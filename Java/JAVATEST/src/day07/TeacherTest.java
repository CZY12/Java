package day07;

/**
 * @ClassName TeacherTest
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 11:33
 * @Version 1.0
 */
public class TeacherTest {
    public static void main(String[] args) {
        Teacher tea = new Teacher();
        tea.name = "cheng";
        tea.age = 100;
        System.out.println(tea.name+tea.age);
        tea.goToStudy();
    }
}
