package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;

/* loaded from: classes9.dex */
public class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public float f15994I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Legend.LegendForm f15995II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public DashPathEffect f15996X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f15997XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public String f15998oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public float f15999oxoX;

    public oIX0oI() {
        this.f15995II0xO0 = Legend.LegendForm.DEFAULT;
        this.f15994I0Io = Float.NaN;
        this.f15999oxoX = Float.NaN;
        this.f15996X0o0xo = null;
        this.f15997XO = XIXIX.oIX0oI.f3782oIX0oI;
    }

    public oIX0oI(String str, Legend.LegendForm legendForm, float f, float f2, DashPathEffect dashPathEffect, int i) {
        Legend.LegendForm legendForm2 = Legend.LegendForm.DEFAULT;
        this.f15998oIX0oI = str;
        this.f15995II0xO0 = legendForm;
        this.f15994I0Io = f;
        this.f15999oxoX = f2;
        this.f15996X0o0xo = dashPathEffect;
        this.f15997XO = i;
    }
}
