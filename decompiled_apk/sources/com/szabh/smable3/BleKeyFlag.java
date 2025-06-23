package com.szabh.smable3;

import OXOo.OOXIXo;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpDelete;
import java.util.Arrays;
import kotlin.enums.I0Io;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class BleKeyFlag {
    private static final /* synthetic */ kotlin.enums.oIX0oI $ENTRIES;
    private static final /* synthetic */ BleKeyFlag[] $VALUES;

    @OOXIXo
    public static final oIX0oI Companion;
    private final int mBleKeyFlag;
    public static final BleKeyFlag UPDATE = new BleKeyFlag("UPDATE", 0, 0);
    public static final BleKeyFlag READ = new BleKeyFlag("READ", 1, 16);
    public static final BleKeyFlag READ_CONTINUE = new BleKeyFlag("READ_CONTINUE", 2, 17);
    public static final BleKeyFlag CREATE = new BleKeyFlag("CREATE", 3, 32);
    public static final BleKeyFlag DELETE = new BleKeyFlag(HttpDelete.METHOD_NAME, 4, 48);
    public static final BleKeyFlag RESET = new BleKeyFlag("RESET", 5, 64);
    public static final BleKeyFlag NONE = new BleKeyFlag("NONE", 6, 255);

    @XX({"SMAP\nBleCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleCommand.kt\ncom/szabh/smable3/BleKeyFlag$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,394:1\n1#2:395\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class oIX0oI {
        public /* synthetic */ oIX0oI(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final BleKeyFlag oIX0oI(int i) {
            BleKeyFlag bleKeyFlag;
            BleKeyFlag[] values = BleKeyFlag.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    bleKeyFlag = values[i2];
                    if (bleKeyFlag.getMBleKeyFlag() == i) {
                        break;
                    }
                    i2++;
                } else {
                    bleKeyFlag = null;
                    break;
                }
            }
            if (bleKeyFlag == null) {
                return BleKeyFlag.NONE;
            }
            return bleKeyFlag;
        }

        public oIX0oI() {
        }
    }

    private static final /* synthetic */ BleKeyFlag[] $values() {
        return new BleKeyFlag[]{UPDATE, READ, READ_CONTINUE, CREATE, DELETE, RESET, NONE};
    }

    static {
        BleKeyFlag[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new oIX0oI(null);
    }

    private BleKeyFlag(String str, int i, int i2) {
        this.mBleKeyFlag = i2;
    }

    @OOXIXo
    public static kotlin.enums.oIX0oI<BleKeyFlag> getEntries() {
        return $ENTRIES;
    }

    public static BleKeyFlag valueOf(String str) {
        return (BleKeyFlag) Enum.valueOf(BleKeyFlag.class, str);
    }

    public static BleKeyFlag[] values() {
        return (BleKeyFlag[]) $VALUES.clone();
    }

    public final int getMBleKeyFlag() {
        return this.mBleKeyFlag;
    }

    @Override // java.lang.Enum
    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("0x%02X_", Arrays.copyOf(new Object[]{Integer.valueOf(this.mBleKeyFlag)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(name());
        return sb.toString();
    }
}
