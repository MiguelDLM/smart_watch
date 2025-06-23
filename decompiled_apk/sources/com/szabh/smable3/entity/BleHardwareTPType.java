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
public final class BleHardwareTPType implements BleHardwareType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleHardwareTPType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final BleHardwareTPType CD_TP_TYPE_NONE = new BleHardwareTPType("CD_TP_TYPE_NONE", 0, 0);
    public static final BleHardwareTPType CD_TP_TYPE_CST816 = new BleHardwareTPType("CD_TP_TYPE_CST816", 1, 1);
    public static final BleHardwareTPType CD_TP_TYPE_FT6336G = new BleHardwareTPType("CD_TP_TYPE_FT6336G", 2, 2);
    public static final BleHardwareTPType CD_TP_TYPE_BL6133 = new BleHardwareTPType("CD_TP_TYPE_BL6133", 3, 3);
    public static final BleHardwareTPType CD_TP_TYPE_CHS5816 = new BleHardwareTPType("CD_TP_TYPE_CHS5816", 4, 4);
    public static final BleHardwareTPType CD_TP_TYPE_SPD2010 = new BleHardwareTPType("CD_TP_TYPE_SPD2010", 5, 5);
    public static final BleHardwareTPType CD_TP_TYPE_CHSC6X = new BleHardwareTPType("CD_TP_TYPE_CHSC6X", 6, 6);
    public static final BleHardwareTPType CD_TP_TYPE_CF1133 = new BleHardwareTPType("CD_TP_TYPE_CF1133", 7, 7);
    public static final BleHardwareTPType CD_TP_TYPE_AXS5106L = new BleHardwareTPType("CD_TP_TYPE_AXS5106L", 8, 8);
    public static final BleHardwareTPType CD_TP_TYPE_AXS1523 = new BleHardwareTPType("CD_TP_TYPE_AXS1523", 9, 9);
    public static final BleHardwareTPType CD_TP_TYPE_CST92XX = new BleHardwareTPType("CD_TP_TYPE_CST92XX", 10, 10);
    public static final BleHardwareTPType CD_TP_TYPE_MAX = new BleHardwareTPType("CD_TP_TYPE_MAX", 11, 255);

    @XX({"SMAP\nBleHardwareInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleHardwareInfo.kt\ncom/szabh/smable3/entity/BleHardwareTPType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,303:1\n1#2:304\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleHardwareTPType of(int i) {
            BleHardwareTPType bleHardwareTPType;
            BleHardwareTPType[] values = BleHardwareTPType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleHardwareTPType = values[i2];
                    if (bleHardwareTPType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleHardwareTPType = null;
                    break;
                }
            }
            if (bleHardwareTPType == null) {
                return BleHardwareTPType.CD_TP_TYPE_NONE;
            }
            return bleHardwareTPType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ BleHardwareTPType[] $values() {
        return new BleHardwareTPType[]{CD_TP_TYPE_NONE, CD_TP_TYPE_CST816, CD_TP_TYPE_FT6336G, CD_TP_TYPE_BL6133, CD_TP_TYPE_CHS5816, CD_TP_TYPE_SPD2010, CD_TP_TYPE_CHSC6X, CD_TP_TYPE_CF1133, CD_TP_TYPE_AXS5106L, CD_TP_TYPE_AXS1523, CD_TP_TYPE_CST92XX, CD_TP_TYPE_MAX};
    }

    static {
        BleHardwareTPType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private BleHardwareTPType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<BleHardwareTPType> getEntries() {
        return $ENTRIES;
    }

    public static BleHardwareTPType valueOf(String str) {
        return (BleHardwareTPType) Enum.valueOf(BleHardwareTPType.class, str);
    }

    public static BleHardwareTPType[] values() {
        return (BleHardwareTPType[]) $VALUES.clone();
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
