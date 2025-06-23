package com.baidu.platform.comapi;

import android.content.Context;
import com.baidu.mapapi.OpenLogUtil;
import com.baidu.mapsdkplatform.comapi.commonutils.b;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes8.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static boolean f9534a = false;
    private NAEngine b;

    public boolean a(Context context) {
        f9534a = false;
        this.b = new NAEngine();
        boolean a2 = NAEngine.a(context, null);
        if (OpenLogUtil.isMapLogEnable()) {
            b.a().a("initEngine isEngineSuccess = " + a2);
        }
        if (a2) {
            return a2;
        }
        com.baidu.platform.comapi.a.a.a().a("engine_init_failed");
        return false;
    }

    public boolean b(Context context) {
        boolean initLongLinkClient = NAEngine.initLongLinkClient();
        if (initLongLinkClient) {
            return initLongLinkClient;
        }
        return false;
    }

    public void b() {
        if (f9534a) {
            a();
        }
        MessageProxy.destroy();
        NAEngine.b();
        if (this.b != null) {
            this.b = null;
        }
    }

    public boolean a() {
        f9534a = false;
        return true;
    }
}
