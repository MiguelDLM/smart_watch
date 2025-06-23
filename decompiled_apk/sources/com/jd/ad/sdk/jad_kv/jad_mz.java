package com.jd.ad.sdk.jad_kv;

import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_gp.jad_hu;
import com.jd.ad.sdk.jad_hq.jad_an;
import com.jd.ad.sdk.jad_kv.jad_an;
import com.jd.ad.sdk.jad_kv.jad_hu;
import com.jd.ad.sdk.jad_kv.jad_re;
import com.jd.ad.sdk.jad_mx.jad_an;
import com.jd.ad.sdk.jad_mx.jad_fs;
import com.jd.ad.sdk.jad_mx.jad_hu;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes10.dex */
public class jad_mz implements jad_ob, jad_hu.jad_an, jad_re.jad_an {
    public static final boolean jad_hu = Log.isLoggable("Engine", 2);
    public final jad_uh jad_an;
    public final jad_qd jad_bo;
    public final com.jd.ad.sdk.jad_mx.jad_hu jad_cp;
    public final jad_bo jad_dq;
    public final jad_cn jad_er;
    public final jad_an jad_fs;
    public final com.jd.ad.sdk.jad_kv.jad_an jad_jt;

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static class jad_an {
        public final jad_hu.jad_er jad_an;
        public final Pools.Pool<jad_hu<?>> jad_bo = com.jd.ad.sdk.jad_hq.jad_an.jad_an(150, new C0694jad_an());
        public int jad_cp;

        /* renamed from: com.jd.ad.sdk.jad_kv.jad_mz$jad_an$jad_an, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0694jad_an implements jad_an.jad_bo<jad_hu<?>> {
            public C0694jad_an() {
            }

            @Override // com.jd.ad.sdk.jad_hq.jad_an.jad_bo
            public jad_hu<?> jad_an() {
                jad_an jad_anVar = jad_an.this;
                return new jad_hu<>(jad_anVar.jad_an, jad_anVar.jad_bo);
            }
        }

        public jad_an(jad_hu.jad_er jad_erVar) {
            this.jad_an = jad_erVar;
        }
    }

    @VisibleForTesting
    /* loaded from: classes10.dex */
    public static class jad_bo {
        public final com.jd.ad.sdk.jad_ny.jad_an jad_an;
        public final com.jd.ad.sdk.jad_ny.jad_an jad_bo;
        public final com.jd.ad.sdk.jad_ny.jad_an jad_cp;
        public final com.jd.ad.sdk.jad_ny.jad_an jad_dq;
        public final jad_ob jad_er;
        public final jad_re.jad_an jad_fs;
        public final Pools.Pool<jad_na<?>> jad_jt = com.jd.ad.sdk.jad_hq.jad_an.jad_an(150, new jad_an());

        /* loaded from: classes10.dex */
        public class jad_an implements jad_an.jad_bo<jad_na<?>> {
            public jad_an() {
            }

            @Override // com.jd.ad.sdk.jad_hq.jad_an.jad_bo
            public jad_na<?> jad_an() {
                jad_bo jad_boVar = jad_bo.this;
                return new jad_na<>(jad_boVar.jad_an, jad_boVar.jad_bo, jad_boVar.jad_cp, jad_boVar.jad_dq, jad_boVar.jad_er, jad_boVar.jad_fs, jad_boVar.jad_jt, jad_na.jad_zm);
            }
        }

        public jad_bo(com.jd.ad.sdk.jad_ny.jad_an jad_anVar, com.jd.ad.sdk.jad_ny.jad_an jad_anVar2, com.jd.ad.sdk.jad_ny.jad_an jad_anVar3, com.jd.ad.sdk.jad_ny.jad_an jad_anVar4, jad_ob jad_obVar, jad_re.jad_an jad_anVar5) {
            this.jad_an = jad_anVar;
            this.jad_bo = jad_anVar2;
            this.jad_cp = jad_anVar3;
            this.jad_dq = jad_anVar4;
            this.jad_er = jad_obVar;
            this.jad_fs = jad_anVar5;
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_cp implements jad_hu.jad_er {
        public final jad_an.InterfaceC0698jad_an jad_an;
        public volatile com.jd.ad.sdk.jad_mx.jad_an jad_bo;

        public jad_cp(jad_an.InterfaceC0698jad_an interfaceC0698jad_an) {
            this.jad_an = interfaceC0698jad_an;
        }

        public com.jd.ad.sdk.jad_mx.jad_an jad_an() {
            if (this.jad_bo == null) {
                synchronized (this) {
                    try {
                        if (this.jad_bo == null) {
                            com.jd.ad.sdk.jad_mx.jad_dq jad_dqVar = (com.jd.ad.sdk.jad_mx.jad_dq) this.jad_an;
                            jad_fs.jad_an jad_anVar = (jad_fs.jad_an) jad_dqVar.jad_bo;
                            File cacheDir = jad_anVar.jad_an.getCacheDir();
                            com.jd.ad.sdk.jad_mx.jad_er jad_erVar = null;
                            if (cacheDir == null) {
                                cacheDir = null;
                            } else if (jad_anVar.jad_bo != null) {
                                cacheDir = new File(cacheDir, jad_anVar.jad_bo);
                            }
                            if (cacheDir != null && (cacheDir.isDirectory() || cacheDir.mkdirs())) {
                                jad_erVar = new com.jd.ad.sdk.jad_mx.jad_er(cacheDir, jad_dqVar.jad_an);
                            }
                            this.jad_bo = jad_erVar;
                        }
                        if (this.jad_bo == null) {
                            this.jad_bo = new com.jd.ad.sdk.jad_mx.jad_bo();
                        }
                    } finally {
                    }
                }
            }
            return this.jad_bo;
        }
    }

    /* loaded from: classes10.dex */
    public class jad_dq {
        public final jad_na<?> jad_an;
        public final com.jd.ad.sdk.jad_al.jad_iv jad_bo;

        public jad_dq(com.jd.ad.sdk.jad_al.jad_iv jad_ivVar, jad_na<?> jad_naVar) {
            this.jad_bo = jad_ivVar;
            this.jad_an = jad_naVar;
        }
    }

    @VisibleForTesting
    public jad_mz(com.jd.ad.sdk.jad_mx.jad_hu jad_huVar, jad_an.InterfaceC0698jad_an interfaceC0698jad_an, com.jd.ad.sdk.jad_ny.jad_an jad_anVar, com.jd.ad.sdk.jad_ny.jad_an jad_anVar2, com.jd.ad.sdk.jad_ny.jad_an jad_anVar3, com.jd.ad.sdk.jad_ny.jad_an jad_anVar4, jad_uh jad_uhVar, jad_qd jad_qdVar, com.jd.ad.sdk.jad_kv.jad_an jad_anVar5, jad_bo jad_boVar, jad_an jad_anVar6, jad_cn jad_cnVar, boolean z) {
        this.jad_cp = jad_huVar;
        jad_cp jad_cpVar = new jad_cp(interfaceC0698jad_an);
        com.jd.ad.sdk.jad_kv.jad_an jad_anVar7 = new com.jd.ad.sdk.jad_kv.jad_an(z);
        this.jad_jt = jad_anVar7;
        jad_anVar7.jad_an(this);
        this.jad_bo = new jad_qd();
        this.jad_an = new jad_uh();
        this.jad_dq = new jad_bo(jad_anVar, jad_anVar2, jad_anVar3, jad_anVar4, this, this);
        this.jad_fs = new jad_an(jad_cpVar);
        this.jad_er = new jad_cn();
        ((com.jd.ad.sdk.jad_mx.jad_jt) jad_huVar).jad_an((jad_hu.jad_an) this);
    }

    public void jad_an(jad_xk<?> jad_xkVar) {
        if (!(jad_xkVar instanceof jad_re)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((jad_re) jad_xkVar).jad_jt();
    }

    public static void jad_an(String str, long j, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar) {
        Logger.v("Engine", str + " in " + com.jd.ad.sdk.jad_gp.jad_jt.jad_an(j) + "ms, key: " + jad_huVar);
    }

    public <R> jad_dq jad_an(com.jd.ad.sdk.jad_ep.jad_er jad_erVar, Object obj, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, int i, int i2, Class<?> cls, Class<R> cls2, com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, jad_ly jad_lyVar, Map<Class<?>, com.jd.ad.sdk.jad_hs.jad_na<?>> map, boolean z, boolean z2, com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar, boolean z3, boolean z4, boolean z5, boolean z6, com.jd.ad.sdk.jad_al.jad_iv jad_ivVar, Executor executor) {
        long jad_an2 = jad_hu ? com.jd.ad.sdk.jad_gp.jad_jt.jad_an() : 0L;
        this.jad_bo.getClass();
        jad_pc jad_pcVar = new jad_pc(obj, jad_huVar, i, i2, map, cls, cls2, jad_jwVar);
        synchronized (this) {
            try {
                jad_re<?> jad_an3 = jad_an(jad_pcVar, z3, jad_an2);
                if (jad_an3 == null) {
                    return jad_an(jad_erVar, obj, jad_huVar, i, i2, cls, cls2, jad_jtVar, jad_lyVar, map, z, z2, jad_jwVar, z3, z4, z5, z6, jad_ivVar, executor, jad_pcVar, jad_an2);
                }
                ((com.jd.ad.sdk.jad_al.jad_jw) jad_ivVar).jad_an(jad_an3, com.jd.ad.sdk.jad_hs.jad_an.MEMORY_CACHE, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final jad_re<?> jad_an(jad_pc jad_pcVar, boolean z, long j) {
        jad_re<?> jad_reVar;
        jad_xk jad_xkVar;
        jad_re<?> jad_reVar2;
        if (!z) {
            return null;
        }
        com.jd.ad.sdk.jad_kv.jad_an jad_anVar = this.jad_jt;
        synchronized (jad_anVar) {
            jad_an.jad_cp jad_cpVar = jad_anVar.jad_bo.get(jad_pcVar);
            if (jad_cpVar == null) {
                jad_reVar = null;
            } else {
                jad_reVar = jad_cpVar.get();
                if (jad_reVar == null) {
                    jad_anVar.jad_an(jad_cpVar);
                }
            }
        }
        if (jad_reVar != null) {
            jad_reVar.jad_an();
        }
        if (jad_reVar != null) {
            if (jad_hu) {
                jad_an("Loaded resource from active resources", j, jad_pcVar);
            }
            return jad_reVar;
        }
        com.jd.ad.sdk.jad_mx.jad_jt jad_jtVar = (com.jd.ad.sdk.jad_mx.jad_jt) this.jad_cp;
        synchronized (jad_jtVar) {
            jad_hu.jad_an jad_anVar2 = (jad_hu.jad_an) jad_jtVar.jad_an.remove(jad_pcVar);
            if (jad_anVar2 == null) {
                jad_xkVar = null;
            } else {
                jad_jtVar.jad_cp -= jad_anVar2.jad_bo;
                jad_xkVar = jad_anVar2.jad_an;
            }
        }
        jad_xk jad_xkVar2 = jad_xkVar;
        if (jad_xkVar2 == null) {
            jad_reVar2 = null;
        } else {
            jad_reVar2 = jad_xkVar2 instanceof jad_re ? (jad_re) jad_xkVar2 : new jad_re<>(jad_xkVar2, true, true, jad_pcVar, this);
        }
        if (jad_reVar2 != null) {
            jad_reVar2.jad_an();
            this.jad_jt.jad_an(jad_pcVar, jad_reVar2);
        }
        if (jad_reVar2 == null) {
            return null;
        }
        if (jad_hu) {
            jad_an("Loaded resource from cache", j, jad_pcVar);
        }
        return jad_reVar2;
    }

    public synchronized void jad_an(jad_na<?> jad_naVar, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, jad_re<?> jad_reVar) {
        if (jad_reVar != null) {
            try {
                if (jad_reVar.jad_an) {
                    this.jad_jt.jad_an(jad_huVar, jad_reVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        jad_uh jad_uhVar = this.jad_an;
        jad_uhVar.getClass();
        Map<com.jd.ad.sdk.jad_hs.jad_hu, jad_na<?>> jad_an2 = jad_uhVar.jad_an(jad_naVar.jad_pc);
        if (jad_naVar.equals(jad_an2.get(jad_huVar))) {
            jad_an2.remove(jad_huVar);
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_re.jad_an
    public void jad_an(com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, jad_re<?> jad_reVar) {
        com.jd.ad.sdk.jad_kv.jad_an jad_anVar = this.jad_jt;
        synchronized (jad_anVar) {
            jad_an.jad_cp remove = jad_anVar.jad_bo.remove(jad_huVar);
            if (remove != null) {
                remove.jad_cp = null;
                remove.clear();
            }
        }
        if (jad_reVar.jad_an) {
            ((com.jd.ad.sdk.jad_mx.jad_jt) this.jad_cp).jad_bo(jad_huVar, jad_reVar);
        } else {
            this.jad_er.jad_an(jad_reVar, false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> jad_dq jad_an(com.jd.ad.sdk.jad_ep.jad_er jad_erVar, Object obj, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, int i, int i2, Class<?> cls, Class<R> cls2, com.jd.ad.sdk.jad_ep.jad_jt jad_jtVar, jad_ly jad_lyVar, Map<Class<?>, com.jd.ad.sdk.jad_hs.jad_na<?>> map, boolean z, boolean z2, com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar, boolean z3, boolean z4, boolean z5, boolean z6, com.jd.ad.sdk.jad_al.jad_iv jad_ivVar, Executor executor, jad_pc jad_pcVar, long j) {
        com.jd.ad.sdk.jad_ny.jad_an jad_anVar;
        jad_uh jad_uhVar = this.jad_an;
        jad_na<?> jad_naVar = (z6 ? jad_uhVar.jad_bo : jad_uhVar.jad_an).get(jad_pcVar);
        if (jad_naVar != null) {
            jad_naVar.jad_an(jad_ivVar, executor);
            if (jad_hu) {
                jad_an("Added to existing load", j, jad_pcVar);
            }
            return new jad_dq(jad_ivVar, jad_naVar);
        }
        jad_na<?> jad_naVar2 = (jad_na) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_dq.jad_jt.acquire());
        synchronized (jad_naVar2) {
            jad_naVar2.jad_ly = jad_pcVar;
            jad_naVar2.jad_mz = z3;
            jad_naVar2.jad_na = z4;
            jad_naVar2.jad_ob = z5;
            jad_naVar2.jad_pc = z6;
        }
        jad_an jad_anVar2 = this.jad_fs;
        jad_hu<R> jad_huVar2 = (jad_hu) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(jad_anVar2.jad_bo.acquire());
        int i3 = jad_anVar2.jad_cp;
        jad_anVar2.jad_cp = i3 + 1;
        jad_jt<R> jad_jtVar2 = jad_huVar2.jad_an;
        jad_hu.jad_er jad_erVar2 = jad_huVar2.jad_dq;
        jad_jtVar2.jad_cp = jad_erVar;
        jad_jtVar2.jad_dq = obj;
        jad_jtVar2.jad_na = jad_huVar;
        jad_jtVar2.jad_er = i;
        jad_jtVar2.jad_fs = i2;
        jad_jtVar2.jad_pc = jad_lyVar;
        jad_jtVar2.jad_jt = cls;
        jad_jtVar2.jad_hu = jad_erVar2;
        jad_jtVar2.jad_kx = cls2;
        jad_jtVar2.jad_ob = jad_jtVar;
        jad_jtVar2.jad_iv = jad_jwVar;
        jad_jtVar2.jad_jw = map;
        jad_jtVar2.jad_qd = z;
        jad_jtVar2.jad_re = z2;
        jad_huVar2.jad_hu = jad_erVar;
        jad_huVar2.jad_iv = jad_huVar;
        jad_huVar2.jad_jw = jad_jtVar;
        jad_huVar2.jad_kx = jad_pcVar;
        jad_huVar2.jad_ly = i;
        jad_huVar2.jad_mz = i2;
        jad_huVar2.jad_na = jad_lyVar;
        jad_huVar2.jad_uh = z6;
        jad_huVar2.jad_ob = jad_jwVar;
        jad_huVar2.jad_pc = jad_naVar2;
        jad_huVar2.jad_qd = i3;
        jad_huVar2.jad_sf = 1;
        jad_huVar2.jad_vi = obj;
        jad_uh jad_uhVar2 = this.jad_an;
        jad_uhVar2.getClass();
        jad_uhVar2.jad_an(jad_naVar2.jad_pc).put(jad_pcVar, jad_naVar2);
        jad_naVar2.jad_an(jad_ivVar, executor);
        synchronized (jad_naVar2) {
            try {
                jad_naVar2.jad_wj = jad_huVar2;
                int jad_an2 = jad_huVar2.jad_an(1);
                if (jad_an2 != 2 && jad_an2 != 3) {
                    jad_anVar = jad_naVar2.jad_na ? jad_naVar2.jad_iv : jad_naVar2.jad_ob ? jad_naVar2.jad_jw : jad_naVar2.jad_hu;
                    jad_anVar.jad_an.execute(jad_huVar2);
                }
                jad_anVar = jad_naVar2.jad_jt;
                jad_anVar.jad_an.execute(jad_huVar2);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (jad_hu) {
            jad_an("Started new load", j, jad_pcVar);
        }
        return new jad_dq(jad_ivVar, jad_naVar2);
    }
}
