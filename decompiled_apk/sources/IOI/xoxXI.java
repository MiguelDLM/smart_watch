package IOI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeParseException;
import kotlinx.datetime.DateTimeFormatException;

@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.XO.class)
/* loaded from: classes6.dex */
public final class xoxXI implements Comparable<xoxXI> {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xoxXI f519IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xoxXI f520Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LocalDate f521XO;

    @kotlin.jvm.internal.XX({"SMAP\nLocalDate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalDate.kt\nkotlinx/datetime/LocalDate$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,133:1\n1#2:134\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final xoxXI I0Io() {
            return xoxXI.f520Oo;
        }

        @OXOo.OOXIXo
        public final xoxXI II0xO0() {
            return xoxXI.f519IXxxXO;
        }

        @OXOo.OOXIXo
        public final xoxXI oIX0oI(int i) {
            LocalDate ofEpochDay;
            ofEpochDay = LocalDate.ofEpochDay(i);
            kotlin.jvm.internal.IIX0o.oO(ofEpochDay, "ofEpochDay(...)");
            return new xoxXI(ofEpochDay);
        }

        @OXOo.OOXIXo
        public final xoxXI oxoX(@OXOo.OOXIXo String isoString) {
            LocalDate parse;
            kotlin.jvm.internal.IIX0o.x0xO0oo(isoString, "isoString");
            try {
                parse = LocalDate.parse(isoString);
                return new xoxXI(parse);
            } catch (DateTimeParseException e) {
                throw new DateTimeFormatException(e);
            }
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<xoxXI> serializer() {
            return kotlinx.datetime.serializers.XO.f30538oIX0oI;
        }

        public oIX0oI() {
        }
    }

    static {
        LocalDate MIN;
        LocalDate MAX;
        MIN = LocalDate.MIN;
        kotlin.jvm.internal.IIX0o.oO(MIN, "MIN");
        f520Oo = new xoxXI(MIN);
        MAX = LocalDate.MAX;
        kotlin.jvm.internal.IIX0o.oO(MAX, "MAX");
        f519IXxxXO = new xoxXI(MAX);
    }

    public xoxXI(@OXOo.OOXIXo LocalDate value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f521XO = value;
    }

    @OXOo.OOXIXo
    public final DayOfWeek II0XooXoX() {
        DayOfWeek dayOfWeek;
        dayOfWeek = this.f521XO.getDayOfWeek();
        kotlin.jvm.internal.IIX0o.oO(dayOfWeek, "getDayOfWeek(...)");
        return dayOfWeek;
    }

    @OXOo.OOXIXo
    public final Month OOXIXo() {
        Month month;
        month = this.f521XO.getMonth();
        kotlin.jvm.internal.IIX0o.oO(month, "getMonth(...)");
        return month;
    }

    public final int Oxx0IOOO() {
        int dayOfMonth;
        dayOfMonth = this.f521XO.getDayOfMonth();
        return dayOfMonth;
    }

    @Override // java.lang.Comparable
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public int compareTo(@OXOo.OOXIXo xoxXI other) {
        int compareTo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        compareTo = this.f521XO.compareTo(com.sma.smartv3.util.O0xOxO.oIX0oI(other.f521XO));
        return compareTo;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this != obj && (!(obj instanceof xoxXI) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f521XO, ((xoxXI) obj).f521XO))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f521XO.hashCode();
        return hashCode;
    }

    public final int oO() {
        long epochDay;
        epochDay = this.f521XO.toEpochDay();
        return OOOox.II0XooXoX.oIX0oI(epochDay);
    }

    public final int oOoXoXO() {
        int monthValue;
        monthValue = this.f521XO.getMonthValue();
        return monthValue;
    }

    @OXOo.OOXIXo
    public final LocalDate ooOOo0oXI() {
        return this.f521XO;
    }

    @OXOo.OOXIXo
    public String toString() {
        String localDate;
        localDate = this.f521XO.toString();
        kotlin.jvm.internal.IIX0o.oO(localDate, "toString(...)");
        return localDate;
    }

    public final int x0XOIxOo() {
        int year;
        year = this.f521XO.getYear();
        return year;
    }

    public final int xoIox() {
        int dayOfYear;
        dayOfYear = this.f521XO.getDayOfYear();
        return dayOfYear;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xoxXI(int r1, int r2, int r3) {
        /*
            r0 = this;
            java.time.LocalDate r1 = com.alibaba.fastjson.parser.deserializer.oX.oIX0oI(r1, r2, r3)     // Catch: java.time.DateTimeException -> Lb
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            r0.<init>(r1)
            return
        Lb:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: IOI.xoxXI.<init>(int, int, int):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public xoxXI(int i, @OXOo.OOXIXo Month month, int i2) {
        this(i, oI.II0xO0(month), i2);
        kotlin.jvm.internal.IIX0o.x0xO0oo(month, "month");
    }
}
