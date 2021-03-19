package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.SurveyDao;
import com.uniyaz.Core.Domain.Survey;

/**
 * Created by ipekg on 2021
 */
public class SurveyService extends BaseService<Survey, SurveyDao>{
    public SurveyService() {
        super(SurveyDao.class);
    }
}
