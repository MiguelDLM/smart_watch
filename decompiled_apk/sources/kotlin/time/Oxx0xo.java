package kotlin.time;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.oxxXoxO;

@IIX0(markerClass = {xoIox.class})
@oxxXoxO(version = "1.9")
/* loaded from: classes6.dex */
public final class Oxx0xo<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final long f29633II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final T f29634oIX0oI;

    public /* synthetic */ Oxx0xo(Object obj, long j, IIXOooo iIXOooo) {
        this(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Oxx0xo oxoX(Oxx0xo oxx0xo, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = oxx0xo.f29634oIX0oI;
        }
        if ((i & 2) != 0) {
            j = oxx0xo.f29633II0xO0;
        }
        return oxx0xo.I0Io(obj, j);
    }

    @OXOo.OOXIXo
    public final Oxx0xo<T> I0Io(T t, long j) {
        return new Oxx0xo<>(t, j, null);
    }

    public final long II0xO0() {
        return this.f29633II0xO0;
    }

    public final long X0o0xo() {
        return this.f29633II0xO0;
    }

    public final T XO() {
        return this.f29634oIX0oI;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Oxx0xo)) {
            return false;
        }
        Oxx0xo oxx0xo = (Oxx0xo) obj;
        return IIX0o.Oxx0IOOO(this.f29634oIX0oI, oxx0xo.f29634oIX0oI) && oxoX.IXxxXO(this.f29633II0xO0, oxx0xo.f29633II0xO0);
    }

    public int hashCode() {
        T t = this.f29634oIX0oI;
        return ((t == null ? 0 : t.hashCode()) * 31) + oxoX.XoX(this.f29633II0xO0);
    }

    public final T oIX0oI() {
        return this.f29634oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "TimedValue(value=" + this.f29634oIX0oI + ", duration=" + ((Object) oxoX.o0xxxXXxX(this.f29633II0xO0)) + HexStringBuilder.COMMENT_END_CHAR;
    }

    public Oxx0xo(T t, long j) {
        this.f29634oIX0oI = t;
        this.f29633II0xO0 = j;
    }
}
