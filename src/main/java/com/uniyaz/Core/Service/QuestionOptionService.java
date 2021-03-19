package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.QuestionOptionDao;
import com.uniyaz.Core.Domain.Question;
import com.uniyaz.Core.Domain.QuestionOption;
import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Domain.SurveyQuestion;

import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class QuestionOptionService extends BaseService<QuestionOption,QuestionOptionDao>{
    public QuestionOptionService() {
        super(QuestionOptionDao.class);
    }
    public List<QuestionOption> findAllOption(SurveyQuestion question){
        return getDao().findAllOption(question);
    }
}
