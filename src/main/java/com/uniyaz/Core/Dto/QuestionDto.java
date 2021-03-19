package com.uniyaz.Core.Dto;

/**
 * Created by ipekg on 2021
 */
public class QuestionDto {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
