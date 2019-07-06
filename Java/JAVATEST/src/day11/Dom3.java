package day11;

import java.util.*;

/**
 * @ClassName Dom3
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/1 17:28
 * @Version 1.0
 */
public class Dom3 {
    public static void main(String[] args) {
        Set<Student> inter1 = new HashSet<>();
        inter1.add(new Student("aa",12));
        inter1.add(new Student("aa",13));
        inter1.add(new Student("bb",12));
        inter1.add(new Student("aa",12));
        inter1.add(new Student("ab",14));
        for (Student i:
             inter1) {
            System.out.println(i.name+","+i.age);

        }
    }
}
