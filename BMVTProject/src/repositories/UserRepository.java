package repositories;

import entities.User;
import entities.UserLoginData;
import helpers.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 05.12.2017 -> 1:17
 * KPFU ITIS 11-601
 **/


public class UserRepository {

    private static UserRepository repository;

    private Connection connection;

    private UserRepository() {
        this.connection = DbHelper.getConnection();
    }

    public static UserRepository getRepository()  {
        if (repository == null) {
            repository = new UserRepository();
        }
        return repository;
    }

    public int createUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO user_profile (username, email, isadmin) VALUES (?, ?, ?) RETURNING id"
            );
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setBoolean(3, user.isAdmin());
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int id = set.getInt("id");
                System.out.println("User with id " + id + " is created.");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public User getById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM user_profile WHERE id = ?"
            );
            statement.setInt(1, id);
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int userId = set.getInt("id");
                String username = set.getString("username");
                String email = set.getString("email");
                Boolean isAdmin = set.getBoolean("isadmin");
                String picUrl = set.getString("pic_url");
                String token = set.getString("token");
                UserLoginData loginData = LoginDataRepository.getRepository().getByUserId(userId);
                return new User(userId, username, email, isAdmin, picUrl, token, loginData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
