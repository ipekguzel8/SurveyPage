package com.uniyaz.Ui.Page;

import com.uniyaz.Ui.Component.SPMenuBar;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by ipekg on 2021
 */
public class Header extends VerticalLayout {
    public Header() {
        SPMenuBar spMenuBar= new SPMenuBar();
        addComponent(spMenuBar);
    }

}
