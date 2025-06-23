package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import com.blankj.utilcode.constant.PermissionConstants;
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
public final class FactoryTestType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ FactoryTestType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final FactoryTestType RESULT = new FactoryTestType("RESULT", 0, 0);
    public static final FactoryTestType FIRMWARE_VERSION = new FactoryTestType("FIRMWARE_VERSION", 1, 1);
    public static final FactoryTestType UI_VERSION = new FactoryTestType("UI_VERSION", 2, 2);
    public static final FactoryTestType BATTERY_POWER = new FactoryTestType("BATTERY_POWER", 3, 3);
    public static final FactoryTestType GSENSOR = new FactoryTestType("GSENSOR", 4, 4);
    public static final FactoryTestType TP = new FactoryTestType("TP", 5, 5);
    public static final FactoryTestType KEY = new FactoryTestType("KEY", 6, 6);
    public static final FactoryTestType MOTOR = new FactoryTestType("MOTOR", 7, 7);
    public static final FactoryTestType SPEAKER = new FactoryTestType("SPEAKER", 8, 8);
    public static final FactoryTestType MICROPHONE = new FactoryTestType(PermissionConstants.MICROPHONE, 9, 9);
    public static final FactoryTestType HR_LEAK = new FactoryTestType("HR_LEAK", 10, 10);
    public static final FactoryTestType HR_PS = new FactoryTestType("HR_PS", 11, 11);
    public static final FactoryTestType HR_BIO = new FactoryTestType("HR_BIO", 12, 12);
    public static final FactoryTestType BIO_CALC = new FactoryTestType("BIO_CALC", 13, 13);
    public static final FactoryTestType FLASH = new FactoryTestType("FLASH", 14, 14);
    public static final FactoryTestType SD = new FactoryTestType("SD", 15, 15);
    public static final FactoryTestType TEMPERATURE = new FactoryTestType("TEMPERATURE", 16, 16);
    public static final FactoryTestType MAGNETIC_SENSOR = new FactoryTestType("MAGNETIC_SENSOR", 17, 17);
    public static final FactoryTestType TUYA_INFO = new FactoryTestType("TUYA_INFO", 18, 18);
    public static final FactoryTestType RSSI_RESULT = new FactoryTestType("RSSI_RESULT", 19, 19);
    public static final FactoryTestType HARDWARE = new FactoryTestType("HARDWARE", 20, 20);
    public static final FactoryTestType BLE_NAME = new FactoryTestType("BLE_NAME", 21, 21);
    public static final FactoryTestType GOMORE_INFO = new FactoryTestType("GOMORE_INFO", 22, 22);
    public static final FactoryTestType HR_VALUE = new FactoryTestType("HR_VALUE", 23, 23);
    public static final FactoryTestType HARDWARE_ALIPAY = new FactoryTestType("HARDWARE_ALIPAY", 24, 24);
    public static final FactoryTestType AIR_ALTITUDE_CALIBRATION = new FactoryTestType("AIR_ALTITUDE_CALIBRATION", 25, 25);
    public static final FactoryTestType VOLTAGE = new FactoryTestType("VOLTAGE", 26, 26);
    public static final FactoryTestType ENTER = new FactoryTestType("ENTER", 27, 128);
    public static final FactoryTestType QUIT = new FactoryTestType("QUIT", 28, 129);
    public static final FactoryTestType AGEING = new FactoryTestType("AGEING", 29, 130);
    public static final FactoryTestType EXIT = new FactoryTestType("EXIT", 30, 131);
    public static final FactoryTestType TEST_FAILED = new FactoryTestType("TEST_FAILED", 31, 132);
    public static final FactoryTestType TEST_RESET = new FactoryTestType("TEST_RESET", 32, 133);
    public static final FactoryTestType STEWING = new FactoryTestType("STEWING", 33, 134);
    public static final FactoryTestType STEWING_RESULT = new FactoryTestType("STEWING_RESULT", 34, 135);
    public static final FactoryTestType HARDWARE_INFO = new FactoryTestType("HARDWARE_INFO", 35, 136);
    public static final FactoryTestType LIGHT_SWITCH = new FactoryTestType("LIGHT_SWITCH", 36, 137);
    public static final FactoryTestType RESET_OFF_FLAG = new FactoryTestType("RESET_OFF_FLAG", 37, 144);
    public static final FactoryTestType CHECK_MAC = new FactoryTestType("CHECK_MAC", 38, 240);
    public static final FactoryTestType NONE = new FactoryTestType("NONE", 39, 65535);

    @XX({"SMAP\nBleFactoryTest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleFactoryTest.kt\ncom/szabh/smable3/entity/FactoryTestType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,342:1\n1#2:343\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final FactoryTestType of(int i) {
            FactoryTestType factoryTestType;
            FactoryTestType[] values = FactoryTestType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    factoryTestType = values[i2];
                    if (factoryTestType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    factoryTestType = null;
                    break;
                }
            }
            if (factoryTestType == null) {
                return FactoryTestType.NONE;
            }
            return factoryTestType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FactoryTestType[] $values() {
        return new FactoryTestType[]{RESULT, FIRMWARE_VERSION, UI_VERSION, BATTERY_POWER, GSENSOR, TP, KEY, MOTOR, SPEAKER, MICROPHONE, HR_LEAK, HR_PS, HR_BIO, BIO_CALC, FLASH, SD, TEMPERATURE, MAGNETIC_SENSOR, TUYA_INFO, RSSI_RESULT, HARDWARE, BLE_NAME, GOMORE_INFO, HR_VALUE, HARDWARE_ALIPAY, AIR_ALTITUDE_CALIBRATION, VOLTAGE, ENTER, QUIT, AGEING, EXIT, TEST_FAILED, TEST_RESET, STEWING, STEWING_RESULT, HARDWARE_INFO, LIGHT_SWITCH, RESET_OFF_FLAG, CHECK_MAC, NONE};
    }

    static {
        FactoryTestType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private FactoryTestType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<FactoryTestType> getEntries() {
        return $ENTRIES;
    }

    public static FactoryTestType valueOf(String str) {
        return (FactoryTestType) Enum.valueOf(FactoryTestType.class, str);
    }

    public static FactoryTestType[] values() {
        return (FactoryTestType[]) $VALUES.clone();
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
