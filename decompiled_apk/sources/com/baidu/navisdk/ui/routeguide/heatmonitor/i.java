package com.baidu.navisdk.ui.routeguide.heatmonitor;

import android.text.TextUtils;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.ui.routeguide.control.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class i implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {

    /* renamed from: a, reason: collision with root package name */
    private final com.baidu.navisdk.ui.routeguide.heatmonitor.j f8628a;
    private final List<com.baidu.navisdk.ui.routeguide.heatmonitor.i.b> b;

    /* loaded from: classes8.dex */
    public class b implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.b() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "disable_asr", gVar.b() + "", i.this.f8628a.a() + "");
            }
            if (gVar.b() == 1) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().b(9, false);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h5();
            } else if (gVar.b() == 0) {
                com.baidu.navisdk.ui.routeguide.asr.c.n().b(9, true);
                com.baidu.navisdk.ui.routeguide.mapmode.a.o5().h5();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.heatmonitor.i$i, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0443i implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private C0443i(i iVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
        }
    }

    /* loaded from: classes8.dex */
    public class m implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private m() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.d() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "disable_detector", gVar.d() + "", i.this.f8628a.a() + "");
            }
            if (com.baidu.navisdk.j.d()) {
                if (gVar.d() == 1) {
                    com.baidu.navisdk.module.vmsr.c.f().b();
                } else if (gVar.d() == 0) {
                    com.baidu.navisdk.module.vmsr.c.f().a(com.baidu.navisdk.framework.a.c().a());
                }
            }
        }
    }

    public i(com.baidu.navisdk.ui.routeguide.heatmonitor.j jVar) {
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.add(new m());
        arrayList.add(new l());
        arrayList.add(new b());
        arrayList.add(new k());
        arrayList.add(new h());
        arrayList.add(new f());
        arrayList.add(new g());
        arrayList.add(new j());
        arrayList.add(new C0443i());
        arrayList.add(new c());
        arrayList.add(new e());
        arrayList.add(new d());
        this.f8628a = jVar;
    }

    @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
    public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
        if (gVar == null) {
            return;
        }
        Iterator<com.baidu.navisdk.ui.routeguide.heatmonitor.i.b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a(gVar);
        }
    }

    @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
    public void a() {
        Iterator<com.baidu.navisdk.ui.routeguide.heatmonitor.i.b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* loaded from: classes8.dex */
    public class e implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private e() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.g() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "expand_hide_type", gVar.g() + "", i.this.f8628a.a() + "");
                BNRouteGuider.getInstance().setExpandHideType(gVar.g());
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            BNRouteGuider.getInstance().setExpandHideType(0);
        }
    }

    /* loaded from: classes8.dex */
    public class h implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private h() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.j() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "link_road", gVar.j() + "", i.this.f8628a.a() + "");
                JNIGuidanceControl.getInstance().setGetPointsFrequency(gVar.j());
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            JNIGuidanceControl.getInstance().setGetPointsFrequency(1000);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private c() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.a() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "avoid_expand", gVar.a() + "", i.this.f8628a.a() + "");
                q.c().a(gVar.a() != 1);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            q.c().a(true);
        }
    }

    /* loaded from: classes8.dex */
    public class f implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private f() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.k() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "fps", gVar.k() + "", i.this.f8628a.a() + "");
                com.baidu.nplatform.comapi.map.j mapController = BNMapController.getInstance().getMapController();
                if (mapController != null) {
                    mapController.g(gVar.k());
                }
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            com.baidu.nplatform.comapi.map.j mapController = BNMapController.getInstance().getMapController();
            if (mapController != null) {
                mapController.g(0);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b, a.InterfaceC0201a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8631a;

        private d() {
            this.f8631a = false;
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.f() == -1 || this.f8631a || BNCommSettingManager.getInstance().getVoiceMode() != 0) {
                return;
            }
            com.baidu.navisdk.ui.routeguide.module.diyspeak.e eVar = com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f;
            if (eVar.a(true) == 0) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "diy_model", gVar.f() + "", i.this.f8628a.a() + "");
                eVar.a(6, gVar.f());
                com.baidu.navisdk.framework.message.a.a().a(this, com.baidu.navisdk.behavrules.event.b.class, new Class[0]);
            }
        }

        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if (obj instanceof com.baidu.navisdk.behavrules.event.b) {
                String a2 = ((com.baidu.navisdk.behavrules.event.b) obj).a();
                if (TextUtils.equals(a2, "asr_e_c_voice_diy_mode_simple") || TextUtils.equals(a2, "asr_e_c_voice_diy_mode_detail") || TextUtils.equals(a2, "asr_e_c_voice_diy_mode_custom") || TextUtils.equals(a2, "asr_e_c_voice_diy_mode_standard") || TextUtils.equals(a2, "asr_e_c_voice_mode_justwarning") || TextUtils.equals(a2, "asr_e_c_voice_mode_justwarning_inset") || TextUtils.equals(a2, "asr_e_c_voice_mode_play") || TextUtils.equals(a2, "asr_e_c_voice_mode_play_inset") || TextUtils.equals(a2, "asr_e_c_voice_mode_quiet") || TextUtils.equals(a2, "asr_e_c_voice_mode_quiet_inset")) {
                    com.baidu.navisdk.framework.message.a.a().a((a.InterfaceC0201a) this);
                }
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            com.baidu.navisdk.framework.message.a.a().a((a.InterfaceC0201a) this);
        }
    }

    /* loaded from: classes8.dex */
    public class j implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private j() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.c() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "disable_animation", gVar.c() + "", i.this.f8628a.a() + "");
            }
            if (gVar.c() == 1) {
                JNIBaseMap.setDynamicEffects(false);
            } else if (gVar.c() == 0) {
                JNIBaseMap.setDynamicEffects(true);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            JNIBaseMap.setDynamicEffects(true);
        }
    }

    /* loaded from: classes8.dex */
    public class k implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private k() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.e() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "disable_poi", gVar.e() + "", i.this.f8628a.a() + "");
            }
            if (gVar.e() == 1) {
                BNMapController.getInstance().setMapPoiScene(false);
            } else if (gVar.e() == 0) {
                BNMapController.getInstance().setMapPoiScene(true);
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            BNMapController.getInstance().setMapPoiScene(true);
        }
    }

    /* loaded from: classes8.dex */
    public class l implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private l() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.m()) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "disable_vdr", gVar.m() + "", i.this.f8628a.a() + "");
                com.baidu.navisdk.module.vdr.a.d(0);
                com.baidu.navisdk.module.vdr.a.d(3);
                com.baidu.navisdk.module.vdr.a.a(false);
                com.baidu.navisdk.module.vdr.a.d();
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            com.baidu.navisdk.module.vdr.a.a(true);
        }
    }

    /* loaded from: classes8.dex */
    public class g implements com.baidu.navisdk.ui.routeguide.heatmonitor.i.b {
        private g() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a(com.baidu.navisdk.ui.routeguide.heatmonitor.g gVar) {
            if (gVar.k() != -1) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.18.1.1", "hd_fps", gVar.k() + "", i.this.f8628a.a() + "");
                com.baidu.navisdk.ui.routeguide.navicenter.c j = com.baidu.navisdk.ui.routeguide.b.V().j();
                if (j != null) {
                    com.baidu.navisdk.framework.interfaces.pronavi.multinavi.b c = j.c(true);
                    if (c != null) {
                        c.b(gVar.h());
                        c.d(gVar.i());
                    }
                    com.baidu.navisdk.pronavi.hd.normal.i.a d = j.d(true);
                    if (d != null) {
                        d.b(gVar.l());
                    }
                }
            }
        }

        @Override // com.baidu.navisdk.ui.routeguide.heatmonitor.i.b
        public void a() {
            com.baidu.nplatform.comapi.map.j mapController = BNMapController.getInstance().getMapController();
            if (mapController != null) {
                mapController.g(0);
            }
        }
    }
}
