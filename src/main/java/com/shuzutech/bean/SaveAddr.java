package com.shuzutech.bean;


import java.util.Objects;

public class SaveAddr {
    private int id;
    private String address;
    private String env;

    public SaveAddr() {
    }

    public SaveAddr(int id, String address, String env) {
        this.id = id;
        this.address = address;
        this.env = env;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveAddr saveAddr = (SaveAddr) o;
        return id == saveAddr.id &&
                Objects.equals(address, saveAddr.address) &&
                Objects.equals(env, saveAddr.env);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, env);
    }

    @Override
    public String toString() {
        return "SaveAddr{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", env='" + env + '\'' +
                '}';
    }
}
