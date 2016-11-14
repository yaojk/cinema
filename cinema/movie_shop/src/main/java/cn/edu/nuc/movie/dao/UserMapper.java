package cn.edu.nuc.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.movie.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    User findByUname(@Param("username") String username);
    int findCount();
    
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> findByPage(@Param("begin") int begin,@Param("limit") int limit);
    
	User findByUser(@Param("username") String username,@Param("password") String password);
}