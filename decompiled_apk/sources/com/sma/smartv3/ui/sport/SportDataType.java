package com.sma.smartv3.ui.sport;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class SportDataType {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ SportDataType[] $VALUES;
    public static final SportDataType TIME = new SportDataType("TIME", 0);
    public static final SportDataType DISTANCE = new SportDataType("DISTANCE", 1);
    public static final SportDataType CALORIES = new SportDataType("CALORIES", 2);
    public static final SportDataType STEP = new SportDataType("STEP", 3);
    public static final SportDataType SPM = new SportDataType("SPM", 4);
    public static final SportDataType PACE = new SportDataType("PACE", 5);
    public static final SportDataType SPEED = new SportDataType("SPEED", 6);
    public static final SportDataType ALTITUDE = new SportDataType("ALTITUDE", 7);
    public static final SportDataType HEARTRATE = new SportDataType("HEARTRATE", 8);

    private static final /* synthetic */ SportDataType[] $values() {
        return new SportDataType[]{TIME, DISTANCE, CALORIES, STEP, SPM, PACE, SPEED, ALTITUDE, HEARTRATE};
    }

    static {
        SportDataType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private SportDataType(String str, int i) {
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<SportDataType> getEntries() {
        return $ENTRIES;
    }

    public static SportDataType valueOf(String str) {
        return (SportDataType) Enum.valueOf(SportDataType.class, str);
    }

    public static SportDataType[] values() {
        return (SportDataType[]) $VALUES.clone();
    }
}
