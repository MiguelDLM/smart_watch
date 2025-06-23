package com.baidu.navisdk.asr;

import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.e;

/* loaded from: classes7.dex */
public class b implements a.InterfaceC0201a {
    public void a() {
        com.baidu.navisdk.framework.message.a.a().a(this, com.baidu.navisdk.framework.message.bean.e.class, new Class[0]);
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        if (obj instanceof com.baidu.navisdk.framework.message.bean.e) {
            com.baidu.navisdk.framework.interfaces.pronavi.b h = com.baidu.navisdk.framework.interfaces.c.p().h();
            if (h != null && h.x0()) {
                return;
            }
            e.a aVar = ((com.baidu.navisdk.framework.message.bean.e) obj).b;
            if ((aVar == e.a.CANCEL || aVar == e.a.FINISH) && d.B().r()) {
                d.B().b();
            }
        }
    }
}
