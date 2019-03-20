package cn.changemax.mas.service;

import java.util.List;

import com.hankcs.hanlp.seg.common.Term;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.QaResponse;
import cn.changemax.mas.po.Text;
import cn.changemax.mas.po.TextExample;

/**
 * <p>
 * Title: TextService.java
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
public interface TextService {

	void insertText(Text text) throws Exception;

	Text generateText(String textId, String textContent, String talkingContent, boolean isChangemaxSpeak,
			String speakId) throws Exception;

	void addNewText(QaResponse newQaResponse, String responseTextContent, String analysisType) throws Exception;

	Text selectByPrimaryKey(Integer id) throws Exception;

	int getCount(TextExample example) throws Exception;

	List<Text> selectTextSearchInfo(Text text, PageModel pageModel) throws Exception;

	List<Term> segmentText(String preanalysisText) throws Exception;

	String convertToSimplifiedChinese(String traditionalChineseString) throws Exception;

	String convertToTraditionalChinese(String simplifiedChineseString) throws Exception;

	String convertToPinyinString(String text, String separator, boolean remainNone) throws Exception;

}
