package cn.edu.nuc.movie.entity;

public class Sysadmin {
    private Integer adminid;

    private Integer roleid;

    private String adminname;

    private String adminpwd;

    private String admintruename;

    private Integer adminstate;

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpwd() {
        return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
        this.adminpwd = adminpwd == null ? null : adminpwd.trim();
    }

    public String getAdmintruename() {
        return admintruename;
    }

    public void setAdmintruename(String admintruename) {
        this.admintruename = admintruename == null ? null : admintruename.trim();
    }

    public Integer getAdminstate() {
        return adminstate;
    }

    public void setAdminstate(Integer adminstate) {
        this.adminstate = adminstate;
    }
}