package com.baidu.mapclient.liteapp;

import OXOo.OOXIXo;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes7.dex */
public final class NavType {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ NavType[] $VALUES;
    public static final NavType CAR = new NavType("CAR", 0);
    public static final NavType WALK = new NavType("WALK", 1);
    public static final NavType BIKE = new NavType("BIKE", 2);

    private static final /* synthetic */ NavType[] $values() {
        return new NavType[]{CAR, WALK, BIKE};
    }

    static {
        NavType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private NavType(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<NavType> getEntries() {
        return $ENTRIES;
    }

    public static NavType valueOf(String str) {
        return (NavType) Enum.valueOf(NavType.class, str);
    }

    public static NavType[] values() {
        return (NavType[]) $VALUES.clone();
    }
}
