package cn.edu.nuc.movie.entity;

import java.util.Date;

public class News {
    private Integer newsid;

    private String newscontent;

    private Date newstime;

    public Integer getNewsid() {
        return newsid;
    }

    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent == null ? null : newscontent.trim();
    }

    public Date getNewstime() {
        return newstime;
    }

    public void setNewstime(Date newstime) {
        this.newstime = newstime;
    }
}