package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: classes8.dex */
public class BaiduNativeExpressAd extends MediationNativeAd {

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f10442Oo;

    /* renamed from: XO, reason: collision with root package name */
    public ExpressResponse f10443XO;

    public BaiduNativeExpressAd(Context context, ExpressResponse expressResponse, MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge) {
        super(mediationAdLoaderImpl, bridge);
        this.f10442Oo = false;
        this.f10443XO = expressResponse;
        a();
    }

    private void a() {
        double d;
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        if (isClientBidding()) {
            try {
                d = Double.valueOf(this.f10443XO.getECPMLevel()).doubleValue();
            } catch (Exception e) {
                e.printStackTrace();
                d = 0.0d;
            }
            create.add(8016, Math.max(d, OOXIXo.f3760XO));
        } else if (isMultiBidding()) {
            create.add(8058, this.f10443XO.getECPMLevel());
        }
        create.add(8055, BaiduAdapterUtil.isDownloadAd(this.f10443XO));
        create.add(8059, BaiduAdapterUtil.getinteractionType(this.f10443XO.getAdActionType()));
        create.add(8033, true);
        notifyNativeValue(create.build());
        this.f10443XO.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeExpressAd.1
            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdClick() {
                BaiduNativeExpressAd.this.notifyOnClickAd();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdExposed() {
                BaiduNativeExpressAd.this.notifyOnShowAd();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderFail(View view, String str, int i) {
                BaiduNativeExpressAd.this.notifyRenderFail(view, i, str);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderSuccess(View view, float f, float f2) {
                BaiduNativeExpressAd.this.notifyRenderSuccess(f, f2);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private String oIX0oI() {
        try {
            ExpressResponse expressResponse = this.f10443XO;
            if (expressResponse != null) {
                return (String) expressResponse.getAdDataForKey("request_id");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8121) {
            return (T) isReadyStatus();
        }
        if (i == 6083) {
            ExpressResponse expressResponse = this.f10443XO;
            if (expressResponse != null) {
                expressResponse.render();
            } else {
                notifyRenderFail(null, 80003, "物料错误");
            }
        } else {
            if (i == 8135) {
                return (T) Boolean.TRUE;
            }
            if (i == 6081) {
                ExpressResponse expressResponse2 = this.f10443XO;
                if (expressResponse2 != null) {
                    return (T) expressResponse2.getExpressAdView();
                }
            } else if (i == 8109) {
                this.f10442Oo = true;
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.f10442Oo);
                }
                if (i == 6085) {
                    this.f10443XO.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeExpressAd.2
                        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                        public void onDislikeItemClick(String str) {
                            BaiduNativeExpressAd.this.notifyDislikeClick("百度智能优选dislike接口无关闭原因", null);
                            BaiduNativeExpressAd.this.notifyDislikeSelect(0, "百度智能优选dislike接口无关闭原因");
                        }

                        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                        public void onDislikeWindowClose() {
                        }

                        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                        public void onDislikeWindowShow() {
                        }
                    });
                } else if (i == 8147) {
                    return (T) oIX0oI();
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        ExpressResponse expressResponse = this.f10443XO;
        return (expressResponse == null || !expressResponse.isAdAvailable()) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }
}
