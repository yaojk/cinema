package cn.edu.nuc.movie.service;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.movie.entity.Sysadmin;

public interface SysadminService {
	int deleteByPrimaryKey(Integer adminid);

    int insert(Sysadmin record);

    int insertSelective(Sysadmin record);

    Sysadmin selectByPrimaryKey(Integer adminid);

    int updateByPrimaryKeySelective(Sysadmin record);

    int updateByPrimaryKey(Sysadmin record);
    
    Sysadmin login(@Param("adminname") String adminname,@Param("adminpwd") String adminpwd);
}
