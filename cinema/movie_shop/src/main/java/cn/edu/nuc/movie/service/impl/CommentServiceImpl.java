package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.CommentMapper;
import cn.edu.nuc.movie.entity.Comment;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.entity.User;
import cn.edu.nuc.movie.service.CommentService;
import cn.edu.nuc.movie.utils.PageBean;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer commentid) {
		// TODO Auto-generated method stub
		return commentMapper.deleteByPrimaryKey(commentid);
	}

	@Override
	public int insert(Comment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Comment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Comment selectByPrimaryKey(Integer commentid) {
		// TODO Auto-generated method stub
		return commentMapper.selectByPrimaryKey(commentid);
	}

	@Override
	public Comment selectByUid(User user) {
		// TODO Auto-generated method stub
		return commentMapper.selectByUid(user);
	}

	@Override
	public Comment selectByMovieid(Movie movie) {
		// TODO Auto-generated method stub
		return commentMapper.selectByMovieid(movie);
	}

	@Override
	public PageBean<Comment> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Comment> pageBean = new PageBean<Comment>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = commentMapper.findCommentCount();
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
		List<Comment> list = commentMapper.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public int updateByPrimaryKeySelective(Comment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Comment record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findCommentCount() {
		// TODO Auto-generated method stub
		return commentMapper.findCommentCount();
	}

}
