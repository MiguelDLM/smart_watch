package com.github.mikephil.charting.listener;

import XI0oooXX.oxoX;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;

/* loaded from: classes9.dex */
public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public static final int f16038IIXOooo = 1;

    /* renamed from: O0xOxO, reason: collision with root package name */
    public static final int f16039O0xOxO = 5;

    /* renamed from: OxI, reason: collision with root package name */
    public static final int f16040OxI = 4;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f16041OxxIIOOXO = 0;

    /* renamed from: X0IIOO, reason: collision with root package name */
    public static final int f16042X0IIOO = 6;

    /* renamed from: o00, reason: collision with root package name */
    public static final int f16043o00 = 3;

    /* renamed from: xoXoI, reason: collision with root package name */
    public static final int f16044xoXoI = 2;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public oxoX f16045IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public GestureDetector f16047Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public T f16049oI0IIXIo;

    /* renamed from: XO, reason: collision with root package name */
    public ChartGesture f16048XO = ChartGesture.NONE;

    /* renamed from: Oo, reason: collision with root package name */
    public int f16046Oo = 0;

    /* loaded from: classes9.dex */
    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t) {
        this.f16049oI0IIXIo = t;
        this.f16047Oxx0xo = new GestureDetector(t.getContext(), this);
    }

    public static float oIX0oI(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public ChartGesture I0Io() {
        return this.f16048XO;
    }

    public void II0xO0(MotionEvent motionEvent) {
        II0xO0 onChartGestureListener = this.f16049oI0IIXIo.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.XO(motionEvent, this.f16048XO);
        }
    }

    public void Oxx0IOOO(MotionEvent motionEvent) {
        II0xO0 onChartGestureListener = this.f16049oI0IIXIo.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.oIX0oI(motionEvent, this.f16048XO);
        }
    }

    public void X0o0xo(oxoX oxox, MotionEvent motionEvent) {
        if (oxox != null && !oxox.oIX0oI(this.f16045IXxxXO)) {
            this.f16049oI0IIXIo.xXxxox0I(oxox, true);
            this.f16045IXxxXO = oxox;
        } else {
            this.f16049oI0IIXIo.xXxxox0I(null, true);
            this.f16045IXxxXO = null;
        }
    }

    public void XO(oxoX oxox) {
        this.f16045IXxxXO = oxox;
    }

    public int oxoX() {
        return this.f16046Oo;
    }
}
