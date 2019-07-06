package work3.Test3.Test4;

import java.util.HashMap;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName Count
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/5 19:41
 * @Version 1.0
 */
public class Count {
    public static void main(String[] args){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream("D:\\TEST\\Java\\JAVATEST\\src\\aa\\aa.txt");
            HashMap<String,Integer> map = new HashMap<>();
            int len = 0;
            while ((len = fileInputStream.read())!=-1){
                int count = 0;
                char c = (char) len;
                System.out.println("____________"+len);
                System.out.println("!!!!!!!!!!!!!!"+c);
                try{
                    count = map.get(c+"");
                }catch (Exception e){

                }
                map.put(c+"",count+1);
            }
            fileInputStream.close();
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, Integer> entry = iterator.next();
                System.out.print(entry.getKey() + "(" + entry.getValue() + ") \t");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
