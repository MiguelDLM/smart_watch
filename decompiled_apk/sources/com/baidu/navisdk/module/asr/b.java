package com.baidu.navisdk.module.asr;

import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.e;

@Deprecated
/* loaded from: classes7.dex */
public class b implements a.InterfaceC0201a {
    public void a(boolean z) {
        com.baidu.navisdk.asr.d.B().u();
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        if (obj instanceof com.baidu.navisdk.framework.message.bean.e) {
            e.a aVar = ((com.baidu.navisdk.framework.message.bean.e) obj).b;
            if (aVar == e.a.CANCEL) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z.5", null, null, "2");
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.o.4", "1", "", "1");
                a(true);
            } else if (aVar == e.a.FINISH) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.o.4", "2", "", "1");
                a(false);
            }
        }
    }
}
