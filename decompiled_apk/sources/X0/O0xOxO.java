package X0;

import java.util.Iterator;
import kotlin.IIX0;
import kotlin.XI0oooXX;
import kotlin.oxxXoxO;

@IIX0(markerClass = {kotlin.oI0IIXIo.class})
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public class O0xOxO implements Iterable<XI0oooXX>, OI0IXox.oIX0oI {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3179Oxx0xo = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final long f3180IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final long f3181Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final long f3182XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final O0xOxO oIX0oI(long j, long j2, long j3) {
            return new O0xOxO(j, j2, j3, null);
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ O0xOxO(long j, long j2, long j3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(j, j2, j3);
    }

    public final long X0o0xo() {
        return this.f3181Oo;
    }

    public final long XO() {
        return this.f3180IXxxXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof O0xOxO) {
            if (!isEmpty() || !((O0xOxO) obj).isEmpty()) {
                O0xOxO o0xOxO = (O0xOxO) obj;
                if (this.f3182XO != o0xOxO.f3182XO || this.f3181Oo != o0xOxO.f3181Oo || this.f3180IXxxXO != o0xOxO.f3180IXxxXO) {
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
        long j = this.f3182XO;
        int oOoXoXO2 = ((int) XI0oooXX.oOoXoXO(j ^ XI0oooXX.oOoXoXO(j >>> 32))) * 31;
        long j2 = this.f3181Oo;
        int oOoXoXO3 = (oOoXoXO2 + ((int) XI0oooXX.oOoXoXO(j2 ^ XI0oooXX.oOoXoXO(j2 >>> 32)))) * 31;
        long j3 = this.f3180IXxxXO;
        return ((int) (j3 ^ (j3 >>> 32))) + oOoXoXO3;
    }

    public boolean isEmpty() {
        int compare;
        long j = this.f3180IXxxXO;
        compare = Long.compare(this.f3182XO ^ Long.MIN_VALUE, this.f3181Oo ^ Long.MIN_VALUE);
        if (j > 0) {
            if (compare <= 0) {
                return false;
            }
        } else if (compare >= 0) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    @OXOo.OOXIXo
    public final Iterator<XI0oooXX> iterator() {
        return new X0IIOO(this.f3182XO, this.f3181Oo, this.f3180IXxxXO, null);
    }

    public final long oxoX() {
        return this.f3182XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb;
        long j;
        if (this.f3180IXxxXO > 0) {
            sb = new StringBuilder();
            sb.append((Object) XI0oooXX.Xo0(this.f3182XO));
            sb.append("..");
            sb.append((Object) XI0oooXX.Xo0(this.f3181Oo));
            sb.append(" step ");
            j = this.f3180IXxxXO;
        } else {
            sb = new StringBuilder();
            sb.append((Object) XI0oooXX.Xo0(this.f3182XO));
            sb.append(" downTo ");
            sb.append((Object) XI0oooXX.Xo0(this.f3181Oo));
            sb.append(" step ");
            j = -this.f3180IXxxXO;
        }
        sb.append(j);
        return sb.toString();
    }

    public O0xOxO(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 != Long.MIN_VALUE) {
            this.f3182XO = j;
            this.f3181Oo = xx0o0O.IXxxXO.I0Io(j, j2, j3);
            this.f3180IXxxXO = j3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }
}
