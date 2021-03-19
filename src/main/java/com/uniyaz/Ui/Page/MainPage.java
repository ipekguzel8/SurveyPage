package com.uniyaz.Ui.Page;

import com.uniyaz.Ui.MyUI;
import com.vaadin.ui.UI;

/**
 * Created by ipekg on 2021
 */
public class MainPage extends BasePage{
    @Override
    public void buildPage() {
        MyUI current = (MyUI) UI.getCurrent();
        Header header= current.getHeader();
        Body body=current.getBody();
        Footer footer= new Footer();
        addComponent(header);
        addComponent(body);
        addComponent(footer);
        setExpandRatio(header,1f);
        setExpandRatio(body,8f);
        setExpandRatio(footer,1f);
    }

    public MainPage() {
        buildPage();
    }
}
