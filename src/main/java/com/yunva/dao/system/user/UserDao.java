package com.yunva.dao.system.user;

import com.yunva.repository.BaseRepository;
import com.yunva.model.Page;
import com.yunva.model.system.User;
import com.yunva.util.PageData;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDao extends BaseRepository {



	public PageData findByUiId(PageData pd){
		return template.selectOne("UserXMapper.findByUiId", pd);
	}


	/*
	* 通过loginname获取数据
	*/
	public PageData findByUId(PageData pd){
		return template.selectOne("UserXMapper.findByUId", pd);
	}


	/*
	* 通过邮箱获取数据
	*/
	public PageData findByUE(PageData pd){
		return template.selectOne("UserXMapper.findByUE", pd);
	}

	/*
	* 通过编号获取数据
	*/
	public PageData findByUN(PageData pd){
		return template.selectOne("UserXMapper.findByUN", pd);
	}

	/*
	* 保存用户
	*/
	public void saveU(PageData pd){
		template.insert("UserXMapper.saveU", pd);
	}
	/*
	* 修改用户
	*/
	public void editUser(PageData pd){
		template.update("UserXMapper.editUser", pd);
	}
	/*
	* 换皮肤
	*/
	public void setSKIN(PageData pd){
		template.update("UserXMapper.setSKIN", pd);
	}
	/*
	* 删除用户
	*/
	public void deleteUser(PageData pd){
		template.delete("UserXMapper.deleteUser", pd);
	}
	/*
	* 批量删除用户
	*/
	public void deleteAllU(String[] USER_IDS){
		template.delete("UserXMapper.deleteAllU", USER_IDS);
	}
	/*
	*用户列表
	*/
	public List<PageData> listPdPageUser(Page page){
		return template.selectList("UserXMapper.userlistPage", page);
	}

	/*
	*用户列表(全部)
	*/
	public List<PageData> listAllUser(PageData pd){
		return template.selectList("UserXMapper.listAllUser", pd);
	}

	/*
	*用户列表(供应商用户)
	*/
	public List<PageData> listGPdPageUser(Page page){
		return template.selectList("UserXMapper.userGlistPage", page);
	}
	/*
	* 保存用户IP
	*/
	public void saveIP(PageData pd){
		template.update("UserXMapper.saveIP", pd);
	}

	/*
	* 登录判断
	*/
	public PageData getUserByNameAndPwd(PageData pd){
		return template.selectOne("UserXMapper.getUserInfo", pd);
	}


	/*
	*通过id获取数据
	*/
	public User getUserAndRoleById(String USER_ID)  {
		return template.selectOne("UserMapper.getUserAndRoleById", USER_ID);
	}

	
}
