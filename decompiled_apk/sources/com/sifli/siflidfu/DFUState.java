package com.sifli.siflidfu;

/* loaded from: classes11.dex */
public class DFUState {
    public static final int DFU_STATE_DOWNLOADING = 3;
    public static final int DFU_STATE_FORCE = 8;
    public static final int DFU_STATE_INIT = 1;
    public static final int DFU_STATE_INIT_REBOOT = 2;
    public static final int DFU_STATE_INSTALLED = 5;
    public static final int DFU_STATE_INSTALLING = 4;
    public static final int DFU_STATE_NO_STATE = 0;
    public static final int DFU_STATE_REBOOT_CONNECT = 9;
    public static final int DFU_STATE_REBOOT_CONNECT_RETRY = 10;
    public static final int DFU_STATE_RESUME = 6;
    public static final int DFU_STATE_RESUME_REBOOT = 7;
    private int state = 0;

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }
}
