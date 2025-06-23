package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Rule;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class LevelType {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ LevelType[] $VALUES;
    public static final LevelType ALL = new LevelType(Rule.ALL, 0);
    public static final LevelType STANDARD = new LevelType("STANDARD", 1);
    public static final LevelType LOW = new LevelType("LOW", 2);
    public static final LevelType HIGH = new LevelType("HIGH", 3);

    private static final /* synthetic */ LevelType[] $values() {
        return new LevelType[]{ALL, STANDARD, LOW, HIGH};
    }

    static {
        LevelType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private LevelType(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<LevelType> getEntries() {
        return $ENTRIES;
    }

    public static LevelType valueOf(String str) {
        return (LevelType) Enum.valueOf(LevelType.class, str);
    }

    public static LevelType[] values() {
        return (LevelType[]) $VALUES.clone();
    }
}
