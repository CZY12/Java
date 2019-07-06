package Type;

/**
 * @ClassName Test
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/29 9:08
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args){
        Game game = new Game();
        Player player = new Player();
        for (int i = 0; i<6;) {
            player.setLeveNo(i);
            System.out.println(player.getLeveNo());
            StringBuffer out1 = game.printStr(LeverParam.levers[player.getLeveNo()].getStrLength());
            String out2 = new String(out1);
            System.out.println(out2);
            player.setStartTime(System.currentTimeMillis());
            String in = player.play();
            int a = game.printResult(out2 , in ,player);
            System.out.println("当前积分为："+a);
            if(a%10==0)
                i++;
        }
    }
}
