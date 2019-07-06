package day11;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @ClassName Dom1
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/1 11:14
 * @Version 1.0
 */
public class Dom1 {
    public static void main(String[] args){
//        double a = 567;
//        DecimalFormat d = new DecimalFormat("#.00");
//        System.out.println(d.format(a));
        Scanner input = new Scanner(System.in);
        System.out.println("请输入邮箱：");
        String mail = input.next();
        boolean s1 = mail.startsWith("@");
        if(s1) {
            System.out.println("邮箱首位不能为@");
            System.exit(0);
        }
        boolean s2 = mail.endsWith(".");
        if(s2) {
            System.out.println("邮箱末尾不能为.");
            System.exit(0);
        }
        boolean s3 = mail.contentEquals("@.");
        if(!s3) {
            System.out.println("@与.之间要有字符串");
            System.exit(0);
        }
        System.out.println(mail);
    }
}
