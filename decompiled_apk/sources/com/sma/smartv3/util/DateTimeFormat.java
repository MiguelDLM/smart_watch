package com.sma.smartv3.util;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class DateTimeFormat {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ DateTimeFormat[] $VALUES;

    @OXOo.OOXIXo
    public static final oIX0oI Companion;
    private final int type;
    public static final DateTimeFormat yyyyMMdd = new DateTimeFormat("yyyyMMdd", 0, 0);
    public static final DateTimeFormat ddMMyyyy = new DateTimeFormat("ddMMyyyy", 1, 1);
    public static final DateTimeFormat MMddyyyy = new DateTimeFormat("MMddyyyy", 2, 2);

    @kotlin.jvm.internal.XX({"SMAP\nDateTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DateTime.kt\ncom/sma/smartv3/util/DateTimeFormat$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,725:1\n1#2:726\n*E\n"})
    /* loaded from: classes12.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(kotlin.jvm.internal.IIXOooo iIXOooo) {
            this();
        }

        @OXOo.OOXIXo
        public final DateTimeFormat oIX0oI(int i) {
            DateTimeFormat dateTimeFormat;
            DateTimeFormat[] values = DateTimeFormat.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    dateTimeFormat = values[i2];
                    if (dateTimeFormat.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    dateTimeFormat = null;
                    break;
                }
            }
            if (dateTimeFormat == null) {
                return DateTimeFormat.MMddyyyy;
            }
            return dateTimeFormat;
        }

        public oIX0oI() {
        }
    }

    private static final /* synthetic */ DateTimeFormat[] $values() {
        return new DateTimeFormat[]{yyyyMMdd, ddMMyyyy, MMddyyyy};
    }

    static {
        DateTimeFormat[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
        Companion = new oIX0oI(null);
    }

    private DateTimeFormat(String str, int i, int i2) {
        this.type = i2;
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<DateTimeFormat> getEntries() {
        return $ENTRIES;
    }

    public static DateTimeFormat valueOf(String str) {
        return (DateTimeFormat) Enum.valueOf(DateTimeFormat.class, str);
    }

    public static DateTimeFormat[] values() {
        return (DateTimeFormat[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }
}
