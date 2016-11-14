package cn.edu.nuc.movie.service;

import java.util.List;

import cn.edu.nuc.movie.entity.Sysfunction;

public interface SysfunctionService {

	   int deleteByPrimaryKey(Integer funid);

	    int insert(Sysfunction record);

	    int insertSelective(Sysfunction record);

	    Sysfunction selectByPrimaryKey(Integer funid);
	    
	    Sysfunction findByFun(String funname);

	    int updateByPrimaryKeySelective(Sysfunction record);

	    int updateByPrimaryKey(Sysfunction record);
	    
	    List<Sysfunction> selectAll();
}
