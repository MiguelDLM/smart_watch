package com.baidu.navisdk.ui.routeguide.asr;

import com.baidu.navisdk.asr.c;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.asr.i.g;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.f;
import com.baidu.navisdk.module.asr.e;
import com.baidu.navisdk.util.common.l;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f8467a = false;
    private static com.baidu.navisdk.ui.routeguide.asr.b b;
    private static a.InterfaceC0201a c = new b();

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0418a implements c.a {
        @Override // com.baidu.navisdk.asr.c.a
        public boolean a() {
            return 2 == BNCommSettingManager.getInstance().getVoiceMode();
        }

        @Override // com.baidu.navisdk.asr.c.a
        public void stopTTS() {
            TTSPlayerControl.stopVoiceTTSOutput();
        }

        @Override // com.baidu.navisdk.asr.c.a
        public void a(String str) {
            TTSPlayerControl.playXDTTSText(str, 1);
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.InterfaceC0201a {
        @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
        public void onEvent(Object obj) {
            if ((obj instanceof f) && ((f) obj).f6828a) {
                c.n().a(1, true);
            }
        }
    }

    public static void a(boolean z) {
        f8467a = z;
    }

    public static void b() {
        d.B().a((g) null);
        d.B().a((com.baidu.navisdk.asr.i.f) null);
        d.B().a();
        c.n().j();
        com.baidu.navisdk.ui.routeguide.asr.b bVar = b;
        if (bVar != null) {
            bVar.f();
        }
        com.baidu.navisdk.asr.c.b();
        com.baidu.navisdk.framework.message.a.a().a(c);
    }

    public static void c() {
        HashMap<String, com.baidu.navisdk.asr.a> j;
        if (b == null) {
            b = new com.baidu.navisdk.ui.routeguide.asr.b();
        }
        b.e();
        d.B().a(b);
        d B = d.B();
        e eVar = e.INSTANCE;
        B.a(eVar);
        eVar.a("0");
        d.B().a(new com.baidu.navisdk.module.asr.c());
        com.baidu.navisdk.asr.c.a(new C0418a());
        if (com.baidu.navisdk.module.vehiclemanager.b.i().h()) {
            com.baidu.navisdk.ui.routeguide.asr.instruction.a.a(a());
        } else {
            com.baidu.navisdk.ui.routeguide.asr.instruction.a.a();
            if (com.baidu.navisdk.ui.routeguide.b.V().E() && (j = d.B().j()) != null) {
                j.remove("panel_simple_mode");
            }
        }
        c.n().a(d.B());
        if (BNSettingManager.getAsrCloseWakeUpPowerSave()) {
            c.n().a(1, true);
        }
        com.baidu.navisdk.framework.message.a.a().a(c, f.class, new Class[0]);
    }

    public static void a(int i) {
        if (i == 4102 && f8467a) {
            if (l.c(com.baidu.navisdk.framework.a.c().a())) {
                BNCommSettingManager.getInstance().setPowerSaveMode(0);
            }
            f8467a = false;
        }
    }

    public static HashSet<String> a() {
        return new HashSet<>();
    }
}
