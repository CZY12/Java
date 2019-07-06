package Yangsisen;

/**
 * @ClassName IpAndPassword
 * @Description TODO
 * @Author czy61
 * @Date 2019/7/4 20:51
 * @Version 1.0
 */
public class IpAndPassword {
    private String ip;
    private String password;
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public IpAndPassword() {
        // TODO Auto-generated constructor stub
    }
    public IpAndPassword(String ip, String password) {
        super();
        this.ip = ip;
        this.password = password;
    }
    @Override
    public String toString() {
        return "IpAndPassword [ip=" + ip + ", password=" + password + "]";
    }

}
