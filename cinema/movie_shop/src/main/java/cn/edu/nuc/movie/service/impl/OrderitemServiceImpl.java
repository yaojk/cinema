package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.OrderitemMapper;
import cn.edu.nuc.movie.entity.Orderitem;
import cn.edu.nuc.movie.entity.Orders;
import cn.edu.nuc.movie.service.OrderitemService;
@Service
public class OrderitemServiceImpl implements OrderitemService {

	@Autowired
	private OrderitemMapper orderitemMapper;
	@Override
	public List<Orderitem> findOrderItemByOid(Integer oid) {
		// TODO Auto-generated method stub
		Orderitem orderitem = new Orderitem();
		Orders orders = new Orders();
		orders.setOid(oid);
		orderitem.setOrders(orders);
		return orderitemMapper.findOrderItemByOid(orderitem);
	}

}
