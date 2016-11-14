package cn.edu.nuc.movie.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Comment {
    private Integer commentid;

    private Integer uid;

    private Integer movieid;

    private String ccontent;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date commenttime;

    private Integer cisHot;

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent == null ? null : ccontent.trim();
    }

    public Date getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Date commenttime) {
        this.commenttime = commenttime;
    }

    public Integer getCisHot() {
        return cisHot;
    }

    public void setCisHot(Integer cisHot) {
        this.cisHot = cisHot;
    }
}