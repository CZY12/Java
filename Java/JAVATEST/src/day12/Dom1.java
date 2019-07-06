package day12;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName Dom1
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/3 11:05
 * @Version 1.0
 */
public class Dom1 {
    public static void main(String[] args){
        MyComparator my = new MyComparator();
        Set<SStudent> list = new TreeSet<>(my);
        list.add(new SStudent("aa",12));
        list.add(new SStudent("ab",12));
        list.add(new SStudent("ba",13));
        list.add(new SStudent("bb",11));
        for (SStudent s :
                list) {
            System.out.println(s.name+","+s.age);
        }
    }
}
