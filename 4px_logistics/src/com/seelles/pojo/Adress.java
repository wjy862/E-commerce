package com.seelles.pojo;

public class Adress {
    private int 	aid;
    private int 	atelephone;
    private int acp;
    private String aname;
    private String aadress;
    private String adepartement;
    private int uid;
    private User user;

    @Override
    public String toString() {
        return "Adress{" +
                "aid=" + aid +
                ", atelephone=" + atelephone +
                ", acp=" + acp +
                ", aname='" + aname + '\'' +
                ", aadress='" + aadress + '\'' +
                ", adepartement='" + adepartement + '\'' +
                ", uid=" + uid +
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Adress(int aid, int atelephone, int acp, String aname, String aadress, String adepartement, int uid, User user) {
        this.aid = aid;
        this.atelephone = atelephone;
        this.acp = acp;
        this.aname = aname;
        this.aadress = aadress;
        this.adepartement = adepartement;
        this.uid = uid;
        this.user = user;
    }
    public Adress(int atelephone, int acp, String aname, String aadress, String adepartement, int uid, User user) {

        this.atelephone = atelephone;
        this.acp = acp;
        this.aname = aname;
        this.aadress = aadress;
        this.adepartement = adepartement;
        this.uid = uid;
        this.user = user;
    }

    public Adress() {
    }
}
