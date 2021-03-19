package com.uniyaz.Core.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ipekg on 2021
 */
@Entity
@Table(name="SurveyQuestion")
public class SurveyQuestion extends BaseEntity{
    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public Long getId() {
        return id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SURVEY", foreignKey = @ForeignKey(name = "FK_SURVEY_QUESTION_SURVEY"))
    private Survey survey;

    @Column(name = "QUESTIONTEXT")
    @NotNull
    private String questionText;

    @Column(name = "QUESTIONTYPE")
    @NotNull
    private  String type;
}
