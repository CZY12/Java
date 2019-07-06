package PeopleAndRobot;

/**
 * @ClassName User
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 20:34
 * @Version 1.0
 */
public class User {
    public String name;
    public int score;

    public String showFist(int num) {
        String fist ;
        switch (num) {
            case 1:
                fist =  "剪刀";
            break;
            case 2:
                fist =  "石头";
            break;
            case 3:
                fist =  "布";
            break;
            default:
                fist = "输入错误";
                break;
        }
        return fist;
    }
}
