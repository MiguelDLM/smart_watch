package com.kwad.sdk.api.core;

import android.content.Context;

/* loaded from: classes11.dex */
public class ApiViewUtil {
    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
