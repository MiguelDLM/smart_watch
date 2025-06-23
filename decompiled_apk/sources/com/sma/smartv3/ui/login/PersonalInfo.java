package com.sma.smartv3.ui.login;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class PersonalInfo {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ PersonalInfo[] $VALUES;
    public static final PersonalInfo NAME_GENDER = new PersonalInfo("NAME_GENDER", 0);
    public static final PersonalInfo BIRTHDAY_UNIT = new PersonalInfo("BIRTHDAY_UNIT", 1);
    public static final PersonalInfo HEIGHT_WEIGHT = new PersonalInfo("HEIGHT_WEIGHT", 2);
    public static final PersonalInfo MOVING_TARGET = new PersonalInfo("MOVING_TARGET", 3);

    private static final /* synthetic */ PersonalInfo[] $values() {
        return new PersonalInfo[]{NAME_GENDER, BIRTHDAY_UNIT, HEIGHT_WEIGHT, MOVING_TARGET};
    }

    static {
        PersonalInfo[] $values = $values();
        $VALUES = $values;
        $ENTRIES = kotlin.enums.I0Io.I0Io($values);
    }

    private PersonalInfo(String str, int i) {
    }

    @OXOo.OOXIXo
    public static kotlin.enums.oIX0oI<PersonalInfo> getEntries() {
        return $ENTRIES;
    }

    public static PersonalInfo valueOf(String str) {
        return (PersonalInfo) Enum.valueOf(PersonalInfo.class, str);
    }

    public static PersonalInfo[] values() {
        return (PersonalInfo[]) $VALUES.clone();
    }
}
