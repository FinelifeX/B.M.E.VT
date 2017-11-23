package interfaces;

import entities.ForumMessage;
import entities.Level;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:09
 * KPFU ITIS 11-601
 **/


public interface ForumMessageDao {

    public ForumMessage create();

    public ForumMessage read(int key);

    public ForumMessage read(String title);

    public ForumMessage read(boolean isPopular);

    public void update(Level level);

    public void delete(Level level);

    public List<Level> getAll() throws SQLException;
}
