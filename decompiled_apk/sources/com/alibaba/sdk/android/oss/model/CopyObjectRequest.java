package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class CopyObjectRequest extends OSSRequest {
    private String destinationBucketName;
    private String destinationKey;
    private Date modifiedSinceConstraint;
    private ObjectMetadata newObjectMetadata;
    private String serverSideEncryption;
    private String sourceBucketName;
    private String sourceKey;
    private Date unmodifiedSinceConstraint;
    private List<String> matchingETagConstraints = new ArrayList();
    private List<String> nonmatchingEtagConstraints = new ArrayList();

    public CopyObjectRequest(String str, String str2, String str3, String str4) {
        setSourceBucketName(str);
        setSourceKey(str2);
        setDestinationBucketName(str3);
        setDestinationKey(str4);
    }

    public void clearMatchingETagConstraints() {
        this.matchingETagConstraints.clear();
    }

    public void clearNonmatchingETagConstraints() {
        this.nonmatchingEtagConstraints.clear();
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public String getDestinationKey() {
        return this.destinationKey;
    }

    public List<String> getMatchingETagConstraints() {
        return this.matchingETagConstraints;
    }

    public Date getModifiedSinceConstraint() {
        return this.modifiedSinceConstraint;
    }

    public ObjectMetadata getNewObjectMetadata() {
        return this.newObjectMetadata;
    }

    public List<String> getNonmatchingEtagConstraints() {
        return this.nonmatchingEtagConstraints;
    }

    public String getServerSideEncryption() {
        return this.serverSideEncryption;
    }

    public String getSourceBucketName() {
        return this.sourceBucketName;
    }

    public String getSourceKey() {
        return this.sourceKey;
    }

    public Date getUnmodifiedSinceConstraint() {
        return this.unmodifiedSinceConstraint;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public void setDestinationKey(String str) {
        this.destinationKey = str;
    }

    public void setMatchingETagConstraints(List<String> list) {
        this.matchingETagConstraints.clear();
        if (list != null && !list.isEmpty()) {
            this.matchingETagConstraints.addAll(list);
        }
    }

    public void setModifiedSinceConstraint(Date date) {
        this.modifiedSinceConstraint = date;
    }

    public void setNewObjectMetadata(ObjectMetadata objectMetadata) {
        this.newObjectMetadata = objectMetadata;
    }

    public void setNonmatchingETagConstraints(List<String> list) {
        this.nonmatchingEtagConstraints.clear();
        if (list != null && !list.isEmpty()) {
            this.nonmatchingEtagConstraints.addAll(list);
        }
    }

    public void setServerSideEncryption(String str) {
        this.serverSideEncryption = str;
    }

    public void setSourceBucketName(String str) {
        this.sourceBucketName = str;
    }

    public void setSourceKey(String str) {
        this.sourceKey = str;
    }

    public void setUnmodifiedSinceConstraint(Date date) {
        this.unmodifiedSinceConstraint = date;
    }
}
