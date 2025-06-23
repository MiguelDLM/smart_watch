package com.baidu.navisdk.util.worker.loop;

import android.os.Message;
import com.baidu.navisdk.util.common.LogUtil;

/* loaded from: classes8.dex */
public class c implements e {
    public static final String b = "c";
    private static c c;
    private static final Object d = new Object();

    /* renamed from: a, reason: collision with root package name */
    private e f9400a = null;

    private c() {
    }

    public static c a() {
        if (c == null) {
            synchronized (d) {
                try {
                    if (c == null) {
                        c = new c();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    private void b(e eVar) {
        if (this.f9400a != null) {
            LogUtil.e(b, "setFramework() framework is not null.");
        } else if (eVar == null) {
            LogUtil.e(b, "setFramework() framework is null.");
        } else {
            this.f9400a = eVar;
        }
    }

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void c(Message message) {
        if (message == null) {
            LogUtil.e(b, "markFinish() message is null.");
            return;
        }
        e eVar = this.f9400a;
        if (eVar != null) {
            eVar.c(message);
        } else {
            LogUtil.e(b, "markFinish() framework is null.");
        }
    }

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void b(Message message) {
        e eVar = this.f9400a;
        if (eVar != null) {
            eVar.b(message);
        } else {
            LogUtil.e(b, "markSubmit() framework is null.");
        }
    }

    public static void a(e eVar) {
        a().b(eVar);
    }

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void a(Runnable runnable) {
        if (runnable == null) {
            LogUtil.e(b, "runInLooperBuffer() runnable is null.");
            return;
        }
        e eVar = this.f9400a;
        if (eVar != null) {
            eVar.a(runnable);
        } else {
            LogUtil.e(b, "runInLooperBuffer() framework is null.");
        }
    }

    @Override // com.baidu.navisdk.util.worker.loop.e
    public void a(Message message) {
        if (message == null) {
            LogUtil.e(b, "markRunning() message is null.");
            return;
        }
        e eVar = this.f9400a;
        if (eVar != null) {
            eVar.a(message);
        } else {
            LogUtil.e(b, "markRunning() framework is null.");
        }
    }
}
