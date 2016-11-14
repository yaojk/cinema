package cn.edu.nuc.movie.entity;

public class Sysfunction {
    private Integer funid;

    private Integer sysFunid;

    private String funname;

    private String funurl;

    private Integer funstate;

    public Integer getFunid() {
        return funid;
    }

    public void setFunid(Integer funid) {
        this.funid = funid;
    }

    public Integer getSysFunid() {
        return sysFunid;
    }

    public void setSysFunid(Integer sysFunid) {
        this.sysFunid = sysFunid;
    }

    public String getFunname() {
        return funname;
    }

    public void setFunname(String funname) {
        this.funname = funname == null ? null : funname.trim();
    }

    public String getFunurl() {
        return funurl;
    }

    public void setFunurl(String funurl) {
        this.funurl = funurl == null ? null : funurl.trim();
    }

    public Integer getFunstate() {
        return funstate;
    }

    public void setFunstate(Integer funstate) {
        this.funstate = funstate;
    }
}