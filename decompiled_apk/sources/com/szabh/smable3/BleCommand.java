package com.szabh.smable3;

import OXOo.OOXIXo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.XX;
import kotlin.jvm.internal.oxxXoxO;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@XX({"SMAP\nBleCommand.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleCommand.kt\ncom/szabh/smable3/BleCommand\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,394:1\n3792#2:395\n4307#2,2:396\n*S KotlinDebug\n*F\n+ 1 BleCommand.kt\ncom/szabh/smable3/BleCommand\n*L\n15#1:395\n15#1:396,2\n*E\n"})
/* loaded from: classes13.dex */
public final class BleCommand {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ BleCommand[] $VALUES;
    private final int mBleCommand;
    public static final BleCommand UPDATE = new BleCommand("UPDATE", 0, 1);
    public static final BleCommand SET = new BleCommand("SET", 1, 2);
    public static final BleCommand CONNECT = new BleCommand("CONNECT", 2, 3);
    public static final BleCommand PUSH = new BleCommand("PUSH", 3, 4);
    public static final BleCommand DATA = new BleCommand("DATA", 4, 5);
    public static final BleCommand CONTROL = new BleCommand("CONTROL", 5, 6);

    /* renamed from: IO, reason: collision with root package name */
    public static final BleCommand f26445IO = new BleCommand("IO", 6, 7);
    public static final BleCommand NONE = new BleCommand("NONE", 7, 255);

    private static final /* synthetic */ BleCommand[] $values() {
        return new BleCommand[]{UPDATE, SET, CONNECT, PUSH, DATA, CONTROL, f26445IO, NONE};
    }

    static {
        BleCommand[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private BleCommand(String str, int i, int i2) {
        this.mBleCommand = i2;
    }

    @OOXIXo
    public static oIX0oI<BleCommand> getEntries() {
        return $ENTRIES;
    }

    public static BleCommand valueOf(String str) {
        return (BleCommand) Enum.valueOf(BleCommand.class, str);
    }

    public static BleCommand[] values() {
        return (BleCommand[]) $VALUES.clone();
    }

    @OOXIXo
    public final List<BleKey> getBleKeys() {
        BleKey[] values = BleKey.values();
        ArrayList arrayList = new ArrayList();
        for (BleKey bleKey : values) {
            if ((bleKey.getMKey() >>> 8) == this.mBleCommand) {
                arrayList.add(bleKey);
            }
        }
        return arrayList;
    }

    public final int getMBleCommand() {
        return this.mBleCommand;
    }

    @Override // java.lang.Enum
    @OOXIXo
    public String toString() {
        StringBuilder sb = new StringBuilder();
        oxxXoxO oxxxoxo = oxxXoxO.f29356oIX0oI;
        String format = String.format("0x%02X_", Arrays.copyOf(new Object[]{Integer.valueOf(this.mBleCommand)}, 1));
        IIX0o.oO(format, "format(...)");
        sb.append(format);
        sb.append(name());
        return sb.toString();
    }
}
