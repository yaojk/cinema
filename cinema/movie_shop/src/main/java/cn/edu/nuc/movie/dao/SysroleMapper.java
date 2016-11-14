package cn.edu.nuc.movie.dao;

import cn.edu.nuc.movie.entity.Sysrole;

public interface SysroleMapper {
    int deleteByPrimaryKey(Integer roleid);

    int insert(Sysrole record);

    int insertSelective(Sysrole record);

    Sysrole selectByPrimaryKey(Integer roleid);

    int updateByPrimaryKeySelective(Sysrole record);

    int updateByPrimaryKey(Sysrole record);
}