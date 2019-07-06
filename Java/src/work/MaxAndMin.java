package work;

/**
 * @ClassName MaxAndMin
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/28 15:55
 * @Version 1.0
 */
public class MaxAndMin {
    public static void main(String[] args){
        int [] a = new int[10];
        int max = 0;
        int min = 100;
        for(int i = 0; i < a.length ; i ++){
            int b = (int)(Math.random()*26+75);
            a[i] = b;
            if(max<a[i])
                max=a[i];
            if(min>a[i])
                min=a[i];
        }
        for (int c:a
        ) {
            System.out.println(c);
        }
//        int max = 0;
//        for (int i = 0; i< a.length ; i++){
//            if(max<a[i])
//                max=a[i];
//        }
        System.out.println("最大值为"+max+"\n最小值为："+min);
    }
}
