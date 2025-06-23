package com.jieli.jl_rcsp.model.device;

/* loaded from: classes10.dex */
public class MusicStatusInfo {
    private int currentDev;
    private int currentTime;
    private boolean isPlay;
    private int totalTime;

    public MusicStatusInfo() {
    }

    public int getCurrentDev() {
        return this.currentDev;
    }

    public int getCurrentTime() {
        return this.currentTime;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public boolean isPlay() {
        return this.isPlay;
    }

    public void setCurrentDev(int i) {
        this.currentDev = i;
    }

    public void setCurrentTime(int i) {
        this.currentTime = i;
    }

    public void setPlay(boolean z) {
        this.isPlay = z;
    }

    public void setTotalTime(int i) {
        this.totalTime = i;
    }

    public String toString() {
        return "MusicStatusInfo{isPlay=" + this.isPlay + ", currentTime=" + this.currentTime + ", totalTime=" + this.totalTime + ", currentDev=" + this.currentDev + '}';
    }

    public MusicStatusInfo(boolean z, int i, int i2, int i3) {
        setPlay(z);
        setCurrentTime(i);
        setTotalTime(i2);
        setCurrentDev(i3);
    }
}
