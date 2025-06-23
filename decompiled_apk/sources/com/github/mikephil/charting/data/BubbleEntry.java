package com.github.mikephil.charting.data;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes9.dex */
public class BubbleEntry extends Entry {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public float f16004oI0IIXIo;

    public BubbleEntry(float f, float f2, float f3) {
        super(f, f2);
        this.f16004oI0IIXIo = f3;
    }

    @Override // com.github.mikephil.charting.data.Entry
    /* renamed from: OOXIXo, reason: merged with bridge method [inline-methods] */
    public BubbleEntry Oxx0IOOO() {
        return new BubbleEntry(xxIXOIIO(), I0Io(), this.f16004oI0IIXIo, oIX0oI());
    }

    public float oOoXoXO() {
        return this.f16004oI0IIXIo;
    }

    public void ooOOo0oXI(float f) {
        this.f16004oI0IIXIo = f;
    }

    public BubbleEntry(float f, float f2, float f3, Object obj) {
        super(f, f2, obj);
        this.f16004oI0IIXIo = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable) {
        super(f, f2, drawable);
        this.f16004oI0IIXIo = f3;
    }

    public BubbleEntry(float f, float f2, float f3, Drawable drawable, Object obj) {
        super(f, f2, drawable, obj);
        this.f16004oI0IIXIo = f3;
    }
}
