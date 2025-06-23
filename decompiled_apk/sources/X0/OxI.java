package X0;

import kotlin.IIX0;
import kotlin.oxxXoxO;
import kotlin.xxIO;

@IIX0(markerClass = {kotlin.oI0IIXIo.class})
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public final class OxI extends xoXoI implements Oxx0IOOO<xxIO>, Oxx0xo<xxIO> {

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final OxI f3187OxxIIOOXO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3188oI0IIXIo;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final OxI oIX0oI() {
            return OxI.f3187OxxIIOOXO;
        }

        public oIX0oI() {
        }
    }

    static {
        kotlin.jvm.internal.IIXOooo iIXOooo = null;
        f3188oI0IIXIo = new oIX0oI(iIXOooo);
        f3187OxxIIOOXO = new OxI(-1, 0, iIXOooo);
    }

    public /* synthetic */ OxI(int i, int i2, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i, i2);
    }

    public boolean II0XooXoX(int i) {
        int compare;
        int compare2;
        compare = Integer.compare(oxoX() ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        if (compare <= 0) {
            compare2 = Integer.compare(i ^ Integer.MIN_VALUE, X0o0xo() ^ Integer.MIN_VALUE);
            if (compare2 <= 0) {
                return true;
            }
        }
        return false;
    }

    @Override // X0.Oxx0xo
    public /* bridge */ /* synthetic */ xxIO II0xO0() {
        return xxIO.oxoX(xxIXOIIO());
    }

    public int OOXIXo() {
        return X0o0xo();
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return II0XooXoX(((xxIO) comparable).OO());
    }

    @Override // X0.xoXoI
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof OxI) {
            if (!isEmpty() || !((OxI) obj).isEmpty()) {
                OxI oxI = (OxI) obj;
                if (oxoX() != oxI.oxoX() || X0o0xo() != oxI.X0o0xo()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0IOOO
    public /* bridge */ /* synthetic */ xxIO getEndInclusive() {
        return xxIO.oxoX(OOXIXo());
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ Comparable getStart() {
        return xxIO.oxoX(oOoXoXO());
    }

    @Override // X0.xoXoI
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (oxoX() * 31) + X0o0xo();
    }

    @Override // X0.xoXoI, X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        int compare;
        compare = Integer.compare(oxoX() ^ Integer.MIN_VALUE, X0o0xo() ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return true;
        }
        return false;
    }

    public int oOoXoXO() {
        return oxoX();
    }

    @Override // X0.xoXoI
    @OXOo.OOXIXo
    public String toString() {
        return ((Object) xxIO.Xo0(oxoX())) + ".." + ((Object) xxIO.Xo0(X0o0xo()));
    }

    public int xxIXOIIO() {
        if (X0o0xo() != -1) {
            return xxIO.oOoXoXO(X0o0xo() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public OxI(int i, int i2) {
        super(i, i2, 1, null);
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.OOXIXo(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @oxxXoxO(version = "1.9")
    public static /* synthetic */ void xoIox() {
    }
}
