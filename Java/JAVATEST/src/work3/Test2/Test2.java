package work3.Test2;

import com.sun.corba.se.impl.presentation.rmi.StubFactoryStaticImpl;

import java.util.*;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 16:20
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args){
        Set<Student> studentSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if(o1.getScore().compareTo(o2.getScore())!=0)
                    return -o1.getScore().compareTo(o2.getScore());
                else
                    return 0;
            }
        });
        studentSet.add(new Student(9,"张三",91));
        studentSet.add(new Student(5,"张四",83));
        studentSet.add(new Student(2,"张五",65));
        studentSet.add(new Student(7,"张六",99));
        studentSet.add(new Student(4,"张七",78));
        studentSet.add(new Student(8,"张八",24));
        studentSet.add(new Student(6,"张九",36));
        studentSet.add(new Student(3,"张十",55));
        studentSet.add(new Student(1,"张二",62));
        System.out.println("学号"+"\t"+"姓名"+"\t"+"分数");
        Iterator<Student> iterator = studentSet.iterator();
        int n1 = 0;
        int n2 = 0;
        while (iterator.hasNext()){
            Student stu = iterator.next();
            System.out.println(stu.getNum()+"\t"+stu.getName()+"\t"+stu.getScore());
            if(stu.getScore()>=60)
                n2++;
            if(stu.getScore()>=80)
                n1++;
        }
        double m1 = (double) n1/studentSet.size();
        double m2 = (double)n2/studentSet.size();
        System.out.println("优秀（80分及以上）人数为"+n1+"，优秀率为"+String.format("%.9f",m1)+"\n及格人数为"+n2+"人，及格率为"+String.format("%.9f",m2));
    }
}
