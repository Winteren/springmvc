package com.apple.springmvc.service;

import com.apple.springmvc.bean.QueryUser;
import com.apple.springmvc.bean.User;

import java.util.List;
import java.util.Map;

/**
 * Created by renxueni on 2016/7/4.
 */
public interface IUserService {

    /**
     * 获取所有用户
     * @return
     */
    public List<User> getAllUser();



    /**
     * 新增单个用户
     * @param user
     */
    void addUser(User user);

    /**
     * 批量新增用户
     * @param users
     */
    void addUserBatch(List<User> users);

    /**
     * 更新单个用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 批量更新用户
     * @param users
     */
    void updateUserBatch(List<User> users);

    /**
     * 根据用户Id 删除用户
     * @param userId
     */
    void deleteUserById(String userId);

    /**
     * 根据用户Id 批量删除
     * @param userIds
     */
    void deleteUserByIdBatch(Map<String,Object> userIds);

    /**
     * 根据用户Id 查找用户
     * @param userId
     * @return
     */
    User getUserById(String userId);

    /**
     * 根据用户Id 批量查找用户
     * @param userIds
     * @return
     */
    List<User> getUserByIdBatch(Map<String, Object> userIds);

    /**
     * 多条件查询用户
     * @param queryUser
     * @return
     */
    List<User> getUserByParam(QueryUser queryUser);

}
