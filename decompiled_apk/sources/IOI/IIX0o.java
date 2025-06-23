package IOI;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import kotlin.DeprecationLevel;
import kotlin.time.DurationUnit;
import kotlin.time.oxoX;
import kotlinx.datetime.DateTimeFormatException;

@kotlin.jvm.internal.XX({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlinx/datetime/Instant\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,190:1\n731#2,2:191\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlinx/datetime/Instant\n*L\n37#1:191,2\n*E\n"})
@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.X0o0xo.class)
/* loaded from: classes6.dex */
public final class IIX0o implements Comparable<IIX0o> {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IIX0o f474IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IIX0o f475Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IIX0o f476Oxx0xo;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final IIX0o f477oI0IIXIo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final Instant f478XO;

    @kotlin.jvm.internal.XX({"SMAP\nInstant.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Instant.kt\nkotlinx/datetime/Instant$Companion\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,190:1\n163#2,6:191\n*S KotlinDebug\n*F\n+ 1 Instant.kt\nkotlinx/datetime/Instant$Companion\n*L\n80#1:191,6\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        public static /* synthetic */ IIX0o X0o0xo(oIX0oI oix0oi, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            return oix0oi.oxoX(j, j2);
        }

        @OXOo.OOXIXo
        public final IIX0o I0Io(long j, int i) {
            return oxoX(j, i);
        }

        @OXOo.OOXIXo
        public final IIX0o II0XooXoX() {
            return IIX0o.f477oI0IIXIo;
        }

        @OXOo.OOXIXo
        public final IIX0o II0xO0(long j) {
            Instant ofEpochMilli;
            ofEpochMilli = Instant.ofEpochMilli(j);
            kotlin.jvm.internal.IIX0o.oO(ofEpochMilli, "ofEpochMilli(...)");
            return new IIX0o(ofEpochMilli);
        }

        @OXOo.OOXIXo
        public final IIX0o OOXIXo(@OXOo.OOXIXo String isoString) {
            OffsetDateTime parse;
            Instant instant;
            kotlin.jvm.internal.IIX0o.x0xO0oo(isoString, "isoString");
            try {
                parse = OffsetDateTime.parse(oIX0oI(isoString));
                instant = parse.toInstant();
                kotlin.jvm.internal.IIX0o.oO(instant, "toInstant(...)");
                return new IIX0o(instant);
            } catch (DateTimeParseException e) {
                throw new DateTimeFormatException(e);
            }
        }

        @OXOo.OOXIXo
        public final IIX0o Oxx0IOOO() {
            return IIX0o.f475Oo;
        }

        @OXOo.OOXIXo
        public final IIX0o XO() {
            return IIX0o.f474IXxxXO;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x002f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String oIX0oI(java.lang.String r13) {
            /*
                r12 = this;
                r4 = 2
                r5 = 0
                r1 = 84
                r2 = 0
                r3 = 1
                r0 = r13
                int r0 = kotlin.text.StringsKt__StringsKt.XxIIOXIXx(r0, r1, r2, r3, r4, r5)
                r1 = -1
                if (r0 != r1) goto Lf
                return r13
            Lf:
                int r2 = r13.length()
                int r2 = r2 + r1
                if (r2 < 0) goto L2c
            L16:
                int r3 = r2 + (-1)
                char r4 = r13.charAt(r2)
                r5 = 43
                if (r4 == r5) goto L2a
                r5 = 45
                if (r4 != r5) goto L25
                goto L2a
            L25:
                if (r3 >= 0) goto L28
                goto L2c
            L28:
                r2 = r3
                goto L16
            L2a:
                r8 = r2
                goto L2d
            L2c:
                r8 = -1
            L2d:
                if (r8 >= r0) goto L30
                return r13
            L30:
                r10 = 4
                r11 = 0
                r7 = 58
                r9 = 0
                r6 = r13
                int r0 = kotlin.text.StringsKt__StringsKt.XxIIOXIXx(r6, r7, r8, r9, r10, r11)
                if (r0 == r1) goto L3d
                goto L4e
            L3d:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r0.append(r13)
                java.lang.String r13 = ":00"
                r0.append(r13)
                java.lang.String r13 = r0.toString()
            L4e:
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: IOI.IIX0o.oIX0oI.oIX0oI(java.lang.String):java.lang.String");
        }

        @OXOo.OOXIXo
        public final IIX0o oxoX(long j, long j2) {
            IIX0o xxIXOIIO2;
            Instant ofEpochSecond;
            try {
                ofEpochSecond = Instant.ofEpochSecond(j, j2);
                kotlin.jvm.internal.IIX0o.oO(ofEpochSecond, "ofEpochSecond(...)");
                return new IIX0o(ofEpochSecond);
            } catch (Exception e) {
                if (!(e instanceof ArithmeticException) && !X0IIOO.oIX0oI(e)) {
                    throw e;
                }
                if (j > 0) {
                    xxIXOIIO2 = II0XooXoX();
                } else {
                    xxIXOIIO2 = xxIXOIIO();
                }
                return xxIXOIIO2;
            }
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<IIX0o> serializer() {
            return kotlinx.datetime.serializers.X0o0xo.f30536oIX0oI;
        }

        @kotlin.OOXIXo(level = DeprecationLevel.ERROR, message = "Use Clock.System.now() instead", replaceWith = @kotlin.XX(expression = "Clock.System.now()", imports = {"kotlinx.datetime.Clock"}))
        @OXOo.OOXIXo
        public final IIX0o xoIox() {
            Clock systemUTC;
            Instant instant;
            systemUTC = Clock.systemUTC();
            instant = systemUTC.instant();
            kotlin.jvm.internal.IIX0o.oO(instant, "instant(...)");
            return new IIX0o(instant);
        }

        @OXOo.OOXIXo
        public final IIX0o xxIXOIIO() {
            return IIX0o.f476Oxx0xo;
        }

        public oIX0oI() {
        }
    }

    static {
        Instant ofEpochSecond;
        Instant ofEpochSecond2;
        Instant MIN;
        Instant MAX;
        ofEpochSecond = Instant.ofEpochSecond(o0.f485oIX0oI, 999999999L);
        kotlin.jvm.internal.IIX0o.oO(ofEpochSecond, "ofEpochSecond(...)");
        f475Oo = new IIX0o(ofEpochSecond);
        ofEpochSecond2 = Instant.ofEpochSecond(o0.f484II0xO0, 0L);
        kotlin.jvm.internal.IIX0o.oO(ofEpochSecond2, "ofEpochSecond(...)");
        f474IXxxXO = new IIX0o(ofEpochSecond2);
        MIN = Instant.MIN;
        kotlin.jvm.internal.IIX0o.oO(MIN, "MIN");
        f476Oxx0xo = new IIX0o(MIN);
        MAX = Instant.MAX;
        kotlin.jvm.internal.IIX0o.oO(MAX, "MAX");
        f477oI0IIXIo = new IIX0o(MAX);
    }

    public IIX0o(@OXOo.OOXIXo Instant value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f478XO = value;
    }

    @Override // java.lang.Comparable
    /* renamed from: II0XooXoX, reason: merged with bridge method [inline-methods] */
    public int compareTo(@OXOo.OOXIXo IIX0o other) {
        int compareTo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        compareTo = this.f478XO.compareTo(other.f478XO);
        return compareTo;
    }

    public final int OOXIXo() {
        int nano;
        nano = this.f478XO.getNano();
        return nano;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this != obj && (!(obj instanceof IIX0o) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f478XO, ((IIX0o) obj).f478XO))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f478XO.hashCode();
        return hashCode;
    }

    @OXOo.OOXIXo
    public final IIX0o oO(long j) {
        IIX0o iIX0o;
        Instant plusSeconds;
        Instant plusNanos;
        long IO2 = kotlin.time.oxoX.IO(j);
        int OI02 = kotlin.time.oxoX.OI0(j);
        try {
            plusSeconds = this.f478XO.plusSeconds(IO2);
            plusNanos = plusSeconds.plusNanos(OI02);
            kotlin.jvm.internal.IIX0o.oO(plusNanos, "plusNanos(...)");
            return new IIX0o(plusNanos);
        } catch (Exception e) {
            if (!(e instanceof ArithmeticException) && !X0IIOO.oIX0oI(e)) {
                throw e;
            }
            if (kotlin.time.oxoX.oX(j)) {
                iIX0o = f477oI0IIXIo;
            } else {
                iIX0o = f476Oxx0xo;
            }
            return iIX0o;
        }
    }

    @OXOo.OOXIXo
    public final Instant oOoXoXO() {
        return this.f478XO;
    }

    public final long ooOOo0oXI(@OXOo.OOXIXo IIX0o other) {
        long epochSecond;
        long epochSecond2;
        int nano;
        int nano2;
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        oxoX.oIX0oI oix0oi = kotlin.time.oxoX.f29647Oo;
        epochSecond = this.f478XO.getEpochSecond();
        epochSecond2 = other.f478XO.getEpochSecond();
        long xoIxX2 = kotlin.time.XO.xoIxX(epochSecond - epochSecond2, DurationUnit.SECONDS);
        nano = this.f478XO.getNano();
        nano2 = other.f478XO.getNano();
        return kotlin.time.oxoX.XoI0Ixx0(xoIxX2, kotlin.time.XO.IoOoo(nano - nano2, DurationUnit.NANOSECONDS));
    }

    @OXOo.OOXIXo
    public String toString() {
        String instant;
        instant = this.f478XO.toString();
        kotlin.jvm.internal.IIX0o.oO(instant, "toString(...)");
        return instant;
    }

    @OXOo.OOXIXo
    public final IIX0o x0XOIxOo(long j) {
        return oO(kotlin.time.oxoX.OOXIxO0(j));
    }

    public final long x0xO0oo() {
        Instant instant;
        boolean isAfter;
        long epochMilli;
        try {
            epochMilli = this.f478XO.toEpochMilli();
            return epochMilli;
        } catch (ArithmeticException unused) {
            Instant instant2 = this.f478XO;
            instant = Instant.EPOCH;
            isAfter = instant2.isAfter(instant);
            if (isAfter) {
                return Long.MAX_VALUE;
            }
            return Long.MIN_VALUE;
        }
    }

    public final long xoIox() {
        long epochSecond;
        epochSecond = this.f478XO.getEpochSecond();
        return epochSecond;
    }
}
