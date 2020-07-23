package com.shuzutech.model;

public class GroupModel {
    private String fphxz;
//    private String spmc;
//    private String ggxh;
//    private String dw;
    private String spsl;
    private String dj;
    private String je;
    private String sl;
    private String se;
//    private String spbm;
//    private String zxbm;
//    private String yhzcbs;
//    private String lslbs;
//    private String zzstsgl;


    public GroupModel(String fphxz, String spsl, String dj, String je, String sl,String se) {
        this.fphxz = fphxz;
        this.spsl = spsl;
        this.dj = dj;
        this.je = je;
        this.sl = sl;
        this.se = se;
    }

    public String getFphxz() {
        return fphxz;
    }

    public void setFphxz(String fphxz) {
        this.fphxz = fphxz;
    }

    public String getSpsl() {
        return spsl;
    }

    public void setSpsl(String spsl) {
        this.spsl = spsl;
    }

    public String getDj() {
        return dj;
    }

    public void setDj(String dj) {
        this.dj = dj;
    }

    public String getJe() {
        return je;
    }

    public void setJe(String je) {
        this.je = je;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }
}
