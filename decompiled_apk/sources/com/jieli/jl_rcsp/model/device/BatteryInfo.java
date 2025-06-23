package com.jieli.jl_rcsp.model.device;

/* loaded from: classes10.dex */
public class BatteryInfo {
    private int battery;

    public BatteryInfo() {
    }

    public int getBattery() {
        return this.battery;
    }

    public void setBattery(int i) {
        this.battery = i;
    }

    public String toString() {
        return "BatteryInfo{battery=" + this.battery + '}';
    }

    public BatteryInfo(int i) {
        setBattery(i);
    }
}
