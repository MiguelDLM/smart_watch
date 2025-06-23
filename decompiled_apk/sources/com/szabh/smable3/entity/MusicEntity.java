package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;
import kotlin.jvm.internal.IIXOooo;
import kotlin.jvm.internal.XX;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class MusicEntity {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ MusicEntity[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    public static final MusicEntity PLAYER = new MusicEntity("PLAYER", 0, (byte) 0);
    public static final MusicEntity QUEUE = new MusicEntity("QUEUE", 1, (byte) 1);
    public static final MusicEntity TRACK = new MusicEntity("TRACK", 2, (byte) 2);
    public static final MusicEntity UNKNOWN = new MusicEntity("UNKNOWN", 3, (byte) -1);
    private final byte mEntity;

    @XX({"SMAP\nBleMusicControl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BleMusicControl.kt\ncom/szabh/smable3/entity/MusicEntity$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,117:1\n1#2:118\n*E\n"})
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final MusicEntity of(byte b) {
            MusicEntity musicEntity;
            MusicEntity[] values = MusicEntity.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    musicEntity = values[i];
                    if (musicEntity.getMEntity() == b) {
                        break;
                    }
                    i++;
                } else {
                    musicEntity = null;
                    break;
                }
            }
            if (musicEntity == null) {
                return MusicEntity.UNKNOWN;
            }
            return musicEntity;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ MusicEntity[] $values() {
        return new MusicEntity[]{PLAYER, QUEUE, TRACK, UNKNOWN};
    }

    static {
        MusicEntity[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private MusicEntity(String str, int i, byte b) {
        this.mEntity = b;
    }

    @OOXIXo
    public static oIX0oI<MusicEntity> getEntries() {
        return $ENTRIES;
    }

    public static MusicEntity valueOf(String str) {
        return (MusicEntity) Enum.valueOf(MusicEntity.class, str);
    }

    public static MusicEntity[] values() {
        return (MusicEntity[]) $VALUES.clone();
    }

    public final byte getMEntity() {
        return this.mEntity;
    }
}
