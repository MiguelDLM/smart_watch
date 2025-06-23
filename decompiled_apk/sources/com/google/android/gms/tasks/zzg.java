package com.google.android.gms.tasks;

/* loaded from: classes9.dex */
final class zzg implements Runnable {
    final /* synthetic */ zzh zza;

    public zzg(zzh zzhVar) {
        this.zza = zzhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCanceledListener onCanceledListener;
        OnCanceledListener onCanceledListener2;
        obj = this.zza.zzb;
        synchronized (obj) {
            try {
                zzh zzhVar = this.zza;
                onCanceledListener = zzhVar.zzc;
                if (onCanceledListener != null) {
                    onCanceledListener2 = zzhVar.zzc;
                    onCanceledListener2.onCanceled();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
