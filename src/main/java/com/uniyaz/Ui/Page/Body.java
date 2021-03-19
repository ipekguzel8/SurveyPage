package com.uniyaz.Ui.Page;

import com.vaadin.ui.HorizontalLayout;

/**
 * Created by ipekg on 2021
 */
public class Body extends HorizontalLayout {
    public ViewSurvey getViewSurvey() {
        return viewSurvey;
    }

    Content content= new Content();
    ViewSurvey viewSurvey= new ViewSurvey();
    public Body() {
        setSizeFull();
        addComponent(content);
        addComponent(viewSurvey);
        setExpandRatio(content,5f);
        setExpandRatio(viewSurvey,5f);
    }

    public Content getContent() {
        return content;
    }
}
