package cn.edu.nuc.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.edu.nuc.movie.entity.Orderitem;
import cn.edu.nuc.movie.entity.Orders;
import cn.edu.nuc.movie.service.MovieService;
import cn.edu.nuc.movie.service.OrderitemService;
import cn.edu.nuc.movie.service.OrdersService;
import cn.edu.nuc.movie.utils.PageBean;

@Controller
@RequestMapping("orders")
public class OrdersController {

	@Autowired
	private OrdersService ordersService;
	@Autowired
	private OrderitemService orderitemService;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String findAll(@RequestParam(name="page",defaultValue="1") int page,Model model){
		PageBean<Orders> pageBean = ordersService.findByPage(page);
		model.addAttribute("pageBean",pageBean);
		return "orders/list";
	}
	
	@RequestMapping(value="/orderItemlist",method=RequestMethod.GET)
	public String findOrderItem(Orderitem orderitem , Model model){
		List<Orderitem> orderItems = orderitemService.findOrderItemByOid(orderitem.getOrders().getOid());
		System.out.println(orderItems);
		model.addAttribute("orderItems", orderItems);
		return "orders/orderItem";
	}
	
	
	
}
