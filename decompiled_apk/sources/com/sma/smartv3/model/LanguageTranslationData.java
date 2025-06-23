package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import com.szabh.smable3.entity.Languages;
import java.io.Serializable;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class LanguageTranslationData extends JsonFieldContainer implements Serializable {

    @OOXIXo
    private String accent;

    @OOXIXo
    private String asrLanguage;
    private int code;
    private boolean isSupportTransfer;

    @OOXIXo
    private String name;

    @OOXIXo
    private String rtasrLanguage;

    @OOXIXo
    private String ttsViuceName;
    private int type;

    public /* synthetic */ LanguageTranslationData(String str, String str2, String str3, String str4, boolean z, int i, String str5, int i2, int i3, IIXOooo iIXOooo) {
        this(str, (i3 & 2) != 0 ? "zh-cn" : str2, (i3 & 4) != 0 ? "cn" : str3, (i3 & 8) != 0 ? "x4_enus_catherine_profnews" : str4, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? 10000 : i, (i3 & 64) != 0 ? "mandarin" : str5, (i3 & 128) == 0 ? i2 : 0);
    }

    @OOXIXo
    public final String component1() {
        return this.name;
    }

    @OOXIXo
    public final String component2() {
        return this.asrLanguage;
    }

    @OOXIXo
    public final String component3() {
        return this.rtasrLanguage;
    }

    @OOXIXo
    public final String component4() {
        return this.ttsViuceName;
    }

    public final boolean component5() {
        return this.isSupportTransfer;
    }

    public final int component6() {
        return this.code;
    }

    @OOXIXo
    public final String component7() {
        return this.accent;
    }

    public final int component8() {
        return this.type;
    }

    @OOXIXo
    public final LanguageTranslationData copy(@OOXIXo String name, @OOXIXo String asrLanguage, @OOXIXo String rtasrLanguage, @OOXIXo String ttsViuceName, boolean z, int i, @OOXIXo String accent, int i2) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(asrLanguage, "asrLanguage");
        IIX0o.x0xO0oo(rtasrLanguage, "rtasrLanguage");
        IIX0o.x0xO0oo(ttsViuceName, "ttsViuceName");
        IIX0o.x0xO0oo(accent, "accent");
        return new LanguageTranslationData(name, asrLanguage, rtasrLanguage, ttsViuceName, z, i, accent, i2);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LanguageTranslationData)) {
            return false;
        }
        LanguageTranslationData languageTranslationData = (LanguageTranslationData) obj;
        return IIX0o.Oxx0IOOO(this.name, languageTranslationData.name) && IIX0o.Oxx0IOOO(this.asrLanguage, languageTranslationData.asrLanguage) && IIX0o.Oxx0IOOO(this.rtasrLanguage, languageTranslationData.rtasrLanguage) && IIX0o.Oxx0IOOO(this.ttsViuceName, languageTranslationData.ttsViuceName) && this.isSupportTransfer == languageTranslationData.isSupportTransfer && this.code == languageTranslationData.code && IIX0o.Oxx0IOOO(this.accent, languageTranslationData.accent) && this.type == languageTranslationData.type;
    }

    @OOXIXo
    public final String getAccent() {
        return this.accent;
    }

    @OOXIXo
    public final String getAsrLanguage() {
        return this.asrLanguage;
    }

    public final int getCode() {
        return this.code;
    }

    @OOXIXo
    public final String getName() {
        return this.name;
    }

    @OOXIXo
    public final String getRtasrLanguage() {
        return this.rtasrLanguage;
    }

    @OOXIXo
    public final String getTtsViuceName() {
        return this.ttsViuceName;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((((this.name.hashCode() * 31) + this.asrLanguage.hashCode()) * 31) + this.rtasrLanguage.hashCode()) * 31) + this.ttsViuceName.hashCode()) * 31) + androidx.work.oIX0oI.oIX0oI(this.isSupportTransfer)) * 31) + this.code) * 31) + this.accent.hashCode()) * 31) + this.type;
    }

    public final boolean isSupportTransfer() {
        return this.isSupportTransfer;
    }

    public final void setAccent(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.accent = str;
    }

    public final void setAsrLanguage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.asrLanguage = str;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final void setName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.name = str;
    }

    public final void setRtasrLanguage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.rtasrLanguage = str;
    }

    public final void setSupportTransfer(boolean z) {
        this.isSupportTransfer = z;
    }

    public final void setTtsViuceName(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.ttsViuceName = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @OOXIXo
    public String toString() {
        return "LanguageTranslationData(name=" + this.name + ", asrLanguage=" + this.asrLanguage + ", rtasrLanguage=" + this.rtasrLanguage + ", ttsViuceName=" + this.ttsViuceName + ", isSupportTransfer=" + this.isSupportTransfer + ", code=" + this.code + ", accent=" + this.accent + ", type=" + this.type + HexStringBuilder.COMMENT_END_CHAR;
    }

    public LanguageTranslationData(@OOXIXo String name, @OOXIXo String asrLanguage, @OOXIXo String rtasrLanguage, @OOXIXo String ttsViuceName, boolean z, int i, @OOXIXo String accent, int i2) {
        IIX0o.x0xO0oo(name, "name");
        IIX0o.x0xO0oo(asrLanguage, "asrLanguage");
        IIX0o.x0xO0oo(rtasrLanguage, "rtasrLanguage");
        IIX0o.x0xO0oo(ttsViuceName, "ttsViuceName");
        IIX0o.x0xO0oo(accent, "accent");
        this.name = name;
        this.asrLanguage = asrLanguage;
        this.rtasrLanguage = rtasrLanguage;
        this.ttsViuceName = ttsViuceName;
        this.isSupportTransfer = z;
        this.code = i;
        this.accent = accent;
        this.type = i2;
        this.code = IIX0o.Oxx0IOOO(rtasrLanguage, "cn") ? Languages.INSTANCE.languageBriefToCode(Languages.DEFAULT_LANGUAGE_ZH, 10000) : Languages.INSTANCE.languageBriefToCode(this.rtasrLanguage, 10000);
    }
}
