package kotlin.text;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes6.dex */
public final class OOXIXo {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public final X0.oOoXoXO f29515II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public final String f29516oIX0oI;

    public OOXIXo(@OXOo.OOXIXo String value, @OXOo.OOXIXo X0.oOoXoXO range) {
        IIX0o.x0xO0oo(value, "value");
        IIX0o.x0xO0oo(range, "range");
        this.f29516oIX0oI = value;
        this.f29515II0xO0 = range;
    }

    public static /* synthetic */ OOXIXo oxoX(OOXIXo oOXIXo, String str, X0.oOoXoXO oooxoxo, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oOXIXo.f29516oIX0oI;
        }
        if ((i & 2) != 0) {
            oooxoxo = oOXIXo.f29515II0xO0;
        }
        return oOXIXo.I0Io(str, oooxoxo);
    }

    @OXOo.OOXIXo
    public final OOXIXo I0Io(@OXOo.OOXIXo String value, @OXOo.OOXIXo X0.oOoXoXO range) {
        IIX0o.x0xO0oo(value, "value");
        IIX0o.x0xO0oo(range, "range");
        return new OOXIXo(value, range);
    }

    @OXOo.OOXIXo
    public final X0.oOoXoXO II0xO0() {
        return this.f29515II0xO0;
    }

    @OXOo.OOXIXo
    public final X0.oOoXoXO X0o0xo() {
        return this.f29515II0xO0;
    }

    @OXOo.OOXIXo
    public final String XO() {
        return this.f29516oIX0oI;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OOXIXo)) {
            return false;
        }
        OOXIXo oOXIXo = (OOXIXo) obj;
        return IIX0o.Oxx0IOOO(this.f29516oIX0oI, oOXIXo.f29516oIX0oI) && IIX0o.Oxx0IOOO(this.f29515II0xO0, oOXIXo.f29515II0xO0);
    }

    public int hashCode() {
        return (this.f29516oIX0oI.hashCode() * 31) + this.f29515II0xO0.hashCode();
    }

    @OXOo.OOXIXo
    public final String oIX0oI() {
        return this.f29516oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "MatchGroup(value=" + this.f29516oIX0oI + ", range=" + this.f29515II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
