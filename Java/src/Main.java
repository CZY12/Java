import java.util.Scanner;
// 类 ： 主信息
class Menu {
    Information inf = new Information();
    public void showLoginMenu() {
        Scanner a = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("欢迎来到我行我素购物管理系统");
        System.out.println("1.登录");
        System.out.println("2.退出");
        System.out.println("************************************");
        StartSMS startsms = new StartSMS();
        System.out.print("请选择，输入数字：");
        int str = a.nextInt();
        if (str == 1) {
            startsms.startSms();
        } else if (str == 2) {
            System.out.println("谢谢您的使用！");
        }
    }

    public void showMainMenu() {
        System.out.println("************************************");
        System.out.println("欢迎来到我行我素购物管理系统");
        System.out.println("1.客户信息管理");
        System.out.println("2.购物结算");
        System.out.println("3.真情回馈");
        System.out.println("4.注销");
        System.out.println("************************************");
        Scanner b = new Scanner(System.in);
        System.out.print("请选择，输入数字：");
        int str = b.nextInt();
        if (str == 1)
            inf.information();
        else if (str == 2)
            showOrderMenu();
        else if (str == 3)
            showSendGMenu();
        else if (str == 4) {
            showLoginMenu();
        } else {
            System.out.println("输入不合法，请重新输入！");
            showMainMenu();
        }
    }

    public void showSendGMenu() {
        System.out.println("************************************");
        System.out.println("购物管理系统>真情回馈");
        System.out.println("1.幸运大放送");
        System.out.println("2.幸运抽奖");
        System.out.println("3.生日问候");
        System.out.println("************************************");
    }

    public void showOrderMenu() {
        Scanner str = new Scanner(System.in);
        System.out.print("请输入是否为会员：是（y）/否（其他字符）");
        String a = str.next();
        if ("y".equals(a)) {
            System.out.print("请输入总金额");
            int b = str.nextInt();
            if (b > 0) {
                if (b > 200) {
                    System.out.println("应付金额：" + (b * 0.75));
                } else
                    System.out.println("应付金额：" + (b * 0.8));
            } else
                System.out.println("输入错误");
        } else {
            System.out.print("请输入总金额");
            int c = str.nextInt();
            System.out.print("应付金额：" + (c * 0.9));
        }
        showMainMenu();
    }
}
// 类 ： 登录信息
class StartSMS {
    public void startSms() {
        Menu a = new Menu();
        Scanner c = new Scanner(System.in);
//        int i = 3;
//        while (i > 0) {
//            String name[] = {"t","o","m"};
//            int password[] = {1,2,3,4};
//            System.out.print("请输入用户名：");
//            String [] str1 = null;
//            for(int j = 0;c.hasNextInt();j++) {
//                str1 [j] = c.next();
//            }
//            System.out.print("请输入密码：");
//            int [] str2 = null;
//            for(int j = 0;c.hasNextInt();j++) {
//                str2 [j] = c.nextInt();
//            }
//            if ("tom".equals(str1) && str2 == 1234) {
//                System.out.println("************************************");
//                System.out.println("登录成功！！!");
//                a.showMainMenu();
//            } else
//                System.out.println("本账号没有权限进入系统，请重新登录,剩余登录次数：" + --i);
//            for(int n =0 ; n < str1.length; n++){
//                if (str1[n]!=name[n])
//                    System.out.println("账号错误");
//                System.out.println("本账号没有权限进入系统，请重新登录,剩余登录次数：" + --i);
//            }
//
//            for(int n =0 ; n < str2.length; i++){
//                if (str2[n]!=password[n])
//                    System.out.println("密码错误");
//                System.out.println("本账号没有权限进入系统，请重新登录,剩余登录次数：" + --i);
//            }
//            System.out.println("登录成功");
//            System.out.println("************************************");
//            System.out.println("登录成功！！!");
//            a.showMainMenu();
//        }
//        System.out.println("对不起，账号输入次数用完，请重新输入");
//        a.showLoginMenu();
        String []name = new String[100];
        int []password = new int [100];
        System.out.println("请输入账号：");
        String id = c.next();

    }
}
// 类 ：  客户信息管理
class Information{
    public static void information(){
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        System.out.println("************************************");
        System.out.println("购物管理系统>客户信息管理");
        System.out.println("1.显示所有客户信息");
        System.out.println("2.添加客户信息");
        System.out.println("3.修改客户信息");
        System.out.println("4.查询客户信息");
        System.out.println("************************************");
        System.out.print("请输入编号：");
        int num = input.nextInt();
        switch(num){
            case 1:
                allCustInf();
                break;
            case 2:
                addCustInf();
                break;
            case 3:
                aletrCustInf();
                break;
            case 4:
                findCustInf();
                break;
            default:
                menu.showMainMenu();
                break;
        }
    }
    public static void allCustInf(){
        System.out.println("all客户信息");
    }
    public static void addCustInf(){
        System.out.println("添加客户信息");
    }
    public static void aletrCustInf(){
        System.out.println("修改客户信息");
    }
    public static void findCustInf(){
        System.out.println("查询客户信息");
    }
}
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.showLoginMenu();

    }
}