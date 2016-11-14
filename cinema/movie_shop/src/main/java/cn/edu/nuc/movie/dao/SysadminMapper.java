package cn.edu.nuc.movie.dao;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.movie.entity.Sysadmin;

public interface SysadminMapper {
    int deleteByPrimaryKey(Integer adminid);

    int insert(Sysadmin record);

    int insertSelective(Sysadmin record);

    Sysadmin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Sysadmin record);

    int updateByPrimaryKey(Sysadmin record);

	Sysadmin findByAdmin(@Param("adminname") String adminname,@Param("adminpwd") String adminpwd);
}