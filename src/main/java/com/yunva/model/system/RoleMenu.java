package com.yunva.model.system;
/**
 *
 * <dl>
 * <dt>yunva-admin</dt>
 * <dd>Description:角色权限中间model</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年8月3日</dd>
 * </dl>
 * @author 张志
 */
public class RoleMenu {

	private Integer roleId; //角色id

	private Integer menuId; //菜单Id

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("RoleMenu{");
		sb.append("roleId=").append(roleId);
		sb.append(", menuId=").append(menuId);
		sb.append('}');
		return sb.toString();
	}
}
