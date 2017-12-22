package repositories;

import entities.Learning;
import helpers.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 07.12.2017 -> 23:47
 * KPFU ITIS 11-601
 **/


public class LearningRepository {

    private static LearningRepository repository;

    private Connection connection;

    public LearningRepository() {
        this.connection = DbHelper.getConnection();
    }

    public static LearningRepository getRepository() {
        if (repository == null) {
            repository = new LearningRepository();
        }
        return repository;
    }

    public int createLearning(Learning learning) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO learning (user_id, course_id) VALUES (?, ?)"
            );
            statement.setInt(1, learning.getUser_id());
            statement.setInt(2, learning.getCourse_id());
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int id = set.getInt("id");
                System.out.println("Learning with id " + id + " is created.");
                return id;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
