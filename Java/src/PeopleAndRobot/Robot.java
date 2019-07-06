package PeopleAndRobot;

/**
 * @ClassName Robot
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 20:34
 * @Version 1.0
 */
public class Robot {
    public int score;
    public String role(int num){
        String fist ;
        switch (num) {
            case 1:
                fist =  "刘备";
                break;
            case 2:
                fist =  "曹操";
                break;
            case 3:
                fist =  "孙权";
                break;
            default:
                fist = "输入错误";
                break;
        }
        return fist;
    }

    public  int showFist(){
        int num = (int)(Math.random()*3);
        return num;
    }

}
