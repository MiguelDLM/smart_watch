package com.baidu.navisdk.ui.routeguide.asr.instruction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.s;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.l0;
import com.baidu.navisdk.util.common.y;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

/* loaded from: classes8.dex */
public class e {

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.1.6");
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(14, 1, bundle);
            return com.baidu.navisdk.module.asr.instructions.b.b(bundle.getString("speedLimitInfo"));
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            boolean z;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.4");
            if (a0.I().c() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (TextUtils.equals(aVar.p0, "entry") && z) {
                return com.baidu.navisdk.module.asr.instructions.b.b("抱歉，未找到前方高速信息");
            }
            if (TextUtils.equals(aVar.p0, "exit") && !z) {
                return com.baidu.navisdk.module.asr.instructions.b.b("抱歉，未找到前方高速信息");
            }
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.ASR;
            if (gVar.d()) {
                gVar.e("XDVoiceRGQueryInstructions", "highway(), isInHighRoad = " + z);
            }
            if (z) {
                com.baidu.navisdk.module.pronavi.model.d j = com.baidu.navisdk.ui.routeguide.b.V().i().c().j();
                if (gVar.d()) {
                    gVar.e("XDVoiceRGQueryInstructions", "highway(), exitBean = " + j);
                }
                if (j != null && j.h() != null) {
                    String b = l0.b(j.k());
                    j.h();
                    return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_highway_node, b, "离开"));
                }
                com.baidu.navisdk.module.pronavi.model.d a2 = com.baidu.navisdk.ui.routeguide.asr.instruction.b.a(1);
                if (gVar.d()) {
                    gVar.e("XDVoiceRGQueryInstructions", "highway(), stationBean = " + a2);
                }
                if (a2 != null) {
                    return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_highway_node2, l0.b(a2.k()), a2.h()));
                }
            } else {
                com.baidu.navisdk.module.pronavi.model.d a3 = com.baidu.navisdk.ui.routeguide.asr.instruction.b.a();
                if (gVar.d()) {
                    gVar.e("XDVoiceRGQueryInstructions", "highway(), entryBean = " + a3);
                }
                if (a3 != null) {
                    return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_highway_node, l0.b(a3.k()), "进入"));
                }
                com.baidu.navisdk.module.pronavi.model.d a4 = com.baidu.navisdk.ui.routeguide.asr.instruction.b.a(1);
                if (gVar.d()) {
                    gVar.e("XDVoiceRGQueryInstructions", "highway(), stationBean = " + a4);
                }
                if (a4 != null) {
                    return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_highway_node2, l0.b(a4.k()), a4.h()));
                }
            }
            return com.baidu.navisdk.module.asr.instructions.b.b("抱歉，未找到前方高速信息");
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.l.3");
            return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.nsdk_end_node, ((com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel")).g().getName()));
        }
    }

    /* loaded from: classes8.dex */
    public class d extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.2");
            StringBuilder sb = new StringBuilder();
            sb.append("离目的地还有");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.routeguide.asr.instruction.b.a(sb).toString());
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.instruction.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0424e extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.3");
            StringBuilder sb = new StringBuilder();
            String b = com.baidu.navisdk.ui.routeguide.asr.instruction.b.b();
            if (b != null) {
                sb.append("离目的地剩余");
                sb.append(b);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(sb.toString());
        }
    }

    /* loaded from: classes8.dex */
    public class f extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.f");
            StringBuilder sb = new StringBuilder();
            String b = com.baidu.navisdk.ui.routeguide.asr.instruction.b.b();
            if (b != null) {
                sb.append("离目的地剩余");
                sb.append(b);
            }
            sb.append("大约需要");
            return com.baidu.navisdk.module.asr.instructions.b.b(com.baidu.navisdk.ui.routeguide.asr.instruction.b.a(sb).toString());
        }
    }

    /* loaded from: classes8.dex */
    public class g extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.1");
            if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f2()) {
                string = a0.I().g();
            } else if (com.baidu.navisdk.ui.routeguide.mapmode.a.o5().N2()) {
                string = com.baidu.navisdk.ui.routeguide.holder.a.d().b();
            } else {
                string = JarUtils.getResources().getString(R.string.asr_rg_answer_forward, a0.I().a(a0.I().h().getInt(RouteGuideParams.RGKey.SimpleGuideInfo.RemainDist, 0)), a0.I().o());
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes8.dex */
    public class h extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.3");
            if (TextUtils.isEmpty(aVar.m)) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                return null;
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(aVar.m);
        }
    }

    /* loaded from: classes8.dex */
    public class i extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.9");
            if (com.baidu.navisdk.module.asr.h.a()) {
                return com.baidu.navisdk.module.asr.instructions.b.b(JarUtils.getResources().getString(R.string.asr_rg_pref_traffic_info_not_use));
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(BNRouteGuider.getInstance().getCurRoadConditionText());
        }
    }

    /* loaded from: classes8.dex */
    public class j extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.7.6");
            String string = JarUtils.getResources().getString(R.string.asr_rg_has_no_service);
            com.baidu.navisdk.module.pronavi.model.d a2 = com.baidu.navisdk.ui.routeguide.b.V().m().a();
            if (a2 != null && a2.k() > 0) {
                string = JarUtils.getResources().getString(R.string.asr_rg_next_service, a2.h(), a2.m() + a2.n());
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    /* loaded from: classes8.dex */
    public class k extends com.baidu.navisdk.asr.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f8477a = new a(this, Looper.getMainLooper());

        /* loaded from: classes8.dex */
        public class a extends Handler {
            public a(k kVar, Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1003) {
                    com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                    return;
                }
                if (message.arg1 == 0) {
                    s b = ((com.baidu.navisdk.model.modelfactory.e) com.baidu.navisdk.model.modelfactory.c.a().a("PoiSearchModel")).b();
                    if (b != null && !TextUtils.isEmpty(b.g)) {
                        com.baidu.navisdk.asr.d.B().a(com.baidu.navisdk.module.asr.instructions.b.b("当前位于" + b.g));
                        return;
                    }
                    com.baidu.navisdk.ui.routeguide.asr.c.n().l();
                    return;
                }
                com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            }
        }

        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            GeoPoint c;
            int i;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.8.2");
            com.baidu.navisdk.model.datastruct.g a2 = com.baidu.navisdk.util.logic.j.r().a();
            if (a2 == null || !a2.b()) {
                a2 = com.baidu.navisdk.util.logic.g.j().a();
            }
            if (a2 != null && (c = a2.c()) != null) {
                if (com.baidu.navisdk.framework.a.c().a() != null && !y.d(com.baidu.navisdk.framework.a.c().a())) {
                    i = 0;
                } else {
                    i = 1;
                }
                com.baidu.navisdk.poisearch.c.a(c, i, 3000, this.f8477a);
                return null;
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class l extends com.baidu.navisdk.asr.a {
        @Override // com.baidu.navisdk.asr.a
        public com.baidu.navisdk.framework.interfaces.asr.a a(com.baidu.navisdk.asr.model.a aVar) {
            String string;
            com.baidu.navisdk.module.asr.instructions.b.a("3.c.j.7.7");
            Bundle bundle = new Bundle();
            BNRouteGuider.getInstance().getRouteInfoInUniform(14, bundle);
            int i = bundle.getInt("trafficLight", 0);
            if (i != 0) {
                string = JarUtils.getResources().getString(R.string.asr_rg_traffic_light_count, Integer.valueOf(i));
            } else {
                string = JarUtils.getResources().getString(R.string.asr_rg_has_no_traffic_light);
            }
            return com.baidu.navisdk.module.asr.instructions.b.b(string);
        }
    }

    public static void a() {
        new d().a("remaining_time");
        new C0424e().a("remaining_distance");
        new f().a("remaining_distance_and_time");
        new g().a("ask_forward");
        new h().a("open_help");
        new i().a("traffic_info");
        new j().a("next_srv_area");
        new k().a("my_position");
        new l().a("traffic_signal_num");
        new a().a("speed_limit");
        new b().a("highway_node");
        new c().a("endnode_name");
    }
}
