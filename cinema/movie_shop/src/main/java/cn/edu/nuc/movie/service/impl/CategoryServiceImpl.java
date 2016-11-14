package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.CategoryMapper;
import cn.edu.nuc.movie.entity.Category;
import cn.edu.nuc.movie.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return categoryMapper.deleteByPrimaryKey(cid);
	}

	@Override
	public int insert(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.insert(record);
	}

	@Override
	public int insertSelective(Category record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category selectByPrimaryKey(Integer cid) {
		// TODO Auto-generated method stub
		return categoryMapper.selectByPrimaryKey(cid);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryMapper.findAll();
	}

	@Override
	public int updateByPrimaryKeySelective(Category record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Category record) {
		// TODO Auto-generated method stub
		return categoryMapper.updateByPrimaryKey(record);
	}

}
