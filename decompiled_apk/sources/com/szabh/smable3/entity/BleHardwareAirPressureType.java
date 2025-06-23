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
public final class BleHardwareAirPressureType implements BleHardwareType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareAirPressureType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareAirPressureType CD_AIR_PRESSURE_TYPE_NONE = new BleHardwareAirPressureType("CD_AIR_PRESSURE_TYPE_NONE", 0, 0);
    public static final BleHardwareAirPressureType CD_AIR_PRESSURE_TYPE_SPL06 = new BleHardwareAirPressureType("CD_AIR_PRESSURE_TYPE_SPL06", 1, 1);
    public static final BleHardwareAirPressureType CD_AIR_PRESSURE_TYPE_AIR3535R = new BleHardwareAirPressureType("CD_AIR_PRESSURE_TYPE_AIR3535R", 2, 2);
    public static final BleHardwareAirPressureType CD_AIR_PRESSURE_TYPE_BMP280 = new BleHardwareAirPressureType("CD_AIR_PRESSURE_TYPE_BMP280", 3, 3);
    public static final BleHardwareAirPressureType CD_AIR_PRESSURE_TYPE_MAX = new BleHardwareAirPressureType("CD_AIR_PRESSURE_TYPE_MAX", 4, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareAirPressureType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareAirPressureType of(int i) {
            BleHardwareAirPressureType bleHardwareAirPressureType;
            BleHardwareAirPressureType[] values = BleHardwareAirPressureType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareAirPressureType = values[i2];
                    if (bleHardwareAirPressureType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareAirPressureType = null;
                    break;
                }
            }
            if (bleHardwareAirPressureType == null) {
                return BleHardwareAirPressureType.CD_AIR_PRESSURE_TYPE_NONE;
            }
            return bleHardwareAirPressureType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareAirPressureType[] $values() {
        return new BleHardwareAirPressureType[]{CD_AIR_PRESSURE_TYPE_NONE, CD_AIR_PRESSURE_TYPE_SPL06, CD_AIR_PRESSURE_TYPE_AIR3535R, CD_AIR_PRESSURE_TYPE_BMP280, CD_AIR_PRESSURE_TYPE_MAX};
    }

    static {
        BleHardwareAirPressureType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareAirPressureType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareAirPressureType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareAirPressureType valueOf(String str) {
        return (BleHardwareAirPressureType) Enum.valueOf(BleHardwareAirPressureType.class, str);
    }

    public static BleHardwareAirPressureType[] values() {
        return (BleHardwareAirPressureType[]) $VALUES.clone();
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
