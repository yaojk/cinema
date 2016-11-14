package cn.edu.nuc.movie.dao;

import java.util.List;

import cn.edu.nuc.movie.entity.Orderitem;

public interface OrderitemMapper {
    int deleteByPrimaryKey(Integer itemid);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    Orderitem selectByPrimaryKey(Integer itemid);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);
    
    List<Orderitem> findOrderItemByOid(Orderitem record);
}