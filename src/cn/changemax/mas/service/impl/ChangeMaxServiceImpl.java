package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;

import cn.changemax.mas.mapper.ChangeMaxMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.ChangeMax;
import cn.changemax.mas.po.ChangeMaxExample;
import cn.changemax.mas.service.ChangeMaxService;

/**
 * <p>
 * Title: ChangeMaxServiceImpl.java
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
public class ChangeMaxServiceImpl implements ChangeMaxService {
	
	private ChangeMaxMapper changeMaxMapper;

	@Override
	public ChangeMax selectChangeMaxByUserId(String userId) {
		ChangeMax changeMax = new ChangeMax(userId);
		return changeMax;
	}


	@Override
	public List<ChangeMax> selectChangeMaxSearchInfo(ChangeMax changeMax, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		ChangeMaxExample example = new ChangeMaxExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return changeMaxMapper.selectByExample(example);
		} else {
			return new ArrayList<ChangeMax>();
		}
	}

	@Override
	public int getCount(ChangeMaxExample example) throws Exception {
		return changeMaxMapper.countByExample(example);
	}

	@Override
	public ChangeMax selectByPrimaryKey(Integer changeMaxId) throws Exception {
		return changeMaxMapper.selectByPrimaryKey(changeMaxId);
	}
	
	
}
