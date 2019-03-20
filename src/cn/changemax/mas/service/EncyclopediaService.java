package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Answer;
import cn.changemax.mas.po.Encyclopedia;
import cn.changemax.mas.po.EncyclopediaExample;
import cn.changemax.mas.po.EncyclopediaKey;

/**
 * <p>
 * Title: EncyclopediaService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月10日
 * @version 1.0
 */
public interface EncyclopediaService {

	List<Answer> getBestEncyclopediaList(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<Answer> getBestBaiDuEncyclopedia(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<Answer> getBestDatabaseEncyclopedia(String questionId, String analysisType, String textContent,
			List<String> splitWordList, List<String> keywordList) throws Exception;

	List<Encyclopedia> searchEncyclopediaEntries(String keywordString) throws Exception;

	String getEncyclopediaIntro(String baiduEncyclopediaUrl) throws Exception;

	String getEncyclopediaInfor(String baiduEncyclopediaUrl) throws Exception;

	List<Encyclopedia> selectEncyclopediaByLikeName(List<String> keywordList) throws Exception;

	void insertEncyclopedia(Encyclopedia encyclopedia) throws Exception;

	Encyclopedia selectIdiomEncyclopedia(String key, String idiomName) throws Exception;

	List<Encyclopedia> selectEncyclopediaSearchInfo(Encyclopedia encyclopedia, PageModel pageModel) throws Exception;

	int getCount(EncyclopediaExample example) throws Exception;

	Encyclopedia selectEncyclopediaByKey(EncyclopediaKey key) throws Exception;

}
