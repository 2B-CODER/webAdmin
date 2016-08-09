package com.yunva.service.impl;

import com.yunva.dao.system.menu.MenuDao;
import com.yunva.model.system.Menu;
import com.yunva.service.MenuService;
import com.yunva.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <dl>
 * <dt>yunva-new-admin</dt>
 * <dd>Description:菜单服务接口实现类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016/8/6</dd>
 * </dl>
 *
 * @author 张志
 */
@Service
public class MenuServiceImpl implements MenuService
{

 @Autowired
 private MenuDao menuDao;

    @Override
    public void deleteMenuById(String menuId)
    {
        menuDao.deleteMenuById(menuId);
    }

    @Override
    public PageData getMenuById(PageData pd) {
        return menuDao.getMenuById(pd);
    }

    @Override
    public PageData findMaxId(PageData pd) {
        return menuDao.findMaxId(pd);
    }

    @Override
    public List<Menu> listAllParentMenu() {
        return menuDao.listAllParentMenu();
    }

    @Override
    public List<Menu> listAllUserParentMenu(Integer roleId) {
        return menuDao.listAllUserParentMenu(roleId);
    }

    @Override
    public void saveMenu(Menu menu) {

        menuDao.saveMenu(menu);
    }

    @Override
    public List<Menu> listSubMenuByParentId(Integer parentId) {
        return menuDao.listSubMenuByParentId(parentId);
    }

    @Override
    public List<Integer> getMenuIds(Integer parentId) {
        return menuDao.getMenuIds(parentId);
    }

    @Override
    public List<Menu> listSubUserMenuByParentId(List<Integer> menuIds, Integer roleId) {
        return menuDao.listSubUserMenuByParentId(menuIds,roleId);
    }


    public List<Menu> listAllMenu()  {
        List<Menu> rl = this.listAllParentMenu();
        for(Menu menu : rl){
            List<Menu> subList = this.listSubMenuByParentId(menu.getMenuId());
            menu.setSubMenu(subList);
        }
        return rl;
    }


    public List<Menu> listAllUserMenu(Integer roleId)  {
        List<Menu> rl = this.listAllUserParentMenu(roleId);
        for(Menu menu : rl){
            List<Integer> menuIds = this.getMenuIds(menu.getMenuId()); //获取子菜单
            if(menuIds != null && menuIds.size() > 0)
            {
                List<Menu> subList = this.listSubUserMenuByParentId(menuIds, roleId);
                menu.setSubMenu(subList);
            }
        }
        return rl;
    }

    /**
     * 获取登录用户的权限菜单
     * @return
     * @
     */
    public List<Menu> listUserMenu()  {
        List<Menu> rl = this.listAllParentMenu();
        for(Menu menu : rl){
            List<Menu> subList = this.listSubMenuByParentId(menu.getMenuId());
            menu.setSubMenu(subList);
        }
        return rl;
    }

    @Override
    public List<Menu> listAllSubMenu() {
        return menuDao.listAllSubMenu();
    }


    @Override
    public void edit(PageData pd) {

        menuDao.edit(pd);
    }

    @Override
    public void editicon(PageData pd) {

        menuDao.editicon(pd);
    }
}