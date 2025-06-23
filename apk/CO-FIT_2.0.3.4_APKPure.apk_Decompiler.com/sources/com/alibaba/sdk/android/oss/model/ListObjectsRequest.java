package com.alibaba.sdk.android.oss.model;

public class ListObjectsRequest extends OSSRequest {
    private static final int MAX_RETURNED_KEYS_LIMIT = 1000;
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private String marker;
    private Integer maxKeys;
    private String prefix;

    public ListObjectsRequest() {
        this((String) null);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getMarker() {
        return this.marker;
    }

    public Integer getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setMaxKeys(Integer num) {
        if (num.intValue() < 0 || num.intValue() > 1000) {
            throw new IllegalArgumentException("Maxkeys should less can not exceed 1000.");
        }
        this.maxKeys = num;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public ListObjectsRequest(String str) {
        this(str, (String) null, (String) null, (String) null, (Integer) null);
    }

    public ListObjectsRequest(String str, String str2, String str3, String str4, Integer num) {
        setBucketName(str);
        setPrefix(str2);
        setMarker(str3);
        setDelimiter(str4);
        if (num != null) {
            setMaxKeys(num);
        }
    }
}
