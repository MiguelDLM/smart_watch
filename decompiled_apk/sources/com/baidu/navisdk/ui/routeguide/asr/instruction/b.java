package com.baidu.navisdk.ui.routeguide.asr.instruction;

import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.ui.routeguide.model.n;
import com.baidu.navisdk.util.common.l0;
import java.util.List;

/* loaded from: classes8.dex */
public class b {
    public static com.baidu.navisdk.module.pronavi.model.d a(int i) {
        List<com.baidu.navisdk.module.pronavi.model.d> a2;
        n c = com.baidu.navisdk.ui.routeguide.b.V().i().c();
        if (c == null || (a2 = c.a(true)) == null) {
            return null;
        }
        for (int i2 = 0; i2 < a2.size(); i2++) {
            com.baidu.navisdk.module.pronavi.model.d dVar = a2.get(i2);
            if (dVar != null && i == dVar.p()) {
                return dVar;
            }
        }
        return null;
    }

    public static String b() {
        String b = l0.b(a0.I().l());
        if (!l0.c(b) && b.contains("点2")) {
            b = b.replaceAll("点2", "点二");
        }
        if (l0.c(b)) {
            return "";
        }
        return b;
    }

    public static com.baidu.navisdk.module.pronavi.model.d a() {
        n c;
        List<com.baidu.navisdk.module.pronavi.model.d> a2;
        com.baidu.navisdk.module.pronavi.model.d a3 = a(1);
        if (a3 == null || (c = com.baidu.navisdk.ui.routeguide.b.V().i().c()) == null || (a2 = c.a(false)) == null) {
            return null;
        }
        for (int indexOf = a2.indexOf(a3) - 1; indexOf >= 0; indexOf--) {
            com.baidu.navisdk.module.pronavi.model.d dVar = a2.get(indexOf);
            if (dVar.p() == 2) {
                return dVar;
            }
        }
        return null;
    }

    public static StringBuilder a(StringBuilder sb) {
        String str;
        String n = a0.I().n();
        if (l0.c(n)) {
            str = "";
        } else {
            if (n.contains("分") && !n.endsWith("分")) {
                n = n.substring(0, n.indexOf("分") + 1);
            }
            str = n + "钟";
        }
        sb.append(str);
        String a2 = a0.I().a();
        if (!l0.c(a2)) {
            sb.append(",预计");
            sb.append(a2);
        }
        return sb;
    }
}
