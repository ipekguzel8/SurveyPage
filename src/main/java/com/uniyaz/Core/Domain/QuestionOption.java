package com.uniyaz.Core.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ipekg on 2021
 */
@Entity
@Table(name = "QUESTION_OPTION")
public class QuestionOption extends BaseEntity{
    public void setId(Long id) {
        this.id = id;
    }

    public SurveyQuestion getSurveyQuestion() {
        return surveyQuestion;
    }

    public void setSurveyQuestion(SurveyQuestion surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    @Override
    public Long getId() {
        return null;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_QUESTION", foreignKey = @ForeignKey(name = "FK_QUESTION_OPTION_QUESTION"))
    private SurveyQuestion surveyQuestion;

    @Column(name = "OPTION_TEXT")
    @NotNull
    private String optionText;
}
