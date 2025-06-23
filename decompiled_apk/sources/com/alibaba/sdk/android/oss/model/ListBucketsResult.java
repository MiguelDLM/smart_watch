package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ListBucketsResult extends OSSResult {
    private List<OSSBucketSummary> buckets = new ArrayList();
    private boolean isTruncated;
    private String marker;
    private int maxKeys;
    private String nextMarker;
    private String ownerDisplayName;
    private String ownerId;
    private String prefix;

    public void addBucket(OSSBucketSummary oSSBucketSummary) {
        this.buckets.add(oSSBucketSummary);
    }

    public void clearBucketList() {
        this.buckets.clear();
    }

    public List<OSSBucketSummary> getBuckets() {
        return this.buckets;
    }

    public String getMarker() {
        return this.marker;
    }

    public int getMaxKeys() {
        return this.maxKeys;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public String getOwnerDisplayName() {
        return this.ownerDisplayName;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public boolean getTruncated() {
        return this.isTruncated;
    }

    public void setBuckets(List<OSSBucketSummary> list) {
        this.buckets = list;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setMaxKeys(int i) {
        this.maxKeys = i;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setOwnerDisplayName(String str) {
        this.ownerDisplayName = str;
    }

    public void setOwnerId(String str) {
        this.ownerId = str;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setTruncated(boolean z) {
        this.isTruncated = z;
    }
}
