package com.seelles.pojo;

public class Contain {
    private Parcel pid;
    private Objectparcel objectparcel;
    private int quantity;
    private double prix;

    @Override
    public String toString() {
        return "Contain{" +
                "pid=" + pid +
                ", objectparcel=" + objectparcel +
                ", quantity=" + quantity +
                ", prix=" + prix +
                '}';
    }

    public Parcel getPid() {
        return pid;
    }

    public void setPid(Parcel pid) {
        this.pid = pid;
    }

    public Objectparcel getObjectparcel() {
        return objectparcel;
    }

    public void setObjectparcel(Objectparcel objectparcel) {
        this.objectparcel = objectparcel;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Contain(Parcel pid, Objectparcel objectparcel, int quantity, double prix) {
        this.pid = pid;
        this.objectparcel = objectparcel;
        this.quantity = quantity;
        this.prix = prix;
    }

    public Contain() {
    }
}
