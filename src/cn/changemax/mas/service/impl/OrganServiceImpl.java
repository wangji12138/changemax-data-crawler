package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.mapper.OrganMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Organ;
import cn.changemax.mas.po.OrganExample;
import cn.changemax.mas.service.OrganService;

/**
 * <p>
 * Title: OrganServiceImpl.java
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
public class OrganServiceImpl implements OrganService {
	@Autowired
	private OrganMapper organMapper;

	@Override
	public List<Organ> selectOrganSearchInfo(Organ organ, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		OrganExample example = new OrganExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return organMapper.selectByExample(example);
		} else {
			return new ArrayList<Organ>();
		}
	}

	@Override
	public int getCount(OrganExample example) throws Exception {
		return organMapper.countByExample(example);
	}

	@Override
	public Organ selectByPrimaryKey(Integer organId) throws Exception {
		return organMapper.selectByPrimaryKey(organId);
	}

	@Override
	public List<Organ> selectOrganListByPartId(Integer partId) throws Exception {
		OrganExample example = new OrganExample();
		example.createCriteria().andOrganPartIdEqualTo(partId);
		return organMapper.selectByExample(example);
	}
}
