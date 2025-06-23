package com.baidu.navisdk.ui.routeguide.model;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.google.android.exoplayer2.util.MimeTypes;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static String f8985a;

    public static void d() {
        f8985a = null;
        if (com.baidu.navisdk.module.pronavi.a.j == 2) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("scenic_broadcast", "queryScenicBroadcast, is demo");
                return;
            }
            return;
        }
        if (com.baidu.navisdk.j.c()) {
            return;
        }
        if (!BNCommSettingManager.getInstance().isScenicBroadcastOpen()) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar2.d()) {
                gVar2.e("scenic_broadcast", "queryScenicBroadcast, not open");
                return;
            }
            return;
        }
        RoutePlanNode g = ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g();
        if (g == null) {
            com.baidu.navisdk.util.common.g gVar3 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar3.d()) {
                gVar3.e("scenic_broadcast", "endNode == null");
            }
            f8985a = null;
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
            return;
        }
        String str = g.mUID;
        if (TextUtils.isEmpty(str)) {
            com.baidu.navisdk.util.common.g gVar4 = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar4.d()) {
                gVar4.e("scenic_broadcast", "uid == null");
            }
            f8985a = null;
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
            return;
        }
        com.baidu.navisdk.util.http.center.b.a().a("https://content.map.baidu.com/scope?qt=scope_v2_audiointroduce&uid=" + str, null, new a(), new com.baidu.navisdk.util.http.center.e(true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        try {
            return new JSONObject(str).getJSONObject("data").getString(MimeTypes.BASE_TYPE_AUDIO);
        } catch (Throwable th) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                th.printStackTrace();
                return "";
            }
            return "";
        }
    }

    public static void b() {
        f8985a = null;
    }

    public static String c() {
        return f8985a;
    }

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.http.center.f {
        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str, Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("scenic_broadcast", "error code:" + i + " response:" + str);
            }
            String unused = y.f8985a = null;
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
        }

        @Override // com.baidu.navisdk.util.http.center.f
        public void a(int i, String str) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.PRO_NAV;
            if (gVar.d()) {
                gVar.e("scenic_broadcast", "success code:" + i + " response:" + str);
            }
            if (i == 200) {
                String unused = y.f8985a = y.e(str);
                if (!TextUtils.isEmpty(y.f8985a)) {
                    if (gVar.d()) {
                        gVar.e("scenic_broadcast", "content length " + y.d(y.f8985a));
                    }
                    if (y.d(y.f8985a) >= 1024) {
                        String unused2 = y.f8985a = null;
                    }
                }
            }
            if (!TextUtils.isEmpty(y.f8985a)) {
                com.baidu.navisdk.util.statistic.userop.b.r().b("3.p.4.1");
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(true);
            } else {
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
            }
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return str.getBytes("GBK").length;
        } catch (Exception e) {
            if (com.baidu.navisdk.util.common.g.PRO_NAV.d()) {
                e.printStackTrace();
            }
            return 0;
        }
    }
}
