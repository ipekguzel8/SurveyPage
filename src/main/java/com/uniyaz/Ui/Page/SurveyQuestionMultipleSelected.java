package com.uniyaz.Ui.Page;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by ipekg on 2021
 */
public class SurveyQuestionMultipleSelected extends VerticalLayout {
    public SurveyQuestionMultipleSelected() {
        TextField questionText= new TextField("Seçimi Giriniz");
        Button questionAdded=new Button("Ekle");
        questionAdded.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {

            }
        });
    }
}
