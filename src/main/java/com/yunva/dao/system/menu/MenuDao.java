package com.yunva.dao.system.menu;

import com.yunva.repository.BaseRepository;
import com.yunva.model.system.Menu;
import com.yunva.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MenuDao extends BaseRepository
{

	
	public void deleteMenuById(String MENU_ID)  {
		template.delete("MenuMapper.deleteMenuById", MENU_ID);
		
	}

	public PageData getMenuById(PageData pd)  {
		return template.selectOne("MenuMapper.getMenuById", pd);
		
	}

	//取最大id
	public PageData findMaxId(PageData pd)  {
		return template.selectOne("MenuMapper.findMaxId", pd);

	}
	
	public List<Menu> listAllParentMenu()  {
		return template.selectList("MenuMapper.listAllParentMenu", null);
		
	}


	public List<Menu> listAllUserParentMenu(Integer roleId)  {
		return template.selectList("MenuMapper.listAllUserParentMenu", roleId);

	}

	public void saveMenu(Menu menu) 
	{
    	template.insert("MenuMapper.insertMenu", menu);
	}

	public List<Menu> listSubMenuByParentId(Integer parentId)  {
		return template.selectList("MenuMapper.listSubMenuByParentId", parentId);
		
	}
	/**
	 * 获取父级菜单下的子菜单
	 * @param parentId
	 * @return
	 */
	public List<Integer> getMenuIds(Integer parentId)
	{
		return template.selectList("MenuMapper.getMenuIds", parentId);

	}


	public List<Menu> listSubUserMenuByParentId(List<Integer> menuIds,Integer roleId ) 
	{
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("menuIds", menuIds);
		params.put("roleId", roleId);
		return template.selectList("MenuMapper.listSubUserMenuByParentId", params);

	}

	public List<Menu> listAllSubMenu() {
		return template.selectList("MenuMapper.listAllSubMenu", null);
		
	}
	
	/**
	 * 编辑
	 */
	public void edit(PageData pd)  {
		 template.update("MenuMapper.updateMenu", pd);
	}
	/**
	 * 保存菜单图标 (顶部菜单)
	 */
	public void editicon(PageData pd)  {
		template.update("MenuMapper.editicon", pd);
	}

}
