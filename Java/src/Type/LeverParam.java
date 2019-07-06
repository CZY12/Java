package Type;

/**
 * @ClassName LeverParam
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/28 19:42
 * @Version 1.0
 */
public class LeverParam extends Level {
    public final static Level levers[]=new Level[6];
    static {
        levers[0]=new Level(1,2,10,30,1);
        levers[1]=new Level(2,3,9,26,2);
        levers[2]=new Level(3,4,8,22,5);
        levers[3]=new Level(4,5,7,18,8);
        levers[4]=new Level(5,6,6,15,10);
        levers[5]=new Level(6,7,5,12,15);
    }
}
