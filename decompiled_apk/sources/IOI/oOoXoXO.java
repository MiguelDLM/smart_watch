package IOI;

import kotlin.time.DurationUnit;
import kotlin.time.oxoX;
import kotlinx.datetime.serializers.DateBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.DateTimeUnitSerializer;
import kotlinx.datetime.serializers.DayBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer;
import kotlinx.datetime.serializers.TimeBasedDateTimeUnitSerializer;

@kotlinx.serialization.IXxxXO(with = DateTimeUnitSerializer.class)
/* loaded from: classes6.dex */
public abstract class oOoXoXO {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: I0Io, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0o0xo f492I0Io;

    /* renamed from: II0XooXoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f493II0XooXoX;

    /* renamed from: II0xO0, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0o0xo f494II0xO0;

    /* renamed from: OOXIXo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oxoX f495OOXIXo;

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final I0Io f496Oxx0IOOO;

    /* renamed from: X0o0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0o0xo f497X0o0xo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0o0xo f498XO;

    /* renamed from: oIX0oI, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0o0xo f499oIX0oI;

    /* renamed from: oOoXoXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oxoX f500oOoXoXO;

    /* renamed from: oxoX, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final X0o0xo f501oxoX;

    /* renamed from: xoIox, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oxoX f502xoIox;

    /* renamed from: xxIXOIIO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final oxoX f503xxIXOIIO;

    @kotlin.jvm.internal.XX({"SMAP\nDateTimeUnit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTimeUnit.kt\nkotlinx/datetime/DateTimeUnit$DayBased\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,247:1\n1#2:248\n*E\n"})
    @kotlinx.serialization.IXxxXO(with = DayBasedDateTimeUnitSerializer.class)
    /* loaded from: classes6.dex */
    public static final class I0Io extends II0xO0 {

        @OXOo.OOXIXo
        public static final oIX0oI Companion = new oIX0oI(null);

        /* renamed from: ooOOo0oXI, reason: collision with root package name */
        public final int f504ooOOo0oXI;

        /* loaded from: classes6.dex */
        public static final class oIX0oI {
            public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final kotlinx.serialization.Oxx0IOOO<I0Io> serializer() {
                return DayBasedDateTimeUnitSerializer.f30512oIX0oI;
            }

            public oIX0oI() {
            }
        }

        public I0Io(int i) {
            super(null);
            this.f504ooOOo0oXI = i;
            if (i > 0) {
                return;
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + i + " days.").toString());
        }

        public final int IXxxXO() {
            return this.f504ooOOo0oXI;
        }

        @Override // IOI.oOoXoXO
        @OXOo.OOXIXo
        /* renamed from: Oxx0xo, reason: merged with bridge method [inline-methods] */
        public I0Io oO(int i) {
            return new I0Io(OOOox.Oxx0IOOO.I0Io(this.f504ooOOo0oXI, i));
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this != obj && (!(obj instanceof I0Io) || this.f504ooOOo0oXI != ((I0Io) obj).f504ooOOo0oXI)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f504ooOOo0oXI ^ 65536;
        }

