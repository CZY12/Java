import java.util.Scanner;

public class day4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        System.out.print("输入数字：");
//        int num = input.nextInt();
//        System.out.print("输入元素个数：");
//        int count = input.nextInt();
//        average(num);
//        int num = input.nextInt();
//        int result = Prinme(num);
//        int result = input.nextInt();
//        for(;num>0;num--){
//            System.out.print(num);
//            if(num>1)
//                System.out.print("+");
//        }
//        System.out.print("="+result);
//      Sum(result,sum);
//        int n = Sum(result);
//        System.out.println("该数字各位之和为："+n);
//        int num = input.nextInt();
//        System.out.println(print(num));
//        print(num);
//        int b = num;
//        int result = Sum(num,count,b);
//        System.out.print("="+result);
//        int i = 1;
//
//        for (; i <= 35; i++) {
//            int j = 35 - i ;
//                if ((i * 2 + j * 4) == 94)
//                    System.out.println("鸡有：" + i + "只，兔有：" + j + "只");
//        }
        int price = (int)(Math.random()*1000+100);
        int number;
        do{
        System.out.print("输入价格：");
        number = input.nextInt();
            if(number>price)
                System.out.println("高了");
            else if(number<price)
                System.out.println("低了");
        }while(number != price);
        System.out.println("正确，价格为："+price);
    }
    // 素数
    public static int Prime(int i) {
        int result;
        if (i == 1) {
            result = 1;
        } else
            result = i + Prime(i - 1);
        return result;
    }

    // 一个数的每位上的和：abcd   sum=a+b+c+d
    public static int Sum(int m) {
        int result = 0;
        if (m % 10 != 0) {
            result = (m % 10) + Sum(m / 10);
        }
        return result;

    }

    // 输出0，1，2，3，4，5.......j
    public static void print(int j) {
//        int i = j;
        if (j >= 0) {
            print(j - 1);
            if (j > 0)
                System.out.print(",");
            System.out.print(j);

        }
    }

    // 求平均值
    public static void average(int q) {
        Scanner input = new Scanner(System.in);
        int score;
        int sum = 0;
        for (int i = 1; i <= q; i++) {
            System.out.println("请输入学生" + i + "的成绩");
            score = input.nextInt();
            sum += score;
        }
        System.out.println("该班学生平均分为：" + sum / q);

    }

    // a+aa+aaa+aaaa.........
    public static int Sum(int m, int n, int z) {
        int result;
        if (n == 1)
            result = m;
        else {
            result = m + Sum(m * 10 + z, n - 1, z);
        }
        if (n > 1)
            System.out.print("+");
        System.out.print(m);
        return result;
    }
}

