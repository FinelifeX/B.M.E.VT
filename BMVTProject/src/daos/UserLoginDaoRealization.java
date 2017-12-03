package daos;

import entities.UserLoginData;
import interfaces.UserLoginDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:35
 * KPFU ITIS 11-601
 **/


public class UserLoginDaoRealization implements UserLoginDao {
    @Override
    public UserLoginData create() {
        return null;
    }

    @Override
    public UserLoginData read(int user_id, Connection connection) {
        return null;
    }

    @Override
    public void update(UserLoginData loginData) {

    }

    @Override
    public void delete(UserLoginData loginData) {

    }

    @Override
    public List<UserLoginData> getAll() throws SQLException {
        return null;
    }
}
