package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.mapper.QaCategoryMapper;
import cn.changemax.mas.po.QaCategory;
import cn.changemax.mas.po.QaCategoryExample;
import cn.changemax.mas.service.QaCategoryService;
import cn.changemax.mas.service.QuestionService;
import cn.changemax.mas.utils.ListUtils;

/**
 * <p>
 * Title: QaCategoryServiceImpl.java
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
public class QaCategoryServiceImpl implements QaCategoryService {

	@Autowired
	private QaCategoryMapper qaCategoryMapper;

	@Autowired
	private QuestionService questionService;

	@Override
	public Integer insertQaCategory(String name, String introduction) throws Exception {
		Integer result = 0;

		QaCategoryExample example = new QaCategoryExample();
		example.createCriteria().andNameEqualTo(name).andIntroductionEqualTo(introduction);
		List<QaCategory> qaCategoryList = qaCategoryMapper.selectByExample(example);

		if (ListUtils.isEmpty(qaCategoryList)) {
			QaCategory qaCategory = new QaCategory();
			qaCategory.setName(name);
			qaCategory.setIntroduction(introduction);
			result = qaCategoryMapper.insert(qaCategory);
		}

		return result;

	}

	@Override
	public Integer deleteQaCategory(Integer id) throws Exception {
		return qaCategoryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public QaCategory selectById(Integer id) throws Exception {
		id = (id != null && id > 0) ? id : 1;

		QaCategory qaCategory = null;
		if (id != null && id > 0) {
			QaCategoryExample example = new QaCategoryExample();
			example.createCriteria().andIdEqualTo(id);
			List<QaCategory> qaCategoryList = qaCategoryMapper.selectByExample(example);
			if (ListUtils.isNotEmpty(qaCategoryList)) {
				if (qaCategoryList.size() > 1) {
					// 错误！
				}
				qaCategory = qaCategoryList.get(0);
			}
		}
		return qaCategory;
	}

	@Override
	public List<QaCategory> selectMaxQuestionNumberQaCategory(Integer qaCategoryId, Integer number) throws Exception {
		number = (number != null && number > 0) ? number : 5;
		List<QaCategory> qaCategoryList = null;

		Map<Object, Long> maxNumberQaCategoryMap = questionService.selectMaxQuestionNumberQaCategory(qaCategoryId,
				number);

		if (maxNumberQaCategoryMap != null && maxNumberQaCategoryMap.size() > 0) {
			qaCategoryList = new ArrayList<QaCategory>();
			for (Entry<Object, Long> entry : maxNumberQaCategoryMap.entrySet()) {
				Object entryQaCategoryId = entry.getKey();
				if (qaCategoryId != null) {
					Long entryNumber = entry.getValue();
					QaCategory qaCategory = qaCategoryMapper
							.selectByPrimaryKey(Integer.valueOf(entryQaCategoryId.toString()));
					if (qaCategory != null) {
						qaCategory.setQuestionNumber(entryNumber.intValue());
						qaCategoryList.add(qaCategory);
					}
				}
			}
		}

		return qaCategoryList;
	}

	@Override
	public List<QaCategory> selectAllQaCategory() throws Exception {
		return selectMaxQuestionNumberQaCategory(-1, -1);

	}

}
