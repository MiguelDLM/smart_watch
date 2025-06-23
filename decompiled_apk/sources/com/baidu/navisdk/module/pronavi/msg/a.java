package com.baidu.navisdk.module.pronavi.msg;

import android.os.Message;
import android.util.SparseArray;
import com.baidu.navisdk.util.common.g;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes7.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    private final SparseArray<Set<c>> f7472a;
    private final ReentrantLock b = new ReentrantLock(true);

    public a(int i) {
        this.f7472a = new SparseArray<>(i <= 0 ? 20 : i);
    }

    @Override // com.baidu.navisdk.module.pronavi.msg.b
    public void a(Message message) {
        g gVar = g.PRO_NAV;
        if (gVar.d()) {
            gVar.e("BNMessageDispatcher", "dispatchMessage: " + message);
        }
        if (this.f7472a.size() <= 0) {
            return;
        }
        this.b.lock();
        try {
            Set<c> set = this.f7472a.get(message.what);
            if (set != null) {
                for (c cVar : set) {
                    if (cVar != null) {
                        try {
                            cVar.a(message);
                        } catch (Throwable th) {
                            if (g.PRO_NAV.c()) {
                                g gVar2 = g.PRO_NAV;
                                gVar2.c("BNMessageDispatcher", "dispatchMessage: " + th);
                                gVar2.a("BNMessageDispatcher", th);
                            }
                        }
                    }
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.msg.b
    public void b(c cVar) {
        if (cVar != null) {
            a(cVar, cVar.a());
        }
    }

    public void b(c cVar, int[] iArr) {
        if (cVar == null || iArr == null || iArr.length <= 0) {
            return;
        }
        this.b.lock();
        try {
            for (int i : iArr) {
                Set<c> set = this.f7472a.get(i);
                if (set != null) {
                    set.remove(cVar);
                    if (set.isEmpty()) {
                        this.f7472a.remove(i);
                    }
                }
            }
        } finally {
            this.b.unlock();
        }
    }

    public void a(c cVar, int[] iArr) {
        if (cVar == null || iArr == null || iArr.length <= 0) {
            return;
        }
        this.b.lock();
        try {
            for (int i : iArr) {
                Set<c> set = this.f7472a.get(i);
                if (set == null) {
                    set = new HashSet<>(16, 1.0f);
                    this.f7472a.put(i, set);
                }
                set.add(cVar);
            }
            this.b.unlock();
        } catch (Throwable th) {
            this.b.unlock();
            throw th;
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.msg.b
    public void a(c cVar) {
        if (cVar != null) {
            b(cVar, cVar.a());
        }
    }

    @Override // com.baidu.navisdk.module.pronavi.msg.b
    public void a() {
        this.b.lock();
        try {
            this.f7472a.clear();
        } finally {
            this.b.unlock();
        }
    }
}
