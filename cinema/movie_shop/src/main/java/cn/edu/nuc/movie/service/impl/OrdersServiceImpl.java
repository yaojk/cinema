package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.OrdersMapper;
import cn.edu.nuc.movie.entity.Orders;
import cn.edu.nuc.movie.service.OrdersService;
import cn.edu.nuc.movie.utils.PageBean;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer oid) {
		// TODO Auto-generated method stub
		return ordersMapper.deleteByPrimaryKey(oid);
	}

	@Override
	public int insert(Orders record) {
		// TODO Auto-generated method stub
		return ordersMapper.insert(record);
	}

	@Override
	public int insertSelective(Orders record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Orders selectByPrimaryKey(Integer oid) {
		// TODO Auto-generated method stub
		return ordersMapper.selectByPrimaryKey(oid);
	}

	@Override
	public int updateByPrimaryKeySelective(Orders record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Orders record) {
		// TODO Auto-generated method stub
		return ordersMapper.updateByPrimaryKey(record);
	}

	@Override
	public int findOrdersCount() {
		// TODO Auto-generated method stub
		return ordersMapper.findOrdersCount();
	}

	@Override
	public int findCountByUid(Integer uid) {
		// TODO Auto-generated method stub
		return ordersMapper.findCountByUid(uid);
	}

	@Override
	public PageBean<Orders> findByPage(Integer page) {
		PageBean<Orders> pageBean = new PageBean<Orders>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数: 
		int totalCount = 0;
		totalCount = ordersMapper.findOrdersCount();
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
		} else {
				totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Orders> list = ordersMapper.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<Orders> findPageByUid(Integer uid, Integer page) {
//		// TODO Auto-generated method stub
		PageBean<Orders> pageBean = new PageBean<Orders>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数: 
		int totalCount = 0;
		totalCount = ordersMapper.findCountByUid(uid);
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
		} else {
				totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Orders> list = ordersMapper.findPageByUid(uid, begin, limit);
		pageBean.setList(list);
		return pageBean;

	}

	@Override
	public Orders findAll() {
		// TODO Auto-generated method stub
		return ordersMapper.findAll();
	}

}
