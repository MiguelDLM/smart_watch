package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes9.dex */
public final class zao implements Runnable {
    final /* synthetic */ zap zaa;
    private final zam zab;

    public zao(zap zapVar, zam zamVar) {
        this.zaa = zapVar;
        this.zab = zamVar;
    }

    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (!this.zaa.zaa) {
            return;
        }
        ConnectionResult zab = this.zab.zab();
        if (zab.hasResolution()) {
            zap zapVar = this.zaa;
            zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.zaa(zapVar.getActivity(), (PendingIntent) Preconditions.checkNotNull(zab.getResolution()), this.zab.zaa(), false), 1);
            return;
        }
        zap zapVar2 = this.zaa;
        if (zapVar2.zac.getErrorResolutionIntent(zapVar2.getActivity(), zab.getErrorCode(), null) != null) {
            zap zapVar3 = this.zaa;
            zapVar3.zac.zag(zapVar3.getActivity(), zapVar3.mLifecycleFragment, zab.getErrorCode(), 2, this.zaa);
            return;
        }
        if (zab.getErrorCode() == 18) {
            zap zapVar4 = this.zaa;
            Dialog zab2 = zapVar4.zac.zab(zapVar4.getActivity(), zapVar4);
            zap zapVar5 = this.zaa;
            zapVar5.zac.zac(zapVar5.getActivity().getApplicationContext(), new zan(this, zab2));
            return;
        }
        this.zaa.zaa(zab, this.zab.zaa());
    }
}
