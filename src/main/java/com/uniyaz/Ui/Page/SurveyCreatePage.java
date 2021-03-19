package com.uniyaz.Ui.Page;
import com.uniyaz.Ui.Component.SPMultipleSelection;
import com.vaadin.data.Property;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.*;

/**
  *Created by ipekg on 2021
*/
public class SurveyCreatePage extends Panel {
    VerticalLayout panelLayout = new VerticalLayout();
    SurveyEditPage surveyEditPage = new SurveyEditPage();
    TextField header;
    public SurveyCreatePage() {
        TextField header= new TextField();
        header.setCaption("Anket başlığı giriniz.");
        Button surveyCreatedbtn= new Button("Anketi Oluştur");
        surveyCreatedbtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Button answerCreate= new Button("Soru Oluştur");
                answerCreate.setIcon(FontAwesome.PLUS);
                panelLayout.addComponent(answerCreate);
                answerCreate.addClickListener(new Button.ClickListener() {
                    @Override
                    public void buttonClick(Button.ClickEvent clickEvent) {
                        createAnswer(new Button());
                    }
                });
            }
        });
        panelLayout.addComponent(header);
        panelLayout.addComponent(surveyCreatedbtn);
        setContent(panelLayout);

    }

    private void createAnswer(Button button) {
        TextField answerEntered= new TextField();
        answerEntered.setCaption("Soruyu Giriniz");
        surveyEditPage.addComponent(answerEntered);
        ComboBox answerType= new ComboBox();
        answerType.addItem("Int");
        answerType.addItem("Text");
        answerType.addItem("Date");
        answerType.addItem("Çoktan Seçmeli");
        answerType.addItem("Tek Seçim");
        answerType.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                if(valueChangeEvent.getProperty().getValue().equals("Çoktan Seçmeli")){
                    VerticalLayout verticalLayout= new VerticalLayout();
                    panelLayout.addComponent(verticalLayout);
                    TextField selectionCheckBox= new TextField("Seçimin başlığını giriniz.");
                    verticalLayout.addComponent(selectionCheckBox);
                        Button button1= new Button("Seçimi oluştur");
                        button1.setIcon(FontAwesome.PLUS);
                        verticalLayout.addComponent(button1);
                        button1.addClickListener(new Button.ClickListener() {
                            @Override
                            public void buttonClick(Button.ClickEvent clickEvent) {
                                SPMultipleSelection spMultipleSelection= new SPMultipleSelection(selectionCheckBox.getValue());
                                verticalLayout.addComponent(spMultipleSelection);
                                surveyEditPage.addComponent(spMultipleSelection);
                            }
                        });
                }
            }
        });
        panelLayout.addComponent(answerEntered);
        panelLayout.addComponent(answerType);
    }
}
