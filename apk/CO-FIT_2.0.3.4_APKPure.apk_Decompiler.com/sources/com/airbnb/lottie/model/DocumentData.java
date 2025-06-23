package com.airbnb.lottie.model;

import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {

    /* renamed from: I0Io  reason: collision with root package name */
    public final float f836I0Io;
    @ColorInt

    /* renamed from: II0XooXoX  reason: collision with root package name */
    public final int f837II0XooXoX;

    /* renamed from: II0xO0  reason: collision with root package name */
    public final String f838II0xO0;

    /* renamed from: OOXIXo  reason: collision with root package name */
    public final boolean f839OOXIXo;

    /* renamed from: Oxx0IOOO  reason: collision with root package name */
    public final float f840Oxx0IOOO;

    /* renamed from: X0o0xo  reason: collision with root package name */
    public final int f841X0o0xo;

    /* renamed from: XO  reason: collision with root package name */
    public final float f842XO;

    /* renamed from: oIX0oI  reason: collision with root package name */
    public final String f843oIX0oI;

    /* renamed from: oxoX  reason: collision with root package name */
    public final Justification f844oxoX;

    /* renamed from: xoIox  reason: collision with root package name */
    public final float f845xoIox;
    @ColorInt

    /* renamed from: xxIXOIIO  reason: collision with root package name */
    public final int f846xxIXOIIO;

    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f2, float f3, @ColorInt int i2, @ColorInt int i3, float f4, boolean z) {
        this.f843oIX0oI = str;
        this.f838II0xO0 = str2;
        this.f836I0Io = f;
        this.f844oxoX = justification;
        this.f841X0o0xo = i;
        this.f842XO = f2;
        this.f840Oxx0IOOO = f3;
        this.f837II0XooXoX = i2;
        this.f846xxIXOIIO = i3;
        this.f845xoIox = f4;
        this.f839OOXIXo = z;
    }

    public int hashCode() {
        int hashCode = (((((int) (((float) (((this.f843oIX0oI.hashCode() * 31) + this.f838II0xO0.hashCode()) * 31)) + this.f836I0Io)) * 31) + this.f844oxoX.ordinal()) * 31) + this.f841X0o0xo;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f842XO);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f837II0XooXoX;
    }
}
