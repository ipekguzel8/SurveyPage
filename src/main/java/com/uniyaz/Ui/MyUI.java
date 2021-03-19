package com.uniyaz.Ui;

import javax.servlet.annotation.WebServlet;
import com.uniyaz.Core.Domain.Survey;
import com.uniyaz.Core.Domain.User;
import com.uniyaz.Ui.Page.Body;
import com.uniyaz.Ui.Page.Header;
import com.uniyaz.Ui.Page.MainPage;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("com.uniyaz.MyAppWidgetset")
public class MyUI extends UI {
    private Survey useSurvey= new Survey();
    private User user = new User();
    public Survey getUseSurvey() {
        return useSurvey;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser(){ return user;}

    public void setUseSurvey(Survey useSurvey) {
        this.useSurvey = useSurvey;
    }

    private Header header=new Header();

    public Header getHeader() {
        return header;
    }

    public Body getBody() {
        return body;
    }

    private Body body= new Body();
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        MainPage mainPage=new MainPage();
        setContent(mainPage);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
