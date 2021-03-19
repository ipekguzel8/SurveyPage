package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.QuestionOptionDao;
import com.uniyaz.Core.Domain.QuestionOption;

/**
 * Created by ipekg on 2021
 */
public class QuestionOptionService extends BaseService<QuestionOption,QuestionOptionDao>{
    public QuestionOptionService() {
        super(QuestionOptionDao.class);
    }
}
