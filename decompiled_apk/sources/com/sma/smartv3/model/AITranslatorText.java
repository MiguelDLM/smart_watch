package com.sma.smartv3.model;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import com.goodix.ble.libcomx.util.HexStringBuilder;
import kotlin.jvm.internal.IIX0o;
import kotlin.jvm.internal.IIXOooo;

/* loaded from: classes12.dex */
public final class AITranslatorText {

    @OOXIXo
    private String text;

    @OOXIXo
    private String translationLanguage;

    /* JADX WARN: Multi-variable type inference failed */
    public AITranslatorText() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AITranslatorText copy$default(AITranslatorText aITranslatorText, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aITranslatorText.text;
        }
        if ((i & 2) != 0) {
            str2 = aITranslatorText.translationLanguage;
        }
        return aITranslatorText.copy(str, str2);
    }

    @OOXIXo
    public final String component1() {
        return this.text;
    }

    @OOXIXo
    public final String component2() {
        return this.translationLanguage;
    }

    @OOXIXo
    public final AITranslatorText copy(@OOXIXo String text, @OOXIXo String translationLanguage) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(translationLanguage, "translationLanguage");
        return new AITranslatorText(text, translationLanguage);
    }

    public boolean equals(@oOoXoXO Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AITranslatorText)) {
            return false;
        }
        AITranslatorText aITranslatorText = (AITranslatorText) obj;
        return IIX0o.Oxx0IOOO(this.text, aITranslatorText.text) && IIX0o.Oxx0IOOO(this.translationLanguage, aITranslatorText.translationLanguage);
    }

    @OOXIXo
    public final String getText() {
        return this.text;
    }

    @OOXIXo
    public final String getTranslationLanguage() {
        return this.translationLanguage;
    }

    public int hashCode() {
        return (this.text.hashCode() * 31) + this.translationLanguage.hashCode();
    }

    public final void setText(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.text = str;
    }

    public final void setTranslationLanguage(@OOXIXo String str) {
        IIX0o.x0xO0oo(str, "<set-?>");
        this.translationLanguage = str;
    }

    @OOXIXo
    public String toString() {
        return "AITranslatorText(text=" + this.text + ", translationLanguage=" + this.translationLanguage + HexStringBuilder.COMMENT_END_CHAR;
    }

    public AITranslatorText(@OOXIXo String text, @OOXIXo String translationLanguage) {
        IIX0o.x0xO0oo(text, "text");
        IIX0o.x0xO0oo(translationLanguage, "translationLanguage");
        this.text = text;
        this.translationLanguage = translationLanguage;
    }

    public /* synthetic */ AITranslatorText(String str, String str2, int i, IIXOooo iIXOooo) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }
}
