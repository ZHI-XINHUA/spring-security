package com.immoc.dto;

/**
 * Created by zhixinhua on 18/1/21.
 * 用户查询条件
 */
public class UserQueryCondition {
    private  String userName;
    private  int age;
    private int ageTo;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeTo() {
        return ageTo;
    }

    public void setAgeTo(int ageTo) {
        this.ageTo = ageTo;
    }
}
