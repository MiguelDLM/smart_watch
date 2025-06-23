package com.github.mikephil.charting.components;

import XIXIX.OOXIXo;
import XX0xXo.II0xO0;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;

/* loaded from: classes9.dex */
public class LimitLine extends II0xO0 {

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public float f15963II0XooXoX;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public String f15964OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public float f15965Oxx0IOOO;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public DashPathEffect f15966oOoXoXO;

    /* renamed from: ooOOo0oXI, reason: collision with root package name */
    public LimitLabelPosition f15967ooOOo0oXI;

    /* renamed from: xoIox, reason: collision with root package name */
    public Paint.Style f15968xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public int f15969xxIXOIIO;

    /* loaded from: classes9.dex */
    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public LimitLine(float f) {
        this.f15965Oxx0IOOO = 0.0f;
        this.f15963II0XooXoX = 2.0f;
        this.f15969xxIXOIIO = Color.rgb(237, 91, 91);
        this.f15968xoIox = Paint.Style.FILL_AND_STROKE;
        this.f15964OOXIXo = "";
        this.f15966oOoXoXO = null;
        this.f15967ooOOo0oXI = LimitLabelPosition.RIGHT_TOP;
        this.f15965Oxx0IOOO = f;
    }

    public boolean IIXOooo() {
        if (this.f15966oOoXoXO == null) {
            return false;
        }
        return true;
    }

    public float IXxxXO() {
        return this.f15965Oxx0IOOO;
    }

    public void O0xOxO(float f) {
        if (f < 0.2f) {
            f = 0.2f;
        }
        if (f > 12.0f) {
            f = 12.0f;
        }
        this.f15963II0XooXoX = OOXIXo.X0o0xo(f);
    }

    public LimitLabelPosition Oo() {
        return this.f15967ooOOo0oXI;
    }

    public void OxI(int i) {
        this.f15969xxIXOIIO = i;
    }

    public int Oxx0xo() {
        return this.f15969xxIXOIIO;
    }

    public Paint.Style OxxIIOOXO() {
        return this.f15968xoIox;
    }

    public void X0IIOO(Paint.Style style) {
        this.f15968xoIox = style;
    }

    public void o00(LimitLabelPosition limitLabelPosition) {
        this.f15967ooOOo0oXI = limitLabelPosition;
    }

    public float oI0IIXIo() {
        return this.f15963II0XooXoX;
    }

    public DashPathEffect oO() {
        return this.f15966oOoXoXO;
    }

    public void ooOOo0oXI() {
        this.f15966oOoXoXO = null;
    }

    public void x0XOIxOo(float f, float f2, float f3) {
        this.f15966oOoXoXO = new DashPathEffect(new float[]{f, f2}, f3);
    }

    public String x0xO0oo() {
        return this.f15964OOXIXo;
    }

    public void xoXoI(String str) {
        this.f15964OOXIXo = str;
    }

    public LimitLine(float f, String str) {
        this.f15965Oxx0IOOO = 0.0f;
        this.f15963II0XooXoX = 2.0f;
        this.f15969xxIXOIIO = Color.rgb(237, 91, 91);
        this.f15968xoIox = Paint.Style.FILL_AND_STROKE;
        this.f15964OOXIXo = "";
        this.f15966oOoXoXO = null;
        this.f15967ooOOo0oXI = LimitLabelPosition.RIGHT_TOP;
        this.f15965Oxx0IOOO = f;
        this.f15964OOXIXo = str;
    }
}
