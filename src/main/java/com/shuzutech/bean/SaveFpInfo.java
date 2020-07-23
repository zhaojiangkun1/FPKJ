package com.shuzutech.bean;


import java.util.Date;
import java.util.Objects;


public class SaveFpInfo {
    private String fpqqlsh;
    private String fplxdm;
    private String nsrsbh;
    private Date updateTime;
    private int id;

    public SaveFpInfo() {
    }

    public SaveFpInfo(String fpqqlsh, String fplxdm, String nsrsbh, Date updateTime, int id) {
        this.fpqqlsh = fpqqlsh;
        this.fplxdm = fplxdm;
        this.nsrsbh = nsrsbh;
        this.updateTime = updateTime;
        this.id = id;
    }

    public String getFpqqlsh() {
        return fpqqlsh;
    }

    public void setFpqqlsh(String fpqqlsh) {
        this.fpqqlsh = fpqqlsh;
    }

    public String getFplxdm() {
        return fplxdm;
    }

    public void setFplxdm(String fplxdm) {
        this.fplxdm = fplxdm;
    }

    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveFpInfo that = (SaveFpInfo) o;
        return id == that.id &&
                Objects.equals(fpqqlsh, that.fpqqlsh) &&
                Objects.equals(fplxdm, that.fplxdm) &&
                Objects.equals(nsrsbh, that.nsrsbh) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fpqqlsh, fplxdm, nsrsbh, updateTime, id);
    }

    @Override
    public String toString() {
        return "SaveFpInfo{" +
                "fpqqlsh='" + fpqqlsh + '\'' +
                ", fplxdm='" + fplxdm + '\'' +
                ", nsrsbh='" + nsrsbh + '\'' +
                ", updateTime=" + updateTime +
                ", id=" + id +
                '}';
    }
}
