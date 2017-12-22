package repositories;

import entities.User;
import entities.UserLoginData;
import helpers.DbHelper;
import helpers.PasswordHasher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 05.12.2017 -> 1:11
 * KPFU ITIS 11-601
 **/


public class LoginDataRepository {

    private static LoginDataRepository repository;

    private Connection connection;

    private LoginDataRepository() {
        this.connection = DbHelper.getConnection();
    }

    public static LoginDataRepository getRepository() {
        if (repository == null) {
            repository = new LoginDataRepository();
        }
        return repository;
    }

    public int createLoginData(UserLoginData loginData, User user) {
        byte[] salt = PasswordHasher.getSalt();
        String hashedPassword = PasswordHasher.getHashedPassword(loginData.getPassword(), salt);
        loginData.setPassword(hashedPassword);
        try {
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO user_login (user_id, user_password) VALUES (?, ?) RETURNING user_id"
            );
            statement.setInt(1, user.getId());
            statement.setString(2, loginData.getPassword());
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int user_id = set.getInt("user_id");
                System.out.println("Password is created for user with id " + user_id);
                return user_id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public UserLoginData getByUserId(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user_login WHERE user_id = ?"
            );
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int dataId = set.getInt("id");
                int userId = set.getInt("user_id");
                String userPass = set.getString("user_password");
                String salt = set.getString("salt");
                return new UserLoginData(dataId, userId, userPass, salt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
