package work3.Test5;

import java.io.File;

/**
 * @ClassName DeleteFile
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 17:27
 * @Version 1.0
 */
public class DeleteFile {
    public void deleteFile(File file){
        if(file.exists()){
            File[] files = file.listFiles();
            for (int i = 0 ; i< files.length; i++) {
                if (files[i].getName().endsWith(".txt")) {
                    file.delete();
                } else
                    deleteFile(files[i]);
            }
            file.delete();
        }
    }
}
