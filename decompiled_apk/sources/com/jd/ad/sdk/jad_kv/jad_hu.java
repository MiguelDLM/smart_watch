package com.jd.ad.sdk.jad_kv;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.jad_hq.jad_an;
import com.jd.ad.sdk.jad_kv.jad_fs;
import com.jd.ad.sdk.jad_kv.jad_kx;
import com.jd.ad.sdk.jad_kv.jad_mz;
import com.jd.ad.sdk.jad_kv.jad_na;
import com.jd.ad.sdk.jad_kv.jad_re;
import com.jd.ad.sdk.logger.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes10.dex */
public class jad_hu<R> implements jad_fs.jad_an, Runnable, Comparable<jad_hu<?>>, jad_an.jad_dq {
    public com.jd.ad.sdk.jad_hs.jad_an jad_cn;
    public com.jd.ad.sdk.jad_it.jad_dq<?> jad_do;
    public final jad_er jad_dq;
    public volatile com.jd.ad.sdk.jad_kv.jad_fs jad_ep;
    public final Pools.Pool<jad_hu<?>> jad_er;
    public volatile boolean jad_fq;
    public volatile boolean jad_gr;
    public boolean jad_hs;
    public com.jd.ad.sdk.jad_ep.jad_er jad_hu;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_iv;
    public com.jd.ad.sdk.jad_ep.jad_jt jad_jw;
    public jad_pc jad_kx;
    public int jad_ly;
    public int jad_mz;
    public jad_ly jad_na;
    public com.jd.ad.sdk.jad_hs.jad_jw jad_ob;
    public jad_bo<R> jad_pc;
    public int jad_qd;
    public int jad_re;
    public int jad_sf;
    public long jad_tg;
    public boolean jad_uh;
    public Object jad_vi;
    public Thread jad_wj;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_xk;
    public com.jd.ad.sdk.jad_hs.jad_hu jad_yl;
    public Object jad_zm;
    public final jad_jt<R> jad_an = new jad_jt<>();
    public final List<Throwable> jad_bo = new ArrayList();
    public final com.jd.ad.sdk.jad_hq.jad_dq jad_cp = com.jd.ad.sdk.jad_hq.jad_dq.jad_an();
    public final jad_dq<?> jad_fs = new jad_dq<>();
    public final jad_fs jad_jt = new jad_fs();

