package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class CompletionCondition {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ CompletionCondition[] $VALUES;
    private final int condition;
    public static final CompletionCondition DURATION = new CompletionCondition("DURATION", 0, 0);
    public static final CompletionCondition MANUAL = new CompletionCondition("MANUAL", 1, 1);
    public static final CompletionCondition DURATION_IN_HR_ZONE = new CompletionCondition("DURATION_IN_HR_ZONE", 2, 2);
    public static final CompletionCondition HR_ABOVE = new CompletionCondition("HR_ABOVE", 3, 3);
    public static final CompletionCondition HR_BELOW = new CompletionCondition("HR_BELOW", 4, 4);

    private static final /* synthetic */ CompletionCondition[] $values() {
        return new CompletionCondition[]{DURATION, MANUAL, DURATION_IN_HR_ZONE, HR_ABOVE, HR_BELOW};
    }

    static {
        CompletionCondition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private CompletionCondition(String str, int i, int i2) {
        this.condition = i2;
    }

    @OOXIXo
    public static oIX0oI<CompletionCondition> getEntries() {
        return $ENTRIES;
    }

    public static CompletionCondition valueOf(String str) {
        return (CompletionCondition) Enum.valueOf(CompletionCondition.class, str);
    }

    public static CompletionCondition[] values() {
        return (CompletionCondition[]) $VALUES.clone();
    }

    public final int getCondition() {
        return this.condition;
    }
}
