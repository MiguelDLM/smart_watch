package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.sma.smartv3.db.entity.HeartRate;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class RecordDetailHeartRateData {
    private long mAerobic;
    private long mAnaerobic;
    private int mAvgHR;
    private long mFatBurning;

    @OOXIXo
    private ArrayList<HeartRate> mHeartRateList = new ArrayList<>();
    private int mMaxHR;
    private int mMinHR;
    private long mStrenuous;
    private long mWarmUp;

    public final long getMAerobic() {
        return this.mAerobic;
    }

    public final long getMAnaerobic() {
        return this.mAnaerobic;
    }

    public final int getMAvgHR() {
        return this.mAvgHR;
    }

    public final long getMFatBurning() {
        return this.mFatBurning;
    }

    @OOXIXo
    public final ArrayList<HeartRate> getMHeartRateList() {
        return this.mHeartRateList;
    }

    public final int getMMaxHR() {
        return this.mMaxHR;
    }

    public final int getMMinHR() {
        return this.mMinHR;
    }

    public final long getMStrenuous() {
        return this.mStrenuous;
    }

    public final long getMWarmUp() {
        return this.mWarmUp;
    }

    public final void setMAerobic(long j) {
        this.mAerobic = j;
    }

    public final void setMAnaerobic(long j) {
        this.mAnaerobic = j;
    }

    public final void setMAvgHR(int i) {
        this.mAvgHR = i;
    }

    public final void setMFatBurning(long j) {
        this.mFatBurning = j;
    }

    public final void setMHeartRateList(@OOXIXo ArrayList<HeartRate> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.mHeartRateList = arrayList;
    }

    public final void setMMaxHR(int i) {
        this.mMaxHR = i;
    }

    public final void setMMinHR(int i) {
        this.mMinHR = i;
    }

    public final void setMStrenuous(long j) {
        this.mStrenuous = j;
    }

    public final void setMWarmUp(long j) {
        this.mWarmUp = j;
    }
}
