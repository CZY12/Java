package day14;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @ClassName FileTEst
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/4 10:14
 * @Version 1.0
 */
public class FileTEst {
    public static void main(String[] args) throws IOException {
        File file = new File("d:\\TEST\\aa");
        if (file.exists()) {
            System.out.println("!!!!!!!!!!!!");
            File[] f = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (pathname.getName().endsWith(".txt"))
                        return true;
                    else
                        return false;
                }
            });
            System.out.println(f.length);
            for (File f1 :
                    f) {
                System.out.println(f1.getPath());
            }
        } else
            System.out.println("目录不存在");
    }
}
