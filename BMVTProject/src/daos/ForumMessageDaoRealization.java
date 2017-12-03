package daos;

import entities.ForumMessage;
import entities.Level;
import interfaces.ForumMessageDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 27.11.2017 -> 1:28
 * KPFU ITIS 11-601
 **/


public class ForumMessageDaoRealization implements ForumMessageDao {

    @Override
    public ForumMessage create() {
        return null;
    }

    @Override
    public ForumMessage read(int key) {
        return null;
    }

    @Override
    public ForumMessage read(String title) {
        return null;
    }

    @Override
    public ForumMessage read(boolean isPopular) {
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
