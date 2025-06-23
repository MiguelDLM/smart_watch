package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class BGEMGender {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ BGEMGender[] $VALUES;
    public static final BGEMGender M = new BGEMGender("M", 0);
    public static final BGEMGender F = new BGEMGender("F", 1);

    private static final /* synthetic */ BGEMGender[] $values() {
        return new BGEMGender[]{M, F};
    }

    static {
        BGEMGender[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private BGEMGender(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<BGEMGender> getEntries() {
        return $ENTRIES;
    }

    public static BGEMGender valueOf(String str) {
        return (BGEMGender) Enum.valueOf(BGEMGender.class, str);
    }

    public static BGEMGender[] values() {
        return (BGEMGender[]) $VALUES.clone();
    }
}
