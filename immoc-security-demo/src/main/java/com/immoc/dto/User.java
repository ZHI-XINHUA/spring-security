package com.immoc.dto;

/**
 * Created by zhixinhua on 18/1/21.
 */
public class User {

    private String userName;

    private String password;

    public User(){

    }

    public User(String userName,String password){
        this.userName = userName;
        this.password = password;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
