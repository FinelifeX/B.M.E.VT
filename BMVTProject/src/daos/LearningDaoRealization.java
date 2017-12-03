package daos;

import entities.Learning;
import interfaces.LearningDao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 27.11.2017 -> 1:26
 * KPFU ITIS 11-601
 **/


public class LearningDaoRealization implements LearningDao {

    @Override
    public Learning create() {
        return null;
    }

    @Override
    public Learning read(int key) {
        return null;
    }

    @Override
    public void update(Learning learning) {

    }

    @Override
    public void delete(Learning learning) {

    }

    @Override
    public List<Learning> getAll() throws SQLException {
        return null;
    }
}
