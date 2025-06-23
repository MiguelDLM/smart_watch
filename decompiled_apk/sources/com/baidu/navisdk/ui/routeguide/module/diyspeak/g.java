package com.baidu.navisdk.ui.routeguide.module.diyspeak;

import android.media.AudioManager;
import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.comapi.routeguide.RouteGuideParams;
import com.baidu.navisdk.comapi.setting.BNCommSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.framework.message.a;
import com.baidu.navisdk.framework.message.bean.e;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.routeguide.model.a0;
import com.baidu.navisdk.util.common.LogUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.openalliance.ad.constant.x;

/* loaded from: classes8.dex */
public class g implements a.InterfaceC0201a {
    private int d;
    private AudioManager j;
    private h k;

    /* renamed from: a, reason: collision with root package name */
    private int f9008a = 0;
    private long b = 0;
    private int c = x.ac;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private boolean i = true;
    private boolean l = false;
    private com.baidu.navisdk.util.worker.f<String, String> m = new a("BNDiySpeakMusic", null);
    private com.baidu.navisdk.util.worker.loop.a n = new b();
    private TTSPlayerControl.e o = new c();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.f {
        public a(String str, Object obj) {
            super(str, obj);
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public Object execute() {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "execute() ");
            }
            if (g.this.g()) {
                g.this.k();
            } else {
                if (g.this.j == null) {
                    return null;
                }
                boolean isMusicActive = g.this.j.isMusicActive();
                boolean O2 = com.baidu.navisdk.ui.routeguide.control.x.b().O2();
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "execute() mPreMusicActive · = " + g.this.i + " isNowMusicActive = " + isMusicActive + " recordTime = " + g.this.f9008a + " isVdrGuide = " + O2);
                }
                if ((!g.this.i && !isMusicActive) || O2) {
                    g.this.f9008a = 0;
                } else {
                    g.b(g.this, 5000);
                }
                if (g.this.a()) {
                    g.this.j();
                    g.this.d();
                    return null;
                }
                g.this.i = isMusicActive;
                g.this.k();
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class b extends com.baidu.navisdk.util.worker.loop.a {
        public b() {
        }

        @Override // com.baidu.navisdk.util.worker.loop.a
        public void onMessage(Message message) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "handlePhoneMsg() message is " + message);
            }
            if (message.what == 5556) {
                int i = message.arg1;
                if (i == 1 || i == 3) {
                    g.this.h = true;
                    g.this.h();
                } else if (i == 4) {
                    g.this.h = false;
                    g.this.i();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends TTSPlayerControl.f {
        public c() {
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void a(String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "onPlayStart() ");
            }
            g.this.g = true;
            g.this.h();
        }

        @Override // com.baidu.navisdk.comapi.tts.TTSPlayerControl.e
        public void onPlayEnd(String str) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "onPlayEnd() ");
            }
            g.this.g = false;
            g.this.i();
        }
    }

    public g() {
        try {
            this.k = new h();
            AudioManager audioManager = (AudioManager) com.baidu.navisdk.framework.a.c().a().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            this.j = audioManager;
            if (audioManager == null && LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "BNDiySpeakMusicMonitor() audioManager is null");
            }
        } catch (Exception e) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "constructor error is " + e.getMessage());
            LogUtil.printCallStack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "onInterruptEventStop() hasEventInterrpted = " + this.e + " isInXD = " + this.f + " isInTTS = " + this.g + " isInPhoning = " + this.h);
        }
        if (!this.f && !this.g && !this.h) {
            if (this.e) {
                this.e = false;
                k();
            } else if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "onInterruptEventStop() in special");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int b2 = com.baidu.navisdk.util.common.h.b();
        Bundle k = a0.I().k();
        if (k != null && k.containsKey(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime)) {
            b2 = k.getInt(RouteGuideParams.RGKey.SimpleGuideInfo.TotalTime);
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "showNotificationOrChangeMode() remainTime = " + b2 + " type is " + this.d);
        }
        e eVar = e.f;
        if (eVar.c() != 1 && eVar.c() != 6) {
            int i = this.d;
            if (i != 1) {
                if (i == 2) {
                    eVar.b(true);
                    eVar.b(1);
                    return;
                }
                return;
            }
            int voiceMode = BNCommSettingManager.getInstance().getVoiceMode();
            if (voiceMode != 2 && voiceMode != 3) {
                if (!com.baidu.navisdk.ui.routeguide.asr.c.n().h()) {
                    if (LogUtil.LOGGABLE) {
                        LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "showNotificationOrChangeMode() wakeUpEnable = false, return ");
                        return;
                    }
                    return;
                } else {
                    if (b2 < 600) {
                        return;
                    }
                    BNCommSettingManager.getInstance().setDiySpeakMusicAidCount(BNCommSettingManager.getInstance().getDiySpeakMusicAidCount() + 1);
                    this.k.a();
                    return;
                }
            }
            return;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "showNotificationOrChangeMode() mode is " + eVar.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.b = System.currentTimeMillis();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "startTask() mRecordedTimeTag = " + this.b);
        }
        com.baidu.navisdk.util.worker.c.a().a(this.m, new com.baidu.navisdk.util.worker.e(12, 0), 5000L);
    }

    @Override // com.baidu.navisdk.framework.message.a.InterfaceC0201a
    public void onEvent(Object obj) {
        if (obj instanceof com.baidu.navisdk.framework.message.bean.e) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "xd onEvent() " + ((com.baidu.navisdk.framework.message.bean.e) obj).b);
            }
            e.a aVar = ((com.baidu.navisdk.framework.message.bean.e) obj).b;
            if (aVar == e.a.START) {
                this.f = true;
                h();
            } else if (aVar == e.a.FINISH || aVar == e.a.CANCEL) {
                this.f = false;
                i();
            }
        }
    }

    public static /* synthetic */ int b(g gVar, int i) {
        int i2 = gVar.f9008a + i;
        gVar.f9008a = i2;
        return i2;
    }

    private boolean e() {
        int i;
        int i2;
        if (!com.baidu.navisdk.j.d()) {
            return false;
        }
        e eVar = e.f;
        if (eVar.a(true) != 1 && eVar.a(true) != 6) {
            com.baidu.navisdk.model.modelfactory.f fVar = (com.baidu.navisdk.model.modelfactory.f) com.baidu.navisdk.model.modelfactory.c.a().a("RoutePlanModel");
            RoutePlanNode g = fVar.g();
            RoutePlanNode o = fVar.o();
            boolean z = o != null && (i2 = o.mDistrictID) > 0 && com.baidu.navisdk.framework.b.f(i2);
            boolean z2 = (g != null && (i = g.mDistrictID) > 0 && com.baidu.navisdk.framework.b.f(i)) || com.baidu.navisdk.util.common.h.a() > 100000;
            if (!z2 && !z) {
                if (com.baidu.navisdk.module.pronavi.a.j != 2) {
                    return true;
                }
                if (LogUtil.LOGGABLE) {
                    LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "canStart() isDemoGPS");
                }
                return false;
            }
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "canStart() isEndNodeStrange = " + z2 + " isStartNodeStrange = " + z);
            }
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "canStart() mode is " + eVar.a(true));
        }
        return false;
    }

    private void f() {
        com.baidu.navisdk.util.worker.c.a().a((com.baidu.navisdk.util.worker.g) this.m, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        if (com.baidu.navisdk.asr.d.B().r()) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "hasInterruptEvent() xd is waking");
            }
            return true;
        }
        if (com.baidu.navisdk.util.common.b.b().a() != 0) {
            if (LogUtil.LOGGABLE) {
                LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "hasInterruptEvent() phone is not idle");
            }
            return true;
        }
        if (!TTSPlayerControl.getTTSPlayStatus()) {
            return false;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "hasInterruptEvent() tts is playing");
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "onInterruptEventStart() mHasEventInterrupted = " + this.e + " isInXD = " + this.f + " isInTTS = " + this.g + " isInPhoning = " + this.h + " mPreMusicActive = " + this.i + " mRecordedTimeTag = " + this.b);
        }
        if (this.f || this.g || this.h) {
            if (!this.e) {
                if (this.i) {
                    this.f9008a = (int) (this.f9008a + (System.currentTimeMillis() - this.b));
                }
                f();
            }
            this.e = true;
        }
    }

    public void d() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "stop() ");
        }
        this.l = false;
        f();
        com.baidu.navisdk.util.listener.a.b(this.n);
        TTSPlayerControl.removeTTSPlayStateListener(this.o);
        com.baidu.navisdk.framework.message.a.a().a((a.InterfaceC0201a) this);
    }

    public void c() {
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "start() isStarted = " + this.l);
        }
        if (e()) {
            if (this.l) {
                d();
            }
            this.l = true;
            b();
            k();
            TTSPlayerControl.addTTSPlayStateListener(this.o);
            com.baidu.navisdk.util.listener.a.a(this.n);
            com.baidu.navisdk.framework.message.a.a().a(this, com.baidu.navisdk.framework.message.bean.e.class, new Class[0]);
        }
    }

    public boolean a() {
        boolean z = com.baidu.navisdk.ui.routeguide.b.V().z();
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "isFinishMonitor() mRecordTime = " + this.f9008a + " mEndTime = " + this.c + " isBackground = " + z);
        }
        return this.f9008a >= this.c && !z;
    }

    public void b() {
        this.f9008a = 0;
        this.b = 0L;
        this.e = false;
        if (BNCommSettingManager.getInstance().isDiySpeakAutoChangeInMusic()) {
            this.d = 2;
            this.c = 300000;
        } else if (BNCommSettingManager.getInstance().getDiySpeakMusicAidCount() < 2) {
            this.d = 1;
            this.c = x.ac;
        } else {
            this.d = 0;
        }
        if (LogUtil.LOGGABLE) {
            LogUtil.e("DiySpeakBNDiySpeakMusicMonitor", "resetValue() typs = " + this.d);
        }
        if (LogUtil.LOGGABLE) {
            this.c /= 10;
        }
    }
}
