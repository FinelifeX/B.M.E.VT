package repositories;

import entities.Level;
import helpers.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 07.12.2017 -> 23:25
 * KPFU ITIS 11-601
 **/


public class LevelRepository {

    private static LevelRepository repository;

    private Connection connection;

    public LevelRepository() {
        this.connection = DbHelper.getConnection();
    }

    public static LevelRepository getRepository() {

        if (repository == null) {
            repository = new LevelRepository();
        }
        return repository;
    }

    public int createLevel(Level level) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO level (title, content) VALUES (?, ?)"
            );
            statement.setString(1, level.getTitle());
            statement.setString(2, level.getContent());
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int id = set.getInt("id");
                System.out.println("Level with id " + id + " is created.");
                return id;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
