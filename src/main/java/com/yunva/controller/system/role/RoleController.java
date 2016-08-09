package com.yunva.controller.system.role;

import com.yunva.controller.base.BaseController;
import com.yunva.model.Page;
import com.yunva.model.system.Menu;
import com.yunva.model.system.Role;
import com.yunva.model.system.RoleMenu;
import com.yunva.service.MenuService;
import com.yunva.service.RoleService;
import com.yunva.util.*;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * <dl>
 * <dt>yunva-admin</dt>
 * <dd>Description:角色controller层</dd>
 * <dd>Copyright: Copyright (C) 2013</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016年8月3日</dd>
 * </dl>
 * @author 张志
 */

@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController {
	
	String menuUrl = "role.do"; //菜单地址(权限用)

	@Autowired
	private MenuService menuService;

	@Autowired
	private RoleService roleService;

	/**
	 * 列表
	 */
	@RequestMapping
	public ModelAndView list(Page page)throws Exception{
			ModelAndView mv = this.getModelAndView();
			PageData pd = new PageData();
			pd = this.getPageData();
			List<Role> roleList = roleService.listAllRoles();	//列出所有角色
			pd = roleService.findObjectById(pd);
			mv.addObject("roleList", roleList);
			mv.setViewName("system/role/role_list");
			mv.addObject(Const.SESSION_QX,this.getHC());	//按钮权限
		
		return mv;
	}


	/**
	 * 新增页面
	 */
	@RequestMapping(value="/toAdd")
	public ModelAndView toAdd(Page page){
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			mv.setViewName("system/role/role_add");
			mv.addObject("pd", pd);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}



	/**
	 * 保存新增信息
	 */
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
				roleService.add(pd);
			mv.addObject("msg","success");
		} catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 请求编辑
	 */
	@RequestMapping(value="/toEdit")
	public ModelAndView toEdit(Integer roleId )throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			pd.put("roleId", roleId);
			pd = roleService.findObjectById(pd);
			mv.setViewName("system/role/role_edit");
			mv.addObject("pd", pd);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return mv;
	}
	
	/**
	 * 编辑
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try{
			pd = this.getPageData();

				 roleService.edit(pd);
			mv.addObject("msg","success");
		} catch(Exception e){
			logger.error(e.toString(), e);
			mv.addObject("msg","failed");
		}
		mv.setViewName("save_result");
		return mv;
	}


	/**
	 * 请求角色菜单授权页面
	 */
	@RequestMapping(value="/auth")
	public String auth(@RequestParam String roleId,Model model)throws Exception{
		
		try{
			List<Menu> menuList = menuService.listAllMenu();
			Role role = roleService.getRoleById(roleId);
			List<Integer> roleMenuIds = roleService.getRoleMenuIds(Integer.parseInt(roleId));
			if(null != roleMenuIds && roleMenuIds.size() > 0)  //查询到该角色有对应的权限
			{
				for(Menu menu : menuList)
				{
					List<Menu> subMenuList = menu.getSubMenu();
					for(Menu sub : subMenuList)
					{
						if(roleMenuIds.contains(sub.getMenuId())) //包含菜单设置为true
						{
							sub.setHasMenu(true);
							menu.setHasMenu(true);
						}
					}
				}
			}
			JSONArray arr = JSONArray.fromObject(menuList);
			String json = arr.toString();
			json = json.replaceAll("menuId", "id").replaceAll("menuName", "name").replaceAll("subMenu", "nodes").replaceAll("hasMenu", "checked");
			model.addAttribute("zTreeNodes", json);
			model.addAttribute("roleId", roleId);
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		return "authorization";
	}



	/**
	 * 保存角色菜单权限
	 */
	@RequestMapping(value="/auth/save")
	public void saveAuth(@RequestParam String roleId,@RequestParam String menuIds,PrintWriter out)throws Exception{
		PageData pd = new PageData();
		try{
			Role role = new Role();
			role.setRoleId(Integer.parseInt(roleId));
			roleService.deleteRoleMenu(Integer.parseInt(roleId));
			List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
			if(StringUtils.isNotBlank(menuIds))
			{
				String [] menuId = menuIds.split(",");
				for(String str:menuId)
				{
					RoleMenu roleMenu = new RoleMenu();
					roleMenu.setRoleId(Integer.parseInt(roleId));
					roleMenu.setMenuId(Integer.parseInt(str));
					roleMenuList.add(roleMenu);
				}
			//保存角色权限中间model
			roleService.saveRoleMenu(roleMenuList);
			}
			pd.put("roleId", roleId);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
	}
	
	/**
	 * 保存角色按钮权限
	 */
	@RequestMapping(value="/roleButton/save")
	public void orleButton(@RequestParam String ROLE_ID,@RequestParam String menuIds,@RequestParam String msg,PrintWriter out)throws Exception{
		PageData pd = new PageData();
		pd = this.getPageData();
		try{
				if(null != menuIds && !"".equals(menuIds.trim())){
					BigInteger rights = RightsHelper.sumRights(Tools.str2StrArray(menuIds));
					pd.put("value",rights.toString());
				}else{
					pd.put("value","");
				}
				pd.put("roleId", ROLE_ID);
			out.write("success");
			out.close();
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
	}


	/**
	 * 删除
	 */
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object deleteRole(@RequestParam String ROLE_ID)throws Exception{
		Map<String,String> map = new HashMap<String,String>();
		PageData pd = new PageData();
		String errInfo = "";
		try{
				pd.put("roleId", ROLE_ID);
					List<PageData> userlist = roleService.listAllUByRid(pd);
					roleService.deleteRoleById(ROLE_ID);
					errInfo = "success";
		} catch(Exception e){
			logger.error(e.toString(), e);
		}
		map.put("result", errInfo);
		return AppUtil.returnObject(new PageData(), map);
	}


	/* ===============================权限================================== */
	public Map<String, String> getHC(){
		Subject currentUser = SecurityUtils.getSubject();  //shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>)session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */


}
