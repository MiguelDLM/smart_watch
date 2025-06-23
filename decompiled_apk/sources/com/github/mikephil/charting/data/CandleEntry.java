package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes9.dex */
public class CandleEntry extends Entry {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public float f16005IIXOooo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public float f16006OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f16007oI0IIXIo;

    /* renamed from: xoXoI, reason: collision with root package name */
    public float f16008xoXoI;

    public CandleEntry(float f, float f2, float f3, float f4, float f5) {
        super(f, (f2 + f3) / 2.0f);
        this.f16007oI0IIXIo = f2;
        this.f16006OxxIIOOXO = f3;
        this.f16008xoXoI = f4;
        this.f16005IIXOooo = f5;
    }

    @Override // o0xxxXXxX.XO
    public float I0Io() {
        return super.I0Io();
    }

    public void IXxxXO(float f) {
        this.f16005IIXOooo = f;
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public CandleEntry Oxx0IOOO() {
        return new CandleEntry(xxIXOIIO(), this.f16007oI0IIXIo, this.f16006OxxIIOOXO, this.f16008xoXoI, this.f16005IIXOooo, oIX0oI());
    }

    public float Oo() {
        return Math.abs(this.f16007oI0IIXIo - this.f16006OxxIIOOXO);
    }

    public void Oxx0xo(float f) {
        this.f16007oI0IIXIo = f;
    }

    public void OxxIIOOXO(float f) {
        this.f16008xoXoI = f;
    }

    public void oI0IIXIo(float f) {
        this.f16006OxxIIOOXO = f;
    }

    public float oO() {
        return this.f16006OxxIIOOXO;
    }

    public float oOoXoXO() {
        return Math.abs(this.f16008xoXoI - this.f16005IIXOooo);
    }

    public float ooOOo0oXI() {
        return this.f16005IIXOooo;
    }

    public float x0XOIxOo() {
        return this.f16007oI0IIXIo;
    }

    public float x0xO0oo() {
        return this.f16008xoXoI;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Object obj) {
        super(f, (f2 + f3) / 2.0f, obj);
        this.f16007oI0IIXIo = f2;
        this.f16006OxxIIOOXO = f3;
        this.f16008xoXoI = f4;
        this.f16005IIXOooo = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable) {
        super(f, (f2 + f3) / 2.0f, drawable);
        this.f16007oI0IIXIo = f2;
        this.f16006OxxIIOOXO = f3;
        this.f16008xoXoI = f4;
        this.f16005IIXOooo = f5;
    }

    public CandleEntry(float f, float f2, float f3, float f4, float f5, Drawable drawable, Object obj) {
        super(f, (f2 + f3) / 2.0f, drawable, obj);
        this.f16007oI0IIXIo = f2;
        this.f16006OxxIIOOXO = f3;
        this.f16008xoXoI = f4;
        this.f16005IIXOooo = f5;
    }
}
