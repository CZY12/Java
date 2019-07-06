package DvdManagement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.*;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName Menu
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/29 14:26
 * @Version 1.0
 */
public class Menu {
    Scanner input = new Scanner(System.in);
    DVDSet dvdSet = new DVDSet();

    void startMenu() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("1.新增DVD");
        System.out.println("2.查看DVD");
        System.out.println("3.删除DVD");
        System.out.println("4.借出DVD");
        System.out.println("5.归还DVD");
        System.out.println("6.退出DVD");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.print("请选择：");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                addDVD();
                break;
            case 2:
                findDVD();
                break;
            case 3:
                deleteDVD();
                break;
            case 4:
                loanDVD();
                break;
            case 5:
                returnDVD();
                break;
            case 6:
                System.out.println("感谢您的使用");
                break;
            default:
                System.out.println("异常输入");
                startMenu();
                break;
        }
    }

    private void addDVD() {
        System.out.println("请输入要添加的DVD名称");
        String name = input.next();
        boolean flage = isFlage(name);
        if (flage)
            System.out.println("该专辑已存在");
        else {
            for (int i = 0; i < dvdSet.date.length; i++) {
                if (dvdSet.name[i] == null) {
                    dvdSet.name[i] = name;
                    dvdSet.sate[i] = 0;
                    System.out.println("\n录入成功");
                    break;
                }
            }
//        for (int i = 0 ; i<dvdSet.name.length;i++){
//            if(dvdSet.name[i]!=null&&dvdSet.name[i].equals(name))
//                System.out.println("已存在");
//            else if(dvdSet.name[i]==null) {
//                dvdSet.name[i] = name;
//                dvdSet.sate[i] = 0;
//                Date date1 = new Date();
//                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
////                System.out.println(sd.format(date1));
//                dvdSet.date[i]=sd.format(date1);
//                System.out.println("\n录入成功");
//                startMenu();
//                break;
//            }
//        }
        }
        startMenu();
    }

    private void findDVD() {
        System.out.println("书名\t\t\t状态\t\t\t借出日期");
        for (int i = 0; i < dvdSet.name.length; i++) {
            if (dvdSet.name[i] != null) {
                if (dvdSet.sate[i] == 0)
                    System.out.println(dvdSet.name[i] + "\t\t未借出\t\t" + dvdSet.date[i]);
                else if (dvdSet.sate[i] == 1)
                    System.out.println(dvdSet.name[i] + "\t\t已借出\t\t" + dvdSet.date[i]);
            } else if (dvdSet.date[i] == null) {
                break;
            }
        }
        startMenu();
    }

    private void deleteDVD() {
        System.out.println("删除DVD");
        String name = input.next();
        boolean flage = isFlage(name);
        if (!flage)
            System.out.println("该专辑不存在");
        else {
            for (int i = 0; i < dvdSet.name.length; i++) {
                if (name.equals(dvdSet.name[i]) && dvdSet.sate[i] == 0) {
                    int j = i;
                    for (; j < dvdSet.sate.length - 1; j++) {
                        if (dvdSet.name[j + 1] != null) {
                            dvdSet.name[j] = dvdSet.name[j + 1];
                            dvdSet.sate[j] = dvdSet.sate[j + 1];
                            dvdSet.date[j] = dvdSet.date[j + 1];
                        }
                        break;
                    }
                    dvdSet.name[j] = null;
                    dvdSet.sate[j] = 0;
                    dvdSet.date[j] = null;
                    System.out.println("删除成功");
                    break;
                } else if (dvdSet.sate[i] == 1)
                    System.out.println("该专辑已被借出，无法删除");
            }
        }
        startMenu();
    }

    private boolean isFlage(String name) {
        boolean flage = false;
        for (int i = 0; i < dvdSet.sate.length; i++) {
            if (dvdSet.name[i] != null && dvdSet.name[i].equals(name)) {
                flage = true;
                break;
            }
        }
        return flage;
    }

    private void loanDVD() {
        System.out.print("请输入要借的专辑名称：");
        String name = input.next();
        boolean flage = isFlage(name);
        if (!flage)
            System.out.println("该专辑不存在");
        else {
            for (int i = 0; i < dvdSet.date.length; i++) {
                if (dvdSet.name[i].equals(name) && dvdSet.name[i] != null) {
                    if (dvdSet.sate[i] == 0) {
                        System.out.println("此专辑尚未被借出，你确定要借吗？y/n");
                        String choice = input.next();
                        if (choice.equals("y")) {
                            dvdSet.sate[i] = 1;
                            Date date1 = new Date();
                            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
                            dvdSet.date[i] = sd.format(date1);
                            break;
                        }
                    } else
                        System.out.println("该专辑已被借走");
                }
            }
        }
        startMenu();
    }

    private void returnDVD() {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        System.out.print("请输入要还专辑名称：");
        String name = input.next();
        boolean flage = isFlage(name);
        if (!flage) {
            System.out.println("输入错误");
        } else {
            System.out.print("输入归还日期(年-月-日)：");
            String date = input.next();
//            SimpleDateFormat sd1 = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat sd2 = new SimpleDateFormat("yyyy-MM-dd");
            Date d1 = null;
            Date d2 = null;
            for (int i = 0; i < dvdSet.name.length; i++) {
                if (dvdSet.name[i].equals(name)) {
                    try {
                        d1 = sd2.parse(dvdSet.date[i]);
                        d2 = sd2.parse(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
            long change = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
            System.out.println("借出天数为：" + change + "\n应还金额为" + change + "元");
        }
        startMenu();
    }
}
