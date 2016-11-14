package cn.edu.nuc.movie.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.nuc.movie.entity.Cart;
import cn.edu.nuc.movie.entity.CartItem;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.service.MovieService;

@Controller
public class CartController {

	@Autowired
	private MovieService movieService;
	
	//将购物项添加到购物车：执行的方法
	@RequestMapping(value="/addcart",method=RequestMethod.GET)
	public String addCart(int movieid,String count,HttpSession session){
		//封装一个CartItem对象
		CartItem cartItem = new CartItem();
		//设置数量
		int count1 = Integer.parseInt(count);
		cartItem.setCount(count1);
		//根据movieid进行查询商品
		Movie movie = movieService.selectByPrimaryKey(movieid);
		cartItem.setMovie(movie);
		//将购物项添加到购物车
		//购物车应该存到session
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			session.setAttribute("cart",cart);
		}
		cart.addCart(cartItem);
		
		return "forward:mycart";
	}
	
	//清空购物车的执行的方法
	@RequestMapping(value="/clearcart",method=RequestMethod.GET)
	public String clearCart(HttpSession session){
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			session.setAttribute("cart",cart);
		}
		cart.clearCart();
		session.removeAttribute("cart");
		return "forward:mycart";
	}
	
	//从购物车中移除购物项的方法
	@RequestMapping(value="/removecart",method=RequestMethod.GET)
	public String removeCart(HttpSession session,int movieid){
		Cart cart = (Cart) session.getAttribute("cart");
		if(cart == null){
			cart = new Cart();
			session.setAttribute("cart",cart);
		}
		cart.removeCart(movieid);
		if(cart.getCartItems().size()==0){
			session.removeAttribute("cart");
		}
		return "forward:mycart";
	}
	//我的购物车：执行的方法
	@RequestMapping(value="/mycart",method=RequestMethod.GET)
	public String myCart(){
		return "forward:/cart.jsp";
	}
	
}
