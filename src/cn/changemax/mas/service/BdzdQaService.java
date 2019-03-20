package cn.changemax.mas.service;

import java.util.List;
import java.util.Map;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.BdzdQa;
import cn.changemax.mas.po.BdzdQaExample;

/**
 * <p>
 * Title: BDZDQa.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月2日
 * @version 1.0
 */
public interface BdzdQaService {
	List<Answer> getBestInternetAnswerList(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<Answer> getAnswerByDatabase(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<Answer> getAnswerByInternet(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<Answer> getOptimalBdzdQaByList(boolean isDatabase, String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList, List<BdzdQa> bdzdQaList) throws Exception;

	int getInternetBDZDAnswerLastPageByKeyword(String textContent) throws Exception;

	void insertBDZDQa(BdzdQa bdzdQa) throws Exception;

	void insertBdzdQaList(List<BdzdQa> bdzdQaList) throws Exception;

	void insertBdzdQaMap(Map<BdzdQa, Double> bdzdQaMap) throws Exception;

	List<BdzdQa> getBDZDQaList(int pageLast, String textContent) throws Exception;

	List<BdzdQa> selectBDZDQaLikeQuestion(List<String> keywordList) throws Exception;

	List<BdzdQa> selectBdzdQaSearchInfo(BdzdQa bdzdQa, PageModel pageModel) throws Exception;

	int getCount(BdzdQaExample example) throws Exception;

	BdzdQa selectBdzdQaByKey(String url) throws Exception;

}
