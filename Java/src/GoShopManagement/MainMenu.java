package GoShopManagement;

/**
 * @ClassName MainMenu
 * @Description TODO
 * @Author czy61
 * @Date 2019/6/25 19:49
 * @Version 1.0
 */
public class MainMenu {
    Menu menu = new Menu();
    public void allCustInfo(){

        menu.showCustMenu();
    }
    public void Shoppingettlement(){
        System.out.println("购物结算");
    }
    public void FeedBack(){
        menu.showSendMenu();
    }
}
