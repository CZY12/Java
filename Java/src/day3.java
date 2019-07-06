import java.util.Scanner;

public class day3 {
    public static void main(String[] args) {
        Scanner day3 = new Scanner(System.in);
        System.out.print("请输入a：");
        int a = day3.nextInt();
        System.out.print("请输入b：");
        int b = day3.nextInt();
        System.out.print("请输入c：");
        int c = day3.nextInt();
        if (a > b) {
            if (a > c) {                      //a>b;a>c
                if (b > c) {                  //a>b>c
                    System.out.println("a=" + a + "\tb=" + b + "\tc=" + c);
                } else                        //a>c>b
                    System.out.println("a=" + a + "\tc=" + c + "\tb=" + b);
            } else                            //c>a>b
                System.out.println("c=" + c + "\ta=" + a + "\tb=" + b);
        } else {                              //b>a
            if (b > c) {                      //b>a;b>c
                if (a > c) {                  //b>a>c
                    System.out.println("b=" + b + "\ta=" + c + "\tc=" + c);
                } else                        //b>c>a
                    System.out.println("b=" + b + "\ta=" + c + "\tc=" + c);
            }else                             //b>a;c>b === c>b>a
                System.out.println("c=" + c + "\tb=" + b + "\ta=" + a);
        }
    }
}

