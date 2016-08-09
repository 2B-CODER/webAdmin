package com.yunva.model.system;

import java.util.List;

/**
 *
 * <dl>
 * <dt>yunva-admin</dt>
 * <dd>Description:　菜单model</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年8月3日</dd>
 * </dl>
 * @author 张志
 */
public class Menu
{

	private Integer menuId; //菜单id

	private String menuName; //菜单名称

	private String menuUrl;  //菜单地址

	private Integer parentId;  //父级菜单id

	private String menuOrder; //菜单排序   从小到大排序

	private String menuIcon; //菜单小图标

	private String menuType;  //菜单类型  1 系统菜单  2 业务菜单

	private String target; //目标

	private Menu parentMenu;  //父级菜单

	private List<Menu> subMenu;  //子菜单list

	private boolean hasMenu = false;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}


	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(String menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	public List<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(List<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	public boolean isHasMenu() {
		return hasMenu;
	}

	public void setHasMenu(boolean hasMenu) {
		this.hasMenu = hasMenu;
	}


	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Menu{");
		sb.append("menuId=").append(menuId);
		sb.append(", menuName='").append(menuName).append('\'');
		sb.append(", menuUrl='").append(menuUrl).append('\'');
		sb.append(", parentId='").append(parentId).append('\'');
		sb.append(", menuOrder='").append(menuOrder).append('\'');
		sb.append(", menuIcon='").append(menuIcon).append('\'');
		sb.append(", menuType='").append(menuType).append('\'');
		sb.append(", target='").append(target).append('\'');
		sb.append(", parentMenu=").append(parentMenu);
		sb.append(", subMenu=").append(subMenu);
		sb.append(", hasMenu=").append(hasMenu);
		sb.append('}');
		return sb.toString();
	}
}
