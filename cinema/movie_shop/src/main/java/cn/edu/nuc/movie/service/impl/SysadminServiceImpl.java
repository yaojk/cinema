package cn.edu.nuc.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.SysadminMapper;
import cn.edu.nuc.movie.entity.Sysadmin;
import cn.edu.nuc.movie.service.SysadminService;
@Service
public class SysadminServiceImpl implements SysadminService {

    @Autowired
	private SysadminMapper sysadminMapper;
    
	@Override
	public int deleteByPrimaryKey(Integer adminid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Sysadmin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Sysadmin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sysadmin selectByPrimaryKey(Integer adminid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Sysadmin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Sysadmin record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sysadmin login(String adminname, String adminpwd) {
		// TODO Auto-generated method stub
		Sysadmin admin = sysadminMapper.findByAdmin(adminname, adminpwd);
		
		if(admin == null){
			 throw new RuntimeException("用户名或密码错误");
		}
		return admin;
	}

}
