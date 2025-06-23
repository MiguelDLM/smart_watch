package kotlin.time;

import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.IIX0;
import kotlin.jvm.internal.IIX0o;
import kotlin.oxxXoxO;
import kotlin.time.I0Io;

@IIX0(markerClass = {xoIox.class})
@oxxXoxO(version = "1.9")
/* loaded from: classes6.dex */
public interface IXxxXO {

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oIX0oI f29629oIX0oI = oIX0oI.f29632oIX0oI;

    @IIX0(markerClass = {xoIox.class})
    @oxxXoxO(version = "1.9")
    /* loaded from: classes6.dex */
    public interface I0Io extends IXxxXO {
        @Override // kotlin.time.IXxxXO
        @OXOo.OOXIXo
        kotlin.time.I0Io oIX0oI();
    }

    /* loaded from: classes6.dex */
    public static final class II0xO0 implements I0Io {

        /* renamed from: II0xO0, reason: collision with root package name */
        @OXOo.OOXIXo
        public static final II0xO0 f29630II0xO0 = new II0xO0();

        @IIX0(markerClass = {xoIox.class})
        @XO0OX.Oxx0IOOO
        @oxxXoxO(version = "1.9")
        /* loaded from: classes6.dex */
        public static final class oIX0oI implements kotlin.time.I0Io {

            /* renamed from: XO, reason: collision with root package name */
            public final long f29631XO;

            public /* synthetic */ oIX0oI(long j) {
                this.f29631XO = j;
            }

            public static final int II0XooXoX(long j, long j2) {
                return oxoX.oOoXoXO(IXxxXO(j, j2), oxoX.f29647Oo.XX());
            }

            public static final long IXxxXO(long j, long j2) {
                return x0XOIxOo.f29652II0xO0.I0Io(j, j2);
            }

            public static long OOXIXo(long j) {
                return j;
            }

            public static int Oo(long j) {
                return androidx.collection.oIX0oI.oIX0oI(j);
            }

            public static final /* synthetic */ oIX0oI Oxx0IOOO(long j) {
                return new oIX0oI(j);
            }

            public static long OxxIIOOXO(long j, @OXOo.OOXIXo kotlin.time.I0Io other) {
                IIX0o.x0xO0oo(other, "other");
                if (other instanceof oIX0oI) {
                    return IXxxXO(j, ((oIX0oI) other).OxI());
                }
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) o00(j)) + " and " + other);
            }

            public static String o00(long j) {
                return "ValueTimeMark(reading=" + j + HexStringBuilder.COMMENT_END_CHAR;
            }

            public static long oI0IIXIo(long j, long j2) {
                return x0XOIxOo.f29652II0xO0.II0xO0(j, oxoX.OOXIxO0(j2));
            }

            public static boolean oO(long j) {
                return oxoX.I0X0x0oIo(oOoXoXO(j));
            }

            public static long oOoXoXO(long j) {
                return x0XOIxOo.f29652II0xO0.oxoX(j);
            }

            public static boolean ooOOo0oXI(long j, Object obj) {
                return (obj instanceof oIX0oI) && j == ((oIX0oI) obj).OxI();
            }

            public static final boolean x0XOIxOo(long j, long j2) {
                return j == j2;
            }

            public static boolean x0xO0oo(long j) {
                return !oxoX.I0X0x0oIo(oOoXoXO(j));
            }

            public static int xoIox(long j, @OXOo.OOXIXo kotlin.time.I0Io other) {
                IIX0o.x0xO0oo(other, "other");
                return Oxx0IOOO(j).compareTo(other);
            }

            public static long xoXoI(long j, long j2) {
                return x0XOIxOo.f29652II0xO0.II0xO0(j, j2);
            }

            @Override // kotlin.time.x0xO0oo
            public long I0Io() {
                return oOoXoXO(this.f29631XO);
            }

            @Override // kotlin.time.I0Io, kotlin.time.x0xO0oo
            public /* bridge */ /* synthetic */ kotlin.time.I0Io II0xO0(long j) {
                return Oxx0IOOO(Oxx0xo(j));
            }

            public long IIXOooo(long j) {
                return xoXoI(this.f29631XO, j);
            }

            public final /* synthetic */ long OxI() {
                return this.f29631XO;
            }

            public long Oxx0xo(long j) {
                return oI0IIXIo(this.f29631XO, j);
            }

            @Override // kotlin.time.I0Io
            public long X0o0xo(@OXOo.OOXIXo kotlin.time.I0Io other) {
                IIX0o.x0xO0oo(other, "other");
                return OxxIIOOXO(this.f29631XO, other);
            }

            @Override // kotlin.time.x0xO0oo
            public boolean XO() {
                return x0xO0oo(this.f29631XO);
            }

            @Override // kotlin.time.I0Io
            public boolean equals(Object obj) {
                return ooOOo0oXI(this.f29631XO, obj);
            }

            @Override // kotlin.time.I0Io
            public int hashCode() {
                return Oo(this.f29631XO);
            }

            @Override // kotlin.time.I0Io, kotlin.time.x0xO0oo
            public /* bridge */ /* synthetic */ kotlin.time.I0Io oIX0oI(long j) {
                return Oxx0IOOO(IIXOooo(j));
            }

            @Override // kotlin.time.x0xO0oo
            public boolean oxoX() {
                return oO(this.f29631XO);
            }

            public String toString() {
                return o00(this.f29631XO);
            }

            @Override // java.lang.Comparable
            /* renamed from: xxIXOIIO, reason: merged with bridge method [inline-methods] */
            public int compareTo(@OXOo.OOXIXo kotlin.time.I0Io i0Io) {
                return I0Io.oIX0oI.oIX0oI(this, i0Io);
            }

            @Override // kotlin.time.x0xO0oo
            public /* bridge */ /* synthetic */ x0xO0oo II0xO0(long j) {
                return Oxx0IOOO(Oxx0xo(j));
            }

            @Override // kotlin.time.x0xO0oo
            public /* bridge */ /* synthetic */ x0xO0oo oIX0oI(long j) {
                return Oxx0IOOO(IIXOooo(j));
            }
        }

        public long II0xO0() {
            return x0XOIxOo.f29652II0xO0.X0o0xo();
        }

        @Override // kotlin.time.IXxxXO.I0Io, kotlin.time.IXxxXO
        public /* bridge */ /* synthetic */ kotlin.time.I0Io oIX0oI() {
            return oIX0oI.Oxx0IOOO(II0xO0());
        }

        @OXOo.OOXIXo
        public String toString() {
            return x0XOIxOo.f29652II0xO0.toString();
        }

        @Override // kotlin.time.IXxxXO
        public /* bridge */ /* synthetic */ x0xO0oo oIX0oI() {
            return oIX0oI.Oxx0IOOO(II0xO0());
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public static final /* synthetic */ oIX0oI f29632oIX0oI = new oIX0oI();
    }

    @OXOo.OOXIXo
    x0xO0oo oIX0oI();
}
