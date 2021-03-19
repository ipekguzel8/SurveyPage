package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.UserDao;
import com.uniyaz.Core.Domain.User;

/**
 * Created by ipekg on 2021
 */
public class UserService extends BaseService<User, UserDao>{
    public UserService() {
        super(UserDao.class);
    }
}
