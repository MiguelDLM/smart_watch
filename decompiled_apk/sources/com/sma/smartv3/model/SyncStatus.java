package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class SyncStatus {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ SyncStatus[] $VALUES;
    public static final SyncStatus DOWNLOAD = new SyncStatus("DOWNLOAD", 0);
    public static final SyncStatus FAILED = new SyncStatus("FAILED", 1);
    public static final SyncStatus NO_SYNC = new SyncStatus("NO_SYNC", 2);
    public static final SyncStatus SYNCING = new SyncStatus("SYNCING", 3);
    public static final SyncStatus SYNCED = new SyncStatus("SYNCED", 4);

    private static final /* synthetic */ SyncStatus[] $values() {
        return new SyncStatus[]{DOWNLOAD, FAILED, NO_SYNC, SYNCING, SYNCED};
    }

    static {
        SyncStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private SyncStatus(String str, int i) {
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<SyncStatus> getEntries() {
        return $ENTRIES;
    }

    public static SyncStatus valueOf(String str) {
        return (SyncStatus) Enum.valueOf(SyncStatus.class, str);
    }

    public static SyncStatus[] values() {
        return (SyncStatus[]) $VALUES.clone();
    }
}
