package cn.edu.nuc.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.dao.MovieMapper;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.service.MovieService;
import cn.edu.nuc.movie.utils.PageBean;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer movieid) {
		// TODO Auto-generated method stub
		return movieMapper.deleteByPrimaryKey(movieid);
	}

	@Override
	public int insert(Movie record) {
		// TODO Auto-generated method stub
		return movieMapper.insert(record);
	}

	@Override
	public int insertSelective(Movie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Movie selectByPrimaryKey(Integer movieid) {
		// TODO Auto-generated method stub
		return movieMapper.selectByPrimaryKey(movieid);
	}

	@Override
	public int updateByPrimaryKeySelective(Movie record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Movie record) {
		// TODO Auto-generated method stub
		return movieMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Movie> listMovie() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movie> findByMname(String mname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findMovieCount() {
		// TODO Auto-generated method stub
		return movieMapper.findMovieCount();
	}

	@Override
	public PageBean<Movie> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Movie> pageBean = new PageBean<Movie>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = movieMapper.findMovieCount();
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
		List<Movie> list = movieMapper.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public List<Movie> listMovieNew() {
		// TODO Auto-generated method stub
		return movieMapper.listMovieNew();
	}

	@Override
	public List<Movie> listMovieHot() {
		// TODO Auto-generated method stub
		return movieMapper.listMovieHot();
	}

	@Override
	public PageBean<Movie> findByPageCid(Integer cid, Integer page) {
		// TODO Auto-generated method stub
				PageBean<Movie> pageBean = new PageBean<Movie>();
				// 设置当前页数:
				pageBean.setPage(page);
				// 设置每页显示记录数:
				int limit = 10;
				pageBean.setLimit(limit);
				// 设置总记录数:
				int totalCount = 0;
				totalCount = movieMapper.findMovieCountCid(cid);
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
				List<Movie> list = movieMapper.findByPageCid(cid, begin, limit);
				pageBean.setList(list);
				return pageBean;
	}

	@Override
	public PageBean<Movie> findByPageCsid(Integer csid, Integer page) {
		// TODO Auto-generated method stub
				PageBean<Movie> pageBean = new PageBean<Movie>();
				// 设置当前页数:
				pageBean.setPage(page);
				// 设置每页显示记录数:
				int limit = 10;
				pageBean.setLimit(limit);
				// 设置总记录数:
				int totalCount = 0;
				totalCount = movieMapper.findMovieCountCsid(csid);
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
				List<Movie> list = movieMapper.findByPageCsid(csid, begin, limit);
				pageBean.setList(list);
				return pageBean;
	}

	@Override
	public int findMovieCountCid(Integer cid) {
		// TODO Auto-generated method stub
		return movieMapper.findMovieCountCid(cid);
	}

	@Override
	public int findMovieCountCsid(Integer csid) {
		// TODO Auto-generated method stub
		return movieMapper.findMovieCountCsid(csid);
	}



}
