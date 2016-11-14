package cn.edu.nuc.movie.service;


import cn.edu.nuc.movie.entity.User;
import cn.edu.nuc.movie.utils.PageBean;

public interface UserService {
	    int deleteByPrimaryKey(Integer uid);

	    int insert(User record);

	    int insertSelective(User record);

	    User selectByPrimaryKey(Integer uid);

	    int findCount();
	    
	    int updateByPrimaryKeySelective(User record);

	    int updateByPrimaryKey(User record);
	    
	    User login(String username,String password);
	    
	    PageBean<User> findByPage(Integer page);
	    
	    User findByUname(User record);
}
