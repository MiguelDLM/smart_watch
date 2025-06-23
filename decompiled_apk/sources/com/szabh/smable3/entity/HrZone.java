package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class HrZone {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ HrZone[] $VALUES;
    private final int zone;
    public static final HrZone LOW = new HrZone("LOW", 0, 1);
    public static final HrZone NORMAL = new HrZone("NORMAL", 1, 2);
    public static final HrZone MODERATE = new HrZone("MODERATE", 2, 3);
    public static final HrZone HARD = new HrZone("HARD", 3, 4);
    public static final HrZone MAXIMUM = new HrZone("MAXIMUM", 4, 5);

    private static final /* synthetic */ HrZone[] $values() {
        return new HrZone[]{LOW, NORMAL, MODERATE, HARD, MAXIMUM};
    }

    static {
        HrZone[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private HrZone(String str, int i, int i2) {
        this.zone = i2;
    }

    @OOXIXo
    public static oIX0oI<HrZone> getEntries() {
        return $ENTRIES;
    }

    public static HrZone valueOf(String str) {
        return (HrZone) Enum.valueOf(HrZone.class, str);
    }

    public static HrZone[] values() {
        return (HrZone[]) $VALUES.clone();
    }

    public final int getZone() {
        return this.zone;
    }
}
