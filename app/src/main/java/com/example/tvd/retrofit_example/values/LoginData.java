package com.example.tvd.retrofit_example.values;

public class LoginData {
    private String UserName;
    private String UserPassword;
    private String Group;

    public LoginData(String UserName, String UserPassword, String Group)
    {
        this.UserName = UserName;
        this.UserPassword = UserPassword;
        this.Group = Group;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getGroup() {
        return Group;
    }

    public void setGroup(String group) {
        Group = group;
    }
}
