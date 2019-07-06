package day12;

import java.util.Comparator;

/**
 * @ClassName MyComparator
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/3 11:34
 * @Version 1.0
 */
public class MyComparator implements Comparator<SStudent>{
    @Override
    public int compare(SStudent o1, SStudent o2) {
        if(o1.name.compareTo(o2.name)!=0){
            return -o1.name.compareTo(o2.name);
        }else {
            if(o1.age.compareTo(o2.age)!=0)
                return -o1.age.compareTo(o2.age);
            else
                return 0;
        }
    }
}
