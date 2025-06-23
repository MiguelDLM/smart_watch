package X0;

import kotlin.collections.oOXoIIIo;

/* loaded from: classes6.dex */
public class xoIox implements Iterable<Integer>, OI0IXox.oIX0oI {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3221Oxx0xo = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f3222IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f3223Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f3224XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final xoIox oIX0oI(int i, int i2, int i3) {
            return new xoIox(i, i2, i3);
        }

        public oIX0oI() {
        }
    }

    public xoIox(int i, int i2, int i3) {
        if (i3 != 0) {
            if (i3 != Integer.MIN_VALUE) {
                this.f3224XO = i;
                this.f3223Oo = xx0o0O.x0XOIxOo.I0Io(i, i2, i3);
                this.f3222IXxxXO = i3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    @OXOo.OOXIXo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public oOXoIIIo iterator() {
        return new OOXIXo(this.f3224XO, this.f3223Oo, this.f3222IXxxXO);
    }

    public final int X0o0xo() {
        return this.f3223Oo;
    }

    public final int XO() {
        return this.f3222IXxxXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof xoIox) {
            if (!isEmpty() || !((xoIox) obj).isEmpty()) {
                xoIox xoiox = (xoIox) obj;
                if (this.f3224XO != xoiox.f3224XO || this.f3223Oo != xoiox.f3223Oo || this.f3222IXxxXO != xoiox.f3222IXxxXO) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3224XO * 31) + this.f3223Oo) * 31) + this.f3222IXxxXO;
    }

    public boolean isEmpty() {
        if (this.f3222IXxxXO > 0) {
            if (this.f3224XO <= this.f3223Oo) {
                return false;
            }
        } else if (this.f3224XO >= this.f3223Oo) {
            return false;
        }
        return true;
    }

    public final int oxoX() {
        return this.f3224XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f3222IXxxXO > 0) {
            sb = new StringBuilder();
            sb.append(this.f3224XO);
            sb.append("..");
            sb.append(this.f3223Oo);
            sb.append(" step ");
            i = this.f3222IXxxXO;
        } else {
            sb = new StringBuilder();
            sb.append(this.f3224XO);
            sb.append(" downTo ");
            sb.append(this.f3223Oo);
            sb.append(" step ");
            i = -this.f3222IXxxXO;
        }
        sb.append(i);
        return sb.toString();
    }
}
