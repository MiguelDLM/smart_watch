package X0;

import kotlin.IIX0;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public final class oOoXoXO extends xoIox implements Oxx0IOOO<Integer>, Oxx0xo<Integer> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3208oI0IIXIo = new oIX0oI(null);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oOoXoXO f3207OxxIIOOXO = new oOoXoXO(1, 0);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final oOoXoXO oIX0oI() {
            return oOoXoXO.f3207OxxIIOOXO;
        }

        public oIX0oI() {
        }
    }

    public oOoXoXO(int i, int i2) {
        super(i, i2, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return xxIXOIIO(((Number) comparable).intValue());
    }

    @Override // X0.xoIox
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof oOoXoXO) {
            if (!isEmpty() || !((oOoXoXO) obj).isEmpty()) {
                oOoXoXO oooxoxo = (oOoXoXO) obj;
                if (oxoX() != oooxoxo.oxoX() || X0o0xo() != oooxoxo.X0o0xo()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // X0.xoIox
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (oxoX() * 31) + X0o0xo();
    }

    @Override // X0.xoIox, X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        if (oxoX() > X0o0xo()) {
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0IOOO
    @OXOo.OOXIXo
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public Integer getEndInclusive() {
        return Integer.valueOf(X0o0xo());
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public Integer getStart() {
        return Integer.valueOf(oxoX());
    }

    @Override // X0.xoIox
    @OXOo.OOXIXo
    public String toString() {
        return oxoX() + ".." + X0o0xo();
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: xoIox, reason: merged with bridge method [inline-methods] */
    public Integer II0xO0() {
        if (X0o0xo() != Integer.MAX_VALUE) {
            return Integer.valueOf(X0o0xo() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public boolean xxIXOIIO(int i) {
        if (oxoX() <= i && i <= X0o0xo()) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.OOXIXo(message = "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @oxxXoxO(version = "1.9")
    public static /* synthetic */ void OOXIXo() {
    }
}