    /* loaded from: classes10.dex */
    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;
        public static final /* synthetic */ int[] jad_bo;
        public static final /* synthetic */ int[] jad_cp;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_hs.jad_cp.values().length];
            jad_cp = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_cp[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(6).length];
            jad_bo = iArr2;
            try {
                iArr2[1] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                jad_bo[2] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                jad_bo[3] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                jad_bo[5] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                jad_bo[0] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3).length];
            jad_an = iArr3;
            try {
                iArr3[0] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                jad_an[1] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                jad_an[2] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_bo<R> {
    }

    /* loaded from: classes10.dex */
    public final class jad_cp<Z> implements jad_kx.jad_an<Z> {
        public final com.jd.ad.sdk.jad_hs.jad_an jad_an;

        public jad_cp(com.jd.ad.sdk.jad_hs.jad_an jad_anVar) {
            this.jad_an = jad_anVar;
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_dq<Z> {
        public com.jd.ad.sdk.jad_hs.jad_hu jad_an;
        public com.jd.ad.sdk.jad_hs.jad_mz<Z> jad_bo;
        public jad_wj<Z> jad_cp;
    }

    /* loaded from: classes10.dex */
    public interface jad_er {
    }

    /* loaded from: classes10.dex */
    public static class jad_fs {
        public boolean jad_an;
        public boolean jad_bo;
        public boolean jad_cp;

        public final boolean jad_an(boolean z) {
            return (this.jad_cp || z || this.jad_bo) && this.jad_an;
        }
    }

    public jad_hu(jad_er jad_erVar, Pools.Pool<jad_hu<?>> pool) {
        this.jad_dq = jad_erVar;
        this.jad_er = pool;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull jad_hu<?> jad_huVar) {
        jad_hu<?> jad_huVar2 = jad_huVar;
        int ordinal = this.jad_jw.ordinal() - jad_huVar2.jad_jw.ordinal();
        if (ordinal == 0) {
            return this.jad_qd - jad_huVar2.jad_qd;
        }
        return ordinal;
    }

    public final int jad_an(int i) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            if (this.jad_na.jad_bo()) {
                return 2;
            }
            return jad_an(2);
        }
        if (i2 == 1) {
            if (this.jad_na.jad_an()) {
                return 3;
            }
            return jad_an(3);
        }
        if (i2 == 2) {
            return this.jad_uh ? 6 : 4;
        }
        if (i2 == 3 || i2 == 5) {
            return 6;
        }
        StringBuilder a2 = a.a("Unrecognized stage: ");
        a2.append(jad_jw.jad_an(i));
        throw new IllegalArgumentException(a2.toString());
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_fs.jad_an
    public void jad_bo() {
        this.jad_sf = 2;
        ((jad_na) this.jad_pc).jad_an((jad_hu<?>) this);
    }

    public final void jad_cp() {
        jad_xk<R> jad_xkVar;
        boolean jad_an2;
        if (Log.isLoggable("DecodeJob", 2)) {
            long j = this.jad_tg;
            StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("data: ");
            jad_an3.append(this.jad_zm);
            jad_an3.append(", cache key: ");
            jad_an3.append(this.jad_xk);
            jad_an3.append(", fetcher: ");
            jad_an3.append(this.jad_do);
            jad_an("Retrieved data", j, jad_an3.toString());
        }
        jad_wj jad_wjVar = null;
        try {
            jad_xkVar = jad_an(this.jad_do, (com.jd.ad.sdk.jad_it.jad_dq<?>) this.jad_zm, this.jad_cn);
        } catch (jad_sf e) {
            com.jd.ad.sdk.jad_hs.jad_hu jad_huVar = this.jad_yl;
            com.jd.ad.sdk.jad_hs.jad_an jad_anVar = this.jad_cn;
            e.jad_bo = jad_huVar;
            e.jad_cp = jad_anVar;
            e.jad_dq = null;
            this.jad_bo.add(e);
            jad_xkVar = null;
        }
        if (jad_xkVar != null) {
            com.jd.ad.sdk.jad_hs.jad_an jad_anVar2 = this.jad_cn;
            boolean z = this.jad_hs;
            if (jad_xkVar instanceof jad_tg) {
                ((jad_tg) jad_xkVar).jad_an();
            }
            if (this.jad_fs.jad_cp != null) {
                jad_wjVar = jad_wj.jad_an(jad_xkVar);
                jad_xkVar = jad_wjVar;
            }
            jad_an(jad_xkVar, jad_anVar2, z);
            this.jad_re = 5;
            try {
                jad_dq<?> jad_dqVar = this.jad_fs;
                if (jad_dqVar.jad_cp != null) {
                    try {
                        ((jad_mz.jad_cp) this.jad_dq).jad_an().jad_an(jad_dqVar.jad_an, new com.jd.ad.sdk.jad_kv.jad_er(jad_dqVar.jad_bo, jad_dqVar.jad_cp, this.jad_ob));
                        jad_dqVar.jad_cp.jad_er();
                    } catch (Throwable th) {
                        jad_dqVar.jad_cp.jad_er();
                        throw th;
                    }
                }
                if (jad_wjVar != null) {
                    jad_wjVar.jad_er();
                }
                jad_fs jad_fsVar = this.jad_jt;
                synchronized (jad_fsVar) {
                    jad_fsVar.jad_bo = true;
                    jad_an2 = jad_fsVar.jad_an(false);
                }
                if (jad_an2) {
                    jad_fs();
                    return;
                }
                return;
            } catch (Throwable th2) {
                if (jad_wjVar != null) {
                    jad_wjVar.jad_er();
                }
                throw th2;
            }
        }
        jad_jt();
    }

    public final com.jd.ad.sdk.jad_kv.jad_fs jad_dq() {
        int jad_an2 = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(this.jad_re);
        if (jad_an2 != 1) {
            if (jad_an2 != 2) {
                if (jad_an2 != 3) {
                    if (jad_an2 == 5) {
                        return null;
                    }
                    StringBuilder jad_an3 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Unrecognized stage: ");
                    jad_an3.append(jad_jw.jad_an(this.jad_re));
                    throw new IllegalStateException(jad_an3.toString());
                }
                return new jad_ep(this.jad_an, this);
            }
            jad_jt<R> jad_jtVar = this.jad_an;
            return new com.jd.ad.sdk.jad_kv.jad_cp(jad_jtVar.jad_an(), jad_jtVar, this);
        }
        return new jad_yl(this.jad_an, this);
    }

    public final void jad_er() {
        boolean jad_an2;
        jad_iv();
        jad_sf jad_sfVar = new jad_sf("Failed to load resource", new ArrayList(this.jad_bo));
        jad_na<?> jad_naVar = (jad_na) this.jad_pc;
        synchronized (jad_naVar) {
            jad_naVar.jad_tg = jad_sfVar;
        }
        synchronized (jad_naVar) {
            try {
                jad_naVar.jad_bo.jad_bo();
                if (jad_naVar.jad_xk) {
                    jad_naVar.jad_dq();
                } else if (!jad_naVar.jad_an.jad_an.isEmpty()) {
                    if (!jad_naVar.jad_uh) {
                        jad_naVar.jad_uh = true;
                        com.jd.ad.sdk.jad_hs.jad_hu jad_huVar = jad_naVar.jad_ly;
                        jad_na.jad_er jad_erVar = jad_naVar.jad_an;
                        jad_erVar.getClass();
                        ArrayList arrayList = new ArrayList(jad_erVar.jad_an);
                        jad_naVar.jad_an(arrayList.size() + 1);
                        ((jad_mz) jad_naVar.jad_fs).jad_an(jad_naVar, jad_huVar, (jad_re<?>) null);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            jad_na.jad_dq jad_dqVar = (jad_na.jad_dq) it.next();
                            jad_dqVar.jad_bo.execute(new jad_na.jad_an(jad_dqVar.jad_an));
                        }
                        jad_naVar.jad_bo();
                    } else {
                        throw new IllegalStateException("Already failed once");
                    }
                } else {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
            } finally {
            }
        }
        jad_fs jad_fsVar = this.jad_jt;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_cp = true;
            jad_an2 = jad_fsVar.jad_an(false);
        }
        if (jad_an2) {
            jad_fs();
        }
    }

    public final void jad_fs() {
        jad_fs jad_fsVar = this.jad_jt;
        synchronized (jad_fsVar) {
            jad_fsVar.jad_bo = false;
            jad_fsVar.jad_an = false;
            jad_fsVar.jad_cp = false;
        }
        jad_dq<?> jad_dqVar = this.jad_fs;
        jad_dqVar.jad_an = null;
        jad_dqVar.jad_bo = null;
        jad_dqVar.jad_cp = null;
        jad_jt<R> jad_jtVar = this.jad_an;
        jad_jtVar.jad_cp = null;
        jad_jtVar.jad_dq = null;
        jad_jtVar.jad_na = null;
        jad_jtVar.jad_jt = null;
        jad_jtVar.jad_kx = null;
        jad_jtVar.jad_iv = null;
        jad_jtVar.jad_ob = null;
        jad_jtVar.jad_jw = null;
        jad_jtVar.jad_pc = null;
        jad_jtVar.jad_an.clear();
        jad_jtVar.jad_ly = false;
        jad_jtVar.jad_bo.clear();
        jad_jtVar.jad_mz = false;
        this.jad_fq = false;
        this.jad_hu = null;
        this.jad_iv = null;
        this.jad_ob = null;
        this.jad_jw = null;
        this.jad_kx = null;
        this.jad_pc = null;
        this.jad_re = 0;
        this.jad_ep = null;
        this.jad_wj = null;
        this.jad_xk = null;
        this.jad_zm = null;
        this.jad_cn = null;
        this.jad_do = null;
        this.jad_tg = 0L;
        this.jad_gr = false;
        this.jad_vi = null;
        this.jad_bo.clear();
        this.jad_er.release(this);
    }

    public final void jad_hu() {
        int i = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(this.jad_sf)];
        if (i == 1) {
            this.jad_re = jad_an(1);
            this.jad_ep = jad_dq();
        } else if (i != 2) {
            if (i == 3) {
                jad_cp();
                return;
            } else {
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Unrecognized run reason: ");
                jad_an2.append(jad_iv.jad_an(this.jad_sf));
                throw new IllegalStateException(jad_an2.toString());
            }
        }
        jad_jt();
    }

    public final void jad_iv() {
        Throwable th;
        this.jad_cp.jad_bo();
        if (!this.jad_fq) {
            this.jad_fq = true;
            return;
        }
        if (this.jad_bo.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.jad_bo;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    public final void jad_jt() {
        this.jad_wj = Thread.currentThread();
        this.jad_tg = com.jd.ad.sdk.jad_gp.jad_jt.jad_an();
        boolean z = false;
        while (!this.jad_gr && this.jad_ep != null && !(z = this.jad_ep.jad_an())) {
            this.jad_re = jad_an(this.jad_re);
            this.jad_ep = jad_dq();
            if (this.jad_re == 4) {
                this.jad_sf = 2;
                ((jad_na) this.jad_pc).jad_an((jad_hu<?>) this);
                return;
            }
        }
        if ((this.jad_re == 6 || this.jad_gr) && !z) {
            jad_er();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.jd.ad.sdk.jad_it.jad_dq<?> jad_dqVar = this.jad_do;
        try {
            try {
                if (this.jad_gr) {
                    jad_er();
                    if (jad_dqVar != null) {
                        jad_dqVar.jad_bo();
                        return;
                    }
                    return;
                }
                jad_hu();
                if (jad_dqVar != null) {
                    jad_dqVar.jad_bo();
                }
            } catch (Throwable th) {
                if (jad_dqVar != null) {
                    jad_dqVar.jad_bo();
                }
                throw th;
            }
        } catch (com.jd.ad.sdk.jad_kv.jad_bo e) {
            throw e;
        } catch (Throwable th2) {
            if (Log.isLoggable("DecodeJob", 3)) {
                Logger.d("DecodeJob", "DecodeJob threw unexpectedly, isCancelled: " + this.jad_gr + ", stage: " + jad_jw.jad_an(this.jad_re), th2);
            }
            if (this.jad_re != 5) {
                this.jad_bo.add(th2);
                jad_er();
            }
            throw th2;
        }
    }

    @Override // com.jd.ad.sdk.jad_hq.jad_an.jad_dq
    @NonNull
    public com.jd.ad.sdk.jad_hq.jad_dq jad_an() {
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_fs.jad_an
    public void jad_an(com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, Object obj, com.jd.ad.sdk.jad_it.jad_dq<?> jad_dqVar, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, com.jd.ad.sdk.jad_hs.jad_hu jad_huVar2) {
        this.jad_xk = jad_huVar;
        this.jad_zm = obj;
        this.jad_do = jad_dqVar;
        this.jad_cn = jad_anVar;
        this.jad_yl = jad_huVar2;
        this.jad_hs = jad_huVar != this.jad_an.jad_an().get(0);
        if (Thread.currentThread() == this.jad_wj) {
            jad_cp();
        } else {
            this.jad_sf = 3;
            ((jad_na) this.jad_pc).jad_an((jad_hu<?>) this);
        }
    }

    public final void jad_an(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.jd.ad.sdk.jad_gp.jad_jt.jad_an(j));
        sb.append(", load key: ");
        sb.append(this.jad_kx);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Logger.v("DecodeJob", sb.toString());
    }

    public final <Data> jad_xk<R> jad_an(com.jd.ad.sdk.jad_it.jad_dq<?> jad_dqVar, Data data, com.jd.ad.sdk.jad_hs.jad_an jad_anVar) {
        if (data == null) {
            return null;
        }
        try {
            long jad_an2 = com.jd.ad.sdk.jad_gp.jad_jt.jad_an();
            jad_xk<R> jad_an3 = jad_an(data, jad_anVar);
            if (Log.isLoggable("DecodeJob", 2)) {
                jad_an("Decoded result " + jad_an3, jad_an2, (String) null);
            }
            return jad_an3;
        } finally {
            jad_dqVar.jad_bo();
        }
    }

    public final <Data> jad_xk<R> jad_an(Data data, com.jd.ad.sdk.jad_hs.jad_an jad_anVar) {
        jad_vi<Data, ?, R> jad_an2 = this.jad_an.jad_an((Class) data.getClass());
        com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar = this.jad_ob;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = jad_anVar == com.jd.ad.sdk.jad_hs.jad_an.RESOURCE_DISK_CACHE || this.jad_an.jad_re;
            com.jd.ad.sdk.jad_hs.jad_iv<Boolean> jad_ivVar = com.jd.ad.sdk.jad_rc.jad_jw.jad_iv;
            Boolean bool = (Boolean) jad_jwVar.jad_an(jad_ivVar);
            if (bool == null || (bool.booleanValue() && !z)) {
                jad_jwVar = new com.jd.ad.sdk.jad_hs.jad_jw();
                jad_jwVar.jad_an(this.jad_ob);
                jad_jwVar.jad_bo.put(jad_ivVar, Boolean.valueOf(z));
            }
        }
        com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar2 = jad_jwVar;
        com.jd.ad.sdk.jad_it.jad_er<Data> jad_bo2 = this.jad_hu.jad_bo.jad_bo(data);
        try {
            return jad_an2.jad_an(jad_bo2, jad_jwVar2, this.jad_ly, this.jad_mz, new jad_cp(jad_anVar));
        } finally {
            jad_bo2.jad_bo();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void jad_an(jad_xk<R> jad_xkVar, com.jd.ad.sdk.jad_hs.jad_an jad_anVar, boolean z) {
        jad_iv();
        jad_na<?> jad_naVar = (jad_na) this.jad_pc;
        synchronized (jad_naVar) {
            jad_naVar.jad_qd = jad_xkVar;
            jad_naVar.jad_re = jad_anVar;
            jad_naVar.jad_yl = z;
        }
        synchronized (jad_naVar) {
            try {
                jad_naVar.jad_bo.jad_bo();
                if (jad_naVar.jad_xk) {
                    jad_naVar.jad_qd.jad_dq();
                    jad_naVar.jad_dq();
                    return;
                }
                if (jad_naVar.jad_an.jad_an.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (jad_naVar.jad_sf) {
                    throw new IllegalStateException("Already have resource");
                }
                jad_na.jad_cp jad_cpVar = jad_naVar.jad_er;
                jad_xk<?> jad_xkVar2 = jad_naVar.jad_qd;
                boolean z2 = jad_naVar.jad_mz;
                com.jd.ad.sdk.jad_hs.jad_hu jad_huVar = jad_naVar.jad_ly;
                jad_re.jad_an jad_anVar2 = jad_naVar.jad_cp;
                jad_cpVar.getClass();
                jad_naVar.jad_vi = new jad_re<>(jad_xkVar2, z2, true, jad_huVar, jad_anVar2);
                jad_naVar.jad_sf = true;
                jad_na.jad_er jad_erVar = jad_naVar.jad_an;
                jad_erVar.getClass();
                ArrayList arrayList = new ArrayList(jad_erVar.jad_an);
                jad_naVar.jad_an(arrayList.size() + 1);
                ((jad_mz) jad_naVar.jad_fs).jad_an(jad_naVar, jad_naVar.jad_ly, jad_naVar.jad_vi);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    jad_na.jad_dq jad_dqVar = (jad_na.jad_dq) it.next();
                    jad_dqVar.jad_bo.execute(new jad_na.jad_bo(jad_dqVar.jad_an));
                }
                jad_naVar.jad_bo();
            } finally {
            }
        }
    }

    @Override // com.jd.ad.sdk.jad_kv.jad_fs.jad_an
    public void jad_an(com.jd.ad.sdk.jad_hs.jad_hu jad_huVar, Exception exc, com.jd.ad.sdk.jad_it.jad_dq<?> jad_dqVar, com.jd.ad.sdk.jad_hs.jad_an jad_anVar) {
        jad_dqVar.jad_bo();
        jad_sf jad_sfVar = new jad_sf("Fetching data failed", Collections.singletonList(exc));
        Class<?> jad_an2 = jad_dqVar.jad_an();
        jad_sfVar.jad_bo = jad_huVar;
        jad_sfVar.jad_cp = jad_anVar;
        jad_sfVar.jad_dq = jad_an2;
        this.jad_bo.add(jad_sfVar);
        if (Thread.currentThread() == this.jad_wj) {
            jad_jt();
        } else {
            this.jad_sf = 2;
            ((jad_na) this.jad_pc).jad_an((jad_hu<?>) this);
        }
    }
}
