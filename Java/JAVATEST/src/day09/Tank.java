package day09;

/**
 * @ClassName Tank
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/27 18:47
 * @Version 1.0
 */
public class Tank extends TeavelTool{
    public Tank(String brand) {
        this.brand=brand;
    }

    @Override
    public void start() {
        System.out.println("开坦克");
    }

    @Override
    public void stop() {
        System.out.println("离开坦克");
    }
}
