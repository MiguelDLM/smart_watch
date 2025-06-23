package oxxXoxO;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes8.dex */
public final class oxoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final int f33641II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f33642oIX0oI;

    public oxoX(int i, int i2) {
        this.f33642oIX0oI = i;
        this.f33641II0xO0 = i2;
    }

    public static /* synthetic */ oxoX oxoX(oxoX oxox, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = oxox.f33642oIX0oI;
        }
        if ((i3 & 2) != 0) {
            i2 = oxox.f33641II0xO0;
        }
        return oxox.I0Io(i, i2);
    }

    @OOXIXo
    public final oxoX I0Io(int i, int i2) {
        return new oxoX(i, i2);
    }

    public final int II0xO0() {
        return this.f33641II0xO0;
    }

    public final int X0o0xo() {
        return this.f33642oIX0oI;
    }

    public final int XO() {
        return this.f33641II0xO0;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oxoX)) {
            return false;
        }
        oxoX oxox = (oxoX) obj;
        if (this.f33642oIX0oI == oxox.f33642oIX0oI && this.f33641II0xO0 == oxox.f33641II0xO0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f33642oIX0oI * 31) + this.f33641II0xO0;
    }

    public final int oIX0oI() {
        return this.f33642oIX0oI;
    }

    @OOXIXo
    public String toString() {
        return "RateOfBurnFat(max=" + this.f33642oIX0oI + ", min=" + this.f33641II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
