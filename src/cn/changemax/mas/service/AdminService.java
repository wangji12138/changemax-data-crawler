package cn.changemax.mas.service;

import java.util.List;

import cn.changemax.mas.model.PageModel;
import cn.changemax.mas.po.Admin;
import cn.changemax.mas.po.AdminExample;
 
/**
 * <p>
 * Title: AdminService.java
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
public interface AdminService {

	Admin selectAdminByUsernameAndPassword(String adminUsername, String adminPassword) throws Exception;

	List<Admin> selectAdminSearchInfo(Admin admin, PageModel pageModel) throws Exception;

	int getCount(AdminExample example) throws Exception;

	Admin selectAdminByAdminId(Integer adminId) throws Exception;

}
