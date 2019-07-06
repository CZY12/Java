package day16;

import day14.TryCatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Demo1
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 20:18
 * @Version 1.0
 */
public class Demo1 {
    public static void  main(String[] args){
        List<Worker> list = new ArrayList<>();
        list.add(new Worker("张三",18,3000));
        list.add(new Worker("李四",23,3500));
        list.add(new Worker("王二",22,3200));
        System.out.println("姓名\t年龄\t工资");
        for (Worker w:
             list) {
            System.out.println(w.name+"\t"+w.age+"\t"+w.money);
        }
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("请输入要添加的信息：");
            System.out.print("姓名：");
            String name = input.next();
            System.out.print("年龄：");
            Integer age = input.nextInt();
            System.out.print("工资：");
            Integer money = input.nextInt();
            System.out.println("要添加的一条信息为>>> ["+name+"\t"+age+"\t"+money+"]");
            System.out.println("要添加的位置");
            int num = input.nextInt();
            if(num<0||num>list.size())
                System.out.println("添加位置有误！！！");
            list.add(num,new Worker(name,age,money));
            System.out.println("添加成功");

        }catch (Exception e){
            e.printStackTrace();
        }
        for (Worker w:
                list) {
            System.out.println(w.name+"\t"+w.age+"\t"+w.money);
        }
    }
}
