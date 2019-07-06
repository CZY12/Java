package GoShopManagement;

import java.util.Scanner;

/**
 * @ClassName StartSMS
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 20:00
 * @Version 1.0
 */
public class StartSMS {
    public static final int maxNum = 3;
    public void loginCheck(){
        Menu menu = new Menu();
        Scanner input = new Scanner(System.in);
        IdAndPasswordArray idArray = new IdAndPasswordArray(maxNum);
        while (true){
            System.out.println("欢迎来到我行我素购物管理系统");
            System.out.println();
            System.out.println("1：注册");
            System.out.println("2：登录");
            System.out.println("3：退出");
            System.out.println("_______________________________");
            System.out.print("输入数字进行选择（1/2/3）:");
            int a = input.nextInt();
            switch (a){
                case 1:
                    if(idArray.getNum() == maxNum)
                        System.out.println("注册人数已达上限");
                    else {
                        IdAndPassowrd id = new IdAndPassowrd();
                        System.out.println("输入账号");
                        String userName = input.next();
                        System.out.println("输入密码");
                        String userPaw = input.next();
                        id.setId(userName);
                        id.setPassword(userPaw);
                        if(!idArray.findId(id)){
                            idArray.insertId(id);
                            int n = idArray.getNum();
                            idArray.displayId();
                            System.out.println("注册成功"+n);
                        }else{
                            System.out.println("该用户已存在");
                        }
                    }
                    break;
                case 2:
                    IdAndPassowrd id = new IdAndPassowrd();
                    System.out.print("请输入账号：");
                    String id1 = input.next();
                    System.out.print("请输入密码：");
                    String paw = input.next();
                    id.setId(id1);
                    id.setPassword(paw);
                    if(idArray.findId(id)){
                        System.out.println("登录成功");
                        menu.showMainMenu();
                    }else
                        System.out.println("输入有误");
                    break;
                case 3:
                    System.out.println("谢谢使用");
                    break;
                default:
                    System.out.println("输入不合法");
                    break;
            }
        }

    }
}
