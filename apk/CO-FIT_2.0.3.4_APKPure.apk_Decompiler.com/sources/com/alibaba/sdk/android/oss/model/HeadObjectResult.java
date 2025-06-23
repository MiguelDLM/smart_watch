package com.alibaba.sdk.android.oss.model;

public class HeadObjectResult extends OSSResult {
    private ObjectMetadata metadata = new ObjectMetadata();

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public String toString() {
        return String.format("HeadObjectResult<%s>:\n metadata:%s", new Object[]{super.toString(), this.metadata.toString()});
    }
}
