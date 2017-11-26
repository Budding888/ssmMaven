package com._520it.ssm.query;


import com._520it.ssm.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {

    private  int currentPage = 1;
    private  int pageSize = 3;

    private int prevPage;
    private int nextPage;
    private int totalPage;

    private int totalCount;
    private List<User> list;

    public PageResult(List<User> list, int totalCount, int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.list=list;

        this.totalPage = totalCount % pageSize == 0 ?  totalCount / pageSize : totalCount / pageSize +1  ;
        this.prevPage = currentPage -1 > 0 ? currentPage -1: 1;
        this.nextPage = currentPage + 1 > totalPage ? totalPage : currentPage + 1;
    }


    public static PageResult empty(int currentPage, int pageSize){
        return new PageResult(Collections.EMPTY_LIST,0,currentPage, pageSize);
    }

}
