package day06;

/**
 * @ClassName dom1
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 10:14
 * @Version 1.0
 **/
import java.util.Scanner;

public class dom1 {
    public static void main(String [] args ){
        Scanner input = new Scanner(System.in);
        System.out.println("输入行数：");
        int line = input.nextInt();
        int [][] array = new int [line][];
        for(int i = 0 ; i < array.length; i++){
            array[i] = new int [i+1];
            for(int j = 0 ; j < array[i].length ; j++){
                if (i == 0 || j == 0 || i == j){
                    array[i][j] = 1;
                }else
                    array[i][j] = array[i-1][j-1]+array[i-1][j];
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
