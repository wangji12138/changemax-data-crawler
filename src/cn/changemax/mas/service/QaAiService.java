package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.QaAi;
import cn.changemax.mas.po.QaAiExample;
import cn.changemax.mas.po.QaAiKey;

/**
 * <p>
 * Title: QaAiService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月15日
 * @version 1.0
 */
public interface QaAiService {
	public Answer sendMsg(final String questionId, final String analysisType, final String textContent)
			throws Exception;

	void insertQaAi(QaAi qaAi) throws Exception;

	QaAi selectByPrimaryKey(QaAiKey key) throws Exception;

	int getCount(QaAiExample example) throws Exception;

	List<QaAi> selectQaAiSearchInfo(QaAi qaAi, PageModel pageModel) throws Exception;
}
