package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;

/* loaded from: classes11.dex */
public class d extends c {
    @Override // com.kwad.components.core.request.k
    public void a(@NonNull AdResultData adResultData) {
    }

    @Override // com.kwad.components.core.request.k
    public void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.request.c
    public void a(@NonNull AdResultData adResultData, boolean z) {
        a(adResultData);
    }

    @Override // com.kwad.components.core.request.c
    public void a(int i, String str, boolean z) {
        onError(i, str);
    }
}
