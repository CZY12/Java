//package day13;
//
//import org.omg.PortableInterceptor.INACTIVE;
//
//import javax.swing.text.html.HTMLDocument;
//import java.util.*;
//
///**
// * @ClassName Dom1
// * @Description TODO
// * @Author czy61
// * @Date 2019/7/3 19:04
// * @Version 1.0
// */
//public class Dom1 {
//    public static void main(String[] args){
//        Map<String,Integer> student = new HashMap<>();
//        student.put("004",76);
//        student.put("005",98);
//        student.put("006",2);
//        student.put("001",20);
//        student.put("002",99);
//        student.put("003",33);
//        System.out.println("======打印6名学员======");
//        Set<String> ste = student.keySet();
//        for (String k:
//             ste) {
//            System.out.println(k+":"+student.get(k));
//        }
//        System.out.println("======前三名学员成绩======");
//        Set<Student> students = new TreeSet<>();
//        Set<Map.Entry<String ,Integer>> set1= student.entrySet();
//        Iterator<Map.Entry<String ,Integer>> tier = set1.iterator();
//        while (tier.hasNext()){
//            Map.Entry<String, Integer> map = tier.next();
//            students.add(new Student(map.getKey(),map.getValue()));
//        }
//        for (Student s:
//             students) {
//            System.out.println(s.num+":"+s.score);
//        }
//        List<Student> list = new ArrayList<>();
//        Iterator<Student> iterator = students.iterator();
//        while (iterator.hasNext()){
//            Student s = iterator.next();
//            list.add(new Student(s.num,s.score));
//        }
//        for (int i = 0 ; i< 3 ; i++){
//            System.out.println(list.get(i).num+":"+list.get(i).score);
//        }
//    }
//}
