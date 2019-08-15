package entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class ShopCar {

	// 定义一个集合来装购物车的商品
	private List<GoodInfo> list = new ArrayList<>();

	// 提供一个方法给外界调用，然后得到一辆购物车
	public static ShopCar getShopCar(HttpSession session) {
		// 可以先从域中取到购物车，然后进行判断，如果购物车为空，则创建一个购物车
		ShopCar shopCar = (ShopCar) session.getAttribute("SHOP_CAR");
		if (shopCar == null) {
			shopCar = new ShopCar();
			// 把购物车存到域中
			session.setAttribute("SHOP_CAR", shopCar);
		}
		return shopCar;
	}
	
	//往购物车添加商品
	public void add(GoodInfo goodInfo){
		boolean flag = true;
		//判断购物车是否有该商品
		for (GoodInfo good : getList()) {
			if(good.getId()==goodInfo.getId()){
				//修改购物车中这个商品数量
				good.setCount(good.getCount()+goodInfo.getCount());
				//表示有这个商品
				flag = false;
				return;
			}
		}
		
		if(flag){
			//往购物车添加这个商品
			getList().add(goodInfo);
		}
	}
	
	//修改购物车中某个商品的数量
	public void update(int id,int count){
		for (GoodInfo goodInfo : getList()) {
			if(goodInfo.getId()==id){
				//修改商品数量
				goodInfo.setCount(count);
				return;
			}
		}
	}
	
	//删除商品
	public void delete(int id){
		for (GoodInfo goodInfo : getList()) {
			if(goodInfo.getId()==id){
				//移除商品
				getList().remove(goodInfo);
				return;
			}
		}
	}
	
	//计算这个购物车中商品的总额
	public double getTotalPrice(){
		BigDecimal totalPrice = new BigDecimal(String.valueOf(0));
		for (GoodInfo goodInfo : getList()) {
			totalPrice = totalPrice.add(new BigDecimal(String.valueOf(goodInfo.getDanPrice())));
		}
		return totalPrice.doubleValue();
	}

	public List<GoodInfo> getList() {
		return list;
	}

	public void setList(List<GoodInfo> list) {
		this.list = list;
	}
}
