package com.goodix.ble.gr.libdfu.define;

/* loaded from: classes9.dex */
public enum MemoryLayout {
    SYSTEM_CONFIG(16777280, 400),
    BOOT_INFO(16777216, 24);


    /* renamed from: a, reason: collision with root package name */
    private int f16074a;
    private int b;

    MemoryLayout(int i, int i2) {
        this.f16074a = i;
        this.b = i2;
    }

    public int getAddress() {
        return this.f16074a;
    }

    public int getSize() {
        return this.b;
    }
}
