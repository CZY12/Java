package GoShopManagement;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @ClassName IdAndPassowrd
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/26 11:31
 * @Version 1.0
 */
public class IdAndPassowrd {
     private String id ;
     private String password;

     public IdAndPassowrd(){

     }

     public IdAndPassowrd(String id, String password){
         super();
         this.id = id;
         this.id = password;
     }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdAndPassowrd)) return false;
        IdAndPassowrd that = (IdAndPassowrd) o;
        return getId().equals(that.getId()) &&
                getPassword().equals(that.getPassword());
    }

    @Override
    public String toString() {
        return "IdAndPassowrd{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
