package com.shuzutech.bean;


import java.util.Date;
import java.util.Objects;


public class SaveFpInfo {
    private String fpqqlsh;
    private String fplxdm;
    private String jsbh;
    private String nsrsbh;
    private String fpdm;
    private String fphm;
    private Date updateTime;
    private int id;

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

    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
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

    public String getJsbh() {
        return jsbh;
    }

    public void setJsbh(String jsbh) {
        this.jsbh = jsbh;
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
