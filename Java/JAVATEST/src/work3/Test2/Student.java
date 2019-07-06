package work3.Test2;

/**
 * @ClassName Student
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 16:18
 * @Version 1.0
 */
public class Student {
    private Integer num ;
    private String name;
    private Integer score;

    public Student() {
    }

    public Student(Integer num, String name, Integer score) {
        this.num = num;
        this.name = name;
        this.score = score;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
