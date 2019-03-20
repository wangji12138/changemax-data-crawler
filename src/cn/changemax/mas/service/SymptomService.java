package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Symptom;
import cn.changemax.mas.po.SymptomExample;
import cn.changemax.mas.po.SymptomWithBLOBs;

/**
 * <p>
 * Title: SymptomService.java
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
public interface SymptomService {

	int getCount(SymptomExample example) throws Exception;

	Symptom selectByPrimaryKey(String symptomId) throws Exception;

	List<SymptomWithBLOBs> selectSymptomWithBLOBsSearchInfo(Symptom symptom, PageModel pageModel) throws Exception;

}
