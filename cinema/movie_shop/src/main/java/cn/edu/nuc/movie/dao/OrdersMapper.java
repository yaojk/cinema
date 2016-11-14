package cn.edu.nuc.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.movie.entity.Orders;

public interface OrdersMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    Orders findAll();
    
    int findOrdersCount();
    
    int findCountByUid(@Param("uid") int uid);
    
    List<Orders> findByPage(@Param("begin") int begin,@Param("limit") int limit);
    
    List<Orders> findPageByUid(@Param("uid") int uid, @Param("begin") int begin,@Param("limit") int limit);
}