package com.github.mikephil.charting.components;

import XIXIX.OOXIXo;
import android.graphics.Paint;

/* loaded from: classes9.dex */
public class YAxis extends XX0xXo.oIX0oI {

    /* renamed from: IO, reason: collision with root package name */
    public int f15980IO;

    /* renamed from: Io, reason: collision with root package name */
    public AxisDependency f15981Io;

    /* renamed from: IoOoX, reason: collision with root package name */
    public boolean f15982IoOoX;

    /* renamed from: OI0, reason: collision with root package name */
    public YAxisLabelPosition f15983OI0;

    /* renamed from: X00IoxXI, reason: collision with root package name */
    public boolean f15984X00IoxXI;

    /* renamed from: XOxIOxOx, reason: collision with root package name */
    public float f15985XOxIOxOx;

    /* renamed from: XX, reason: collision with root package name */
    public float f15986XX;

    /* renamed from: Xx000oIo, reason: collision with root package name */
    public boolean f15987Xx000oIo;

    /* renamed from: o0, reason: collision with root package name */
    public float f15988o0;

    /* renamed from: oOXoIIIo, reason: collision with root package name */
    public boolean f15989oOXoIIIo;

    /* renamed from: oo, reason: collision with root package name */
    public boolean f15990oo;

    /* renamed from: oo0xXOI0I, reason: collision with root package name */
    public boolean f15991oo0xXOI0I;

    /* renamed from: x0o, reason: collision with root package name */
    public float f15992x0o;

    /* renamed from: xII, reason: collision with root package name */
    public float f15993xII;

    /* loaded from: classes9.dex */
    public enum AxisDependency {
        LEFT,
        RIGHT
    }

    /* loaded from: classes9.dex */
    public enum YAxisLabelPosition {
        OUTSIDE_CHART,
        INSIDE_CHART
    }

    public YAxis() {
        this.f15991oo0xXOI0I = true;
        this.f15990oo = true;
        this.f15982IoOoX = false;
        this.f15989oOXoIIIo = false;
        this.f15987Xx000oIo = false;
        this.f15984X00IoxXI = false;
        this.f15980IO = -7829368;
        this.f15993xII = 1.0f;
        this.f15992x0o = 10.0f;
        this.f15985XOxIOxOx = 10.0f;
        this.f15983OI0 = YAxisLabelPosition.OUTSIDE_CHART;
        this.f15988o0 = 0.0f;
        this.f15986XX = Float.POSITIVE_INFINITY;
        this.f15981Io = AxisDependency.LEFT;
        this.f3992I0Io = 0.0f;
    }

    public float I0(Paint paint) {
        paint.setTextSize(this.f3994X0o0xo);
        float oxoX2 = OOXIXo.oxoX(paint, XxX0x0xxx()) + (oxoX() * 2.0f);
        float OOXIxO02 = OOXIxO0();
        float XI0oooXX2 = XI0oooXX();
        if (OOXIxO02 > 0.0f) {
            OOXIxO02 = OOXIXo.X0o0xo(OOXIxO02);
        }
        if (XI0oooXX2 > 0.0f && XI0oooXX2 != Float.POSITIVE_INFINITY) {
            XI0oooXX2 = OOXIXo.X0o0xo(XI0oooXX2);
        }
        if (XI0oooXX2 <= OOXIXo.f3760XO) {
            XI0oooXX2 = oxoX2;
        }
        return Math.max(OOXIxO02, Math.min(oxoX2, XI0oooXX2));
    }

    @Deprecated
    public boolean IIX0() {
        return this.f15987Xx000oIo;
    }

    public float IIxOXoOo0(Paint paint) {
        paint.setTextSize(this.f3994X0o0xo);
        return OOXIXo.oIX0oI(paint, XxX0x0xxx()) + (X0o0xo() * 2.0f);
    }

    public void IoIOOxIIo(float f) {
        this.f15988o0 = f;
    }

    public void IxIX0I(float f) {
        this.f15993xII = OOXIXo.X0o0xo(f);
    }

