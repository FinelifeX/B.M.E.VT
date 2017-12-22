package helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 05.12.2017 -> 0:59
 * KPFU ITIS 11-601
 **/


public class DbHelper {
    private final static String dbURL = "jdbc:postgresql://localhost:5432/BMEVT";
    private final static String user = "postgres";
    private final static String password = "postgres";

    private static Connection connection;

    private DbHelper() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(dbURL, user, password);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
