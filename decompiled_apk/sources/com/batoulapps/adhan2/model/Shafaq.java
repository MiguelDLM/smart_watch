package com.batoulapps.adhan2.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class Shafaq {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ Shafaq[] $VALUES;
    public static final Shafaq GENERAL = new Shafaq("GENERAL", 0);
    public static final Shafaq AHMER = new Shafaq("AHMER", 1);
    public static final Shafaq ABYAD = new Shafaq("ABYAD", 2);

    private static final /* synthetic */ Shafaq[] $values() {
        return new Shafaq[]{GENERAL, AHMER, ABYAD};
    }

    static {
        Shafaq[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private Shafaq(String str, int i) {
    }

    @OOXIXo
    public static oIX0oI<Shafaq> getEntries() {
        return $ENTRIES;
    }

    public static Shafaq valueOf(String str) {
        return (Shafaq) Enum.valueOf(Shafaq.class, str);
    }

    public static Shafaq[] values() {
        return (Shafaq[]) $VALUES.clone();
    }
}
