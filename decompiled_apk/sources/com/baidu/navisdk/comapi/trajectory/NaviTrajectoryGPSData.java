package com.baidu.navisdk.comapi.trajectory;

import XIXIX.OOXIXo;

/* loaded from: classes7.dex */
public class NaviTrajectoryGPSData {
    public boolean bBrake;
    public boolean bCurve;
    public boolean bMaxSpeed;
    public boolean bOverSpeed;
    public boolean bRapidAcc;
    public boolean bYaw;
    public int enLocType;
    public float fMaxSpeed;
    public float mAccuracy;
    public float mBearing;
    public long mGpsTime;
    public double mLatitude;
    public long mLinkId;
    public double mLongitude;
    public float mSpeed;
    public int unLimitSpeed;

    public boolean isEnable() {
        if (this.mLongitude != OOXIXo.f3760XO && this.mLatitude != OOXIXo.f3760XO && this.mSpeed != 0.0f) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "mSpeed:" + this.mSpeed + " mBearing:" + this.mBearing + " mAccuracy:" + this.mAccuracy;
    }
}
