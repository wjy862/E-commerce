package com.seelles.pojo;
import java.math.BigDecimal;
import java.util.Date;

public class Command {
    private int numcn;
    private int cid;
    private double weighttotal;
    private double weightpervolume;
    private double volume;
    private double weightreal;
    private double amountlivraison;
    private double	declaredprice;
    private int logisticsnum;
    private User user;


    private String description;
    private String 	statuspayment;
    private String depotname;
    private String typetransport;
    private String 	service;
    private String insurance;
    private Date time;

    @Override
    public String toString() {
        return "Command{" +
                "numcn=" + numcn +
                ", cid=" + cid +
                ", weighttotal=" + weighttotal +
                ", weightpervolume=" + weightpervolume +
                ", volume=" + volume +
                ", weightreal=" + weightreal +
                ", amountlivraison=" + amountlivraison +
                ", declaredprice=" + declaredprice +
                ", logisticsnum=" + logisticsnum +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", statuspayment='" + statuspayment + '\'' +
                ", depotname='" + depotname + '\'' +
                ", typetransport='" + typetransport + '\'' +
                ", service='" + service + '\'' +
                ", insurance='" + insurance + '\'' +
                ", time=" + time +
                '}';
    }

    public int getNumcn() {
        return numcn;
    }

    public void setNumcn(int numcn) {
        this.numcn = numcn;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getWeighttotal() {
        return weighttotal;
    }

    public void setWeighttotal(double weighttotal) {
        this.weighttotal = weighttotal;
    }

    public double getWeightpervolume() {
        return weightpervolume;
    }

    public void setWeightpervolume(double weightpervolume) {
        this.weightpervolume = weightpervolume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeightreal() {
        return weightreal;
    }

    public void setWeightreal(double weightreal) {
        this.weightreal = weightreal;
    }

    public double getAmountlivraison() {
        return amountlivraison;
    }

    public void setAmountlivraison(double amountlivraison) {
        this.amountlivraison = amountlivraison;
    }

    public double getDeclaredprice() {
        return declaredprice;
    }

    public void setDeclaredprice(double declaredprice) {
        this.declaredprice = declaredprice;
    }

    public int getLogisticsnum() {
        return logisticsnum;
    }

    public void setLogisticsnum(int logisticsnum) {
        this.logisticsnum = logisticsnum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatuspayment() {
        return statuspayment;
    }

    public void setStatuspayment(String statuspayment) {
        this.statuspayment = statuspayment;
    }

    public String getDepotname() {
        return depotname;
    }

    public void setDepotname(String depotname) {
        this.depotname = depotname;
    }

    public String getTypetransport() {
        return typetransport;
    }

    public void setTypetransport(String typetransport) {
        this.typetransport = typetransport;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Command(int numcn, int cid, double weighttotal, double weightpervolume, double volume, double weightreal, double amountlivraison, double declaredprice, int logisticsnum, User user, String description, String statuspayment, String depotname, String typetransport, String service, String insurance, Date time) {
        this.numcn = numcn;
        this.cid = cid;
        this.weighttotal = weighttotal;
        this.weightpervolume = weightpervolume;
        this.volume = volume;
        this.weightreal = weightreal;
        this.amountlivraison = amountlivraison;
        this.declaredprice = declaredprice;
        this.logisticsnum = logisticsnum;
        this.user = user;
        this.description = description;
        this.statuspayment = statuspayment;
        this.depotname = depotname;
        this.typetransport = typetransport;
        this.service = service;
        this.insurance = insurance;
        this.time = time;
    }

    public Command() {
    }
}
