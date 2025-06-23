package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class DocumentData {

    /* renamed from: I0Io, reason: collision with root package name */
    public final float f4830I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @ColorInt
    public final int f4831II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final String f4832II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public final boolean f4833OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final float f4834Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f4835X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final float f4836XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final String f4837oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final Justification f4838oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    public final float f4839xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @ColorInt
    public final int f4840xxIXOIIO;

    /* loaded from: classes.dex */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z) {
        this.f4837oIX0oI = str;
        this.f4832II0xO0 = str2;
        this.f4830I0Io = f;
        this.f4838oxoX = justification;
        this.f4835X0o0xo = i;
        this.f4836XO = f2;
        this.f4834Oxx0IOOO = f3;
        this.f4831II0XooXoX = i2;
        this.f4840xxIXOIIO = i3;
        this.f4839xoIox = f4;
        this.f4833OOXIXo = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.f4837oIX0oI.hashCode() * 31) + this.f4832II0xO0.hashCode()) * 31) + this.f4830I0Io)) * 31) + this.f4838oxoX.ordinal()) * 31) + this.f4835X0o0xo;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f4836XO);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f4831II0XooXoX;
    }
}
