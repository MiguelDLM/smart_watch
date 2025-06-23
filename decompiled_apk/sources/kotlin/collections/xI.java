package kotlin.collections;

import com.goodix.ble.libcomx.util.HexStringBuilder;

/* loaded from: classes6.dex */
public final class xI<T> {

    /* renamed from: II0xO0, reason: collision with root package name */
    public final T f29173II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final int f29174oIX0oI;

    public xI(int i, T t) {
        this.f29174oIX0oI = i;
        this.f29173II0xO0 = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ xI oxoX(xI xIVar, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = xIVar.f29174oIX0oI;
        }
        if ((i2 & 2) != 0) {
            obj = xIVar.f29173II0xO0;
        }
        return xIVar.I0Io(i, obj);
    }

    @OXOo.OOXIXo
    public final xI<T> I0Io(int i, T t) {
        return new xI<>(i, t);
    }

    public final T II0xO0() {
        return this.f29173II0xO0;
    }

    public final int X0o0xo() {
        return this.f29174oIX0oI;
    }

    public final T XO() {
        return this.f29173II0xO0;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xI)) {
            return false;
        }
        xI xIVar = (xI) obj;
        return this.f29174oIX0oI == xIVar.f29174oIX0oI && kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f29173II0xO0, xIVar.f29173II0xO0);
    }

    public int hashCode() {
        int i = this.f29174oIX0oI * 31;
        T t = this.f29173II0xO0;
        return i + (t == null ? 0 : t.hashCode());
    }

    public final int oIX0oI() {
        return this.f29174oIX0oI;
    }

    @OXOo.OOXIXo
    public String toString() {
        return "IndexedValue(index=" + this.f29174oIX0oI + ", value=" + this.f29173II0xO0 + HexStringBuilder.COMMENT_END_CHAR;
    }
}
