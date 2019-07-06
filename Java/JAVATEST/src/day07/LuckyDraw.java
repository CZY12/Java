package day07;

import java.util.Scanner;

/**
 * @ClassName LuckyDraw
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 10:11
 * @Version 1.0
 */
public class LuckyDraw {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = 50;
        String array[] = new String[max];
        int i = -1;
        a:while (i < max) {
            System.out.println("学生管理系统");
            System.out.println("1.添加学员信息");
            System.out.println("2.删除学员信息");
            System.out.println("3.查询学员信息");
            System.out.println("4.退出");
            System.out.println("----------------------------");
            System.out.print("请输入您的选择：");
            int n = input.nextInt();
            switch (n) {
                case 1:
                    System.out.print("请输入学员姓名：");
                    String name = input.next();
                    array[++i] = name;
//                    i++;
                    System.out.println("添加成功！");
                    System.out.println("----------------------------");
                    break;
                case 2:
                    System.out.print("请输入学员姓名：");
                    String name1 = input.next();
                    for (int m = 0; m <= i; m++) {
                        if (array[m].equals(name1)) {
                            if (m < i-1)
                                array[m] = array[i-1];
//                          System.out.println(array[m]);
                            array[--i] = null;
                            break ;
                        }else if(m == i)
                            System.out.println("未找到该用户");
                    }
                    if(i==-1)
                        System.out.println("无用户");
                    System.out.println("----------------------------");
                    break;
                case 3:
                    System.out.println("查询学员信息>>>>>");
                    if (i != 0)
                        for (int j = 0; j < i; j++) {
                            System.out.println(array[j]);
                        }
                    else
                        System.out.println("无数据");
                    System.out.println("----------------------------");
                    break;
                case 4:
                    System.out.println("谢谢使用！");
                    break a;
            }
        }
    }
}
