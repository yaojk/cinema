package cn.edu.nuc.movie.service;

import java.util.List;

import cn.edu.nuc.movie.entity.Sysfunction;
import cn.edu.nuc.movie.entity.Sysrole;

public interface SysroleService {

	int deleteByPrimaryKey(Integer roleid);

    int insert(Sysrole record);

    int insertSelective(Sysrole record);

    Sysrole selectByPrimaryKey(Integer roleid);
    /**
     * 获取所有的角色列表
     * @return
     */
    List<Sysrole> allList();

    int updateByPrimaryKeySelective(Sysrole record);

    int updateByPrimaryKey(Sysrole record);
    
    /**
     * 分配权限初始化页面数据
     * @param role
     * @return
     */
    List<Sysfunction> initfunlist(Sysrole role);
    
    /**
     * 保存角色权限
     * @param roleid
     * @param funids
     * @return
     */
    int saveright(String roleid,String[] funids );
}
