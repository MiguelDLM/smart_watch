package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.util.Log;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes9.dex */
public class PieEntry extends Entry {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public String f16037oI0IIXIo;

    public PieEntry(float f) {
        super(0.0f, f);
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public PieEntry Oxx0IOOO() {
        return new PieEntry(I0Io(), this.f16037oI0IIXIo, oIX0oI());
    }

    public String oOoXoXO() {
        return this.f16037oI0IIXIo;
    }

    public float ooOOo0oXI() {
        return I0Io();
    }

    public void x0XOIxOo(String str) {
        this.f16037oI0IIXIo = str;
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public void xoIox(float f) {
        super.xoIox(f);
        Log.i("DEPRECATED", "Pie entries do not have x values");
    }

    @Override // com.github.mikephil.charting.data.Entry
    @Deprecated
    public float xxIXOIIO() {
        Log.i("DEPRECATED", "Pie entries do not have x values");
        return super.xxIXOIIO();
    }

    public PieEntry(float f, Object obj) {
        super(0.0f, f, obj);
    }

    public PieEntry(float f, Drawable drawable) {
        super(0.0f, f, drawable);
    }

    public PieEntry(float f, Drawable drawable, Object obj) {
        super(0.0f, f, drawable, obj);
    }

    public PieEntry(float f, String str) {
        super(0.0f, f);
        this.f16037oI0IIXIo = str;
    }

    public PieEntry(float f, String str, Object obj) {
        super(0.0f, f, obj);
        this.f16037oI0IIXIo = str;
    }

    public PieEntry(float f, String str, Drawable drawable) {
        super(0.0f, f, drawable);
        this.f16037oI0IIXIo = str;
    }

    public PieEntry(float f, String str, Drawable drawable, Object obj) {
        super(0.0f, f, drawable, obj);
        this.f16037oI0IIXIo = str;
    }
}
