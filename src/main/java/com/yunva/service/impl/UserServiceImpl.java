package com.yunva.service.impl;

import com.yunva.dao.system.user.UserDao;
import com.yunva.model.Page;
import com.yunva.model.system.User;
import com.yunva.service.UserService;
import com.yunva.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <dl>
 * <dt>yunva-new-admin</dt>
 * <dd>Description:用户服务接口实现类</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 深圳云娃科技有限公司</dd>
 * <dd>CreateDate: 2016/8/5</dd>
 * </dl>
 *
 * @author 张志
 */
@Service
public class UserServiceImpl implements UserService
{

    @Autowired
    private UserDao userDao;

    public PageData findByUiId(PageData pd){
        return userDao.findByUiId(pd);
    }
    /*
    * 通过loginname获取数据
    */
    public PageData findByUId(PageData pd) {
        return userDao.findByUId( pd);
    }


    /*
    * 通过邮箱获取数据
    */
    public PageData findByUE(PageData pd){
        return userDao.findByUE(pd);
    }

    /*
    * 通过编号获取数据
    */
    public PageData findByUN(PageData pd){
        return userDao.findByUN(pd);
    }

    /*
    * 保存用户
    */
    public void saveU(PageData pd){
        userDao.saveU(pd);
    }
    /*
    * 修改用户
    */
    public void editUser(PageData pd){
        userDao.editUser(pd);
    }
    /*
    * 换皮肤
    */
    public void setSKIN(PageData pd){
        userDao.setSKIN(pd);
    }
    /*
    * 删除用户
    */
    public void deleteUser(PageData pd){
        userDao.deleteUser(pd);
    }
    /*
    * 批量删除用户
    */
    public void deleteAllU(String[] USER_IDS){
        userDao.deleteAllU(USER_IDS);
    }
    /*
    *用户列表
    */
    public List<PageData> listPdPageUser(Page page){
        return userDao.listPdPageUser(page);
    }

    /*
    *用户列表(全部)
    */
    public List<PageData> listAllUser(PageData pd){
        return userDao.listAllUser(pd);
    }

    /*
    *用户列表(供应商用户)
    */
    public List<PageData> listGPdPageUser(Page page){
        return userDao.listGPdPageUser(page);
    }

    /*
    * 登录判断
    */
    public PageData getUserByNameAndPwd(PageData pd){
        return userDao.getUserByNameAndPwd(pd);
    }


    /*
    *通过id获取数据
    */
    public User getUserAndRoleById(String userId)  {
        return userDao.getUserAndRoleById(userId);
    }

}