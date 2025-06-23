package com.goodix.ble.gr.libdfu.dfu.entity;

import com.goodix.ble.libcomx.util.HexBuilder;
import com.goodix.ble.libcomx.util.HexReader;

/* loaded from: classes9.dex */
public class BootInfo {

    /* renamed from: a, reason: collision with root package name */
    BootConfig f16090a = new BootConfig();
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;

    public void deserialize(HexReader hexReader) {
        this.f = hexReader.get(4);
        this.e = hexReader.get(4);
        this.d = hexReader.get(4);
        this.c = hexReader.get(4);
        this.b = hexReader.get(4);
        this.f16090a.setConfig(hexReader.get(4));
    }

    public int getAppSize() {
        return this.f;
    }

    public int getChecksum() {
        return this.e;
    }

    public BootConfig getConfig() {
        return this.f16090a;
    }

    public int getLoadAddr() {
        return this.d;
    }

    public int getRunAddr() {
        return this.c;
    }

    public int getSerializeSize() {
        return 24;
    }

    public int getSpiAccessMode() {
        return this.b;
    }

    public void serialize(HexBuilder hexBuilder) {
        hexBuilder.put(this.f, 4);
        hexBuilder.put(this.e, 4);
        hexBuilder.put(this.d, 4);
        hexBuilder.put(this.c, 4);
        hexBuilder.put(this.b, 4);
        hexBuilder.put(this.f16090a.getConfig(), 4);
    }

    public void setAppSize(int i) {
        this.f = i;
    }

    public void setChecksum(int i) {
        this.e = i;
    }

    public void setConfig(BootConfig bootConfig) {
        this.f16090a = bootConfig;
    }

    public void setLoadAddr(int i) {
        this.d = i;
    }

    public void setRunAddr(int i) {
        this.c = i;
    }

    public void setSpiAccessMode(int i) {
        this.b = i;
    }
}
