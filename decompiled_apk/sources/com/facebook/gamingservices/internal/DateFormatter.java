package com.facebook.gamingservices.internal;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.os.Build;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes8.dex */
public final class DateFormatter {

    @OOXIXo
    public static final DateFormatter INSTANCE = new DateFormatter();

    private DateFormatter() {
    }

    @oOoXoXO
    public final ZonedDateTime format$facebook_gamingservices_release(@oOoXoXO String str) {
        DateTimeFormatter ofPattern;
        ZonedDateTime parse;
        if (Build.VERSION.SDK_INT >= 26) {
            ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
            IIX0o.oO(ofPattern, "ofPattern(\"yyyy-MM-dd'T'HH:mm:ssZ\")");
            parse = ZonedDateTime.parse(str, ofPattern);
            return parse;
        }
        return null;
    }
}
