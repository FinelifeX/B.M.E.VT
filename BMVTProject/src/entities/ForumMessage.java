package entities;

/**
 * Created by Bulat Murtazin on 22.11.2017 -> 23:10
 * KPFU ITIS 11-601
 **/


public class ForumMessage {

    private int id;

    private int user_id;

    private String topic;

    private String content;

    private boolean isPopular;

    public ForumMessage(int id, int user_id, String topic, String content, boolean isPopular) {
        this.id = id;
        this.user_id = user_id;
        this.topic = topic;
        this.content = content;
        this.isPopular = isPopular;
    }

    public ForumMessage(int id, int user_id, String topic, String content) {
        this.id = id;
        this.user_id = user_id;
        this.topic = topic;
        this.content = content;
        this.isPopular = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isPopular() {
        return isPopular;
    }

    public void setPopular(boolean popular) {
        isPopular = popular;
    }
}
