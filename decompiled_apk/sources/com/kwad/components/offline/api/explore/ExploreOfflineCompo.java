package com.kwad.components.offline.api.explore;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.explore.model.AdParams;

/* loaded from: classes11.dex */
public interface ExploreOfflineCompo extends IOfflineCompo<ExploreOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.explore.ExploreOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.explore";

    void reportKsAllianceAdLoad(AdParams adParams);

    void reportKsAllianceAdShow(AdParams adParams);
}
