package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.SysfunctionMapper;
import cn.edu.nuc.movie.entity.Sysfunction;
import cn.edu.nuc.movie.service.SysfunctionService;
@Service
public class SysfunctionServiceImpl implements SysfunctionService {

	@Autowired
	private SysfunctionMapper sysfunctionMapper;
	@Override
	public int deleteByPrimaryKey(Integer funid) {
		// TODO Auto-generated method stub
		return sysfunctionMapper.deleteByPrimaryKey(funid);
	}

	@Override
	public int insert(Sysfunction record) {
		// TODO Auto-generated method stub
		return sysfunctionMapper.insert(record);
	}

	@Override
	public int insertSelective(Sysfunction record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Sysfunction selectByPrimaryKey(Integer funid) {
		// TODO Auto-generated method stub
		return sysfunctionMapper.selectByPrimaryKey(funid);
	}

	@Override
	public Sysfunction findByFun(String funname) {
		// TODO Auto-generated method stub
		return sysfunctionMapper.findByFun(funname);
	}

	@Override
	public int updateByPrimaryKeySelective(Sysfunction record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Sysfunction record) {
		// TODO Auto-generated method stub
		return sysfunctionMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Sysfunction> selectAll() {
		// TODO Auto-generated method stub
		return sysfunctionMapper.selectAll();
	}

}
