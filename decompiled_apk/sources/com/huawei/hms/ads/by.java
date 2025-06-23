package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.ads.jb;
import com.huawei.hms.ads.nativead.DislikeAdListener;
import com.huawei.hms.ads.nativead.DislikeAdReason;
import com.huawei.hms.ads.nativead.IUnityNativeAdPresenter;
import com.huawei.hms.ads.nativead.MediaContent;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.nativead.NativeAdMonitor;
import com.huawei.hms.ads.nativead.NativeView;
import com.huawei.hms.ads.nativead.c;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.utils.NativeListener;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes10.dex */
public class by extends NativeAd implements IUnityNativeAdPresenter, PPSNativeView.b, PPSNativeView.e {
    private VideoOperator D;
    private NativeView I;
    private DislikeAdListener L;
    private Image S;
    private com.huawei.openalliance.ad.inter.data.l V;
    private NativeAdMonitor Z;

    /* renamed from: a, reason: collision with root package name */
    private boolean f17256a;
    private AdListener b;
    private NativeListener c;
    private boolean d;
    private String e;
    private Context f;
    private AdFeedbackListener g;
    private AdCloseBtnClickListener h;
    private List<DislikeAdReason> B = new ArrayList();
    private List<Image> C = new ArrayList();
    private DislikeAdListener i = new DislikeAdListener() { // from class: com.huawei.hms.ads.by.1
        @Override // com.huawei.hms.ads.nativead.DislikeAdListener
        public void onAdDisliked() {
            if (by.this.L != null) {
                by.this.L.onAdDisliked();
            }
        }
    };
    private AdFeedbackListener j = new AdFeedbackListener() { // from class: com.huawei.hms.ads.by.2
        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdDisliked() {
            if (by.this.g != null) {
                by.this.g.onAdDisliked();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdFeedbackShowFailed() {
            if (by.this.g != null) {
                by.this.g.onAdFeedbackShowFailed();
            }
        }

        @Override // com.huawei.hms.ads.AdFeedbackListener
        public void onAdLiked() {
            if (by.this.g != null) {
                by.this.g.onAdLiked();
            }
        }
    };
    private AdCloseBtnClickListener k = new AdCloseBtnClickListener() { // from class: com.huawei.hms.ads.by.3
        @Override // com.huawei.hms.ads.AdCloseBtnClickListener
        public void onCloseBtnClick() {
            if (by.this.h != null) {
                by.this.h.onCloseBtnClick();
            }
            if (by.this.g instanceof AdFeedbackListenerV2) {
                ((AdFeedbackListenerV2) by.this.g).onCloseBtnClick();
            }
        }
    };

    public by(Context context, com.huawei.openalliance.ad.inter.data.g gVar) {
        this.f = context;
        if (gVar == null || !(gVar instanceof com.huawei.openalliance.ad.inter.data.l)) {
            return;
        }
        com.huawei.openalliance.ad.inter.data.l lVar = (com.huawei.openalliance.ad.inter.data.l) gVar;
        this.V = lVar;
        this.e = lVar.a();
    }

    private boolean C() {
        NativeAdConfiguration aq;
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || (aq = lVar.aq()) == null) {
            return false;
        }
        return aq.isReturnUrlsForImages();
    }

    private Context S() {
        NativeView nativeView = this.I;
        return nativeView != null ? nativeView.getContext() : this.f;
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void B() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdImpression();
        }
        NativeListener nativeListener = this.c;
        if (nativeListener != null) {
            nativeListener.onAdImpression();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void Z() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void destroy() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            lVar.ap();
        }
        this.I = null;
        this.Z = null;
        this.L = null;
        this.g = null;
        this.h = null;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void dislikeAd(DislikeAdReason dislikeAdReason) {
        if (isCustomDislikeThisAdEnabled()) {
            NativeView nativeView = this.I;
            if (nativeView != null) {
                if (dislikeAdReason == null) {
                    nativeView.F();
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(dislikeAdReason.getDescription())) {
                        arrayList.add(dislikeAdReason.getDescription());
                    }
                    this.I.Code(arrayList);
                }
            }
            NativeAdMonitor nativeAdMonitor = this.Z;
            if (nativeAdMonitor != null) {
                if (dislikeAdReason == null) {
                    nativeAdMonitor.Z();
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(dislikeAdReason.getDescription())) {
                    arrayList2.add(dislikeAdReason.getDescription());
                }
                this.Z.Code(arrayList2);
            }
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getAbilityDetailInfo() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.R();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getAdSign() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        return lVar == null ? "2" : lVar.b();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getAdSource() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.ak();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public List<AdvertiserInfo> getAdvertiserInfo() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.G();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public AppInfo getAppInfo() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return new AppInfo(lVar.y());
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public BiddingInfo getBiddingInfo() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.ae();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getCallToAction() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return com.huawei.hms.ads.utils.a.Code(this.f, lVar.y(), this.V.L());
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public NativeAd.ChoicesInfo getChoicesInfo() {
        return new a();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public int getCreativeType() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return -1;
        }
        return lVar.c();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getDescription() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.V();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public List<DislikeAdReason> getDislikeAdReasons() {
        if (this.V == null || !isCustomDislikeThisAdEnabled()) {
            return new ArrayList();
        }
        if (com.huawei.openalliance.ad.utils.ad.Code(this.B)) {
            this.B = new ArrayList();
            List<String> m = this.V.m();
            if (com.huawei.openalliance.ad.utils.ad.Code(m)) {
                return new ArrayList();
            }
            for (String str : m) {
                if (!TextUtils.isEmpty(str)) {
                    this.B.add(new bw(str));
                }
            }
        }
        return this.B;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getDspLogo() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.P();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getDspName() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.O();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Map<String, String> getExt() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.s();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Bundle getExtraBundle() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.ao();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getHwChannelId() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.T();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Image getIcon() {
        ImageInfo Z;
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        if (this.S == null && (Z = lVar.Z()) != null) {
            u uVar = new u(Z, C());
            this.S = uVar;
            uVar.Code(this.e);
        }
        return this.S;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public List<Image> getImages() {
        if (this.V == null) {
            return new ArrayList();
        }
        if (com.huawei.openalliance.ad.utils.ad.Code(this.C)) {
            this.C = new ArrayList();
            List<ImageInfo> B = this.V.B();
            if (com.huawei.openalliance.ad.utils.ad.Code(B)) {
                return new ArrayList();
            }
            boolean C = C();
            for (ImageInfo imageInfo : B) {
                if (imageInfo != null) {
                    u uVar = new u(imageInfo, C);
                    uVar.Code(this.e);
                    this.C.add(uVar);
                }
            }
        }
        return this.C;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public int getInteractionType() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return -1;
        }
        return lVar.l_();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getMarket() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.am();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public MediaContent getMediaContent() {
        VideoOperator videoOperator = getVideoOperator();
        if (videoOperator instanceof c) {
            return ((c) videoOperator).Code();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public int getMinEffectiveShowRatio() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.A()) {
            return 0;
        }
        return this.V.v();
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public long getMinEffectiveShowTime() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.A()) {
            return 0L;
        }
        return this.V.u();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getPrice() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.an();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public PromoteInfo getPromoteInfo() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.ad();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Double getRating() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.al();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getTitle() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.Code();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getTransparencyTplUrl() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        return lVar == null ? "" : lVar.Y();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getUniqueId() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return null;
        }
        return lVar.x();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public Video getVideo() {
        VideoInfo C;
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || (C = lVar.C()) == null) {
            return null;
        }
        return new w(C);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public VideoOperator getVideoOperator() {
        if (this.D == null) {
            this.D = new c(new bz(this));
        }
        return this.D;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public String getWhyThisAd() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        return lVar == null ? com.huawei.openalliance.ad.constant.x.ao : lVar.i();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void gotoWhyThisAdPage(Context context) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return;
        }
        lVar.Code(context);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean hasAdvertiserInfo() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return false;
        }
        return lVar.f_();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isAutoDownloadApp() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return false;
        }
        return lVar.p_();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isCustomClickAllowed() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        return lVar != null && lVar.A() && this.d;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isCustomDislikeThisAdEnabled() {
        return this.f17256a;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isShowAppElement() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return false;
        }
        return lVar.W();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean isTransparencyOpen() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return false;
        }
        return lVar.aa();
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void onAdClose(Context context, List<String> list) {
        com.huawei.openalliance.ad.inter.data.l lVar;
        if (context == null || (lVar = this.V) == null) {
            return;
        }
        lVar.Code(context, list);
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public boolean onUnityAdClick() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null && lVar.A()) {
            com.huawei.openalliance.ad.uriaction.p Code = com.huawei.openalliance.ad.uriaction.q.Code(this.f, this.V.n(), this.V.ar());
            if (Code.Code()) {
                new h(this.f, this.V).Code(Code.I(), com.huawei.openalliance.ad.utils.b.Code(this.I));
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdClose(List<String> list) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.A()) {
            return;
        }
        new h(this.f, this.V).V(list);
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdPhyShow(long j, int i) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.A()) {
            return;
        }
        new h(this.f, this.V).Code(j, i);
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdShow(Long l, Integer num, Integer num2) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.A()) {
            return;
        }
        new h(this.f, this.V).Code(new jb.a().Code(l).Code(num).V(num2).I(com.huawei.openalliance.ad.utils.b.Code(this.I)).Code(jp.Code(this.I)).Code());
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityAdShowStart() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.A()) {
            return;
        }
        new h(this.f, this.V).Code();
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void onUnityGoWhyShowThis() {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.A()) {
            return;
        }
        if (ck.Code(this.f).V()) {
            fb.I("NativeAdImpl", "china rom should not call gotoWhyThisAdPage method");
        } else {
            com.huawei.openalliance.ad.utils.w.Code(this.f, this.V.n());
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void recordClickEvent() {
        if (isCustomClickAllowed()) {
            new h(this.f, this.V).Code(com.huawei.openalliance.ad.utils.b.Code(this.I));
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean recordImpressionEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            return lVar.V(S(), bundle);
        }
        return false;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean recordShowStartEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return false;
        }
        return lVar.Code(S(), bundle);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void recordTouchEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            lVar.Code(bundle);
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setAdCloseBtnClickListener(AdCloseBtnClickListener adCloseBtnClickListener) {
        this.h = adCloseBtnClickListener;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setAdFeedbackListener(AdFeedbackListener adFeedbackListener) {
        this.g = adFeedbackListener;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setAllowCustomClick() {
        this.d = true;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setAutoDownloadApp(boolean z) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return;
        }
        lVar.Z(z);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setDislikeAdListener(DislikeAdListener dislikeAdListener) {
        this.L = dislikeAdListener;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setNativeListener(NativeListener nativeListener) {
        this.c = nativeListener;
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return;
        }
        lVar.Code(rewardVerifyConfig);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null) {
            return;
        }
        lVar.Code(videoConfiguration);
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void showAppDetailPage(Context context) {
        if (this.V == null) {
            return;
        }
        NativeView nativeView = this.I;
        if (nativeView == null || nativeView.getClickInfo() == null) {
            this.V.V(context);
        } else {
            fb.Code("NativeAdImpl", this.I.getClickInfo().toString());
            this.V.Code(context, this.I.getClickInfo());
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public void triggerClick(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar == null || !lVar.Z(S(), bundle)) {
            return;
        }
        V();
        I();
    }

    @Override // com.huawei.hms.ads.nativead.IUnityNativeAdPresenter
    public void updateContent() {
        String valueOf = String.valueOf(com.huawei.openalliance.ad.utils.w.Code());
        AdContentData n = this.V.n();
        if (n != null) {
            n.I(valueOf);
        }
    }

    public com.huawei.openalliance.ad.inter.data.l Code() {
        return this.V;
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void I() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdLeave();
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.e
    public void V() {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }

    @Override // com.huawei.hms.ads.nativead.NativeAd
    public boolean recordClickEvent(Bundle bundle) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            return lVar.I(S(), bundle);
        }
        return false;
    }

    @Override // com.huawei.openalliance.ad.views.PPSNativeView.b
    public void Code(View view) {
        AdListener adListener = this.b;
        if (adListener != null) {
            adListener.onAdClicked();
        }
        NativeListener nativeListener = this.c;
        if (nativeListener != null) {
            nativeListener.onAdClicked();
        }
    }

    public void Code(AdListener adListener) {
        this.b = adListener;
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        if (nativeAdConfiguration == null) {
            return;
        }
        com.huawei.openalliance.ad.inter.data.l lVar = this.V;
        if (lVar != null) {
            lVar.Code(nativeAdConfiguration);
        }
        Code(nativeAdConfiguration.Code());
    }

    public void Code(NativeAdMonitor nativeAdMonitor) {
        this.Z = nativeAdMonitor;
        if (nativeAdMonitor != null) {
            nativeAdMonitor.Code((PPSNativeView.e) this);
            this.Z.Code((PPSNativeView.b) this);
            this.Z.Code(this.i);
        }
    }

    public void Code(NativeView nativeView) {
        this.I = nativeView;
        if (nativeView != null) {
            nativeView.setOnNativeAdStatusTrackingListener(this);
            this.I.setOnNativeAdClickListener(this);
            this.I.setDislikeAdListener(this.i);
            this.I.setAdFeedbackListener(this.j);
            this.I.setAdCloseBtnClickListener(this.k);
        }
    }

    public void Code(boolean z) {
        this.f17256a = z;
    }
}
