package com.uniyaz.Ui.Page;
import com.uniyaz.Core.Domain.*;
import com.uniyaz.Core.Service.QuestionOptionService;
import com.uniyaz.Core.Service.SurveyQuestionService;
import com.uniyaz.Core.Service.UserSurveyService;
import com.uniyaz.Ui.Component.CheckBoxOption;
import com.uniyaz.Ui.Component.RadioButtonOption;
import com.uniyaz.Ui.Component.TextAreaOption;
import com.uniyaz.Ui.MyUI;
import com.vaadin.data.Item;
import com.vaadin.data.Validator;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class OpenSurvey extends VerticalLayout {
    public OpenSurvey(Survey survey) {
        LinkedList<Component> componentList= new LinkedList<>();
        LinkedList<SurveyQuestion> surveyQuestions= new LinkedList<>();
        SurveyQuestionService questionService= new SurveyQuestionService();
        List<SurveyQuestion> allQuestion = questionService.findAllQuestion(survey);
        for(SurveyQuestion question: allQuestion){
            addComponent(new Label(question.getQuestionText()));
            if(question.getType().equals("Text")){
                surveyQuestions.addLast(question);
                componentList.addLast(new TextAreaOption(question));
            }else if(question.getType().equals("Çoklu Seçim")){
                OptionGroup optionGroup= new OptionGroup();
                QuestionOptionService questionOptionService= new QuestionOptionService();
                List<QuestionOption> allOption = questionOptionService.findAllOption(question);
                for(QuestionOption questionOption:allOption){
                    optionGroup.addItem(questionOption.getOptionText());
                }
                optionGroup.setMultiSelect(true);
                componentList.addLast(optionGroup);

            }else{

                RadioButtonOption optionGroup= new RadioButtonOption(question);
                QuestionOptionService questionOptionService= new QuestionOptionService();
                List<QuestionOption> allOption = questionOptionService.findAllOption(question);
                for(QuestionOption questionOption:allOption){
                    optionGroup.addItem(questionOption.getOptionText());
                }
                componentList.addLast(optionGroup);
                List<Object> objects = optionGroup.ObjectList();
                for (Object obj: objects){
                    Class<?> aClass = obj.getClass();
                    String name = aClass.getName();
                    System.out.println(name);
                }
            }
        }

        for(Component component:componentList){
            addComponent(component);
        }
        Button button= new Button("GÖNDER");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MyUI current = (MyUI) MyUI.getCurrent();
                int i=0;
                for(Component component:componentList){
                    UserSurvey userSurvey= new UserSurvey();
                    userSurvey.setUser(current.getUser());
                    userSurvey.setSurvey(current.getUseSurvey());
                    userSurvey.setQuestion(surveyQuestions.get(i));
                    Class<? extends Component> aClass = component.getClass();
                    if(aClass.getName().equals(TextAreaOption.class.getName())){
                        userSurvey.setReply(aClass.getName());
                        UserSurveyService userSurveyService= new UserSurveyService();
                        userSurveyService.save(userSurvey);
                    }else{

                    }
                    i+=1;
                }
            }
        });
        addComponent(button);
    }
}
