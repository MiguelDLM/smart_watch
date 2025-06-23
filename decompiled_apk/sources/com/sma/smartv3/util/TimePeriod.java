package com.sma.smartv3.util;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class TimePeriod {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ TimePeriod[] $VALUES;
    public static final TimePeriod HALF_HOUR = new TimePeriod("HALF_HOUR", 0);
    public static final TimePeriod HOUR = new TimePeriod("HOUR", 1);
    public static final TimePeriod DAY = new TimePeriod("DAY", 2);
    public static final TimePeriod WEEK = new TimePeriod("WEEK", 3);
    public static final TimePeriod MONTH = new TimePeriod("MONTH", 4);
    public static final TimePeriod YEAR = new TimePeriod("YEAR", 5);

    private static final /* synthetic */ TimePeriod[] $values() {
        return new TimePeriod[]{HALF_HOUR, HOUR, DAY, WEEK, MONTH, YEAR};
    }

    static {
        TimePeriod[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private TimePeriod(String str, int i) {
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<TimePeriod> getEntries() {
        return $ENTRIES;
    }

    public static TimePeriod valueOf(String str) {
        return (TimePeriod) Enum.valueOf(TimePeriod.class, str);
    }

    public static TimePeriod[] values() {
        return (TimePeriod[]) $VALUES.clone();
    }
}
