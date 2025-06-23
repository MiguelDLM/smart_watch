package com.baidu.navisdk.module.brule.business;

import com.baidu.navisdk.l;
import com.baidu.navisdk.m;
import com.baidu.navisdk.n;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.navisdk.module.brule.business.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0226a implements n {
        public C0226a(a aVar) {
        }

        @Override // com.baidu.navisdk.n
        public void a(boolean z, String str) {
            com.baidu.navisdk.behavrules.scene.b a2;
            g gVar = g.DYNA_DATA;
            if (gVar.d()) {
                gVar.e("BNBRuleDynaUIInit", "onResult(), isSuccess = " + z + " data = " + str);
            }
            if (!com.baidu.navisdk.module.brule.business.util.b.f7047a && z && (a2 = new com.baidu.navisdk.behavrules.b().a(str, com.baidu.navisdk.module.brule.b.a())) != null) {
                a2.c();
            }
        }
    }

    public void a() {
        l.a().b(m.BRULE, new C0226a(this));
    }
}
