package com.baidu.navisdk.module.asr;

import org.json.JSONArray;

/* loaded from: classes7.dex */
public class c implements com.baidu.navisdk.asr.i.i {
    public static String b() {
        com.baidu.navisdk.asr.model.c c = c();
        com.baidu.navisdk.util.common.g.ASR.e("BNAsrNavModel", c.a());
        return c.a();
    }

    public static com.baidu.navisdk.asr.model.c c() {
        return a().d(com.baidu.navisdk.module.asr.model.a.b()).i(com.baidu.navisdk.module.asr.model.a.e()).b(com.baidu.navisdk.module.asr.model.a.c());
    }

    @Override // com.baidu.navisdk.asr.i.i
    public String a(String str) {
        com.baidu.navisdk.asr.model.c b = a().b((Object) str);
        com.baidu.navisdk.module.asr.model.a.a(b);
        return b.a();
    }

    @Override // com.baidu.navisdk.asr.i.i
    public String a(String str, JSONArray jSONArray) {
        com.baidu.navisdk.asr.model.c c = a().b((Object) str).c(jSONArray);
        com.baidu.navisdk.module.asr.model.a.a(c);
        return c.a();
    }

    public static com.baidu.navisdk.asr.model.c a() {
        com.baidu.navisdk.asr.model.c cVar = new com.baidu.navisdk.asr.model.c();
        if (com.baidu.navisdk.module.vehiclemanager.b.i().a() == 1) {
            cVar.a(6);
            return cVar;
        }
        int b = com.baidu.navisdk.module.vehiclemanager.b.i().b();
        if (b == 1) {
            cVar.a(1);
        } else if (b == 2) {
            cVar.a(5);
        } else if (b == 3) {
            cVar.a(4);
        }
        return cVar;
    }
}
