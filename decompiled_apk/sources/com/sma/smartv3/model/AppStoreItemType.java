package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class AppStoreItemType {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ AppStoreItemType[] $VALUES;
    private final int type;
    public static final AppStoreItemType INSTALLED = new AppStoreItemType("INSTALLED", 0, 0);
    public static final AppStoreItemType INSTALL = new AppStoreItemType("INSTALL", 1, 1);
    public static final AppStoreItemType RENEW = new AppStoreItemType("RENEW", 2, 2);
    public static final AppStoreItemType NOT_RENEW = new AppStoreItemType("NOT_RENEW", 3, 3);

    private static final /* synthetic */ AppStoreItemType[] $values() {
        return new AppStoreItemType[]{INSTALLED, INSTALL, RENEW, NOT_RENEW};
    }

    static {
        AppStoreItemType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private AppStoreItemType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<AppStoreItemType> getEntries() {
        return $ENTRIES;
    }

    public static AppStoreItemType valueOf(String str) {
        return (AppStoreItemType) Enum.valueOf(AppStoreItemType.class, str);
    }

    public static AppStoreItemType[] values() {
        return (AppStoreItemType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }
}
