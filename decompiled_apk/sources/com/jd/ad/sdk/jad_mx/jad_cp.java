package com.jd.ad.sdk.jad_mx;

import com.jd.ad.sdk.jad_gp.jad_kx;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes10.dex */
public final class jad_cp {
    public final Map<String, jad_an> jad_an = new HashMap();
    public final jad_bo jad_bo = new jad_bo();

    /* loaded from: classes10.dex */
    public static class jad_an {
        public final Lock jad_an = new ReentrantLock();
        public int jad_bo;
    }

    /* loaded from: classes10.dex */
    public static class jad_bo {
        public final Queue<jad_an> jad_an = new ArrayDeque();
    }

    public void jad_an(String str) {
        jad_an jad_anVar;
        synchronized (this) {
            try {
                jad_anVar = (jad_an) jad_kx.jad_an(this.jad_an.get(str));
                int i = jad_anVar.jad_bo;
                if (i >= 1) {
                    int i2 = i - 1;
                    jad_anVar.jad_bo = i2;
                    if (i2 == 0) {
                        jad_an remove = this.jad_an.remove(str);
                        if (remove.equals(jad_anVar)) {
                            jad_bo jad_boVar = this.jad_bo;
                            synchronized (jad_boVar.jad_an) {
                                try {
                                    if (jad_boVar.jad_an.size() < 10) {
                                        jad_boVar.jad_an.offer(remove);
                                    }
                                } finally {
                                }
                            }
                        } else {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + jad_anVar + ", but actually removed: " + remove + ", safeKey: " + str);
                        }
                    }
                } else {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + jad_anVar.jad_bo);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        jad_anVar.jad_an.unlock();
    }
}
