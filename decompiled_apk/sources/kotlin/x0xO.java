package kotlin;

@IIX0(markerClass = {oI0IIXIo.class})
@XO0OX.Oxx0IOOO
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public final class x0xO implements Comparable<x0xO> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final byte f29654IXxxXO = 0;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29655Oo = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final byte f29656Oxx0xo = -1;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29657OxxIIOOXO = 8;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f29658oI0IIXIo = 1;

    /* renamed from: XO, reason: collision with root package name */
    public final byte f29659XO;

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
    public /* synthetic */ x0xO(byte b) {
        this.f29659XO = b;
    }

    @xx0o0O.XO
    public static final byte I0Io(byte b, byte b2) {
        return oOoXoXO((byte) (b & b2));
    }

    @OXOo.OOXIXo
    public static String I0X0x0oIo(byte b) {
        return String.valueOf(b & 255);
    }

    @xx0o0O.XO
    public static final int I0oOoX(byte b, short s) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) * xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int II0XooXoX(byte b, long j) {
        int compare;
        compare = Long.compare(XI0oooXX.oOoXoXO(b & 255) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final long IIX0o(byte b, long j) {
        return xoxXI.oIX0oI(XI0oooXX.oOoXoXO(b & 255), j);
    }

    @xx0o0O.XO
    public static final int IIXOooo(byte b, int i) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(b & 255), i);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.9")
    public static final X0.OxI IO(byte b, byte b2) {
        return X0.xxX.o0(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(b2 & 255));
    }

    public static boolean IXxxXO(byte b, Object obj) {
        return (obj instanceof x0xO) && b == ((x0xO) obj).I0oOIX();
    }

    @xx0o0O.XO
    public static final int Io(byte b, byte b2) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) * xxIO.oOoXoXO(b2 & 255));
    }

    @xx0o0O.XO
    public static final long IoOoX(byte b, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(b & 255) + j);
    }

    @xx0o0O.XO
    public static final short O0Xx(byte b) {
        return OX00O0xII.oOoXoXO((short) (b & 255));
    }

    @xx0o0O.XO
    public static final byte O0xOxO(byte b) {
        return oOoXoXO((byte) (b + 1));
    }

    @xx0o0O.XO
    public static final int OI0(byte b, short s) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int OOXIXo(byte b, short s) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(b & 255, s & OX00O0xII.f29066Oxx0xo);
    }

    @xx0o0O.XO
    public static final int Oo(byte b, short s) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    public static int OxI(byte b) {
        return b;
    }

    @xx0o0O.XO
    public static int Oxx0IOOO(byte b, byte b2) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(b & 255, b2 & 255);
    }

    public static final boolean Oxx0xo(byte b, byte b2) {
        return b == b2;
    }

    @xx0o0O.XO
    public static final long OxxIIOOXO(byte b, long j) {
        return IoOoo.oIX0oI(XI0oooXX.oOoXoXO(b & 255), j);
    }

    @xx0o0O.XO
    public static final X0.OxI X00IoxXI(byte b, byte b2) {
        return new X0.OxI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(b2 & 255), null);
    }

    @xx0o0O.XO
    public static final byte X0IIOO(byte b) {
        return oOoXoXO((byte) (~b));
    }

    @xx0o0O.XO
    public static final int XI0IXoo(byte b, byte b2) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) - xxIO.oOoXoXO(b2 & 255));
    }

    @xx0o0O.XO
    public static final long XIxXXX0x0(byte b, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(b & 255) - j);
    }

    @xx0o0O.XO
    public static final int XOxIOxOx(byte b, int i) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(b & 255), i);
    }

    @xx0o0O.XO
    public static final int XX(byte b, int i) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) * i);
    }

    @xx0o0O.XO
    public static final short XX0(byte b) {
        return (short) (b & 255);
    }

    @xx0o0O.XO
    public static final int Xo0(byte b) {
        return xxIO.oOoXoXO(b & 255);
    }

    @xx0o0O.XO
    public static final long XoI0Ixx0(byte b) {
        return XI0oooXX.oOoXoXO(b & 255);
    }

    @xx0o0O.XO
    public static final double XoX(byte b) {
        return b & 255;
    }

    @xx0o0O.XO
    public static final int Xx000oIo(byte b, short s) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) + xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int XxX0x0xxx(byte b, short s) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) - xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final long o0(byte b, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(b & 255) * j);
    }

    @o0
    public static /* synthetic */ void o00() {
    }

    @xx0o0O.XO
    public static final int oI0IIXIo(byte b, byte b2) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(b2 & 255));
    }

    @xx0o0O.XO
    public static final long oO(byte b, long j) {
        return IoOoo.oIX0oI(XI0oooXX.oOoXoXO(b & 255), j);
    }

    @xx0o0O.XO
    public static final int oOXoIIIo(byte b, int i) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) + i);
    }

    @o0
    @xx0o0O.Oxx0IOOO
    public static byte oOoXoXO(byte b) {
        return b;
    }

    @xx0o0O.XO
    public static final byte oX(byte b) {
        return b;
    }

    @xx0o0O.XO
    public static final int oo(byte b, byte b2) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) + xxIO.oOoXoXO(b2 & 255));
    }

    @xx0o0O.XO
    public static final byte oo0xXOI0I(byte b, byte b2) {
        return oOoXoXO((byte) (b | b2));
    }

    @xx0o0O.XO
    public static final byte ooOOo0oXI(byte b) {
        return oOoXoXO((byte) (b - 1));
    }

    @xx0o0O.XO
    public static final int ooXIXxIX(byte b, int i) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(b & 255), i);
    }

    @xx0o0O.XO
    public static final float oxXx0IX(byte b) {
        return b & 255;
    }

    public static final /* synthetic */ x0xO oxoX(byte b) {
        return new x0xO(b);
    }

    @xx0o0O.XO
    public static final byte oxxXoxO(byte b) {
        return b;
    }

    @xx0o0O.XO
    public static final int x0XOIxOo(byte b, byte b2) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(b2 & 255));
    }

    @xx0o0O.XO
    public static final long x0o(byte b, long j) {
        return xoxXI.oIX0oI(XI0oooXX.oOoXoXO(b & 255), j);
    }

    @xx0o0O.XO
    public static final int x0xO0oo(byte b, int i) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(b & 255), i);
    }

    @xx0o0O.XO
    public static final short xI(byte b, short s) {
        return OX00O0xII.oOoXoXO((short) I0oOIX.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo)));
    }

    @xx0o0O.XO
    public static final int xII(byte b, byte b2) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(b2 & 255));
    }

    @xx0o0O.XO
    public static final long xXOx(byte b) {
        return b & 255;
    }

    @xx0o0O.XO
    public static final byte xXxxox0I(byte b, byte b2) {
        return oOoXoXO((byte) I0oOIX.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(b2 & 255)));
    }

    @xx0o0O.XO
    public static final int xo0x(byte b) {
        return b & 255;
    }

    @xx0o0O.XO
    public static final int xoIox(byte b, int i) {
        int compare;
        compare = Integer.compare(xxIO.oOoXoXO(b & 255) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final int xoXoI(byte b, short s) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(b & 255), xxIO.oOoXoXO(s & OX00O0xII.f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final byte xoxXI(byte b, byte b2) {
        return oOoXoXO((byte) (b ^ b2));
    }

    @xx0o0O.XO
    public static final int xxX(byte b, int i) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(b & 255) - i);
    }

    public final /* synthetic */ byte I0oOIX() {
        return this.f29659XO;
    }

    @xx0o0O.XO
    public final int XO(byte b) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(I0oOIX() & 255, b & 255);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(x0xO x0xo) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(I0oOIX() & 255, x0xo.I0oOIX() & 255);
    }

    public boolean equals(Object obj) {
        return IXxxXO(this.f29659XO, obj);
    }

    public int hashCode() {
        return OxI(this.f29659XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return I0X0x0oIo(this.f29659XO);
    }
}
