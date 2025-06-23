package com.szabh.smable3.entity;

import OXOo.OOXIXo;
import kotlin.enums.I0Io;
import kotlin.enums.oIX0oI;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes13.dex */
public final class PlaybackState {
    private static final /* synthetic */ oIX0oI $ENTRIES;
    private static final /* synthetic */ PlaybackState[] $VALUES;
    private final byte mState;
    public static final PlaybackState PAUSED = new PlaybackState("PAUSED", 0, (byte) 0);
    public static final PlaybackState PLAYING = new PlaybackState("PLAYING", 1, (byte) 1);
    public static final PlaybackState REWINDING = new PlaybackState("REWINDING", 2, (byte) 2);
    public static final PlaybackState FAST_FORWARDING = new PlaybackState("FAST_FORWARDING", 3, (byte) 3);
    public static final PlaybackState UNKNOWN = new PlaybackState("UNKNOWN", 4, (byte) -1);

    private static final /* synthetic */ PlaybackState[] $values() {
        return new PlaybackState[]{PAUSED, PLAYING, REWINDING, FAST_FORWARDING, UNKNOWN};
    }

    static {
        PlaybackState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = I0Io.I0Io($values);
    }

    private PlaybackState(String str, int i, byte b) {
        this.mState = b;
    }

    @OOXIXo
    public static oIX0oI<PlaybackState> getEntries() {
        return $ENTRIES;
    }

    public static PlaybackState valueOf(String str) {
        return (PlaybackState) Enum.valueOf(PlaybackState.class, str);
    }

    public static PlaybackState[] values() {
        return (PlaybackState[]) $VALUES.clone();
    }

    public final byte getMState() {
        return this.mState;
    }
}
