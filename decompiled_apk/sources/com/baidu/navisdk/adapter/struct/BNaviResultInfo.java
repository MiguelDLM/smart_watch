package com.baidu.navisdk.adapter.struct;

/* loaded from: classes7.dex */
public class BNaviResultInfo {
    private float averageSpeed;
    private float maxSpeed;
    private int speedNum;
    private float totalDistance;
    private long totalTime;

    public float getAverageSpeed() {
        return this.averageSpeed;
    }

    public float getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getSpeedNum() {
        return this.speedNum;
    }

    public float getTotalDistance() {
        return this.totalDistance;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public void setAverageSpeed(float f) {
        this.averageSpeed = f;
    }

    public void setMaxSpeed(float f) {
        this.maxSpeed = f;
    }

    public void setSpeedNum(int i) {
        this.speedNum = i;
    }

    public void setTotalDistance(float f) {
        this.totalDistance = f;
    }

    public void setTotalTime(long j) {
        this.totalTime = j;
    }

    public String toString() {
        return "BNaviResultInfo{totalTime=" + this.totalTime + ", totalDistance=" + this.totalDistance + ", averageSpeed=" + this.averageSpeed + ", maxSpeed=" + this.maxSpeed + ", speedNum=" + this.speedNum + '}';
    }
}
