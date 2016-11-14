package cn.edu.nuc.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.nuc.movie.entity.Comment;
import cn.edu.nuc.movie.entity.Movie;
import cn.edu.nuc.movie.entity.User;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentid);

    Comment selectByUid(User user);
    
    Comment selectByMovieid(Movie movie);
    
    int findCommentCount();
    
    List<Comment> findByPage(@Param("begin") int begin,@Param("limit") int limit);
    
    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}