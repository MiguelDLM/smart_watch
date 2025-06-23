package com.sma.smartv3.network;

import OXOo.OOXIXo;

/* loaded from: classes12.dex */
public final class ToTranslatorText {

    @OOXIXo
    public static final String FLAG_ORIGINAL_LANGUAGE = "originalLanguage";

    @OOXIXo
    public static final String FLAG_SOURCE = "source";

    @OOXIXo
    public static final String FLAG_TEXT_FORM = "textForm";

    @OOXIXo
    public static final String FLAG_TRANSLATION_LANGUAGE = "translationLanguage";

    @OOXIXo
    public static final ToTranslatorText INSTANCE = new ToTranslatorText();

    @OOXIXo
    public static final String URL = "/translator/translatorText";

    private ToTranslatorText() {
    }
}
