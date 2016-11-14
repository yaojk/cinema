package cn.edu.nuc.movie.entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车对象
 * @author kengkeng
 *
 */
public class Cart {

	//购物车属性
	//购物车集合:Map的key 就是商品movieid，value：购物项
	
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//Cart对象中有一个叫cartItems属性
	//转换城关于购物项的集合，便于页面遍历，不显示key
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	//购物总计
	private double total;

	public double getTotal() {
		return total;
	}
	    //购物车的功能
		//1.将购物项添加到购物车
		public void addCart(CartItem cartItem){
			//判断购物车中是否已经存在该购物项
			/**
			 * 如果存在
			 *   数量增加
			 *   总计 = 总计+购物项小计
			 * 如果不存在
			 *   向map中添加购物项
			 *   总计 = 总计+购物项小计
			 */
			//获得商品id
			Integer movieid = cartItem.getMovie().getMovieid();
			//判断购物车中是否已经存在该购物项
			if(map.containsKey(movieid)){
				//存在
				CartItem _cartItem = map.get(movieid);
				_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
			}else{
				//不存在
				map.put(movieid, cartItem);
			}
			
			//设置总计的值
			total += cartItem.getSubtotal();
		
		}
		//2.从购物车移除购物项
		public void removeCart(Integer movieid){
			//将购物项移除购物车
			CartItem cartItem = map.remove(movieid);
			// 总计 = 总计 -移除的购物项小计:
			total -= cartItem.getSubtotal();
		}
		//3.清空购物车
		public void clearCart(){
			//将所有购物项清空
			map.clear();
		    
			//将总计设置为0；
			total = 0;
		}
	
}
