package com.nuc.project.service.impl;

import com.nuc.project.dao.api.UserDao;
import com.nuc.project.dao.impl.UserDaoImpl;
import com.nuc.project.entity.User;
import com.nuc.project.exception.LoginFailedException;
import com.nuc.project.service.api.UserService;
import com.nuc.project.util.ImperialCourtConst;

import java.awt.image.ImagingOpException;
import java.util.List;

/**
 * @author 高赟帅
 * @create 2022-12-21-21:50
 */
public class UserServiceImpl implements UserService {

    UserDaoImpl userDao = new UserDaoImpl();

    //根据登录信息查询用户并返回
    public User selectUserByLoginAccount(String loginUserId, String loginPassword) {

        User user = userDao.selectUserByLoginAccount(loginUserId, loginPassword);

        if( user != null){
            //不为空，则返回此对象
            return user;
        }else{
            //为空，则抛出失败异常
            throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
        }
    }

    //根据注册账号查询账号用户是否存在
    public boolean selectUserByRegisterAccount(String registerUserId) {
        User user = userDao.selectUserByRegisterAccount(registerUserId);

        if(user != null){
            //不为空，则抛出异常,返回存在
//            throw new LoginFailedException(ImperialCourtConst.LOGIN_FAILED_MESSAGE);
            return true;
        }else{
            //为空，则返回不存在
            return false;
        }
    }

    //增添用户信息,注册功能中用
    public int registerUser(User user) {
        return userDao.registerUser(user);
    }

    //根据userId查询user
    public User getUserByUserId(String userId) {
        return userDao.selectUserByRegisterAccount(userId);
    }

    //得到所有用户
    public List<User> showAllUser() {
        return userDao.showAllUser();
    }

    public int deleteUserByUserId(String userId) {
        return userDao.deleteUserByUserId(userId);
    }

    public int updateState0(String userId) {
        return userDao.updateState0(userId);
    }

    public int updateState1(String userId) {
        return userDao.updateState1(userId);
    }
}
