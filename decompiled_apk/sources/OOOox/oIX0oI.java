package OOOox;

/* loaded from: classes6.dex */
public final class oIX0oI {

    /* renamed from: I0Io, reason: collision with root package name */
    public static final int f1740I0Io = 60;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    public static final int f1741II0XooXoX = 1000;

    /* renamed from: II0xO0, reason: collision with root package name */
    public static final int f1742II0xO0 = 60;

    /* renamed from: OOXIXo, reason: collision with root package name */
    public static final long f1743OOXIXo = 3600000000000L;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public static final int f1744Oxx0IOOO = 1000000;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public static final int f1745X0o0xo = 86400;

    /* renamed from: XO, reason: collision with root package name */
    public static final int f1746XO = 1000000000;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public static final int f1747oIX0oI = 3600;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    public static final int f1748oOoXoXO = 86400000;

    /* renamed from: oxoX, reason: collision with root package name */
    public static final int f1749oxoX = 24;

    /* renamed from: xoIox, reason: collision with root package name */
    public static final long f1750xoIox = 60000000000L;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    public static final long f1751xxIXOIIO = 86400000000000L;

    public static final int II0xO0(int i, boolean z) {
        if (i != 2) {
            if (i != 4 && i != 6 && i != 9 && i != 11) {
                return 31;
            }
            return 30;
        }
        if (z) {
            return 29;
        }
        return 28;
    }

    public static final boolean oIX0oI(int i) {
        long j = i;
        if ((3 & j) == 0 && (j % 100 != 0 || j % 400 == 0)) {
            return true;
        }
        return false;
    }
}
