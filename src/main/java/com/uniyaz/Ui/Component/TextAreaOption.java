package com.uniyaz.Ui.Component;

import com.uniyaz.Core.Domain.SurveyQuestion;
import com.vaadin.ui.TextArea;

/**
 * Created by ipekg on 2021
 */
public class TextAreaOption extends TextArea {
    SurveyQuestion surveyQuestion= new SurveyQuestion();

    public SurveyQuestion getSurveyQuestion() {
        return surveyQuestion;
    }


    public TextAreaOption(SurveyQuestion surveyQuestion) {
        this.surveyQuestion=surveyQuestion;
    }

}
