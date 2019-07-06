package GoShopManagement;

/**
 * @ClassName IdAndPasswordArray
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 14:58
 * @Version 1.0
 */
public class IdAndPasswordArray {
    private IdAndPassowrd[] ids;
    private int num;

    public IdAndPasswordArray() {

    }

    public IdAndPasswordArray(int maxNum) {
        ids = new IdAndPassowrd[maxNum];
        num = 0;
    }

    public int getNum() {
        return num;
    }

    public void insertId(IdAndPassowrd idAndPassowrd) {
        ids[num] = idAndPassowrd;
        num++;
    }

    public boolean findId(IdAndPassowrd idAndPassowrd) {
        for (int i = 0; i < num; i++) {
            if (idAndPassowrd.equals(ids[i]))
                return true;
        }
        return false;
    }

    public void displayId() {
        for (int i = 0; i < num; i++) {
            System.out.println(ids[i].toString());
        }
    }

    public boolean deleteId(IdAndPassowrd idAndPassowrd) {
        int goalPos;
        for (goalPos = 0; goalPos < num; goalPos++)
            if (idAndPassowrd.equals(ids[goalPos]))
                break;
        if (goalPos == num)
            return false;
        else {
            for (int i = goalPos; i<num; i++)
                ids[i] = ids[i+1];
            num--;
            return true;
        }
    }
}
