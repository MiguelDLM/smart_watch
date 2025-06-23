package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AISpeech implements Serializable {
    private int LanguageModel;

    @OOXIXo
    private String dst;
    private long endTime;

    @OOXIXo
    private String lang;
    private long startTime;
    private int status;

    @OOXIXo
    private String targetLang;

    @OOXIXo
    private String text;

    @OOXIXo
    private String ttsVoiceName;

    public AISpeech() {
        this(null, null, 0, 0, null, null, null, 0L, 0L, 511, null);
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

    public final int component4() {
        return this.LanguageModel;
    }

    @OOXIXo
    public final String component5() {
        return this.lang;
    }

    @OOXIXo
    public final String component6() {
        return this.targetLang;
    }

    @OOXIXo
    public final String component7() {
        return this.ttsVoiceName;
    }

    public final long component8() {
        return this.startTime;
    }

    public final long component9() {
        return this.endTime;
    }

    @OOXIXo
    public final AISpeech copy(@OOXIXo String text, @OOXIXo String dst, int i, int i2, @OOXIXo String lang, @OOXIXo String targetLang, @OOXIXo String ttsVoiceName, long j, long j2) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(dst, "dst");
        IIX0o.x0xO0oo(lang, "lang");
        IIX0o.x0xO0oo(targetLang, "targetLang");
        IIX0o.x0xO0oo(ttsVoiceName, "ttsVoiceName");
        return new AISpeech(text, dst, i, i2, lang, targetLang, ttsVoiceName, j, j2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AISpeech)) {
            return false;
        }
        AISpeech aISpeech = (AISpeech) obj;
        if (IIX0o.Oxx0IOOO(this.text, aISpeech.text) && IIX0o.Oxx0IOOO(this.dst, aISpeech.dst)) {
            return true;
        }
        return false;
    }

    @OOXIXo
    public final String getDst() {
        return this.dst;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    @OOXIXo
    public final String getLang() {
        return this.lang;
    }

    public final int getLanguageModel() {
        return this.LanguageModel;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final int getStatus() {
        return this.status;
    }

    @OOXIXo
    public final String getTargetLang() {
        return this.targetLang;
    }

    @OOXIXo
    public final String getText() {
        return this.text;
    }

    @OOXIXo
    public final String getTtsVoiceName() {
        return this.ttsVoiceName;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.dst.hashCode();
    }

    public final void setDst(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.dst = str;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setLang(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.lang = str;
    }

    public final void setLanguageModel(int i) {
        this.LanguageModel = i;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTargetLang(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.targetLang = str;
    }

    public final void setText(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.text = str;
    }

    public final void setTtsVoiceName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.ttsVoiceName = str;
    }

    @OOXIXo
    public String toString() {
        return "AISpeech(text=" + this.text + ", dst=" + this.dst + ", status=" + this.status + ", LanguageModel=" + this.LanguageModel + ", lang=" + this.lang + ", targetLang=" + this.targetLang + ", ttsVoiceName=" + this.ttsVoiceName + ", startTime=" + this.startTime + ", endTime=" + this.endTime + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AISpeech(@OOXIXo String text, @OOXIXo String dst, int i, int i2, @OOXIXo String lang, @OOXIXo String targetLang, @OOXIXo String ttsVoiceName, long j, long j2) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(dst, "dst");
        IIX0o.x0xO0oo(lang, "lang");
        IIX0o.x0xO0oo(targetLang, "targetLang");
        IIX0o.x0xO0oo(ttsVoiceName, "ttsVoiceName");
        this.text = text;
        this.dst = dst;
        this.status = i;
        this.LanguageModel = i2;
        this.lang = lang;
        this.targetLang = targetLang;
        this.ttsVoiceName = ttsVoiceName;
        this.startTime = j;
        this.endTime = j2;
    }

    public /* synthetic */ AISpeech(String str, String str2, int i, int i2, String str3, String str4, String str5, long j, long j2, int i3, IIXOooo iIXOooo) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? "" : str3, (i3 & 32) != 0 ? "" : str4, (i3 & 64) == 0 ? str5 : "", (i3 & 128) != 0 ? 0L : j, (i3 & 256) == 0 ? j2 : 0L);
    }
}
