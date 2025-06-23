package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AudioItem extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final Stream stream;

    public AudioItem(@OOXIXo Stream stream) {
        IIX0o.x0xO0oo(stream, "stream");
        this.stream = stream;
    }

    public static /* synthetic */ AudioItem copy$default(AudioItem audioItem, Stream stream, int i, Object obj) {
        if ((i & 1) != 0) {
            stream = audioItem.stream;
        }
        return audioItem.copy(stream);
    }

    @OOXIXo
    public final Stream component1() {
        return this.stream;
    }

    @OOXIXo
    public final AudioItem copy(@OOXIXo Stream stream) {
        IIX0o.x0xO0oo(stream, "stream");
        return new AudioItem(stream);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AudioItem) && IIX0o.Oxx0IOOO(this.stream, ((AudioItem) obj).stream);
    }

    @OOXIXo
    public final Stream getStream() {
        return this.stream;
    }

    public int hashCode() {
        return this.stream.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "AudioItem(stream=" + this.stream + HexStringBuilder.COMMENT_END_CHAR;
    }
}
