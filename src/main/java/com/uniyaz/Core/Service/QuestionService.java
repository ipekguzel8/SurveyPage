package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.QuestionDao;
import com.uniyaz.Core.Domain.Question;

/**
 * Created by ipekg on 2021
 */
public class QuestionService extends BaseService<Question, QuestionDao>{
    public QuestionService() {
        super(QuestionDao.class);
    }
}
