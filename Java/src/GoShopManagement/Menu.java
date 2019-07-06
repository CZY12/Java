package GoShopManagement;

import java.util.Scanner;

/**
 * @ClassName Menu
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 19:31
 * @Version 1.0
 */
public class Menu {
    StartSMS sta = new StartSMS();
//    public void showLoginMenu(){
//        Scanner input = new Scanner(System.in);
//        StartSMS sta = new StartSMS();
//        System.out.println("欢迎来到我行我素购物管理系统");
//        System.out.println();
//        System.out.println();
//        System.out.println("1：登录");
//        System.out.println("2：退出");
//        System.out.println("_______________________________");
//        System.out.print("输入数字进行选择（1/2）:");
//        int a = input.nextInt();
//        switch (a){
//            case 1:
//                sta.loginCheck();
//                break;
//            case 2:
//                System.out.println("谢谢使用！");
//                break;
//        }
//    }
    public void showMainMenu(){
        MainMenu mainMenu = new MainMenu();
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到我行我素购物管理系统");
        System.out.println();
        System.out.println();
        System.out.println("1：客户信息管理");
        System.out.println("2：购物结算");
        System.out.println("3：真情回馈");
        System.out.println("4：注销");
        System.out.println("_______________________________");
        System.out.print("输入数字进行选择（1/2/3/4）:");
        int a = input.nextInt();
        switch (a){
            case 1:
                mainMenu.allCustInfo();
                break;
            case 2:
                mainMenu.Shoppingettlement();
                break;
            case 3:
                mainMenu.FeedBack();
                break;
            case 4:
                sta.loginCheck();
                break;
        }
    }
    public void showCustMenu(){
        System.out.println("欢迎来到我行我素购物管理系统");
        System.out.println();
        System.out.println();
        System.out.println("1：查看所有客户信息");
        System.out.println("2：添加客户信息");
        System.out.println("3：修改客户信息");
        System.out.println("4：查询客户信息");
        System.out.println("_______________________________");
    }
    public void showSendMenu(){
        System.out.println("欢迎来到我行我素购物管理系统");
        System.out.println();
        System.out.println();
        System.out.println("1：幸运大放送");
        System.out.println("2：幸运抽奖");
        System.out.println("3：生日问候");
        System.out.println("_______________________________");
    }
}
