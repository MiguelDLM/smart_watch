package com.adp.sdk;

import android.content.Context;
import com.adp.sdk.dto.AdInfo;
import com.qq.e.comm.managers.GDTAdSdk;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4713a = false;

    /* loaded from: classes.dex */
    public static class a implements GDTAdSdk.OnStartListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f4714a;

        public a(b bVar) {
            this.f4714a = bVar;
        }

        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
        public void onStartFailed(Exception exc) {
            b bVar = this.f4714a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // com.qq.e.comm.managers.GDTAdSdk.OnStartListener
        public void onStartSuccess() {
            boolean unused = g.f4713a = true;
            b bVar = this.f4714a;
            if (bVar != null) {
                bVar.success();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void success();
    }

    public static synchronized boolean a(Context context, b bVar) {
        synchronized (g.class) {
            if (f4713a) {
                return true;
            }
            if (context == null) {
                return false;
            }
            AdInfo adInfo = com.adp.sdk.a.b;
            if (adInfo == null || a(adInfo.getTencent())) {
                return false;
            }
            try {
                Thread.sleep(100L);
                GDTAdSdk.start(new a(bVar));
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public static boolean a() {
        return f4713a;
    }

    private static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
