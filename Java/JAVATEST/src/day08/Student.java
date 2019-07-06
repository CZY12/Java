package day08;

/**
 * @ClassName Student
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 17:46
 * @Version 1.0
 */
public class Student {
    /**
     * 静态属性
     */
    public static String school;
    /**
     * 姓名属性
     */
    public String sname;

    /**
     * 静态块
     */
    static {
        school="千锋";
        //show3();
        //show2();
    }

    public void show1() {
        System.out.println("这是实例方法");
        System.out.println("静态变量："+school+",成员变量："+sname);

        show2();
        show4();
    }

    public void show2() {
        System.out.println("这是实例方法");
    }

    public static void show3() {
        System.out.println("这是静态方法");
        System.out.println("静态变量："+school);
        //在自己的类中创建自己的对象，非常耗内存
        Student stu=new Student();
        System.out.println("成员变量："+stu.sname);

        stu.show2();
        show4();
    }

    public static void show4() {
        System.out.println("这是静态方法");
    }
}

