package com.goodix.ble.gr.libdfu.dfu.entity;

/* loaded from: classes9.dex */
public class BootConfig {

    /* renamed from: a, reason: collision with root package name */
    private int f16089a;

    private int a(int i, int i2) {
        if (i2 <= 0) {
            return 0;
        }
        if (i < 0) {
            i = 0;
        } else if (i > 31) {
            i = 31;
        }
        if (i2 + i > 31) {
            i2 = 32 - i;
        }
        int i3 = this.f16089a;
        if (i > 0) {
            i3 >>= i;
        }
        return i3 & ((1 << i2) - 1);
    }

    public int getBootDelay() {
        return a(9, 1);
    }

    public int getCodeCopyMode() {
        return a(4, 1);
    }

    public int getConfig() {
        return this.f16089a;
    }

    public int getDapBoot() {
        return a(10, 1);
    }

    public int getImgChkFlag() {
        return a(8, 1);
    }

    public int getSystemClk() {
        return a(5, 3);
    }

    public int getXQspiSpeed() {
        return a(0, 4);
    }

    public void setBootDelay(int i) {
        a(9, 1, i);
    }

    public void setCodeCopyMode(int i) {
        a(4, 1, i);
    }

    public void setConfig(int i) {
        this.f16089a = i;
    }

    public void setDapBoot(int i) {
        a(10, 1, i);
    }

    public void setImgChkFlag(int i) {
        a(8, 1, i);
    }

    public void setSystemClk(int i) {
        a(5, 3, i);
    }

    public void setXQspiSpeed(int i) {
        a(0, 4, i);
    }

    private void a(int i, int i2, int i3) {
        if (i2 <= 0) {
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i > 31) {
            i = 31;
        }
        if (i2 + i > 31) {
            i2 = 32 - i;
        }
        int i4 = (1 << i2) - 1;
        this.f16089a = ((i4 & i3) << i) | (this.f16089a & (~(i4 << i)));
    }
}
