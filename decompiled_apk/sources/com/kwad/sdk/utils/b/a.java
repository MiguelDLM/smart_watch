package com.kwad.sdk.utils.b;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: classes11.dex */
public class a extends com.kwad.sdk.commercial.c.a {
    public int aTq = -1;
    public int aTr = -1;
    public int aTs = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "KvOperationRecord{putCount=" + this.aTq + ", getFailedCount=" + this.aTr + ", getSuccessCount=" + this.aTs + '}';
    }
}
