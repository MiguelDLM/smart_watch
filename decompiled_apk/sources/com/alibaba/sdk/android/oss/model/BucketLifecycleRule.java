package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class BucketLifecycleRule {
    private String mArchiveDays;
    private String mArchiveExpireDate;
    private String mDays;
    private String mExpireDate;
    private String mIADays;
    private String mIAExpireDate;
    private String mIdentifier;
    private String mMultipartDays;
    private String mMultipartExpireDate;
    private String mPrefix;
    private boolean mStatus;

    public String getArchiveDays() {
        return this.mArchiveDays;
    }

    public String getArchiveExpireDate() {
        return this.mArchiveExpireDate;
    }

    public String getDays() {
        return this.mDays;
    }

    public String getExpireDate() {
        return this.mExpireDate;
    }

    public String getIADays() {
        return this.mIADays;
    }

    public String getIAExpireDate() {
        return this.mIAExpireDate;
    }

    public String getIdentifier() {
        return this.mIdentifier;
    }

    public String getMultipartDays() {
        return this.mMultipartDays;
    }

    public String getMultipartExpireDate() {
        return this.mMultipartExpireDate;
    }

    public String getPrefix() {
        return this.mPrefix;
    }

    public boolean getStatus() {
        return this.mStatus;
    }

    public void setArchiveDays(String str) {
        this.mArchiveDays = str;
    }

    public void setArchiveExpireDate(String str) {
        this.mArchiveExpireDate = str;
    }

    public void setDays(String str) {
        this.mDays = str;
    }

    public void setExpireDate(String str) {
        this.mExpireDate = str;
    }

    public void setIADays(String str) {
        this.mIADays = str;
    }

    public void setIAExpireDate(String str) {
        this.mIAExpireDate = str;
    }

    public void setIdentifier(String str) {
        this.mIdentifier = str;
    }

    public void setMultipartDays(String str) {
        this.mMultipartDays = str;
    }

    public void setMultipartExpireDate(String str) {
        this.mMultipartExpireDate = str;
    }

    public void setPrefix(String str) {
        this.mPrefix = str;
    }

    public void setStatus(boolean z) {
        this.mStatus = z;
    }
}
