package day08;

/**
 * @ClassName dom1
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 17:47
 * @Version 1.0
 */
public class dom1 {
    public static void main(String[] args) {
        //用构造方法创建对象
        Student stu1=new Student();
        //用对象调用属性并赋值
        stu1.sname="张三";
        stu1.school="北大";
        //用对象调用实例方法
        stu1.show2();
        //用对象调用静态方法
        stu1.show4();
        //用类名调用静态方法
        Student.show4();

        //用构造方法创建对象
        Student stu2=new Student();
        //用对象调用属性并赋值
        stu2.sname="李四";
        stu2.school="青华";


        //用类名调用静态变量
        System.out.println("学生姓名:"+stu1.sname+",所属的学校："+Student.school);
        //用对象调用静态变量
        System.out.println("学生姓名:"+stu2.sname+",所属的学校："+stu2.school);
    }
}
