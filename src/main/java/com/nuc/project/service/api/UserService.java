package com.nuc.project.service.api;

import com.nuc.project.entity.User;

import java.util.List;

/**
 * @author 高赟帅
 * @create 2022-12-21-21:50
 */
public interface UserService {

    //根据登录信息查询用户并返回
    User selectUserByLoginAccount(String loginUserId, String loginPassword);

    //根据注册账号查询账号用户是否存在
    boolean selectUserByRegisterAccount(String registerUserId);

    //增添用户信息
    int registerUser(User user);

    //根据userId查询用户user
    User getUserByUserId(String userId);

    //返回所有用户信息
    List<User> showAllUser();

    //删除指定id的用户
    int deleteUserByUserId(String userId);

    //将指定id的用户改为管理员
    int updateState0(String userId);

    //将指定id的管理员改为普通用户
    int updateState1(String userId);
}
