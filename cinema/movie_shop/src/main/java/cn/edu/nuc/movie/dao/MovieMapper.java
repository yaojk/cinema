package cn.edu.nuc.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.movie.entity.Movie;


public interface MovieMapper {
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
    
    List<Movie> findByPage(@Param("begin") int begin,@Param("limit") int limit);
    
    List<Movie> findByPageCid(@Param("cid") int cid,@Param("begin") int begin,@Param("limit") int limit);
    
    List<Movie> findByPageCsid(@Param("csid") int csid,@Param("begin") int begin,@Param("limit") int limit);
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