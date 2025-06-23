package com.google.android.gms.common.internal;

import android.net.Uri;

/* loaded from: classes9.dex */
public final class zzu {
    private static final Uri zza;
    private static final Uri zzb;

    static {
        Uri parse = Uri.parse("https://plus.google.com/");
        zza = parse;
        zzb = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }
}
