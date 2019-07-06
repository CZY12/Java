package day12;

import java.util.Comparator;

/**
 * @ClassName SStudent
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/3 11:04
 * @Version 1.0
 */
//public class SStudent implements Comparable<SStudent> {
//    public String name;
//    public Integer age;
//
//    public SStudent() {
//    }
//
//    public SStudent(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    @Override
//    public int compareTo(SStudent o) {
//        if (this.name.compareTo(o.name) != 0) {
//            return this.name.compareTo(o.name);
//        } else {
//            if (this.age.compareTo(o.age) != 0) {
//                return this.age.compareTo(o.age);
//            } else
//                return 0;
//        }
//    }
//}
public class SStudent {
    public String name;
    public Integer age;

    public SStudent() {
    }

    public SStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }
//
//    @Override
//    public int compare(SStudent o1, SStudent o2) {
//        if(o1.name.compareTo(o2.name)!=0){
//            return -o1.name.compareTo(o2.name);
//        }else {
//            if(o1.age.compareTo(o2.age)!=0)
//                return -o1.age.compareTo(o2.age);
//            else
//                return 0;
//        }
//    }
}
