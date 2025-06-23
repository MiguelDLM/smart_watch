package com.baidu.mshield;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes7.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f6363a;
    public final /* synthetic */ HashMap b;

    public a(Context context, HashMap hashMap) {
        this.f6363a = context;
        this.b = hashMap;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean initAppkey;
        com.baidu.mshield.b.c.a.b("===pre isUserAuthPrv===");
        com.baidu.xclient.gdid.a.h(this.f6363a);
        com.baidu.sec.privacy.a.b.a(this.f6363a, "mshield", new b(this));
        com.baidu.mshield.b.a.a.f6364a = "985050001";
        initAppkey = MH.initAppkey(this.f6363a);
        if (!initAppkey) {
            return;
        }
        com.baidu.mshield.utility.b.a(this.f6363a).a();
        String[] b = com.baidu.mshield.utility.a.b(this.f6363a);
        if (b.length == 2) {
            MH.registerSDKReceiver(this.f6363a);
            String str = b[0];
            com.baidu.mshield.b.a.a.f6364a = str;
            com.baidu.mshield.core.a.a(this.f6363a, str, b[1], this.b, 0);
        }
    }
}
