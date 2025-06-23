package com.baidu.navisdk.framework.interfaces;

import androidx.annotation.Nullable;
import com.baidu.voicesquare.interfaces.Map2VoiceSquare;
import com.baidu.voicesquare.interfaces.VoiceInterfaceImplProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes7.dex */
public class c {
    private static final Object d = new Object();
    private static volatile c e;

    /* renamed from: a, reason: collision with root package name */
    private a f6811a = new b();
    private volatile boolean b = false;
    private final Map<String, h> c = new HashMap();

    /* loaded from: classes7.dex */
    public interface a {
        h a(String str);
    }

    /* loaded from: classes7.dex */
    public static class b implements a {
        @Override // com.baidu.navisdk.framework.interfaces.c.a
        public h a(String str) {
            return null;
        }
    }

    private c() {
    }

    public static c p() {
        if (e == null) {
            synchronized (c.class) {
                try {
                    if (e == null) {
                        e = new c();
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public void a(a aVar) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f6811a = aVar;
    }

    public f b() {
        return (f) a("asr_manager");
    }

    public v c() {
        return (v) a("route_result_page");
    }

    public g d() {
        return (g) a("Common");
    }

    public com.baidu.navisdk.framework.interfaces.commute.b e() {
        return (com.baidu.navisdk.framework.interfaces.commute.b) a("commute_page");
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.d f() {
        return (com.baidu.navisdk.framework.interfaces.pronavi.d) a("custom_navi");
    }

    public com.baidu.navisdk.framework.interfaces.diyspeak.a g() {
        return (com.baidu.navisdk.framework.interfaces.diyspeak.a) a("DiySpeak");
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.b h() {
        return (com.baidu.navisdk.framework.interfaces.pronavi.b) a("guide_page");
    }

    public com.baidu.navisdk.framework.interfaces.lightnavi.a i() {
        return (com.baidu.navisdk.framework.interfaces.lightnavi.a) a("LightRouteGuideScene");
    }

    public com.baidu.navisdk.framework.interfaces.locationshare.a j() {
        return (com.baidu.navisdk.framework.interfaces.locationshare.a) a("location_share");
    }

    public k k() {
        try {
            return (k) a("open_sdk");
        } catch (Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.OPEN_SDK;
            if (gVar.c()) {
                gVar.c(th.toString());
                return null;
            }
            return null;
        }
    }

    public s l() {
        try {
            return (s) a("sdk_vdr");
        } catch (Throwable th) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.OPEN_SDK;
            if (gVar.c()) {
                gVar.c(th.toString());
                return null;
            }
            return null;
        }
    }

    public o m() {
        return (o) a("setting");
    }

    public com.baidu.navisdk.framework.interfaces.pronavi.l n() {
        return (com.baidu.navisdk.framework.interfaces.pronavi.l) a("shortcut_fun");
    }

    public VoiceInterfaceImplProxy o() {
        if (!com.baidu.navisdk.j.d()) {
            return null;
        }
        return Map2VoiceSquare.getInstance().getMap2VoiceInterfaceProxy();
    }

    @Nullable
    public <I extends h> I a(String str) {
        return (I) a(str, "com.baidu.navisdk.framework.interfaces.BNInterfaceFactory.DefaultKey");
    }

    @Nullable
    public <I extends h> I a(String str, String str2) {
        String str3 = str2 + ":" + str;
        synchronized (d) {
            try {
                I i = (I) this.c.get(str3);
                if (i != null) {
                    return i;
                }
                I i2 = (I) this.f6811a.a(str);
                if (i2 == null) {
                    com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.INIT;
                    if (gVar.c()) {
                        gVar.c("InterfaceBase is null, cannot create an instance of " + str3);
                    }
                    return null;
                }
                this.c.put(str3, i2);
                return i2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public com.baidu.navisdk.framework.interfaces.a a() {
        return (com.baidu.navisdk.framework.interfaces.a) a("ABTest");
    }
}
