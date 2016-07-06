package com.apple.springmvc.manager.impl;

import com.apple.springmvc.bean.QueryUser;
import com.apple.springmvc.bean.User;
import com.apple.springmvc.dao.IUserDao;
import com.apple.springmvc.manager.IUserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by renxueni on 2016/7/4.
 */
@Component
public class UserManagerImpl implements IUserManager{

    @Autowired
    private IUserDao userDao;

    public List<User> getAllUser(){
        System.out.println("----------------------");
       return userDao.getAllUser();
    }

    public void addUser(User user){
        userDao.addUser(user);
    }


    /**
     * 批量新增用户
     * @param users
     */
    public void addUserBatch(List<User> users){
        userDao.addUserBatch(users);
    }

    /**
     * 更新单个用户
     * @param user
     */
    public void updateUser(User user){
        userDao.updateUser(user);
    }

    /**
     * 批量更新用户
     * @param users
     */
    public void updateUserBatch(List<User> users){
        userDao.updateUserBatch(users);
    }

    /**
     * 根据用户Id 删除用户
     * @param userId
     */
    public void deleteUserById(String userId){
        userDao.deleteUserById(userId);
    }

    /**
     * 根据用户Id 批量删除
     * @param userIds
     */
    public void deleteUserByIdBatch(Map<String,Object> userIds){
        userDao.deleteUserByIdBatch(userIds);
    }

    /**
     * 根据用户Id 查找用户
     * @param userId
     * @return
     */
    public User getUserById(String userId){
        return userDao.getUserById(userId);
    }

    /**
     * 根据用户Id 批量查找用户
     * @param userIds
     * @return
     */
    public List<User> getUserByIdBatch(Map<String, Object> userIds){
        return userDao.getUserByIdBatch(userIds);
    }

    /**
     * 多条件查询用户
     * @param queryUser
     * @return
     */
    public List<User> getUserByParam(QueryUser queryUser){
        return userDao.getUserByParam(queryUser);
    }
}
