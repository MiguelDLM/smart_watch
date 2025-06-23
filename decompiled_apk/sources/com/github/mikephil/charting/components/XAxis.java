package com.github.mikephil.charting.components;

import XIXIX.OOXIXo;

/* loaded from: classes9.dex */
public class XAxis extends XX0xXo.oIX0oI {

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public int f15979oo0xXOI0I = 1;

    /* renamed from: oo, reason: collision with root package name */
    public int f15978oo = 1;

    /* renamed from: IoOoX, reason: collision with root package name */
    public int f15974IoOoX = 1;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public int f15977oOXoIIIo = 1;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public float f15976Xx000oIo = 0.0f;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public boolean f15975X00IoxXI = false;

    /* renamed from: IO, reason: collision with root package name */
    public XAxisPosition f15973IO = XAxisPosition.TOP;

    /* loaded from: classes9.dex */
    public enum XAxisPosition {
        TOP,
        BOTTOM,
        BOTH_SIDED,
        TOP_INSIDE,
        BOTTOM_INSIDE
    }

    public XAxis() {
        this.f3992I0Io = OOXIXo.X0o0xo(4.0f);
    }

    public void I0(XAxisPosition xAxisPosition) {
        this.f15973IO = xAxisPosition;
    }

    public void IIxOXoOo0(float f) {
        this.f15976Xx000oIo = f;
    }

    public float O00XxXI() {
        return this.f15976Xx000oIo;
    }

    public void OOXIxO0(boolean z) {
        this.f15975X00IoxXI = z;
    }

    public boolean XI0oooXX() {
        return this.f15975X00IoxXI;
    }

    public XAxisPosition ox() {
        return this.f15973IO;
    }
}
