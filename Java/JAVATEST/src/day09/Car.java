package day09;

/**
 * @ClassName Car
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/27 18:47
 * @Version 1.0
 */
public class Car extends TeavelTool {
    public Car(String brand) {
        this.brand=brand;
    }

    @Override
    public void start() {
        System.out.println("坐汽车");
    }

    @Override
    public void stop() {
        System.out.println("下车");
    }
}
