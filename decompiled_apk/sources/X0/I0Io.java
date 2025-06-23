package X0;

import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;

/* loaded from: classes6.dex */
public final class I0Io extends X0.oIX0oI implements Oxx0IOOO<Character>, Oxx0xo<Character> {

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f3170oI0IIXIo = new oIX0oI(null);

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f3169OxxIIOOXO = new I0Io(1, 0);

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final I0Io oIX0oI() {
            return I0Io.f3169OxxIIOOXO;
        }

        public oIX0oI() {
        }
    }

    public I0Io(char c, char c2) {
        super(c, c2, 1);
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return xxIXOIIO(((Character) comparable).charValue());
    }

    @Override // X0.oIX0oI
    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (obj instanceof I0Io) {
            if (!isEmpty() || !((I0Io) obj).isEmpty()) {
                I0Io i0Io = (I0Io) obj;
                if (oxoX() != i0Io.oxoX() || X0o0xo() != i0Io.X0o0xo()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // X0.oIX0oI
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (oxoX() * 31) + X0o0xo();
    }

    @Override // X0.oIX0oI, X0.Oxx0IOOO, X0.Oxx0xo
    public boolean isEmpty() {
        if (IIX0o.oI0IIXIo(oxoX(), X0o0xo()) > 0) {
            return true;
        }
        return false;
    }

    @Override // X0.Oxx0IOOO
    @OXOo.OOXIXo
    /* renamed from: oOoXoXO, reason: merged with bridge method [inline-methods] */
    public Character getEndInclusive() {
        return Character.valueOf(X0o0xo());
    }

    @Override // X0.Oxx0IOOO, X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: ooOOo0oXI, reason: merged with bridge method [inline-methods] */
    public Character getStart() {
        return Character.valueOf(oxoX());
    }

    @Override // X0.oIX0oI
    @OXOo.OOXIXo
    public String toString() {
        return oxoX() + ".." + X0o0xo();
    }

    @Override // X0.Oxx0xo
    @OXOo.OOXIXo
    /* renamed from: xoIox, reason: merged with bridge method [inline-methods] */
    public Character II0xO0() {
        if (X0o0xo() != 65535) {
            return Character.valueOf((char) (X0o0xo() + 1));
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.");
    }

    public boolean xxIXOIIO(char c) {
        if (IIX0o.oI0IIXIo(oxoX(), c) <= 0 && IIX0o.oI0IIXIo(c, X0o0xo()) <= 0) {
            return true;
        }
        return false;
    }

    @IIX0(markerClass = {kotlin.IXxxXO.class})
    @kotlin.OOXIXo(message = "Can throw an exception when it's impossible to represent the value with Char type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @oxxXoxO(version = "1.9")
    public static /* synthetic */ void OOXIXo() {
    }
}
