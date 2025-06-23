package com.jd.ad.sdk.jad_kv;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_ep.jad_hu;
import com.jd.ad.sdk.jad_kv.jad_hu;
import com.jd.ad.sdk.jad_oz.jad_na;
import java.util.List;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes10.dex */
public class jad_kx<DataType, ResourceType, Transcode> {
    public final Class<DataType> jad_an;
    public final List<? extends com.jd.ad.sdk.jad_hs.jad_ly<DataType, ResourceType>> jad_bo;
    public final com.jd.ad.sdk.jad_wh.jad_er<ResourceType, Transcode> jad_cp;
    public final Pools.Pool<List<Throwable>> jad_dq;
    public final String jad_er;

    /* loaded from: classes10.dex */
    public interface jad_an<ResourceType> {
    }

    public jad_kx(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends com.jd.ad.sdk.jad_hs.jad_ly<DataType, ResourceType>> list, com.jd.ad.sdk.jad_wh.jad_er<ResourceType, Transcode> jad_erVar, Pools.Pool<List<Throwable>> pool) {
        this.jad_an = cls;
        this.jad_bo = list;
        this.jad_cp = jad_erVar;
        this.jad_dq = pool;
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("Failed DecodePath{");
        jad_an2.append(cls.getSimpleName());
        jad_an2.append("->");
        jad_an2.append(cls2.getSimpleName());
        jad_an2.append("->");
        jad_an2.append(cls3.getSimpleName());
        jad_an2.append(ooOOo0oXI.f33074oOoXoXO);
        this.jad_er = jad_an2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072 A[LOOP:0: B:2:0x0012->B:13:0x0072, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0074 A[EDGE_INSN: B:14:0x0074->B:15:0x0074 BREAK  A[LOOP:0: B:2:0x0012->B:13:0x0072], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0052  */
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.jd.ad.sdk.jad_kv.jad_xk<ResourceType> jad_an(com.jd.ad.sdk.jad_it.jad_er<DataType> r17, int r18, int r19, @androidx.annotation.NonNull com.jd.ad.sdk.jad_hs.jad_jw r20, java.util.List<java.lang.Throwable> r21) {
        /*
            r16 = this;
            r1 = r16
            r2 = r20
            r3 = r21
            r4 = 1
            r5 = 2
            java.util.List<? extends com.jd.ad.sdk.jad_hs.jad_ly<DataType, ResourceType>> r0 = r1.jad_bo
            int r6 = r0.size()
            r0 = 0
            r7 = 0
            r8 = r0
            r9 = 0
        L12:
            if (r9 >= r6) goto L74
            java.util.List<? extends com.jd.ad.sdk.jad_hs.jad_ly<DataType, ResourceType>> r0 = r1.jad_bo
            java.lang.Object r0 = r0.get(r9)
            r10 = r0
            com.jd.ad.sdk.jad_hs.jad_ly r10 = (com.jd.ad.sdk.jad_hs.jad_ly) r10
            java.lang.Object r0 = r17.jad_an()     // Catch: java.lang.OutOfMemoryError -> L3b java.lang.RuntimeException -> L41 java.io.IOException -> L43
            boolean r0 = r10.jad_an(r0, r2)     // Catch: java.lang.OutOfMemoryError -> L3b java.lang.RuntimeException -> L41 java.io.IOException -> L43
            if (r0 == 0) goto L45
            java.lang.Object r0 = r17.jad_an()     // Catch: java.lang.OutOfMemoryError -> L3b java.lang.RuntimeException -> L41 java.io.IOException -> L43
            r11 = r18
            r12 = r19
            com.jd.ad.sdk.jad_kv.jad_xk r0 = r10.jad_an(r0, r11, r12, r2)     // Catch: java.lang.OutOfMemoryError -> L35 java.lang.RuntimeException -> L37 java.io.IOException -> L39
            r8 = r0
            goto L6f
        L35:
            r0 = move-exception
            goto L4a
        L37:
            r0 = move-exception
            goto L4a
        L39:
            r0 = move-exception
            goto L4a
        L3b:
            r0 = move-exception
        L3c:
            r11 = r18
            r12 = r19
            goto L4a
        L41:
            r0 = move-exception
            goto L3c
        L43:
            r0 = move-exception
            goto L3c
        L45:
            r11 = r18
            r12 = r19
            goto L6f
        L4a:
            java.lang.String r13 = "DecodePath"
            boolean r14 = android.util.Log.isLoggable(r13, r5)
            if (r14 == 0) goto L6c
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "Failed to decode data for "
            r14.append(r15)
            r14.append(r10)
            java.lang.String r10 = r14.toString()
            java.lang.Object[] r14 = new java.lang.Object[r5]
            r14[r7] = r10
            r14[r4] = r0
            com.jd.ad.sdk.logger.Logger.v(r13, r14)
        L6c:
            r3.add(r0)
        L6f:
            if (r8 == 0) goto L72
            goto L74
        L72:
            int r9 = r9 + r4
            goto L12
        L74:
            if (r8 == 0) goto L77
            return r8
        L77:
            com.jd.ad.sdk.jad_kv.jad_sf r0 = new com.jd.ad.sdk.jad_kv.jad_sf
            java.lang.String r2 = r1.jad_er
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
            r0.<init>(r2, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_kv.jad_kx.jad_an(com.jd.ad.sdk.jad_it.jad_er, int, int, com.jd.ad.sdk.jad_hs.jad_jw, java.util.List):com.jd.ad.sdk.jad_kv.jad_xk");
    }

    public String toString() {
        StringBuilder jad_an2 = com.jd.ad.sdk.jad_ep.jad_ly.jad_an("DecodePath{ dataClass=");
        jad_an2.append(this.jad_an);
        jad_an2.append(", decoders=");
        jad_an2.append(this.jad_bo);
        jad_an2.append(", transcoder=");
        jad_an2.append(this.jad_cp);
        jad_an2.append('}');
        return jad_an2.toString();
    }

    public jad_xk<Transcode> jad_an(com.jd.ad.sdk.jad_it.jad_er<DataType> jad_erVar, int i, int i2, @NonNull com.jd.ad.sdk.jad_hs.jad_jw jad_jwVar, jad_an<ResourceType> jad_anVar) {
        jad_xk<ResourceType> jad_xkVar;
        com.jd.ad.sdk.jad_hs.jad_na jad_naVar;
        com.jd.ad.sdk.jad_hs.jad_cp jad_cpVar;
        com.jd.ad.sdk.jad_hs.jad_hu jad_dqVar;
        List<Throwable> list = (List) com.jd.ad.sdk.jad_gp.jad_kx.jad_an(this.jad_dq.acquire());
        try {
            jad_xk<ResourceType> jad_an2 = jad_an(jad_erVar, i, i2, jad_jwVar, list);
            this.jad_dq.release(list);
            jad_hu.jad_cp jad_cpVar2 = (jad_hu.jad_cp) jad_anVar;
            jad_hu jad_huVar = jad_hu.this;
            com.jd.ad.sdk.jad_hs.jad_an jad_anVar2 = jad_cpVar2.jad_an;
            jad_huVar.getClass();
            Class<?> cls = jad_an2.get().getClass();
            com.jd.ad.sdk.jad_hs.jad_mz jad_mzVar = null;
            if (jad_anVar2 != com.jd.ad.sdk.jad_hs.jad_an.RESOURCE_DISK_CACHE) {
                com.jd.ad.sdk.jad_hs.jad_na jad_bo = jad_huVar.jad_an.jad_bo(cls);
                jad_naVar = jad_bo;
                jad_xkVar = jad_bo.jad_an(jad_huVar.jad_hu, jad_an2, jad_huVar.jad_ly, jad_huVar.jad_mz);
            } else {
                jad_xkVar = jad_an2;
                jad_naVar = null;
            }
            if (!jad_an2.equals(jad_xkVar)) {
                jad_an2.jad_dq();
            }
            if (jad_huVar.jad_an.jad_an((jad_xk<?>) jad_xkVar)) {
                jad_mzVar = jad_huVar.jad_an.jad_cp.jad_bo.jad_dq.jad_an(jad_xkVar.jad_cp());
                if (jad_mzVar != null) {
                    jad_cpVar = jad_mzVar.jad_an(jad_huVar.jad_ob);
                } else {
                    throw new jad_hu.jad_dq(jad_xkVar.jad_cp());
                }
            } else {
                jad_cpVar = com.jd.ad.sdk.jad_hs.jad_cp.NONE;
            }
            com.jd.ad.sdk.jad_hs.jad_mz jad_mzVar2 = jad_mzVar;
            jad_jt<R> jad_jtVar = jad_huVar.jad_an;
            com.jd.ad.sdk.jad_hs.jad_hu jad_huVar2 = jad_huVar.jad_xk;
            List<jad_na.jad_an<?>> jad_cp = jad_jtVar.jad_cp();
            int size = jad_cp.size();
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (jad_cp.get(i3).jad_an.equals(jad_huVar2)) {
                    z = true;
                    break;
                }
                i3++;
            }
            jad_xk<ResourceType> jad_xkVar2 = jad_xkVar;
            if (jad_huVar.jad_na.jad_an(!z, jad_anVar2, jad_cpVar)) {
                if (jad_mzVar2 != null) {
                    int i4 = jad_hu.jad_an.jad_cp[jad_cpVar.ordinal()];
                    if (i4 == 1) {
                        jad_dqVar = new jad_dq(jad_huVar.jad_xk, jad_huVar.jad_iv);
                    } else {
                        if (i4 != 2) {
                            throw new IllegalArgumentException("Unknown strategy: " + jad_cpVar);
                        }
                        jad_dqVar = new jad_zm(jad_huVar.jad_an.jad_cp.jad_an, jad_huVar.jad_xk, jad_huVar.jad_iv, jad_huVar.jad_ly, jad_huVar.jad_mz, jad_naVar, cls, jad_huVar.jad_ob);
                    }
                    jad_wj<Z> jad_an3 = jad_wj.jad_an(jad_xkVar);
                    jad_hu.jad_dq<?> jad_dqVar2 = jad_huVar.jad_fs;
                    jad_dqVar2.jad_an = jad_dqVar;
                    jad_dqVar2.jad_bo = jad_mzVar2;
                    jad_dqVar2.jad_cp = jad_an3;
                    jad_xkVar2 = jad_an3;
                } else {
                    throw new jad_hu.jad_dq(jad_xkVar.get().getClass());
                }
            }
            return this.jad_cp.jad_an(jad_xkVar2, jad_jwVar);
        } catch (Throwable th) {
            this.jad_dq.release(list);
            throw th;
        }
    }
}
