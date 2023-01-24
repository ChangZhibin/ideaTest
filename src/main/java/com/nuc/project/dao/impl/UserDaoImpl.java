package com.nuc.project.dao.impl;

import com.nuc.project.dao.BaseDao;
import com.nuc.project.dao.api.UserDao;
import com.nuc.project.entity.User;

import java.util.List;

/**
 * @author 高赟帅
 * @create 2022-12-21-21:53
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    //根据登录信息查询用户并返回
    public User selectUserByLoginAccount(String loginUserId, String loginPassword) {
        //编写sql语句
        String sql = "select user_id userId," +
                " password ,NAME, sex," +
                " phone, permission " +
                "from user " +
                "where user_id = ? and password = ?";

        return super.getSingleBean(sql, User.class, loginUserId, loginPassword);
    }
    //根据注册账号查询账号用户并返回
    public User selectUserByRegisterAccount(String registerUserId) {
        //编写sql语句
        String sql = "select user_id userId," +
                " password ,NAME, sex," +
                " phone, permission " +
                "from user " +
                "where user_id = ?";

        return super.getSingleBean(sql, User.class, registerUserId);
    }
    //增添用户信息
    public int registerUser(User user) {
        //编写sql语句
        String sql = "insert into user(user_id, password, name, sex, phone)\n" +
                "values (?,?,?,?,?);";

        return super.update(sql, user.getUserId(),user.getPassword(),user.getName(),user.getSex(),user.getPhone());
    }

    public List<User> showAllUser() {
        String sql = "select user_id userId," +
                " password ,NAME, sex," +
                " phone, permission " +
                "from user ";
        return super.getBeanList(sql,User.class);
    }

    public int deleteUserByUserId(String userId) {
        String sql = "delete from user where user_id = ?";

        return super.update(sql,userId);
    }

    public int updateState0(String userId) {
        String sql = "update user set permission = 0 where user_id = ?";

        return super.update(sql,userId);
    }

    public int updateState1(String userId) {
        String sql = "update user set permission = 1 where user_id = ?";

        return super.update(sql,userId);
    }


}
