package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class PlayPayload extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final AudioItem audioItem;

    public PlayPayload(@OOXIXo AudioItem audioItem) {
        IIX0o.x0xO0oo(audioItem, "audioItem");
        this.audioItem = audioItem;
    }

    public static /* synthetic */ PlayPayload copy$default(PlayPayload playPayload, AudioItem audioItem, int i, Object obj) {
        if ((i & 1) != 0) {
            audioItem = playPayload.audioItem;
        }
        return playPayload.copy(audioItem);
    }

    @OOXIXo
    public final AudioItem component1() {
        return this.audioItem;
    }

    @OOXIXo
    public final PlayPayload copy(@OOXIXo AudioItem audioItem) {
        IIX0o.x0xO0oo(audioItem, "audioItem");
        return new PlayPayload(audioItem);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PlayPayload) && IIX0o.Oxx0IOOO(this.audioItem, ((PlayPayload) obj).audioItem);
    }

    @OOXIXo
    public final AudioItem getAudioItem() {
        return this.audioItem;
    }

    public int hashCode() {
        return this.audioItem.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "PlayPayload(audioItem=" + this.audioItem + HexStringBuilder.COMMENT_END_CHAR;
    }
}
