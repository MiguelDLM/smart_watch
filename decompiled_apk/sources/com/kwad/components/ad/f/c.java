package com.kwad.components.ad.f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.s.m;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c {
    public static void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.b(covert);
        boolean a2 = m.rI().a(covert, "loadNativeAd");
        covert.setAdStyle(10000);
        KsAdLoadManager.M();
        KsAdLoadManager.a(new a.C0806a().e(new ImpInfo(covert)).aJ(a2).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.f.c.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                com.kwad.sdk.commercial.d.d.a(covert, adTemplateList.size());
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = covert;
                        arrayList.add(new d(adTemplate));
                    }
                }
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.f.c.1.2
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        KsAdLoadManager.M().b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
                try {
                    for (AdTemplate adTemplate2 : adResultData.getAdTemplateList()) {
                        if (adTemplate2 != null) {
                            com.kwad.sdk.core.response.b.e.dS(adTemplate2);
                            try {
                                if (com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class) != null) {
                                    com.kwad.sdk.components.c.f(com.kwad.components.core.n.a.b.a.class);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.k
            public final void onError(final int i, final String str) {
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.f.c.1.1
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.NativeAdListener.this.onError(i, str);
                    }
                });
            }
        }).ra());
    }

    public static void loadNativeAd(String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        if (m.rI().a((SceneImpl) null, "loadNativeAdByJson") && m.rI().rJ() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.f.c.2
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    com.kwad.sdk.core.e.c.e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awK;
                    nativeAdListener2.onError(eVar.errorCode, eVar.msg);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.f.c.3
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        com.kwad.sdk.core.e.c.e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = AdResultData.this;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
                return;
            }
            if (adResultData.isAdResultDataEmpty()) {
                bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.f.c.4
                    @Override // com.kwad.sdk.utils.az
                    public final void doTask() {
                        String str2;
                        KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                        int i = com.kwad.sdk.core.network.e.awK.errorCode;
                        if (TextUtils.isEmpty(adResultData.testErrorMsg)) {
                            str2 = com.kwad.sdk.core.network.e.awK.msg;
                        } else {
                            str2 = adResultData.testErrorMsg;
                        }
                        nativeAdListener2.onError(i, str2);
                    }
                });
                return;
            }
            final ArrayList arrayList = new ArrayList();
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    arrayList.add(new d(adTemplate));
                }
            }
            bo.runOnUiThread(new az() { // from class: com.kwad.components.ad.f.c.5
                @Override // com.kwad.sdk.utils.az
                public final void doTask() {
                    KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.e.c.printStackTrace(e);
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awJ;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
