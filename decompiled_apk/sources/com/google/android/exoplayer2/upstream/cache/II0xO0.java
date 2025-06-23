package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;

/* loaded from: classes9.dex */
public final /* synthetic */ class II0xO0 {
    static {
        CacheKeyFactory cacheKeyFactory = CacheKeyFactory.DEFAULT;
    }

    public static /* synthetic */ String oIX0oI(DataSpec dataSpec) {
        String str = dataSpec.key;
        if (str == null) {
            return dataSpec.uri.toString();
        }
        return str;
    }
}
