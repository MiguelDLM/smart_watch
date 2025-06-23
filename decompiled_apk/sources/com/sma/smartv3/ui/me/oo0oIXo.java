package com.sma.smartv3.ui.me;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.BleLocationGga;
import com.szabh.smable3.entity.BleLocationGsv;
import java.util.List;

/* loaded from: classes11.dex */
public final class oo0oIXo {

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.oOoXoXO
    public BleLocationGga f23588I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23589II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public String f23590oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.oOoXoXO
    public List<BleLocationGsv> f23591oxoX;

    public oo0oIXo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ oo0oIXo XO(oo0oIXo oo0oixo, String str, String str2, BleLocationGga bleLocationGga, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oo0oixo.f23590oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = oo0oixo.f23589II0xO0;
        }
        if ((i & 4) != 0) {
            bleLocationGga = oo0oixo.f23588I0Io;
        }
        if ((i & 8) != 0) {
            list = oo0oixo.f23591oxoX;
        }
        return oo0oixo.X0o0xo(str, str2, bleLocationGga, list);
    }

    @OXOo.oOoXoXO
    public final BleLocationGga I0Io() {
        return this.f23588I0Io;
    }

    @OXOo.oOoXoXO
    public final List<BleLocationGsv> II0XooXoX() {
        return this.f23591oxoX;
    }

    @OXOo.OOXIXo
    public final String II0xO0() {
        return this.f23589II0xO0;
    }

    public final void OOXIXo(@OXOo.oOoXoXO BleLocationGga bleLocationGga) {
        this.f23588I0Io = bleLocationGga;
    }

    @OXOo.oOoXoXO
    public final BleLocationGga Oxx0IOOO() {
        return this.f23588I0Io;
    }

    @OXOo.OOXIXo
    public final oo0oIXo X0o0xo(@OXOo.OOXIXo String time, @OXOo.OOXIXo String power, @OXOo.oOoXoXO BleLocationGga bleLocationGga, @OXOo.oOoXoXO List<BleLocationGsv> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(time, "time");
        kotlin.jvm.internal.IIX0o.x0xO0oo(power, "power");
        return new oo0oIXo(time, power, bleLocationGga, list);
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oo0oIXo)) {
            return false;
        }
        oo0oIXo oo0oixo = (oo0oIXo) obj;
        return kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23590oIX0oI, oo0oixo.f23590oIX0oI) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23589II0xO0, oo0oixo.f23589II0xO0) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23588I0Io, oo0oixo.f23588I0Io) && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f23591oxoX, oo0oixo.f23591oxoX);
    }

    public int hashCode() {
        int hashCode = ((this.f23590oIX0oI.hashCode() * 31) + this.f23589II0xO0.hashCode()) * 31;
        BleLocationGga bleLocationGga = this.f23588I0Io;
        int hashCode2 = (hashCode + (bleLocationGga == null ? 0 : bleLocationGga.hashCode())) * 31;
        List<BleLocationGsv> list = this.f23591oxoX;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @OXOo.OOXIXo
    public final String oIX0oI() {
        return this.f23590oIX0oI;
    }

    public final void oOoXoXO(@OXOo.oOoXoXO List<BleLocationGsv> list) {
        this.f23591oxoX = list;
    }

    public final void ooOOo0oXI(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23589II0xO0 = str;
    }

    @OXOo.oOoXoXO
    public final List<BleLocationGsv> oxoX() {
        return this.f23591oxoX;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "GpsInfo(time=" + this.f23590oIX0oI + ", power=" + this.f23589II0xO0 + ", gga=" + this.f23588I0Io + ", gsv=" + this.f23591oxoX + HexStringBuilder.COMMENT_END_CHAR;
    }

    public final void x0XOIxOo(@OXOo.OOXIXo String str) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(str, "<set-?>");
        this.f23590oIX0oI = str;
    }

    @OXOo.OOXIXo
    public final String xoIox() {
        return this.f23590oIX0oI;
    }

    @OXOo.OOXIXo
    public final String xxIXOIIO() {
        return this.f23589II0xO0;
    }

    public oo0oIXo(@OXOo.OOXIXo String time, @OXOo.OOXIXo String power, @OXOo.oOoXoXO BleLocationGga bleLocationGga, @OXOo.oOoXoXO List<BleLocationGsv> list) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(time, "time");
        kotlin.jvm.internal.IIX0o.x0xO0oo(power, "power");
        this.f23590oIX0oI = time;
        this.f23589II0xO0 = power;
        this.f23588I0Io = bleLocationGga;
        this.f23591oxoX = list;
    }

    public /* synthetic */ oo0oIXo(String str, String str2, BleLocationGga bleLocationGga, List list, int i, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : bleLocationGga, (i & 8) != 0 ? null : list);
    }
}
