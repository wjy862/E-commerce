package com.seelles.pojo;

public class Typepreciseparcel {
    private int tpid;
    private String tpdescription;
    private Typeparcel typeparcel;

    @Override
    public String toString() {
        return "Typepreciseparcel{" +
                "tpid=" + tpid +
                ", tpdescription='" + tpdescription + '\'' +
                ", typeparcel=" + typeparcel +
                '}';
    }

    public int getTpid() {
        return tpid;
    }

    public void setTpid(int tpid) {
        this.tpid = tpid;
    }

    public String getTpdescription() {
        return tpdescription;
    }

    public void setTpdescription(String tpdescription) {
        this.tpdescription = tpdescription;
    }

    public Typeparcel getTypeparcel() {
        return typeparcel;
    }

    public void setTypeparcel(Typeparcel typeparcel) {
        this.typeparcel = typeparcel;
    }

    public Typepreciseparcel(int tpid, String tpdescription, Typeparcel typeparcel) {
        this.tpid = tpid;
        this.tpdescription = tpdescription;
        this.typeparcel = typeparcel;
    }

    public Typepreciseparcel() {
    }
}
