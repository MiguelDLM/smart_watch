package com.jd.ad.sdk.jad_ep;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.jd.ad.sdk.jad_ep.jad_cp;
import com.jd.ad.sdk.jad_ep.jad_dq;
import com.jd.ad.sdk.jad_kv.jad_mz;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class jad_er extends ContextWrapper {

    @VisibleForTesting
    public static final jad_kx<?, ?> jad_jw = new jad_bo();
    public final com.jd.ad.sdk.jad_lw.jad_bo jad_an;
    public final jad_hu jad_bo;
    public final jad_cp.jad_an jad_cp;
    public final List<com.jd.ad.sdk.jad_al.jad_jt<Object>> jad_dq;
    public final Map<Class<?>, jad_kx<?, ?>> jad_er;
    public final jad_mz jad_fs;
    public final int jad_hu;

    @Nullable
    @GuardedBy("this")
    public com.jd.ad.sdk.jad_al.jad_hu jad_iv;
    public final jad_fs jad_jt;

    public jad_er(@NonNull Context context, @NonNull com.jd.ad.sdk.jad_lw.jad_bo jad_boVar, @NonNull jad_hu jad_huVar, @NonNull com.jd.ad.sdk.jad_bm.jad_bo jad_boVar2, @NonNull jad_cp.jad_an jad_anVar, @NonNull Map<Class<?>, jad_kx<?, ?>> map, @NonNull List<com.jd.ad.sdk.jad_al.jad_jt<Object>> list, @NonNull jad_mz jad_mzVar, @NonNull jad_fs jad_fsVar, int i) {
        super(context.getApplicationContext());
        this.jad_an = jad_boVar;
        this.jad_bo = jad_huVar;
        this.jad_cp = jad_anVar;
        this.jad_dq = list;
        this.jad_er = map;
        this.jad_fs = jad_mzVar;
        this.jad_jt = jad_fsVar;
        this.jad_hu = i;
    }

    public List<com.jd.ad.sdk.jad_al.jad_jt<Object>> jad_an() {
        return this.jad_dq;
    }

    public synchronized com.jd.ad.sdk.jad_al.jad_hu jad_bo() {
        try {
            if (this.jad_iv == null) {
                ((jad_dq.jad_an) this.jad_cp).getClass();
                com.jd.ad.sdk.jad_al.jad_hu jad_huVar = new com.jd.ad.sdk.jad_al.jad_hu();
                jad_huVar.jad_tg = true;
                this.jad_iv = jad_huVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.jad_iv;
    }

    public jad_fs jad_cp() {
        return this.jad_jt;
    }
}
