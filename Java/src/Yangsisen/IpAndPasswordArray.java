package Yangsisen;

import java.util.Scanner;

/**
 * @ClassName IpAndPasswordArray
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/4 20:51
 * @Version 1.0
 */
public class IpAndPasswordArray {
    public static final int maxnum=3;
    private IpAndPassword[] user=new IpAndPassword[3];
    public IpAndPassword[] getUser() {
        return user;
    }
    public void setUser(IpAndPassword[] user) {
        this.user = user;
    }
    public static int num3;
    static{
        int num3=0;
    }
}
