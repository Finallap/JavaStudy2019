package com.entity;

public class Teacher {
    private String tid;

    private String tname;

    public Teacher(String tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Teacher() {
        super();
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }
}