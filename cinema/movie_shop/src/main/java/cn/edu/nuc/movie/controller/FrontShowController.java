package cn.edu.nuc.movie.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nuc.movie.entity.Cart;
import cn.edu.nuc.movie.entity.CartItem;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.entity.Orderitem;
import cn.edu.nuc.movie.entity.Orders;
import cn.edu.nuc.movie.entity.User;
import cn.edu.nuc.movie.service.MovieService;
import cn.edu.nuc.movie.service.OrdersService;
import cn.edu.nuc.movie.utils.PageBean;
import cn.edu.nuc.movie.utils.PaymentUtil;

@Controller
public class FrontShowController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private OrdersService ordersService;

	@RequestMapping(value = "/findbymid", method = RequestMethod.GET)
	public String findByMid(Movie movie, Model model) {

		Movie mv = movieService.selectByPrimaryKey(movie.getMovieid());
		model.addAttribute("mv", mv);

		return "forward:/movie.jsp";
	}

	@RequestMapping(value = "/findbycid", method = RequestMethod.GET)
	public String findByCid(@RequestParam(name = "page", defaultValue = "1") int page, int cid, Model model) {
		PageBean<Movie> pageBean = movieService.findByPageCid(cid, page);
		model.addAttribute("pageBean", pageBean);
		return "forward:/movielist.jsp";
	}

	@RequestMapping(value = "/findbycsid", method = RequestMethod.GET)
	public String findByCsid(@RequestParam(name = "page", defaultValue = "1") int page, int csid, Model model) {
		PageBean<Movie> pageBean = movieService.findByPageCsid(csid, page);
		model.addAttribute("pageBean", pageBean);
		return "forward:/movielist.jsp";
	}

	@RequestMapping(value = "/orderslist", method = RequestMethod.GET)
	public String orderslist(Model model) {
		Orders orders = ordersService.findAll();
		model.addAttribute("orders", orders);
		return "forward:/order.jsp";
	}

	@RequestMapping(value = "/saveorder", method = RequestMethod.GET)
	public String saveorder(HttpSession session, Model model, Orders orders) {
		Cart cart = (Cart) session.getAttribute("cart");
		if (cart == null) {
			model.addAttribute("msg", "亲!您还没有购物!");
			return "forward:/cart.jsp";
		}
		orders.setTotal(cart.getTotal());
		orders.setState(1);
		// 设置订单的时间
		orders.setOrdertime(new Date());
		// 设置订单关联的客户
		User existUser = (User) session.getAttribute("existUser");
		if (existUser == null) {
			model.addAttribute("msg", "亲!您还没有登录!");
			return "forward:/login.jsp";
		}
		orders.setUid(existUser.getUid());
		orders.setName(existUser.getUname());
		orders.setPhone(existUser.getUphone());
		orders.setAddr(existUser.getUaddr());
		
		// 设置订单项集合
		for (CartItem cartItem : cart.getCartItems()) {
			// 订单项的信息从购物项获得的
			Orderitem orderItem = new Orderitem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setMovie(cartItem.getMovie());
			orderItem.setOrders(orders);
			orders.getOrderItems().add(orderItem);
		}
		ordersService.insert(orders);
        System.out.println(orders.getOid());
		// 清空购物车
		cart.clearCart();
		// 页面需要回显订单信息
		model.addAttribute("orders", orders);

		return "forward:/order.jsp";
	}
	
	@RequestMapping(value="/payorder",method=RequestMethod.POST)
	public void payOrder(Orders orders,String pd_FrpId1,HttpServletResponse response) throws IOException{
		Orders currOrder = ordersService.selectByPrimaryKey(orders.getOid());
		currOrder.setAddr(orders.getAddr());
		currOrder.setName(orders.getName());
		currOrder.setPhone(orders.getPhone());
		ordersService.updateByPrimaryKey(currOrder);
		        //2.完成付款
				//付款需要的参数
				String p0_Cmd = "Buy"; // 业务类型:
				String p1_MerId = "10001126856";// 商户编号:
				String p2_Order = orders.getOid().toString();// 订单编号:
				String p3_Amt = "0.01"; // 付款金额:
				String p4_Cur = "CNY"; // 交易币种:
				String p5_Pid = ""; // 商品名称:
				String p6_Pcat = ""; // 商品种类:
				String p7_Pdesc = ""; // 商品描述:
				String p8_Url = "http://172.31.1.57/orderscallBack"; // 商户接收支付成功数据的地址:
				String p9_SAF = ""; // 送货地址:
				String pa_MP = ""; // 商户扩展信息:
				String pd_FrpId = pd_FrpId1;// 支付通道编码:
				String pr_NeedResponse = "1"; // 应答机制:
				String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue); // hmac
				// 向易宝发送请求:
				StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
				sb.append("p0_Cmd=").append(p0_Cmd).append("&");
				sb.append("p1_MerId=").append(p1_MerId).append("&");
				sb.append("p2_Order=").append(p2_Order).append("&");
				sb.append("p3_Amt=").append(p3_Amt).append("&");
				sb.append("p4_Cur=").append(p4_Cur).append("&");
				sb.append("p5_Pid=").append(p5_Pid).append("&");
				sb.append("p6_Pcat=").append(p6_Pcat).append("&");
				sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
				sb.append("p8_Url=").append(p8_Url).append("&");
				sb.append("p9_SAF=").append(p9_SAF).append("&");
				sb.append("pa_MP=").append(pa_MP).append("&");
				sb.append("pd_FrpId=").append(pd_FrpId).append("&");
				sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
				sb.append("hmac=").append(hmac);		
				// 重定向:向易宝出发:
				response.sendRedirect(sb.toString());
	}
	
	@RequestMapping(value="/orderscallBack",method=RequestMethod.GET)
	public String callback(String r3_Amt,String r6_Order,Model model){
		Orders currOrder = ordersService.selectByPrimaryKey(Integer.parseInt(r6_Order));
		//修改订单状态为2：已经付款
		currOrder.setState(2);
		ordersService.updateByPrimaryKey(currOrder);
		model.addAttribute("msg", "支付成功！订单编号为：" +r6_Order+" 付款金额为: "+r3_Amt);
		return "msg";
	}
	

}
