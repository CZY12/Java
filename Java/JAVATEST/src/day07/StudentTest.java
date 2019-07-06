package day07;
import java.util.Scanner;
/**
 * @ClassName StudentTest
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 14:12
 * @Version 1.0
 */
public class StudentTest {
    public static void main(String[] args){
        Student sut = new Student("111",20,"研究生");
//        sut.name = "111";
//        sut.setAge(18);
//        sut.setEducation("研究生");
        System.out.println("姓名为："+sut.name+"年龄为:"+sut.getAge()+"学历为:"+sut.getEducation());
    }

}
