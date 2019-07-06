package day13;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName HashTest
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/3 20:34
 * @Version 1.0
 */
public class HashTest {
    public static void main(String[] args){
        Map<String , Integer> stu = new HashMap<>();
        stu.put("11",11);
        stu.put("33",19);
        stu.put("22",13);
        stu.put("44",14);
        stu.put("55",15);
        stu.put("77",16);
//        Set<Map.Entry<String,Integer>> set = stu.entrySet();
//        Iterator<Map.Entry<String,Integer>> aa = set.iterator();
//        while (aa.hasNext()){
//            Map.Entry<String,Integer> a = aa.next();
//            System.out.println(a.getKey()+","+a.getValue());
//        }
        Set<String> set = stu.keySet();
        Iterator<String> iterator = set.iterator();
//        while (iterator.hasNext()){
//            String d = iterator.next();
//            System.out.println(d+","+stu.get(d));
//        }
        for (String k :
             set) {
            System.out.println(k+";"+stu.get(k));
        }
    }

}
