package xII;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class X0o0xo extends II0xO0 {

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final String f34150II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f34151oIX0oI;

    public X0o0xo(@OOXIXo String mService, @OOXIXo String mCharacteristic) {
        IIX0o.x0xO0oo(mService, "mService");
        IIX0o.x0xO0oo(mCharacteristic, "mCharacteristic");
        this.f34151oIX0oI = mService;
        this.f34150II0xO0 = mCharacteristic;
    }

    public static /* synthetic */ X0o0xo oxoX(X0o0xo x0o0xo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = x0o0xo.f34151oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = x0o0xo.f34150II0xO0;
        }
        return x0o0xo.I0Io(str, str2);
    }

    @OOXIXo
    public final X0o0xo I0Io(@OOXIXo String mService, @OOXIXo String mCharacteristic) {
        IIX0o.x0xO0oo(mService, "mService");
        IIX0o.x0xO0oo(mCharacteristic, "mCharacteristic");
        return new X0o0xo(mService, mCharacteristic);
    }

    @OOXIXo
    public final String II0xO0() {
        return this.f34150II0xO0;
    }

    @OOXIXo
    public final String X0o0xo() {
        return this.f34150II0xO0;
    }

    @OOXIXo
    public final String XO() {
        return this.f34151oIX0oI;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof X0o0xo)) {
            return false;
        }
        X0o0xo x0o0xo = (X0o0xo) obj;
        if (IIX0o.Oxx0IOOO(this.f34151oIX0oI, x0o0xo.f34151oIX0oI) && IIX0o.Oxx0IOOO(this.f34150II0xO0, x0o0xo.f34150II0xO0)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f34151oIX0oI.hashCode() * 31) + this.f34150II0xO0.hashCode();
    }

    @OOXIXo
    public final String oIX0oI() {
        return this.f34151oIX0oI;
    }

    @OOXIXo
    public String toString() {
        return "ReadMessage(mService=" + this.f34151oIX0oI + ", mCharacteristic=" + this.f34150II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
