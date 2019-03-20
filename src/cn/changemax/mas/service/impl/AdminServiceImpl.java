package cn.changemax.mas.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.changemax.mas.mapper.AdminMapper;
import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Admin;
import cn.changemax.mas.po.AdminExample;
import cn.changemax.mas.service.AdminService;
import cn.changemax.mas.utils.ListUtils;

/**
 * <p>
 * Title: AdminServiceImpl.java
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
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public Admin selectAdminByUsernameAndPassword(String adminUsername, String adminPassword) throws Exception {
		AdminExample example = new AdminExample();
		example.createCriteria().andAdminUsernameEqualTo(adminUsername).andAdminPasswordEqualTo(adminPassword);
		List<Admin> adminList = adminMapper.selectByExample(example);
		if (ListUtils.isNotEmpty(adminList)) {
			return adminList.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Admin> selectAdminSearchInfo(Admin admin, PageModel pageModel) throws Exception {
		/** 当前需要分页的总数据条数  */
		AdminExample example = new AdminExample();

		int recordCount = getCount(example);
		pageModel.setRecordCount(recordCount);

		if (recordCount > 0) {
			example.setStartRow(pageModel.getFirstLimitParam());
			example.setPageSize(pageModel.getPageSize());

			return adminMapper.selectByExample(example);
		} else {
			return new ArrayList<Admin>();
		}
	}

	@Override
	public int getCount(AdminExample example) throws Exception {
		return adminMapper.countByExample(example);
	}

	@Override
	public Admin selectAdminByAdminId(Integer adminId) throws Exception {
		return adminMapper.selectByPrimaryKey(adminId);
	}

}
