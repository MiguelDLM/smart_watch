package X0;

import java.util.Iterator;
import kotlin.IIX0;
import kotlin.oxxXoxO;
import kotlin.xxIO;

@IIX0(markerClass = {kotlin.oI0IIXIo.class})
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public class xoXoI implements Iterable<xxIO>, OI0IXox.oIX0oI {

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3225Oxx0xo = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    public final int f3226IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public final int f3227Oo;

    /* renamed from: XO, reason: collision with root package name */
    public final int f3228XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final xoXoI oIX0oI(int i, int i2, int i3) {
            return new xoXoI(i, i2, i3, null);
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ xoXoI(int i, int i2, int i3, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i, i2, i3);
    }

    public final int X0o0xo() {
        return this.f3227Oo;
    }

    public final int XO() {
        return this.f3226IXxxXO;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof xoXoI) {
            if (!isEmpty() || !((xoXoI) obj).isEmpty()) {
                xoXoI xoxoi = (xoXoI) obj;
                if (this.f3228XO != xoxoi.f3228XO || this.f3227Oo != xoxoi.f3227Oo || this.f3226IXxxXO != xoxoi.f3226IXxxXO) {
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
        return (((this.f3228XO * 31) + this.f3227Oo) * 31) + this.f3226IXxxXO;
    }

    public boolean isEmpty() {
        int compare;
        int compare2;
        if (this.f3226IXxxXO > 0) {
            compare2 = Integer.compare(this.f3228XO ^ Integer.MIN_VALUE, this.f3227Oo ^ Integer.MIN_VALUE);
            if (compare2 <= 0) {
                return false;
            }
        } else {
            compare = Integer.compare(this.f3228XO ^ Integer.MIN_VALUE, this.f3227Oo ^ Integer.MIN_VALUE);
            if (compare >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    @OXOo.OOXIXo
    public final Iterator<xxIO> iterator() {
        return new o00(this.f3228XO, this.f3227Oo, this.f3226IXxxXO, null);
    }

    public final int oxoX() {
        return this.f3228XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f3226IXxxXO > 0) {
            sb = new StringBuilder();
            sb.append((Object) xxIO.Xo0(this.f3228XO));
            sb.append("..");
            sb.append((Object) xxIO.Xo0(this.f3227Oo));
            sb.append(" step ");
            i = this.f3226IXxxXO;
        } else {
            sb = new StringBuilder();
            sb.append((Object) xxIO.Xo0(this.f3228XO));
            sb.append(" downTo ");
            sb.append((Object) xxIO.Xo0(this.f3227Oo));
            sb.append(" step ");
            i = -this.f3226IXxxXO;
        }
        sb.append(i);
        return sb.toString();
    }

    public xoXoI(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f3228XO = i;
            this.f3227Oo = xx0o0O.IXxxXO.oxoX(i, i2, i3);
            this.f3226IXxxXO = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }
}
