package com.yunva.service.impl;

import com.yunva.dao.system.role.RoleDao;
import com.yunva.model.system.Role;
import com.yunva.model.system.RoleMenu;
import com.yunva.service.RoleService;
import com.yunva.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <dl>
 * <dt>yunva-new-admin</dt>
 * <dd>Description:角色服务接口实现类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016/8/5</dd>
 * </dl>
 *
 * @author 张志
 */

@Service
public class RoleServiceImpl  implements RoleService{


    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> listAllERRoles() {
        return roleDao.listAllERRoles();
    }

    @Override
    public List<Role> listAllRoles() {
        return roleDao.listAllRoles();
    }

    @Override
    public List<PageData> listAllUByRid(PageData pd) {
        return roleDao.listAllUByRid(pd);
    }

    @Override
    public void deleteRoleById(String roleId) {
        roleDao.deleteRoleById(roleId);
    }

    @Override
    public Role getRoleById(String roleId) {
        return roleDao.getRoleById(roleId);
    }

    @Override
    public void add(PageData pd) {
        roleDao.add(pd);
    }

    @Override
    public PageData findObjectById(PageData pd) {
        return roleDao.findObjectById(pd);
    }

    @Override
    public void edit(PageData pd) {

        roleDao.edit(pd);
    }

    @Override
    public List<Integer> getRoleMenuIds(Integer roleId) {
        return roleDao.getRoleMenuIds(roleId);
    }

    @Override
    public void deleteRoleMenu(Integer roleId) {

        roleDao.deleteRoleMenu(roleId);
    }

    @Override
    public void saveRoleMenu(List<RoleMenu> list) {

        roleDao.saveRoleMenu(list);
    }
}