package com.baidu.navisdk.ui.routeguide.brule.data;

import android.text.TextUtils;
import com.baidu.navisdk.behavrules.data.c;
import com.baidu.navisdk.module.pronavi.model.d;
import com.baidu.navisdk.ui.routeguide.model.n;

/* loaded from: classes8.dex */
public class a implements c {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r2.s() == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.navisdk.ui.routeguide.brule.data.a.b(java.lang.String):java.lang.String");
    }

    private String c(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith("charge")) {
            return b(str);
        }
        return null;
    }

    @Override // com.baidu.navisdk.behavrules.data.c
    public String a() {
        return "nav_newEng";
    }

    @Override // com.baidu.navisdk.behavrules.data.c
    public String a(String str) {
        str.hashCode();
        if (str.equals("end_node_type")) {
            return b();
        }
        if (!str.equals("ne_has_end_attch_charge")) {
            return c(str);
        }
        return String.valueOf(c());
    }

    private boolean c() {
        n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
        if (c == null) {
            return false;
        }
        d f = c.f();
        com.baidu.navisdk.model.datastruct.chargestation.b bVar = f == null ? null : (com.baidu.navisdk.model.datastruct.chargestation.b) f.a("charge_station_info");
        return bVar != null && bVar.e() == 5;
    }

    private String b() {
        n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
        if (c == null) {
            return null;
        }
        d g = c.g();
        com.baidu.navisdk.model.datastruct.chargestation.b bVar = g == null ? null : (com.baidu.navisdk.model.datastruct.chargestation.b) g.a("charge_station_info");
        if (bVar == null || bVar.e() != 4) {
            return null;
        }
        return "charge";
    }
}
