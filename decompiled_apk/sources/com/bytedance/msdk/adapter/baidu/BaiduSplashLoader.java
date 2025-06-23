package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: classes8.dex */
public class BaiduSplashLoader extends BaiduBaseLoader {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public BaiduSplashAd f10456IXxxXO;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public SplashAd f10458Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public int f10459XO = 3000;

    /* renamed from: Oo, reason: collision with root package name */
    public boolean f10457Oo = true;

    /* loaded from: classes8.dex */
    public class BaiduSplashAd extends MediationBaseAdBridge implements SplashInteractionListener {

        /* renamed from: Oo, reason: collision with root package name */
        public FrameLayout f10461Oo;

        /* renamed from: XO, reason: collision with root package name */
        public SplashAd f10462XO;

        public BaiduSplashAd(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
        }

        private String oIX0oI() {
            try {
                SplashAd splashAd = this.f10462XO;
                if (splashAd != null) {
                    return (String) splashAd.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8139) {
                return (T) String.valueOf(BaiduSplashLoader.this.getBiddingToken((Context) valueSet.objectValue(8009, Context.class), valueSet.stringValue(8007), valueSet.objectValue(8044, Object.class)));
            }
            if (i == 6152) {
                MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader showSplashAd ");
                ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(20060, ViewGroup.class);
                if (viewGroup != null) {
                    showSplashAd(viewGroup);
                }
            } else if (i != 6154 && i != 6153 && i != 6161) {
                if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8120) {
                        return (T) Boolean.valueOf(hasDestroyed());
                    }
                    if (i == 8121) {
                        return (T) isReadyStatus();
                    }
                    if (i == 8147) {
                        return (T) oIX0oI();
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f10462XO == null;
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        @JProtect
        public void onADLoaded() {
            double d;
            StringBuilder sb;
            String str;
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onADLoaded ");
            if (this.f10462XO != null) {
                if (BaiduSplashLoader.this.isClientBidding()) {
                    try {
                        d = Double.valueOf(this.f10462XO.getECPMLevel()).doubleValue();
                    } catch (Exception unused) {
                        d = OOXIXo.f3760XO;
                    }
                    setCpm(d);
                    sb = new StringBuilder();
                    str = "BaiduSplashLoader Baidu_cientBidding splash 返回的 cpm价格：";
                } else if (BaiduSplashLoader.this.isMultiBidding()) {
                    setLevelTag(this.f10462XO.getECPMLevel());
                    sb = new StringBuilder();
                    str = "BaiduSplashLoader Baidu_多阶底价 splash 返回的 价格标签：";
                }
                sb.append(str);
                sb.append(this.f10462XO.getECPMLevel());
                MediationApiLog.i("TTMediationSDK", sb.toString());
            }
            BaiduSplashLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheFailed() {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onAdCacheFailed ");
            BaiduSplashLoader.this.f10457Oo = false;
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdCacheSuccess() {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onAdCacheSuccess ");
            BaiduSplashLoader.this.f10457Oo = true;
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @JProtect
        public void onAdClick() {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onAdClick ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @JProtect
        public void onAdDismissed() {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onAdDismissed ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1011, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdExposed() {
        }

        @Override // com.baidu.mobads.sdk.api.SplashAdListener
        @JProtect
        public void onAdFailed(String str) {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onAdFailed s:" + str);
            BaiduSplashLoader.this.notifyAdFailed(80001, str);
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @JProtect
        public void onAdPresent() {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onAdPresent ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        public void onAdSkip() {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onDestroy ");
            SplashAd splashAd = this.f10462XO;
            if (splashAd != null) {
                splashAd.destroy();
                this.f10462XO = null;
            }
            FrameLayout frameLayout = this.f10461Oo;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
        }

        @Override // com.baidu.mobads.sdk.api.SplashInteractionListener
        @JProtect
        public void onLpClosed() {
            MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader onLpClosed ");
        }

        public void setSplashAd(SplashAd splashAd) {
            this.f10462XO = splashAd;
        }

        @JProtect
        public void showSplashAd(ViewGroup viewGroup) {
            if (this.f10462XO == null || viewGroup == null) {
                return;
            }
            this.f10461Oo = new FrameLayout(viewGroup.getContext());
            viewGroup.removeAllViews();
            this.f10461Oo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f10461Oo.setVisibility(0);
            viewGroup.addView(this.f10461Oo);
            this.f10462XO.show(this.f10461Oo);
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public final void II0xO0(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, String str, RequestParameters requestParameters) {
        if (context != null) {
            if (this.f10456IXxxXO == null) {
                this.f10456IXxxXO = new BaiduSplashAd(mediationAdSlotValueSet, getGMBridge());
            }
            setBiddingResult(getAdnId(), isClientBidding(), requestParameters);
            BaiduSplashAd baiduSplashAd = this.f10456IXxxXO;
            if (baiduSplashAd != null && baiduSplashAd.getSlotValueSet() == null && mediationAdSlotValueSet != null) {
                this.f10456IXxxXO.setSlotValueSet(mediationAdSlotValueSet);
            }
            if (this.f10458Oxx0xo == null) {
                this.f10458Oxx0xo = new SplashAd(context.getApplicationContext(), str, requestParameters, this.f10456IXxxXO);
            }
            this.f10456IXxxXO.setSplashAd(this.f10458Oxx0xo);
        }
    }

    public String getBiddingToken(Context context, String str, Object obj) {
        if (obj instanceof RequestParameters) {
            II0xO0(context, null, str, (RequestParameters) obj);
            return this.f10458Oxx0xo.getBiddingToken();
        }
        MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader getBiddingToken RequestParameters is null");
        return null;
    }

    public final RequestParameters oIX0oI(MediationAdSlotValueSet mediationAdSlotValueSet) {
        RequestParameters requestParameters = BaiduAdapterUtil.getRequestParameters(mediationAdSlotValueSet);
        return requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        MediationApiLog.i("TTMediationSDK", "BaiduSplashLoader realLoader adnId:" + getAdnId());
        this.f10459XO = getLoadTimeOut();
        II0xO0(context, mediationAdSlotValueSet, getAdnId(), oIX0oI(mediationAdSlotValueSet));
        if (mediationAdSlotValueSet != null) {
            String baiduAppSid = mediationAdSlotValueSet.getBaiduAppSid();
            if (!TextUtils.isEmpty(baiduAppSid)) {
                this.f10458Oxx0xo.setAppSid(baiduAppSid);
            }
        }
        if (TextUtils.isEmpty(getAdm())) {
            this.f10458Oxx0xo.load();
        } else {
            this.f10458Oxx0xo.loadBiddingAd(getAdm());
        }
    }
}
