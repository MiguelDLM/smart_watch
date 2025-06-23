package com.baidu.navisdk.module.brule;

import com.baidu.navisdk.behavrules.util.b;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    public class a implements b.a {
        @Override // com.baidu.navisdk.behavrules.util.b.a
        public void a(String str, String str2) {
            g gVar = g.BRULE;
            if (gVar.d()) {
                gVar.e(str, str2);
            }
        }

        @Override // com.baidu.navisdk.behavrules.util.b.a
        public void b(String str, String str2) {
            g gVar = g.BRULE;
            if (gVar.c()) {
                gVar.c(str, str2);
            }
        }
    }

    public static void a() {
        c();
        b();
    }

    private static void b() {
        new com.baidu.navisdk.module.brule.business.a().a();
    }

    private static void c() {
        com.baidu.navisdk.behavrules.util.b.a(new a());
    }
}
