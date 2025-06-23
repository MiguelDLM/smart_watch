package X0;

import com.szabh.smable3.entity.BleWatchFaceId;
import kotlin.IIX0;
import kotlin.XI0oooXX;
import kotlin.oxxXoxO;

@IIX0(markerClass = {kotlin.oI0IIXIo.class})
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public final class XI0IXoo extends O0xOxO implements Oxx0IOOO<XI0oooXX>, Oxx0xo<XI0oooXX> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3196oI0IIXIo = new oIX0oI(null);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final XI0IXoo f3195OxxIIOOXO = new XI0IXoo(-1, 0, null);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final XI0IXoo oIX0oI() {
            return XI0IXoo.f3195OxxIIOOXO;
        }

        public oIX0oI() {
        }
    }

    public /* synthetic */ XI0IXoo(long j, long j2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(j, j2);
    }

    public boolean II0XooXoX(long j) {
        int compare;
        int compare2;
        compare = Long.compare(oxoX() ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Long.compare(j ^ Long.MIN_VALUE, X0o0xo() ^ Long.MIN_VALUE);
            if (compare2 <= 0) {
                return true;
            }
        }
        return false;
    }

    @Override // X0.Oxx0xo
    public /* bridge */ /* synthetic */ XI0oooXX II0xO0() {
        return XI0oooXX.oxoX(xxIXOIIO());
    }

    public long OOXIXo() {
        return X0o0xo();
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return II0XooXoX(((XI0oooXX) comparable).OO());
    }

    @Override // X0.O0xOxO
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof XI0IXoo) {
            if (!isEmpty() || !((XI0IXoo) obj).isEmpty()) {
                XI0IXoo xI0IXoo = (XI0IXoo) obj;
                if (oxoX() != xI0IXoo.oxoX() || X0o0xo() != xI0IXoo.X0o0xo()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0IOOO
    public /* bridge */ /* synthetic */ XI0oooXX getEndInclusive() {
        return XI0oooXX.oxoX(OOXIXo());
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return XI0oooXX.oxoX(oOoXoXO());
    }

    @Override // X0.O0xOxO
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) XI0oooXX.oOoXoXO(X0o0xo() ^ XI0oooXX.oOoXoXO(X0o0xo() >>> 32))) + (((int) XI0oooXX.oOoXoXO(oxoX() ^ XI0oooXX.oOoXoXO(oxoX() >>> 32))) * 31);
    }

    @Override // X0.O0xOxO, X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        int compare;
        compare = Long.compare(oxoX() ^ Long.MIN_VALUE, X0o0xo() ^ Long.MIN_VALUE);
        if (compare > 0) {
            return true;
        }
        return false;
    }

    public long oOoXoXO() {
        return oxoX();
    }

    @Override // X0.O0xOxO
    @OXOo.OOXIXo
    public String toString() {
        return ((Object) XI0oooXX.Xo0(oxoX())) + ".." + ((Object) XI0oooXX.Xo0(X0o0xo()));
    }

    public long xxIXOIIO() {
        if (X0o0xo() != -1) {
            return XI0oooXX.oOoXoXO(X0o0xo() + XI0oooXX.oOoXoXO(1 & BleWatchFaceId.WATCHFACE_ID_INVALID));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public XI0IXoo(long j, long j2) {
        super(j, j2, 1L, null);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.OOXIXo(message = "Can throw an exception when it's impossible to represent the value with ULong type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @oxxXoxO(version = "1.9")
    public static /* synthetic */ void xoIox() {
    }
}
