package xII;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes8.dex */
public final class XO extends II0xO0 {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f34152oIX0oI;

    public XO(int i) {
        this.f34152oIX0oI = i;
    }

    public static /* synthetic */ XO I0Io(XO xo2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = xo2.f34152oIX0oI;
        }
        return xo2.II0xO0(i);
    }

    @OOXIXo
    public final XO II0xO0(int i) {
        return new XO(i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof XO) && this.f34152oIX0oI == ((XO) obj).f34152oIX0oI) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f34152oIX0oI;
    }

    public final int oIX0oI() {
        return this.f34152oIX0oI;
    }

    public final int oxoX() {
        return this.f34152oIX0oI;
    }

    @OOXIXo
    public String toString() {
        return "RequestConnectionPriorityMessage(mPriority=" + this.f34152oIX0oI + HexStringBuilder.COMMENT_END_CHAR;
    }
}
