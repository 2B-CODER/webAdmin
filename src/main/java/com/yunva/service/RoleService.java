package com.yunva.service;

import com.yunva.model.system.Role;
import com.yunva.model.system.RoleMenu;
import com.yunva.util.PageData;

import java.util.List;

/**
 * <dl>
 * <dt>yunva-new-admin</dt>
 * <dd>Description:权限服务接口</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016/8/5</dd>
 * </dl>
 *
 * @author 张志
 */
public interface RoleService {



    public List<Role> listAllERRoles();


    public List<Role> listAllRoles();



    //列出此角色下的所有用户
    public List<PageData> listAllUByRid(PageData pd);



    public void deleteRoleById(String roleId);



    public Role getRoleById(String roleId);


    /**
     * 添加
     */
    public void add(PageData pd);

    /**
     * 通过id查找
     */
    public PageData findObjectById(PageData pd);


    /**
     * 编辑角色
     */
    public void edit(PageData pd);



    public List<Integer> getRoleMenuIds(Integer roleId);



    /**
     * 删除角色权限中间表
     * @param roleId
     * @throws Exception
     */
    public void deleteRoleMenu(Integer roleId);




    /**
     * 保存角色权限中间表
     * @param list
     */
    public void saveRoleMenu(List<RoleMenu> list);

}