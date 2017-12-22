package repositories;

import entities.Course;
import entities.Level;
import helpers.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 07.12.2017 -> 23:40
 * KPFU ITIS 11-601
 **/


public class CourseRepository {

    private static CourseRepository repository;

    private Connection connection;

    public CourseRepository() {
        this.connection = DbHelper.getConnection();
    }

    public static CourseRepository getRepository() {
        if (repository == null) {
            repository = new CourseRepository();
        }
        return repository;
    }

    public int createCourse(Course course) {

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO course (lang, lvl_id) VALUES (?, ?)"
            );
            statement.setString(1, course.getLanguage());
            statement.setInt(2, course.getLevel_id());
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int id = set.getInt("id");
                System.out.println("Course with id " + id + " is created");
                return id;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
