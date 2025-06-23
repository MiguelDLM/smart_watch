package com.bestmafen.baseble.scanner;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class ScanMode {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ ScanMode[] $VALUES;
    public static final ScanMode LOW_POWER = new ScanMode("LOW_POWER", 0);
    public static final ScanMode BALANCED = new ScanMode("BALANCED", 1);
    public static final ScanMode LOW_LATENCY = new ScanMode("LOW_LATENCY", 2);

    private static final /* synthetic */ ScanMode[] $values() {
        return new ScanMode[]{LOW_POWER, BALANCED, LOW_LATENCY};
    }

    static {
        ScanMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private ScanMode(String str, int i) {
    }

    @OOXIXo
    public static oIX0oI<ScanMode> getEntries() {
        return $ENTRIES;
    }

    public static ScanMode valueOf(String str) {
        return (ScanMode) Enum.valueOf(ScanMode.class, str);
    }

    public static ScanMode[] values() {
        return (ScanMode[]) $VALUES.clone();
    }
}
