package com.payu.models;

/**
 * Created by asaleem on 18/12/17.
 */
public class TinyUrlModel {

    //id + not null
    private long uuid;

    //uniq
    private String tinyUrl;

    //uniq
    private String originalUrl;

    public long getUuid() {
        return uuid;
    }

    public void setUuid(long uuid) {
        this.uuid = uuid;
    }

    public String getTinyUrl() {
        return tinyUrl;
    }

    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

}
