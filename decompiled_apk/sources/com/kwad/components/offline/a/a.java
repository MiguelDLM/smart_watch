package com.kwad.components.offline.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* loaded from: classes11.dex */
public class a implements com.kwad.components.core.n.a.a.a {
    private final IAdLiveOfflineCompo adl;

    public a(@NonNull IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        this.adl = iAdLiveOfflineCompo;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveEndRequest getAdLiveEndRequest(String str) {
        return this.adl.getAdLiveEndRequest(str);
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        return this.adl.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j);
    }

    @Override // com.kwad.sdk.components.a
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final IAdLiveOfflineView getView(Context context, int i) {
        return this.adl.getView(context, i);
    }

    @Override // com.kwad.sdk.components.a
    public final void init(Context context) {
    }

    @Override // com.kwad.components.core.n.a.a.a
    public final boolean pj() {
        if (this.adl.getState() == IAdLiveOfflineCompo.AdLiveState.READY) {
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.components.a
    public final int priority() {
        return this.adl.priority();
    }
}
