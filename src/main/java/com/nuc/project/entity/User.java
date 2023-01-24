package com.nuc.project.entity;

/**
 * @author 赵梓博
 * @create 2022-12-21-17:14
 * 用户实体
 */
public class User {
    private String userId;
    private String password;
    private String name;
    private String sex;
    private String phone;
    private String permission;

    public User() {
    }

    public User(String userId, String password, String name, String sex, String phone) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
