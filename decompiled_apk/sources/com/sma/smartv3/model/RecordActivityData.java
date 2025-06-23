package com.sma.smartv3.model;

import OXOo.OOXIXo;
import java.util.ArrayList;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class RecordActivityData {
    private int mAirPressure;
    private int mAltitude;
    private int mAvgBpm;
    private float mAvgSpeed;
    private int mAvgStress;
    private int mCalorieTotal;
    private float mDistanceTotal;
    private int mMaxBpm;
    private int mMaxPace;
    private int mMaxSpm;
    private int mMaxStress;
    private int mMinBpm;
    private int mMinPace;
    private int mMinSpm;
    private int mMinStress;
    private int mPace;
    private float mSpeed;
    private int mSpm;
    private int mStepTotal;

    @OOXIXo
    private String mSportTimeStr = "00:00:00";

    @OOXIXo
    private String mPauseTimeTotal = "00:00:00";

    @OOXIXo
    private ArrayList<RecordTimeList> mTimeList = new ArrayList<>();

    @OOXIXo
    private String mPlatform = "";

    public final int getMAirPressure() {
        return this.mAirPressure;
    }

    public final int getMAltitude() {
        return this.mAltitude;
    }

    public final int getMAvgBpm() {
        return this.mAvgBpm;
    }

    public final float getMAvgSpeed() {
        return this.mAvgSpeed;
    }

    public final int getMAvgStress() {
        return this.mAvgStress;
    }

    public final int getMCalorieTotal() {
        return this.mCalorieTotal;
    }

    public final float getMDistanceTotal() {
        return this.mDistanceTotal;
    }

    public final int getMMaxBpm() {
        return this.mMaxBpm;
    }

    public final int getMMaxPace() {
        return this.mMaxPace;
    }

    public final int getMMaxSpm() {
        return this.mMaxSpm;
    }

    public final int getMMaxStress() {
        return this.mMaxStress;
    }

    public final int getMMinBpm() {
        return this.mMinBpm;
    }

    public final int getMMinPace() {
        return this.mMinPace;
    }

    public final int getMMinSpm() {
        return this.mMinSpm;
    }

    public final int getMMinStress() {
        return this.mMinStress;
    }

    public final int getMPace() {
        return this.mPace;
    }

    @OOXIXo
    public final String getMPauseTimeTotal() {
        return this.mPauseTimeTotal;
    }

    @OOXIXo
    public final String getMPlatform() {
        return this.mPlatform;
    }

    public final float getMSpeed() {
        return this.mSpeed;
    }

    public final int getMSpm() {
        return this.mSpm;
    }

    @OOXIXo
    public final String getMSportTimeStr() {
        return this.mSportTimeStr;
    }

    public final int getMStepTotal() {
        return this.mStepTotal;
    }

    @OOXIXo
    public final ArrayList<RecordTimeList> getMTimeList() {
        return this.mTimeList;
    }

    public final void setMAirPressure(int i) {
        this.mAirPressure = i;
    }

    public final void setMAltitude(int i) {
        this.mAltitude = i;
    }

    public final void setMAvgBpm(int i) {
        this.mAvgBpm = i;
    }

    public final void setMAvgSpeed(float f) {
        this.mAvgSpeed = f;
    }

    public final void setMAvgStress(int i) {
        this.mAvgStress = i;
    }

    public final void setMCalorieTotal(int i) {
        this.mCalorieTotal = i;
    }

    public final void setMDistanceTotal(float f) {
        this.mDistanceTotal = f;
    }

    public final void setMMaxBpm(int i) {
        this.mMaxBpm = i;
    }

    public final void setMMaxPace(int i) {
        this.mMaxPace = i;
    }

    public final void setMMaxSpm(int i) {
        this.mMaxSpm = i;
    }

    public final void setMMaxStress(int i) {
        this.mMaxStress = i;
    }

    public final void setMMinBpm(int i) {
        this.mMinBpm = i;
    }

    public final void setMMinPace(int i) {
        this.mMinPace = i;
    }

    public final void setMMinSpm(int i) {
        this.mMinSpm = i;
    }

    public final void setMMinStress(int i) {
        this.mMinStress = i;
    }

    public final void setMPace(int i) {
        this.mPace = i;
    }

    public final void setMPauseTimeTotal(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPauseTimeTotal = str;
    }

    public final void setMPlatform(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mPlatform = str;
    }

    public final void setMSpeed(float f) {
        this.mSpeed = f;
    }

    public final void setMSpm(int i) {
        this.mSpm = i;
    }

    public final void setMSportTimeStr(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.mSportTimeStr = str;
    }

    public final void setMStepTotal(int i) {
        this.mStepTotal = i;
    }

    public final void setMTimeList(@OOXIXo ArrayList<RecordTimeList> arrayList) {
        IIX0o.x0xO0oo(arrayList, "<set-?>");
        this.mTimeList = arrayList;
    }
}
