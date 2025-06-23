package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class CompleteMultipartUploadRequest extends OSSRequest {
    private String bucketName;
    private Map<String, String> callbackParam;
    private Map<String, String> callbackVars;
    private ObjectMetadata metadata;
    private String objectKey;
    private List<PartETag> partETags = new ArrayList();
    private String uploadId;

    public CompleteMultipartUploadRequest(String str, String str2, String str3, List<PartETag> list) {
        setBucketName(str);
        setObjectKey(str2);
        setUploadId(str3);
        setPartETags(list);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public Map<String, String> getCallbackParam() {
        return this.callbackParam;
    }

    public Map<String, String> getCallbackVars() {
        return this.callbackVars;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public List<PartETag> getPartETags() {
        return this.partETags;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCallbackParam(Map<String, String> map) {
        this.callbackParam = map;
    }

    public void setCallbackVars(Map<String, String> map) {
        this.callbackVars = map;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setPartETags(List<PartETag> list) {
        this.partETags = list;
    }

    public void setUploadId(String str) {
        this.uploadId = str;
    }
}
