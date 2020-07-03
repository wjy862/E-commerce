package com.seelles.pojo;

public class Bon {
    private int bid;
    private int bamout;
    private String conditionutilisation;
    private String conditionroute;
    private String btype;

    @Override
    public String toString() {
        return "Bon{" +
                "bid=" + bid +
                ", bamout=" + bamout +
                ", conditionutilisation='" + conditionutilisation + '\'' +
                ", conditionroute='" + conditionroute + '\'' +
                ", btype='" + btype + '\'' +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getBamout() {
        return bamout;
    }

    public void setBamout(int bamout) {
        this.bamout = bamout;
    }

    public String getConditionutilisation() {
        return conditionutilisation;
    }

    public void setConditionutilisation(String conditionutilisation) {
        this.conditionutilisation = conditionutilisation;
    }

    public String getConditionroute() {
        return conditionroute;
    }

    public void setConditionroute(String conditionroute) {
        this.conditionroute = conditionroute;
    }

    public String getBtype() {
        return btype;
    }

    public void setBtype(String btype) {
        this.btype = btype;
    }

    public Bon(int bid, int bamout, String conditionutilisation, String conditionroute, String btype) {
        this.bid = bid;
        this.bamout = bamout;
        this.conditionutilisation = conditionutilisation;
        this.conditionroute = conditionroute;
        this.btype = btype;
    }

    public Bon() {
    }
}
