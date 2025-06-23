package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import java.util.Map;

public class ResumableDownloadRequest extends OSSRequest {
    private String bucketName;
    private String checkPointFilePath;
    private String downloadToFilePath;
    private Boolean enableCheckPoint;
    private String objectKey;
    private long partSize;
    private OSSProgressCallback progressListener;
    private Range range;
    private Map<String, String> requestHeader;
    private Integer threadNum;

    public ResumableDownloadRequest(String str, String str2, String str3) {
        this.enableCheckPoint = Boolean.FALSE;
        this.partSize = 262144;
        this.bucketName = str;
        this.objectKey = str2;
        this.downloadToFilePath = str3;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getCheckPointFilePath() {
        return this.checkPointFilePath;
    }

    public String getDownloadToFilePath() {
        return this.downloadToFilePath;
    }

    public Boolean getEnableCheckPoint() {
        return this.enableCheckPoint;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public OSSProgressCallback getProgressListener() {
        return this.progressListener;
    }

    public Range getRange() {
        return this.range;
    }

    public Map<String, String> getRequestHeader() {
        return this.requestHeader;
    }

    public String getTempFilePath() {
        return this.downloadToFilePath + ".tmp";
    }

    public Integer getThreadNum() {
        return this.threadNum;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setCheckPointFilePath(String str) {
        this.checkPointFilePath = str;
    }

    public void setDownloadToFilePath(String str) {
        this.downloadToFilePath = str;
    }

    public void setEnableCheckPoint(Boolean bool) {
        this.enableCheckPoint = bool;
    }

    public void setObjectKey(String str) {
        this.objectKey = str;
    }

    public void setPartSize(long j) {
        this.partSize = j;
    }

    public void setProgressListener(OSSProgressCallback oSSProgressCallback) {
        this.progressListener = oSSProgressCallback;
    }

    public void setRange(Range range2) {
        this.range = range2;
    }

    public void setRequestHeader(Map<String, String> map) {
        this.requestHeader = map;
    }

    public void setThreadNum(Integer num) {
        this.threadNum = num;
    }

    public ResumableDownloadRequest(String str, String str2, String str3, String str4) {
        this.partSize = 262144;
        this.bucketName = str;
        this.objectKey = str2;
        this.downloadToFilePath = str3;
        this.enableCheckPoint = Boolean.TRUE;
        this.checkPointFilePath = str4;
    }
}
