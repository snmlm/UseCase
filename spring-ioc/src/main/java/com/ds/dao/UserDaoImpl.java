package com.ds.dao;

import com.ds.service.UserServiceImpl;

/**
 * @author: xxxxx
 * @create: 2020-11-25
 */
public class UserDaoImpl implements UserDao{

    private String name;

    public UserDaoImpl(){
        this.name = "";
    }

    public UserDaoImpl(String name){
        this.name = name;
    }

    @Override
    public void getUser() {
        System.out.println("name："+name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
