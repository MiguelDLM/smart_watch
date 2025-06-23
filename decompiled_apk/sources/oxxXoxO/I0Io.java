package oxxXoxO;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class I0Io {

    /* renamed from: I0Io, reason: collision with root package name */
    public final int f33574I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final String f33575II0xO0;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final int f33576Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public final int f33577X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f33578XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f33579oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OOXIXo
    public final String f33580oxoX;

    public I0Io(@OOXIXo String biaData, @OOXIXo String dataId, int i, @OOXIXo String deviceMac, int i2, int i3, int i4) {
        IIX0o.x0xO0oo(biaData, "biaData");
        IIX0o.x0xO0oo(dataId, "dataId");
        IIX0o.x0xO0oo(deviceMac, "deviceMac");
        this.f33579oIX0oI = biaData;
        this.f33575II0xO0 = dataId;
        this.f33574I0Io = i;
        this.f33580oxoX = deviceMac;
        this.f33577X0o0xo = i2;
        this.f33578XO = i3;
        this.f33576Oxx0IOOO = i4;
    }

    public static /* synthetic */ I0Io xxIXOIIO(I0Io i0Io, String str, String str2, int i, String str3, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = i0Io.f33579oIX0oI;
        }
        if ((i5 & 2) != 0) {
            str2 = i0Io.f33575II0xO0;
        }
        String str4 = str2;
        if ((i5 & 4) != 0) {
            i = i0Io.f33574I0Io;
        }
        int i6 = i;
        if ((i5 & 8) != 0) {
            str3 = i0Io.f33580oxoX;
        }
        String str5 = str3;
        if ((i5 & 16) != 0) {
            i2 = i0Io.f33577X0o0xo;
        }
        int i7 = i2;
        if ((i5 & 32) != 0) {
            i3 = i0Io.f33578XO;
        }
        int i8 = i3;
        if ((i5 & 64) != 0) {
            i4 = i0Io.f33576Oxx0IOOO;
        }
        return i0Io.II0XooXoX(str, str4, i6, str5, i7, i8, i4);
    }

    public final int I0Io() {
        return this.f33574I0Io;
    }

    @OOXIXo
    public final I0Io II0XooXoX(@OOXIXo String biaData, @OOXIXo String dataId, int i, @OOXIXo String deviceMac, int i2, int i3, int i4) {
        IIX0o.x0xO0oo(biaData, "biaData");
        IIX0o.x0xO0oo(dataId, "dataId");
        IIX0o.x0xO0oo(deviceMac, "deviceMac");
        return new I0Io(biaData, dataId, i, deviceMac, i2, i3, i4);
    }

    @OOXIXo
    public final String II0xO0() {
        return this.f33575II0xO0;
    }

    @OOXIXo
    public final String OOXIXo() {
        return this.f33575II0xO0;
    }

    public final int Oxx0IOOO() {
        return this.f33576Oxx0IOOO;
    }

    public final int X0o0xo() {
        return this.f33577X0o0xo;
    }

    public final int XO() {
        return this.f33578XO;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I0Io)) {
            return false;
        }
        I0Io i0Io = (I0Io) obj;
        if (IIX0o.Oxx0IOOO(this.f33579oIX0oI, i0Io.f33579oIX0oI) && IIX0o.Oxx0IOOO(this.f33575II0xO0, i0Io.f33575II0xO0) && this.f33574I0Io == i0Io.f33574I0Io && IIX0o.Oxx0IOOO(this.f33580oxoX, i0Io.f33580oxoX) && this.f33577X0o0xo == i0Io.f33577X0o0xo && this.f33578XO == i0Io.f33578XO && this.f33576Oxx0IOOO == i0Io.f33576Oxx0IOOO) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.f33579oIX0oI.hashCode() * 31) + this.f33575II0xO0.hashCode()) * 31) + this.f33574I0Io) * 31) + this.f33580oxoX.hashCode()) * 31) + this.f33577X0o0xo) * 31) + this.f33578XO) * 31) + this.f33576Oxx0IOOO;
    }

    @OOXIXo
    public final String oIX0oI() {
        return this.f33579oIX0oI;
    }

    public final int oO() {
        return this.f33578XO;
    }

    public final int oOoXoXO() {
        return this.f33574I0Io;
    }

    @OOXIXo
    public final String ooOOo0oXI() {
        return this.f33580oxoX;
    }

    @OOXIXo
    public final String oxoX() {
        return this.f33580oxoX;
    }

    @OOXIXo
    public String toString() {
        return "DeviceInfo(biaData=" + this.f33579oIX0oI + ", dataId=" + this.f33575II0xO0 + ", dataScale=" + this.f33574I0Io + ", deviceMac=" + this.f33580oxoX + ", deviceSubType=" + this.f33577X0o0xo + ", deviceType=" + this.f33578XO + ", deviceVendor=" + this.f33576Oxx0IOOO + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final int x0XOIxOo() {
        return this.f33577X0o0xo;
    }

    public final int x0xO0oo() {
        return this.f33576Oxx0IOOO;
    }

    @OOXIXo
    public final String xoIox() {
        return this.f33579oIX0oI;
    }
}
