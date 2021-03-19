package com.uniyaz.Ui.Component;

import com.uniyaz.Core.Domain.QuestionOption;
import com.vaadin.ui.CheckBox;

/**
 * Created by ipekg on 2021
 */
public class CheckBoxOption extends CheckBox {
    QuestionOption questionOption= new QuestionOption();
    public CheckBoxOption(QuestionOption questionOption) {
    this.questionOption=questionOption;
    }

    public QuestionOption getQuestionOption() {
        return questionOption;
    }
}
