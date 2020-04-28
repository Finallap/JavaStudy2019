package com.bean;

import java.util.Date;

/**
 * @description: RssMessage
 * @date: 2020/4/28 17:07
 * @author: Finallap
 * @version: 1.0
 */
public class RssMessage {
    String title;
    String url;
    String summary;
    Date createdDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
