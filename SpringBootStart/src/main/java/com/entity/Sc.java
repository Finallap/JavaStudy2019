package com.entity;

import java.math.BigDecimal;

public class Sc {
    private String sid;

    private String cid;

    private BigDecimal score;

    public Sc(String sid, String cid, BigDecimal score) {
        this.sid = sid;
        this.cid = cid;
        this.score = score;
    }

    public Sc() {
        super();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}