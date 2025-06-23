package com.baidu.navisdk.util.worker;

import java.util.concurrent.Future;

/* loaded from: classes8.dex */
public class c implements h {
    private static c b;
    private static final Object c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private h f9393a = null;

    private c() {
    }

    public static void a(h hVar) {
        if (b == null) {
            synchronized (c) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } finally {
                }
            }
        }
        if (hVar != null) {
            b.b(hVar);
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e("use the outer worker cetner.");
                return;
            }
            return;
        }
        b.b(a.a());
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.WORKER_CENTER;
        if (gVar2.d()) {
            gVar2.e("use the inner worker cetner.");
        }
    }

    private void b(h hVar) {
        if (hVar == null) {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "setWorkerCenter() worker center is null");
                return;
            }
            return;
        }
        if (this.f9393a != null) {
            com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar2.d()) {
                gVar2.e(g.TAG, "setWorkerCenter() return for cur workder center is not null");
                return;
            }
            return;
        }
        this.f9393a = hVar;
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void c(f<K, T> fVar, e eVar) {
        if (this.f9393a != null) {
            fVar.isCancelled = false;
            this.f9393a.c(fVar, eVar);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "worker center is null.");
            }
        }
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void c(f<K, T> fVar, e eVar, long j) {
        if (this.f9393a != null) {
            fVar.isCancelled = false;
            this.f9393a.c(fVar, eVar, j);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "worker center is null.");
            }
        }
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void b(f<K, T> fVar, e eVar, long j) {
        if (this.f9393a != null) {
            fVar.isCancelled = false;
            this.f9393a.b(fVar, eVar, j);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "worker center is null.");
            }
        }
    }

    public static h a() {
        if (b == null) {
            synchronized (c) {
                try {
                    if (b == null) {
                        b = new c();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void b(f<K, T> fVar, e eVar) {
        if (this.f9393a != null) {
            fVar.isCancelled = false;
            this.f9393a.b(fVar, eVar);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "worker center is null.");
            }
        }
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> Future<?> a(g<K, T> gVar, e eVar) {
        if (this.f9393a != null) {
            gVar.isCancelled = false;
            return this.f9393a.a(gVar, eVar);
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.WORKER_CENTER;
        if (!gVar2.d()) {
            return null;
        }
        gVar2.e(g.TAG, "worker center is null.");
        return null;
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void a(b<K, T> bVar, e eVar) {
        if (this.f9393a != null) {
            bVar.isCancelled = false;
            this.f9393a.a((b) bVar, eVar);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "worker center is null.");
            }
        }
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void a(f<K, T> fVar, e eVar) {
        if (this.f9393a != null) {
            fVar.isCancelled = false;
            this.f9393a.a((f) fVar, eVar);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "worker center is null.");
            }
        }
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> void a(f<K, T> fVar, e eVar, long j) {
        if (this.f9393a != null) {
            fVar.isCancelled = false;
            this.f9393a.a(fVar, eVar, j);
        } else {
            com.baidu.navisdk.util.common.g gVar = com.baidu.navisdk.util.common.g.WORKER_CENTER;
            if (gVar.d()) {
                gVar.e(g.TAG, "worker center is null.");
            }
        }
    }

    @Override // com.baidu.navisdk.util.worker.h
    @Deprecated
    public <K, T> Future<?> a(g<K, T> gVar) {
        h hVar = this.f9393a;
        if (hVar != null) {
            return hVar.a(gVar);
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.WORKER_CENTER;
        if (!gVar2.d()) {
            return null;
        }
        gVar2.e(g.TAG, "worker center is null.");
        return null;
    }

    @Override // com.baidu.navisdk.util.worker.h
    public <K, T> boolean a(g<K, T> gVar, boolean z) {
        h hVar = this.f9393a;
        if (hVar != null) {
            return hVar.a(gVar, z);
        }
        com.baidu.navisdk.util.common.g gVar2 = com.baidu.navisdk.util.common.g.WORKER_CENTER;
        if (!gVar2.d()) {
            return false;
        }
        gVar2.e(g.TAG, "worker center is null.");
        return false;
    }
}
