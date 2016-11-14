package cn.edu.nuc.movie.entity;

import java.util.HashSet;
import java.util.Set;

public class Category {
    private Integer cid;

    private String cname;

    // 一级分类中存放二级分类的集合:
 	private Set<Categorysecond> categorySeconds = new HashSet<Categorysecond>();
 	
    public Set<Categorysecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<Categorysecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }
}