package daos;

import entities.Course;
import interfaces.CourseDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 27.11.2017 -> 1:25
 * KPFU ITIS 11-601
 **/


public class CourseDaoRealization implements CourseDao{

    @Override
    public Course create() {
        return null;
    }

    @Override
    public Course read(int id) {
        return null;
    }

    @Override
    public Course read(String lang) {
        return null;
    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void delete(Course course) {

    }

    @Override
    public List<Course> getAll() throws SQLException {
        return null;
    }
}
