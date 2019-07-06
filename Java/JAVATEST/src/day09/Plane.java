package day09;

/**
 * @ClassName Plane
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/27 18:48
 * @Version 1.0
 */
public class Plane extends TeavelTool{
    public Plane(String brand) {
        this.brand=brand;
    }
    @Override
    public void start() {
        System.out.println("开飞机");
    }

    @Override
    public void stop() {
        System.out.println("下飞机");
    }
}
