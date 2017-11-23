package entities;

/**
 * Created by Bulat Murtazin on 22.11.2017 -> 23:07
 * KPFU ITIS 11-601
 **/


public class Level {

    private int id;

    private String title;

    private String content;

    private int user_id;

    public Level(int id, String title, String content, int user_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
