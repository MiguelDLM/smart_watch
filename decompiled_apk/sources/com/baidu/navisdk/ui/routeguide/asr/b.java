package com.baidu.navisdk.ui.routeguide.asr;

import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.asr.i.f;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.asr.c;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.util.common.a0;
import com.baidu.navisdk.util.common.g;
import com.baidu.navisdk.util.jar.JarUtils;

/* loaded from: classes8.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private final TTSPlayerControl.e f8468a = new a(this);

    /* loaded from: classes8.dex */
    public class a extends TTSPlayerControl.f {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8469a = false;

        /* renamed from: com.baidu.navisdk.ui.routeguide.asr.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0419a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8470a;

            public RunnableC0419a(String str) {
                this.f8470a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar = g.ASR;
                if (gVar.d()) {
                    gVar.e("XDVoiceRGAsrProcessor", "onPlayStart() speechId = " + this.f8470a);
                }
                if (!TextUtils.isEmpty(this.f8470a) && this.f8470a.startsWith("ASRDisable-")) {
                    a.this.f8469a = true;
                    c.n().b(4, false);
                }
            }
        }

        /* renamed from: com.baidu.navisdk.ui.routeguide.asr.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC0420b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f8471a;

            public RunnableC0420b(String str) {
                this.f8471a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                g.ASR.e("XDVoiceRGAsrProcessor", "onPlayEnd() isDisableByTTS = " + a.this.f8469a + " speechid =" + this.f8471a);
                if (a.this.f8469a) {
                    a.this.f8469a = false;
                    c.n().b(4, true);
                }
            }
        }

        public a(b bVar) {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            com.baidu.navisdk.asr.f.a(new RunnableC0420b(str));
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            com.baidu.navisdk.asr.f.a(new RunnableC0419a(str));
        }
    }

    private void g() {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("XDVoice", "disposeStateBeforeEnterVoice curState = " + RouteGuideFSM.getInstance().getTopState());
        }
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.EnlargeRoadmap)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.MSG_ENLARGE_ROADMAP_HIDE);
            return;
        }
        if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.BrowseMap)) {
            BNMapController.getInstance().recoveryHighLightRoute();
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.BROWSER_STATE_EXIT);
        } else if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.NearbySearch)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_NEARBY_SEARCH);
        } else if (RouteGuideFSM.getInstance().getTopState().equals(RGFSMTable.FsmState.DynamicLayer)) {
            RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.EXIT_DYNAMIC_LAYER);
        }
    }

    private void h() {
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.VOICE_STATE_ENTRY, new Bundle());
    }

    private void i() {
        if (!RGFSMTable.FsmState.Voice.equals(RouteGuideFSM.getInstance().getTopState())) {
            RouteGuideFSM.getInstance().runRemoveState(RGFSMTable.FsmState.Voice);
        }
        RouteGuideFSM.getInstance().run(RGFSMTable.FsmEvent.VOICE_STATE_EXIT);
        x.b().s3();
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void a(boolean z, boolean z2) {
        com.baidu.navisdk.module.business.a.e().a();
        if (c.n().e()) {
            h();
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().H4();
        }
        com.baidu.navisdk.module.powersavemode.f.o().i();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(false);
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().J4();
    }

    @Override // com.baidu.navisdk.asr.i.f
    public boolean b() {
        return true;
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void c() {
        c.n().a(c.EnumC0421c.AID);
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void d() {
        if (c.n().e()) {
            g();
        }
    }

    public void e() {
        TTSPlayerControl.addTTSPlayStateListener(this.f8468a);
    }

    public void f() {
        TTSPlayerControl.removeTTSPlayStateListener(this.f8468a);
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void onStop() {
        TTSPlayerControl.stopVoiceTTSOutput();
        if (c.n().e()) {
            com.baidu.navisdk.ui.routeguide.b.V().w();
            s.T().m();
            if (!s.T().l(133)) {
                s.T().p();
            }
            i();
        } else {
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().L1();
            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().y0();
        }
        com.baidu.navisdk.module.powersavemode.f.o().d();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().v3();
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().M(true);
        c.n().a(c.EnumC0421c.NORMAL);
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void b(String str) {
        BNSettingManager.setXDInstructionCount(str, BNSettingManager.getXDInstructionCount(str) + 1);
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void a(int i) {
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.z", null, null, "1");
        if (!BNCommSettingManager.getInstance().isXDAwakened() && i == 0) {
            BNCommSettingManager.getInstance().setXDAwakened();
        }
        com.baidu.navisdk.behavrules.util.a.a().a(new com.baidu.navisdk.behavrules.event.b("asr_e_c_voice_up"));
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void a(com.baidu.navisdk.framework.interfaces.asr.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.d) || !aVar.d.contains(JarUtils.getResources().getString(R.string.nav_voice_disable_keyword))) {
            return;
        }
        aVar.i = "ASRDisable-";
    }

    @Override // com.baidu.navisdk.asr.i.f
    public boolean a() {
        if (com.baidu.navisdk.module.cloudconfig.f.c().c.v != 0) {
            return false;
        }
        try {
            if (com.baidu.navisdk.framework.a.c().a() != null) {
                if (com.baidu.navisdk.framework.a.c().a().getPackageManager().checkPermission("android.permission.RECORD_AUDIO", a0.g()) == 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            g.ASR.e("XDVoiceRGAsrProcessor", "isAsrCanWork Exception !!!! - " + e);
        }
        return false;
    }

    @Override // com.baidu.navisdk.asr.i.f
    public void a(String str) {
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().f(str);
    }
}
