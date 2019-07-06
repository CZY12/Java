package Yangsisen;

import java.util.Scanner;

/**
 * @ClassName StartSMS
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/4 20:52
 * @Version 1.0
 */
public class StartSMS {
    IpAndPasswordArray user1=new IpAndPasswordArray();

    public void enter(){
        Scanner input=new Scanner(System.in);
        System.out.println("购物管理》登录系统");
        System.out.println("******************************************");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("******************************************");
        System.out.println("请选择，输入数字或按任意键返回上一级。");
        int num2=input.nextInt();
        switch(num2){
            case 1:
                user1.register();
                break;
            case 2:
                user1.add();
                enter();
                break;
            default:
                enter();
                break;
        }
    }
}
