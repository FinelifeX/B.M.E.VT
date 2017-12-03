package interfaces;

import entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:02
 * KPFU ITIS 11-601
 **/


public interface UserDao {

    public User create();

    public User read(int id, Connection connection) throws SQLException;

    public User read(String username);

    public void update(User user);

    public void delete(User user);

    public List<User> getAll() throws SQLException;
}
