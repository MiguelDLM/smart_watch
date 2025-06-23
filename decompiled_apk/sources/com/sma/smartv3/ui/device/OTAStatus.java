package com.sma.smartv3.ui.device;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class OTAStatus {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ OTAStatus[] $VALUES;
    public static final OTAStatus NONE = new OTAStatus("NONE", 0);
    public static final OTAStatus UPGRADE_SCANNING_START = new OTAStatus("UPGRADE_SCANNING_START", 1);
    public static final OTAStatus UPGRADE_SCANNING_TIMEOUT = new OTAStatus("UPGRADE_SCANNING_TIMEOUT", 2);
    public static final OTAStatus UPGRADE_SCANNING_STOP = new OTAStatus("UPGRADE_SCANNING_STOP", 3);
    public static final OTAStatus UPGRADE_PREPARE = new OTAStatus("UPGRADE_PREPARE", 4);
    public static final OTAStatus UPGRADE_PREPARE_FAILED = new OTAStatus("UPGRADE_PREPARE_FAILED", 5);
    public static final OTAStatus UPGRADE_START = new OTAStatus("UPGRADE_START", 6);
    public static final OTAStatus UPGRADE_CHECKING = new OTAStatus("UPGRADE_CHECKING", 7);
    public static final OTAStatus UPGRADEING = new OTAStatus("UPGRADEING", 8);
    public static final OTAStatus UPGRADE_STOP = new OTAStatus("UPGRADE_STOP", 9);
    public static final OTAStatus UPGRADE_FAILED = new OTAStatus("UPGRADE_FAILED", 10);

    private static final /* synthetic */ OTAStatus[] $values() {
        return new OTAStatus[]{NONE, UPGRADE_SCANNING_START, UPGRADE_SCANNING_TIMEOUT, UPGRADE_SCANNING_STOP, UPGRADE_PREPARE, UPGRADE_PREPARE_FAILED, UPGRADE_START, UPGRADE_CHECKING, UPGRADEING, UPGRADE_STOP, UPGRADE_FAILED};
    }

    static {
        OTAStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private OTAStatus(String str, int i) {
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<OTAStatus> getEntries() {
        return $ENTRIES;
    }

    public static OTAStatus valueOf(String str) {
        return (OTAStatus) Enum.valueOf(OTAStatus.class, str);
    }

    public static OTAStatus[] values() {
        return (OTAStatus[]) $VALUES.clone();
    }
}
