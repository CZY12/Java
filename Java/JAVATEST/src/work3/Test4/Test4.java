package work3.Test3.Test4;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName Test4
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 16:55
 * @Version 1.0
 */
public class Test4 {
    public static void main(String[] agrs) throws IOException {
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("D:\\TEST\\Java\\JAVATEST\\src\\aa\\aa.txt");
            byte[] bytes = new byte[5];
            int len = fileInputStream.read(bytes);
            int n1=0;
            int n2=0;
            int n3=0;
            int n4=0;
            int n5=0;
            int n6=0;
            while (len != -1){
                System.out.println("-------------"+len);
                for (int i = 0 ; i < bytes.length ; i ++){
                    char c = (char) bytes[i];
                    switch (c){
                        case 'a':
                            n1++;
                            break;
                        case 'b':
                            n2++;
                            break;
                        case 'c':
                            n3++;
                            break;
                        case 'A':
                            n4++;
                            break;
                        case 'B':
                            n5++;
                            break;
                        case 'C':
                            n6++;
                            break;
                    }
                }
                len = fileInputStream.read(bytes);
            }
            System.out.println("A("+n4+"),B("+n5+"),C("+n6+"),a("+n1+"),b("+n2+"),c("+n3+")");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }
    }
}
