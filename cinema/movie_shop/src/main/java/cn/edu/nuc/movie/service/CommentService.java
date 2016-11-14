package cn.edu.nuc.movie.service;

import java.util.List;


import cn.edu.nuc.movie.entity.Comment;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.entity.User;
import cn.edu.nuc.movie.utils.PageBean;

public interface CommentService {

	   int deleteByPrimaryKey(Integer commentid);

	    int insert(Comment record);

	    int insertSelective(Comment record);

	    Comment selectByPrimaryKey(Integer commentid);

	    Comment selectByUid(User user);
	    
	    Comment selectByMovieid(Movie movie);
	    
	    int findCommentCount();
	    
	    PageBean<Comment> findByPage(Integer page);
	    
	    int updateByPrimaryKeySelective(Comment record);

	    int updateByPrimaryKey(Comment record);
}
