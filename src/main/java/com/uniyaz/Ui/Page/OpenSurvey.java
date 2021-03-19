package com.uniyaz.Ui.Page;

import com.uniyaz.Core.Dao.QuestionDao;
import com.uniyaz.Core.Domain.Question;
import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Service.QuestionService;
import com.uniyaz.Core.Service.SurveyQuestionService;
import com.uniyaz.Core.Service.SurveyService;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class OpenSurvey extends VerticalLayout {
    public OpenSurvey(Survey survey) {
        SurveyQuestionService questionService= new SurveyQuestionService();
        List<Question> allQuestion = questionService.findAllQuestion(survey);
        System.out.println(allQuestion);
    }
}
