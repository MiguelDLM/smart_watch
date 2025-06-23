package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.baidu.mapapi.UIMsg;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import java.util.Map;

/* loaded from: classes8.dex */
public class BaiduRewardLoader extends BaiduBaseLoader {

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f10452Oo;

    /* renamed from: XO, reason: collision with root package name */
    public MediationAdSlotValueSet f10453XO;

    /* loaded from: classes8.dex */
    public class BaiduRewardVideoAd extends MediationBaseAdBridge implements RewardVideoAd.RewardVideoAdListener {

        /* renamed from: XO, reason: collision with root package name */
        public RewardVideoAd f10455XO;

        public BaiduRewardVideoAd() {
            super(BaiduRewardLoader.this.f10453XO, BaiduRewardLoader.this.f10452Oo);
        }

        private String oIX0oI() {
            try {
                RewardVideoAd rewardVideoAd = this.f10455XO;
                if (rewardVideoAd != null) {
                    return (String) rewardVideoAd.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @JProtect
        public void II0xO0(Context context) {
            RewardVideoAd rewardVideoAd = new RewardVideoAd(context, BaiduRewardLoader.this.getAdnId(), this, BaiduRewardLoader.this.f10453XO.isUseSurfaceView());
            this.f10455XO = rewardVideoAd;
            rewardVideoAd.setDownloadAppConfirmPolicy(BaiduRewardLoader.this.f10453XO.getBaiduDownloadAppConfirmPolicy());
            this.f10455XO.setShowDialogOnSkip(BaiduRewardLoader.this.f10453XO.getBaiduShowDialogOnSkip());
            RequestParameters build = new RequestParameters.Builder().build();
            BaiduRewardLoader baiduRewardLoader = BaiduRewardLoader.this;
            baiduRewardLoader.setBiddingResult(baiduRewardLoader.getAdnId(), BaiduRewardLoader.this.isClientBidding(), build);
            this.f10455XO.setRequestParameters(build);
            String baiduAppSid = BaiduRewardLoader.this.f10453XO.getBaiduAppSid();
            if (!TextUtils.isEmpty(baiduAppSid)) {
                this.f10455XO.setAppSid(baiduAppSid);
            }
            String userId = BaiduRewardLoader.this.f10453XO.getUserId();
            if (userId != null) {
                this.f10455XO.setUserId(userId);
            }
            Map<String, Object> extraObject = BaiduRewardLoader.this.f10453XO.getExtraObject();
            if (extraObject != null && extraObject.get("baidu") != null) {
                this.f10455XO.setExtraInfo(String.valueOf(extraObject.get("baidu")));
            }
            this.f10455XO.load();
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8113) {
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
            return this.f10455XO == null;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            RewardVideoAd rewardVideoAd = this.f10455XO;
            return (rewardVideoAd == null || !rewardVideoAd.isReady()) ? MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClick() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(8115, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClose(float f) {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(8116, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdFailed(String str) {
            BaiduRewardLoader.this.notifyAdFailed(80001, str);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdLoaded() {
            MediationApiLog.i("-------baidu_onAdLoaded:" + this.f10455XO + "  isClientBidding:" + BaiduRewardLoader.this.isClientBidding());
            if (this.f10455XO != null) {
                if (BaiduRewardLoader.this.isClientBidding()) {
                    double d = OOXIXo.f3760XO;
                    try {
                        MediationApiLog.i("-------baidu_ getECPMLevel:" + this.f10455XO.getECPMLevel());
                        if (!TextUtils.isEmpty(this.f10455XO.getECPMLevel())) {
                            d = Double.valueOf(this.f10455XO.getECPMLevel()).doubleValue();
                        }
                    } catch (Exception e) {
                        MediationApiLog.i("-------baidu_ getECPMLevel e:" + e.toString());
                        e.printStackTrace();
                    }
                    setCpm(d);
                } else if (BaiduRewardLoader.this.isMultiBidding()) {
                    setLevelTag(this.f10455XO.getECPMLevel());
                }
            }
            BaiduRewardLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdShow() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(8230, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdSkip(float f) {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(8119, null, Void.class);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            this.f10455XO = null;
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        @JProtect
        public void onRewardVerify(boolean z) {
            if (this.mGMAd != null) {
                MediationValueSetBuilder create = MediationValueSetBuilder.create();
                create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYSOPEN, true);
                create.add(UIMsg.m_AppUI.MSG_SUG_TEXTCHAGNE, BaiduRewardLoader.this.f10453XO.getRewardAmount());
                create.add(8019, BaiduRewardLoader.this.f10453XO.getRewardName());
                this.mGMAd.call(8231, create.build(), Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onVideoDownloadSuccess() {
            BaiduRewardLoader.this.notifyAdCache(this.mGMAd, -1, "");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void playCompletion() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(8118, null, Void.class);
            }
        }

        @JProtect
        public void showAd(Activity activity) {
            RewardVideoAd rewardVideoAd = this.f10455XO;
            if (rewardVideoAd != null) {
                rewardVideoAd.show();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context == null || mediationAdSlotValueSet == null) {
            notifyAdFailed(80001, "context is null or adSlotValueSet is null");
            return;
        }
        this.f10453XO = mediationAdSlotValueSet;
        this.f10452Oo = getGMBridge();
        new BaiduRewardVideoAd().II0xO0(context.getApplicationContext());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
