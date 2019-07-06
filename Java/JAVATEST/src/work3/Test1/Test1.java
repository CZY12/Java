package work3.Test1;

import java.util.*;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 15:39
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        List<Person> list = new ArrayList<>();
        System.out.print("请输入Person对象的个数：");
        int num = input.nextInt();
        for (int i = 1 ; i <= num ; i++) {
            Person person = new Person();
            System.out.println("请输入第" + i + "个人的信息：");
            String name = input.next();
            person.setName(name);
            Integer age = input.nextInt();
            person.setAge(age);
            list.add(person);
        }
        for (Person k:
                list) {
            System.out.println(k.getName()+"\t\t"+k.getAge());
        }
        System.out.println("去除重复元素");
        for(int i = 0 ; i < list.size()-1 ; i++){
            for (int j = i+1 ; j < list.size(); j++ ){
                if(list.get(i).getName().equals(list.get(j).getName())&&list.get(i).getAge()==list.get(j).getAge())
                    System.out.println("即将删除》》》Person ["+list.get(j).getName()+","+list.get(j).getAge()+"]");
            }
        }
        Set<Person> personSet = new HashSet<>();
        for (int i = 0 ; i < list.size() ; i++){
            personSet.add(list.get(i));
        }
        Iterator<Person> personIterator = personSet.iterator();
        while (personIterator.hasNext()){
            Person l = personIterator.next();
            System.out.println(l.getName()+"\t\t"+l.getAge());
        }
    }
}
