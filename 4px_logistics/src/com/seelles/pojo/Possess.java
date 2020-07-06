package com.seelles.pojo;

public class Possess {
    private int id;
    private String 	blimitedate;
    private int bquantite;
    private  int bstatus;//0失效 1有效
    private String bdatefin;
    private User user;

    @Override
    public String toString() {
        return "Possess{" +
                "id=" + id +
                ", blimitedate='" + blimitedate + '\'' +
                ", bquantite=" + bquantite +
                ", bstatus=" + bstatus +
                ", bdatefin='" + bdatefin + '\'' +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Possess(int id, String blimitedate, int bquantite, int bstatus, String bdatefin, User user) {
        this.id = id;
        this.blimitedate = blimitedate;
        this.bquantite = bquantite;
        this.bstatus = bstatus;
        this.bdatefin = bdatefin;
        this.user = user;
    }

    public Possess() {
    }
}
