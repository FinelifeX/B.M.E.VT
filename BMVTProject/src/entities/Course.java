package entities;

/**
 * Created by Bulat Murtazin on 22.11.2017 -> 23:01
 * KPFU ITIS 11-601
 **/


public class Course {

    private int id;

    private String language;

    private int level_id;

    public Course(int id, String language, int level_id) {
        this.id = id;
        this.language = language;
        this.level_id = level_id;
    }

    public Course(int id) {
        this.id = id;
        this.language = "english";
        this.level_id = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLevel_id() {
        return level_id;
    }

    public void setLevel_id(int level_id) {
        this.level_id = level_id;
    }
}
