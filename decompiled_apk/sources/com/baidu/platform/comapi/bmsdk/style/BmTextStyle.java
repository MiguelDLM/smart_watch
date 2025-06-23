package com.baidu.platform.comapi.bmsdk.style;

import com.baidu.platform.comapi.bmsdk.BmObject;

/* loaded from: classes8.dex */
public class BmTextStyle extends BmObject implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private int f9587a;
    private int b;
    private int c;
    private int d;
    private int e;

    public BmTextStyle() {
        super(54, nativeCreate());
        this.f9587a = -13421773;
        this.b = 22;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    private static native long nativeCreate();

    private static native boolean nativeSetBorderColor(long j, int i);

    private static native boolean nativeSetBorderWidth(long j, int i);

    private static native boolean nativeSetFontOption(long j, int i);

    private static native boolean nativeSetTextColor(long j, int i);

    private static native boolean nativeSetTextSize(long j, int i);

    public boolean a(int i) {
        this.f9587a = i;
        return nativeSetTextColor(this.g, a.a(i));
    }

    public boolean b(int i) {
        this.b = i;
        return nativeSetTextSize(this.g, i);
    }

    public boolean c(int i) {
        this.c = i;
        return nativeSetBorderColor(this.g, a.a(i));
    }

    public boolean d(int i) {
        this.d = i;
        return nativeSetBorderWidth(this.g, i);
    }

    public boolean e(int i) {
        this.e = i;
        return nativeSetFontOption(this.g, i);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public BmTextStyle clone() {
        BmTextStyle bmTextStyle = new BmTextStyle();
        bmTextStyle.a(this.f9587a);
        bmTextStyle.b(this.b);
        bmTextStyle.c(this.c);
        bmTextStyle.d(this.d);
        bmTextStyle.e(this.e);
        return bmTextStyle;
    }
}
