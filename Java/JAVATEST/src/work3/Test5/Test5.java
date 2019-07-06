package work3.Test5;

import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName Test5
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 17:09
 * @Version 1.0
 */
public class Test5 {
    public static void main(String [] args){
        File file = new File("D:\\TEST\\Java\\JAVATEST\\src\\bb");
        DeleteFile deleteFile = new DeleteFile();
        deleteFile.deleteFile(file);
    }

}
