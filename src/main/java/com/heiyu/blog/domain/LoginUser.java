package com.heiyu.blog.domain;


import java.util.Objects;


public class LoginUser {

    private String username;
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginUser(){}

    public LoginUser(String username, String password){
        this.username=username;
        this.password=password;
    }

    @Override
    public String toString(){
        return "{\"username\":\""+username+"\",\"password\":\""+password+"\"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoginUser loginUser = (LoginUser) o;
        return Objects.equals(username, loginUser.username) &&
                Objects.equals(password, loginUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }


    /** todo 将loginUser与User合并
     *
     */
}
