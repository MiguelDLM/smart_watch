package com.sma.smartv3.initializer;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class O0xOxO {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f20883I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f20884II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f20885oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f20886oxoX;

    public O0xOxO() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ O0xOxO XO(O0xOxO o0xOxO, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = o0xOxO.f20885oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = o0xOxO.f20884II0xO0;
        }
        if ((i & 4) != 0) {
            str3 = o0xOxO.f20883I0Io;
        }
        if ((i & 8) != 0) {
            str4 = o0xOxO.f20886oxoX;
        }
        return o0xOxO.X0o0xo(str, str2, str3, str4);
    }

    @OXOo.OOXIXo
    public final String I0Io() {
        return this.f20883I0Io;
    }

    @OXOo.OOXIXo
    public final String II0XooXoX() {
        return this.f20886oxoX;
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        return this.f20884II0xO0;
    }

    public final void OOXIXo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f20883I0Io = str;
    }

    @OXOo.OOXIXo
    public final String Oxx0IOOO() {
        return this.f20883I0Io;
    }

    @OXOo.OOXIXo
    public final O0xOxO X0o0xo(@OXOo.OOXIXo String mWeather, @OXOo.OOXIXo String mRealtime, @OXOo.OOXIXo String mForecast, @OXOo.OOXIXo String mLocation) {
        IIX0o.x0xO0oo(mWeather, "mWeather");
        IIX0o.x0xO0oo(mRealtime, "mRealtime");
        IIX0o.x0xO0oo(mForecast, "mForecast");
        IIX0o.x0xO0oo(mLocation, "mLocation");
        return new O0xOxO(mWeather, mRealtime, mForecast, mLocation);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof O0xOxO)) {
            return false;
        }
        O0xOxO o0xOxO = (O0xOxO) obj;
        return IIX0o.Oxx0IOOO(this.f20885oIX0oI, o0xOxO.f20885oIX0oI) && IIX0o.Oxx0IOOO(this.f20884II0xO0, o0xOxO.f20884II0xO0) && IIX0o.Oxx0IOOO(this.f20883I0Io, o0xOxO.f20883I0Io) && IIX0o.Oxx0IOOO(this.f20886oxoX, o0xOxO.f20886oxoX);
    }

    public int hashCode() {
        return (((((this.f20885oIX0oI.hashCode() * 31) + this.f20884II0xO0.hashCode()) * 31) + this.f20883I0Io.hashCode()) * 31) + this.f20886oxoX.hashCode();
    }

    @OXOo.OOXIXo
    public final String oIX0oI() {
        return this.f20885oIX0oI;
    }

    public final void oOoXoXO(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f20886oxoX = str;
    }

    public final void ooOOo0oXI(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f20884II0xO0 = str;
    }

    @OXOo.OOXIXo
    public final String oxoX() {
        return this.f20886oxoX;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "WeatherStatus(mWeather=" + this.f20885oIX0oI + ", mRealtime=" + this.f20884II0xO0 + ", mForecast=" + this.f20883I0Io + ", mLocation=" + this.f20886oxoX + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void x0XOIxOo(@OXOo.OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.f20885oIX0oI = str;
    }

    @OXOo.OOXIXo
    public final String xoIox() {
        return this.f20885oIX0oI;
    }

    @OXOo.OOXIXo
    public final String xxIXOIIO() {
        return this.f20884II0xO0;
    }

    public O0xOxO(@OXOo.OOXIXo String mWeather, @OXOo.OOXIXo String mRealtime, @OXOo.OOXIXo String mForecast, @OXOo.OOXIXo String mLocation) {
        IIX0o.x0xO0oo(mWeather, "mWeather");
        IIX0o.x0xO0oo(mRealtime, "mRealtime");
        IIX0o.x0xO0oo(mForecast, "mForecast");
        IIX0o.x0xO0oo(mLocation, "mLocation");
        this.f20885oIX0oI = mWeather;
        this.f20884II0xO0 = mRealtime;
        this.f20883I0Io = mForecast;
        this.f20886oxoX = mLocation;
    }

    public /* synthetic */ O0xOxO(String str, String str2, String str3, String str4, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }
}
