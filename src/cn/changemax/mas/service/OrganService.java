package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Organ;
import cn.changemax.mas.po.OrganExample;

/**
 * <p>
 * Title: OrganService.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月26日
 * @version 1.0
 */
public interface OrganService {

	Organ selectByPrimaryKey(Integer organId) throws Exception;

	int getCount(OrganExample example) throws Exception;

	List<Organ> selectOrganSearchInfo(Organ organ, PageModel pageModel) throws Exception;

	List<Organ> selectOrganListByPartId(Integer partId) throws Exception;

}
