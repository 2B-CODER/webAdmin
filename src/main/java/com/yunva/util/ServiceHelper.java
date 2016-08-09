package com.yunva.util;

import com.yunva.dao.system.menu.MenuDao;
import com.yunva.dao.system.role.RoleDao;
import com.yunva.dao.system.user.UserDao;



/**
 * @author Administrator
 * 获取Spring容器中的service bean
 */
public final class ServiceHelper {
	
	public static Object getService(String serviceName){
		//WebApplicationContextUtils.
		return Const.WEB_APP_CONTEXT.getBean(serviceName);
	}
	
	public static UserDao getUserService(){
		return (UserDao) getService("userService");
	}
	
	public static RoleDao getRoleService(){
		return (RoleDao) getService("roleService");
	}
	
	public static MenuDao getMenuService(){
		return (MenuDao) getService("menuService");
	}
}
