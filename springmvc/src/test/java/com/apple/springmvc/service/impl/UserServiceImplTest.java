package com.apple.springmvc.service.impl;

import com.apple.springmvc.bean.User;
import com.apple.springmvc.service.IUserService;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/** 
* UserServiceImpl Tester. 
* 
* @author renxueni 
* @since <pre>七月 4, 2016</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-dao.xml",
        "classpath:spring/applicationContext-manager.xml",
        "classpath:spring/applicationContext-service.xml"})
public class UserServiceImplTest {

    @Autowired
    private IUserService userService;

/** 
* 
* Method: getAllUser() 
* 
*/ 

public void testGetAllUser() throws Exception {

    List<User> users = userService.getAllUser();
    for (User user : users){
        System.out.println(user);
    }
}
/*
    private LoadingCache<String,List<User>> cache = null;
    @Before
    public void loadCache(){
        cache = CacheBuilder
                .newBuilder()
                .maximumSize(1000)
                .expireAfterAccess(2, TimeUnit.SECONDS)
                .build(new CacheLoader<String, List<User>>() {
                    @Override
                    public List<User> load(String key) throws Exception {
                        return userService.getAllUser();
                    }
                });
    }


    @Test
    public  void testLoadingCache(){
        try {
             System.out.println(cache.get("user"));
             System.out.println(cache.get("user"));
             Thread.sleep(5000);
             System.out.println(cache.get("user"));
             System.out.println(cache.get("user"));
        } catch (Exception e) {
            System.out.println("---"+e.getMessage());
        }


    }

*/


    private Cache<String,List<User>> cache = null;
    private List<User> users = null;
    @Before
    public void callableCache(){
        cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        try {
                users = cache.get("user", new Callable<List<User>>() {
                public List<User> call() throws Exception {
                return userService.getAllUser();
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void testCallableCache() throws Exception{

        System.out.println("user value : " + users);
        System.out.println("user value : " + users);
        System.out.println("user value : " + users);
        System.out.println("user value : " + users);
    }


} 
