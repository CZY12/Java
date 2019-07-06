package day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Dom4
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/2 17:52
 * @Version 1.0
 */
public class Dom4 {
    public static void main(String[] args){
        List<Dog> list = new ArrayList();
        list.add(new Dog("欧欧","雪娜娜"));
        list.add(new Dog("亚亚","拉布拉多"));
        list.add(new Dog("菲菲","拉布拉多"));
        list.add(new Dog("美美","雪娜娜"));
        System.out.println("共计有"+list.size()+"条狗狗\n分别是：");
        for (Dog ob:
             list) {
            System.out.println(ob.name+"\t"+ob.kind);
        }
        System.out.println("第一条狗的名字是"+list.get(0).name);
        System.out.println("最后一条狗的名字是"+list.get(list.size()-1).name);
        list.remove(0);
        for(int i = 0 ; i< list.size(); i++){
            if(list.get(i).name.equals("菲菲"))
                list.remove(i);
        }
        for (Dog ob:
                list) {
            System.out.println(ob.name+"\t"+ob.kind);
        }
    }
}
