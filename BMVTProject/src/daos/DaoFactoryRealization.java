package daos;

import interfaces.*;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:27
 * KPFU ITIS 11-601
 **/


public class DaoFactoryRealization implements DaoFactory {

    private String user = "postgres";

    private String password = "postgres";

    private String url = "jdbc:postgresql://localhost:5432/BMEVT";

    private String driver = "org.postgresql.Driver";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public UserDao getUserDao(Connection connection) {
        return null;
    }

    @Override
    public UserLoginDao getUserLoginDao(Connection connection) {
        return null;
    }

    @Override
    public CourseDao getCourseDao(Connection connection) {
        return null;
    }

    @Override
    public LevelDao getLevelDao(Connection connection) {
        return null;
    }

    @Override
    public LearningDao getLearningDao(Connection connection) {
        return null;
    }

    @Override
    public ForumMessageDao getForumMessageDao(Connection connection) {
        return null;
    }
}
