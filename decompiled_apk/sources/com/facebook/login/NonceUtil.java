package com.facebook.login;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.message.TokenParser;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes8.dex */
public final class NonceUtil {

    @OXOo.OOXIXo
    public static final NonceUtil INSTANCE = new NonceUtil();

    private NonceUtil() {
    }

    @XO0OX.x0XOIxOo
    public static final boolean isValidNonce(@OXOo.oOoXoXO String str) {
        boolean z = false;
        if (str == null || str.length() == 0) {
            return false;
        }
        if (StringsKt__StringsKt.XxIIOXIXx(str, TokenParser.SP, 0, false, 6, null) >= 0) {
            z = true;
        }
        return !z;
    }
}
