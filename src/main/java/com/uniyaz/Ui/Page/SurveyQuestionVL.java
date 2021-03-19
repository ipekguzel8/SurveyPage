package com.uniyaz.Ui.Page;

import com.uniyaz.Core.Dao.QuestionOptionDao;
import com.uniyaz.Core.Domain.QuestionOption;
import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Domain.SurveyQuestion;
import com.uniyaz.Core.Service.SurveyQuestionService;
import com.uniyaz.Ui.Component.SPMultipleSelection;
import com.uniyaz.Ui.MyUI;
import com.vaadin.data.Property;
import com.vaadin.event.ContextClickEvent;
import com.vaadin.event.FieldEvents;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class SurveyQuestionVL extends VerticalLayout {
    SurveyQuestion saveQuestion= new SurveyQuestion();
    public SurveyQuestionVL() {
        VerticalLayout select= new VerticalLayout();
        List<QuestionOption> questionOptionList= new ArrayList<>();
        List<String> data= new ArrayList<>();
        TextField questionField= new TextField("Soruyu Giriniz");
        ComboBox questionType= new ComboBox("Veri türünü Seçiniz");
        questionType.addItem("Int");
        questionType.addItem("Text");
        questionType.addItem("Çoklu Seçim");
        questionType.addItem("Tek Seçim");
        Button selectbtn= new Button("Soruyu Ekle");

        //soru ekle tıklandı
        selectbtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MyUI current = (MyUI) MyUI.getCurrent();
                ViewSurvey viewSurvey = current.getBody().getViewSurvey();
                viewSurvey.addComponent(new Label(questionField.getValue()));
                SurveyQuestionService surveyQuestionService= new SurveyQuestionService();
                Survey useSurvey = current.getUseSurvey();
                SurveyQuestion surveyQuestion1= new SurveyQuestion();

                surveyQuestion1.setSurvey(useSurvey);
                surveyQuestion1.setQuestionText(questionField.getValue());
                surveyQuestion1.setType(questionType.getValue().toString());
                saveQuestion = surveyQuestionService.save(surveyQuestion1);
                removeAllComponents();

                //Soru veri tipiyle birlikte veritabanına kaydedildi.
                TextField questionSelect= new TextField();

                //Çoklu seçim ise
                if(questionType.getValue().equals("Çoklu Seçim") || questionType.getValue().equals("Tek Seçim")){
                    OptionGroup optionGroup= new OptionGroup();
                    HorizontalLayout horizontalLayout= new HorizontalLayout();
                    questionSelect.setInputPrompt("Seçim Giriniz");
                    questionSelect.addTextChangeListener(new FieldEvents.TextChangeListener() {
                        @Override
                        public void textChange(FieldEvents.TextChangeEvent textChangeEvent) {
                            System.out.println(textChangeEvent.getText());
                        }
                    });
                    Button button= new Button("Seçimi Ekle");
                    button.setIcon(FontAwesome.PLUS);
                    button.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            QuestionOption questionOption= new QuestionOption();
                            MyUI current = (MyUI) MyUI.getCurrent();
                            ViewSurvey viewSurvey = current.getBody().getViewSurvey();
                            questionOption.setSurveyQuestion(saveQuestion);
                            questionOption.setOptionText(questionSelect.getValue());
                            if(questionType.getValue().equals("Çoklu Seçim")) viewSurvey.addComponent(new CheckBox(questionSelect.getValue()));
                            else{
                                optionGroup.addItem(questionSelect.getValue());
                            }
                            questionOptionList.add(questionOption);
                            questionSelect.clear();
                        }
                    });
                    horizontalLayout.addComponent(questionSelect);
                    horizontalLayout.setSpacing(true);
                    horizontalLayout.addComponent(button);
                    Button questionCreated= new Button("Yeni Soru Oluştur");
                    questionCreated.addClickListener(new Button.ClickListener() {
                        @Override
                        public void buttonClick(Button.ClickEvent clickEvent) {
                            MyUI current1 = (MyUI) MyUI.getCurrent();
                            ViewSurvey viewSurvey = current1.getBody().getViewSurvey();
                            QuestionOptionDao questionOptionDao= new QuestionOptionDao();
                            questionOptionDao.saveOption(questionOptionList);
                            if(questionType.getValue().equals("Tek Seçim")) viewSurvey.addComponent(optionGroup);
                            questionField.clear();
                            questionType.setValue(null);
                            questionSelect.clear();
                            removeAllComponents();
                            addComponent(select);
                        }
                    });
                    addComponent(horizontalLayout);
                    addComponent(questionCreated);
                }
                else if(questionType.getValue().equals("Text")){
                    questionField.clear();
                    questionType.setValue(null);
                    MyUI current1 = (MyUI) MyUI.getCurrent();
                    ViewSurvey viewSurvey3 = current1.getBody().getViewSurvey();
                    viewSurvey3.addComponent(new TextArea());
                    removeAllComponents();
                    addComponent(select);
                }
            }
        });
        select.addComponent(questionField);
        select.addComponent(questionType);
        select.addComponent(selectbtn);

        //seçenekler liste halinde veritabanına gönderildi.
        questionField.addTextChangeListener(new FieldEvents.TextChangeListener() {
            @Override
            public void textChange(FieldEvents.TextChangeEvent textChangeEvent) {

                MyUI current = (MyUI) MyUI.getCurrent();
                ViewSurvey viewSurvey = current.getBody().getViewSurvey();
                viewSurvey.setWord(textChangeEvent.getText());

            }
        });




        setSizeUndefined();
        addComponent(select);

        setSpacing(true);

    }
}
