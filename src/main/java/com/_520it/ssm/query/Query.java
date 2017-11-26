package com._520it.ssm.query;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Query  {

    private  int currentPage = 1;
    private  int pageSize = 3;

    private int getStartIndex(){
        return (currentPage - 1)*pageSize;
    }


}
