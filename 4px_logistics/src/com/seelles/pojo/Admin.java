package com.seelles.pojo;

public class Admin {
    private int adid;
    private  String pwd;
    private String adname;
    private String role;

    @Override
    public String toString() {
        return "Admin{" +
                "adid=" + adid +
                ", pwd='" + pwd + '\'' +
                ", adname='" + adname + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public int getAdid() {
        return adid;
    }

    public void setAdid(int adid) {
        this.adid = adid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Admin(int adid, String pwd, String adname, String role) {
        this.adid = adid;
        this.pwd = pwd;
        this.adname = adname;
        this.role = role;
    }

    public Admin() {
    }
}
