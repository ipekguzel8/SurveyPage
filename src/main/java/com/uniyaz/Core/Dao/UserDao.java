package com.uniyaz.Core.Dao;

import com.uniyaz.Core.Domain.User;

/**
 * Created by ipekg on 2021
 */
public class UserDao extends BaseDao<User>{
    public UserDao() {
        super(User.class);
    }
}
