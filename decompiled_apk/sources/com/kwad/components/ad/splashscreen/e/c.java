package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdInfo;

/* loaded from: classes11.dex */
public final class c {
    public static void a(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i2 >= 0) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(view.getContext(), i2);
            }
            marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(view.getContext(), 16.0f);
        }
    }

    public static boolean z(@NonNull AdInfo adInfo) {
        if (adInfo.adSplashInfo.skipButtonPosition == 0) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int a2 = com.kwad.sdk.c.a.a.a(context, 10.0f);
        return Math.abs(i - i3) <= a2 && Math.abs(i2 - i4) <= a2;
    }
}