    public void O0(boolean z) {
        this.f15989oOXoIIIo = z;
    }

    public AxisDependency O00XxXI() {
        return this.f15981Io;
    }

    @Deprecated
    public boolean O0X() {
        return this.f15984X00IoxXI;
    }

    @Deprecated
    public void OIOoIIOIx(boolean z) {
        this.f15984X00IoxXI = z;
    }

    public float OOXIxO0() {
        return this.f15988o0;
    }

    public int OX00O0xII() {
        return this.f15980IO;
    }

    @Deprecated
    public void OoO(boolean z) {
        if (z) {
            I0X0x0oIo(0.0f);
        } else {
            I0oOoX();
        }
    }

    public void Ox0O(boolean z) {
        this.f15990oo = z;
    }

    public float XI0oooXX() {
        return this.f15986XX;
    }

    public boolean XIXIX() {
        return this.f15990oo;
    }

    public void XIXIxO(float f) {
        this.f15992x0o = f;
    }

    public void XXoOx0(int i) {
        this.f15980IO = i;
    }

    public void o0oIxOo(float f) {
        this.f15985XOxIOxOx = f;
    }

    public boolean oOo() {
        return this.f15982IoOoX;
    }

    public boolean oXIO0o0XI() {
        return this.f15989oOXoIIIo;
    }

    public float ooOx() {
        return this.f15985XOxIOxOx;
    }

    public YAxisLabelPosition ox() {
        return this.f15983OI0;
    }

    public void oxIIX0o(YAxisLabelPosition yAxisLabelPosition) {
        this.f15983OI0 = yAxisLabelPosition;
    }

    @Deprecated
    public void x0OIX00oO(boolean z) {
        this.f15987Xx000oIo = z;
    }

    @Override // XX0xXo.oIX0oI
    public void x0XOIxOo(float f, float f2) {
        float ooOx2;
        float xoO0xx02;
        if (Math.abs(f2 - f) == 0.0f) {
            f2 += 1.0f;
            f -= 1.0f;
        }
        float abs = Math.abs(f2 - f);
        if (this.f4019XxX0x0xxx) {
            ooOx2 = this.f4025ooXIXxIX;
        } else {
            ooOx2 = f - ((abs / 100.0f) * ooOx());
        }
        this.f4025ooXIXxIX = ooOx2;
        if (this.f4029xXxxox0I) {
            xoO0xx02 = this.f4006IIX0o;
        } else {
            xoO0xx02 = f2 + ((abs / 100.0f) * xoO0xx0());
        }
        this.f4006IIX0o = xoO0xx02;
        this.f4028xI = Math.abs(this.f4025ooXIXxIX - xoO0xx02);
    }

    public void xI0oxI00(float f) {
        this.f15986XX = f;
    }

    public boolean xOOOX() {
        return this.f15991oo0xXOI0I;
    }

    public boolean xOoOIoI() {
        if (XO() && IO() && ox() == YAxisLabelPosition.OUTSIDE_CHART) {
            return true;
        }
        return false;
    }

    public float xX0IIXIx0() {
        return this.f15993xII;
    }

    public float xoO0xx0() {
        return this.f15992x0o;
    }

    public void xx0X0(boolean z) {
        this.f15982IoOoX = z;
    }

    public YAxis(AxisDependency axisDependency) {
        this.f15991oo0xXOI0I = true;
        this.f15990oo = true;
        this.f15982IoOoX = false;
        this.f15989oOXoIIIo = false;
        this.f15987Xx000oIo = false;
        this.f15984X00IoxXI = false;
        this.f15980IO = -7829368;
        this.f15993xII = 1.0f;
        this.f15992x0o = 10.0f;
        this.f15985XOxIOxOx = 10.0f;
        this.f15983OI0 = YAxisLabelPosition.OUTSIDE_CHART;
        this.f15988o0 = 0.0f;
        this.f15986XX = Float.POSITIVE_INFINITY;
        this.f15981Io = axisDependency;
        this.f3992I0Io = 0.0f;
    }
}
