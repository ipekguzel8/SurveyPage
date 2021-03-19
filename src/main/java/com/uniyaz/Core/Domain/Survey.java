package com.uniyaz.Core.Domain;

import javax.persistence.*;

/**
 * Created by ipekg on 2021
 */
@Entity
@Table(name="SURVEY")
public class Survey extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }
}
