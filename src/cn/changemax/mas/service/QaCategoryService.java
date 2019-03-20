package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.po.QaCategory;

/**
 * <p>
 * Title: QaCategoryService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2019年1月17日
 * @version 1.0
 */
public interface QaCategoryService {

	Integer insertQaCategory(String name, String introduction) throws Exception;

	Integer deleteQaCategory(Integer id) throws Exception;

	QaCategory selectById(Integer id) throws Exception;

	List<QaCategory> selectAllQaCategory() throws Exception;

	List<QaCategory> selectMaxQuestionNumberQaCategory(Integer qaCategoryId, Integer number) throws Exception;

}
