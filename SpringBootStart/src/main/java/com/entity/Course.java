package com.entity;

public class Course {
    private String cid;

    private String cname;

    private String tid;

    public Course(String cid, String cname, String tid) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
    }

    public Course() {
        super();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }
}