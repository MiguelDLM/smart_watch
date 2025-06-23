package com.kwad.components.ad.draw;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;

/* loaded from: classes11.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        SceneImpl covert = SceneImpl.covert(ksScene);
        boolean a2 = m.rI().a(covert, "loadDrawAd");
        covert.setAdStyle(6);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0806a().e(new ImpInfo(covert)).aJ(a2).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void a(@NonNull AdResultData adResultData) {
                String str;
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null && !TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(e.dS(adTemplate)))) {
                        arrayList.add(new c(adTemplate));
                    }
                }
                if (arrayList.isEmpty()) {
                    int i = com.kwad.sdk.core.network.e.awK.errorCode;
                    if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                        str = com.kwad.sdk.core.network.e.awK.msg + "(无视频资源)";
                    } else {
                        str = adResultData.testErrorMsg;
                    }
                    onError(i, str);
                    return;
                }
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.draw.d.1.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        KsLoadManager.DrawAdListener.this.onDrawAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdDrawLoadManager", "loadDrawAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.DrawAdListener.this.onError(i, str);
                    }
                });
            }
        }).ra());
    }
}
