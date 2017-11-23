package interfaces;

import entities.Learning;
import entities.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:09
 * KPFU ITIS 11-601
 **/


public interface LearningDao {

    public Learning create();

    public Learning read(int key);

    public void update(Learning learning);

    public void delete(Learning learning);

    public List<Learning> getAll() throws SQLException;
}
