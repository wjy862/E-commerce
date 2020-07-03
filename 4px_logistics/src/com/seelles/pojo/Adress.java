package com.seelles.pojo;

public class Adress {
    private int 	aid;
    private int 	atelephone;
    private int acp;
    private String aname;
    private String aadress;

    @Override
    public String toString() {
        return "adress{" +
                "aid=" + aid +
                ", atelephone=" + atelephone +
                ", acp=" + acp +
                ", aname='" + aname + '\'' +
                ", aadress='" + aadress + '\'' +
                ", adepartement='" + adepartement + '\'' +
                ", user=" + user +
                '}';
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getAtelephone() {
        return atelephone;
    }

    public void setAtelephone(int atelephone) {
        this.atelephone = atelephone;
    }

    public int getAcp() {
        return acp;
    }

    public void setAcp(int acp) {
        this.acp = acp;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAadress() {
        return aadress;
    }

    public void setAadress(String aadress) {
        this.aadress = aadress;
    }

    public String getAdepartement() {
        return adepartement;
    }

    public void setAdepartement(String adepartement) {
        this.adepartement = adepartement;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Adress(int aid, int atelephone, int acp, String aname, String aadress, String adepartement, User user) {
        this.aid = aid;
        this.atelephone = atelephone;
        this.acp = acp;
        this.aname = aname;
        this.aadress = aadress;
        this.adepartement = adepartement;
        this.user = user;
    }

    public Adress() {
    }

    private String adepartement;
    private User user;

}
