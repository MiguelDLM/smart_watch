package kotlin;

import com.szabh.smable3.entity.BleWatchFaceId;

@IIX0(markerClass = {oI0IIXIo.class})
@XO0OX.Oxx0IOOO
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public final class xxIO implements Comparable<xxIO> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final int f29673IXxxXO = 0;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29674Oo = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final int f29675Oxx0xo = -1;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29676OxxIIOOXO = 32;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f29677oI0IIXIo = 4;

    /* renamed from: XO, reason: collision with root package name */
    public final int f29678XO;

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
    public /* synthetic */ xxIO(int i) {
        this.f29678XO = i;
    }

    @xx0o0O.XO
    public static final int I0Io(int i, int i2) {
        return oOoXoXO(i & i2);
    }

    @xx0o0O.XO
    public static final long I0X0x0oIo(int i) {
        return i & BleWatchFaceId.WATCHFACE_ID_INVALID;
    }

    @xx0o0O.XO
    public static final long I0oOIX(int i) {
        return XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID);
    }

    @xx0o0O.XO
    public static final long I0oOoX(int i, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID) * j);
    }

    @xx0o0O.XO
    public static final long IIX0o(int i, long j) {
        return xoxXI.oIX0oI(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID), j);
    }

    @xx0o0O.XO
    public static final int IIXOooo(int i, int i2) {
        return O0Xx.oIX0oI(i, i2);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.9")
    public static final X0.OxI IO(int i, int i2) {
        return X0.xxX.o0(i, i2);
    }

    public static boolean IXxxXO(int i, Object obj) {
        return (obj instanceof xxIO) && i == ((xxIO) obj).OO();
    }

    @xx0o0O.XO
    public static final int Io(int i, int i2) {
        return oOoXoXO(i << i2);
    }

    @xx0o0O.XO
    public static final long IoOoX(int i, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID) + j);
    }

    @xx0o0O.XO
    public static final int IoOoo(int i, int i2) {
        return oOoXoXO(i ^ i2);
    }

    @xx0o0O.XO
    public static final int O0Xx(int i) {
        return i;
    }

    @xx0o0O.XO
    public static final int O0xOxO(int i) {
        return oOoXoXO(i + 1);
    }

    @xx0o0O.XO
    public static final int OI0(int i, short s) {
        return I0oOIX.oIX0oI(i, oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int OOXIXo(int i, short s) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, oOoXoXO(s & OX00O0xII.f29066Oxx0xo) ^ Integer.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final int Oo(int i, short s) {
        return O0Xx.oIX0oI(i, oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    public static int OxI(int i) {
        return i;
    }

    @xx0o0O.XO
    public static final int Oxx0IOOO(int i, long j) {
        int compare;
        compare = Long.compare(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    public static final boolean Oxx0xo(int i, int i2) {
        return i == i2;
    }

    @xx0o0O.XO
    public static final long OxxIIOOXO(int i, long j) {
        return IoOoo.oIX0oI(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID), j);
    }

    @xx0o0O.XO
    public static final X0.OxI X00IoxXI(int i, int i2) {
        return new X0.OxI(i, i2, null);
    }

    @xx0o0O.XO
    public static final int X0IIOO(int i) {
        return oOoXoXO(~i);
    }

    @xx0o0O.XO
    public static final int XI0IXoo(int i, byte b) {
        return oOoXoXO(i - oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long XIxXXX0x0(int i, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID) - j);
    }

    @xx0o0O.XO
    public static final int XO(int i, byte b) {
        int compare;
        compare = Integer.compare(i ^ Integer.MIN_VALUE, oOoXoXO(b & 255) ^ Integer.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final int XOxIOxOx(int i, int i2) {
        return O0X.X0o0xo(i, i2);
    }

    @xx0o0O.XO
    public static final int XX(int i, byte b) {
        return oOoXoXO(i * oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final int XX0(int i) {
        return i;
    }

    @OXOo.OOXIXo
    public static String Xo0(int i) {
        return String.valueOf(i & BleWatchFaceId.WATCHFACE_ID_INVALID);
    }

    @xx0o0O.XO
    public static final byte XoI0Ixx0(int i) {
        return x0xO.oOoXoXO((byte) i);
    }

    @xx0o0O.XO
    public static final int XoX(int i, short s) {
        return oOoXoXO(i * oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int Xx000oIo(int i, short s) {
        return oOoXoXO(i + oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int XxX0x0xxx(int i, short s) {
        return oOoXoXO(i - oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int o0(int i, int i2) {
        return oOoXoXO(i >>> i2);
    }

    @o0
    public static /* synthetic */ void o00() {
    }

    @xx0o0O.XO
    public static final int oI0IIXIo(int i, byte b) {
        return O0Xx.oIX0oI(i, oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long oO(int i, long j) {
        return IoOoo.oIX0oI(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID), j);
    }

    @xx0o0O.XO
    public static final int oOXoIIIo(int i, int i2) {
        return oOoXoXO(i + i2);
    }

    @o0
    @xx0o0O.Oxx0IOOO
    public static int oOoXoXO(int i) {
        return i;
    }

    @xx0o0O.XO
    public static final short oX(int i) {
        return (short) i;
    }

    @xx0o0O.XO
    public static final int oo(int i, byte b) {
        return oOoXoXO(i + oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final int oo0xXOI0I(int i, int i2) {
        return oOoXoXO(i | i2);
    }

    @xx0o0O.XO
    public static final int ooOOo0oXI(int i) {
        return oOoXoXO(i - 1);
    }

    @xx0o0O.XO
    public static final int ooXIXxIX(int i, int i2) {
        return I0oOIX.oIX0oI(i, i2);
    }

    @xx0o0O.XO
    public static final byte oxXx0IX(int i) {
        return (byte) i;
    }

    public static final /* synthetic */ xxIO oxoX(int i) {
        return new xxIO(i);
    }

    @xx0o0O.XO
    public static final int oxxXoxO(int i, int i2) {
        return oOoXoXO(i * i2);
    }

    @xx0o0O.XO
    public static final int x0XOIxOo(int i, byte b) {
        return O0Xx.oIX0oI(i, oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long x0o(int i, long j) {
        return xoxXI.oIX0oI(XI0oooXX.oOoXoXO(i & BleWatchFaceId.WATCHFACE_ID_INVALID), j);
    }

    @xx0o0O.XO
    public static final int x0xO0oo(int i, int i2) {
        return O0X.oxoX(i, i2);
    }

    @xx0o0O.XO
    public static final short xI(int i, short s) {
        return OX00O0xII.oOoXoXO((short) I0oOIX.oIX0oI(i, oOoXoXO(s & OX00O0xII.f29066Oxx0xo)));
    }

    @xx0o0O.XO
    public static final int xII(int i, byte b) {
        return I0oOIX.oIX0oI(i, oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final float xXOx(int i) {
        return (float) O0X.XO(i);
    }

    @xx0o0O.XO
    public static final byte xXxxox0I(int i, byte b) {
        return x0xO.oOoXoXO((byte) I0oOIX.oIX0oI(i, oOoXoXO(b & 255)));
    }

    @xx0o0O.XO
    public static final double xo0x(int i) {
        return O0X.XO(i);
    }

    @xx0o0O.XO
    public static int xoIox(int i, int i2) {
        return O0X.I0Io(i, i2);
    }

    @xx0o0O.XO
    public static final int xoXoI(int i, short s) {
        return O0Xx.oIX0oI(i, oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final short xoxXI(int i) {
        return OX00O0xII.oOoXoXO((short) i);
    }

    @xx0o0O.XO
    public static final int xxX(int i, int i2) {
        return oOoXoXO(i - i2);
    }

    @xx0o0O.XO
    public final int II0XooXoX(int i) {
        return O0X.I0Io(OO(), i);
    }

    public final /* synthetic */ int OO() {
        return this.f29678XO;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(xxIO xxio) {
        return O0X.I0Io(OO(), xxio.OO());
    }

    public boolean equals(Object obj) {
        return IXxxXO(this.f29678XO, obj);
    }

    public int hashCode() {
        return OxI(this.f29678XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return Xo0(this.f29678XO);
    }
}
