package com.google.android.gms.fitness.request;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public final class zzah {
    private static final zzah zza = new zzah();
    private final Map zzb = new HashMap();

    private zzah() {
    }

    public static zzah zza() {
        return zza;
    }

    private static ListenerHolder zzf(OnDataPointListener onDataPointListener, Looper looper) {
        return ListenerHolders.createListenerHolder(onDataPointListener, looper, OnDataPointListener.class.getSimpleName());
    }

    public final zzaj zzb(ListenerHolder listenerHolder) {
        zzaj zzajVar;
        synchronized (this.zzb) {
            try {
                ListenerHolder.ListenerKey listenerKey = (ListenerHolder.ListenerKey) Preconditions.checkNotNull(listenerHolder.getListenerKey(), "Key must not be null");
                zzajVar = (zzaj) this.zzb.get(listenerKey);
                if (zzajVar == null) {
                    zzajVar = new zzaj(listenerHolder, null);
                    this.zzb.put(listenerKey, zzajVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzajVar;
    }

    public final zzaj zzc(OnDataPointListener onDataPointListener, Looper looper) {
        return zzb(zzf(onDataPointListener, looper));
    }

    @Nullable
    public final zzaj zzd(ListenerHolder listenerHolder) {
        synchronized (this.zzb) {
            try {
                ListenerHolder.ListenerKey listenerKey = listenerHolder.getListenerKey();
                if (listenerKey == null) {
                    return null;
                }
                zzaj zzajVar = (zzaj) this.zzb.remove(listenerKey);
                if (zzajVar != null) {
                    zzajVar.zzc();
                }
                return zzajVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Nullable
    public final zzaj zze(OnDataPointListener onDataPointListener, Looper looper) {
        return zzd(zzf(onDataPointListener, looper));
    }
}
