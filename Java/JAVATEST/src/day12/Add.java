package day12;

/**
 * @ClassName Add
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/3 11:53
 * @Version 1.0
 */
public class Add {
    public static void main(String[] args){
        AddInterface add = new AddInterface(){

            @Override
            public void add(int num1, int num2) {
                int result = num1+num2;
                System.out.println(result);
            }
        };

        add.add(1,2);
    }

}
