package com.kwad.components.core.n.a.a;

import android.content.Context;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;

/* loaded from: classes11.dex */
public interface a extends com.kwad.sdk.components.a {
    IAdLiveEndRequest getAdLiveEndRequest(String str);

    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j);

    IAdLiveOfflineView getView(Context context, int i);

    boolean pj();
}
