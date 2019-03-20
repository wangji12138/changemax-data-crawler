package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Part;
import cn.changemax.mas.po.PartExample;

/**
 * <p>
 * Title: PartService.java
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
public interface PartService {
	int getCount(PartExample example) throws Exception;

	List<Part> selectPartSearchInfo(Part part, PageModel pageModel) throws Exception;

	Part selectPartById(Integer partId) throws Exception;

}
