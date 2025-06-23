package com.bytedance.sdk.openadsdk;

import android.content.Context;

/* loaded from: classes8.dex */
public interface TTDislikeController {
    @Deprecated
    void onDislikeEvent(Context context, boolean z);

    void onDislikeSelected(FilterWord filterWord);

    @Deprecated
    void openWebPage(Context context, boolean z);
}
