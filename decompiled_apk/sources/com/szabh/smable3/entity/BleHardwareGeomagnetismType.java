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
public final class BleHardwareGeomagnetismType implements BleHardwareType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareGeomagnetismType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareGeomagnetismType CD_GEOMAGNETISM_TYPE_NONE = new BleHardwareGeomagnetismType("CD_GEOMAGNETISM_TYPE_NONE", 0, 0);
    public static final BleHardwareGeomagnetismType CD_GEOMAGNETISM_TYPE_MMC5603 = new BleHardwareGeomagnetismType("CD_GEOMAGNETISM_TYPE_MMC5603", 1, 1);
    public static final BleHardwareGeomagnetismType CD_GEOMAGNETISM_TYPE_AF8133J = new BleHardwareGeomagnetismType("CD_GEOMAGNETISM_TYPE_AF8133J", 2, 2);
    public static final BleHardwareGeomagnetismType CD_GEOMAGNETISM_TYPE_QMC6309 = new BleHardwareGeomagnetismType("CD_GEOMAGNETISM_TYPE_QMC6309", 3, 3);
    public static final BleHardwareGeomagnetismType CD_GEOMAGNETISM_TYPE_MAX = new BleHardwareGeomagnetismType("CD_GEOMAGNETISM_TYPE_MAX", 4, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareGeomagnetismType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareGeomagnetismType of(int i) {
            BleHardwareGeomagnetismType bleHardwareGeomagnetismType;
            BleHardwareGeomagnetismType[] values = BleHardwareGeomagnetismType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareGeomagnetismType = values[i2];
                    if (bleHardwareGeomagnetismType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareGeomagnetismType = null;
                    break;
                }
            }
            if (bleHardwareGeomagnetismType == null) {
                return BleHardwareGeomagnetismType.CD_GEOMAGNETISM_TYPE_NONE;
            }
            return bleHardwareGeomagnetismType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareGeomagnetismType[] $values() {
        return new BleHardwareGeomagnetismType[]{CD_GEOMAGNETISM_TYPE_NONE, CD_GEOMAGNETISM_TYPE_MMC5603, CD_GEOMAGNETISM_TYPE_AF8133J, CD_GEOMAGNETISM_TYPE_QMC6309, CD_GEOMAGNETISM_TYPE_MAX};
    }

    static {
        BleHardwareGeomagnetismType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareGeomagnetismType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareGeomagnetismType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareGeomagnetismType valueOf(String str) {
        return (BleHardwareGeomagnetismType) Enum.valueOf(BleHardwareGeomagnetismType.class, str);
    }

    public static BleHardwareGeomagnetismType[] values() {
        return (BleHardwareGeomagnetismType[]) $VALUES.clone();
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
