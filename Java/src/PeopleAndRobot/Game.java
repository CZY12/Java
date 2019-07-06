package PeopleAndRobot;
/**
 * @ClassName Game
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 20:34
 * @Version 1.0
 */
import java.util.Scanner;

public class Game {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        User user = new User();
        Robot robot = new Robot();
        System.out.println("***********欢迎来到游戏世界***********\n\n");
        System.out.println("游戏规则：1.剪刀，2.石头，3.布");
        System.out.println("请选择对战角色：1.刘备，2.曹操，3孙权");
        int choice = input.nextInt();
        String name1 = robot.role(choice);
        System.out.println("你的姓名为：");
        String name2 = input.next();
        user.name = name2;
        System.out.println("你选择的对战对象为："+name1);
        System.out.println("要开始了吗？y/n");
        String choice1 = input.next();
        boolean t ;
        int  x = 0;
        if(choice1.equals("y")){
            do {
            System.out.println("请出拳：1.剪刀，2.石头，3.布");
            int i = input.nextInt();
            System.out.println("你出拳： "+user.showFist(i));
//            String fist ;
            int n = robot.showFist();
            switch (n){
                case 0:
                    System.out.println(name1+"出拳： 剪刀");
                    break;
                case 1:
                    System.out.println(name1+"出拳： 石头");
                    break;
                case 2:
                    System.out.println(name1+"出拳： 布");
                    break;
            }
                if (i == (n + 1)) {
                    System.out.println("平局");
                    user.score++;
                    robot.score++;
                }
                else {
                    if (i == 1) {
                        if (n == 1) {
                            System.out.println("再接再厉");
                            robot.score++;
                        }
                        else {
                            System.out.println("厉害");
                            user.score++;
                        }
                    } else if (i == 2) {
                        if (n == 2){
                            System.out.println("你输了");
                            robot.score++;
                        }
                        else {
                            System.out.println("nb");
                            user.score++;
                        }
                    } else {
                        if (n == 0) {
                            System.out.println("垃圾");
                            robot.score++;
                        }
                        else {
                            System.out.println("你真棒");
                            user.score++;
                        }
                    }
                }
                System.out.println("还玩吗？y/n");
                String play = input.next();
                t = play.equals("y");
                ++x;
            }while (t);
        }
        System.out.println(user.name+"VS"+robot.role(choice));
        System.out.println("对战次数为："+x);
        System.out.println(user.name+"得分为："+user.score+"\n"+robot.role(choice)+"得分为："+robot.score);
        if(user.score>robot.score)
            System.out.println("你赢了");
        else if(user.score<robot.score)
            System.out.println("你输了");
        else
            System.out.println("势均力敌");
    }
}
