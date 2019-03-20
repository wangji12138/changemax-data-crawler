package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import cn.changemax.mas.mapper.TextMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.po.Text;
import cn.changemax.mas.po.TextExample;
import cn.changemax.mas.service.TextService;
import cn.changemax.mas.utils.WordUtils;

/**
 * <p>
 * Title: TextServiceImpl.java
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
public class TextServiceImpl implements TextService {

	@Autowired
	private TextMapper textMapper;

	@Override
	public void insertText(Text text) throws Exception {
		new Thread(new Runnable() {

			@Override
			public void run() {
				textMapper.insert(text);
			}
		}).start();
	}

	@Override
	public void addNewText(QaResponse newQaResponse, String responseTextContent, String analysisType) throws Exception {

		List<Text> qaResponseTextList = newQaResponse.getQaResponseTextList();
		List<String> analysisTypeList = newQaResponse.getAnalysisTypeList();

		Text newText = null;

		String textId = "";// 话id //请求id------------组成：系统毫秒+“-”+32位uuid,可重复
		responseTextContent = organizationalDisplayLanguage(responseTextContent, analysisType);// 话内容
		boolean isChangemaxSpeak = true;// 是否为changemax说话
		String speakerId = "";// 说话者id
		String talkingContent = organizationalVoiceLanguage(responseTextContent, analysisType);// 语音内容

		if (qaResponseTextList != null && analysisTypeList != null) {// 反馈对话集不为空，分析类型不为空
			Text oldText = newQaResponse.getQaResponseTextList().get(0);
			textId = oldText.getTextId();
			speakerId = oldText.getSpeakerId();

			newText = generateText(textId, responseTextContent, talkingContent, isChangemaxSpeak, speakerId);
			newQaResponse.getQaResponseTextList().add(newText);
			newQaResponse.getAnalysisTypeList().add(analysisType);
		} else {// 反馈对话集为空，分析类型为空
			newQaResponse.setQaResponseTextList(new ArrayList<Text>());// 新建反馈集
			newQaResponse.setAnalysisTypeList(new ArrayList<String>());// 新建类型集

			textId = (System.currentTimeMillis()) + "-" + (UUID.randomUUID().toString().replaceAll("-", ""));
			speakerId = newQaResponse.getQaResponseChangeMaxId();
			newText = generateText(textId, responseTextContent, talkingContent, isChangemaxSpeak, speakerId);

			newQaResponse.getQaResponseTextList().add(newText);
			newQaResponse.getAnalysisTypeList().add(analysisType);
			newQaResponse.setTextId(textId);

		}

		// 加入newText
	}

	@Override
	public Text generateText(String textId, String textContent, String talkingContent, boolean isChangeMaxSpeak,
			String speakerId) throws Exception {
		Text newText = new Text(textId, textContent, WordUtils.getSplitWords(textContent),
				WordUtils.getKeywordWords(textContent), talkingContent, isChangeMaxSpeak, speakerId);

		insertText(newText);

		return newText;
	}

	/**
	 * 
	 * <p>
	 * Title: organizationalDisplayLanguage
	 * </p>
	 * <p>
	 * Description:生成显示语言
	 * </p>
	 * 
	 * @param wordString
	 * @param type
	 * @return
	 * @throws Exception
	 */
	private String organizationalDisplayLanguage(String wordString, String type) throws Exception {
		String textContent = "";
		switch (type) {
		case "FA":
			textContent = "点击就可以打开：***" + wordString + "***了哦";
			break;
		case "QAA":
			textContent = wordString;
			break;
		case "IQAA":
			textContent = wordString;
			break;
		case "VA":
			textContent = wordString;
			break;
		default:
			textContent = wordString;
			break;
		}

		return textContent;

	}

	/**
	 * 
	 * <p>
	 * Title: organizationalVoiceLanguage
	 * </p>
	 * <p>
	 * Description: 生成语音语言
	 * </p>
	 * 
	 * @param wordString
	 * @param type
	 * @return
	 * @throws Exception
	 */
	private String organizationalVoiceLanguage(String wordString, String type) throws Exception {
		String talkingContent = "";
		switch (type) {
		case "FA":
			talkingContent = "点击就可以打开：" + wordString + "了哦";
			break;

		default:
			break;
		}

		return talkingContent;

	}

	@Override
	public List<Text> selectTextSearchInfo(Text text, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		TextExample example = new TextExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return textMapper.selectByExample(example);
		} else {
			return new ArrayList<Text>();
		}
	}

	@Override
	public int getCount(TextExample example) throws Exception {
		return textMapper.countByExample(example);
	}

	@Override
	public Text selectByPrimaryKey(Integer id) throws Exception {
		return textMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Term> segmentText(String preanalysisText) throws Exception {
		return HanLP.segment(preanalysisText);
	}

	/**
	 * 繁转简
	 *
	 * @param traditionalChineseString 繁体中文
	 * @return 简体中文
	 */
	@Override
	public String convertToSimplifiedChinese(String traditionalChineseString) throws Exception {
		return HanLP.convertToSimplifiedChinese(traditionalChineseString);
	}

	/**
	 * 简转繁
	 *
	 * @param simplifiedChineseString 简体中文
	 * @return 繁体中文
	 */
	@Override
	public String convertToTraditionalChinese(String simplifiedChineseString) throws Exception {
		return HanLP.convertToTraditionalChinese(simplifiedChineseString);
	}

	/**
	 * 转化为拼音
	 *
	 * @param text       文本
	 * @param separator  分隔符
	 * @param remainNone 有些字没有拼音（如标点），是否保留它们的拼音（true用none表示，false用原字符表示）
	 * @return 一个字符串，由[拼音][分隔符][拼音]构成
	 */
	@Override
	public String convertToPinyinString(String text, String separator, boolean remainNone) throws Exception {
		return HanLP.convertToPinyinString(text, " ", false);
	}

}
