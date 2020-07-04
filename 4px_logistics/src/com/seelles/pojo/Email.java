package com.seelles.pojo;

import java.sql.Date;

public class Email {
    private  int eid;
    private String etitle;
    private  String econ;
    private  String filename;
    private int recid;
    private int sendid;
    private Date edate;
    private User us;

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getEtitle() {
        return etitle;
    }

    public void setEtitle(String etitle) {
        this.etitle = etitle;
    }

    public String getEcon() {
        return econ;
    }

    public void setEcon(String econ) {
        this.econ = econ;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getRecid() {
        return recid;
    }

    public void setRecid(int recid) {
        this.recid = recid;
    }

    public int getSendid() {
        return sendid;
    }

    public void setSendid(int sendid) {
        this.sendid = sendid;
    }

    public Date getEdate() {
        return edate;
    }

    public void setEdate(Date edate) {
        this.edate = edate;
    }

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }

    public Email() {
    }

    @Override
    public String toString() {
        return "Email{" +
                "eid=" + eid +
                ", etitle='" + etitle + '\'' +
                ", econ='" + econ + '\'' +
                ", filename='" + filename + '\'' +
                ", recid=" + recid +
                ", sendid=" + sendid +
                ", edate=" + edate +
                ", us=" + us +
                '}';
    }

    public Email(int eid, String etitle, String econ, String filename, int recid, int sendid, Date edate, User us) {
        this.eid = eid;
        this.etitle = etitle;
        this.econ = econ;
        this.filename = filename;
        this.recid = recid;
        this.sendid = sendid;
        this.edate = edate;
        this.us = us;
    }
}
