package com.zyd.linkmanager;

import java.util.Date;

public class Link {
    public final static int STATE_NOT_PROCESSED = 0;
    public final static int STATE_FINISHED_OK = 1;
    public final static int STATE_FINISHED_ERROR = 2;

    private String url;
    private long id;
    private Date createTime;
    private Date finishTime;
    private int tryCount;
    private int state;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void setTryCount(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}