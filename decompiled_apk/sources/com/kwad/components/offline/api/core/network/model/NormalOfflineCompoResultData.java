package com.kwad.components.offline.api.core.network.model;

import com.kwad.sdk.core.network.c;

/* loaded from: classes11.dex */
public class NormalOfflineCompoResultData extends BaseOfflineCompoResultData {
    public int code;
    public String data;
    public String header;

    public void parseResponse(c cVar) {
        this.code = cVar.code;
        this.data = cVar.awE;
        this.header = null;
    }
}
