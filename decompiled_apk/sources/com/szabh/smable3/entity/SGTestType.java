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
public final class SGTestType {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ SGTestType[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final int type;
    public static final SGTestType MUISC_PLAY_PAUSE = new SGTestType("MUISC_PLAY_PAUSE", 0, 1);
    public static final SGTestType ADJUST_VOLUME = new SGTestType("ADJUST_VOLUME", 1, 2);
    public static final SGTestType MUCIC_NEXT = new SGTestType("MUCIC_NEXT", 2, 3);
    public static final SGTestType TAKE_PHOTO = new SGTestType("TAKE_PHOTO", 3, 4);
    public static final SGTestType RECORD_START = new SGTestType("RECORD_START", 4, 5);
    public static final SGTestType RECORD_STOP = new SGTestType("RECORD_STOP", 5, 6);
    public static final SGTestType AI_VOICE_ASSISTANT = new SGTestType("AI_VOICE_ASSISTANT", 6, 7);
    public static final SGTestType ENTER = new SGTestType("ENTER", 7, 128);
    public static final SGTestType QUIT = new SGTestType("QUIT", 8, 129);
    public static final SGTestType NONE = new SGTestType("NONE", 9, 65535);

    @XX({"SMAP\nBleSGTest.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleSGTest.kt\ncom/szabh/smable3/entity/SGTestType$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final SGTestType of(int i) {
            SGTestType sGTestType;
            SGTestType[] values = SGTestType.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    sGTestType = values[i2];
                    if (sGTestType.getType() == i) {
                        break;
                    }
                    i2++;
                } else {
                    sGTestType = null;
                    break;
                }
            }
            if (sGTestType == null) {
                return SGTestType.NONE;
            }
            return sGTestType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SGTestType[] $values() {
        return new SGTestType[]{MUISC_PLAY_PAUSE, ADJUST_VOLUME, MUCIC_NEXT, TAKE_PHOTO, RECORD_START, RECORD_STOP, AI_VOICE_ASSISTANT, ENTER, QUIT, NONE};
    }

    static {
        SGTestType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private SGTestType(String str, int i, int i2) {
        this.type = i2;
    }

    @OOXIXo
    public static oIX0oI<SGTestType> getEntries() {
        return $ENTRIES;
    }

    public static SGTestType valueOf(String str) {
        return (SGTestType) Enum.valueOf(SGTestType.class, str);
    }

    public static SGTestType[] values() {
        return (SGTestType[]) $VALUES.clone();
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
