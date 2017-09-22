package com.panodata.service.user.impl;

import com.panodata.mapper.UserPOMapper;
import com.panodata.model.UserPO;
import com.panodata.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wp_sp on 2017/9/21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPOMapper userPOMapper;


    @Override
    public List<UserPO> findAll() {
        return userPOMapper.findAll();
    }

    @Override
    public UserPO findById(String id) {
        return userPOMapper.findById(id);
    }

    @Override
    public int save(UserPO userPO) {
        return userPOMapper.insert(userPO);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserPO findByIdAndName(String id, String name) {
        return userPOMapper.findByIdAndName(id,name);
    }

    @Override
    public int updateUserById(String id, String name, String tel) {
        return userPOMapper.updateUserById(id,name,tel);
    }
}
