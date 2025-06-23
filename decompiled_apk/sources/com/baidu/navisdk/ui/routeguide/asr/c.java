package com.baidu.navisdk.ui.routeguide.asr;

import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.navisdk.asr.d;
import com.baidu.navisdk.asr.f;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.j;
import com.baidu.navisdk.ui.routeguide.model.x;
import com.baidu.navisdk.util.common.g;

/* loaded from: classes8.dex */
public class c {
    private static c g;

    /* renamed from: a, reason: collision with root package name */
    private d f8472a;
    EnumC0421c b = EnumC0421c.NORMAL;
    private boolean c = true;
    private final com.baidu.navisdk.util.worker.loop.a d = new a("behavRules");
    private final SparseArray<Boolean> e = new SparseArray<>();
    private final SparseArray<Boolean> f = new SparseArray<>();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.a {
        public a(String str) {
            super(str);
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            int i = message.arg1;
            if (message.what == 5556) {
                if (i != 1) {
                    if (i != 3) {
                        if (i == 4) {
                            c.this.a(false);
                            return;
                        }
                        return;
                    }
                    c.this.a(true);
                    return;
                }
                c.this.a(true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.asr.i.a {
        public b() {
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void a(String str, boolean z) {
            super.a(str, z);
            if (TextUtils.equals(str, "personalize_route")) {
                if (z) {
                    com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE.a(true);
                } else {
                    com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.j.7.5", com.baidu.navisdk.ui.routeguide.asr.instruction.d.INSTANCE.a(), "3", null);
                }
            }
            c.this.d(z);
        }

        @Override // com.baidu.navisdk.asr.i.a
        public void b() {
            if (x.A().f8982a) {
                com.baidu.navisdk.ui.routeguide.b.V().a(2, true);
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.asr.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public enum EnumC0421c {
        NORMAL,
        AID
    }

    private c() {
    }

    public static c n() {
        if (g == null) {
            synchronized (c.class) {
                try {
                    if (g == null) {
                        g = new c();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public void b(boolean z) {
        b(2, z);
    }

    public boolean c() {
        int i = 0;
        for (int i2 = 0; i2 < this.e.size(); i2++) {
            Boolean bool = this.e.get(this.e.keyAt(i2));
            if (bool == null) {
                g.ASR.e("XDVoice", "setwake error, return");
                return false;
            }
            if (!bool.booleanValue()) {
                i++;
            }
        }
        if (i != 1 || (a(1) && a(9))) {
            return (i != 2 || a(1) || a(9)) ? false : true;
        }
        return true;
    }

    public boolean d() {
        return this.b == EnumC0421c.AID;
    }

    public boolean e() {
        if (this.b == EnumC0421c.NORMAL) {
            return true;
        }
        return false;
    }

    public boolean f() {
        if (i() && e()) {
            return true;
        }
        return false;
    }

    public boolean g() {
        return this.c;
    }

    public boolean h() {
        d dVar = this.f8472a;
        if (dVar != null) {
            return dVar.q();
        }
        return false;
    }

    public boolean i() {
        d dVar = this.f8472a;
        if (dVar != null) {
            return dVar.r();
        }
        return false;
    }

    public void j() {
        this.f8472a = null;
        this.e.clear();
        this.f.clear();
        if (j.d()) {
            com.baidu.navisdk.util.listener.a.b(this.d);
        }
    }

    public boolean k() {
        if (this.f8472a != null) {
            b(3, true);
            return true;
        }
        return false;
    }

    public void l() {
        c(true);
    }

    public boolean m() {
        d dVar = this.f8472a;
        if (dVar != null) {
            return dVar.t();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z) {
        if (!x.A().f8982a) {
            g.ASR.e("XDVoice", "route recommend view has hide");
            return;
        }
        if (z) {
            com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.b", "aj", "1", null);
            com.baidu.navisdk.ui.routeguide.b.V().a(3, true);
            return;
        }
        com.baidu.navisdk.util.statistic.userop.b.r().a("3.c.b", "aj", "0", null);
        l();
        if (x.A().f8982a) {
            com.baidu.navisdk.ui.routeguide.b.V().a(4, true);
        }
    }

    public void a(d dVar) {
        this.f8472a = dVar;
        this.e.clear();
        this.f.clear();
        if (j.d()) {
            com.baidu.navisdk.util.listener.a.a(this.d);
        }
    }

    public void b(int i, boolean z) {
        g gVar = g.ASR;
        gVar.e("XDVoice", "setWakeupEnable key: " + i + " enable:" + z);
        f.d();
        if (this.f.get(i) != null) {
            gVar.e("XDVoice", "setWakeupEnable controllEnable enable" + this.f.get(i));
            z = this.f.get(i).booleanValue();
        }
        this.e.put(i, Boolean.valueOf(z));
        if (z) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                int keyAt = this.e.keyAt(i2);
                Boolean bool = this.e.get(keyAt);
                g gVar2 = g.ASR;
                gVar2.e("XDVoice", "key:" + keyAt + " result:" + bool);
                if (bool == null) {
                    gVar2.e("XDVoice", "setwake error, return");
                    return;
                } else {
                    if (!bool.booleanValue()) {
                        if (c()) {
                            com.baidu.navisdk.ui.routeguide.mapmode.a.o5().P(true);
                        }
                        gVar2.e("XDVoice", "has disable result, return");
                        return;
                    }
                }
            }
        }
        g.ASR.e("XDVoice", "setWakeupEnable > " + z);
        d dVar = this.f8472a;
        if (dVar != null) {
            dVar.b(z);
        }
        if (c()) {
            return;
        }
        com.baidu.navisdk.ui.routeguide.mapmode.a.o5().P(z);
    }

    public void a(boolean z) {
        g.ASR.e("XDVoice", "setPhoneIn > " + z);
        b(6, z ^ true);
    }

    public void c(boolean z) {
        d dVar = this.f8472a;
        if (dVar == null || !dVar.r()) {
            return;
        }
        if (z || e()) {
            TTSPlayerControl.stopVoiceTTSOutput();
            this.f8472a.b();
        }
    }

    public void a(int i, boolean z) {
        g gVar = g.TTS;
        if (gVar.d()) {
            gVar.e("XDVoice", "setControllEnable(), key = " + i + " enable = " + z);
        }
        this.f.put(i, Boolean.valueOf(z));
        b(i, z);
    }

    public boolean a(int i) {
        if (this.e.get(i) == null) {
            return true;
        }
        return this.e.get(i).booleanValue();
    }

    public boolean a() {
        g.ASR.e("XDVoice", "closeWakeupTemporary mManager is " + this.f8472a);
        if (this.f8472a == null) {
            return false;
        }
        b(3, false);
        return true;
    }

    public void a(EnumC0421c enumC0421c) {
        this.b = enumC0421c;
    }

    public void a(String str, int i) {
        String str2;
        g.ASR.e("XDVoice", "askRouteRecommend() - tips: " + str);
        if (i == 6) {
            str2 = "personalize_route";
        } else if (i == 1) {
            str = str + "，需要切换吗？";
            str2 = "avoid_congestion";
        } else if (i == 2) {
            str = str + "，需要切换吗？";
            str2 = "route_recommend";
        } else {
            str = str + "，需要切换吗？";
            str2 = "route_recommend_passively";
        }
        boolean x = x.A().x();
        d dVar = this.f8472a;
        if (dVar != null) {
            dVar.a(str, str2, new b(), x);
        }
    }

    public boolean b() {
        return com.baidu.navisdk.module.cloudconfig.f.c().c.v != 0;
    }
}
