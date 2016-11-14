package cn.edu.nuc.movie.service;

import java.util.List;

import cn.edu.nuc.movie.entity.Orderitem;

public interface OrderitemService {

	 List<Orderitem> findOrderItemByOid(Integer oid);
}
