package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.d;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.az;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class c {
    private static <T extends com.kwad.components.core.request.a> T a(com.kwad.sdk.f.c<T> cVar) {
        return cVar.get();
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.request.model.a ra = new a.C0806a().e(new ImpInfo(SceneImpl.covert(ksScene))).a(new d()).ra();
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) a(new com.kwad.sdk.f.c<com.kwad.components.ad.a.a>() { // from class: com.kwad.components.ad.adbit.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.c
            /* renamed from: P, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.a get() {
                return new com.kwad.components.ad.a.a(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).N();
    }

    public static String a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        final com.kwad.components.core.request.model.a ra = new a.C0806a().e(new ImpInfo(sceneImpl)).a(new d()).ra();
        b bVar = (b) a(new com.kwad.sdk.f.c<b>() { // from class: com.kwad.components.ad.adbit.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.f.c
            /* renamed from: O, reason: merged with bridge method [inline-methods] */
            public b get() {
                return new b(com.kwad.components.core.request.model.a.this);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).N();
    }

    public static boolean b(@NonNull final com.kwad.components.core.request.model.a aVar) {
        String bidResponseV2 = aVar.MX.adScene.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.MX.adScene.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.Gr().submit(new az() { // from class: com.kwad.components.ad.adbit.c.3
            @Override // com.kwad.sdk.utils.az
            public final void doTask() {
                try {
                    com.kwad.components.core.request.model.a.this.ay("server_bid_one");
                    com.kwad.components.core.request.model.a aVar2 = com.kwad.components.core.request.model.a.this;
                    com.kwad.sdk.commercial.d.d.b(aVar2.MX.adScene, aVar2.qZ());
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(com.kwad.components.core.request.model.a.this.MX.adScene);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(c.b(adBitResultData));
                    adBitResultData.setAdSource("server_bid_one");
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = com.kwad.components.core.request.model.a.this.MX.adScene.getAdStyle();
                    if (adStyle != 10000 && adStyle != e.dM(adTemplate)) {
                        com.kwad.components.core.request.model.a aVar3 = com.kwad.components.core.request.model.a.this;
                        com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awO;
                        com.kwad.components.core.request.model.a.a(aVar3, eVar.errorCode, eVar.msg, true);
                        return;
                    }
                    com.kwad.components.core.request.model.a.a(com.kwad.components.core.request.model.a.this, adBitResultData, true);
                } catch (Exception e) {
                    com.kwad.components.core.request.model.a aVar4 = com.kwad.components.core.request.model.a.this;
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.awJ;
                    com.kwad.components.core.request.model.a.a(aVar4, eVar2.errorCode, eVar2.msg, true);
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e);
                }
            }
        });
        return true;
    }

    private static void a(String str, @NonNull com.kwad.components.core.request.model.a aVar) {
        try {
            aVar.ay("server_bid_two");
            com.kwad.sdk.commercial.d.d.b(aVar.MX.adScene, aVar.qZ());
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.MX.adScene);
            adBitResultData.parseJson(jSONObject);
            List<String> a2 = a(adBitResultData);
            if (a2.isEmpty()) {
                com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.awK.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.awK.msg : adBitResultData.testErrorMsg, false);
            } else {
                a(a2, adBitResultData, aVar);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awJ;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, false);
            com.kwad.sdk.core.e.c.printStackTraceOnly(e);
        }
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate a2;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (a2 = a(adBitResultData, j)) != null) {
                    a2.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    private static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.request.model.a aVar) {
        new l<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* renamed from: Q, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.b createRequest() {
                return new com.kwad.components.ad.a.b(adBitResultData.adxId, list);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(com.kwad.components.core.request.model.a.this.MX.adScene);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new o<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            private void b(int i, String str) {
                com.kwad.components.core.request.model.a.a(aVar, i, str, false);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(c.a(AdBitResultData.this, adBitResultData2));
                adBitResultData2.setAdSource("server_bid_two");
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i = aVar.MX.adScene.adStyle;
                if (i != 10000 && i != e.dM(adTemplate)) {
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.awO;
                    com.kwad.components.core.request.model.a.a(aVar2, eVar.errorCode, eVar.msg, false);
                    return;
                }
                com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                b(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate a2;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (a2 = a(adBitResultData2, j)) != null) {
                    a2.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(a2);
                }
            }
        }
        return arrayList;
    }

    private static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    @Nullable
    private static AdTemplate a(AdBitResultData adBitResultData, long j) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j == e.ec(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }
}
