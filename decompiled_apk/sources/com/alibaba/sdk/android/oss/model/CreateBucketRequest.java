package com.alibaba.sdk.android.oss.model;

/* loaded from: classes.dex */
public class CreateBucketRequest extends OSSRequest {
    public static final String TAB_LOCATIONCONSTRAINT = "LocationConstraint";
    public static final String TAB_STORAGECLASS = "StorageClass";
    private CannedAccessControlList bucketACL;
    private String bucketName;
    private StorageClass bucketStorageClass = StorageClass.Standard;
    private String locationConstraint;

    public CreateBucketRequest(String str) {
        setBucketName(str);
    }

    public CannedAccessControlList getBucketACL() {
        return this.bucketACL;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public StorageClass getBucketStorageClass() {
        return this.bucketStorageClass;
    }

    @Deprecated
    public String getLocationConstraint() {
        return this.locationConstraint;
    }

    public void setBucketACL(CannedAccessControlList cannedAccessControlList) {
        this.bucketACL = cannedAccessControlList;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setBucketStorageClass(StorageClass storageClass) {
        this.bucketStorageClass = storageClass;
    }

    @Deprecated
    public void setLocationConstraint(String str) {
        this.locationConstraint = str;
    }
}
