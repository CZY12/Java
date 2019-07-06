package day09;

/**
 * @ClassName Bike
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/27 18:47
 * @Version 1.0
 */
public class Bike extends TeavelTool {
    public Bike(String  brand) {
        this.brand = brand;
    }

    @Override
    public void start() {
        System.out.println("骑自行车");
    }

    @Override
    public void stop() {
        System.out.println("停下自行车");
    }
}
