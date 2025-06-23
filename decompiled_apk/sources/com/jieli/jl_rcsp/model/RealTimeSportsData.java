package com.jieli.jl_rcsp.model;

/* loaded from: classes10.dex */
public class RealTimeSportsData {
    private int calorie;
    private float distance;
    private int duration;
    private int exerciseStatus;
    private int heartRate;
    private float pace;
    private float speed;
    private int step;
    private int stepFreq;
    private int stride;
    private byte version;

    public int getCalorie() {
        return this.calorie;
    }

    public float getDistance() {
        return this.distance;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getExerciseStatus() {
        return this.exerciseStatus;
    }

    public int getHeartRate() {
        return this.heartRate;
    }

    public float getPace() {
        return this.pace;
    }

    public float getSpeed() {
        return this.speed;
    }

    public int getStep() {
        return this.step;
    }

    public int getStepFreq() {
        return this.stepFreq;
    }

    public int getStride() {
        return this.stride;
    }

    public byte getVersion() {
        return this.version;
    }

    public RealTimeSportsData setCalorie(int i) {
        this.calorie = i;
        return this;
    }

    public RealTimeSportsData setDistance(float f) {
        this.distance = f;
        return this;
    }

    public RealTimeSportsData setDuration(int i) {
        this.duration = i;
        return this;
    }

    public RealTimeSportsData setExerciseStatus(int i) {
        this.exerciseStatus = i;
        return this;
    }

    public RealTimeSportsData setHeartRate(int i) {
        this.heartRate = i;
        return this;
    }

    public RealTimeSportsData setPace(float f) {
        this.pace = f;
        return this;
    }

    public RealTimeSportsData setSpeed(float f) {
        this.speed = f;
        return this;
    }

    public RealTimeSportsData setStep(int i) {
        this.step = i;
        return this;
    }

    public RealTimeSportsData setStepFreq(int i) {
        this.stepFreq = i;
        return this;
    }

    public RealTimeSportsData setStride(int i) {
        this.stride = i;
        return this;
    }

    public RealTimeSportsData setVersion(byte b) {
        this.version = b;
        return this;
    }

    public String toString() {
        return "RealTimeSportsData{version=" + ((int) this.version) + ", step=" + this.step + ", distance=" + this.distance + ", duration=" + this.duration + ", speed=" + this.speed + ", pace=" + this.pace + ", calorie=" + this.calorie + ", stepFreq=" + this.stepFreq + ", stride=" + this.stride + ", exerciseStatus=" + this.exerciseStatus + ", heartRate=" + this.heartRate + '}';
    }
}
