package Yangsisen;

import java.util.Scanner;

/**
 * @ClassName Menu
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/4 20:52
 * @Version 1.0
 */
public class Menu {
    IpAndPasswordArray i1=new IpAndPasswordArray();
    /**
     * 显示登录菜单
     */
    public void showLoginMenu(){
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎使用我行我素购物管理系统");
        System.out.println("1.登入系统");
        System.out.println("2.退出");
        System.out.println("********************************");
        System.out.println("请选择，执行步骤：");
        int n1=input.nextInt();
        switch(n1){
            case 1:
                enter();
                break;
            case 2:
                System.out.println("谢谢你的使用");
                System.exit(0);
                break;
            default:
                System.out.println("你输入的有误，请重新输入！");
                showLoginMenu();
                break;

        }
    }
    /**
     * 显示主菜单
     */
    public void showMainMenu(){
        Scanner input=new Scanner(System.in);
        System.out.println("我行我素购物管理系统主菜单");
        System.out.println("******************************************");
        System.out.println("1.客户信息管理");
        System.out.println("2.购物结算");
        System.out.println("3.真情回馈");
        System.out.println("4.注销");
        traverse();
        System.out.println("******************************************");
        System.out.println("请选择，输入执行步骤：");
        int num=input.nextInt();
        switch(num){
            case 1:
                showCustMenu();
                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            default:

                break;
        }
    }
    /**
     * 显示客户信息管理菜单
     */
    public void showCustMenu(){
        Scanner input=new Scanner(System.in);
        System.out.println("购物管理系统>客户信息管理");
        System.out.println("********************************");
        System.out.println("1.显示所有客户信息");
        System.out.println("2.添加客户信息");
        System.out.println("3.修改客户信息");
        System.out.println("4.查询客户信息");
        System.out.println("********************************");
        System.out.println("请选择，输入执行步骤或按0返回上一级菜单：");
        int num=input.nextInt();
        switch(num){
            case 1:
                traverse();
                showCustMenu();
                break;
            case 2:
                add();
                showCustMenu();
                break;
            case 3:
                delete();
                showCustMenu();
                break;
            case 4:
                System.out.println("请输入需要查询的用户名：");
                String ip1=new String();
                refer(ip1);
                break;
            default:
                showMainMenu();
                break;
        }
    }
    /**
     * 显示真情回馈菜单

     */
    public void showSendGMenu(){

    }
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
                register();
                break;
            case 2:
                add();
                enter();
                break;
            default:
                enter();
                break;
        }
    }
    /**
     * 查找的方法
     */
    public boolean refer(String ip){
        traverse();
        boolean flag=false;
        for (int i = 0; i < i1.maxnum; i++) {
            if(i1.getUser()user[i]!=null&&user[i].getIp().equals(ip)){
                traverse();
                flag=true;
                break;
            }
        }
        return flag;
    }
    /**
     * 添加的方法
     */
    public void add(){
        Scanner input=new Scanner(System.in);
        IpAndPassword ju=new IpAndPassword();
        System.out.println("请输入注册账户：");
        String ip=input.next();
        ju.setIp(ip);
        boolean flag=refer(ip);
        if(num3==maxnum){
            System.out.println("注册用户已满");
        }else{
            if(flag==true){
                System.out.println("该用户已存在");
            }else{
                System.out.println("请输入注册密码：");
                String password=input.next();
                ju.setPassword(password);
                user[num3]=ju;
                ++num3;
                System.out.println("添加成功！！！");
                traverse();
            }
        }
        System.out.println("正在返回上一级");
    }
    /**
     * 删除的方法
     */
    public void delete(){
        Scanner input=new Scanner(System.in);
        System.out.println("请输入需要删除的用户：");
        String ip=input.next();
        boolean flag=refer(ip);
        if(flag==false){
            System.out.println("该用户不存在");
            System.out.println("正在返回上一级");
        }else{
            for (int i = 0; i < user.length; i++) {
                if(user[i].getIp().equals(ip)){
                    user[i]=null;
                    System.out.println("删除成功");
                    System.out.println("正在返回上一级");
                    break;
                }
            }
        }
    }
    /**
     * 遍历的方法
     */
    public void traverse(){
        for (IpAndPassword ju : user) {
            System.out.println(ju);
        }
    }
    /**
     * 登录的方法
     */
    public void register(){
        traverse();
        Scanner input=new Scanner(System.in);
        IpAndPassword ju=new IpAndPassword();
        System.out.println("请输入登录账号：");
        String ip=input.next();
        boolean flag=refer(ip);
        if(flag==false){
            System.out.println("你输入的账号不存在！");
            enter();
        }else{
            System.out.println("请输入登录密码：");
            String password=input.next();
            for (int i = 0; i < user.length; i++) {
                if(user[i]!=null&&(user[i].getIp().equals(ip)&user[i].getPassword().equals(password))){
                    System.out.println("登陆成功！！！");
                    System.out.println("正在跳转页面");
                    m1.showMainMenu();
                    break;
                }else{
                    System.out.println("你输入的密码错误！");
                    System.out.println("******************************************");
                    System.out.println("1.返回登录界面");
                    System.out.println("2.重新登录");
                    System.out.println("3.按任意键退出系统");
                    System.out.println("******************************************");
                    System.out.println("请选择，输入数字：");
                    int num=input.nextInt();
                    switch(num){
                        case 1:
                            enter();
                            break;
                        case 2:
                            register();
                            break;
                        default:
                            System.out.println("谢谢使用！！！");
                            break;
                    }
                }
            }
        }
    }
}
