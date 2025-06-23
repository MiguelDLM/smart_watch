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
public final class BleHardwareGsensorType implements BleHardwareType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareGsensorType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_NONE = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_NONE", 0, 0);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_STK8321 = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_STK8321", 1, 1);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_KX022 = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_KX022", 2, 2);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_SLW7A20 = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_SLW7A20", 3, 3);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_SLW7A20E = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_SLW7A20E", 4, 4);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_SLW7A20H = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_SLW7A20H", 5, 5);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_MSA310 = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_MSA310", 6, 6);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_DA267 = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_DA267", 7, 7);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_QMA6100 = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_QMA6100", 8, 8);
    public static final BleHardwareGsensorType CD_G_SENSOR_TYPE_MAX = new BleHardwareGsensorType("CD_G_SENSOR_TYPE_MAX", 9, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareGsensorType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareGsensorType of(int i) {
            BleHardwareGsensorType bleHardwareGsensorType;
            BleHardwareGsensorType[] values = BleHardwareGsensorType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareGsensorType = values[i2];
                    if (bleHardwareGsensorType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareGsensorType = null;
                    break;
                }
            }
            if (bleHardwareGsensorType == null) {
                return BleHardwareGsensorType.CD_G_SENSOR_TYPE_NONE;
            }
            return bleHardwareGsensorType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareGsensorType[] $values() {
        return new BleHardwareGsensorType[]{CD_G_SENSOR_TYPE_NONE, CD_G_SENSOR_TYPE_STK8321, CD_G_SENSOR_TYPE_KX022, CD_G_SENSOR_TYPE_SLW7A20, CD_G_SENSOR_TYPE_SLW7A20E, CD_G_SENSOR_TYPE_SLW7A20H, CD_G_SENSOR_TYPE_MSA310, CD_G_SENSOR_TYPE_DA267, CD_G_SENSOR_TYPE_QMA6100, CD_G_SENSOR_TYPE_MAX};
    }

    static {
        BleHardwareGsensorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareGsensorType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareGsensorType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareGsensorType valueOf(String str) {
        return (BleHardwareGsensorType) Enum.valueOf(BleHardwareGsensorType.class, str);
    }

    public static BleHardwareGsensorType[] values() {
        return (BleHardwareGsensorType[]) $VALUES.clone();
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
