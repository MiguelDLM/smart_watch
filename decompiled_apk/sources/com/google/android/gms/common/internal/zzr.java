package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zzr implements Handler.Callback {
    final /* synthetic */ zzs zza;

    public /* synthetic */ zzr(zzs zzsVar, zzq zzqVar) {
        this.zza = zzsVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        HashMap hashMap4;
        HashMap hashMap5;
        int i = message.what;
        if (i != 0) {
            if (i != 1) {
                return false;
            }
            hashMap4 = this.zza.zzb;
            synchronized (hashMap4) {
                try {
                    zzo zzoVar = (zzo) message.obj;
                    hashMap5 = this.zza.zzb;
                    zzp zzpVar = (zzp) hashMap5.get(zzoVar);
                    if (zzpVar != null && zzpVar.zza() == 3) {
                        Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(zzoVar), new Exception());
                        ComponentName zzb = zzpVar.zzb();
                        if (zzb == null) {
                            zzb = zzoVar.zza();
                        }
                        if (zzb == null) {
                            String zzc = zzoVar.zzc();
                            Preconditions.checkNotNull(zzc);
                            zzb = new ComponentName(zzc, "unknown");
                        }
                        zzpVar.onServiceDisconnected(zzb);
                    }
                } finally {
                }
            }
            return true;
        }
        hashMap = this.zza.zzb;
        synchronized (hashMap) {
            try {
                zzo zzoVar2 = (zzo) message.obj;
                hashMap2 = this.zza.zzb;
                zzp zzpVar2 = (zzp) hashMap2.get(zzoVar2);
                if (zzpVar2 != null && zzpVar2.zzi()) {
                    if (zzpVar2.zzj()) {
                        zzpVar2.zzg("GmsClientSupervisor");
                    }
                    hashMap3 = this.zza.zzb;
                    hashMap3.remove(zzoVar2);
                }
            } finally {
            }
        }
        return true;
    }
}
