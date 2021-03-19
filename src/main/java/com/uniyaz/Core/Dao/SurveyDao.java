package com.uniyaz.Core.Dao;

import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigInteger;

/**
 * Created by ipekg on 2021
 */
public class SurveyDao extends BaseDao<Survey>{
    Long lastId;
    public SurveyDao() {
        super(Survey.class);
    }

}
