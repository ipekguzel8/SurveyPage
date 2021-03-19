package com.uniyaz.Core.Dao;

import com.uniyaz.Core.Domain.Survey;

/**
 * Created by ipekg on 2021
 */
public class SurveyDao extends BaseDao<Survey>{
    Long lastId;
    public SurveyDao() {
        super(Survey.class);
    }

}
