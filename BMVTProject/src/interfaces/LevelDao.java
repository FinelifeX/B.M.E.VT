package interfaces;

import entities.Level;
import entities.User;
import servlets.LogoutServlet;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Bulat Murtazin on 23.11.2017 -> 0:09
 * KPFU ITIS 11-601
 **/


public interface LevelDao {

    public Level create();

    public Level read(int id);

    public Level read(String title);

    public void update(Level level);

    public void delete(Level level);

    public List<Level> getAll() throws SQLException;
}
