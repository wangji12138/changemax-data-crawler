package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.ChangeMax;
import cn.changemax.mas.po.ChangeMaxExample;

/**
 * <p>
 * Title: ChangeMaxService.java
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
public interface ChangeMaxService {

	ChangeMax selectChangeMaxByUserId(String userId) throws Exception;

	ChangeMax selectByPrimaryKey(Integer changeMaxId) throws Exception;

	int getCount(ChangeMaxExample example) throws Exception;

	List<ChangeMax> selectChangeMaxSearchInfo(ChangeMax changeMax, PageModel pageModel) throws Exception;

}
