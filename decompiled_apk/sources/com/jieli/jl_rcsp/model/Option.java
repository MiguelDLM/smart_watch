package com.jieli.jl_rcsp.model;

/* loaded from: classes10.dex */
public class Option {
    private int cmdTimeout = 2000;
    private boolean isMultiDevice;

    public static Option createOption() {
        return new Option().setMultiDevice(false);
    }

    public int getCmdTimeout() {
        return this.cmdTimeout;
    }

    public boolean isMultiDevice() {
        return this.isMultiDevice;
    }

    public Option setCmdTimeout(int i) {
        this.cmdTimeout = i;
        return this;
    }

    public Option setMultiDevice(boolean z) {
        this.isMultiDevice = z;
        return this;
    }

    public String toString() {
        return "Option{isMultiDevice=" + this.isMultiDevice + ", cmdTimeout=" + this.cmdTimeout + '}';
    }
}
