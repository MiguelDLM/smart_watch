package xII;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class Oxx0IOOO extends II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f34149oIX0oI;

    public Oxx0IOOO() {
        this(0, 1, null);
    }

    public static /* synthetic */ Oxx0IOOO I0Io(Oxx0IOOO oxx0IOOO, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = oxx0IOOO.f34149oIX0oI;
        }
        return oxx0IOOO.II0xO0(i);
    }

    @OOXIXo
    public final Oxx0IOOO II0xO0(int i) {
        return new Oxx0IOOO(i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Oxx0IOOO) && this.f34149oIX0oI == ((Oxx0IOOO) obj).f34149oIX0oI) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f34149oIX0oI;
    }

    public final int oIX0oI() {
        return this.f34149oIX0oI;
    }

    public final int oxoX() {
        return this.f34149oIX0oI;
    }

    @OOXIXo
    public String toString() {
        return "RequestMtuMessage(mMtu=" + this.f34149oIX0oI + HexStringBuilder.COMMENT_END_CHAR;
    }

    public /* synthetic */ Oxx0IOOO(int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? I0Io.oIX0oI() : i);
    }

    public Oxx0IOOO(int i) {
        this.f34149oIX0oI = i;
    }
}
