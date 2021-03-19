package com.uniyaz.Ui.Component;

import com.uniyaz.Ui.MyUI;
import com.uniyaz.Ui.Page.*;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

/**
 * Created by ipekg on 2021
 */
public class SPMenuBar extends MenuBar {
    public SPMenuBar() {

        addItem("Anket Yap", FontAwesome.EDIT, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                UserLoginPage userLoginPage= new UserLoginPage();
                Body body = MyUi().getBody();
                body.removeAllComponents();
                body.addComponent(userLoginPage);
            }
        });
        addItem("Anket Oluştur", FontAwesome.PLUS, new Command() {
            @Override
            public void menuSelected(MenuItem menuItem) {
                SurveyHeaderVL surveyHeaderVL= new SurveyHeaderVL();
                Content content = MyUi().getBody().getContent();
                content.removeAllComponents();
                content.addComponent(surveyHeaderVL);
                content.setComponentAlignment(surveyHeaderVL, Alignment.MIDDLE_CENTER);
            }
        });
    }
    public MyUI MyUi(){
        MyUI current = (MyUI) UI.getCurrent();
        return current;
    }
}
