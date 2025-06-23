package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.az;
import java.util.List;

/* loaded from: classes11.dex */
public class j extends o<com.kwad.components.core.request.a, AdResultData> {
    private final com.kwad.components.core.request.model.a JO;

    public j(com.kwad.components.core.request.model.a aVar) {
        this.JO = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void j(AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        a mU = a.mU();
        if (mU != null && proceedTemplateList.size() > 0) {
            AdTemplate adTemplate = proceedTemplateList.get(0);
            e s = e.s(adResultData.getPosId());
            mU.mV();
            mU.i(h.a(s, adResultData));
            mU.a(e.ak(adTemplate));
        }
    }

    public boolean a(com.kwad.components.core.request.model.a aVar, AdResultData adResultData) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(@NonNull com.kwad.components.core.request.a aVar, @NonNull final AdResultData adResultData) {
        super.onSuccess(aVar, adResultData);
        GlobalThreadPools.Gr().submit(new az() { // from class: com.kwad.components.core.c.j.1
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                j jVar = j.this;
                j.j(adResultData);
            }
        });
        if (a(this.JO, adResultData)) {
            return;
        }
        com.kwad.components.core.request.model.a.a(this.JO, adResultData, false);
    }

    @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(@NonNull com.kwad.components.core.request.a aVar, int i, String str) {
        super.onError(aVar, i, str);
        com.kwad.components.core.request.model.a.a(this.JO, i, str, false);
    }
}
