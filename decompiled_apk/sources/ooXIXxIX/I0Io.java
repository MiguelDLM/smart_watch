package ooXIXxIX;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import XXO0.oIX0oI;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f32448I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f32449II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f32450X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f32451XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f32452oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final int f32453oxoX;

    public I0Io() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public static /* synthetic */ I0Io II0XooXoX(I0Io i0Io, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i = i0Io.f32452oIX0oI;
        }
        if ((i7 & 2) != 0) {
            i2 = i0Io.f32449II0xO0;
        }
        int i8 = i2;
        if ((i7 & 4) != 0) {
            i3 = i0Io.f32448I0Io;
        }
        int i9 = i3;
        if ((i7 & 8) != 0) {
            i4 = i0Io.f32453oxoX;
        }
        int i10 = i4;
        if ((i7 & 16) != 0) {
            i5 = i0Io.f32450X0o0xo;
        }
        int i11 = i5;
        if ((i7 & 32) != 0) {
            i6 = i0Io.f32451XO;
        }
        return i0Io.Oxx0IOOO(i, i8, i9, i10, i11, i6);
    }

    public final int I0Io() {
        return this.f32448I0Io;
    }

    public final int II0xO0() {
        return this.f32449II0xO0;
    }

    public final int OOXIXo() {
        return this.f32452oIX0oI;
    }

    @OOXIXo
    public final I0Io Oxx0IOOO(int i, int i2, int i3, int i4, int i5, int i6) {
        return new I0Io(i, i2, i3, i4, i5, i6);
    }

    public final int X0o0xo() {
        return this.f32450X0o0xo;
    }

    public final int XO() {
        return this.f32451XO;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I0Io)) {
            return false;
        }
        I0Io i0Io = (I0Io) obj;
        if (this.f32452oIX0oI == i0Io.f32452oIX0oI && this.f32449II0xO0 == i0Io.f32449II0xO0 && this.f32448I0Io == i0Io.f32448I0Io && this.f32453oxoX == i0Io.f32453oxoX && this.f32450X0o0xo == i0Io.f32450X0o0xo && this.f32451XO == i0Io.f32451XO) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f32452oIX0oI * 31) + this.f32449II0xO0) * 31) + this.f32448I0Io) * 31) + this.f32453oxoX) * 31) + this.f32450X0o0xo) * 31) + this.f32451XO;
    }

    public final int oIX0oI() {
        return this.f32452oIX0oI;
    }

    public final int oOoXoXO() {
        return this.f32451XO;
    }

    public final int ooOOo0oXI() {
        return this.f32450X0o0xo;
    }

    public final int oxoX() {
        return this.f32453oxoX;
    }

    @OOXIXo
    public String toString() {
        return "PrayerAdjustments(fajr=" + this.f32452oIX0oI + ", sunrise=" + this.f32449II0xO0 + ", dhuhr=" + this.f32448I0Io + ", asr=" + this.f32453oxoX + ", maghrib=" + this.f32450X0o0xo + ", isha=" + this.f32451XO + oIX0oI.I0Io.f4095I0Io;
    }

    public final int x0XOIxOo() {
        return this.f32449II0xO0;
    }

    public final int xoIox() {
        return this.f32448I0Io;
    }

    public final int xxIXOIIO() {
        return this.f32453oxoX;
    }

    public I0Io(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f32452oIX0oI = i;
        this.f32449II0xO0 = i2;
        this.f32448I0Io = i3;
        this.f32453oxoX = i4;
        this.f32450X0o0xo = i5;
        this.f32451XO = i6;
    }

    public /* synthetic */ I0Io(int i, int i2, int i3, int i4, int i5, int i6, int i7, IIXOooo iIXOooo) {
        this((i7 & 1) != 0 ? 0 : i, (i7 & 2) != 0 ? 0 : i2, (i7 & 4) != 0 ? 0 : i3, (i7 & 8) != 0 ? 0 : i4, (i7 & 16) != 0 ? 0 : i5, (i7 & 32) != 0 ? 0 : i6);
    }
}
