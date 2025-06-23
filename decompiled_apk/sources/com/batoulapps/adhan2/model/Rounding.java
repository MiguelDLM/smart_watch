package com.batoulapps.adhan2.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class Rounding {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ Rounding[] $VALUES;
    public static final Rounding NEAREST = new Rounding("NEAREST", 0);
    public static final Rounding UP = new Rounding("UP", 1);
    public static final Rounding NONE = new Rounding("NONE", 2);

    private static final /* synthetic */ Rounding[] $values() {
        return new Rounding[]{NEAREST, UP, NONE};
    }

    static {
        Rounding[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private Rounding(String str, int i) {
    }

    @OOXIXo
    public static oIX0oI<Rounding> getEntries() {
        return $ENTRIES;
    }

    public static Rounding valueOf(String str) {
        return (Rounding) Enum.valueOf(Rounding.class, str);
    }

    public static Rounding[] values() {
        return (Rounding[]) $VALUES.clone();
    }
}
