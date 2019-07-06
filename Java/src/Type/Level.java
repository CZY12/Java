package Type;

/**
 * @ClassName Level
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/28 19:22
 * @Version 1.0
 */
public class Level {
    public Level() {
    }

    public Level(int leveNo,  int strLength, int strTime,int timeLimit, int perScore) {
        this.leveNo = leveNo;
        this.strLength = strLength;
        this.strTime = strTime;
        this.timeLimit = timeLimit;
        this.perScore = perScore;
    }

    //各级别号
    private int leveNo;

    public int getLeveNo() {
        return leveNo;
    }

    public void setLeveNo(int leveNo) {
        this.leveNo = leveNo;
    }

    //各级别一次输出字符串的长度
    private int strLength;

    public int getStrLength() {
        return strLength;
    }

    public void setStrLength(int strLength) {
        this.strLength = strLength;
    }

    //各级玩家输出字符串的次数
    private int strTime;


    public int getStrTime() {
        return strTime;
    }

    public void setStrTime(int strTime) {
        this.strTime = strTime;
    }

    //各级别闯关的时间限制
    private int timeLimit;

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    //各级别正确输入一次的得分
    private int perScore;

    public int getPerScore() {
        return perScore;
    }

    public void setPerScore(int perScore) {
        this.perScore = perScore;
    }



}
