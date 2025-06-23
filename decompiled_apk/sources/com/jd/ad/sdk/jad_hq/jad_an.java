package com.jd.ad.sdk.jad_hq;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_ep.jad_ly;
import com.jd.ad.sdk.jad_hq.jad_dq;
import com.jd.ad.sdk.logger.Logger;
import java.util.List;

/* loaded from: classes10.dex */
public final class jad_an {
    public static final jad_er<Object> jad_an = new C0686jad_an();

    /* renamed from: com.jd.ad.sdk.jad_hq.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0686jad_an implements jad_er<Object> {
        @Override // com.jd.ad.sdk.jad_hq.jad_an.jad_er
        public void jad_an(@NonNull Object obj) {
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_bo<T> {
        T jad_an();
    }

    /* loaded from: classes10.dex */
    public static final class jad_cp<T> implements Pools.Pool<T> {
        public final jad_bo<T> jad_an;
        public final jad_er<T> jad_bo;
        public final Pools.Pool<T> jad_cp;

        public jad_cp(@NonNull Pools.Pool<T> pool, @NonNull jad_bo<T> jad_boVar, @NonNull jad_er<T> jad_erVar) {
            this.jad_cp = pool;
            this.jad_an = jad_boVar;
            this.jad_bo = jad_erVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T acquire = this.jad_cp.acquire();
            if (acquire == null) {
                acquire = this.jad_an.jad_an();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder jad_an = jad_ly.jad_an("Created new ");
                    jad_an.append(acquire.getClass());
                    Logger.v("FactoryPools", jad_an.toString());
                }
            }
            if (acquire instanceof jad_dq) {
                ((jad_dq.jad_bo) acquire.jad_an()).jad_an = false;
            }
            return (T) acquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof jad_dq) {
                ((jad_dq.jad_bo) ((jad_dq) t).jad_an()).jad_an = true;
            }
            this.jad_bo.jad_an(t);
            return this.jad_cp.release(t);
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_dq {
        @NonNull
        com.jd.ad.sdk.jad_hq.jad_dq jad_an();
    }

    /* loaded from: classes10.dex */
    public interface jad_er<T> {
        void jad_an(@NonNull T t);
    }

    @NonNull
    public static <T extends jad_dq> Pools.Pool<T> jad_an(int i, @NonNull jad_bo<T> jad_boVar) {
        return new jad_cp(new Pools.SynchronizedPool(i), jad_boVar, jad_an);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> jad_an() {
        return new jad_cp(new Pools.SynchronizedPool(20), new com.jd.ad.sdk.jad_hq.jad_bo(), new com.jd.ad.sdk.jad_hq.jad_cp());
    }
}
