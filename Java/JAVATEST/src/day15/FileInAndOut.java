package day15;

import java.io.*;

/**
 * @ClassName FileInAndOut
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 10:10
 * @Version 1.0
 */
public class FileInAndOut {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = null;
        OutputStreamWriter osr = null;
        try {
            isr = new InputStreamReader(new FileInputStream("d:\\TEST\\a.txt"));
            osr = new OutputStreamWriter(new FileOutputStream("d:\\TEST\\b.txt"));
            char [] chars = new char[10];
            int len = isr.read(chars);
            while (len!=-1){
                osr.write(chars,0,len);
                len = isr.read(chars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(isr!=null)
                isr.close();
            if(osr!=null)
                osr.close();
        }
    }

}
