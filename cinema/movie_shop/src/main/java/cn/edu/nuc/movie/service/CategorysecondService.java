package cn.edu.nuc.movie.service;

import java.util.List;

import cn.edu.nuc.movie.entity.Categorysecond;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.utils.PageBean;

public interface CategorysecondService {

    int deleteByPrimaryKey(Integer csid);

    int insert(Categorysecond record);

    int insertSelective(Categorysecond record);

    Categorysecond selectByPrimaryKey(Integer csid);

    List<Categorysecond> findAll();
    
    PageBean<Categorysecond> findByPage(Integer page);
    
    int findCategorysecondCount();
    
    int updateByPrimaryKeySelective(Categorysecond record);

    int updateByPrimaryKey(Categorysecond record);
}
