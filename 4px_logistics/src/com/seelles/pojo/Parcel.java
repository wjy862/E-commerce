package com.seelles.pojo;

import java.util.List;

public class Parcel {
    private int pid;
    private int cid;
    private String pname;
    private double prix;
    private int quantity;
    private String type;
    private Command command;


    @Override
    public String toString() {
        return "Parcel{" +
                "pid=" + pid +
                ", cid=" + cid +
                ", pname='" + pname + '\'' +
                ", prix=" + prix +
                ", quantity=" + quantity +
                ", type='" + type + '\'' +
                ", command=" + command +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public Parcel(int pid, int cid, String pname, double prix, int quantity, String type, Command command) {
        this.pid = pid;
        this.cid = cid;
        this.pname = pname;
        this.prix = prix;
        this.quantity = quantity;
        this.type = type;
        this.command = command;
    }

    public Parcel() {
    }
}
