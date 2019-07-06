package day13;

import java.util.*;

/**
 * @ClassName HashMap
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/3 21:42
 * @Version 1.0
 */
public class HashMap {
    public static void main(String[] args){
        TreeMap<Student,Integer> treeMap = new TreeMap<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.num.compareTo(o2.num)!=0){
                    return o1.num.compareTo(o2.num);
                }else{
                    if(o1.score.compareTo(o2.score)!=0)
                        return o1.score.compareTo(o2.score);
                    else
                        return 0;
                }
            }
        });
        treeMap.put(new Student("11",12),2);
        treeMap.put(new Student("12",13),3);
        treeMap.put(new Student("7",14),1);
        treeMap.put(new Student("9",15),6);
        treeMap.put(new Student("3",16),8);
        treeMap.put(new Student("1",17),4);
        treeMap.put(new Student("5",18),0);
        Set<Map.Entry<Student,Integer>> set = treeMap.entrySet();
        Iterator<Map.Entry<Student,Integer>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Student,Integer> k = iterator.next();
            System.out.println(k.getKey().num+","+k.getKey().score+","+k.getValue());
        }
    }
}
