package com.baidu.navisdk.yellowbannerui.view;

import android.content.Context;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class c {
    public static a a(Context context, com.baidu.navisdk.yellowbannerui.view.params.a aVar) {
        g gVar = g.NAV_RESULT;
        if (gVar.d()) {
            gVar.e("RouteCarYBannerViewFactory", "create() --> activity = " + context + ", params = " + aVar);
        }
        if (aVar != null && aVar.j() != null && aVar.j().c() != null && context != null && aVar.a() != null) {
            return new b(context, aVar);
        }
        return null;
    }
}
