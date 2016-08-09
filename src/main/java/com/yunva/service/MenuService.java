package com.yunva.service;

import com.yunva.model.system.Menu;
import com.yunva.util.PageData;

import java.util.List;

/**
 * <dl>
 * <dt>yunva-new-admin</dt>
 * <dd>Description:菜单服务接口</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016/8/5</dd>
 * </dl>
 *
 * @author 张志
 */
public interface  MenuService
{

    public void deleteMenuById(String menuId);


    public PageData getMenuById(PageData pd);



    //取最大id
    public PageData findMaxId(PageData pd);

    public List<Menu> listAllParentMenu() ;


    public List<Menu> listAllUserParentMenu(Integer roleId) ;

    public void saveMenu(Menu menu);


    public List<Menu> listSubMenuByParentId(Integer parentId) ;




    /**
     * 获取父级菜单下的子菜单
     * @param parentId
     * @return
     */
    public List<Integer> getMenuIds(Integer parentId);


    public List<Menu> listSubUserMenuByParentId(List<Integer> menuIds,Integer roleId );





    public List<Menu> listAllMenu() ;


    public List<Menu> listAllUserMenu(Integer roleId);

    /**
     * 获取登录用户的权限菜单
     * @return
     * @
     */
    public List<Menu> listUserMenu() ;



    public List<Menu> listAllSubMenu();

    /**
     * 编辑
     */
    public void edit(PageData pd) ;


    /**
     * 保存菜单图标 (顶部菜单)
     */
    public void editicon(PageData pd) ;
}