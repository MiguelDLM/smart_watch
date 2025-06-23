package com.alibaba.sdk.android.oss.model;

import java.util.Map;

public class PutObjectTaggingRequest extends OSSRequest {
    private String bucketName;
    private String objectKey;
    private Map<String, String> tags;

    public PutObjectTaggingRequest(String str, String str2, Map<String, String> map) {
        this.bucketName = str;
        this.objectKey = str2;
        this.tags = map;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setTags(Map<String, String> map) {
        this.tags = map;
    }
}
