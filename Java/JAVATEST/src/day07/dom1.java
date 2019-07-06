package day07;

/**
 * @ClassName dom1
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 10:24
 * @Version 1.0
 */
public class dom1 {
    public static void main(String[] args){
        int a = 1;
        int b = 2;
        int c = 3;
        add(a,b,c);
    }
    public static void add(int ...num){
        int sum = 0;
        for(int i = 0; i<num.length; i++){
            sum = sum+num[i];
        }
        System.out.println(num.length+"个数的和为："+sum);
    }
}
