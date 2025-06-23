package X0;

import kotlin.IIX0;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public final class oO extends ooOOo0oXI implements Oxx0IOOO<Long>, Oxx0xo<Long> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3206oI0IIXIo = new oIX0oI(null);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oO f3205OxxIIOOXO = new oO(1, 0);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final oO oIX0oI() {
            return oO.f3205OxxIIOOXO;
        }

        public oIX0oI() {
        }
    }

    public oO(long j, long j2) {
        super(j, j2, 1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return xxIXOIIO(((Number) comparable).longValue());
    }

    @Override // X0.ooOOo0oXI
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof oO) {
            if (!isEmpty() || !((oO) obj).isEmpty()) {
                oO oOVar = (oO) obj;
                if (oxoX() != oOVar.oxoX() || X0o0xo() != oOVar.X0o0xo()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // X0.ooOOo0oXI
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (oxoX() ^ (oxoX() >>> 32))) + (X0o0xo() ^ (X0o0xo() >>> 32)));
    }

    @Override // X0.ooOOo0oXI, X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        if (oxoX() > X0o0xo()) {
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0IOOO
    @OXOo.OOXIXo
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public Long getEndInclusive() {
        return Long.valueOf(X0o0xo());
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public Long getStart() {
        return Long.valueOf(oxoX());
    }

    @Override // X0.ooOOo0oXI
    @OXOo.OOXIXo
    public String toString() {
        return oxoX() + ".." + X0o0xo();
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: xoIox, reason: merged with bridge method [inline-methods] */
    public Long II0xO0() {
        if (X0o0xo() != Long.MAX_VALUE) {
            return Long.valueOf(X0o0xo() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public boolean xxIXOIIO(long j) {
        if (oxoX() <= j && j <= X0o0xo()) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.OOXIXo(message = "Can throw an exception when it's impossible to represent the value with Long type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @oxxXoxO(version = "1.9")
    public static /* synthetic */ void OOXIXo() {
    }
}
