package com.baidu.navisdk.module.brule;

import android.text.TextUtils;
import com.baidu.navisdk.behavrules.condition.e;
import com.baidu.navisdk.module.brule.condition.b;
import com.baidu.navisdk.module.brule.matchpage.d;

/* loaded from: classes7.dex */
public class b {

    /* loaded from: classes7.dex */
    public class a implements e {
        @Override // com.baidu.navisdk.behavrules.condition.e
        public String a(String str) {
            if (TextUtils.equals(str, "0")) {
                return "common_type";
            }
            if (TextUtils.equals(str, "1")) {
                return "click_type";
            }
            return str;
        }
    }

    public static com.baidu.navisdk.behavrules.a a() {
        com.baidu.navisdk.behavrules.a aVar = new com.baidu.navisdk.behavrules.a(com.baidu.navisdk.framework.a.c().a());
        b(aVar);
        a(aVar);
        aVar.a(com.baidu.navisdk.module.brule.a.l());
        aVar.a("speak", new b.a());
        aVar.a("scene_type", new com.baidu.navisdk.module.brule.condition.a());
        aVar.a(2);
        aVar.f("0");
        aVar.e("0");
        aVar.a(new a());
        return aVar;
    }

    private static void b(com.baidu.navisdk.behavrules.a aVar) {
        aVar.a(new d());
        aVar.a(new com.baidu.navisdk.module.brule.matchpage.a());
        aVar.a(new com.baidu.navisdk.module.brule.matchpage.c());
        aVar.a(new com.baidu.navisdk.module.brule.matchpage.b());
        aVar.a(com.baidu.navisdk.module.brule.matchpage.e.a());
        aVar.a(com.baidu.navisdk.module.brule.matchpage.e.b());
        aVar.a(com.baidu.navisdk.module.brule.matchpage.e.d());
        aVar.a(com.baidu.navisdk.module.brule.matchpage.e.c());
    }

    private static void a(com.baidu.navisdk.behavrules.a aVar) {
        aVar.a(new com.baidu.navisdk.module.dynamicui.dialog.a());
        aVar.a(new com.baidu.navisdk.module.dynamicui.bubble.a());
    }
}
