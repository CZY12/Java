package day08;

/**
 * @ClassName Dom2
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 20:15
 * @Version 1.0
 */
public class Dom2 {
    public static void main(String[] args){
        Human human = new Human();
        Park park = new Park();
        Animal animal = new Animal();
        human.name = "张三";
        park.name= "朝阳";
        animal.name = "里斯";
        human.liugou();
        animal.liugou();
        System.out.println(human.name+"在"+park.name+"公园溜"+animal.name);
    }
}
