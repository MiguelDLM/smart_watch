package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class MusicCommand {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ MusicCommand[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final byte mCommand;
    public static final MusicCommand PLAY = new MusicCommand("PLAY", 0, (byte) 0);
    public static final MusicCommand PAUSE = new MusicCommand("PAUSE", 1, (byte) 1);
    public static final MusicCommand TOGGLE = new MusicCommand("TOGGLE", 2, (byte) 2);
    public static final MusicCommand NEXT = new MusicCommand("NEXT", 3, (byte) 3);
    public static final MusicCommand PRE = new MusicCommand("PRE", 4, (byte) 4);
    public static final MusicCommand VOLUME_UP = new MusicCommand("VOLUME_UP", 5, (byte) 5);
    public static final MusicCommand VOLUME_DOWN = new MusicCommand("VOLUME_DOWN", 6, (byte) 6);
    public static final MusicCommand UNKNOWN = new MusicCommand("UNKNOWN", 7, (byte) -1);

    @XX({"SMAP\nBleMusicControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMusicControl.kt\ncom/szabh/smable3/entity/MusicCommand$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final MusicCommand of(byte b) {
            MusicCommand musicCommand;
            MusicCommand[] values = MusicCommand.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    musicCommand = values[i];
                    if (musicCommand.getMCommand() == b) {
                        break;
                    }
                    i++;
                } else {
                    musicCommand = null;
                    break;
                }
            }
            if (musicCommand == null) {
                return MusicCommand.UNKNOWN;
            }
            return musicCommand;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ MusicCommand[] $values() {
        return new MusicCommand[]{PLAY, PAUSE, TOGGLE, NEXT, PRE, VOLUME_UP, VOLUME_DOWN, UNKNOWN};
    }

    static {
        MusicCommand[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private MusicCommand(String str, int i, byte b) {
        this.mCommand = b;
    }

    @OOXIXo
    public static oIX0oI<MusicCommand> getEntries() {
        return $ENTRIES;
    }

    public static MusicCommand valueOf(String str) {
        return (MusicCommand) Enum.valueOf(MusicCommand.class, str);
    }

    public static MusicCommand[] values() {
        return (MusicCommand[]) $VALUES.clone();
    }

    public final byte getMCommand() {
        return this.mCommand;
    }
}
