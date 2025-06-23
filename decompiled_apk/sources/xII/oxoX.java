package xII;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes8.dex */
public final class oxoX extends II0xO0 {

    /* renamed from: I0Io, reason: collision with root package name */
    public final boolean f34153I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OOXIXo
    public final String f34154II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OOXIXo
    public final String f34155oIX0oI;

    public /* synthetic */ oxoX(String str, String str2, boolean z, int i, IIXOooo iIXOooo) {
        this(str, str2, (i & 4) != 0 ? true : z);
    }

    public static /* synthetic */ oxoX X0o0xo(oxoX oxox, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = oxox.f34155oIX0oI;
        }
        if ((i & 2) != 0) {
            str2 = oxox.f34154II0xO0;
        }
        if ((i & 4) != 0) {
            z = oxox.f34153I0Io;
        }
        return oxox.oxoX(str, str2, z);
    }

    public final boolean I0Io() {
        return this.f34153I0Io;
    }

    @OOXIXo
    public final String II0XooXoX() {
        return this.f34155oIX0oI;
    }

    @OOXIXo
    public final String II0xO0() {
        return this.f34154II0xO0;
    }

    public final boolean Oxx0IOOO() {
        return this.f34153I0Io;
    }

    @OOXIXo
    public final String XO() {
        return this.f34154II0xO0;
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof oxoX)) {
            return false;
        }
        oxoX oxox = (oxoX) obj;
        if (IIX0o.Oxx0IOOO(this.f34155oIX0oI, oxox.f34155oIX0oI) && IIX0o.Oxx0IOOO(this.f34154II0xO0, oxox.f34154II0xO0) && this.f34153I0Io == oxox.f34153I0Io) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f34155oIX0oI.hashCode() * 31) + this.f34154II0xO0.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.f34153I0Io);
    }

    @OOXIXo
    public final String oIX0oI() {
        return this.f34155oIX0oI;
    }

    @OOXIXo
    public final oxoX oxoX(@OOXIXo String mService, @OOXIXo String mCharacteristic, boolean z) {
        IIX0o.x0xO0oo(mService, "mService");
        IIX0o.x0xO0oo(mCharacteristic, "mCharacteristic");
        return new oxoX(mService, mCharacteristic, z);
    }

    @OOXIXo
    public String toString() {
        return "NotifyMessage(mService=" + this.f34155oIX0oI + ", mCharacteristic=" + this.f34154II0xO0 + ", mEnabled=" + this.f34153I0Io + HexStringBuilder.COMMENT_END_CHAR;
    }

    public oxoX(@OOXIXo String mService, @OOXIXo String mCharacteristic, boolean z) {
        IIX0o.x0xO0oo(mService, "mService");
        IIX0o.x0xO0oo(mCharacteristic, "mCharacteristic");
        this.f34155oIX0oI = mService;
        this.f34154II0xO0 = mCharacteristic;
        this.f34153I0Io = z;
    }
}
