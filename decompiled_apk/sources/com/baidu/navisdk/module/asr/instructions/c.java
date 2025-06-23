package com.baidu.navisdk.module.asr.instructions;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.framework.interfaces.asr.a;

/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    public class a extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            return com.baidu.navisdk.module.asr.instructions.b.a(aVar.C0.f6555a, true);
        }
    }

    /* loaded from: classes7.dex */
    public class b extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.asr.model.c j = new com.baidu.navisdk.asr.model.c().a("NaviPage", Long.valueOf(System.currentTimeMillis()), "").d(com.baidu.navisdk.module.asr.model.a.b()).i(com.baidu.navisdk.module.asr.model.a.e()).j(aVar.z0);
            Boolean bool = Boolean.TRUE;
            String a2 = j.a(bool).k(bool).a();
            com.baidu.navisdk.framework.interfaces.asr.a b = com.baidu.navisdk.module.asr.instructions.b.b(aVar.C0.f6555a, true);
            b.e = a2;
            return b;
        }
    }

    /* renamed from: com.baidu.navisdk.module.asr.instructions.c$c, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0224c extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            return new a.C0199a().a(aVar.C0.f6555a).e(true).c(true).b(com.baidu.navisdk.module.asr.c.a().j(aVar.z0).k(Boolean.TRUE).b((Object) "scene_confirm").a()).a(true).d(true).a();
        }
    }

    /* loaded from: classes7.dex */
    public class d extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.asr.sceneguide.a a2 = com.baidu.navisdk.asr.sceneguide.c.a().a(aVar.z0);
            if (a2 != null) {
                com.baidu.navisdk.asr.d.B().a(a2.a());
                return null;
            }
            com.baidu.navisdk.asr.d.B().c();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class e extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.6");
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(aVar.p) && !TextUtils.equals(aVar.p, "当前")) {
                return com.baidu.navisdk.module.asr.instructions.b.b("暂不支持该指令");
            }
            BNRouteGuider.getInstance().getRouteInfoInUniform(39, bundle);
            String string = bundle.getString("content");
            if (TextUtils.isEmpty(string)) {
                string = "前方因车流量大导致拥堵，请小心驾驶";
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes7.dex */
    public class f extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.a.a().a(aVar.z0);
            return com.baidu.navisdk.module.asr.instructions.b.b("好的，已为您开启小度唤醒");
        }
    }

    public static void a() {
        new a().a("common_speak_voice");
        new b().a("common_speak_ask");
        new C0224c().a("common_speak_confirm");
        new d().a("speak_again");
        new e().a("jam_reason");
        new f().a("xd_wakeup_setting");
    }
}
