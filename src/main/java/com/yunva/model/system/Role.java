package com.yunva.model.system;
/**
 *
 * <dl>
 * <dt>yunva-admin</dt>
 * <dd>Description:角色权限</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年8月3日</dd>
 * </dl>
 * @author 张志
 */
public class Role {

	private Integer roleId; //角色id

	private String roleName;  //角色名称

	private String roleDesc ; //角色描述

	private String createTime; //创建时间

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Role{");
		sb.append("roleId=").append(roleId);
		sb.append(", roleName='").append(roleName).append('\'');
		sb.append(", createTime='").append(createTime).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
