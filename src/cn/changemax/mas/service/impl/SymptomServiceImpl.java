package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.mapper.SymptomMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Symptom;
import cn.changemax.mas.po.SymptomExample;
import cn.changemax.mas.po.SymptomWithBLOBs;
import cn.changemax.mas.service.SymptomService;

/**
 * <p>
 * Title: SymptomServiceImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: www.changemax.com
 * </p>
 * 
 * @author WangJi
 * @date 2018年12月11日
 * @version 1.0
 */
public class SymptomServiceImpl implements SymptomService {
	@Autowired
	private SymptomMapper symptomMapper;

	@Override
	public List<SymptomWithBLOBs> selectSymptomWithBLOBsSearchInfo(Symptom symptom, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		SymptomExample example = new SymptomExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return symptomMapper.selectByExampleWithBLOBs(example);
		} else {
			return new ArrayList<SymptomWithBLOBs>();
		}
	}

	@Override
	public int getCount(SymptomExample example) throws Exception {
		return symptomMapper.countByExample(example);
	}

	@Override
	public Symptom selectByPrimaryKey(String symptomId) throws Exception {
		return symptomMapper.selectByPrimaryKey(symptomId);
	}

}
