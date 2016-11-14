package cn.edu.nuc.movie.dao;

import cn.edu.nuc.movie.entity.News;

public interface NewsMapper {
    int deleteByPrimaryKey(Integer newsid);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsid);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);
}