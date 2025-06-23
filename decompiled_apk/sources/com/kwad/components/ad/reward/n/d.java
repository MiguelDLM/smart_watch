package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.aj;

/* loaded from: classes11.dex */
public abstract class d {
    public void a(r rVar) {
    }

    public void ab(boolean z) {
    }

    public final void b(@NonNull r rVar) {
        a(rVar);
        gG().getContext();
        ab(aj.ML());
    }

    public abstract ViewGroup gG();

    public void onUnbind() {
    }
}
