package com.baidu.navisdk.comapi.trajectory;

import java.io.Serializable;

/* loaded from: classes7.dex */
public class NaviTrajectory implements Serializable {
    private static final long serialVersionUID = -7553390785996603989L;
    public boolean bIsChangedKey;
    public String clBduss;
    public String clCUID;
    public String clDataSign;
    public String clPoiID;
    public String clSessionID;
    public String clSessionSign;
    public String clTrackID;
    public String clUrl;
    public float mAverageSpeed;
    public String mDataVersion;
    public long mDate;
    public float mDistance;
    public long mDuration;
    public String mExtra;
    public int mFromType;
    public boolean mHasSync;
    public float mMaxSpeed;
    public String mName;
    public String mUUID;
    public int nKeyVersion;
    public long ulCreateTime;
    public int unMileageDist;

    public String toString() {
        return "{\"mUUID\":\"" + this.mUUID + "\",\"mName\":\"" + this.mName + "\",\"mHasSync\":" + this.mHasSync + ",\"mDistance\":" + this.mDistance + ",\"mDate\":" + this.mDate + ",\"mDuration\":" + this.mDuration + ",\"mAverageSpeed\":" + this.mAverageSpeed + ",\"mMaxSpeed\":" + this.mMaxSpeed + ",\"unMileageDist\":" + this.unMileageDist + ",\"ulCreateTime\":" + this.ulCreateTime + ",\"bIsChangedKey\":" + this.bIsChangedKey + ",\"nKeyVersion\":" + this.nKeyVersion + ",\"clTrackID\":\"" + this.clTrackID + "\",\"clCUID\":\"" + this.clCUID + "\",\"clSessionID\":\"" + this.clSessionID + "\",\"clBduss\":\"" + this.clBduss + "\",\"clPoiID\":\"" + this.clPoiID + "\",\"clDataSign\":\"" + this.clDataSign + "\",\"clSessionSign\":\"" + this.clSessionSign + "\",\"clUrl\":\"" + this.clUrl + "\",\"mFromType\":" + this.mFromType + ",\"mExtra\":\"" + this.mExtra + "\"}";
    }
}
