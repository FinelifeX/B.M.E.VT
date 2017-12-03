package daos;

import entities.Level;
import interfaces.LevelDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 27.11.2017 -> 1:28
 * KPFU ITIS 11-601
 **/


public class LevelDaoRealization implements LevelDao {

    @Override
    public Level create() {
        return null;
    }

    @Override
    public Level read(int id) {
        return null;
    }

    @Override
    public Level read(String title) {
        return null;
    }

    @Override
    public void update(Level level) {

    }

    @Override
    public void delete(Level level) {

    }

    @Override
    public List<Level> getAll() throws SQLException {
        return null;
    }
}
