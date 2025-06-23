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
public final class BleHardwareLCDType implements BleHardwareType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareLCDType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareLCDType CD_LCD_TYPE_NONE = new BleHardwareLCDType("CD_LCD_TYPE_NONE", 0, 0);
    public static final BleHardwareLCDType CD_LCD_TYPE_AXS15231 = new BleHardwareLCDType("CD_LCD_TYPE_AXS15231", 1, 1);
    public static final BleHardwareLCDType CD_LCD_TYPE_CH13613 = new BleHardwareLCDType("CD_LCD_TYPE_CH13613", 2, 2);
    public static final BleHardwareLCDType CD_LCD_TYPE_ER76288A = new BleHardwareLCDType("CD_LCD_TYPE_ER76288A", 3, 3);
    public static final BleHardwareLCDType CD_LCD_TYPE_NA3311 = new BleHardwareLCDType("CD_LCD_TYPE_NA3311", 4, 4);
    public static final BleHardwareLCDType CD_LCD_TYPE_RM690C = new BleHardwareLCDType("CD_LCD_TYPE_RM690C", 5, 5);
    public static final BleHardwareLCDType CD_LCD_TYPE_RM69092 = new BleHardwareLCDType("CD_LCD_TYPE_RM69092", 6, 6);
    public static final BleHardwareLCDType CD_LCD_TYPE_SH8501 = new BleHardwareLCDType("CD_LCD_TYPE_SH8501", 7, 7);
    public static final BleHardwareLCDType CD_LCD_TYPE_SPD2012 = new BleHardwareLCDType("CD_LCD_TYPE_SPD2012", 8, 8);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST7388 = new BleHardwareLCDType("CD_LCD_TYPE_ST7388", 9, 9);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST77903 = new BleHardwareLCDType("CD_LCD_TYPE_ST77903", 10, 10);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST77916 = new BleHardwareLCDType("CD_LCD_TYPE_ST77916", 11, 11);
    public static final BleHardwareLCDType CD_LCD_TYPE_C05300 = new BleHardwareLCDType("CD_LCD_TYPE_C05300", 12, 12);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST9851 = new BleHardwareLCDType("CD_LCD_TYPE_ST9851", 13, 13);
    public static final BleHardwareLCDType CD_LCD_TYPE_GC9A01 = new BleHardwareLCDType("CD_LCD_TYPE_GC9A01", 14, 14);
    public static final BleHardwareLCDType CD_LCD_TYPE_GC9B71 = new BleHardwareLCDType("CD_LCD_TYPE_GC9B71", 15, 15);
    public static final BleHardwareLCDType CD_LCD_TYPE_GC9C01 = new BleHardwareLCDType("CD_LCD_TYPE_GC9C01", 16, 16);
    public static final BleHardwareLCDType CD_LCD_TYPE_GC9307 = new BleHardwareLCDType("CD_LCD_TYPE_GC9307", 17, 17);
    public static final BleHardwareLCDType CD_LCD_TYPE_ILI8688F = new BleHardwareLCDType("CD_LCD_TYPE_ILI8688F", 18, 18);
    public static final BleHardwareLCDType CD_LCD_TYPE_WEA2012 = new BleHardwareLCDType("CD_LCD_TYPE_WEA2012", 19, 19);
    public static final BleHardwareLCDType CD_LCD_TYPE_NV3002 = new BleHardwareLCDType("CD_LCD_TYPE_NV3002", 20, 20);
    public static final BleHardwareLCDType CD_LCD_TYPE_NV3002B = new BleHardwareLCDType("CD_LCD_TYPE_NV3002B", 21, 21);
    public static final BleHardwareLCDType CD_LCD_TYPE_NV3029S = new BleHardwareLCDType("CD_LCD_TYPE_NV3029S", 22, 22);
    public static final BleHardwareLCDType CD_LCD_TYPE_NV3030B = new BleHardwareLCDType("CD_LCD_TYPE_NV3030B", 23, 23);
    public static final BleHardwareLCDType CD_LCD_TYPE_NV3310 = new BleHardwareLCDType("CD_LCD_TYPE_NV3310", 24, 24);
    public static final BleHardwareLCDType CD_LCD_TYPE_RM69330 = new BleHardwareLCDType("CD_LCD_TYPE_RM69330", 25, 25);
    public static final BleHardwareLCDType CD_LCD_TYPE_SH8601A = new BleHardwareLCDType("CD_LCD_TYPE_SH8601A", 26, 26);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST7789 = new BleHardwareLCDType("CD_LCD_TYPE_ST7789", 27, 27);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST7789W3 = new BleHardwareLCDType("CD_LCD_TYPE_ST7789W3", 28, 28);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST7789V = new BleHardwareLCDType("CD_LCD_TYPE_ST7789V", 29, 29);
    public static final BleHardwareLCDType CD_LCD_TYPE_XM80240G = new BleHardwareLCDType("CD_LCD_TYPE_XM80240G", 30, 30);
    public static final BleHardwareLCDType CD_LCD_TYPE_JD5858 = new BleHardwareLCDType("CD_LCD_TYPE_JD5858", 31, 31);
    public static final BleHardwareLCDType CD_LCD_TYPE_ST9853 = new BleHardwareLCDType("CD_LCD_TYPE_ST9853", 32, 32);
    public static final BleHardwareLCDType CD_LCD_TYPE_MAX = new BleHardwareLCDType("CD_LCD_TYPE_MAX", 33, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareLCDType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareLCDType of(int i) {
            BleHardwareLCDType bleHardwareLCDType;
            BleHardwareLCDType[] values = BleHardwareLCDType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareLCDType = values[i2];
                    if (bleHardwareLCDType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareLCDType = null;
                    break;
                }
            }
            if (bleHardwareLCDType == null) {
                return BleHardwareLCDType.CD_LCD_TYPE_NONE;
            }
            return bleHardwareLCDType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareLCDType[] $values() {
        return new BleHardwareLCDType[]{CD_LCD_TYPE_NONE, CD_LCD_TYPE_AXS15231, CD_LCD_TYPE_CH13613, CD_LCD_TYPE_ER76288A, CD_LCD_TYPE_NA3311, CD_LCD_TYPE_RM690C, CD_LCD_TYPE_RM69092, CD_LCD_TYPE_SH8501, CD_LCD_TYPE_SPD2012, CD_LCD_TYPE_ST7388, CD_LCD_TYPE_ST77903, CD_LCD_TYPE_ST77916, CD_LCD_TYPE_C05300, CD_LCD_TYPE_ST9851, CD_LCD_TYPE_GC9A01, CD_LCD_TYPE_GC9B71, CD_LCD_TYPE_GC9C01, CD_LCD_TYPE_GC9307, CD_LCD_TYPE_ILI8688F, CD_LCD_TYPE_WEA2012, CD_LCD_TYPE_NV3002, CD_LCD_TYPE_NV3002B, CD_LCD_TYPE_NV3029S, CD_LCD_TYPE_NV3030B, CD_LCD_TYPE_NV3310, CD_LCD_TYPE_RM69330, CD_LCD_TYPE_SH8601A, CD_LCD_TYPE_ST7789, CD_LCD_TYPE_ST7789W3, CD_LCD_TYPE_ST7789V, CD_LCD_TYPE_XM80240G, CD_LCD_TYPE_JD5858, CD_LCD_TYPE_ST9853, CD_LCD_TYPE_MAX};
    }

    static {
        BleHardwareLCDType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareLCDType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareLCDType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareLCDType valueOf(String str) {
        return (BleHardwareLCDType) Enum.valueOf(BleHardwareLCDType.class, str);
    }

    public static BleHardwareLCDType[] values() {
        return (BleHardwareLCDType[]) $VALUES.clone();
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
