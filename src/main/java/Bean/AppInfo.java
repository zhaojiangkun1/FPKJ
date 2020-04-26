package Bean;

import java.util.Date;
import java.util.Objects;

public class AppInfo {
    private int id;
    private String appid;
    private String appSecret;
    private String accessToken;
    private Date updateTime;
    private String env;
    private String address;

    public AppInfo() {
    }

    public AppInfo(int id, String appid, String appSecret, String accessToken, Date updateTime, String env, String address) {
        this.id = id;
        this.appid = appid;
        this.appSecret = appSecret;
        this.accessToken = accessToken;
        this.updateTime = updateTime;
        this.env = env;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppInfo appInfo = (AppInfo) o;
        return id == appInfo.id &&
                Objects.equals(appid, appInfo.appid) &&
                Objects.equals(appSecret, appInfo.appSecret) &&
                Objects.equals(accessToken, appInfo.accessToken) &&
                Objects.equals(updateTime, appInfo.updateTime) &&
                Objects.equals(env, appInfo.env) &&
                Objects.equals(address, appInfo.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appid, appSecret, accessToken, updateTime, env, address);
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", appid='" + appid + '\'' +
                ", appSecret='" + appSecret + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", updateTime=" + updateTime +
                ", env='" + env + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
