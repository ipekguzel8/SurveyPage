package com.uniyaz.Core.Service;

import com.uniyaz.Core.Dao.SurveyQuestionDao;
import com.uniyaz.Core.Domain.Question;
import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Domain.SurveyQuestion;
import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class SurveyQuestionService extends BaseService<SurveyQuestion, SurveyQuestionDao>{
    public SurveyQuestionService() {
        super(SurveyQuestionDao.class);
    }
    public List<SurveyQuestion> findAllQuestion(Survey survey){
        return getDao().findAllQuestion(survey);
    }
}
