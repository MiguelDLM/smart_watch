package com.kwad.components.core.n.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.sdk.components.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes11.dex */
public final class a implements ILive {
    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j) {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) c.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.pj()) {
            return aVar.getAdLivePlayModule(iAdLiveOfflineView, str, str2, str3, j);
        }
        return null;
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveOfflineView getIAdLiveOfflineView(Context context, int i) {
        com.kwad.components.core.n.a.a.a aVar = (com.kwad.components.core.n.a.a.a) c.f(com.kwad.components.core.n.a.a.a.class);
        if (aVar != null && aVar.pj()) {
            try {
                return aVar.getView(context, i);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
        return null;
    }

    @Override // com.kwad.components.offline.api.core.adlive.ILive
    public final IAdLiveEndRequest mIAdLiveEndRequest(String str) {
        com.kwad.components.core.n.a.a.a aVar;
        if (!TextUtils.isEmpty(str) && (aVar = (com.kwad.components.core.n.a.a.a) c.f(com.kwad.components.core.n.a.a.a.class)) != null && aVar.pj()) {
            return aVar.getAdLiveEndRequest(str);
        }
        return null;
    }
}
