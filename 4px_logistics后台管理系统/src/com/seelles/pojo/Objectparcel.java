package com.seelles.pojo;

public class Objectparcel {
    private int oid;
    private String odescription;
    private Typepreciseparcel typepreciseparcel;

    public Objectparcel() {
    }

    @Override
    public String toString() {
        return "Objectparcel{" +
                "oid=" + oid +
                ", odescription='" + odescription + '\'' +
                ", typepreciseparcel=" + typepreciseparcel +
                '}';
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOdescription() {
        return odescription;
    }

    public void setOdescription(String odescription) {
        this.odescription = odescription;
    }

    public Typepreciseparcel getTypepreciseparcel() {
        return typepreciseparcel;
    }

    public void setTypepreciseparcel(Typepreciseparcel typepreciseparcel) {
        this.typepreciseparcel = typepreciseparcel;
    }

    public Objectparcel(int oid, String odescription, Typepreciseparcel typepreciseparcel) {
        this.oid = oid;
        this.odescription = odescription;
        this.typepreciseparcel = typepreciseparcel;
    }
}





