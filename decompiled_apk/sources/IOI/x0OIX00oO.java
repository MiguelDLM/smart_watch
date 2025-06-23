package IOI;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import kotlinx.datetime.DateTimeFormatException;

@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.II0XooXoX.class)
/* loaded from: classes6.dex */
public final class x0OIX00oO implements Comparable<x0OIX00oO> {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0OIX00oO f509IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final x0OIX00oO f510Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LocalTime f511XO;

    @kotlin.jvm.internal.XX({"SMAP\nLocalTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalTime.kt\nkotlinx/datetime/LocalTime$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,75:1\n1#2:76\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final x0OIX00oO I0Io(int i) {
            LocalTime ofSecondOfDay;
            try {
                ofSecondOfDay = LocalTime.ofSecondOfDay(i);
                return new x0OIX00oO(ofSecondOfDay);
            } catch (DateTimeException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @OXOo.OOXIXo
        public final x0OIX00oO II0xO0(long j) {
            LocalTime ofNanoOfDay;
            try {
                ofNanoOfDay = LocalTime.ofNanoOfDay(j);
                return new x0OIX00oO(ofNanoOfDay);
            } catch (DateTimeException e) {
                throw new IllegalArgumentException(e);
            }
        }

        @OXOo.OOXIXo
        public final x0OIX00oO X0o0xo() {
            return x0OIX00oO.f510Oo;
        }

        @OXOo.OOXIXo
        public final x0OIX00oO XO(@OXOo.OOXIXo String isoString) {
            LocalTime parse;
            kotlin.jvm.internal.IIX0o.x0xO0oo(isoString, "isoString");
            try {
                parse = LocalTime.parse(isoString);
                return new x0OIX00oO(parse);
            } catch (DateTimeParseException e) {
                throw new DateTimeFormatException(e);
            }
        }

        @OXOo.OOXIXo
        public final x0OIX00oO oIX0oI(int i) {
            LocalTime ofNanoOfDay;
            try {
                ofNanoOfDay = LocalTime.ofNanoOfDay(i * 1000000);
                return new x0OIX00oO(ofNanoOfDay);
            } catch (Throwable th) {
                throw new IllegalArgumentException(th);
            }
        }

        @OXOo.OOXIXo
        public final x0OIX00oO oxoX() {
            return x0OIX00oO.f509IXxxXO;
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<x0OIX00oO> serializer() {
            return kotlinx.datetime.serializers.II0XooXoX.f30516oIX0oI;
        }

        public oIX0oI() {
        }
    }

    static {
        LocalTime MIN;
        LocalTime MAX;
        MIN = LocalTime.MIN;
        kotlin.jvm.internal.IIX0o.oO(MIN, "MIN");
        f510Oo = new x0OIX00oO(MIN);
        MAX = LocalTime.MAX;
        kotlin.jvm.internal.IIX0o.oO(MAX, "MAX");
        f509IXxxXO = new x0OIX00oO(MAX);
    }

    public x0OIX00oO(@OXOo.OOXIXo LocalTime value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f511XO = value;
    }

    public final int II0XooXoX() {
        int minute;
        minute = this.f511XO.getMinute();
        return minute;
    }

    public final int OOXIXo() {
        int second;
        second = this.f511XO.getSecond();
        return second;
    }

    public final int Oxx0IOOO() {
        int hour;
        hour = this.f511XO.getHour();
        return hour;
    }

    @Override // java.lang.Comparable
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public int compareTo(@OXOo.OOXIXo x0OIX00oO other) {
        int compareTo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        compareTo = this.f511XO.compareTo(other.f511XO);
        return compareTo;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this != obj && (!(obj instanceof x0OIX00oO) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f511XO, ((x0OIX00oO) obj).f511XO))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f511XO.hashCode();
        return hashCode;
    }

    public final int oO() {
        int secondOfDay;
        secondOfDay = this.f511XO.toSecondOfDay();
        return secondOfDay;
    }

    @OXOo.OOXIXo
    public final LocalTime oOoXoXO() {
        return this.f511XO;
    }

    public final int ooOOo0oXI() {
        long nanoOfDay;
        nanoOfDay = this.f511XO.toNanoOfDay();
        return (int) (nanoOfDay / 1000000);
    }

    @OXOo.OOXIXo
    public String toString() {
        String localTime;
        localTime = this.f511XO.toString();
        kotlin.jvm.internal.IIX0o.oO(localTime, "toString(...)");
        return localTime;
    }

    public final long x0XOIxOo() {
        long nanoOfDay;
        nanoOfDay = this.f511XO.toNanoOfDay();
        return nanoOfDay;
    }

    public final int xoIox() {
        int nano;
        nano = this.f511XO.getNano();
        return nano;
    }

    public /* synthetic */ x0OIX00oO(int i, int i2, int i3, int i4, int i5, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i, i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 0 : i4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x0OIX00oO(int r1, int r2, int r3, int r4) {
        /*
            r0 = this;
            java.time.LocalTime r1 = com.alibaba.fastjson.parser.deserializer.X0IIOO.oIX0oI(r1, r2, r3, r4)     // Catch: java.time.DateTimeException -> Lb
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            r0.<init>(r1)
            return
        Lb:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: IOI.x0OIX00oO.<init>(int, int, int, int):void");
    }
}
