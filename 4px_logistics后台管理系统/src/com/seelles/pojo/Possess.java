package com.seelles.pojo;

public class Possess {
    private User user;
    private Bon bon;
    private String 	blimitedate;
    private int bquantite;
    private  int bstatus;//0失效 1有效
    private String bdatefin;

    @Override
    public String toString() {
        return "Possess{" +
                "user=" + user +
                ", bon=" + bon +
                ", blimitedate='" + blimitedate + '\'' +
                ", bquantite=" + bquantite +
                ", bstatus=" + bstatus +
                ", bdatefin='" + bdatefin + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Bon getBon() {
        return bon;
    }

    public void setBon(Bon bon) {
        this.bon = bon;
    }

    public String getBlimitedate() {
        return blimitedate;
    }

    public void setBlimitedate(String blimitedate) {
        this.blimitedate = blimitedate;
    }

    public int getBquantite() {
        return bquantite;
    }

    public void setBquantite(int bquantite) {
        this.bquantite = bquantite;
    }

    public int getBstatus() {
        return bstatus;
    }

    public void setBstatus(int bstatus) {
        this.bstatus = bstatus;
    }

    public String getBdatefin() {
        return bdatefin;
    }

    public void setBdatefin(String bdatefin) {
        this.bdatefin = bdatefin;
    }

    public Possess(User user, Bon bon, String blimitedate, int bquantite, int bstatus, String bdatefin) {
        this.user = user;
        this.bon = bon;
        this.blimitedate = blimitedate;
        this.bquantite = bquantite;
        this.bstatus = bstatus;
        this.bdatefin = bdatefin;
    }

    public Possess() {
    }
}
