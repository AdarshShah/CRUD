package com.royal.controller;

import java.util.ArrayList;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restuser")
public class UserRestController {

    @RequestMapping(method = RequestMethod.GET)
    public ArrayList<UserBean> getAll(UserDao dao){
        return new ArrayList<>(dao.getAll());
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void remove(UserBean user,UserDao dao){
        dao.remove(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(UserBean user,UserDao dao){
        dao.insert(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(String name,UserDao dao){
        UserBean user = new UserBean();
        user.setName(name);
        dao.insert(user);
    }
}