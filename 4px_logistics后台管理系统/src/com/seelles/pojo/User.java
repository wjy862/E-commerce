package com.seelles.pojo;

public class User {
    private int uid;
    private String uname;
    private int  telephone;
    private String photo;
    private String mail;
    private String gender;
    private String birthday;
    private int currentbalance;
    private int rebate;
    private  String pwd;

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", telephone=" + telephone +
                ", photo='" + photo + '\'' +
                ", mail='" + mail + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", currentbalance=" + currentbalance +
                ", rebate=" + rebate +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public User(int uid, String uname, int telephone, String photo, String mail, String gender, String birthday, int currentbalance, int rebate, String pwd) {
        this.uid = uid;
        this.uname = uname;
        this.telephone = telephone;
        this.photo = photo;
        this.mail = mail;
        this.gender = gender;
        this.birthday = birthday;
        this.currentbalance = currentbalance;
        this.rebate = rebate;
        this.pwd = pwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(int currentbalance) {
        this.currentbalance = currentbalance;
    }

    public int getRebate() {
        return rebate;
    }

    public void setRebate(int rebate) {
        this.rebate = rebate;
    }



    public User() {
    }
}
