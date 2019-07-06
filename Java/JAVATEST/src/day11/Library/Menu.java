package day11.Library;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName Menu
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/2 19:29
 * @Version 1.0
 */
public class Menu {
    public void menu() {
        List<LibraryTest> libraryTests = new ArrayList<>();
        System.out.println("----------------------图书列表-------------------------");
        System.out.println("图书编号\t图书名称\t\t图书单价\t库存");
        libraryTests.add(new LibraryTest("Java教程", 30.6, 30));
        libraryTests.add(new LibraryTest("Jsp指南", 42.1, 40));
        libraryTests.add(new LibraryTest("SSH架构", 47.6, 15));
        for (int i = 0; i < libraryTests.size(); i++) {
            System.out.println((i + 1) + "\t\t" + libraryTests.get(i).bookName + "\t\t" + libraryTests.get(i).bookPrice + "\t" + libraryTests.get(i).bookRepertory);
        }
        pay(libraryTests);
    }
    public void pay(List<LibraryTest> list){
        Scanner input = new Scanner(System.in);
        String choice;
        List<ShopCart> shopCarts = new ArrayList<>();
        do {
            System.out.print("请输入购买图书编号：");
            int serial= input.nextInt();
            System.out.print("请输入购买图书数量：");
            int num = input.nextInt();
            shopCarts.add(new ShopCart(serial,num));
            System.out.print("是否继续购买：(y/n)");
            choice = input.next();
        }while (choice.equals("y"));
        double allPrice = 0.0;
        int str = (int)(Math.random()*100000);
        System.out.println("图书订单编号："+String.format("%6d",str));
        System.out.println("图书名称\t\t购买数量\t图书单价");
        System.out.println("---------------------------------");
        for (int i = 0 ; i < shopCarts.size() ; i++){
            int n = shopCarts.get(i).serial-1;
            System.out.println(list.get(n).bookName+"\t\t"+shopCarts.get(i).num+"\t\t"+list.get(n).bookPrice);
            allPrice = allPrice+list.get(n).bookPrice*shopCarts.get(i).num;
        }
        System.out.println("---------------------------------");
        System.out.println("订单总额：\t\t\t"+allPrice);
        Date date = new Date();
        System.out.println("日期"+date);

    }
}