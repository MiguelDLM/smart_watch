package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import java.util.Arrays;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class BleHardwareHeatrateType implements BleHardwareType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareHeatrateType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_NONE = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_NONE", 0, 0);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_FAKE = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_FAKE", 1, 1);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_BD1662 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_BD1662", 2, 2);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_BD1688 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_BD1688", 3, 3);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_SC7R31 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_SC7R31", 4, 4);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_PAH8007 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_PAH8007", 5, 5);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_TY3300 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_TY3300", 6, 6);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_TY3602 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_TY3602", 7, 7);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_TY3603 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_TY3603", 8, 8);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_TY3605 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_TY3605", 9, 9);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_LC09A = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_LC09A", 10, 10);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_LC11S = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_LC11S", 11, 11);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_VC32S = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_VC32S", 12, 12);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_VC30F = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_VC30F", 13, 13);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_VC9202 = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_VC9202", 14, 14);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_VC30F_SC = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_VC30F_SC", 15, 15);
    public static final BleHardwareHeatrateType CD_HEART_RATE_TYPE_MAX = new BleHardwareHeatrateType("CD_HEART_RATE_TYPE_MAX", 16, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareHeatrateType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareHeatrateType of(int i) {
            BleHardwareHeatrateType bleHardwareHeatrateType;
            BleHardwareHeatrateType[] values = BleHardwareHeatrateType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareHeatrateType = values[i2];
                    if (bleHardwareHeatrateType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareHeatrateType = null;
                    break;
                }
            }
            if (bleHardwareHeatrateType == null) {
                return BleHardwareHeatrateType.CD_HEART_RATE_TYPE_NONE;
            }
            return bleHardwareHeatrateType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareHeatrateType[] $values() {
        return new BleHardwareHeatrateType[]{CD_HEART_RATE_TYPE_NONE, CD_HEART_RATE_TYPE_FAKE, CD_HEART_RATE_TYPE_BD1662, CD_HEART_RATE_TYPE_BD1688, CD_HEART_RATE_TYPE_SC7R31, CD_HEART_RATE_TYPE_PAH8007, CD_HEART_RATE_TYPE_TY3300, CD_HEART_RATE_TYPE_TY3602, CD_HEART_RATE_TYPE_TY3603, CD_HEART_RATE_TYPE_TY3605, CD_HEART_RATE_TYPE_LC09A, CD_HEART_RATE_TYPE_LC11S, CD_HEART_RATE_TYPE_VC32S, CD_HEART_RATE_TYPE_VC30F, CD_HEART_RATE_TYPE_VC9202, CD_HEART_RATE_TYPE_VC30F_SC, CD_HEART_RATE_TYPE_MAX};
    }

    static {
        BleHardwareHeatrateType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareHeatrateType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareHeatrateType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareHeatrateType valueOf(String str) {
        return (BleHardwareHeatrateType) Enum.valueOf(BleHardwareHeatrateType.class, str);
    }

    public static BleHardwareHeatrateType[] values() {
        return (BleHardwareHeatrateType[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }

    @Override // java.lang.Enum
    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("0x%02X_", Arrays.copyOf(new Object[]{Integer.valueOf(this.type)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(name());
        return sb.toString();
    }
}
