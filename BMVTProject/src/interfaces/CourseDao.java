package interfaces;

import entities.Course;
import entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:09
 * KPFU ITIS 11-601
 **/


public interface CourseDao {

    public Course create();

    public Course read(int id);

    public Course read(String lang);

    public void update(Course course);

    public void delete(Course course);

    public List<Course> getAll() throws SQLException;
}
