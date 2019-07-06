package day14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName FileInputStreamTEst
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/4 17:12
 * @Version 1.0
 */
public class FileInputStreamTEst {
    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = new FileInputStream("JAVATEST\\aa\\cc.txt");
//        byte[] bytes = new byte[10];
//        int k = fileInputStream.read(bytes);
//        while(k!=-1){
//                String a = new String(bytes,0,k);
//                System.out.print(a);
//                k = fileInputStream.read(bytes);
//        }
//        fileInputStream.close();
//        System.exit(0);
        File file = new File("JAVATEST\\aa\\bb\\aaa\\a.txt");
//        boolean a = file.canRead();
//        boolean b = file.canWrite();
//        boolean c = file.isAbsolute();
//        if(a)
//            System.out.println("可读");
//        if(b)
//            System.out.println("可写");
//        if(c)
//            System.out.println("是绝对路径");
//        else
//            System.out.println("不是绝对路径");
//        long length = file.length();
//        System.out.println(length);
//        if(!file.getParentFile().exists()) {
//            file.getParentFile().mkdirs();
//        }else
//            System.out.println("文件父目录已存在");
//        if(!file.exists()){
//            file.createNewFile();
//        }else
//            System.out.println("文件已存在");
        int num = 2;
        System.out.printf("%03d",num);
    }
}
