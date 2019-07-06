package day13;

/**
 * @ClassName Student
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/3 19:39
 * @Version 1.0
 */
public class Student  {
    public String num;
    public Integer score;

    public Student() {
    }

    public Student(String  num, Integer score) {
        this.num = num;
        this.score = score;
    }

//    @Override
//    public int compareTo(Student o) {
//        if(this.score.compareTo(o.score)!=0)
//            return -this.score.compareTo(o.score);
//        else
//            return 0;
//    }
}
