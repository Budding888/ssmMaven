package com._520it.ssm.service;



import com._520it.ssm.domain.User;
import com._520it.ssm.query.PageResult;
import com._520it.ssm.query.UserQueryObject;

import java.util.List;


public interface IUserService {

    void save(User user);
    void update(User user);
    void delete(Long id);
    User get(Long id);
    List<User> list();

   PageResult query(UserQueryObject qo);

}
