package com.uniyaz.Core.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by ipekg on 2021
 */
@Entity
@Table(name="QUESTION")
public class Question extends BaseEntity{
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME")
    @NotNull
    private String name;

    @Column(name = "TYPE")
    @NotNull
    private  String type;

    public String getType() {
        return type;
    }

    public void setType(String turu) {
        this.type = turu;
    }

    @Override
    public Long getId() {
        return id;
    }
}
