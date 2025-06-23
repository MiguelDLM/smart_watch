package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class CompleteMultipartUploadResult extends OSSResult {
    private String bucketName;
    private String eTag;
    private String location;
    private String objectKey;
    private String serverCallbackReturnBody;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getETag() {
        return this.eTag;
    }

    public String getLocation() {
        return this.location;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getServerCallbackReturnBody() {
        return this.serverCallbackReturnBody;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setServerCallbackReturnBody(String str) {
        this.serverCallbackReturnBody = str;
    }
}
