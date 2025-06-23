package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.html;

import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.Beta;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.annotations.GwtCompatible;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.Escaper;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.escape.Escapers;
import kotlin.text.XIxXXX0x0;

@Beta
@GwtCompatible
/* loaded from: classes10.dex */
public final class HtmlEscapers {
    private static final Escaper HTML_ESCAPER = Escapers.builder().addEscape('\"', "&quot;").addEscape('\'', "&#39;").addEscape(XIxXXX0x0.f29558oxoX, "&amp;").addEscape(XIxXXX0x0.f29542X0o0xo, "&lt;").addEscape(XIxXXX0x0.f29545XO, "&gt;").build();

    private HtmlEscapers() {
    }

    public static Escaper htmlEscaper() {
        return HTML_ESCAPER;
    }
}
