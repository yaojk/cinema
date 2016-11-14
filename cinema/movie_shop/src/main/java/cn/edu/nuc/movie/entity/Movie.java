package cn.edu.nuc.movie.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Movie {
    private Integer movieid;

    private Integer csid;

    private String mname;

    private String mdirector;

    private String mstar;

    private String mtype;

    private String mcountry;

    private String mstory;

    private String mduration;

    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date mpremiere;

    private Integer misHot;

    private String mimage;

    private Double marketprice;

    private Double shopprice;

    private String mticketcount;

    private Float mscore;

    public Integer getMovieid() {
        return movieid;
    }

    public void setMovieid(Integer movieid) {
        this.movieid = movieid;
    }

    public Integer getCsid() {
        return csid;
    }

    public void setCsid(Integer csid) {
        this.csid = csid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname == null ? null : mname.trim();
    }

    public String getMdirector() {
        return mdirector;
    }

    @Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", csid=" + csid + ", mname=" + mname + ", mdirector=" + mdirector
				+ ", mstar=" + mstar + ", mtype=" + mtype + ", mcountry=" + mcountry + ", mstory=" + mstory
				+ ", mduration=" + mduration + ", mpremiere=" + mpremiere + ", misHot=" + misHot + ", mimage=" + mimage
				+ ", marketprice=" + marketprice + ", shopprice=" + shopprice + ", mticketcount=" + mticketcount
				+ ", mscore=" + mscore + "]";
	}

	public void setMdirector(String mdirector) {
        this.mdirector = mdirector == null ? null : mdirector.trim();
    }

    public String getMstar() {
        return mstar;
    }

    public void setMstar(String mstar) {
        this.mstar = mstar == null ? null : mstar.trim();
    }

    public String getMtype() {
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype == null ? null : mtype.trim();
    }

    public String getMcountry() {
        return mcountry;
    }

    public void setMcountry(String mcountry) {
        this.mcountry = mcountry == null ? null : mcountry.trim();
    }

    public String getMstory() {
        return mstory;
    }

    public void setMstory(String mstory) {
        this.mstory = mstory == null ? null : mstory.trim();
    }

    public String getMduration() {
        return mduration;
    }

    public void setMduration(String mduration) {
        this.mduration = mduration == null ? null : mduration.trim();
    }

    public Date getMpremiere() {
        return mpremiere;
    }

    public void setMpremiere(Date mpremiere) {
        this.mpremiere = mpremiere;
    }

    public Integer getMisHot() {
        return misHot;
    }

    public void setMisHot(Integer misHot) {
        this.misHot = misHot;
    }

    public String getMimage() {
        return mimage;
    }

    public void setMimage(String mimage) {
        this.mimage = mimage == null ? null : mimage.trim();
    }

   

    public Double getMarketprice() {
		return marketprice;
	}

	public void setMarketprice(Double marketprice) {
		this.marketprice = marketprice;
	}

	public Double getShopprice() {
		return shopprice;
	}

	public void setShopprice(Double shopprice) {
		this.shopprice = shopprice;
	}

	public String getMticketcount() {
        return mticketcount;
    }

    public void setMticketcount(String mticketcount) {
        this.mticketcount = mticketcount == null ? null : mticketcount.trim();
    }

    public Float getMscore() {
        return mscore;
    }

    public void setMscore(Float mscore) {
        this.mscore = mscore;
    }
}