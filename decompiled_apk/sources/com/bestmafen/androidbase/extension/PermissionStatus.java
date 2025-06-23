package com.bestmafen.androidbase.extension;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes8.dex */
public final class PermissionStatus {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ PermissionStatus[] $VALUES;
    public static final PermissionStatus GRANTED = new PermissionStatus("GRANTED", 0);
    public static final PermissionStatus DENIED = new PermissionStatus("DENIED", 1);
    public static final PermissionStatus DENIED_FOREVER = new PermissionStatus("DENIED_FOREVER", 2);

    private static final /* synthetic */ PermissionStatus[] $values() {
        return new PermissionStatus[]{GRANTED, DENIED, DENIED_FOREVER};
    }

    static {
        PermissionStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private PermissionStatus(String str, int i) {
    }

    @OOXIXo
    public static oIX0oI<PermissionStatus> getEntries() {
        return $ENTRIES;
    }

    public static PermissionStatus valueOf(String str) {
        return (PermissionStatus) Enum.valueOf(PermissionStatus.class, str);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) $VALUES.clone();
    }
}
