package work3.Test3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName Photo
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 16:44
 * @Version 1.0
 */
public class Photo {
    public static void main(String [] args) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream = new FileInputStream("D:\\TEST\\Java\\JAVATEST\\src\\aa\\jojo.jpg");
            fileOutputStream = new FileOutputStream("D:\\TEST\\Java\\JAVATEST\\src\\aa\\dioda.jpg");
            byte[] bytes = new byte[1024];
            int len = fileInputStream.read(bytes);
            while (len!=-1){
                fileOutputStream.write(bytes,0,len);
                len = fileInputStream.read(bytes);
            }
            System.out.println("复制成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }
}
