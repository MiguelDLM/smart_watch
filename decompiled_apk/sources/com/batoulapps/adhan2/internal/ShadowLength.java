package com.batoulapps.adhan2.internal;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class ShadowLength {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ ShadowLength[] $VALUES;
    private final double shadowLength;
    public static final ShadowLength SINGLE = new ShadowLength("SINGLE", 0, 1.0d);
    public static final ShadowLength DOUBLE = new ShadowLength("DOUBLE", 1, 2.0d);

    private static final /* synthetic */ ShadowLength[] $values() {
        return new ShadowLength[]{SINGLE, DOUBLE};
    }

    static {
        ShadowLength[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private ShadowLength(String str, int i, double d) {
        this.shadowLength = d;
    }

    @OOXIXo
    public static oIX0oI<ShadowLength> getEntries() {
        return $ENTRIES;
    }

    public static ShadowLength valueOf(String str) {
        return (ShadowLength) Enum.valueOf(ShadowLength.class, str);
    }

    public static ShadowLength[] values() {
        return (ShadowLength[]) $VALUES.clone();
    }

    public final double getShadowLength() {
        return this.shadowLength;
    }
}
