package com.jieli.jl_rcsp.model.device;

/* loaded from: classes10.dex */
public class WatchSettingInfo {
    private int mask;

    public WatchSettingInfo(int i) {
        this.mask = i;
    }

    public boolean isSupport(int i) {
        if (((this.mask >> i) & 1) == 1) {
            return true;
        }
        return false;
    }

    public void setMask(int i) {
        this.mask = i;
    }
}
