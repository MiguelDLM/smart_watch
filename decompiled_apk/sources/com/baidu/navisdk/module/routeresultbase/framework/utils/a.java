package com.baidu.navisdk.module.routeresultbase.framework.utils;

import android.os.Looper;
import com.baidu.navisdk.util.worker.c;
import com.baidu.navisdk.util.worker.e;
import com.baidu.navisdk.util.worker.f;
import com.baidu.navisdk.util.worker.g;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: com.baidu.navisdk.module.routeresultbase.framework.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0287a extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7505a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0287a(String str, String str2, Runnable runnable) {
            super(str, str2);
            this.f7505a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            Runnable runnable = this.f7505a;
            if (runnable == null) {
                return null;
            }
            runnable.run();
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public class b extends f<String, String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f7506a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2, Runnable runnable) {
            super(str, str2);
            this.f7506a = runnable;
        }

        @Override // com.baidu.navisdk.util.worker.f, com.baidu.navisdk.util.worker.g
        public String execute() {
            Runnable runnable = this.f7506a;
            if (runnable == null) {
                return null;
            }
            runnable.run();
            return null;
        }
    }

    public static f<String, String> a(String str, Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
            return null;
        }
        C0287a c0287a = new C0287a(str, null, runnable);
        c.a().a((f) c0287a, new e(1, 0));
        return c0287a;
    }

    public static void a(String str, long j, Runnable runnable) {
        c.a().a(new b(str, null, runnable), new e(1, 0), j);
    }

    public static void a(g<String, String> gVar, boolean z) {
        c.a().a(gVar, z);
    }
}
