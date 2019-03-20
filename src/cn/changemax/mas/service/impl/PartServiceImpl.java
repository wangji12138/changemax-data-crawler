package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.mapper.PartMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Part;
import cn.changemax.mas.po.PartExample;
import cn.changemax.mas.service.OrganService;
import cn.changemax.mas.service.PartService;

/**
 * <p>
 * Title: PartServiceImpl.java
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
public class PartServiceImpl implements PartService {
	@Autowired
	private PartMapper partMapper;
	
	@Autowired
	private OrganService organService;

	@Override
	public List<Part> selectPartSearchInfo(Part part, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		PartExample example = new PartExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return partMapper.selectByExample(example);
		} else {
			return new ArrayList<Part>();
		}
	}

	@Override
	public int getCount(PartExample example) throws Exception {
		return partMapper.countByExample(example);
	}

	@Override
	public Part selectPartById(Integer partId) throws Exception {
		Part part = partMapper.selectByPrimaryKey(partId);
		
		if (part!=null) {
			part.setOrganList(organService.selectOrganListByPartId(partId));
		}

		return part;
	}
}
