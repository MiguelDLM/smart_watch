package kotlin;

@IIX0(markerClass = {oI0IIXIo.class})
@XO0OX.Oxx0IOOO
@oxxXoxO(version = "1.5")
/* loaded from: classes6.dex */
public final class OX00O0xII implements Comparable<OX00O0xII> {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public static final short f29064IXxxXO = 0;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29065Oo = new oIX0oI(null);

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public static final short f29066Oxx0xo = -1;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public static final int f29067OxxIIOOXO = 16;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public static final int f29068oI0IIXIo = 2;

    /* renamed from: XO, reason: collision with root package name */
    public final short f29069XO;

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
    public /* synthetic */ OX00O0xII(short s) {
        this.f29069XO = s;
    }

    @xx0o0O.XO
    public static final short I0Io(short s, short s2) {
        return oOoXoXO((short) (s & s2));
    }

    @OXOo.OOXIXo
    public static String I0X0x0oIo(short s) {
        return String.valueOf(s & f29066Oxx0xo);
    }

    @xx0o0O.XO
    public static final int I0oOoX(short s, short s2) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) * xxIO.oOoXoXO(s2 & f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int II0XooXoX(short s, int i) {
        int compare;
        compare = Integer.compare(xxIO.oOoXoXO(s & f29066Oxx0xo) ^ Integer.MIN_VALUE, i ^ Integer.MIN_VALUE);
        return compare;
    }

    @xx0o0O.XO
    public static final long IIX0o(short s, long j) {
        return xoxXI.oIX0oI(XI0oooXX.oOoXoXO(s & 65535), j);
    }

    @xx0o0O.XO
    public static final int IIXOooo(short s, int i) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), i);
    }

    @IIX0(markerClass = {IXxxXO.class})
    @xx0o0O.XO
    @oxxXoxO(version = "1.9")
    public static final X0.OxI IO(short s, short s2) {
        return X0.xxX.o0(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(s2 & f29066Oxx0xo));
    }

    public static boolean IXxxXO(short s, Object obj) {
        return (obj instanceof OX00O0xII) && s == ((OX00O0xII) obj).I0oOIX();
    }

    @xx0o0O.XO
    public static final int Io(short s, byte b) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) * xxIO.oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long IoOoX(short s, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(s & 65535) + j);
    }

    @xx0o0O.XO
    public static final short O0Xx(short s) {
        return s;
    }

    @xx0o0O.XO
    public static final short O0xOxO(short s) {
        return oOoXoXO((short) (s + 1));
    }

    @xx0o0O.XO
    public static final int OI0(short s, short s2) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(s2 & f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static int OOXIXo(short s, short s2) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(s & f29066Oxx0xo, s2 & f29066Oxx0xo);
    }

    @xx0o0O.XO
    public static final int Oo(short s, short s2) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(s2 & f29066Oxx0xo));
    }

    public static int OxI(short s) {
        return s;
    }

    @xx0o0O.XO
    public static final int Oxx0IOOO(short s, long j) {
        int compare;
        compare = Long.compare(XI0oooXX.oOoXoXO(s & 65535) ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        return compare;
    }

    public static final boolean Oxx0xo(short s, short s2) {
        return s == s2;
    }

    @xx0o0O.XO
    public static final long OxxIIOOXO(short s, long j) {
        return IoOoo.oIX0oI(XI0oooXX.oOoXoXO(s & 65535), j);
    }

    @xx0o0O.XO
    public static final X0.OxI X00IoxXI(short s, short s2) {
        return new X0.OxI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(s2 & f29066Oxx0xo), null);
    }

    @xx0o0O.XO
    public static final short X0IIOO(short s) {
        return oOoXoXO((short) (~s));
    }

    @xx0o0O.XO
    public static final int XI0IXoo(short s, byte b) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) - xxIO.oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long XIxXXX0x0(short s, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(s & 65535) - j);
    }

    @xx0o0O.XO
    public static final int XO(short s, byte b) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(s & f29066Oxx0xo, b & 255);
    }

    @xx0o0O.XO
    public static final int XOxIOxOx(short s, int i) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), i);
    }

    @xx0o0O.XO
    public static final int XX(short s, int i) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) * i);
    }

    @xx0o0O.XO
    public static final short XX0(short s) {
        return s;
    }

    @xx0o0O.XO
    public static final int Xo0(short s) {
        return xxIO.oOoXoXO(s & f29066Oxx0xo);
    }

    @xx0o0O.XO
    public static final long XoI0Ixx0(short s) {
        return XI0oooXX.oOoXoXO(s & 65535);
    }

    @xx0o0O.XO
    public static final double XoX(short s) {
        return s & f29066Oxx0xo;
    }

    @xx0o0O.XO
    public static final int Xx000oIo(short s, short s2) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) + xxIO.oOoXoXO(s2 & f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final int XxX0x0xxx(short s, short s2) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) - xxIO.oOoXoXO(s2 & f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final long o0(short s, long j) {
        return XI0oooXX.oOoXoXO(XI0oooXX.oOoXoXO(s & 65535) * j);
    }

    @o0
    public static /* synthetic */ void o00() {
    }

    @xx0o0O.XO
    public static final int oI0IIXIo(short s, byte b) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long oO(short s, long j) {
        return IoOoo.oIX0oI(XI0oooXX.oOoXoXO(s & 65535), j);
    }

    @xx0o0O.XO
    public static final int oOXoIIIo(short s, int i) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) + i);
    }

    @o0
    @xx0o0O.Oxx0IOOO
    public static short oOoXoXO(short s) {
        return s;
    }

    @xx0o0O.XO
    public static final byte oX(short s) {
        return x0xO.oOoXoXO((byte) s);
    }

    @xx0o0O.XO
    public static final int oo(short s, byte b) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) + xxIO.oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final short oo0xXOI0I(short s, short s2) {
        return oOoXoXO((short) (s | s2));
    }

    @xx0o0O.XO
    public static final short ooOOo0oXI(short s) {
        return oOoXoXO((short) (s - 1));
    }

    @xx0o0O.XO
    public static final int ooXIXxIX(short s, int i) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), i);
    }

    @xx0o0O.XO
    public static final float oxXx0IX(short s) {
        return s & f29066Oxx0xo;
    }

    public static final /* synthetic */ OX00O0xII oxoX(short s) {
        return new OX00O0xII(s);
    }

    @xx0o0O.XO
    public static final byte oxxXoxO(short s) {
        return (byte) s;
    }

    @xx0o0O.XO
    public static final int x0XOIxOo(short s, byte b) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long x0o(short s, long j) {
        return xoxXI.oIX0oI(XI0oooXX.oOoXoXO(s & 65535), j);
    }

    @xx0o0O.XO
    public static final int x0xO0oo(short s, int i) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), i);
    }

    @xx0o0O.XO
    public static final short xI(short s, short s2) {
        return oOoXoXO((short) I0oOIX.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(s2 & f29066Oxx0xo)));
    }

    @xx0o0O.XO
    public static final int xII(short s, byte b) {
        return I0oOIX.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(b & 255));
    }

    @xx0o0O.XO
    public static final long xXOx(short s) {
        return s & 65535;
    }

    @xx0o0O.XO
    public static final byte xXxxox0I(short s, byte b) {
        return x0xO.oOoXoXO((byte) I0oOIX.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(b & 255)));
    }

    @xx0o0O.XO
    public static final int xo0x(short s) {
        return s & f29066Oxx0xo;
    }

    @xx0o0O.XO
    public static final int xoXoI(short s, short s2) {
        return O0Xx.oIX0oI(xxIO.oOoXoXO(s & f29066Oxx0xo), xxIO.oOoXoXO(s2 & f29066Oxx0xo));
    }

    @xx0o0O.XO
    public static final short xoxXI(short s, short s2) {
        return oOoXoXO((short) (s ^ s2));
    }

    @xx0o0O.XO
    public static final int xxX(short s, int i) {
        return xxIO.oOoXoXO(xxIO.oOoXoXO(s & f29066Oxx0xo) - i);
    }

    public final /* synthetic */ short I0oOIX() {
        return this.f29069XO;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(OX00O0xII oX00O0xII) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(I0oOIX() & f29066Oxx0xo, oX00O0xII.I0oOIX() & f29066Oxx0xo);
    }

    public boolean equals(Object obj) {
        return IXxxXO(this.f29069XO, obj);
    }

    public int hashCode() {
        return OxI(this.f29069XO);
    }

    @OXOo.OOXIXo
    public String toString() {
        return I0X0x0oIo(this.f29069XO);
    }

    @xx0o0O.XO
    public final int xoIox(short s) {
        return kotlin.jvm.internal.IIX0o.oI0IIXIo(I0oOIX() & f29066Oxx0xo, s & f29066Oxx0xo);
    }
}
