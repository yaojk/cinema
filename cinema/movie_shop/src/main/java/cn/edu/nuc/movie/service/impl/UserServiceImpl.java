package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.UserMapper;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.entity.User;
import cn.edu.nuc.movie.service.UserService;
import cn.edu.nuc.movie.utils.PageBean;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.deleteByPrimaryKey(uid);
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer uid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(uid);
	}

	@Override
	public int findCount() {
		// TODO Auto-generated method stub
		return userMapper.findCount();
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userMapper.findByUser(username, password);
		
		return user;
	}

	@Override
	public PageBean<User> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<User> pageBean = new PageBean<User>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = userMapper.findCount();
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
		List<User> list = userMapper.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public User findByUname(User record) {
		// TODO Auto-generated method stub
		return userMapper.findByUname(record.getUsername());
	}

}
