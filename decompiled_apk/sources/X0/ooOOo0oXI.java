package X0;

import kotlin.collections.Xx000oIo;

/* loaded from: classes6.dex */
public class ooOOo0oXI implements Iterable<Long>, OI0IXox.oIX0oI {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3209Oxx0xo = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final long f3210IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final long f3211Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final long f3212XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final ooOOo0oXI oIX0oI(long j, long j2, long j3) {
            return new ooOOo0oXI(j, j2, j3);
        }

        public oIX0oI() {
        }
    }

    public ooOOo0oXI(long j, long j2, long j3) {
        if (j3 != 0) {
            if (j3 != Long.MIN_VALUE) {
                this.f3212XO = j;
                this.f3211Oo = xx0o0O.x0XOIxOo.oxoX(j, j2, j3);
                this.f3210IXxxXO = j3;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    @Override // java.lang.Iterable
    @OXOo.OOXIXo
    /* renamed from: Oxx0IOOO, reason: merged with bridge method [inline-methods] */
    public Xx000oIo iterator() {
        return new x0XOIxOo(this.f3212XO, this.f3211Oo, this.f3210IXxxXO);
    }

    public final long X0o0xo() {
        return this.f3211Oo;
    }

    public final long XO() {
        return this.f3210IXxxXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof ooOOo0oXI) {
            if (!isEmpty() || !((ooOOo0oXI) obj).isEmpty()) {
                ooOOo0oXI ooooo0oxi = (ooOOo0oXI) obj;
                if (this.f3212XO != ooooo0oxi.f3212XO || this.f3211Oo != ooooo0oxi.f3211Oo || this.f3210IXxxXO != ooooo0oxi.f3210IXxxXO) {
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
        long j = 31;
        long j2 = this.f3212XO;
        long j3 = this.f3211Oo;
        long j4 = j * (((j2 ^ (j2 >>> 32)) * j) + (j3 ^ (j3 >>> 32)));
        long j5 = this.f3210IXxxXO;
        return (int) (j4 + (j5 ^ (j5 >>> 32)));
    }

    public boolean isEmpty() {
        long j = this.f3210IXxxXO;
        long j2 = this.f3212XO;
        long j3 = this.f3211Oo;
        if (j > 0) {
            if (j2 <= j3) {
                return false;
            }
        } else if (j2 >= j3) {
            return false;
        }
        return true;
    }

    public final long oxoX() {
        return this.f3212XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb;
        long j;
        if (this.f3210IXxxXO > 0) {
            sb = new StringBuilder();
            sb.append(this.f3212XO);
            sb.append("..");
            sb.append(this.f3211Oo);
            sb.append(" step ");
            j = this.f3210IXxxXO;
        } else {
            sb = new StringBuilder();
            sb.append(this.f3212XO);
            sb.append(" downTo ");
            sb.append(this.f3211Oo);
            sb.append(" step ");
            j = -this.f3210IXxxXO;
        }
        sb.append(j);
        return sb.toString();
    }
}
