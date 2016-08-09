package com.yunva.dao.system.role;

import com.yunva.repository.BaseRepository;
import com.yunva.model.system.Role;
import com.yunva.model.system.RoleMenu;
import com.yunva.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoleDao extends BaseRepository {




	public List<Role> listAllERRoles()  {
		return  template.selectList("RoleMapper.listAllERRoles", null);
		
	}

	public List<Role> listAllRoles()  {
		return  template.selectList("RoleMapper.listAllRoles", null);
		
	}
	

	//列出此角色下的所有用户
	public List<PageData> listAllUByRid(PageData pd)  {
		return  template.selectList("RoleMapper.listAllUByRid", pd);
		
	}


	public void deleteRoleById(String roleId)  {
		template.delete("RoleMapper.deleteRoleById", roleId);
		
	}

	public Role getRoleById(String roleId)  {
		return template.selectOne("RoleMapper.getRoleById", roleId);
		
	}

	/**
	 * 添加
	 */
	public void add(PageData pd) 
	{
		template.selectList("RoleMapper.insert", pd);
	}


	/**
	 * 通过id查找
	 */
	public PageData findObjectById(PageData pd)  {
		return template.selectOne("RoleMapper.findObjectById", pd);
	}


	/**
	 * 编辑角色
	 */
	public void edit(PageData pd)  {
		 template.update("RoleMapper.edit", pd);
	}


	public List<Integer> getRoleMenuIds(Integer roleId) 
	{
		return template.selectList("RoleMapper.getRoleMenuIds", roleId);
	}




	/**
	 * 删除角色权限中间表
	 * @param roleId
	 * @
	 */
	public void deleteRoleMenu(Integer roleId) 
	{
		 template.delete("RoleMapper.deleteRoleMenu", roleId);
	}


	/**
	 * 保存角色权限中间表
	 * @param list
	 */
	public void saveRoleMenu(List<RoleMenu> list)
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("list", list);
		template.insert("RoleMapper.saveRoleMenu",params);
	}
}
