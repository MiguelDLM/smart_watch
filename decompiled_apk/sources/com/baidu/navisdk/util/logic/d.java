package com.baidu.navisdk.util.logic;

import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.ExoPlayer;

/* loaded from: classes8.dex */
public class d {
    private static d c = null;
    public static volatile boolean d = true;

    /* renamed from: a, reason: collision with root package name */
    private volatile long f9322a = 0;
    private final com.baidu.navisdk.util.worker.loop.d b = new a();

    /* loaded from: classes8.dex */
    public class a extends com.baidu.navisdk.util.worker.loop.d {
        public a() {
        }

        @Override // com.baidu.navisdk.comapi.base.d
        public void careAbout() {
            com.baidu.navisdk.util.common.g.GPS.a("Location-HD", "hms control care:4480");
            observe(4480);
        }

        @Override // com.baidu.navisdk.util.worker.loop.d
        public void onMessage(Message message) {
            int i;
            if (message == null) {
                return;
            }
            try {
                com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
                if (gVar.a()) {
                    gVar.a("Location-HD", "hms control msg.what:" + message.what + " msg.arg1:" + message.arg1 + " msg.arg2:" + message.arg2 + " msg.obj:" + message.obj + " control:" + d.d);
                }
                if (message.what == 4480 && d.d && (i = message.arg1) != 0) {
                    if (i == 1) {
                        gVar.a("Location-HD", "hms control start");
                        d.this.c();
                    } else if (i == 2) {
                        gVar.a("Location-HD", "hms control stop");
                        d.this.d();
                    }
                }
            } catch (Throwable th) {
                com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.GPS;
                if (gVar2.c()) {
                    gVar2.c("Location-HD", "mVMsgHandler exeption:" + th.getMessage());
                }
            }
        }
    }

    private d() {
    }

    public static synchronized d e() {
        d dVar;
        synchronized (d.class) {
            try {
                if (c == null) {
                    c = new d();
                }
                dVar = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public void a(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.a()) {
            gVar.a("Location-HD", "setHMSEnable:" + z);
        }
    }

    public void b(boolean z) {
        com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
        if (gVar.a()) {
            gVar.a("Location-HD", "setHMSNaviControlEnable:" + z);
        }
        d = z;
    }

    public void c() {
        com.baidu.navisdk.module.vdr.a.d(8);
    }

    public void d() {
        com.baidu.navisdk.module.vdr.a.d(9);
    }

    public void a() {
        a(com.baidu.navisdk.module.cloudconfig.a.b().a("enable_hms_location", true));
        b(com.baidu.navisdk.module.cloudconfig.a.b().a("enable_hms_navi_control", true));
        com.baidu.navisdk.vi.b.a(this.b);
    }

    public boolean b() {
        boolean z = SystemClock.elapsedRealtime() - this.f9322a <= ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        if (!z) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.GPS;
            if (gVar.d()) {
                gVar.e("Location-HD", "hms-gps timeout");
            }
        }
        return z;
    }
}
