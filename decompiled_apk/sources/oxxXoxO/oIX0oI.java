package oxxXoxO;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    @OOXIXo
    public final String f33638I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final II0xO0 f33639II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f33640oIX0oI;

    public oIX0oI(int i, @OOXIXo II0xO0 details, @OOXIXo String msg) {
        IIX0o.x0xO0oo(details, "details");
        IIX0o.x0xO0oo(msg, "msg");
        this.f33640oIX0oI = i;
        this.f33639II0xO0 = details;
        this.f33638I0Io = msg;
    }

    public static /* synthetic */ oIX0oI X0o0xo(oIX0oI oix0oi, int i, II0xO0 iI0xO0, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = oix0oi.f33640oIX0oI;
        }
        if ((i2 & 2) != 0) {
            iI0xO0 = oix0oi.f33639II0xO0;
        }
        if ((i2 & 4) != 0) {
            str = oix0oi.f33638I0Io;
        }
        return oix0oi.oxoX(i, iI0xO0, str);
    }

    @OOXIXo
    public final String I0Io() {
        return this.f33638I0Io;
    }

    @OOXIXo
    public final String II0XooXoX() {
        return this.f33638I0Io;
    }

    @OOXIXo
    public final II0xO0 II0xO0() {
        return this.f33639II0xO0;
    }

    @OOXIXo
    public final II0xO0 Oxx0IOOO() {
        return this.f33639II0xO0;
    }

    public final int XO() {
        return this.f33640oIX0oI;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oIX0oI)) {
            return false;
        }
        oIX0oI oix0oi = (oIX0oI) obj;
        if (this.f33640oIX0oI == oix0oi.f33640oIX0oI && IIX0o.Oxx0IOOO(this.f33639II0xO0, oix0oi.f33639II0xO0) && IIX0o.Oxx0IOOO(this.f33638I0Io, oix0oi.f33638I0Io)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f33640oIX0oI * 31) + this.f33639II0xO0.hashCode()) * 31) + this.f33638I0Io.hashCode();
    }

    public final int oIX0oI() {
        return this.f33640oIX0oI;
    }

    @OOXIXo
    public final oIX0oI oxoX(int i, @OOXIXo II0xO0 details, @OOXIXo String msg) {
        IIX0o.x0xO0oo(details, "details");
        IIX0o.x0xO0oo(msg, "msg");
        return new oIX0oI(i, details, msg);
    }

    @OOXIXo
    public String toString() {
        return "BodyFatScale(code=" + this.f33640oIX0oI + ", details=" + this.f33639II0xO0 + ", msg=" + this.f33638I0Io + HexStringBuilder.COMMENT_END_CHAR;
    }
}
