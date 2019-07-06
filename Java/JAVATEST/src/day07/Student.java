package day07;


/**
 * @ClassName Student
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 11:45
 * @Version 1.0
 */
public class Student {
    public Student(String tname,int tage,String teducation){
        this.name = tname;
        setAge(tage);
        this.education = teducation;
    }
    /**
     * 姓名
     */
    public String name;
    /**
     * 年龄（默认为19）
     */
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>19&&age<45){
            this.age = age;
        }
        else {
            System.out.println("输入有误，给其默认值19");
            this.age = 19;
        }
    }

    /**
     * 学历（大专、本科、研究生）
     */
    private String education;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        if(education == "大专"||education == "本科" || education == "研究生")
            this.education = education;
        else
            this.education = "大专";
    }
    private String tname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
