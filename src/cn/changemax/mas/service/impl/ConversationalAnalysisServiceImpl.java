package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.exception.AnalysisException;
import cn.changemax.mas.exception.QuestionException;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.QaRequest;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.po.Question;
import cn.changemax.mas.po.Text;
import cn.changemax.mas.service.BdzdQaService;
import cn.changemax.mas.service.ConversationalAnalysisService;
import cn.changemax.mas.service.EncyclopediaService;
import cn.changemax.mas.service.MedicalDatabaseService;
import cn.changemax.mas.service.MedicalQaService;
import cn.changemax.mas.service.MedicalVideoService;
import cn.changemax.mas.service.QaAiService;
import cn.changemax.mas.utils.ListUtils;
import cn.changemax.mas.utils.StringUtils;

/**
 * <p>
 * Title: AnalysisServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月3日
 * @version 1.0
 */
public class ConversationalAnalysisServiceImpl implements ConversationalAnalysisService {

	@Autowired
	private EncyclopediaService encyclopediaService;

	@Autowired
	private MedicalQaService medicalQaService;

	@Autowired
	private MedicalDatabaseService medicalDatabaseService;

	@Autowired
	private BdzdQaService bdzdQuestionAnswerService;

	@Autowired
	private MedicalVideoService medicalVideoService;

	@Autowired
	private QaAiService qaAiService;

	// 所有分析
	//private String[] methodTypeArray = { "ea", "mda", "mqaa", "mva", "iqaa", "caia" };
	private String[] methodTypeArray = { "ea", "mda", "mqaa", "mva", "iqaa"};

	@Override
	public void analysisQaByQuestion(Question question) throws Exception {
		if (question == null) {
			throw new AnalysisException(ConversationalAnalysisServiceImpl.class + "--" + "analysisQaByQuestion" + "--"
					+ "question" + "：参数不正确");
		}
		String questionId = question.getQuestionId();
		String searchQuestion = question.getQuestionTitle();
		List<String> splitWordList = question.getSplitWordList();
		List<String> keywordList = question.getKeywordList();

		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(searchQuestion) || ListUtils.isEmpty(splitWordList)
				|| ListUtils.isEmpty(keywordList)) {
			throw new AnalysisException(
					ConversationalAnalysisServiceImpl.class + "--" + "analysisQaByQuestion" + "：参数不正确");
		}

		// 获取所由分析结果集
		Map<String, List<Answer>> answerListMap = analysisAllMethod(questionId, searchQuestion, splitWordList,
				keywordList);
//		Map<String, List<Answer>> answerListMap = analysisAllMethod2(questionId, searchQuestion, splitWordList, keywordList);

		// 百科性分析
		List<Answer> eaAnswerList = answerListMap.get("ea");

		// 医疗数据库分析
		List<Answer> mdaAnswerList = answerListMap.get("mda");

		// 数据库qa性分析
		List<Answer> mqaaAnswerList = answerListMap.get("mqaa");

		// 视频性分析
		List<Answer> mvaAnswerList = answerListMap.get("mva");

		// 互联网问答性分析
		List<Answer> iqaaAnswerList = answerListMap.get("iqaa");

		// 第三方智能api分析
		List<Answer> caiaAnswerList = answerListMap.get("caia");

		if (ListUtils.isNotEmpty(eaAnswerList)) {
			question.setAnswerList(eaAnswerList);
		} else if (ListUtils.isNotEmpty(mdaAnswerList)) {
			question.setAnswerList(mdaAnswerList);
		} else if (ListUtils.isNotEmpty(mqaaAnswerList)) {
			question.setAnswerList(mqaaAnswerList);
		} else if (ListUtils.isNotEmpty(mvaAnswerList)) {
			question.setAnswerList(mvaAnswerList);
		} else if (ListUtils.isNotEmpty(iqaaAnswerList)) {
			question.setAnswerList(iqaaAnswerList);
		} else if (ListUtils.isNotEmpty(caiaAnswerList)) {
			question.setAnswerList(caiaAnswerList);
		}
	}

	@Override
	public void analysisAllQaByQuestion(Question newQuestion) throws Exception {
		String questionId = newQuestion.getQuestionId();
		String searchQuestion = newQuestion.getQuestionTitle();
		List<String> splitWordList = newQuestion.getSplitWordList();
		List<String> keywordList = newQuestion.getKeywordList();

		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(searchQuestion) || ListUtils.isEmpty(splitWordList)
				|| ListUtils.isEmpty(keywordList)) {
			throw new AnalysisException(
					ConversationalAnalysisServiceImpl.class + "--" + "analysisAllQaByQuestion" + "：参数不正确");
		}

		Map<String, List<Answer>> answerListMap = analysisAllMethod(questionId, searchQuestion, splitWordList,
				keywordList);
