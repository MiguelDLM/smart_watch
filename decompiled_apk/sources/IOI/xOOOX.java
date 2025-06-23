package IOI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeParseException;
import kotlinx.datetime.DateTimeFormatException;

@kotlinx.serialization.IXxxXO(with = kotlinx.datetime.serializers.Oxx0IOOO.class)
/* loaded from: classes6.dex */
public final class xOOOX implements Comparable<xOOOX> {

    @OXOo.OOXIXo
    public static final oIX0oI Companion = new oIX0oI(null);

    /* renamed from: IXxxXO, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xOOOX f513IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    @OXOo.OOXIXo
    public static final xOOOX f514Oo;

    /* renamed from: XO, reason: collision with root package name */
    @OXOo.OOXIXo
    public final LocalDateTime f515XO;

    @kotlin.jvm.internal.XX({"SMAP\nLocalDateTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LocalDateTime.kt\nkotlinx/datetime/LocalDateTime$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
    /* loaded from: classes6.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final xOOOX I0Io(@OXOo.OOXIXo String isoString) {
            LocalDateTime parse;
            kotlin.jvm.internal.IIX0o.x0xO0oo(isoString, "isoString");
            try {
                parse = LocalDateTime.parse(isoString);
                return new xOOOX(parse);
            } catch (DateTimeParseException e) {
                throw new DateTimeFormatException(e);
            }
        }

        @OXOo.OOXIXo
        public final xOOOX II0xO0() {
            return xOOOX.f514Oo;
        }

        @OXOo.OOXIXo
        public final xOOOX oIX0oI() {
            return xOOOX.f513IXxxXO;
        }

        @OXOo.OOXIXo
        public final kotlinx.serialization.Oxx0IOOO<xOOOX> serializer() {
            return kotlinx.datetime.serializers.Oxx0IOOO.f30532oIX0oI;
        }

        public oIX0oI() {
        }
    }

    static {
        LocalDateTime MIN;
        LocalDateTime MAX;
        MIN = LocalDateTime.MIN;
        kotlin.jvm.internal.IIX0o.oO(MIN, "MIN");
        f514Oo = new xOOOX(MIN);
        MAX = LocalDateTime.MAX;
        kotlin.jvm.internal.IIX0o.oO(MAX, "MAX");
        f513IXxxXO = new xOOOX(MAX);
    }

    public xOOOX(@OXOo.OOXIXo LocalDateTime value) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(value, "value");
        this.f515XO = value;
    }

    public final int II0XooXoX() {
        int dayOfMonth;
        dayOfMonth = this.f515XO.getDayOfMonth();
        return dayOfMonth;
    }

    @OXOo.OOXIXo
    public final x0OIX00oO IXxxXO() {
        LocalTime localTime;
        localTime = this.f515XO.toLocalTime();
        kotlin.jvm.internal.IIX0o.oO(localTime, "toLocalTime(...)");
        return new x0OIX00oO(localTime);
    }

    public final int OOXIXo() {
        int dayOfYear;
        dayOfYear = this.f515XO.getDayOfYear();
        return dayOfYear;
    }

    public final int Oo() {
        int second;
        second = this.f515XO.getSecond();
        return second;
    }

    @OXOo.OOXIXo
    public final xoxXI Oxx0IOOO() {
        LocalDate localDate;
        localDate = this.f515XO.toLocalDate();
        kotlin.jvm.internal.IIX0o.oO(localDate, "toLocalDate(...)");
        return new xoxXI(localDate);
    }

    @OXOo.OOXIXo
    public final LocalDateTime Oxx0xo() {
        return this.f515XO;
    }

    @Override // java.lang.Comparable
    /* renamed from: XO, reason: merged with bridge method [inline-methods] */
    public int compareTo(@OXOo.OOXIXo xOOOX other) {
        int compareTo;
        kotlin.jvm.internal.IIX0o.x0xO0oo(other, "other");
        compareTo = this.f515XO.compareTo((ChronoLocalDateTime<?>) xoO0xx0.oIX0oI(other.f515XO));
        return compareTo;
    }

    public boolean equals(@OXOo.oOoXoXO Object obj) {
        if (this != obj && (!(obj instanceof xOOOX) || !kotlin.jvm.internal.IIX0o.Oxx0IOOO(this.f515XO, ((xOOOX) obj).f515XO))) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        hashCode = this.f515XO.hashCode();
        return hashCode;
    }

    public final int oI0IIXIo() {
        int year;
        year = this.f515XO.getYear();
        return year;
    }

    public final int oO() {
        int monthValue;
        monthValue = this.f515XO.getMonthValue();
        return monthValue;
    }

    public final int oOoXoXO() {
        int hour;
        hour = this.f515XO.getHour();
        return hour;
    }

    public final int ooOOo0oXI() {
        int minute;
        minute = this.f515XO.getMinute();
        return minute;
    }

    @OXOo.OOXIXo
    public String toString() {
        String localDateTime;
        localDateTime = this.f515XO.toString();
        kotlin.jvm.internal.IIX0o.oO(localDateTime, "toString(...)");
        return localDateTime;
    }

    @OXOo.OOXIXo
    public final Month x0XOIxOo() {
        Month month;
        month = this.f515XO.getMonth();
        kotlin.jvm.internal.IIX0o.oO(month, "getMonth(...)");
        return month;
    }

    public final int x0xO0oo() {
        int nano;
        nano = this.f515XO.getNano();
        return nano;
    }

    @OXOo.OOXIXo
    public final DayOfWeek xoIox() {
        DayOfWeek dayOfWeek;
        dayOfWeek = this.f515XO.getDayOfWeek();
        kotlin.jvm.internal.IIX0o.oO(dayOfWeek, "getDayOfWeek(...)");
        return dayOfWeek;
    }

    public /* synthetic */ xOOOX(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i, i2, i3, i4, i5, (i8 & 32) != 0 ? 0 : i6, (i8 & 64) != 0 ? 0 : i7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xOOOX(int r1, int r2, int r3, int r4, int r5, int r6, int r7) {
        /*
            r0 = this;
            java.time.LocalDateTime r1 = IOI.ooOx.oIX0oI(r1, r2, r3, r4, r5, r6, r7)     // Catch: java.time.DateTimeException -> Lb
            kotlin.jvm.internal.IIX0o.ooOOo0oXI(r1)
            r0.<init>(r1)
            return
        Lb:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            r2.<init>(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: IOI.xOOOX.<init>(int, int, int, int, int, int, int):void");
    }

    public /* synthetic */ xOOOX(int i, Month month, int i2, int i3, int i4, int i5, int i6, int i7, kotlin.jvm.internal.IIXOooo iIXOooo) {
        this(i, month, i2, i3, i4, (i7 & 32) != 0 ? 0 : i5, (i7 & 64) != 0 ? 0 : i6);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public xOOOX(int i, @OXOo.OOXIXo Month month, int i2, int i3, int i4, int i5, int i6) {
        this(i, oI.II0xO0(month), i2, i3, i4, i5, i6);
        kotlin.jvm.internal.IIX0o.x0xO0oo(month, "month");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public xOOOX(@OXOo.OOXIXo IOI.xoxXI r2, @OXOo.OOXIXo IOI.x0OIX00oO r3) {
        /*
            r1 = this;
            java.lang.String r0 = "date"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r2, r0)
            java.lang.String r0 = "time"
            kotlin.jvm.internal.IIX0o.x0xO0oo(r3, r0)
            java.time.LocalDate r2 = r2.ooOOo0oXI()
            java.time.LocalTime r3 = r3.oOoXoXO()
            java.time.LocalDateTime r2 = com.alibaba.fastjson.parser.deserializer.XX.oIX0oI(r2, r3)
            java.lang.String r3 = "of(...)"
            kotlin.jvm.internal.IIX0o.oO(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: IOI.xOOOX.<init>(IOI.xoxXI, IOI.x0OIX00oO):void");
    }
}
