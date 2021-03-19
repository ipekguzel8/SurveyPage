package com.uniyaz.Ui.Page;

import com.uniyaz.Core.Domain.User;
import com.uniyaz.Core.Service.UserService;
import com.uniyaz.Ui.MyUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by ipekg on 2021
 */
public class UserLoginPage extends VerticalLayout {
    public UserLoginPage() {
        User user= new User();
        SurveyList surveyList= new SurveyList();
        TextField userName= new TextField("E-mail");
        setSpacing(true);
        Button login= new Button("Giriş Yap");
        login.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                user.setName(userName.getValue());
                UserService userService= new UserService();
                userService.save(user);
                MyUI current = (MyUI) MyUI.getCurrent();
                Body body = current.getBody();
                body.removeAllComponents();
                body.addComponent(surveyList);
            }
        });
        addComponent(userName);
        addComponent(login);
    }
}
