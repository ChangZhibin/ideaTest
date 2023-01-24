package com.nuc.project.dao.api;

import com.nuc.project.entity.User;

import java.util.List;

/**
 * @author 高赟帅
 * @create 2022-12-21-21:53
 */
public interface UserDao {

    //根据登录信息查询用户并返回
    User selectUserByLoginAccount(String loginUserId, String loginPassword);

    //根据注册账号查询账号用户并返回
    User selectUserByRegisterAccount(String registerUserId);

    //增添用户信息
    int registerUser(User user);

    //返回所有用户信息
    List<User> showAllUser();

    //删除指定id的用户
    int deleteUserByUserId(String userId);

    //将指定id的用户改为管理员
    int updateState0(String userId);

    //将指定id的管理员改为普通用户
    int updateState1(String userId);
}
