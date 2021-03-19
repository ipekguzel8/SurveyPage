package com.uniyaz.Ui.Page;

import com.vaadin.ui.VerticalLayout;

/**
 * Created by ipekg on 2021
 */
public abstract class BasePage extends VerticalLayout {
    public BasePage() {
        setSizeFull();
    }
    public abstract void buildPage();
}
