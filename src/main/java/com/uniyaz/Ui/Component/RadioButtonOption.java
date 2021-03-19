package com.uniyaz.Ui.Component;

import com.uniyaz.Core.Domain.QuestionOption;
import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Domain.SurveyQuestion;
import com.vaadin.data.Item;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.OptionGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class RadioButtonOption extends OptionGroup{
    @Override
    public Object addItem() throws UnsupportedOperationException {
        System.out.println("Parametresiz çalıştı");
        return super.addItem();
    }
    public Object addItem(Survey survey) throws UnsupportedOperationException {
        System.out.println("Parametresiz çalıştı");
        return super.addItem();
    }
    List<Object> components=new ArrayList<>();
    @Override
    public Item addItem(Object itemId) throws UnsupportedOperationException {
        System.out.println("Parametreli çalıştı");
        components.add(itemId);
        return super.addItem(itemId);
    }
    public List<Object> ObjectList(){
        return components;
    }
    public SurveyQuestion getSurveyQuestion() {
        return surveyQuestion;
    }

    SurveyQuestion surveyQuestion= new SurveyQuestion();
    public RadioButtonOption(SurveyQuestion surveyQuestion) {
        this.surveyQuestion=surveyQuestion;
    }

}
