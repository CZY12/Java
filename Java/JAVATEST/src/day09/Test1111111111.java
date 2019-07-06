package day09;

/**
 * @ClassName Test1111111111
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/27 18:56
 * @Version 1.0
 */
public class Test1111111111 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        TeavelTool bike = new Bike("法拉利");
        TeavelTool car = new Car("桑塔纳");
        TeavelTool plane = new Plane("波音747");
        TeavelTool tank = new Tank("Tc130");
        teacher.name = "ccc";
        System.out.println(teacher.name);
        bike.start();
        bike.stop();
        teacher.name = "sss";
        System.out.println(teacher.name);
        car.start();
        car.stop();
        teacher.name = "aaa";
        System.out.println(teacher.name);
        plane.start();
        plane.stop();
        teacher.name = "xxx";
        System.out.println(teacher.name);
        tank.start();
        tank.stop();
    }
}
