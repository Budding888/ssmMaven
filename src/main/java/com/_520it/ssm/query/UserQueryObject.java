package com._520it.ssm.query;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserQueryObject extends Query {


    private String  keyword ;
    private Integer minAge;
    private Integer maxAge;


}
