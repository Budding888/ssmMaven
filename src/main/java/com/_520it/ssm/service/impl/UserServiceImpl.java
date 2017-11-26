package com._520it.ssm.service.impl;



import com._520it.ssm.domain.User;
import com._520it.ssm.mapper.UserMapper;
import com._520it.ssm.query.PageResult;
import com._520it.ssm.query.UserQueryObject;
import com._520it.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;


    public void save(User user) {
        mapper.save(user);
    }

    public void update(User user) {
        mapper.update(user);
    }

    public void delete(Long id) {
        mapper.delete(id);
    }

    public User get(Long id) {
        User user = mapper.get(id);
        return user;
    }

    public List<User> list() {
        List<User> list = mapper.list();
        return list;
    }



    public PageResult query(UserQueryObject qo) {
        int totalCount  = mapper.queryForCount(qo);
        if (totalCount==0){
          return  PageResult.empty(qo.getCurrentPage(),qo.getPageSize())  ;
        }
        else {
            List<User> list = mapper.queryForList(qo);
            return new PageResult(list,totalCount,qo.getCurrentPage(),qo.getPageSize());
        }
    }
}
