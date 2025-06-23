package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.embed.R;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.module.cloudconfig.f;
import com.baidu.navisdk.ui.routeguide.control.s;
import com.baidu.navisdk.ui.routeguide.control.x;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.i0;
import com.baidu.navisdk.util.common.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes8.dex */
public class e implements com.baidu.navisdk.framework.interfaces.diyspeak.b {
    public static final e f = new e();
    private volatile g c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f9001a = false;
    private boolean d = false;
    private int e = 0;
    f b = new f();

    /* loaded from: classes8.dex */
    public class a implements i0.f {
        public a() {
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void a() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "onAutoHideWithoutClick");
            }
            e.this.f9001a = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.2.2", "1", "3", null);
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void b() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "onCancelBtnClick");
            }
            e.this.f9001a = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.2.2", "1", "2", null);
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            BNSettingManager.setDiySwitchGuideShowTimes(2);
        }

        @Override // com.baidu.navisdk.ui.routeguide.mapmode.subview.i0.f
        public void c() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "onConfirmBtnClick");
            }
            e.this.f9001a = true;
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.2.2", "1", "1", null);
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            BNSettingManager.setDiyVoiceMode(0);
            e.this.b(0);
            e.this.b(true);
            BNSettingManager.setDiySwitchGuideShowTimes(2);
            TTSPlayerControl.playXDTTSText("已为您切换到标准模式播报", 1);
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.asr.i.a {
        public b() {
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void a(String str, boolean z) {
            super.a(str, z);
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "intention :" + str + ", result : " + z);
            }
            e.this.f9001a = true;
            BNSettingManager.setDiySwitchGuideShowTimes(2);
            s.T().p();
            com.baidu.navisdk.ui.routeguide.asr.c.n().l();
            if (z) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("z.2.2", "2", "1", null);
                BNSettingManager.setDiyVoiceMode(0);
                e.this.b(0);
                e.this.b(true);
                TTSPlayerControl.playXDTTSText("已为您切换到标准模式播报", 1);
                return;
            }
            com.baidu.navisdk.util.statistic.userop.b.r().a("z.2.2", "2", "2", null);
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
            LogUtil.e("DiySpeak", "showDiySwitchToStandardModeGuide stop");
            if (!e.this.f9001a) {
                com.baidu.navisdk.util.statistic.userop.b.r().a("z.2.2", "2", "3", null);
                s.T().p();
            }
        }
    }

    private e() {
    }

    private String g() {
        int voiceMode;
        int c;
        int i;
        int i2;
        if (!e() || com.baidu.navisdk.module.pronavi.a.j == 2 || !com.baidu.navisdk.function.b.FUNC_DIY_NONLOCAL_GUIDE_TIPS.a() || BNSettingManager.getDiySwitchGuideShowTimes() >= 2 || 2 == (voiceMode = BNCommSettingManager.getInstance().getVoiceMode()) || 3 == voiceMode || ((c = c()) != 6 && c != 1)) {
            return null;
        }
        if (!s.T().b(119)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "diy allowCommonNotificationShow false");
            }
            return null;
        }
        if (BNRoutePlaner.getInstance().B()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "diy guide is offline");
            }
            return null;
        }
        com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
        RoutePlanNode g = fVar.g();
        RoutePlanNode o = fVar.o();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeak", "diy guide,endNode:" + g);
            LogUtil.e("DiySpeak", "diy guide,startNode:" + o);
        }
        if (o != null && (i2 = o.mDistrictID) > 0 && com.baidu.navisdk.framework.b.f(i2)) {
            return "当前不在常驻地，需要切换到标准模式播报吗？";
        }
        if ((g != null && (i = g.mDistrictID) > 0 && com.baidu.navisdk.framework.b.f(i)) || com.baidu.navisdk.util.common.h.a() > 100000) {
            return "行驶陌生路段，需要切换到标准模式播报吗？";
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeak", "diy guide is offline");
        }
        return null;
    }

    public g b() {
        if (this.c == null) {
            synchronized (e.class) {
                try {
                    if (this.c == null) {
                        this.c = new g();
                    }
                } finally {
                }
            }
        }
        return this.c;
    }

    @Override // com.baidu.navisdk.framework.interfaces.diyspeak.b
    public int c() {
        return a(false);
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return BNCommSettingManager.getInstance().getDiyVoiceModeOpen();
    }

    public void f() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeak", "showDiySwitchToStandardModeGuide start");
        }
        String g = g();
        if (TextUtils.isEmpty(g)) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "showDiySwitchToStandardModeGuide tips null");
                return;
            }
            return;
        }
        this.f9001a = false;
        boolean y = x.b().k(119).D(100).v(30000).z(2).a(g).d(com.baidu.navisdk.ui.util.b.f(R.drawable.nsdk_notification_route_recommend)).g(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_ok)).f(com.baidu.navisdk.ui.util.b.h(R.string.nsdk_string_rg_faster_route_btn_cancle)).A(true).a(new a()).y();
        if (!y) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeak", "diy guide show ret:" + y);
                return;
            }
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().b("z.2.1");
        BNSettingManager.setDiySwitchGuideShowTimes(BNSettingManager.getDiySwitchGuideShowTimes() + 1);
        TTSPlayerControl.stopVoiceTTSOutput();
        TTSPlayerControl.playFastRouteVoice();
        TTSPlayerControl.resumeVoiceTTSOutput();
        int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
        if ((2 == voiceMode || 3 == voiceMode) && !com.baidu.navisdk.ui.routeguide.model.x.A().x()) {
            return;
        }
        Context a2 = com.baidu.navisdk.framework.a.c().a();
        if (com.baidu.navisdk.asr.query.a.a(a2).b("diy_node_strange")) {
            com.baidu.navisdk.asr.query.a.a(a2).a("diy_node_strange");
            com.baidu.navisdk.asr.d.B().a(g, "diy_player_mid", (com.baidu.navisdk.asr.i.a) new b(), false);
        } else {
            TTSPlayerControl.playXDTTSText(g, 1);
        }
    }

    private void c(int i) {
        if (i == 3) {
            i = c();
        }
        if (i == 6 || i == 7 || i == 1 || i == 0) {
            this.e = i;
        }
    }

    @Override // com.baidu.navisdk.framework.interfaces.diyspeak.b
    public void a(JSONArray jSONArray) {
        f.o oVar = com.baidu.navisdk.module.cloudconfig.f.c().f;
        if (oVar != null) {
            if (!oVar.f7128a) {
                BNCommSettingManager.getInstance().setDiyVoiceModeOpen(false);
                int diyVoiceMode = BNCommSettingManager.getInstance().getDiyVoiceMode();
                BNSettingManager.setDiyVoiceMode(diyVoiceMode == 1 ? diyVoiceMode : 0);
            }
            if (oVar.b) {
                BNCommSettingManager.getInstance().setDiyVoiceModeOpen(true);
            }
        }
        if (jSONArray != null) {
            try {
                this.b.a(jSONArray);
            } catch (JSONException e) {
                if (LogUtil.LOGGABLE) {
                    LogUtil.printException("parseCloudConfig", e);
                }
            }
        }
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void b(int i) {
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e("diyspeak", "setVoiceMode :" + i);
        }
        c(i);
        if (i == 3) {
            i = 0;
        }
        BNRouteGuider.getInstance().setVoiceMode(i);
    }

    public int a(boolean z) {
        if (z && this.d) {
            return a(d());
        }
        return a(BNCommSettingManager.getInstance().getDiyVoiceMode());
    }

    public int a(int i) {
        return e() ? i : i == 1 ? 1 : 0;
    }

    public f a() {
        return this.b;
    }

    public void a(int i, long j) {
        if (LogUtil.LOGGABLE) {
            com.baidu.navisdk.util.common.g.ROUTE_GUIDE.e("diyspeak", "setVoiceMode custom diyModeValue :" + j + ", " + i);
        }
        c(i);
        BNRouteGuider.getInstance().setVoiceMode(i, j);
    }
}
