package com.baidu.navisdk.pronavi.util;

import OXOo.OOXIXo;
import OXOo.oOoXoXO;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @OOXIXo
    public static final b f7961a = new b();

    private b() {
    }

    private final void a(int i, int i2, View view) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("RGViewUtils", "setViewMargin: " + i + ", " + i2 + ", " + view);
        }
        if (view == null) {
            if (gVar.c()) {
                gVar.c("RGViewUtils", "setViewMargin: view == null");
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            if (i2 == 1) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams.leftMargin != i) {
                    marginLayoutParams.leftMargin = i;
                    view.requestLayout();
                    return;
                }
                return;
            }
            if (i2 == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams2.topMargin != i) {
                    marginLayoutParams2.topMargin = i;
                    view.requestLayout();
                    return;
                }
                return;
            }
            if (i2 == 3) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams3.rightMargin != i) {
                    marginLayoutParams3.rightMargin = i;
                    view.requestLayout();
                    return;
                }
                return;
            }
            if (i2 != 4) {
                return;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams;
            if (marginLayoutParams4.bottomMargin != i) {
                marginLayoutParams4.bottomMargin = i;
                view.requestLayout();
            }
        }
    }

    public final void a(@oOoXoXO View view, int i) {
        a(i, 4, view);
    }

    @OOXIXo
    public final Rect a(@oOoXoXO View view) {
        Rect rect = new Rect();
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        return rect;
    }
}
