package com.yunva.model.system;

import com.yunva.model.Page;

/**
 *
 * <dl>
 * <dt>yunva-admin</dt>
 * <dd>Description:　系统用户model</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年8月3日</dd>
 * </dl>
 * @author 张志
 */
public class User {
	private Integer  userId;		//用户id

	private String userName;	//用户名

	private String password; 	//密码

	private String name;		//姓名

	private String roleId;		//角色id

	private String status;		//用户状态  1 正常  2 失效

	private Role role;			//角色对象

	private Page page;			//分页对象

	private String skin;		//皮肤

	private Integer userType; //用户类型  1 内部用户

	private String remark ; //备注

	public String getRemark()
	{
		return remark;
	}
	public void setRemark(String remark)
	{
		this.remark = remark;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("User{");
		sb.append("userId=").append(userId);
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", password='").append(password).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", role_id='").append(roleId).append('\'');
		sb.append(", status='").append(status).append('\'');
		sb.append(", role=").append(role);
		sb.append(", page=").append(page);
		sb.append(", skin='").append(skin).append('\'');
		sb.append(", userType=").append(userType);
		sb.append('}');
		return sb.toString();
	}
}
