package com.uniyaz.Ui.Page;

import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Service.SurveyService;
import com.uniyaz.Ui.MyUI;
import com.vaadin.event.FieldEvents;
import com.vaadin.ui.*;

/**
 * Created by ipekg on 2021
 */
public class SurveyHeaderVL extends VerticalLayout {
    public SurveyHeaderVL() {
        Survey survey= new Survey();
        TextField header= new TextField("Anket Başılığı giriniz");
        header.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent textChangeEvent) {
                System.out.println(textChangeEvent.getText());
                MyUI current = (MyUI) MyUI.getCurrent();
                ViewSurvey viewSurvey = current.getBody().getViewSurvey();
                viewSurvey.setWord(textChangeEvent.getText());

            }
        });
        Button headerAdded= new Button("Anketi Oluştur");
        setSpacing(true);
        headerAdded.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MyUI myUI=(MyUI) UI.getCurrent();
                Content content = myUI.getBody().getContent();
                ViewSurvey viewSurvey = myUI.getBody().getViewSurvey();
                viewSurvey.addComponent(new Label(header.getValue()));
                survey.setName(header.getValue());

                SurveyService surveyNameService= new SurveyService();
                Survey save = surveyNameService.save(survey);
                System.out.println(save.toString());
                myUI.setUseSurvey(save);
                content.removeAllComponents();
                SurveyQuestionVL surveyQuestionVL= new SurveyQuestionVL();
                content.addComponent(surveyQuestionVL);
                content.setComponentAlignment(surveyQuestionVL, Alignment.MIDDLE_CENTER);
            }
        });
        setSizeUndefined();
        addComponent(header);
        addComponent(headerAdded);

    }
}
