package com._520it.ssm.domain;

import lombok.*;



public class User {

    private Long id;
    private  String name;
    private Integer age;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
