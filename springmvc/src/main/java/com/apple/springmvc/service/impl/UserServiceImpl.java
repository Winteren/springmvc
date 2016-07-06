package com.apple.springmvc.service.impl;

import com.apple.springmvc.bean.QueryUser;
import com.apple.springmvc.bean.User;
import com.apple.springmvc.manager.IUserManager;
import com.apple.springmvc.service.IUserService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by renxueni on 2016/7/4.
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserManager userManager;

    private LoadingCache<String,List<User>> cache = null;
    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUser(){
        try {
            return cache.get("user");
        } catch (Exception e) {
            System.out.println("---"+e.getMessage());
        }
        return null;
    }

    /**
     * 初始化缓存
     */
    @PostConstruct
    private void loadCache(){
        cache = CacheBuilder
                .newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .build(new CacheLoader<String, List<User>>() {
                    @Override
                    public List<User> load(String key) throws Exception {
                        return userManager.getAllUser();
                    }
                });
    }



    /**
     * 新增单个用户
     * @param user
     */
    public void addUser(User user){
        userManager.addUser(user);
    }

    /**
     * 批量新增用户
     * @param users
     */
    public void addUserBatch(List<User> users){
        userManager.addUserBatch(users);
    }

    /**
     * 更新单个用户
     * @param user
     */
    public void updateUser(User user){
        userManager.updateUser(user);
    }

    /**
     * 批量更新用户
     * @param users
     */
    public void updateUserBatch(List<User> users){
        userManager.updateUserBatch(users);
    }

    /**
     * 根据用户Id 删除用户
     * @param userId
     */
    public void deleteUserById(String userId){
        userManager.deleteUserById(userId);
    }

    /**
     * 根据用户Id 批量删除
     * @param userIds
     */
    public void deleteUserByIdBatch(Map<String,Object> userIds){
        userManager.deleteUserByIdBatch(userIds);
    }

    /**
     * 根据用户Id 查找用户
     * @param userId
     * @return
     */
    public User getUserById(String userId){
        return userManager.getUserById(userId);
    }

    /**
     * 根据用户Id 批量查找用户
     * @param userIds
     * @return
     */
    public List<User> getUserByIdBatch(Map<String, Object> userIds){
        return userManager.getUserByIdBatch(userIds);
    }

    /**
     * 多条件查询用户
     * @param queryUser
     * @return
     */
    public List<User> getUserByParam(QueryUser queryUser){
        return userManager.getUserByParam(queryUser);
    }

}
