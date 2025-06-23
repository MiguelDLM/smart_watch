package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AITranslation {

    @OOXIXo
    private String dst;
    private int status;

    @OOXIXo
    private String text;

    public AITranslation() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ AITranslation copy$default(AITranslation aITranslation, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = aITranslation.text;
        }
        if ((i2 & 2) != 0) {
            str2 = aITranslation.dst;
        }
        if ((i2 & 4) != 0) {
            i = aITranslation.status;
        }
        return aITranslation.copy(str, str2, i);
    }

    @OOXIXo
    public final String component1() {
        return this.text;
    }

    @OOXIXo
    public final String component2() {
        return this.dst;
    }

    public final int component3() {
        return this.status;
    }

    @OOXIXo
    public final AITranslation copy(@OOXIXo String text, @OOXIXo String dst, int i) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(dst, "dst");
        return new AITranslation(text, dst, i);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AITranslation)) {
            return false;
        }
        AITranslation aITranslation = (AITranslation) obj;
        return IIX0o.Oxx0IOOO(this.text, aITranslation.text) && IIX0o.Oxx0IOOO(this.dst, aITranslation.dst) && this.status == aITranslation.status;
    }

    @OOXIXo
    public final String getDst() {
        return this.dst;
    }

    public final int getStatus() {
        return this.status;
    }

    @OOXIXo
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        return (((this.text.hashCode() * 31) + this.dst.hashCode()) * 31) + this.status;
    }

    public final void setDst(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.dst = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setText(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.text = str;
    }

    @OOXIXo
    public String toString() {
        return "AITranslation(text=" + this.text + ", dst=" + this.dst + ", status=" + this.status + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AITranslation(@OOXIXo String text, @OOXIXo String dst, int i) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(dst, "dst");
        this.text = text;
        this.dst = dst;
        this.status = i;
    }

    public /* synthetic */ AITranslation(String str, String str2, int i, int i2, IIXOooo iIXOooo) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : i);
    }
}
