package com.alibaba.sdk.android.oss.model;

import java.util.Date;

public class CopyObjectResult extends OSSResult {
    private String etag;
    private Date lastModified;

    public String getETag() {
        return this.etag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setEtag(String str) {
        this.etag = str;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }
}
