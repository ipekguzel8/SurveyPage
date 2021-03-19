package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.UserDao;
import com.uniyaz.Core.Dao.UserSurveyDao;
import com.uniyaz.Core.Domain.User;
import com.uniyaz.Core.Domain.UserSurvey;

/**
 * Created by ipekg on 2021
 */
public class UserSurveyService extends BaseService<UserSurvey, UserSurveyDao>{
    public UserSurveyService() {
        super(UserSurveyDao.class);
    }
}