//		Map<String, List<Answer>> answerListMap = analysisAllMethod2(questionId, searchQuestion, splitWordList, keywordList);

		List<Answer> allAnswerList = new ArrayList<Answer>();
		for (Map.Entry<String, List<Answer>> entry : answerListMap.entrySet()) {
			if (entry != null && ListUtils.isNotEmpty(entry.getValue()) && !entry.getKey().equals("caia")) {
				allAnswerList.addAll(entry.getValue());
			}
		}

		newQuestion.setAnswerList(allAnswerList);
		if (ListUtils.isNotEmpty(allAnswerList)) {
			newQuestion.setAnswerNumber(allAnswerList.size());
		}
	}

	@Override
	public Map<String, List<Answer>> analysisAllMethod(String questionId, String question, List<String> splitWordList,
			List<String> keywordList) throws Exception {

		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(question) || ListUtils.isEmpty(splitWordList)
				|| ListUtils.isEmpty(keywordList)) {
			throw new QuestionException("question预处理错误！");
		}
		System.err.println("进入analysisAllMethod");

		/*
		 * 分析过程： 通过开启线程分析，提高分析效率，暂时使用顺序分析
		 */
		// 开启线程池
		// 根据map1的大小来确定核心线程池的大小
		// 设置核心池大小
		ExecutorService analysisExecutorService = Executors.newFixedThreadPool(methodTypeArray.length);

		// 创建线程对象
		Map<String, Future<List<Answer>>> analysisFutureMap = new HashMap<String, Future<List<Answer>>>();

		// 开启所有分析方法线程 // 给每个线程分配任务
		final long start = System.currentTimeMillis();
		for (String methodType : methodTypeArray) {
			Future<List<Answer>> future = analysisExecutorService
					.submit(new AnalysisCallable(methodType, questionId, question, splitWordList, keywordList));
			analysisFutureMap.put(methodType, future);
		}

		// 3、结束线程池
		analysisExecutorService.shutdown();// 不允许再想线程池中增加线程

		Map<String, List<Answer>> answerListMap = new HashMap<String, List<Answer>>();

		while (true) {
			if (analysisExecutorService.isTerminated()) {
				// 拼接线程的返回值
				for (Map.Entry<String, Future<List<Answer>>> entry : analysisFutureMap.entrySet()) {
					String key = entry.getKey();
					if (entry.getValue() != null && ListUtils.isNotEmpty(entry.getValue().get())) {
						answerListMap.put(key, entry.getValue().get());
					}
				}
				break;
			}
		}
		final long end = System.currentTimeMillis();
		System.err.println("耗时：" + ((end - start) / 1000));

		for (List<Answer> answerList : answerListMap.values()) {
			if (ListUtils.isNotEmpty(answerList)) {
				System.err.println("____________________上____________________");
				if (ListUtils.isNotEmpty(answerList)) {
					for (Answer answer : answerList) {
						if (answer != null) {
							System.err.println(answer.toString());
						}
					}
				}
				System.err.println("____________________下____________________");

			}
		}

		return answerListMap;
	}

	@Override
	public Map<String, List<Answer>> analysisAllMethod2(String questionId, String question, List<String> splitWordList,
			List<String> keywordList) throws Exception {

		if (StringUtils.isEmpty(questionId) || StringUtils.isEmpty(question) || ListUtils.isEmpty(splitWordList)
				|| ListUtils.isEmpty(keywordList)) {
			throw new QuestionException("question预处理错误！");
		}
		System.err.println("进入analysisAllMethod2");

		Map<String, List<Answer>> answerListMap = new HashMap<String, List<Answer>>();
		final long start = System.currentTimeMillis();
		for (String methodType : methodTypeArray) {
			List<Answer> answerList = analysisMethod(methodType, questionId, question, splitWordList, keywordList);
			if (ListUtils.isNotEmpty(answerList)) {
				answerListMap.put(methodType, answerList);
			}
		}
		final long end = System.currentTimeMillis();
		System.err.println("耗时：" + ((end - start) / 1000));
		for (List<Answer> answerList : answerListMap.values()) {
			if (ListUtils.isNotEmpty(answerList)) {
				System.err.println("____________________上____________________");
				if (ListUtils.isNotEmpty(answerList)) {
					for (Answer answer : answerList) {
						if (answer != null) {
							System.err.println(answer.toString());
						}
					}
				}
				System.err.println("____________________下____________________");

			}
		}

		return answerListMap;
	}

	@Override
	public boolean conversationalAnalysisPortal(QaResponse newQaResponse, QaRequest qaRequest) throws Exception {
		return false;
	}

	@Override
	public boolean complexityAnalysis(QaResponse newQaResponse, QaRequest qaRequest) {
		return false;
	}

	@Override
	public boolean simpleSentenceAnalysis(QaResponse newQaResponse, Text userText) {
		return false;
	}

	public class AnalysisCallable implements Callable<List<Answer>> {
		private String methodType;
		private String questionId;
		private String analysisType;
		private String textContent;
		private List<String> splitWordList;
		private List<String> keywordList;

		public AnalysisCallable(String methodType, String questionId, String textContent, List<String> splitWordList,
				List<String> keywordList) {
			this.methodType = methodType;

			this.questionId = questionId;
			this.textContent = textContent;
			this.splitWordList = splitWordList;
			this.keywordList = keywordList;

		}

		@Override
		public List<Answer> call() {
			analysisType = methodType.toUpperCase();
			switch (methodType) {
			case "ea":
				try {
					// 百科性分析模型
					return encyclopediaService.getBestEncyclopediaList(questionId, analysisType, textContent,
							splitWordList, keywordList);
				} catch (Exception e) {
					System.err.println("getBestEncyclopediaList：" + e.getMessage());
				}
			case "mda":
				try {
					// 医疗数据库分析
					return medicalDatabaseService.getBestMedicalDataList(questionId, analysisType, textContent,
							splitWordList, keywordList);
				} catch (Exception e) {
					System.err.println("getBestMedicalDataList：" + e.getMessage());
				}
			case "mqaa":
				try {
					// 医疗问答分析模型
					return medicalQaService.getBestMedicalQaList(questionId, analysisType, textContent, splitWordList,
							keywordList);
				} catch (Exception e) {
					System.err.println("getBestMedicalAnswerList：" + e.getMessage());
				}
			case "mva":
				try {
					// 本地疾病视频源数据分析模型
					return medicalVideoService.getBestMedicalVideo(questionId, analysisType, textContent, splitWordList,
							keywordList);
				} catch (Exception e) {
					System.err.println("getBestMedicalVideo：" + e.getMessage());
				}
			case "iqaa":
				try {
					// 互联网问答数据分析模型
					return bdzdQuestionAnswerService.getBestInternetAnswerList(questionId, analysisType, textContent,
							splitWordList, keywordList);
				} catch (Exception e) {
					System.err.println("getBestInternetAnswerList：" + e.getMessage());
				}
			case "caia":
				try {
					// 第三方智能数据分析模型
					Answer answer = qaAiService.sendMsg(questionId, analysisType, textContent);
					List<Answer> answerList = new ArrayList<Answer>();
					answerList.add(answer);
					return answerList;
				} catch (Exception e) {
					System.err.println("sendMsg：" + e.getMessage());
				}
			default:
				return null;
			}

		}

	}

	@Override
	public List<Answer> analysisMethod(String methodType, String questionId, String textContent,
			List<String> splitWordList, List<String> keywordList) {
		String analysisType = methodType.toUpperCase();
		switch (methodType) {
		case "ea":
			try {
				return encyclopediaService.getBestEncyclopediaList(questionId, analysisType, textContent, splitWordList,
						keywordList);
			} catch (Exception e) {
				System.err.println("getBestEncyclopediaList：" + e.getMessage());
			}
		case "mda":
			try {
				return medicalDatabaseService.getBestMedicalDataList(questionId, analysisType, textContent,
						splitWordList, keywordList);
			} catch (Exception e) {
				System.err.println("getBestMedicalDataList：" + e.getMessage());
			}
		case "mqaa":
			try {
				return medicalQaService.getBestMedicalQaList(questionId, analysisType, textContent, splitWordList,
						keywordList);
			} catch (Exception e) {
				System.err.println("getBestMedicalAnswerList：" + e.getMessage());
			}
		case "mva":
			try {
				return medicalVideoService.getBestMedicalVideo(questionId, analysisType, textContent, splitWordList,
						keywordList);
			} catch (Exception e) {
				System.err.println("getBestMedicalVideo：" + e.getMessage());
			}
		case "iqaa":
			try {
				return bdzdQuestionAnswerService.getBestInternetAnswerList(questionId, analysisType, textContent,
						splitWordList, keywordList);
			} catch (Exception e) {
				System.err.println("getBestInternetAnswerList：" + e.getMessage());
			}
		case "caia":
			try {
				Answer answer = qaAiService.sendMsg(questionId, analysisType, textContent);
				List<Answer> answerList = new ArrayList<Answer>();
				answerList.add(answer);
				return answerList;
			} catch (Exception e) {
				System.err.println("sendMsg：" + e.getMessage());
			}
		default:
			return null;
		}

	}

}
