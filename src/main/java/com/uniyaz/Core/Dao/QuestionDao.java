package com.uniyaz.Core.Dao;

import com.uniyaz.Core.Domain.Question;
import com.uniyaz.Core.Dto.QuestionDto;
import com.uniyaz.Core.Dto.QuestionDtoNative;
import com.uniyaz.Core.Utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class QuestionDao extends BaseDao<Question>{

    public QuestionDao(Class<Question> clazz) {
        super(clazz);
    }

    public List findAllHqlAliasToBean() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            String hql =
                    "Select     surveyAlias.id, surveyAlias.name " +
                            "From       Survey surveyAlias ";
            Query query = session.createQuery(hql);
            query.setResultTransformer(Transformers.aliasToBean(QuestionDto.class));
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
