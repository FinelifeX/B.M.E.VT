package daos;

import entities.User;
import entities.UserLoginData;
import interfaces.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:33
 * KPFU ITIS 11-601
 **/


public class UserDaoRealization implements UserDao {
    @Override
    public User create() {
        return null;
    }

    @Override
    public User read(int id, Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT user_profile.id, user_profile.username, user_profile.email, user_profile.isadmin, " +
                        "user_profile.pic_url, user_profile.token, user_login.user_password" +
                        " FROM user_profile LEFT JOIN user_login ON user_profile.id = user_login.user_id" +
                        " HAVING user_profile.id = ?"
        );
        statement.setInt(1, id);
        ResultSet set = statement.executeQuery();
        User result = new User();
        UserLoginData loginData = new UserLoginData();
        if (set.next()) {
            loginData.setId(set.getInt("user_login.user_id"));
            loginData.setPassword(set.getString("user_login.user_password"));
            result.setId(set.getInt("user_profile.id"));
            result.setUsername(set.getString("user_profile.username"));
            result.setEmail(set.getString("user_profile.email"));
            result.setAdmin(set.getBoolean("user_profile.isadmin"));
            result.setPicUrl(set.getString("user_profile.pic_url"));
            result.setToken(set.getString("user_profile.token"));
            result.setLoginData(loginData);
            return result;
        }
        return null;
    }

    @Override
    public User read(String username) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> getAll() throws SQLException {
        return null;
    }
}
