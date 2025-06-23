package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class MusicAttr {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ MusicAttr[] $VALUES;

    @OOXIXo
    public static final Companion Companion;
    private final byte mAttr;
    public static final MusicAttr PLAYER_NAME = new MusicAttr("PLAYER_NAME", 0, (byte) 0);
    public static final MusicAttr PLAYER_PLAYBACK_INFO = new MusicAttr("PLAYER_PLAYBACK_INFO", 1, (byte) 1);
    public static final MusicAttr PLAYER_VOLUME = new MusicAttr("PLAYER_VOLUME", 2, (byte) 2);
    public static final MusicAttr QUEUE_INDEX = new MusicAttr("QUEUE_INDEX", 3, (byte) 0);
    public static final MusicAttr QUEUE_COUNT = new MusicAttr("QUEUE_COUNT", 4, (byte) 1);
    public static final MusicAttr QUEUE_SHUFFLE_MODE = new MusicAttr("QUEUE_SHUFFLE_MODE", 5, (byte) 2);
    public static final MusicAttr QUEUE_REPEAT_MODE = new MusicAttr("QUEUE_REPEAT_MODE", 6, (byte) 3);
    public static final MusicAttr TRACK_ARTIST = new MusicAttr("TRACK_ARTIST", 7, (byte) 0);
    public static final MusicAttr TRACK_ALBUM = new MusicAttr("TRACK_ALBUM", 8, (byte) 1);
    public static final MusicAttr TRACK_TITLE = new MusicAttr("TRACK_TITLE", 9, (byte) 2);
    public static final MusicAttr TRACK_DURATION = new MusicAttr("TRACK_DURATION", 10, (byte) 3);
    public static final MusicAttr UNKNOWN = new MusicAttr("UNKNOWN", 11, (byte) -1);

    /* loaded from: classes13.dex */
    public static final class Companion {

        /* loaded from: classes13.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MusicEntity.values().length];
                try {
                    iArr[MusicEntity.PLAYER.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[MusicEntity.QUEUE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[MusicEntity.TRACK.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(IIXOooo iIXOooo) {
            this();
        }

        @OOXIXo
        public final MusicAttr of(@OOXIXo MusicEntity entity, byte b) {
            IIX0o.x0xO0oo(entity, "entity");
            int i = WhenMappings.$EnumSwitchMapping$0[entity.ordinal()];
            if (i == 1) {
                if (b == 0) {
                    return MusicAttr.PLAYER_NAME;
                }
                if (b == 1) {
                    return MusicAttr.PLAYER_PLAYBACK_INFO;
                }
                if (b == 2) {
                    return MusicAttr.PLAYER_VOLUME;
                }
                return MusicAttr.UNKNOWN;
            }
            if (i == 2) {
                if (b == 0) {
                    return MusicAttr.QUEUE_INDEX;
                }
                if (b == 1) {
                    return MusicAttr.QUEUE_COUNT;
                }
                if (b == 2) {
                    return MusicAttr.QUEUE_SHUFFLE_MODE;
                }
                if (b == 3) {
                    return MusicAttr.QUEUE_REPEAT_MODE;
                }
                return MusicAttr.UNKNOWN;
            }
            if (i != 3) {
                return MusicAttr.UNKNOWN;
            }
            if (b == 0) {
                return MusicAttr.TRACK_ARTIST;
            }
            if (b == 1) {
                return MusicAttr.TRACK_ALBUM;
            }
            if (b == 2) {
                return MusicAttr.TRACK_TITLE;
            }
            if (b == 3) {
                return MusicAttr.TRACK_DURATION;
            }
            return MusicAttr.UNKNOWN;
        }

        private Companion() {
        }

        @OOXIXo
        public final MusicAttr of(byte b, byte b2) {
            return of(MusicEntity.Companion.of(b), b2);
        }
    }

    private static final /* synthetic */ MusicAttr[] $values() {
        return new MusicAttr[]{PLAYER_NAME, PLAYER_PLAYBACK_INFO, PLAYER_VOLUME, QUEUE_INDEX, QUEUE_COUNT, QUEUE_SHUFFLE_MODE, QUEUE_REPEAT_MODE, TRACK_ARTIST, TRACK_ALBUM, TRACK_TITLE, TRACK_DURATION, UNKNOWN};
    }

    static {
        MusicAttr[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
        Companion = new Companion(null);
    }

    private MusicAttr(String str, int i, byte b) {
        this.mAttr = b;
    }

    @OOXIXo
    public static oIX0oI<MusicAttr> getEntries() {
        return $ENTRIES;
    }

    public static MusicAttr valueOf(String str) {
        return (MusicAttr) Enum.valueOf(MusicAttr.class, str);
    }

    public static MusicAttr[] values() {
        return (MusicAttr[]) $VALUES.clone();
    }

    public final byte getMAttr() {
        return this.mAttr;
    }
}
