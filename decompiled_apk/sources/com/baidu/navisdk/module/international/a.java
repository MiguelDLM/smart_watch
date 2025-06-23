package com.baidu.navisdk.module.international;

import android.content.Context;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.modelfactory.c;
import com.baidu.navisdk.model.modelfactory.f;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes7.dex */
public class a {
    public static int a() {
        f fVar = (f) c.a().a("RoutePlanModel");
        if (fVar == null) {
            return 0;
        }
        return fVar.f();
    }

    public static boolean b() {
        f fVar = (f) c.a().a("RoutePlanModel");
        if (fVar != null && fVar.f() != 0) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context) {
        if (!b()) {
            return false;
        }
        TipTool.onCreateToastDialog(context, JarUtils.getResources().getString(R.string.nsdk_string_global_not_support));
        return true;
    }
}
