package entities;

/**
 * Created by Bulat Murtazin on 22.11.2017 -> 23:08
 * KPFU ITIS 11-601
 **/


public class Learning {

    private int user_id;

    private int course_id;

    public Learning(int user_id, int course_id) {
        this.user_id = user_id;
        this.course_id = course_id;
    }

    public Learning(int user_id) {
        this.user_id = user_id;
        this.course_id = 1;
    }
}
