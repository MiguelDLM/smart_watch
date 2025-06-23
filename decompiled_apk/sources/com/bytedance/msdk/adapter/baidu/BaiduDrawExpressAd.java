package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.content.Context;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes8.dex */
public class BaiduDrawExpressAd extends MediationNativeAd {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f10413IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public FeedPortraitVideoView f10414Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public MediationAdSlotValueSet f10415Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public XAdNativeResponse f10416XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public WeakReference<Context> f10417oI0IIXIo;

    public BaiduDrawExpressAd(Context context, XAdNativeResponse xAdNativeResponse, MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge, MediationAdSlotValueSet mediationAdSlotValueSet) {
        super(mediationAdLoaderImpl, bridge);
        this.f10413IXxxXO = false;
        this.f10417oI0IIXIo = new WeakReference<>(context);
        this.f10416XO = xAdNativeResponse;
        this.f10415Oxx0xo = mediationAdSlotValueSet;
        II0xO0(context, xAdNativeResponse);
    }

    private String I0Io() {
        try {
            XAdNativeResponse xAdNativeResponse = this.f10416XO;
            if (xAdNativeResponse != null) {
                return (String) xAdNativeResponse.getAdDataForKey("request_id");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a() {
        if (this.f10416XO == null) {
            notifyRenderFail(this.f10414Oo, 80003, "物料错误");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FeedPortraitVideoView feedPortraitVideoView = this.f10414Oo;
        if (feedPortraitVideoView != null) {
            arrayList.add(feedPortraitVideoView);
        }
        this.f10416XO.registerViewForInteraction(this.f10414Oo, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.3
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BaiduDrawExpressAd.this.notifyOnShowAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
        this.f10414Oo.setAdData(this.f10416XO);
        this.f10414Oo.play();
        notifyRenderSuccess(this.f10415Oxx0xo.getWidth(), this.f10415Oxx0xo.getHeight());
    }

    public final void II0xO0(Context context, XAdNativeResponse xAdNativeResponse) {
        double d;
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        if (isClientBidding()) {
            try {
                d = Double.valueOf(xAdNativeResponse.getECPMLevel()).doubleValue();
            } catch (Exception unused) {
                d = 0.0d;
            }
            create.add(8016, Math.max(d, OOXIXo.f3760XO));
        } else if (isMultiBidding()) {
            create.add(8058, xAdNativeResponse.getECPMLevel());
        }
        create.add(8033, true);
        create.add(8059, BaiduAdapterUtil.getinteractionType(xAdNativeResponse.getAdActionType()));
        notifyNativeValue(create.build());
        FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(context);
        this.f10414Oo = feedPortraitVideoView;
        feedPortraitVideoView.setVideoMute(this.f10415Oxx0xo.isMuted());
        this.f10416XO.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.1
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
            public void adDownloadWindowClose() {
                BaiduDrawExpressAd.this.f10414Oo.resume();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
            public void adDownloadWindowShow() {
                BaiduDrawExpressAd.this.f10414Oo.pause();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADFunctionClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPermissionClose() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPermissionShow() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPrivacyClick() {
            }
        });
        this.f10414Oo.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.2
            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void pauseBtnClick() {
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playCompletion() {
                BaiduDrawExpressAd.this.notifyOnVideoComplete();
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playError() {
                BaiduDrawExpressAd.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "error is null");
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playPause() {
                BaiduDrawExpressAd.this.notifyOnVideoPause();
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playRenderingStart() {
                BaiduDrawExpressAd.this.notifyOnVideoStart();
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playResume() {
                BaiduDrawExpressAd.this.notifyOnVideoResume();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 6083) {
            a();
        } else {
            if (i == 6081) {
                return (T) this.f10414Oo;
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(this.f10413IXxxXO);
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8109) {
                this.f10413IXxxXO = true;
            } else if (i == 8147) {
                return (T) I0Io();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        WeakReference<Context> weakReference = this.f10417oI0IIXIo;
        Context context = weakReference != null ? weakReference.get() : null;
        XAdNativeResponse xAdNativeResponse = this.f10416XO;
        return (xAdNativeResponse == null || !xAdNativeResponse.isAdAvailable(context)) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }
}
