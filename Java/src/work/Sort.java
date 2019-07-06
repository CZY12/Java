package work;

/**
 * @ClassName 冒泡排序
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/28 16:04
 * @Version 1.0
 */
public class Sort {
    public static void main(String[] args){
        int [] a = new int[10];
        for(int i = 0; i < a.length ; i ++){
            int b = (int)(Math.random()*26+75);
            a[i] = b;
        }
        for (int c:a
        ) {
            System.out.print(c+"\t");
        }
        System.out.println();
        for(int j = 0 ; j < a.length-1 ; j++){
            for (int n = 0 ; n < a.length-j-1;n++){
                if (a[n] > a[n+1]) {
                    int m = a[n];
                    a[n] = a[n+1];
                    a[n+1] = m;
                }
            }
            System.out.println("*******************");
            System.out.println("冒泡排序第"+(j+1)+"趟");
            for (int c:a
            ) {
                System.out.print(c+"\t");
            }
            System.out.println();
        }
        System.out.println("排序完成后：");
        for (int c:a
        ) {
            System.out.print(c+"\t");
        }
    }
}
