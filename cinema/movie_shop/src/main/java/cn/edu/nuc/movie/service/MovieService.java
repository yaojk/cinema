package cn.edu.nuc.movie.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.utils.PageBean;

public interface MovieService {

	    int deleteByPrimaryKey(Integer movieid);

	    int insert(Movie record);

	    int insertSelective(Movie record);

	    Movie selectByPrimaryKey(Integer movieid);

	    int updateByPrimaryKeySelective(Movie record);

	    int updateByPrimaryKey(Movie record);
	    
	    List<Movie> listMovie();
	    
	    
	    List<Movie> findByMname(String mname);
	    
	    int findMovieCount();
	    
	    int findMovieCountCid(Integer cid);
	    int findMovieCountCsid(Integer csid);
	    PageBean<Movie> findByPage(Integer page);
	    
	    PageBean<Movie> findByPageCid(Integer cid,Integer page);
	    
	    PageBean<Movie> findByPageCsid(Integer csid,Integer page);
	    //前台 
	    
	    /**列出最新的10条商品
	     * @return list
	     */
	    List<Movie> listMovieNew();
	    
	    
	    /**列出最热的10条商品
	     * @return list
	     */
	    List<Movie> listMovieHot();
}
