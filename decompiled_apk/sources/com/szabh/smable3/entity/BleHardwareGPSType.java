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
public final class BleHardwareGPSType implements BleHardwareType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareGPSType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareGPSType CD_GPS_TYPE_NONE = new BleHardwareGPSType("CD_GPS_TYPE_NONE", 0, 0);
    public static final BleHardwareGPSType CD_GPS_TYPE_BCM4775 = new BleHardwareGPSType("CD_GPS_TYPE_BCM4775", 1, 1);
    public static final BleHardwareGPSType CD_GPS_TYPE_UC6228 = new BleHardwareGPSType("CD_GPS_TYPE_UC6228", 2, 2);
    public static final BleHardwareGPSType CD_GPS_TYPE_CC1165W = new BleHardwareGPSType("CD_GPS_TYPE_CC1165W", 3, 3);
    public static final BleHardwareGPSType CD_GPS_TYPE_MAX = new BleHardwareGPSType("CD_GPS_TYPE_MAX", 4, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareGPSType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareGPSType of(int i) {
            BleHardwareGPSType bleHardwareGPSType;
            BleHardwareGPSType[] values = BleHardwareGPSType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareGPSType = values[i2];
                    if (bleHardwareGPSType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareGPSType = null;
                    break;
                }
            }
            if (bleHardwareGPSType == null) {
                return BleHardwareGPSType.CD_GPS_TYPE_NONE;
            }
            return bleHardwareGPSType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareGPSType[] $values() {
        return new BleHardwareGPSType[]{CD_GPS_TYPE_NONE, CD_GPS_TYPE_BCM4775, CD_GPS_TYPE_UC6228, CD_GPS_TYPE_CC1165W, CD_GPS_TYPE_MAX};
    }

    static {
        BleHardwareGPSType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareGPSType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareGPSType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareGPSType valueOf(String str) {
        return (BleHardwareGPSType) Enum.valueOf(BleHardwareGPSType.class, str);
    }

    public static BleHardwareGPSType[] values() {
        return (BleHardwareGPSType[]) $VALUES.clone();
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
