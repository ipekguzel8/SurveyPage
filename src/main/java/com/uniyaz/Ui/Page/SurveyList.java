package com.uniyaz.Ui.Page;

import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Service.SurveyService;
import com.uniyaz.Ui.MyUI;
import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class SurveyList extends VerticalLayout {
    private Table table;
    private Container container;
    private VerticalLayout mainLayout;
    public SurveyList() {
        setSizeFull();
        buildMainLayout();
        addComponent(mainLayout);

        setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);

        fillTable();
    }
    private void fillTable() {
        SurveyService surveyService = new SurveyService();
        List<Survey> surveyList = surveyService.findAll();
        for (Survey survey : surveyList) {
            Item item = container.addItem(survey);
            item.getItemProperty("id").setValue(survey.getId());
            item.getItemProperty("name").setValue(survey.getName());

            Button selectButton = buildSelectButton(survey);
            item.getItemProperty("select").setValue(selectButton);

            Button updateButton = buildUpdateButton(survey);
            item.getItemProperty("update").setValue(updateButton);
        }
    }
    private Button buildSelectButton(Survey survey){
        Button select = new Button();
        select.setIcon(FontAwesome.CHECK);
        select.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                OpenSurvey openSurvey= new OpenSurvey(survey);
                MyUI myUI = (MyUI) MyUI.getCurrent();
                myUI.setUseSurvey(survey);
                myUI.getBody().removeAllComponents();
                myUI.getBody().addComponent(openSurvey);
            }
        });
        return select;
    }
    private Button buildUpdateButton(Survey survey){
        Button update = new Button();
        update.setIcon(FontAwesome.EDIT);
        update.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                MyUI myUI = (MyUI) MyUI.getCurrent();
                myUI.setUseSurvey(survey);
            }
        });
        return update;
    }
    private void buildMainLayout() {
        mainLayout = new VerticalLayout();
        mainLayout.setSizeUndefined();
        buildTable();
        mainLayout.addComponent(table);
    }

    private void buildTable() {
        table = new Table();
        table.setSelectable(true);

        buildContainer();
        table.setContainerDataSource(container);
        table.setColumnHeaders("ID", "ANKET", "", "");
    }

    private void buildContainer() {
        container = new IndexedContainer();
        container.addContainerProperty("id", Long.class, null);
        container.addContainerProperty("name", String.class, null);
        container.addContainerProperty("select", Button.class, null);
        container.addContainerProperty("update", Button.class, null);
    }
    public Table getTable() {
        return table;
    }
}