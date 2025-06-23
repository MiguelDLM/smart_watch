package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.content.Context;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.g0;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private i0 f9012a;
    private i0 b;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.m c;
    private com.baidu.navisdk.ui.routeguide.mapmode.subview.m d;

    /* loaded from: classes8.dex */
    public class a implements g0.d {
        public a(h hVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showChangeShortModeGuide onDismiss() ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements i0.f {
        public b() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showChangeShortModeGuide onAutoHideWithoutClick() ");
            }
            com.baidu.navisdk.asr.d.B().c();
            h.this.c();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.1", "", "0", null);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showChangeShortModeGuide onCancelBtnClick() ");
            }
            com.baidu.navisdk.asr.d.B().c();
            h.this.c();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.1", "", null, "0");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showChangeShortModeGuide onConfirmBtnClick() ");
            }
            com.baidu.navisdk.asr.d.B().v();
            com.baidu.navisdk.asr.d.B().c();
            com.baidu.navisdk.ui.routeguide.module.diyspeak.e eVar = com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f;
            eVar.b(true);
            eVar.b(1);
            h.this.e();
        }
    }

    /* loaded from: classes8.dex */
    public class c extends com.baidu.navisdk.asr.i.a {
        public c() {
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void a(String str, boolean z) {
            super.a(str, z);
            s.T().p();
            com.baidu.navisdk.asr.d.B().v();
            com.baidu.navisdk.asr.d.B().c();
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.1", "", null, "1");
                com.baidu.navisdk.ui.routeguide.module.diyspeak.e eVar = com.baidu.navisdk.ui.routeguide.module.diyspeak.e.f;
                eVar.b(true);
                eVar.b(1);
                h.this.e();
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.1", "", "1", null);
            h.this.c();
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
            s.T().p();
            h.this.c();
        }
    }

    /* loaded from: classes8.dex */
    public class d implements g0.d {
        public d(h hVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "onDismiss() ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements g0.d {
        public e(h hVar) {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.g0.d
        public void a() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showAutoSwitchGuide onDismiss() ");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements i0.f {
        public f() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showAutoSwitchGuide onAutoHideWithoutClick() ");
            }
            com.baidu.navisdk.asr.d.B().c();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.2", "", "0", null);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showAutoSwitchGuide onCancelBtnClick() ");
            }
            com.baidu.navisdk.asr.d.B().c();
            h.this.b();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.2", "", null, "0");
            if (LogUtil.LOGGABLE) {
                LogUtil.e("BNDiySpeakMusicNotification", "showAutoSwitchGuide onConfirmBtnClick() ");
            }
            com.baidu.navisdk.asr.d.B().c();
            h.this.d();
        }
    }

    /* loaded from: classes8.dex */
    public class g extends com.baidu.navisdk.asr.i.a {
        public g() {
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void a(String str, boolean z) {
            super.a(str, z);
            com.baidu.navisdk.asr.d.B().c();
            s.T().p();
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.2", "", null, "1");
                h.this.d();
            } else {
                com.baidu.navisdk.util.statistic.userop.b.r().a("3.i.2", "", "1", null);
                h.this.b();
            }
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        i0 a2 = x.b().k(121).D(100).v(-1).z(2).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_quiet_mode_close)).a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_auto_switch_short_mode)).b(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_auto_switch_short_mode_subtitle)).g("需要").f("取消").A(true).a(new f()).a(new e(this));
        this.b = a2;
        a2.y();
        String h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_auto_switch_short_mode_voice);
        if (com.baidu.navisdk.asr.query.a.a(com.baidu.navisdk.framework.a.c().a()).b("diy_music_2")) {
            com.baidu.navisdk.asr.d.B().a(h, "diy_music_auto_switch_guide", (com.baidu.navisdk.asr.i.a) new g(), false);
        } else {
            TTSPlayerControl.playXDTTSText(h, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        BNCommSettingManager.getInstance().setDiySpeakAutoChangeAidCancelCount(BNCommSettingManager.getInstance().getDiySpeakAutoChangAidCancelCount() + 1);
        if (BNCommSettingManager.getInstance().getDiySpeakAutoChangAidCancelCount() == 2) {
            TTSPlayerControl.playXDTTSText(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_later_setting), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("BNDiySpeakMusicNotification", "cancelChangeShortModeGuide() ");
        }
        BNCommSettingManager.getInstance().setDiySpeakMusicAidCount(2);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m mVar = this.c;
        if (mVar == null || !mVar.a()) {
            com.baidu.navisdk.ui.routeguide.mapmode.subview.m z = x.b().j(121).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_continue_now_mode)).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_fail)).z(100);
            this.c = z;
            z.a(new d(this));
            this.c.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        BNCommSettingManager.getInstance().setDiySpeakMusicAidCount(2);
        BNCommSettingManager.getInstance().setDiySpeakAutoChangeInMusic(true);
        com.baidu.navisdk.ui.routeguide.mapmode.subview.m z = x.b().j(121).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_save_setting)).b(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_success)).z(100);
        this.d = z;
        z.y();
    }

    public void a() {
        i0 a2 = x.b().k(120).D(100).v(-1).z(2).A(true).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_quiet_mode_close)).a(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_notifi_short_mode)).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_ok)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_notify_cancel)).a(new b()).a(new a(this));
        this.f9012a = a2;
        a2.y();
        String h = com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_diy_speak_music_notifi_short_mode_voice);
        TTSPlayerControl.stopVoiceTTSOutput();
        TTSPlayerControl.playFastRouteVoice();
        TTSPlayerControl.resumeVoiceTTSOutput();
        Context a3 = com.baidu.navisdk.framework.a.c().a();
        if (com.baidu.navisdk.asr.query.a.a(a3).b("diy_music")) {
            com.baidu.navisdk.asr.query.a.a(a3).a("diy_music");
            com.baidu.navisdk.asr.d.B().a(h, "diy_set_mid_when_music_play", (com.baidu.navisdk.asr.i.a) new c(), false);
        } else {
            TTSPlayerControl.playXDTTSText(h, 1);
        }
    }
}
