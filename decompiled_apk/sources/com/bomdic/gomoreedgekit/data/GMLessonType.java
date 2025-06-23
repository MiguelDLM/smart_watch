package com.bomdic.gomoreedgekit.data;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class GMLessonType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ GMLessonType[] $VALUES;
    public static final GMLessonType UNKNOWN = new GMLessonType("UNKNOWN", 0);
    public static final GMLessonType STEADY = new GMLessonType("STEADY", 1);
    public static final GMLessonType SHORT_TEMPO = new GMLessonType("SHORT_TEMPO", 2);
    public static final GMLessonType LIIT = new GMLessonType("LIIT", 3);
    public static final GMLessonType TEMPO = new GMLessonType("TEMPO", 4);
    public static final GMLessonType MIIT = new GMLessonType("MIIT", 5);
    public static final GMLessonType HIIT = new GMLessonType("HIIT", 6);

    private static final /* synthetic */ GMLessonType[] $values() {
        return new GMLessonType[]{UNKNOWN, STEADY, SHORT_TEMPO, LIIT, TEMPO, MIIT, HIIT};
    }

    static {
        GMLessonType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private GMLessonType(String str, int i) {
    }

    @OOXIXo
    public static oIX0oI<GMLessonType> getEntries() {
        return $ENTRIES;
    }

    public static GMLessonType valueOf(String str) {
        return (GMLessonType) Enum.valueOf(GMLessonType.class, str);
    }

    public static GMLessonType[] values() {
        return (GMLessonType[]) $VALUES.clone();
    }
}
