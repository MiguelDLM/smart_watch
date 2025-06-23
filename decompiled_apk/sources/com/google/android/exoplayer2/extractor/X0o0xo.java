package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import java.util.Map;

/* loaded from: classes9.dex */
public final /* synthetic */ class X0o0xo {
    static {
        ExtractorsFactory extractorsFactory = ExtractorsFactory.EMPTY;
    }

    public static /* synthetic */ Extractor[] II0xO0() {
        return new Extractor[0];
    }

    public static Extractor[] oIX0oI(ExtractorsFactory extractorsFactory, Uri uri, Map map) {
        return extractorsFactory.createExtractors();
    }
}
