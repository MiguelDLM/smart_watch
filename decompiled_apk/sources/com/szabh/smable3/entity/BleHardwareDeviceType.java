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
public final class BleHardwareDeviceType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareDeviceType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_NONE = new BleHardwareDeviceType("CD_DEVICE_TYPE_NONE", 0, 0);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_LCD = new BleHardwareDeviceType("CD_DEVICE_TYPE_LCD", 1, 1);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_HEARTRATE = new BleHardwareDeviceType("CD_DEVICE_TYPE_HEARTRATE", 2, 2);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_G_SENSOR = new BleHardwareDeviceType("CD_DEVICE_TYPE_G_SENSOR", 3, 3);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_TP = new BleHardwareDeviceType("CD_DEVICE_TYPE_TP", 4, 4);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_GPS = new BleHardwareDeviceType("CD_DEVICE_TYPE_GPS", 5, 5);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_GEOMAGNETISM = new BleHardwareDeviceType("CD_DEVICE_TYPE_GEOMAGNETISM", 6, 6);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_AIR_PRESSURE = new BleHardwareDeviceType("CD_DEVICE_TYPE_AIR_PRESSURE", 7, 7);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_TEMPERATURE = new BleHardwareDeviceType("CD_DEVICE_TYPE_TEMPERATURE", 8, 8);
    public static final BleHardwareDeviceType CD_DEVICE_TYPE_MAX = new BleHardwareDeviceType("CD_DEVICE_TYPE_MAX", 9, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareDeviceType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareDeviceType of(int i) {
            BleHardwareDeviceType bleHardwareDeviceType;
            BleHardwareDeviceType[] values = BleHardwareDeviceType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareDeviceType = values[i2];
                    if (bleHardwareDeviceType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareDeviceType = null;
                    break;
                }
            }
            if (bleHardwareDeviceType == null) {
                return BleHardwareDeviceType.CD_DEVICE_TYPE_NONE;
            }
            return bleHardwareDeviceType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareDeviceType[] $values() {
        return new BleHardwareDeviceType[]{CD_DEVICE_TYPE_NONE, CD_DEVICE_TYPE_LCD, CD_DEVICE_TYPE_HEARTRATE, CD_DEVICE_TYPE_G_SENSOR, CD_DEVICE_TYPE_TP, CD_DEVICE_TYPE_GPS, CD_DEVICE_TYPE_GEOMAGNETISM, CD_DEVICE_TYPE_AIR_PRESSURE, CD_DEVICE_TYPE_TEMPERATURE, CD_DEVICE_TYPE_MAX};
    }

    static {
        BleHardwareDeviceType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareDeviceType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareDeviceType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareDeviceType valueOf(String str) {
        return (BleHardwareDeviceType) Enum.valueOf(BleHardwareDeviceType.class, str);
    }

    public static BleHardwareDeviceType[] values() {
        return (BleHardwareDeviceType[]) $VALUES.clone();
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
