package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @ClassName TryCatch
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/4 14:28
 * @Version 1.0
 */
public class TryCatch {
    public static void main(String[] args) throws Exception {

            Scanner input = new Scanner(System.in);
            try {
                System.out.println("输入");
                int num = input.nextInt();
            }catch (InputMismatchException e){
                throw new Exception("hufuafq");
            }catch (Exception e){
                e.printStackTrace();
            }finally{
                System.out.println("nb");
            }
    }
}
