package kotlinx.coroutines.internal;

/* loaded from: classes6.dex */
public final /* synthetic */ class I0oOoX {
    @OXOo.OOXIXo
    public static final String I0Io(@OXOo.OOXIXo String str, @OXOo.OOXIXo String str2) {
        String oxoX2 = o0.oxoX(str);
        if (oxoX2 != null) {
            return oxoX2;
        }
        return str2;
    }

    public static final long II0xO0(@OXOo.OOXIXo String str, long j, long j2, long j3) {
        String oxoX2 = o0.oxoX(str);
        if (oxoX2 == null) {
            return j;
        }
        Long oOoIIO02 = kotlin.text.o00.oOoIIO0(oxoX2);
        if (oOoIIO02 != null) {
            long longValue = oOoIIO02.longValue();
            if (j2 <= longValue && longValue <= j3) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + oxoX2 + '\'').toString());
    }

    public static /* synthetic */ int X0o0xo(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return o0.II0xO0(str, i, i2, i3);
    }

    public static /* synthetic */ long XO(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return o0.I0Io(str, j, j4, j3);
    }

    public static final int oIX0oI(@OXOo.OOXIXo String str, int i, int i2, int i3) {
        return (int) o0.I0Io(str, i, i2, i3);
    }

    public static final boolean oxoX(@OXOo.OOXIXo String str, boolean z) {
        String oxoX2 = o0.oxoX(str);
        if (oxoX2 != null) {
            return Boolean.parseBoolean(oxoX2);
        }
        return z;
    }
}
