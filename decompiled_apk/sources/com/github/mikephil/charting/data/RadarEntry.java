package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes9.dex */
public class RadarEntry extends Entry {
    public RadarEntry(float f) {
        super(0.0f, f);
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public RadarEntry Oxx0IOOO() {
        return new RadarEntry(I0Io(), oIX0oI());
    }

    public float oOoXoXO() {
        return I0Io();
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void xoIox(float f) {
        super.xoIox(f);
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float xxIXOIIO() {
        return super.xxIXOIIO();
    }

    public RadarEntry(float f, Object obj) {
        super(0.0f, f, obj);
    }
}
