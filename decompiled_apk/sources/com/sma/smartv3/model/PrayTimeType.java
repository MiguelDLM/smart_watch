package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class PrayTimeType {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ PrayTimeType[] $VALUES;
    public static final PrayTimeType FAJR = new PrayTimeType("FAJR", 0);
    public static final PrayTimeType SUNRISE = new PrayTimeType("SUNRISE", 1);
    public static final PrayTimeType DHUHR = new PrayTimeType("DHUHR", 2);
    public static final PrayTimeType ASR = new PrayTimeType("ASR", 3);
    public static final PrayTimeType MAGHRIB = new PrayTimeType("MAGHRIB", 4);
    public static final PrayTimeType ISHA = new PrayTimeType("ISHA", 5);

    private static final /* synthetic */ PrayTimeType[] $values() {
        return new PrayTimeType[]{FAJR, SUNRISE, DHUHR, ASR, MAGHRIB, ISHA};
    }

    static {
        PrayTimeType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private PrayTimeType(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<PrayTimeType> getEntries() {
        return $ENTRIES;
    }

    public static PrayTimeType valueOf(String str) {
        return (PrayTimeType) Enum.valueOf(PrayTimeType.class, str);
    }

    public static PrayTimeType[] values() {
        return (PrayTimeType[]) $VALUES.clone();
    }
}
