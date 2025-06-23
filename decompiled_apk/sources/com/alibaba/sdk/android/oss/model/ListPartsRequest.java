package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class ListPartsRequest extends OSSRequest {
    private String bucketName;
    private Integer maxParts;
    private String objectKey;
    private Integer partNumberMarker;
    private String uploadId;

    public ListPartsRequest(String str, String str2, String str3) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadId(str3);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setMaxParts(int i) {
        this.maxParts = Integer.valueOf(i);
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setPartNumberMarker(Integer num) {
        this.partNumberMarker = num;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
