package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.CategoryMapper;
import cn.edu.nuc.movie.dao.CategorysecondMapper;
import cn.edu.nuc.movie.entity.Categorysecond;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.service.CategorysecondService;
import cn.edu.nuc.movie.utils.PageBean;

@Service
public class CategorysecondServiceImpl implements CategorysecondService {

	@Autowired
	private CategorysecondMapper categorysecondMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer csid) {
		// TODO Auto-generated method stub
		return categorysecondMapper.deleteByPrimaryKey(csid);
	}

	@Override
	public int insert(Categorysecond record) {
		// TODO Auto-generated method stub
		return categorysecondMapper.insert(record);
	}

	@Override
	public int insertSelective(Categorysecond record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Categorysecond selectByPrimaryKey(Integer csid) {
		// TODO Auto-generated method stub
		return categorysecondMapper.selectByPrimaryKey(csid);
	}

	@Override
	public List<Categorysecond> findAll() {
		// TODO Auto-generated method stub
		return categorysecondMapper.findAll();
	}

	@Override
	public PageBean<Categorysecond> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Categorysecond> pageBean = new PageBean<Categorysecond>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = categorysecondMapper.findCategorysecondCount();
		// 设置总页数:
		int totalPage = 0;
		// Math.ceil(totalCount / limit);
		if (totalCount % limit == 0) {
				totalPage = totalCount / limit;
		} else {
				totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 每页显示的数据集合:
		// 从哪开始:
		int begin = (page - 1) * limit;
		List<Categorysecond> list = categorysecondMapper.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public int findCategorysecondCount() {
		// TODO Auto-generated method stub
		return categorysecondMapper.findCategorysecondCount();
	}

	@Override
	public int updateByPrimaryKeySelective(Categorysecond record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Categorysecond record) {
		// TODO Auto-generated method stub
		return categorysecondMapper.updateByPrimaryKey(record);
	}

}
