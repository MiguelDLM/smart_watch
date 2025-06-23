package com.sma.smartv3.model;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.language.bm.Rule;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class AIFunctionCat {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ AIFunctionCat[] $VALUES;
    private final int cat;
    public static final AIFunctionCat ALL = new AIFunctionCat(Rule.ALL, 0, 0);
    public static final AIFunctionCat LIFE = new AIFunctionCat("LIFE", 1, 1);
    public static final AIFunctionCat WORK = new AIFunctionCat("WORK", 2, 2);
    public static final AIFunctionCat AMUSEMENT = new AIFunctionCat("AMUSEMENT", 3, 3);

    private static final /* synthetic */ AIFunctionCat[] $values() {
        return new AIFunctionCat[]{ALL, LIFE, WORK, AMUSEMENT};
    }

    static {
        AIFunctionCat[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private AIFunctionCat(String str, int i, int i2) {
        this.cat = i2;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<AIFunctionCat> getEntries() {
        return $ENTRIES;
    }

    public static AIFunctionCat valueOf(String str) {
        return (AIFunctionCat) Enum.valueOf(AIFunctionCat.class, str);
    }

    public static AIFunctionCat[] values() {
        return (AIFunctionCat[]) $VALUES.clone();
    }

    public final int getCat() {
        return this.cat;
    }
}
