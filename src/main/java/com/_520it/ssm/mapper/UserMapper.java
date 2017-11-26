package com._520it.ssm.mapper;

import com._520it.ssm.domain.User;
import com._520it.ssm.query.UserQueryObject;

import java.util.List;


public interface UserMapper {


    void save(User user);
    void update(User user);

    void delete(Long id);
    User get(Long id);
    List<User> list();


    int queryForCount(UserQueryObject qo);
    List<User> queryForList(UserQueryObject qo);

}
