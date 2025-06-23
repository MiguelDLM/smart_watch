package com.kwad.components.offline.api.core.network.adapter;

import com.kwad.components.offline.api.core.network.IOfflineCompoRequest;
import com.kwad.sdk.core.network.n;

/* loaded from: classes11.dex */
public abstract class NormalRequestAdapter<R extends IOfflineCompoRequest> implements n {
    public abstract R getOfflineCompoRequest();
}
