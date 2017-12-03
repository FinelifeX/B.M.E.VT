package interfaces;

import entities.User;
import entities.UserLoginData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:08
 * KPFU ITIS 11-601
 **/


public interface UserLoginDao {

    public UserLoginData create();

    public UserLoginData read(int user_id, Connection connection);

    public void update(UserLoginData loginData);

    public void delete(UserLoginData loginData);

    public List<UserLoginData> getAll() throws SQLException;
}
