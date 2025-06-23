package com.sma.smartv3.biz.dcs;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.sma.smartv3.model.JsonFieldContainer;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class DcsTts extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private final String logid;

    @OOXIXo
    private final String text;

    @OOXIXo
    private final String tts_optional;

    public DcsTts(@OOXIXo String logid, @OOXIXo String text, @OOXIXo String tts_optional) {
        IIX0o.x0xO0oo(logid, "logid");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(tts_optional, "tts_optional");
        this.logid = logid;
        this.text = text;
        this.tts_optional = tts_optional;
    }

    public static /* synthetic */ DcsTts copy$default(DcsTts dcsTts, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = dcsTts.logid;
        }
        if ((i & 2) != 0) {
            str2 = dcsTts.text;
        }
        if ((i & 4) != 0) {
            str3 = dcsTts.tts_optional;
        }
        return dcsTts.copy(str, str2, str3);
    }

    @OOXIXo
    public final String component1() {
        return this.logid;
    }

    @OOXIXo
    public final String component2() {
        return this.text;
    }

    @OOXIXo
    public final String component3() {
        return this.tts_optional;
    }

    @OOXIXo
    public final DcsTts copy(@OOXIXo String logid, @OOXIXo String text, @OOXIXo String tts_optional) {
        IIX0o.x0xO0oo(logid, "logid");
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(tts_optional, "tts_optional");
        return new DcsTts(logid, text, tts_optional);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DcsTts)) {
            return false;
        }
        DcsTts dcsTts = (DcsTts) obj;
        return IIX0o.Oxx0IOOO(this.logid, dcsTts.logid) && IIX0o.Oxx0IOOO(this.text, dcsTts.text) && IIX0o.Oxx0IOOO(this.tts_optional, dcsTts.tts_optional);
    }

    @OOXIXo
    public final String getLogid() {
        return this.logid;
    }

    @OOXIXo
    public final String getText() {
        return this.text;
    }

    @OOXIXo
    public final String getTts_optional() {
        return this.tts_optional;
    }

    public int hashCode() {
        return (((this.logid.hashCode() * 31) + this.text.hashCode()) * 31) + this.tts_optional.hashCode();
    }

    @OOXIXo
    public String toString() {
        return "DcsTts(logid=" + this.logid + ", text=" + this.text + ", tts_optional=" + this.tts_optional + HexStringBuilder.COMMENT_END_CHAR;
    }
}
