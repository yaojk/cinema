package cn.edu.nuc.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.movie.entity.Categorysecond;

public interface CategorysecondMapper {
    int deleteByPrimaryKey(Integer csid);

    int insert(Categorysecond record);

    int insertSelective(Categorysecond record);

    Categorysecond selectByPrimaryKey(Integer csid);

    List<Categorysecond> findAll();
    
    List<Categorysecond> findByPage(@Param("begin") int begin,@Param("limit") int limit);
    
    int findCategorysecondCount();
    
    int updateByPrimaryKeySelective(Categorysecond record);

    int updateByPrimaryKey(Categorysecond record);
}