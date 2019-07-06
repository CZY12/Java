package Type;

import java.util.Random;

/**
 * @ClassName Game
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/28 19:22
 * @Version 1.0
 */
public class Game {
    public Player player;

    public StringBuffer printStr(int strLength) {
//      int strLength = LeverParam.levers[player.getLeveNo()-1].getStrLength();
        StringBuffer buffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < strLength; i++) {
            int rand = random.nextInt(strLength);
            switch (rand) {
                case 0:
                    buffer.append(">");
                    break;
                case 1:
                    buffer.append("<");
                    break;
                case 2:
                    buffer.append("q");
                    break;
                case 3:
                    buffer.append("w");
                    break;
                case 4:
                    buffer.append("e");
                    break;
                case 5:
                    buffer.append("g");
                    break;
                case 6:
                    buffer.append("h");
                    break;
                default:
                    System.out.println("异常");
                    break;
            }
        }
        return buffer;
    }

    public int printResult(String out, String in,Player player) {
        int integral=0;
        if (out.equals(in)) {
            long currentTime = System.currentTimeMillis();
            if((currentTime-player.getStartTime())/1000>LeverParam.levers[player.getLeveNo()].getTimeLimit()) {
                System.out.println("你输入太慢了，已超时\n将会退出");
                System.exit(0);
            }
            player.setCurrScore(player.getCurrScore()+LeverParam.levers[player.getLeveNo()].getPerScore());
            integral =player.getCurrScore();
//            System.out.println(player.getCurrScore());
            System.out.println("输入正确,用时"+(currentTime-player.getStartTime())/1000+"s");
        } else {
            System.out.println("输入错误\n即将退出");
            System.exit(0);
        }
        return integral;
    }
}
