package com.seelles.pojo;

public class Typeparcel {
    private int tid;
    private String tdescription;

    @Override
    public String toString() {
        return "Typeparcel{" +
                "tid=" + tid +
                ", tdescription='" + tdescription + '\'' +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTdescription() {
        return tdescription;
    }

    public void setTdescription(String tdescription) {
        this.tdescription = tdescription;
    }

    public Typeparcel(int tid, String tdescription) {
        this.tid = tid;
        this.tdescription = tdescription;
    }

    public Typeparcel() {
    }
}
