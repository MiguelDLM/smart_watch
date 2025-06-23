package com.baidu.platform.core.b;

import com.baidu.nplatform.comapi.MapItem;
import com.tencent.connect.common.II0xO0;

/* loaded from: classes8.dex */
public class c extends com.baidu.platform.base.e {
    public c(String str) {
        a(str);
    }

    private void a(String str) {
        this.f9530a.a("qt", MapItem.KEY_EXT);
        this.f9530a.a("num", II0xO0.f26842oIX0oI);
        this.f9530a.a("l", "10");
        this.f9530a.a("ie", "utf-8");
        this.f9530a.a("oue", "1");
        this.f9530a.a("res", "api");
        this.f9530a.a("fromproduct", "android_map_sdk");
        this.f9530a.a("uid", str);
    }

    @Override // com.baidu.platform.base.e
    public String a(com.baidu.platform.domain.c cVar) {
        return cVar.o();
    }
}
