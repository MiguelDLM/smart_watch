package com.sma.smartv3.model;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes12.dex */
public final class VipBenefitType {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ VipBenefitType[] $VALUES;
    private final int type;
    public static final VipBenefitType AI = new VipBenefitType("AI", 0, 257);
    public static final VipBenefitType AIGC = new VipBenefitType("AIGC", 1, 258);
    public static final VipBenefitType DIAL = new VipBenefitType("DIAL", 2, 259);
    public static final VipBenefitType BUY_VIP = new VipBenefitType("BUY_VIP", 3, 260);

    private static final /* synthetic */ VipBenefitType[] $values() {
        return new VipBenefitType[]{AI, AIGC, DIAL, BUY_VIP};
    }

    static {
        VipBenefitType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private VipBenefitType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<VipBenefitType> getEntries() {
        return $ENTRIES;
    }

    public static VipBenefitType valueOf(String str) {
        return (VipBenefitType) Enum.valueOf(VipBenefitType.class, str);
    }

    public static VipBenefitType[] values() {
        return (VipBenefitType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }
}
