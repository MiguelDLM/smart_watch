package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* loaded from: classes11.dex */
public final class br {
    public static boolean a(View view, int i, boolean z) {
        if (view == null || !b(view, i, z) || !cF(view.getContext())) {
            return false;
        }
        return true;
    }

    private static boolean b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity dB = com.kwad.sdk.n.l.dB(view.getContext());
        if ((dB != null && dB.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z && !view.hasWindowFocus())) {
            return false;
        }
        if (view.getGlobalVisibleRect(new Rect())) {
            long height = r9.height() * r9.width();
            long height2 = view.getHeight() * view.getWidth();
            if (height2 > 0 && height * 100 >= i * height2) {
                return true;
            }
        }
        return false;
    }

    private static boolean cF(Context context) {
        return ap.MM().cF(context);
    }

    public static double k(View view, boolean z) {
        if (view == null) {
            return -1.0d;
        }
        if (!cF(view.getContext())) {
            return -2.0d;
        }
        if (view.getParent() == null) {
            return -3.0d;
        }
        Activity dB = com.kwad.sdk.n.l.dB(view.getContext());
        if (dB != null && dB.isFinishing()) {
            return -4.0d;
        }
        if (view.isShown() && view.getVisibility() == 0) {
            if (!view.hasWindowFocus()) {
                return -6.0d;
            }
            if (view.getGlobalVisibleRect(new Rect())) {
                long height = r6.height() * r6.width();
                long height2 = view.getHeight() * view.getWidth();
                if (height2 <= 0) {
                    return -7.0d;
                }
                return (height * 100.0d) / height2;
            }
            return -8.0d;
        }
        return -5.0d;
    }

    public static boolean o(View view, int i) {
        if (view == null || !b(view, i, true) || !view.hasWindowFocus() || !cF(view.getContext())) {
            return false;
        }
        return true;
    }
}
