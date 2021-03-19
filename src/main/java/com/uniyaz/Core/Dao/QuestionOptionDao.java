package com.uniyaz.Core.Dao;

import com.uniyaz.Core.Domain.Question;
import com.uniyaz.Core.Domain.QuestionOption;
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
public class QuestionOptionDao extends BaseDao<QuestionOption>{
    public QuestionOptionDao() {
        super(QuestionOption.class);
    }
    public List<QuestionOption> findAllOption(SurveyQuestion question) {
        Long Id= question.getId();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql = "Select questionOption " +
                    "From QuestionOption questionOption " +
                    "where  questionOption.surveyQuestion.id=" + Id+"";
            Query query = session.createQuery(hql);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }
}
