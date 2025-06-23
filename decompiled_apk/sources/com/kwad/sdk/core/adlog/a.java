package com.kwad.sdk.core.adlog;

import XIXIX.OOXIXo;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ads.fz;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.t;
import com.qq.e.comm.pi.IBidding;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: classes11.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int aqf;

    @NonNull
    private final com.kwad.sdk.core.adlog.c.a aqg;
    private final AdTemplate mAdTemplate;

    @KsJson
    /* renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0845a extends com.kwad.sdk.core.response.a.a {
        public String aqi;
        public int aqj;
        public int aqk;
        public int aql;
        public int aqm;
        public JSONObject aqn;
        public int aqo;
        public int aqp;

        @Nullable
        public AdTrackLog aqq;
        public String templateId;
        public int aqh = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int showLiveStyle = -1;

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.f.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.zz()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.aqq = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.aqq);
            }
            return this.aqq;
        }

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.aqh;
            if (i != -1) {
                t.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                t.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                t.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                t.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.aqq;
            if (adTrackLog != null) {
                t.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.aqn;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject.putOpt(next, this.aqn.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public a(@NonNull com.kwad.sdk.core.adlog.c.a aVar) {
        this.aqg = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.aqf = aVar.apT;
    }

    private void BM() {
        JSONObject jSONObject = this.aqg.aqN;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        t.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    private void a(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        int i = aVar.arp;
        if (i >= 0) {
            putBody("adOrder", i);
        }
        int i2 = aVar.Lg;
        if (i2 >= 0) {
            putBody("adInterstitialSource", i2);
        }
        if (!TextUtils.isEmpty(aVar.aqS)) {
            putBody("adRenderArea", aVar.aqS);
        }
        putBody("adxResult", aVar.adxResult);
        int i3 = aVar.art;
        if (i3 != 0) {
            putBody("fingerSwipeType", i3);
        }
        int i4 = aVar.aru;
        if (i4 != 0) {
            putBody("fingerSwipeDistance", i4);
        }
        int i5 = aVar.arm;
        if (i5 != -1) {
            putBody("installStatus", i5);
        }
        C0845a c0845a = aVar.Li;
        if (c0845a != null) {
            putBody("clientExtData", c0845a.toJson().toString());
        }
        String str2 = aVar.arw;
        if (str2 != null) {
            putBody("clientPkFailAdInfo", str2);
        }
        int i6 = aVar.Lk;
        if (i6 != -1) {
            putBody("triggerType", i6);
        }
        int i7 = aVar.Lj;
        if (i7 != 0) {
            putBody("photoSizeStyle", i7);
        }
    }

    private void b(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            int i = aVar.kl;
            if (i != 0) {
                putBody("itemClickType", i);
            }
            if (!TextUtils.isEmpty(aVar.Lh)) {
                putBody("payload", aVar.Lh);
            }
            int i2 = aVar.are;
            if (i2 != 0) {
                putBody("adAggPageSource", i2);
            }
            int i3 = aVar.arp;
            if (i3 >= 0) {
                putBody("adOrder", i3);
            }
            int i4 = aVar.Lg;
            if (i4 >= 0) {
                putBody("adInterstitialSource", i4);
            }
            int i5 = aVar.Lk;
            if (i5 != -1) {
                putBody("triggerType", i5);
            }
            int i6 = aVar.arv;
            if (i6 != 0) {
                putBody("cardCloseType", i6);
            }
            putBody("adxResult", aVar.adxResult);
            double d = aVar.ko;
            if (d > OOXIXo.f3760XO) {
                putBody("splashShakeAcceleration", d);
            }
            if (!TextUtils.isEmpty(aVar.arq)) {
                putBody("splashInteractionRotateAngle", aVar.arq);
            }
            int i7 = aVar.art;
            if (i7 != 0) {
                putBody("fingerSwipeType", i7);
            }
            int i8 = aVar.aru;
            if (i8 != 0) {
                putBody("fingerSwipeDistance", i8);
            }
            long j = aVar.vA;
            if (j > 0) {
                putBody("playedDuration", j);
            }
            int i9 = aVar.aro;
            if (i9 > 0) {
                putBody("playedRate", i9);
            }
            String str2 = aVar.arw;
            if (str2 != null) {
                putBody("clientPkFailAdInfo", str2);
            }
            int i10 = aVar.aqW;
            if (i10 != -1) {
                putBody("retainCodeType", i10);
            }
            C0845a c0845a = aVar.Li;
            if (c0845a != null) {
                putBody("clientExtData", c0845a.toJson().toString());
            }
            int i11 = aVar.Lj;
            if (i11 != 0) {
                putBody("photoSizeStyle", i11);
            }
        }
    }

    private void c(String str, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            int i = aVar.aqQ;
            if (i != 0) {
                putBody("itemCloseType", i);
            }
            int i2 = aVar.aqO;
            if (i2 > 0) {
                putBody("photoPlaySecond", i2);
            }
            int i3 = aVar.aqP;
            if (i3 != 0) {
                putBody("awardReceiveStage", i3);
            }
            int i4 = aVar.aqR;
            if (i4 != 0) {
                putBody("elementType", i4);
            }
            if (!TextUtils.isEmpty(aVar.Lh)) {
                putBody("payload", aVar.Lh);
            }
            C0845a c0845a = aVar.Li;
            if (c0845a != null) {
                putBody("clientExtData", c0845a.toJson().toString());
            }
            int i5 = aVar.aqX;
            if (i5 > 0) {
                putBody("deeplinkType", i5);
            }
            if (!TextUtils.isEmpty(aVar.aqY)) {
                putBody("deeplinkAppName", aVar.aqY);
            }
            int i6 = aVar.aqZ;
            if (i6 != 0) {
                putBody("deeplinkFailedReason", i6);
            }
            int i7 = aVar.downloadSource;
            if (i7 > 0) {
                putBody(fz.I, i7);
            }
            int i8 = aVar.arv;
            if (i8 != 0) {
                putBody("cardCloseType", i8);
            }
            int i9 = aVar.ara;
            if (i9 > 0) {
                putBody("isPackageChanged", i9);
            }
            putBody("installedFrom", aVar.arb);
            putBody("isChangedEndcard", aVar.ard);
            int i10 = aVar.are;
            if (i10 != 0) {
                putBody("adAggPageSource", i10);
            }
            String str2 = aVar.arc;
            if (str2 != null) {
                putBody("downloadFailedReason", str2);
            }
            if (!bh.isNullString(aVar.arg)) {
                putBody("installedPackageName", aVar.arg);
            }
            if (!bh.isNullString(aVar.arf)) {
                putBody("serverPackageName", aVar.arf);
            }
            int i11 = aVar.ari;
            if (i11 > 0) {
                putBody("closeButtonClickTime", i11);
            }
            int i12 = aVar.arh;
            if (i12 > 0) {
                putBody("closeButtonImpressionTime", i12);
            }
            int i13 = aVar.downloadStatus;
            if (i13 >= 0) {
                putBody("downloadStatus", i13);
            }
            long j = aVar.arj;
            if (j > 0) {
                putBody("landingPageLoadedDuration", j);
            }
            long j2 = aVar.LJ;
            if (j2 > 0) {
                putBody("leaveTime", j2);
            }
            long j3 = aVar.ark;
            if (j3 > 0) {
                putBody("adItemClickBackDuration", j3);
            }
            int i14 = aVar.aqW;
            if (i14 != -1) {
                putBody("retainCodeType", i14);
            }
            long j4 = aVar.aqT;
            if (j4 > -1) {
                putBody(IBidding.HIGHEST_LOSS_PRICE, j4);
            }
            int i15 = aVar.aqU;
            if (i15 >= 0) {
                putBody("impFailReason", i15);
            }
            long j5 = aVar.aqV;
            if (j5 > -1) {
                putBody("winEcpm", j5);
            }
            int i16 = aVar.adnType;
            if (i16 > 0) {
                putBody("adnType", i16);
            }
            if (!TextUtils.isEmpty(aVar.adnName)) {
                putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
            }
            putBody("downloadCardType", aVar.arn);
            putBody("landingPageType", aVar.OP);
            int i17 = aVar.Lg;
            if (i17 >= 0) {
                putBody("adInterstitialSource", i17);
            }
            int i18 = aVar.arr;
            if (i18 > 0) {
                putBody("downloadInstallType", i18);
            }
            int i19 = aVar.art;
            if (i19 != 0) {
                putBody("fingerSwipeType", i19);
            }
            int i20 = aVar.aru;
            if (i20 != 0) {
                putBody("fingerSwipeDistance", i20);
            }
            int i21 = aVar.ars;
            if (i21 > 0) {
                putBody("businessSceneType", i21);
            }
            long j6 = aVar.vA;
            if (j6 > 0) {
                putBody("playedDuration", j6);
            }
            int i22 = aVar.aro;
            if (i22 > 0) {
                putBody("playedRate", i22);
            }
            int i23 = aVar.arl;
            if (i23 != -1) {
                putBody("appStorePageType", i23);
            }
            int i24 = aVar.Lk;
            if (i24 != -1) {
                putBody("triggerType", i24);
            }
            int i25 = aVar.Lj;
            if (i25 != 0) {
                putBody("photoSizeStyle", i25);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String replaceFirst;
        String replaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo dS = e.dS(this.mAdTemplate);
        int i = this.aqf;
        if (i == 1) {
            String str = dS.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).zo()) {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.b.a.aQ(e.dS(this.mAdTemplate))));
            } else {
                replaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            replaceFirst = replaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(replaceFirst, this.aqg);
            a(replaceFirst, this.mAdTemplate, this.aqg);
        } else if (i == 2) {
            replaceFirst = ac.am(context, ac.a(dS.adBaseInfo.clickUrl, this.aqg.kn)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(replaceFirst, this.aqg);
            a(replaceFirst, this.mAdTemplate, this.aqg);
        } else {
            replaceFirst = dS.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(i)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(replaceFirst, this.aqg);
        }
        BM();
        return replaceFirst;
    }

    private void a(String str, AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        int i = adTemplate.mInitVoiceStatus;
        if (i != 0) {
            putBody("initVoiceStatus", i);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        int i2 = aVar.are;
        if (i2 != 0) {
            putBody("adAggPageSource", i2);
        }
        if (TextUtils.isEmpty(aVar.Lh)) {
            return;
        }
        putBody("payload", aVar.Lh);
    }
}
