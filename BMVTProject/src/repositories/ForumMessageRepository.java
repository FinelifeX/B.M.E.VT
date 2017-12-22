package repositories;

import entities.ForumMessage;
import entities.User;
import helpers.DbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Bulat Murtazin on 07.12.2017 -> 23:16
 * KPFU ITIS 11-601
 **/


public class ForumMessageRepository {

    private static ForumMessageRepository repository;

    private Connection connection;

    public ForumMessageRepository() {
        this.connection = DbHelper.getConnection();
    }

    public static ForumMessageRepository getRepository() {
        if (repository == null) {
            repository = new ForumMessageRepository();
        }
        return repository;
    }

    public int createForumMessage(ForumMessage message) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO forum_message (user_id, topic, topic_content, popular) VALUES (?, ?, ?, ?)"
            );
            statement.setInt(1, message.getUser_id());
            statement.setString(2, message.getTopic());
            statement.setString(3, message.getContent());
            statement.setBoolean(4, message.isPopular());
            ResultSet set = statement.executeQuery();
            if (set.next()) {
                int id = set.getInt("id");
                System.out.println("Message by user with id " + id + " is created.");
                return  id;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
