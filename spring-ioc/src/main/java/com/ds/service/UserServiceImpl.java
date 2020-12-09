package com.ds.service;

import com.ds.dao.UserDao;
import com.ds.dao.UserDaoImpl;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import sun.nio.cs.HistoricallyNamedCharset;

/**
 * @author: xxxxx
 * @create: 2020-11-25
 */
public class UserServiceImpl implements UserService{

    private UserDao dao;

    @Override
    public void getUser() {
        dao.getUser();
    }

    public UserService setUser(UserDao dao){
        this.dao = dao;
        return this;
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
