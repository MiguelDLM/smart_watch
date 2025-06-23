package kotlin;

import com.szabh.smable3.entity.BleWatchFaceId;

@IIX0(markerClass = {oI0IIXIo.class})
@XO0OX.Oxx0IOOO
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public final class XI0oooXX implements Comparable<XI0oooXX> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final long f29072IXxxXO = 0;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29073Oo = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final long f29074Oxx0xo = -1;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29075OxxIIOOXO = 64;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f29076oI0IIXIo = 8;

    /* renamed from: XO, reason: collision with root package name */
    public final long f29077XO;

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public oIX0oI() {
        }
    }

    @o0
    @xx0o0O.Oxx0IOOO
    public /* synthetic */ XI0oooXX(long j) {
        this.f29077XO = j;
    }

    @xx0o0O.XO
    public static final long I0Io(long j, long j2) {
        return oOoXoXO(j & j2);
    }

    @xx0o0O.XO
    public static final long I0X0x0oIo(long j) {
        return j;
    }

    @xx0o0O.XO
    public static final long I0oOIX(long j) {
        return j;
    }

    @xx0o0O.XO
    public static final long I0oOoX(long j, long j2) {
        return oOoXoXO(j * j2);
    }

    @xx0o0O.XO
    public static int II0XooXoX(long j, long j2) {
        return O0X.Oxx0IOOO(j, j2);
    }

    @xx0o0O.XO
    public static final long IIX0o(long j, long j2) {
        return xoxXI.oIX0oI(j, j2);
    }

    @xx0o0O.XO
    public static final long IIXOooo(long j, int i) {
        return IoOoo.oIX0oI(j, oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.9")
    public static final X0.XI0IXoo IO(long j, long j2) {
        return X0.xxX.I0oOoX(j, j2);
    }

    public static boolean IXxxXO(long j, Object obj) {
        return (obj instanceof XI0oooXX) && j == ((XI0oooXX) obj).OO();
    }

    @xx0o0O.XO
    public static final long Io(long j, int i) {
        return oOoXoXO(j << i);
    }

    @xx0o0O.XO
    public static final long IoOoX(long j, long j2) {
        return oOoXoXO(j + j2);
    }

    @xx0o0O.XO
    public static final long IoOoo(long j, long j2) {
        return oOoXoXO(j ^ j2);
    }

    @xx0o0O.XO
    public static final int O0Xx(long j) {
        return xxIO.oOoXoXO((int) j);
    }

    @xx0o0O.XO
    public static final long O0xOxO(long j) {
        return oOoXoXO(j + 1);
    }

    @xx0o0O.XO
    public static final long OI0(long j, short s) {
        return xoxXI.oIX0oI(j, oOoXoXO(s & 65535));
    }

    @xx0o0O.XO
    public static final int OOXIXo(long j, short s) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, oOoXoXO(s & 65535) ^ Long.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final long Oo(long j, short s) {
        return IoOoo.oIX0oI(j, oOoXoXO(s & 65535));
    }

    public static int OxI(long j) {
        return androidx.collection.oIX0oI.oIX0oI(j);
    }

    public static final boolean Oxx0xo(long j, long j2) {
        return j == j2;
    }

    @xx0o0O.XO
    public static final long OxxIIOOXO(long j, long j2) {
        return IoOoo.oIX0oI(j, j2);
    }

    @xx0o0O.XO
    public static final X0.XI0IXoo X00IoxXI(long j, long j2) {
        return new X0.XI0IXoo(j, j2, null);
    }

    @xx0o0O.XO
    public static final long X0IIOO(long j) {
        return oOoXoXO(~j);
    }

    @xx0o0O.XO
    public static final long XI0IXoo(long j, byte b) {
        return oOoXoXO(j - oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long XIxXXX0x0(long j, long j2) {
        return oOoXoXO(j - j2);
    }

    @xx0o0O.XO
    public static final int XO(long j, byte b) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, oOoXoXO(b & 255) ^ Long.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final long XOxIOxOx(long j, int i) {
        return xoxXI.oIX0oI(j, oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    @xx0o0O.XO
    public static final long XX(long j, byte b) {
        return oOoXoXO(j * oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final int XX0(long j) {
        return (int) j;
    }

    @OXOo.OOXIXo
    public static String Xo0(long j) {
        return O0X.OOXIXo(j);
    }

    @xx0o0O.XO
    public static final byte XoI0Ixx0(long j) {
        return x0xO.oOoXoXO((byte) j);
    }

    @xx0o0O.XO
    public static final long XoX(long j, short s) {
        return oOoXoXO(j * oOoXoXO(s & 65535));
    }

    @xx0o0O.XO
    public static final long Xx000oIo(long j, short s) {
        return oOoXoXO(j + oOoXoXO(s & 65535));
    }

    @xx0o0O.XO
    public static final long XxX0x0xxx(long j, short s) {
        return oOoXoXO(j - oOoXoXO(s & 65535));
    }

    @xx0o0O.XO
    public static final long o0(long j, int i) {
        return oOoXoXO(j >>> i);
    }

    @o0
    public static /* synthetic */ void o00() {
    }

    @xx0o0O.XO
    public static final long oI0IIXIo(long j, byte b) {
        return IoOoo.oIX0oI(j, oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long oO(long j, long j2) {
        return O0X.II0XooXoX(j, j2);
    }

    @xx0o0O.XO
    public static final long oOXoIIIo(long j, int i) {
        return oOoXoXO(j + oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    @o0
    @xx0o0O.Oxx0IOOO
    public static long oOoXoXO(long j) {
        return j;
    }

    @xx0o0O.XO
    public static final short oX(long j) {
        return (short) j;
    }

    @xx0o0O.XO
    public static final long oo(long j, byte b) {
        return oOoXoXO(j + oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long oo0xXOI0I(long j, long j2) {
        return oOoXoXO(j | j2);
    }

    @xx0o0O.XO
    public static final long ooOOo0oXI(long j) {
        return oOoXoXO(j - 1);
    }

    @xx0o0O.XO
    public static final int ooXIXxIX(long j, int i) {
        return xxIO.oOoXoXO((int) xoxXI.oIX0oI(j, oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID)));
    }

    @xx0o0O.XO
    public static final byte oxXx0IX(long j) {
        return (byte) j;
    }

    public static final /* synthetic */ XI0oooXX oxoX(long j) {
        return new XI0oooXX(j);
    }

    @xx0o0O.XO
    public static final long oxxXoxO(long j, int i) {
        return oOoXoXO(j * oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    @xx0o0O.XO
    public static final long x0XOIxOo(long j, byte b) {
        return IoOoo.oIX0oI(j, oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long x0o(long j, long j2) {
        return O0X.xxIXOIIO(j, j2);
    }

    @xx0o0O.XO
    public static final long x0xO0oo(long j, int i) {
        return IoOoo.oIX0oI(j, oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    @xx0o0O.XO
    public static final short xI(long j, short s) {
        return OX00O0xII.oOoXoXO((short) xoxXI.oIX0oI(j, oOoXoXO(s & 65535)));
    }

    @xx0o0O.XO
    public static final long xII(long j, byte b) {
        return xoxXI.oIX0oI(j, oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final float xXOx(long j) {
        return (float) O0X.xoIox(j);
    }

    @xx0o0O.XO
    public static final byte xXxxox0I(long j, byte b) {
        return x0xO.oOoXoXO((byte) xoxXI.oIX0oI(j, oOoXoXO(b & 255)));
    }

    @xx0o0O.XO
    public static final double xo0x(long j) {
        return O0X.xoIox(j);
    }

    @xx0o0O.XO
    public static final int xoIox(long j, int i) {
        int compare;
        compare = Long.compare(j ^ Long.MIN_VALUE, oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID) ^ Long.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final long xoXoI(long j, short s) {
        return IoOoo.oIX0oI(j, oOoXoXO(s & 65535));
    }

    @xx0o0O.XO
    public static final short xoxXI(long j) {
        return OX00O0xII.oOoXoXO((short) j);
    }

    @xx0o0O.XO
    public static final long xxX(long j, int i) {
        return oOoXoXO(j - oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID));
    }

    public final /* synthetic */ long OO() {
        return this.f29077XO;
    }

    @xx0o0O.XO
    public final int Oxx0IOOO(long j) {
        return O0X.Oxx0IOOO(OO(), j);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(XI0oooXX xI0oooXX) {
        return O0X.Oxx0IOOO(OO(), xI0oooXX.OO());
    }

    public boolean equals(Object obj) {
        return IXxxXO(this.f29077XO, obj);
    }

    public int hashCode() {
        return OxI(this.f29077XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return Xo0(this.f29077XO);
    }
}
