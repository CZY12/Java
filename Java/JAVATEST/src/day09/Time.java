package day09;

import java.io.FileOutputStream;
import java.util.Scanner;
import java.util.stream.StreamSupport;

/**
 * @ClassName Time
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/27 17:13
 * @Version 1.0
 */
public class Time {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入");
        boolean t ;
        int starTime = (int)System.currentTimeMillis()/1000;
        do{
            System.out.println("11111111");
            String time = input.next();
            t = time.equals("y");
        }while(t);
        int endTime = (int)System.currentTimeMillis()/1000;
        int totalTimer = endTime-starTime;
        System.out.println("耗时"+totalTimer+"秒");
    }
}
