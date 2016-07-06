package com.apple.springmvc.manager.impl;

import com.apple.springmvc.bean.QueryUser;
import com.apple.springmvc.bean.User;
import com.apple.springmvc.manager.IUserManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
* UserManagerImpl Tester. 
* 
* @author renxueni 
* @since <pre>七月 4, 2016</pre>
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-manager.xml"})
public class UserManagerImplTest {

    @Autowired
    private IUserManager userManager;

/** 
* 
* Method: getAllUser() 
* 
*/ 
@Test
public void testGetAllUser() throws Exception {
    List<User> Users = userManager.getAllUser();
    for (User user : Users) {
        System.out.println(user.toString());
    }
} 

/** 
* 
* Method: addUser(User user) 
* 
*/ 
@Test
public void testAddUser() throws Exception {
    User user = new User();
    user.setUserId("33");
    user.setUserName("33");
    user.setAge(33);
    user.setSex(1);
    user.setAddress("33");

    userManager.addUser(user);
}

/** 
* 
* Method: addUserBatch(List<User> users) 
* 
*/ 
@Test
public void testAddUserBatch() throws Exception { 

    List<User> users = new ArrayList<User>();
    for (int i= 0;i<10;i++){
        User user = new User();
        user.setUserId("a"+i);
        user.setUserName("test"+i);
        user.setRealName("Apple"+i);
        user.setAge(i);
        user.setSex(i%2==0?1:2);
        user.setAddress("天使街"+i+"号");
        users.add(user);
    }

    userManager.addUserBatch(users);
} 

/** 
* 
* Method: updateUser(User user) 
* 
*/ 
@Test
public void testUpdateUser() throws Exception {
    User user = userManager.getUserById("11");
    user.setAge(99);
    user.setSex(1);
    userManager.updateUser(user);
    System.out.println(userManager.getUserById("11"));
} 

/** 
* 
* Method: updateUserBatch(List<User> users) 
* 
*/ 
@Test
public void testUpdateUserBatch() throws Exception { 
List<User> users = userManager.getAllUser();
    List<User> userList = new ArrayList<User>();
    for(User user:users){
        user.setRealName(user.getRealName());
        user.setAge(22);
        user.setMobile("100000");
        user.setPhone("20000");
        user.setRemark(user.getUserId()+":批量测试");
        userList.add(user);
    }
    userManager.updateUserBatch(userList);

    List<User> newUsers = userManager.getAllUser();
    for(User user:newUsers){
        System.out.println(user);
    }
} 

/** 
* 
* Method: deleteUserById(String userId) 
* 
*/ 
@Test
public void testDeleteUserById() throws Exception { 
userManager.deleteUserById("33");
} 

/** 
* 
* Method: deleteUserByIdBatch(List<User> users) 
* 
*/ 
@Test
public void testDeleteUserByIdBatch() throws Exception {
    List<String> userIds = new ArrayList<String>();
    for (int i= 0;i<10;i++){
        String userId = "a"+i;
        userIds.add(userId);
    }

    Map<String,Object> userIdsMap = new HashMap<String, Object>();
    userIdsMap.put("userIds",userIds);
    userManager.deleteUserByIdBatch(userIdsMap);

    System.out.println(userManager.getAllUser().size());
} 

/** 
* 
* Method: getUserById(String userId) 
* 
*/ 
@Test
public void testGetUserById() throws Exception { 
User user = userManager.getUserById("a0");
    System.out.println(user);
} 

/** 
* 
* Method: getUserByIdBatch(List<String> userIds) 
* 
*/ 
@Test
public void testGetUserByIdBatch() throws Exception {
    List<String> userIds = new ArrayList<String>();
    for (int i= 0;i<10;i++){
        String userId = "a"+i;
        userIds.add(userId);
    }

    Map<String,Object> userIdsMap = new HashMap<String, Object>();
    userIdsMap.put("userIds",userIds);
    List<User> users = userManager.getUserByIdBatch(userIdsMap);
    for(User user:users){
        System.out.println(user);
    }
} 

/** 
* 
* Method: getUserByParam(QueryUser queryUser) 
* 
*/ 
@Test
public void testGetUserByParam() throws Exception {
    QueryUser queryUser = new QueryUser();
    //queryUser.setUserId("a1");
    queryUser.setRealName("Apple");
    queryUser.setUserName("test");

    List<User> users = userManager.getUserByParam(queryUser);
    for(User user:users){
        System.out.println(user);
    }
} 


} 
