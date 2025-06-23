package com.jieli.jl_rcsp.model.device.health;

import java.util.Arrays;

/* loaded from: classes10.dex */
public class SportsInfo {
    private int endTime;
    private int[] exerciseIntensityState;
    private int heartRateMode;
    private int id;
    private boolean isNeedAppGPS;
    private int mode;
    private int readRealTimeDataInterval;
    private short recordFileId;
    private int recordFileSize;
    private int recoveryTime;
    private int state = -1;

    public SportsInfo() {
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int[] getExerciseIntensityState() {
        return this.exerciseIntensityState;
    }

    public int getHeartRateMode() {
        return this.heartRateMode;
    }

    public int getId() {
        return this.id;
    }

    public int getMode() {
        return this.mode;
    }

    public int getReadRealTimeDataInterval() {
        return this.readRealTimeDataInterval;
    }

    public short getRecordFileId() {
        return this.recordFileId;
    }

    public int getRecordFileSize() {
        return this.recordFileSize;
    }

    public int getRecoveryTime() {
        return this.recoveryTime;
    }

    public int getState() {
        return this.state;
    }

    public boolean isNeedAppGPS() {
        return this.isNeedAppGPS;
    }

    public SportsInfo setEndTime(int i) {
        this.endTime = i;
        return this;
    }

    public SportsInfo setExerciseIntensityState(int[] iArr) {
        this.exerciseIntensityState = iArr;
        return this;
    }

    public SportsInfo setHeartRateMode(int i) {
        this.heartRateMode = i;
        return this;
    }

    public SportsInfo setId(int i) {
        this.id = i;
        return this;
    }

    public SportsInfo setMode(int i) {
        this.mode = i;
        return this;
    }

    public SportsInfo setNeedAppGPS(boolean z) {
        this.isNeedAppGPS = z;
        return this;
    }

    public SportsInfo setReadRealTimeDataInterval(int i) {
        this.readRealTimeDataInterval = i;
        return this;
    }

    public SportsInfo setRecordFileId(short s) {
        this.recordFileId = s;
        return this;
    }

    public SportsInfo setRecordFileSize(int i) {
        this.recordFileSize = i;
        return this;
    }

    public SportsInfo setRecoveryTime(int i) {
        this.recoveryTime = i;
        return this;
    }

    public SportsInfo setState(int i) {
        this.state = i;
        return this;
    }

    public String toString() {
        return "SportsInfo{id=" + this.id + ", mode=" + this.mode + ", state=" + this.state + ", isNeedAppGPS=" + this.isNeedAppGPS + ", heartRateMode=" + this.heartRateMode + ", readRealTimeDataInterval=" + this.readRealTimeDataInterval + ", endTime=" + this.endTime + ", recoveryTime=" + this.recoveryTime + ", recordFileId=" + ((int) this.recordFileId) + ", recordFileSize=" + this.recordFileSize + ", exerciseIntensityState=" + Arrays.toString(this.exerciseIntensityState) + '}';
    }

    public SportsInfo(int i, int i2, int i3, boolean z, int i4, int i5) {
        setId(i);
        setMode(i2);
        setState(i3);
        setNeedAppGPS(z);
        setHeartRateMode(i4);
        setReadRealTimeDataInterval(i5);
    }
}
