package com.baidu.navisdk.utils;

import OXOo.oOoXoXO;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes8.dex */
public final class b {
    public static final void a(@oOoXoXO View view) {
        ViewParent viewParent;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }
}
