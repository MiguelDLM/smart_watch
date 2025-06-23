package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;

/* loaded from: classes8.dex */
public class BaiduFullVideoLoader extends MediationAdLoaderImpl {

    /* loaded from: classes8.dex */
    public class BaiduFullVideoAd extends MediationBaseAdBridge implements FullScreenVideoAd.FullScreenVideoAdListener {

        /* renamed from: XO, reason: collision with root package name */
        public FullScreenVideoAd f10426XO;

        public BaiduFullVideoAd(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8113) {
                MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader showAd");
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
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f10426XO == null;
        }

        @JProtect
        public void oIX0oI(Context context) {
            this.f10426XO = new FullScreenVideoAd(context, BaiduFullVideoLoader.this.getAdnId(), this);
            if (getSlotValueSet() != null) {
                String baiduAppSid = getSlotValueSet().getBaiduAppSid();
                if (!TextUtils.isEmpty(baiduAppSid)) {
                    this.f10426XO.setAppSid(baiduAppSid);
                }
            }
            this.f10426XO.load();
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClick() {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader onAdClick ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClose(float f) {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader onAdClose ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1014, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdFailed(String str) {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader onAdFailed s:" + str);
            BaiduFullVideoLoader.this.notifyAdFailed(80001, str);
        }

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdLoaded() {
            double d;
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader onAdLoaded ");
            if (this.f10426XO != null) {
                if (BaiduFullVideoLoader.this.isClientBidding()) {
                    try {
                        d = Double.valueOf(this.f10426XO.getECPMLevel()).doubleValue();
                    } catch (Exception unused) {
                        d = OOXIXo.f3760XO;
                    }
                    setCpm(d);
                } else if (BaiduFullVideoLoader.this.isMultiBidding()) {
                    setLevelTag(this.f10426XO.getECPMLevel());
                }
            }
            BaiduFullVideoLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdShow() {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader onAdShow ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdSkip(float f) {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader onAdSkip ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1037, null, Void.class);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onVideoDownloadSuccess() {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader onVideoDownloadSuccess ");
            BaiduFullVideoLoader.this.notifyAdCache(this.mGMAd, -1, "");
        }

        @Override // com.baidu.mobads.sdk.api.FullScreenVideoAd.FullScreenVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void playCompletion() {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader playCompletion ");
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1026, null, Void.class);
            }
        }

        @JProtect
        public void showAd(Activity activity) {
            FullScreenVideoAd fullScreenVideoAd = this.f10426XO;
            if (fullScreenVideoAd != null) {
                fullScreenVideoAd.show();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            MediationApiLog.i("TTMediationSDK", "BaiduFullVideoLoader realLoader adnId:" + getAdnId());
            new BaiduFullVideoAd(mediationAdSlotValueSet, getGMBridge()).oIX0oI(context.getApplicationContext());
        }
    }
}
