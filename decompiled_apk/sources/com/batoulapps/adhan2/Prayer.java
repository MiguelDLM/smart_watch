package com.batoulapps.adhan2;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class Prayer {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ Prayer[] $VALUES;
    public static final Prayer NONE = new Prayer("NONE", 0);
    public static final Prayer FAJR = new Prayer("FAJR", 1);
    public static final Prayer SUNRISE = new Prayer("SUNRISE", 2);
    public static final Prayer DHUHR = new Prayer("DHUHR", 3);
    public static final Prayer ASR = new Prayer("ASR", 4);
    public static final Prayer MAGHRIB = new Prayer("MAGHRIB", 5);
    public static final Prayer ISHA = new Prayer("ISHA", 6);

    private static final /* synthetic */ Prayer[] $values() {
        return new Prayer[]{NONE, FAJR, SUNRISE, DHUHR, ASR, MAGHRIB, ISHA};
    }

    static {
        Prayer[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private Prayer(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<Prayer> getEntries() {
        return $ENTRIES;
    }

    public static Prayer valueOf(String str) {
        return (Prayer) Enum.valueOf(Prayer.class, str);
    }

    public static Prayer[] values() {
        return (Prayer[]) $VALUES.clone();
    }
}
