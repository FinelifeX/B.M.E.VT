package entities;

/**
 * Created by Bulat Murtazin on 22.11.2017 -> 22:57
 * KPFU ITIS 11-601
 **/


public class UserLoginData {

    private int id;

    private int user_id;

    private String password;

    public UserLoginData(int id, int user_id, String password) {
        this.id = id;
        this.user_id = user_id;
        this.password = password;
    }

    public UserLoginData(int user_id, String password) {
        this.user_id = user_id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
