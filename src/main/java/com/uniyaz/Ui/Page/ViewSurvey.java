package com.uniyaz.Ui.Page;

import com.vaadin.ui.*;

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
