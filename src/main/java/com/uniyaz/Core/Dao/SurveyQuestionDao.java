package com.uniyaz.Core.Dao;

import com.uniyaz.Core.Domain.Question;
import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Domain.SurveyQuestion;
import com.uniyaz.Core.Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class SurveyQuestionDao extends BaseDao<SurveyQuestion> {
    public SurveyQuestionDao() {
        super(SurveyQuestion.class);
    }

    public List<SurveyQuestion> findAllQuestion(Survey survey) {
        Long Id= survey.getId();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select surveyQuestion " +
                            "From SurveyQuestion surveyQuestion " +
                            "where  surveyQuestion.survey.id=" + Id+"";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
}