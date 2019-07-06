package day06;

import java.util.Arrays;
public class MaxValue {
    public static void main(String[] args) {
        int array[] = {1, 3, 4, 7, 1, 4, 9};
        System.out.println("最大值为：" + max(array));
        System.out.println("最小值为：" + mix(array));
        System.out.println(Arrays.toString(array));
    }


//  求数组中最大的值
    public static int max(int a[]) {
        int count = a[0];
        for (int i = 0; i < a.length; i++) {
            if (count < a[i]) {
                count = a[i];
            }
        }
        return count;
    }
//  求数组中最小的值
    public static int mix(int a[]) {
        int count = a[0];
        for (int i = 0; i < a.length; i++) {
            if (count > a[i]) {
                count = a[i];
            }
        }
        return count;
    }
}
