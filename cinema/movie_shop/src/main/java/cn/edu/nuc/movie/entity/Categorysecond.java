package cn.edu.nuc.movie.entity;

public class Categorysecond {
    private Integer csid;

    private Integer cid;

    private String csname;

    //所属一级分类存的是一级分类的对象
  	private Category category;
  	
    public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCsname() {
        return csname;
    }

    public void setCsname(String csname) {
        this.csname = csname == null ? null : csname.trim();
    }
}