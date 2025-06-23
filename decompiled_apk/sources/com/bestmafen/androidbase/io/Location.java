package com.bestmafen.androidbase.io;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class Location {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ Location[] $VALUES;
    public static final Location INTERNAL = new Location("INTERNAL", 0);
    public static final Location EXTERNAL = new Location("EXTERNAL", 1);
    public static final Location PUBLIC = new Location("PUBLIC", 2);

    private static final /* synthetic */ Location[] $values() {
        return new Location[]{INTERNAL, EXTERNAL, PUBLIC};
    }

    static {
        Location[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private Location(String str, int i) {
    }

    @OOXIXo
    public static oIX0oI<Location> getEntries() {
        return $ENTRIES;
    }

    public static Location valueOf(String str) {
        return (Location) Enum.valueOf(Location.class, str);
    }

    public static Location[] values() {
        return (Location[]) $VALUES.clone();
    }
}
