package com.uniyaz.Ui.Page;

import com.uniyaz.Ui.MyUI;
import com.vaadin.ui.*;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ipekg on 2021
 */
public class ViewSurvey extends VerticalLayout {
    Label words= new Label("");
    Button button= new Button("Selamlar");
    public void setWord(String word) {
        words.setValue(word);
    }
    public ViewSurvey() {
        addComponent(words);
    }
    @Override
    public void addComponent(Component c) {
        super.addComponent(c);
        words.setValue("");
    }
}
