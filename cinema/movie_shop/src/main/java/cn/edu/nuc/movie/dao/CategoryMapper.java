package cn.edu.nuc.movie.dao;

import java.util.List;

import cn.edu.nuc.movie.entity.Category;

public interface CategoryMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer cid);

    /**
     * 查询所有的一级分类
     * @return
     */
    List<Category> findAll();
   
    
    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
}