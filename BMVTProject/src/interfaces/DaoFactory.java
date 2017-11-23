package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 22.11.2017 -> 23:43
 * KPFU ITIS 11-601
 **/


public interface DaoFactory {

    public Connection getConnection() throws SQLException;

    public UserDao getUserDao(Connection connection);

    public UserLoginDao getUserLoginDao(Connection connection);

    public CourseDao getCourseDao(Connection connection);

    public LevelDao getLevelDao(Connection connection);

    public LearningDao getLearningDao(Connection connection);

    public ForumMessageDao getForumMessageDao(Connection connection);
}
