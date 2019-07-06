package Type;

import java.util.Scanner;

/**
 * @ClassName Player
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/28 19:22
 * @Version 1.0
 */
public class Player {
    //玩家当前级别
    private int leveNo;
    //玩家当前积分
    private int currScore;
    //当前级别开始时间
    private long startTime;
    //当前级别已用时间
    private int elapsedTime;

    public int getLeveNo() {
        return leveNo;
    }

    public void setLeveNo(int leveNo) {
        this.leveNo = leveNo;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String play(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入");
        String strings = input.next();
        return strings;
    }

}
