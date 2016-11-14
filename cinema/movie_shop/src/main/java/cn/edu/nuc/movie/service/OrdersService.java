package cn.edu.nuc.movie.service;



import cn.edu.nuc.movie.entity.Orders;
import cn.edu.nuc.movie.utils.PageBean;

public interface OrdersService {

	    int deleteByPrimaryKey(Integer oid);

	    int insert(Orders record);

	    int insertSelective(Orders record);

	    Orders selectByPrimaryKey(Integer oid);

	    int updateByPrimaryKeySelective(Orders record);

	    int updateByPrimaryKey(Orders record);
	    
	    Orders findAll();
	    
	    int findOrdersCount();
	    
	    int findCountByUid(Integer uid);
	    
	    PageBean<Orders> findByPage(Integer page);
	    
	    PageBean<Orders> findPageByUid(Integer uid,Integer page);
}
