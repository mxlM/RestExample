package com.panodata.service.user;


import com.panodata.model.UserPO;

import java.util.List;

/**
 * Created by wp_sp on 2017/9/21.
 */
public interface UserService {
    List<UserPO> findAll();

    UserPO findById(String id);

    int save(UserPO userPO);

    void delete(Long id);

    UserPO findByIdAndName(String id, String name);

    int updateUserById(String id, String name, String tel);
}
