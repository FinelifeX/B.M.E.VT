package entities;

/**
 * Created by Bulat Murtazin on 22.11.2017 -> 22:52
 * KPFU ITIS 11-601
 **/


public class User {

    private int id;

    private String username;

    private String email;

    private boolean isAdmin;

    private String picUrl;

    private String token;

    private UserLoginData loginData;

    public User(String username, String email, UserLoginData loginData) {
        this.username = username;
        this.email = email;
        this.isAdmin = false;
        this.picUrl = "";
        this.loginData = loginData;
    }

    public User(int id, String username, String email, boolean isAdmin, String picUrl, String token, UserLoginData loginData) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.isAdmin = isAdmin;
        this.picUrl = picUrl;
        this.token = token;
        this.loginData = loginData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserLoginData getLoginData() {
        return loginData;
    }

    public void setLoginData(UserLoginData loginData) {
        this.loginData = loginData;
    }
}
