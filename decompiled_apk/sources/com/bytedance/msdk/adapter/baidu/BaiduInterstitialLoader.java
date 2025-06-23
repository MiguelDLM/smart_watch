package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: classes8.dex */
public class BaiduInterstitialLoader extends MediationAdLoaderImpl {

    /* loaded from: classes8.dex */
    public class BaiduExpressInterstitialAd extends MediationBaseAdBridge implements ExpressInterstitialListener {

        /* renamed from: XO, reason: collision with root package name */
        public ExpressInterstitialAd f10428XO;

        public BaiduExpressInterstitialAd(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
        }

        private String oIX0oI() {
            try {
                ExpressInterstitialAd expressInterstitialAd = this.f10428XO;
                if (expressInterstitialAd != null) {
                    return (String) expressInterstitialAd.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @JProtect
        public void II0xO0(Context context) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd load adnId:" + BaiduInterstitialLoader.this.getAdnId());
            ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(context.getApplicationContext(), BaiduInterstitialLoader.this.getAdnId());
            this.f10428XO = expressInterstitialAd;
            expressInterstitialAd.setLoadListener(this);
            this.f10428XO.load();
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8113) {
                MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd showAd");
                Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                if (activity != null) {
                    showAd(activity);
                }
            } else if (i == 8109) {
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
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f10428XO == null;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onADExposed() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onADExposed  ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onADExposureFailed() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onADExposureFailed  ");
            if (this.mGMAd != null) {
                MediationValueSetBuilder create = MediationValueSetBuilder.create();
                create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, 0);
                create.add(8015, "广告展示失败");
                this.mGMAd.call(1017, create.build(), Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onADLoaded() {
            double d;
            StringBuilder sb;
            String str;
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onADLoaded ");
            if (this.f10428XO != null) {
                if (BaiduInterstitialLoader.this.isClientBidding()) {
                    try {
                        d = Double.valueOf(this.f10428XO.getECPMLevel()).doubleValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        d = OOXIXo.f3760XO;
                    }
                    setCpm(d);
                    sb = new StringBuilder();
                    str = "BaiduInterstitialLoader Baidu_cientBidding full 返回的 cpm价格：";
                } else if (BaiduInterstitialLoader.this.isMultiBidding()) {
                    setLevelTag(this.f10428XO.getECPMLevel());
                    sb = new StringBuilder();
                    str = "BaiduInterstitialLoader Baidu_多阶底价 full 返回的 价格标签：";
                }
                sb.append(str);
                sb.append(this.f10428XO.getECPMLevel());
                MediationApiLog.i("TTMediationSDK", sb.toString());
            }
            BaiduInterstitialLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdCacheFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdCacheSuccess() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdCacheSuccess ");
            BaiduInterstitialLoader.this.notifyAdCache(this.mGMAd, -1, "");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdClick() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdClick ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdClose() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdClose ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1014, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdFailed(int i, String str) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdFailed errCode:" + i + "  s:" + str);
            BaiduInterstitialLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            if (this.f10428XO != null) {
                this.f10428XO = null;
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onLpClosed() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onLpClosed ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1016, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onNoAd(int i, String str) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onNoAd  errCode:" + i + "  s:" + str);
            BaiduInterstitialLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        @Deprecated
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        @Deprecated
        public void onVideoDownloadSuccess() {
        }

        @JProtect
        public void showAd(Activity activity) {
            ExpressInterstitialAd expressInterstitialAd = this.f10428XO;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.show(activity);
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class BaiduInterstitialAd extends MediationBaseAdBridge implements InterstitialAdListener {

        /* renamed from: XO, reason: collision with root package name */
        public InterstitialAd f10430XO;

        public BaiduInterstitialAd(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8113) {
                MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader showAd ");
                showAd(null);
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(hasDestroyed());
                }
                if (i == 8121) {
                    return (T) isReadyStatus();
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f10430XO == null;
        }

        @JProtect
        public void oIX0oI(Context context) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduInterstitialAd loadAd adnId:" + BaiduInterstitialLoader.this.getAdnId());
            this.f10430XO = new InterstitialAd(context, BaiduInterstitialLoader.this.getAdnId());
            if (getSlotValueSet() != null) {
                String baiduAppSid = getSlotValueSet().getBaiduAppSid();
                if (!TextUtils.isEmpty(baiduAppSid)) {
                    this.f10430XO.setAppSid(baiduAppSid);
                }
            }
            this.f10430XO.setListener(this);
            this.f10430XO.loadAd();
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdClick(InterstitialAd interstitialAd) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader onAdClick ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdDismissed() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader onAdDismissed ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1014, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdFailed(String str) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader onAdFailed s:" + str);
            BaiduInterstitialLoader.this.notifyAdFailed(80001, str);
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdPresent() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader onAdPresent ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
        @JProtect
        public void onAdReady() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader onAdReady ");
            BaiduInterstitialLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            InterstitialAd interstitialAd = this.f10430XO;
            if (interstitialAd != null) {
                interstitialAd.destroy();
                this.f10430XO = null;
            }
        }

        @JProtect
        public void showAd(Activity activity) {
            InterstitialAd interstitialAd = this.f10430XO;
            if (interstitialAd != null) {
                interstitialAd.showAd();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    @JProtect
    private void II0xO0(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        new BaiduExpressInterstitialAd(mediationAdSlotValueSet, getGMBridge()).II0xO0(context);
    }

    @JProtect
    private void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        new BaiduInterstitialAd(mediationAdSlotValueSet, getGMBridge()).oIX0oI(context);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader realLoader adnId:" + getAdnId());
            int originType = getOriginType();
            if (originType == 1) {
                II0xO0(context.getApplicationContext(), mediationAdSlotValueSet);
                return;
            }
            if (originType == 2) {
                oIX0oI(context.getApplicationContext(), mediationAdSlotValueSet);
            } else if (originType == 3) {
                notifyAdFailed(80001, "类型有误");
            } else {
                oIX0oI(context.getApplicationContext(), mediationAdSlotValueSet);
            }
        }
    }
}
