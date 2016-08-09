package com.yunva.service;

import com.yunva.model.Page;
import com.yunva.model.system.User;
import com.yunva.util.PageData;

import java.util.List;

/**
 * <dl>
 * <dt>yunva-new-admin</dt>
 * <dd>Description:用户服务接口</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016/8/5</dd>
 * </dl>
 *
 * @author 张志
 */
public interface UserService   {

	public PageData findByUiId(PageData pd);

	public PageData findByUId(PageData pd);


	/*
	* 通过邮箱获取数据
	*/
	public PageData findByUE(PageData pd);

	/*
	* 通过编号获取数据
	*/
	public PageData findByUN(PageData pd);

	
	/*
	* 保存用户
	*/
	public void saveU(PageData pd);


	/*
	* 修改用户
	*/
	public void editUser(PageData pd);


	/*
	* 换皮肤
	*/
	public void setSKIN(PageData pd)throws Exception;


	/*
	* 删除用户
	*/
	public void deleteUser(PageData pd);


	/*
	* 批量删除用户
	*/
	public void deleteAllU(String[] USER_IDS);



	/*
	*用户列表
	*/
	public List<PageData> listPdPageUser(Page page);


	/*
	*用户列表(全部)
	*/
	public List<PageData> listAllUser(PageData pd);


	/*
	*用户列表(供应商用户)
	*/
	public List<PageData> listGPdPageUser(Page page);




	/*
	* 登录判断
	*/
	public PageData getUserByNameAndPwd(PageData pd);


	/*
	*通过id获取数据
	*/
	public User getUserAndRoleById(String userId);

	
}