        @OXOo.OOXIXo
        public String toString() {
            int i = this.f504ooOOo0oXI;
            if (i % 7 == 0) {
                return ooOOo0oXI(i / 7, "WEEK");
            }
            return ooOOo0oXI(i, "DAY");
        }
    }

    @kotlinx.serialization.IXxxXO(with = DateBasedDateTimeUnitSerializer.class)
    /* loaded from: classes6.dex */
    public static abstract class II0xO0 extends oOoXoXO {

        @OXOo.OOXIXo
        public static final oIX0oI Companion = new oIX0oI(null);

        /* loaded from: classes6.dex */
        public static final class oIX0oI {
            public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final kotlinx.serialization.Oxx0IOOO<II0xO0> serializer() {
                return DateBasedDateTimeUnitSerializer.f30504oIX0oI;
            }

            public oIX0oI() {
            }
        }

        public /* synthetic */ II0xO0(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public II0xO0() {
            super(null);
        }

        @kotlin.OOXIXo(message = "Use DateTimeUnit.MonthBased", replaceWith = @kotlin.XX(expression = "DateTimeUnit.MonthBased", imports = {"kotlinx.datetime.DateTimeUnit"}))
        public static /* synthetic */ void Oo() {
        }

        @kotlin.OOXIXo(message = "Use DateTimeUnit.DayBased", replaceWith = @kotlin.XX(expression = "DateTimeUnit.DayBased", imports = {"kotlinx.datetime.DateTimeUnit"}))
        public static /* synthetic */ void x0xO0oo() {
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nDateTimeUnit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTimeUnit.kt\nkotlinx/datetime/DateTimeUnit$TimeBased\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,247:1\n1#2:248\n*E\n"})
    @kotlinx.serialization.IXxxXO(with = TimeBasedDateTimeUnitSerializer.class)
    /* loaded from: classes6.dex */
    public static final class X0o0xo extends oOoXoXO {

        @OXOo.OOXIXo
        public static final oIX0oI Companion = new oIX0oI(null);

        /* renamed from: oO, reason: collision with root package name */
        public final long f505oO;

        /* renamed from: ooOOo0oXI, reason: collision with root package name */
        public final long f506ooOOo0oXI;

        /* renamed from: x0XOIxOo, reason: collision with root package name */
        @OXOo.OOXIXo
        public final String f507x0XOIxOo;

        /* loaded from: classes6.dex */
        public static final class oIX0oI {
            public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final kotlinx.serialization.Oxx0IOOO<X0o0xo> serializer() {
                return TimeBasedDateTimeUnitSerializer.f30534oIX0oI;
            }

            public oIX0oI() {
            }
        }

        public X0o0xo(long j) {
            super(null);
            this.f506ooOOo0oXI = j;
            if (j > 0) {
                if (j % OOOox.oIX0oI.f1743OOXIXo == 0) {
                    this.f507x0XOIxOo = "HOUR";
                    this.f505oO = j / OOOox.oIX0oI.f1743OOXIXo;
                    return;
                }
                if (j % OOOox.oIX0oI.f1750xoIox == 0) {
                    this.f507x0XOIxOo = "MINUTE";
                    this.f505oO = j / OOOox.oIX0oI.f1750xoIox;
                    return;
                }
                long j2 = 1000000000;
                if (j % j2 == 0) {
                    this.f507x0XOIxOo = "SECOND";
                    this.f505oO = j / j2;
                    return;
                }
                long j3 = 1000000;
                if (j % j3 == 0) {
                    this.f507x0XOIxOo = "MILLISECOND";
                    this.f505oO = j / j3;
                    return;
                }
                long j4 = 1000;
                if (j % j4 == 0) {
                    this.f507x0XOIxOo = "MICROSECOND";
                    this.f505oO = j / j4;
                    return;
                } else {
                    this.f507x0XOIxOo = "NANOSECOND";
                    this.f505oO = j;
                    return;
                }
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + j + " ns.").toString());
        }

        @Override // IOI.oOoXoXO
        @OXOo.OOXIXo
        /* renamed from: IXxxXO, reason: merged with bridge method [inline-methods] */
        public X0o0xo oO(int i) {
            return new X0o0xo(OOOox.Oxx0IOOO.oxoX(this.f506ooOOo0oXI, i));
        }

        public final long Oo() {
            return this.f506ooOOo0oXI;
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this != obj && (!(obj instanceof X0o0xo) || this.f506ooOOo0oXI != ((X0o0xo) obj).f506ooOOo0oXI)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            long j = this.f506ooOOo0oXI;
            return ((int) j) ^ ((int) (j >> 32));
        }

        @OXOo.OOXIXo
        public String toString() {
            return x0XOIxOo(this.f505oO, this.f507x0XOIxOo);
        }

        public final long x0xO0oo() {
            oxoX.oIX0oI oix0oi = kotlin.time.oxoX.f29647Oo;
            return kotlin.time.XO.xoIxX(this.f506ooOOo0oXI, DurationUnit.NANOSECONDS);
        }
    }

    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final X0o0xo I0Io() {
            return oOoXoXO.f498XO;
        }

        @OXOo.OOXIXo
        public final X0o0xo II0XooXoX() {
            return oOoXoXO.f499oIX0oI;
        }

        @OXOo.OOXIXo
        public final I0Io II0xO0() {
            return oOoXoXO.f496Oxx0IOOO;
        }

        @OXOo.OOXIXo
        public final I0Io OOXIXo() {
            return oOoXoXO.f493II0XooXoX;
        }

        @OXOo.OOXIXo
        public final oxoX Oxx0IOOO() {
            return oOoXoXO.f503xxIXOIIO;
        }

        @OXOo.OOXIXo
        public final X0o0xo X0o0xo() {
            return oOoXoXO.f492I0Io;
        }

        @OXOo.OOXIXo
        public final X0o0xo XO() {
            return oOoXoXO.f497X0o0xo;
        }

        @OXOo.OOXIXo
        public final oxoX oIX0oI() {
            return oOoXoXO.f500oOoXoXO;
        }

        @OXOo.OOXIXo
        public final oxoX oOoXoXO() {
            return oOoXoXO.f495OOXIXo;
        }

        @OXOo.OOXIXo
        public final X0o0xo oxoX() {
            return oOoXoXO.f494II0xO0;
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<oOoXoXO> serializer() {
            return DateTimeUnitSerializer.f30510oIX0oI;
        }

        @OXOo.OOXIXo
        public final X0o0xo xoIox() {
            return oOoXoXO.f501oxoX;
        }

        @OXOo.OOXIXo
        public final oxoX xxIXOIIO() {
            return oOoXoXO.f502xoIox;
        }

        public oIX0oI() {
        }
    }

    @kotlin.jvm.internal.XX({"SMAP\nDateTimeUnit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTimeUnit.kt\nkotlinx/datetime/DateTimeUnit$MonthBased\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,247:1\n1#2:248\n*E\n"})
    @kotlinx.serialization.IXxxXO(with = MonthBasedDateTimeUnitSerializer.class)
    /* loaded from: classes6.dex */
    public static final class oxoX extends II0xO0 {

        @OXOo.OOXIXo
        public static final oIX0oI Companion = new oIX0oI(null);

        /* renamed from: ooOOo0oXI, reason: collision with root package name */
        public final int f508ooOOo0oXI;

        /* loaded from: classes6.dex */
        public static final class oIX0oI {
            public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
                this();
            }

            @OXOo.OOXIXo
            public final kotlinx.serialization.Oxx0IOOO<oxoX> serializer() {
                return MonthBasedDateTimeUnitSerializer.f30528oIX0oI;
            }

            public oIX0oI() {
            }
        }

        public oxoX(int i) {
            super(null);
            this.f508ooOOo0oXI = i;
            if (i > 0) {
                return;
            }
            throw new IllegalArgumentException(("Unit duration must be positive, but was " + i + " months.").toString());
        }

        public final int IXxxXO() {
            return this.f508ooOOo0oXI;
        }

        @Override // IOI.oOoXoXO
        @OXOo.OOXIXo
        /* renamed from: Oxx0xo, reason: merged with bridge method [inline-methods] */
        public oxoX oO(int i) {
            return new oxoX(OOOox.Oxx0IOOO.I0Io(this.f508ooOOo0oXI, i));
        }

        public boolean equals(@OXOo.oOoXoXO Object obj) {
            if (this != obj && (!(obj instanceof oxoX) || this.f508ooOOo0oXI != ((oxoX) obj).f508ooOOo0oXI)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f508ooOOo0oXI ^ 131072;
        }

        @OXOo.OOXIXo
        public String toString() {
            int i = this.f508ooOOo0oXI;
            if (i % 1200 == 0) {
                return ooOOo0oXI(i / 1200, "CENTURY");
            }
            if (i % 12 == 0) {
                return ooOOo0oXI(i / 12, "YEAR");
            }
            if (i % 3 == 0) {
                return ooOOo0oXI(i / 3, "QUARTER");
            }
            return ooOOo0oXI(i, "MONTH");
        }
    }

    static {
        X0o0xo x0o0xo = new X0o0xo(1L);
        f499oIX0oI = x0o0xo;
        X0o0xo oO2 = x0o0xo.oO(1000);
        f494II0xO0 = oO2;
        X0o0xo oO3 = oO2.oO(1000);
        f492I0Io = oO3;
        X0o0xo oO4 = oO3.oO(1000);
        f501oxoX = oO4;
        X0o0xo oO5 = oO4.oO(60);
        f497X0o0xo = oO5;
        f498XO = oO5.oO(60);
        I0Io i0Io = new I0Io(1);
        f496Oxx0IOOO = i0Io;
        f493II0XooXoX = i0Io.oO(7);
        oxoX oxox = new oxoX(1);
        f503xxIXOIIO = oxox;
        f502xoIox = oxox.oO(3);
        oxoX oO6 = oxox.oO(12);
        f495OOXIXo = oO6;
        f500oOoXoXO = oO6.oO(100);
    }

    public /* synthetic */ oOoXoXO(kotlin.jvm.internal.IIXOooo iIXOooo) {
        this();
    }

    @OXOo.OOXIXo
    public abstract oOoXoXO oO(int i);

    @OXOo.OOXIXo
    public final String ooOOo0oXI(int i, @OXOo.OOXIXo String unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        if (i != 1) {
            return i + '-' + unit;
        }
        return unit;
    }

    @OXOo.OOXIXo
    public final String x0XOIxOo(long j, @OXOo.OOXIXo String unit) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(unit, "unit");
        if (j != 1) {
            return j + '-' + unit;
        }
        return unit;
    }

    public oOoXoXO() {
    }
}
