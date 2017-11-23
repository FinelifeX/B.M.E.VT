package daos;

import entities.User;
import interfaces.UserDao;

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
    public User read(int id) {
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
