package com.baidu.navisdk.comapi.routeplan.v2;

import android.os.Bundle;

/* loaded from: classes7.dex */
public abstract class a {
    private com.baidu.navisdk.util.worker.loop.a mMainHandler = new com.baidu.navisdk.util.worker.loop.a("BNRoutePlanListenerV2");

    /* renamed from: com.baidu.navisdk.comapi.routeplan.v2.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0183a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f6725a;
        final /* synthetic */ int b;
        final /* synthetic */ d c;
        final /* synthetic */ Bundle d;

        public RunnableC0183a(int i, int i2, d dVar, Bundle bundle) {
            this.f6725a = i;
            this.b = i2;
            this.c = dVar;
            this.d = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.onRoutePlan(this.f6725a, this.b, this.c, this.d);
        }
    }

    public abstract String getName();

    public boolean isPersist() {
        return false;
    }

    public boolean mustOnMainThread() {
        return false;
    }

    public final void notifyRoutePlanMsg(int i, int i2, d dVar, Bundle bundle) {
        if (mustOnMainThread()) {
            this.mMainHandler.post(new RunnableC0183a(i, i2, dVar, bundle));
        } else {
            onRoutePlan(i, i2, dVar, bundle);
        }
    }

    public abstract void onRoutePlan(int i, int i2, d dVar, Bundle bundle);
}
