package com.uniyaz.Core.Domain;

import javax.persistence.*;

/**
 * Created by ipekg on 2021
 */
@Entity
@Table(name = "USER_SURVEY")
public class UserSurvey extends BaseEntity{
    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public Long getId() {
        return null;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", foreignKey = @ForeignKey(name = "FK_USER_SURVEY_USER"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SURVEY", foreignKey = @ForeignKey(name = "FK_USER_SURVEY_SURVEY"))
    private Survey survey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_QESTION", foreignKey = @ForeignKey(name = "FK_USER_SURVEY_QUESTION"))
    private Question question;

    @Column(name = "REPLY")
    private String reply;



}
