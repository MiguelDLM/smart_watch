package com.baidu.navisdk.behavrules.condition;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes7.dex */
public class h extends com.baidu.navisdk.behavrules.condition.a {
    private String c;

    /* loaded from: classes7.dex */
    public static class a implements k {
        @Override // com.baidu.navisdk.behavrules.condition.k
        public j a(String str, com.baidu.navisdk.behavrules.scene.c cVar) {
            return new h(cVar, str);
        }
    }

    public h(com.baidu.navisdk.behavrules.scene.c cVar, String str) {
        super(cVar);
        this.c = str;
    }

    @Override // com.baidu.navisdk.behavrules.condition.j
    public com.baidu.navisdk.behavrules.d l() {
        com.baidu.navisdk.behavrules.a aVar = this.b;
        if (aVar == null) {
            return com.baidu.navisdk.behavrules.d.ERROR_STOP;
        }
        List<l> g = aVar.g();
        if (g != null) {
            for (l lVar : g) {
                if (TextUtils.equals(this.c, lVar.e())) {
                    return lVar.l();
                }
            }
        }
        return com.baidu.navisdk.behavrules.d.ERROR_STOP;
    }
}
