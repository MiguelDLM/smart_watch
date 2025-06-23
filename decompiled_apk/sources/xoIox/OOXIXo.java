package xoIox;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.KsRewardLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class OOXIXo {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f34968II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final KsRewardLoader f34969oIX0oI;

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Context f34984Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f34985XO;

        public oIX0oI(MediationAdSlotValueSet mediationAdSlotValueSet, Context context) {
            this.f34985XO = mediationAdSlotValueSet;
            this.f34984Oo = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            OOXIXo.this.II0xO0(this.f34985XO);
            ooOOo0oXI.oxoX(getClass().getName(), this.f34984Oo.getApplicationContext());
        }
    }

    public OOXIXo(KsRewardLoader ksRewardLoader) {
        this.f34969oIX0oI = ksRewardLoader;
    }

    public final void II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            KsScene.Builder builder = new KsScene.Builder(Long.valueOf(mediationAdSlotValueSet.getADNId()).longValue());
            HashMap hashMap = new HashMap();
            String userId = mediationAdSlotValueSet.getUserId();
            if (userId != null) {
                hashMap.put("thirdUserId", userId);
            }
            Map<String, Object> extraObject = mediationAdSlotValueSet.getExtraObject();
            if (extraObject != null && extraObject.get(MediationConstant.ADN_KS) != null) {
                hashMap.put("extraData", String.valueOf(extraObject.get(MediationConstant.ADN_KS)));
            }
            if (hashMap.size() > 0) {
                builder.rewardCallbackExtraData(hashMap);
            }
            KsScene build = builder.build();
            KsRewardLoader ksRewardLoader = this.f34969oIX0oI;
            new II0xO0(ksRewardLoader, mediationAdSlotValueSet, ksRewardLoader.getGMBridge(), this.f34968II0xO0).oxoX(build);
        } catch (Exception unused) {
            this.f34969oIX0oI.notifyAdFailed(80001, "代码位不合法");
        }
    }

    public void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean Oxx0IOOO2 = x0XOIxOo.Oxx0IOOO(this.f34969oIX0oI, mediationAdSlotValueSet);
        this.f34968II0xO0 = Oxx0IOOO2;
        if (Oxx0IOOO2) {
            ooOOo0oXI.I0Io(new oIX0oI(mediationAdSlotValueSet, context));
        } else {
            II0xO0(mediationAdSlotValueSet);
        }
    }

    /* loaded from: classes.dex */
    public static class II0xO0 extends MediationBaseAdBridge {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public Bridge f34970IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public KsRewardLoader f34971Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public MediationAdSlotValueSet f34972Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public KsLoadManager.RewardVideoAdListener f34973OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public KsRewardVideoAd f34974XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public boolean f34975oI0IIXIo;

        /* loaded from: classes.dex */
        public class I0Io implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Activity f34977XO;

            public I0Io(Activity activity) {
                this.f34977XO = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.xoIox(this.f34977XO);
            }
        }

        /* renamed from: xoIox.OOXIXo$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class CallableC1169II0xO0 implements Callable<MediationConstant.AdIsReadyStatus> {
            public CallableC1169II0xO0() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public MediationConstant.AdIsReadyStatus call() {
                return II0xO0.this.x0XOIxOo();
            }
        }

        /* loaded from: classes.dex */
        public class X0o0xo implements Callable<String> {
            public X0o0xo() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return II0xO0.this.IIXOooo();
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.xxIXOIIO();
            }
        }

        public II0xO0(KsRewardLoader ksRewardLoader, MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, boolean z) {
            super(mediationAdSlotValueSet, bridge);
            this.f34973OxxIIOOXO = new oxoX();
            this.f34971Oo = ksRewardLoader;
            this.f34972Oxx0xo = mediationAdSlotValueSet;
            this.f34970IXxxXO = bridge;
            this.f34975oI0IIXIo = z;
            II0xO0();
        }

        private void II0xO0() {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8035, this);
            this.f34970IXxxXO.call(8128, create.build(), Void.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String IIXOooo() {
            Object obj;
            try {
                KsRewardVideoAd ksRewardVideoAd = this.f34974XO;
                if (ksRewardVideoAd != null && (obj = ksRewardVideoAd.getMediaExtraInfo().get("llsid")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private String Oxx0xo() {
            if (this.f34975oI0IIXIo) {
                return oI0IIXIo();
            }
            return IIXOooo();
        }

        private String oI0IIXIo() {
            try {
                return (String) ooOOo0oXI.oIX0oI(new X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        private void oOoXoXO() {
            ooOOo0oXI.X0o0xo(new oIX0oI());
        }

        private void ooOOo0oXI(Activity activity) {
            ooOOo0oXI.X0o0xo(new I0Io(activity));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oxoX(KsScene ksScene) {
            if (KsAdSDK.getLoadManager() != null) {
                KsAdSDK.getLoadManager().loadRewardVideoAd(ksScene, this.f34973OxxIIOOXO);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MediationConstant.AdIsReadyStatus x0XOIxOo() {
            KsRewardVideoAd ksRewardVideoAd = this.f34974XO;
            if (ksRewardVideoAd != null && ksRewardVideoAd.isAdEnable()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xoIox(Activity activity) {
            boolean z;
            if (this.f34974XO != null) {
                KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
                MediationAdSlotValueSet mediationAdSlotValueSet = this.f34972Oxx0xo;
                if (mediationAdSlotValueSet != null) {
                    z = mediationAdSlotValueSet.isMuted();
                } else {
                    z = false;
                }
                MediationAdSlotValueSet mediationAdSlotValueSet2 = this.f34972Oxx0xo;
                if (mediationAdSlotValueSet2 != null && mediationAdSlotValueSet2.getOrientation() == 2) {
                    builder.showLandscape(true);
                }
                builder.videoSoundEnable(!z);
                this.f34974XO.showRewardVideoAd(activity, builder.build());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xxIXOIIO() {
            KsRewardVideoAd ksRewardVideoAd = this.f34974XO;
            if (ksRewardVideoAd != null) {
                ksRewardVideoAd.setRewardAdInteractionListener(null);
                this.f34974XO = null;
            }
        }

        public void I0Io(Activity activity) {
            if (this.f34975oI0IIXIo) {
                ooOOo0oXI(activity);
            } else {
                xoIox(activity);
            }
        }

        public final MediationConstant.AdIsReadyStatus Oo() {
            try {
                MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) ooOOo0oXI.oIX0oI(new CallableC1169II0xO0()).get(500L, TimeUnit.MILLISECONDS);
                if (adIsReadyStatus != null) {
                    return adIsReadyStatus;
                }
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            } catch (Exception e) {
                e.printStackTrace();
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8113) {
                Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                if (activity != null) {
                    I0Io(activity);
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
                    return (T) Oxx0xo();
                }
                if (i == 8142) {
                    if (x0XOIxOo.xxIXOIIO(this.f34974XO)) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long oxoX2 = x0XOIxOo.oxoX(map);
                            long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                            KsRewardVideoAd ksRewardVideoAd = this.f34974XO;
                            if (ksRewardVideoAd != null) {
                                ksRewardVideoAd.setBidEcpm(oxoX2, oOoXoXO2);
                            }
                        }
                    }
                } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f34974XO)) {
                    Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int oO2 = x0XOIxOo.oO(map2);
                        int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                        int Oo2 = x0XOIxOo.Oo(map2);
                        String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                        if (this.f34974XO != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(x0xO0oo2);
                            adExposureFailedReason.setAdnType(Oo2);
                            adExposureFailedReason.setAdnName(IXxxXO2);
                            this.f34974XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            if (this.f34974XO == null) {
                return true;
            }
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            if (this.f34975oI0IIXIo) {
                return Oo();
            }
            return x0XOIxOo();
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            if (this.f34975oI0IIXIo) {
                oOoXoXO();
            } else {
                xxIXOIIO();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        /* loaded from: classes.dex */
        public class oxoX implements KsLoadManager.RewardVideoAdListener {

            /* loaded from: classes.dex */
            public class oIX0oI implements KsRewardVideoAd.RewardAdInteractionListener {
                public oIX0oI() {
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onAdClicked() {
                    MediationApiLog.i("KsRewardLoader", "onAdClicked");
                    if (II0xO0.this.f34970IXxxXO != null) {
                        II0xO0.this.f34970IXxxXO.call(8115, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onExtraRewardVerify(int i) {
                    MediationApiLog.i("KsRewardLoader", "onExtraRewardVerify");
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onPageDismiss() {
                    MediationApiLog.i("KsRewardLoader", "onPageDismiss");
                    if (II0xO0.this.f34970IXxxXO != null) {
                        II0xO0.this.f34970IXxxXO.call(8116, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardStepVerify(int i, int i2) {
                    MediationApiLog.i("KsRewardLoader", "onRewardStepVerify");
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onRewardVerify() {
                    MediationApiLog.i("KsRewardLoader", "onRewardVerify");
                    if (II0xO0.this.f34970IXxxXO != null) {
                        MediationValueSetBuilder create = MediationValueSetBuilder.create();
                        create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYSOPEN, true);
                        create.add(UIMsg.m_AppUI.MSG_SUG_TEXTCHAGNE, II0xO0.this.f34972Oxx0xo.getRewardAmount());
                        create.add(8019, II0xO0.this.f34972Oxx0xo.getRewardName());
                        II0xO0.this.f34970IXxxXO.call(8231, create.build(), Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayEnd() {
                    MediationApiLog.i("KsRewardLoader", "onVideoPlayEnd");
                    if (II0xO0.this.f34970IXxxXO != null) {
                        II0xO0.this.f34970IXxxXO.call(8118, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayError(int i, int i2) {
                    MediationApiLog.i("KsRewardLoader", "onVideoPlayError");
                    if (II0xO0.this.f34970IXxxXO != null) {
                        II0xO0.this.f34970IXxxXO.call(8117, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoPlayStart() {
                    MediationApiLog.i("KsRewardLoader", "onVideoPlayStart");
                    if (II0xO0.this.f34970IXxxXO != null) {
                        II0xO0.this.f34970IXxxXO.call(8230, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public void onVideoSkipToEnd(long j) {
                    MediationApiLog.i("KsRewardLoader", "onVideoSkipToEnd");
                    if (II0xO0.this.f34970IXxxXO != null) {
                        II0xO0.this.f34970IXxxXO.call(8119, null, Void.class);
                    }
                }
            }

            public oxoX() {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onError(int i, String str) {
                MediationApiLog.i("KsRewardLoader", "load fail");
                II0xO0.this.f34971Oo.notifyAdFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                if (list != null && list.size() != 0 && list.get(0) != null) {
                    II0xO0.this.f34974XO = list.get(0);
                    MediationValueSetBuilder create = MediationValueSetBuilder.create();
                    if (II0xO0.this.f34971Oo.isClientBidding()) {
                        double ecpm = II0xO0.this.f34974XO.getECPM();
                        double d = XIXIX.OOXIXo.f3760XO;
                        if (ecpm > XIXIX.OOXIXo.f3760XO) {
                            d = ecpm;
                        }
                        create.add(8016, d);
                        II0xO0.this.setCpm(ecpm);
                    }
                    if (II0xO0.this.f34970IXxxXO != null) {
                        MediationValueSetBuilder create2 = MediationValueSetBuilder.create();
                        create2.add(8059, x0XOIxOo.II0xO0(II0xO0.this.f34974XO.getInteractionType()));
                        II0xO0.this.f34970IXxxXO.call(8140, create2.build(), Void.class);
                    }
                    II0xO0.this.f34974XO.setRewardAdInteractionListener(new oIX0oI());
                    if (II0xO0.this.f34971Oo != null) {
                        MediationApiLog.i("KsRewardLoader", "load success");
                        KsRewardLoader ksRewardLoader = II0xO0.this.f34971Oo;
                        II0xO0 iI0xO0 = II0xO0.this;
                        ksRewardLoader.notifyAdSuccess(iI0xO0, iI0xO0.f34970IXxxXO);
                    }
                    if (II0xO0.this.f34971Oo != null) {
                        MediationApiLog.i("KsRewardLoader", "cache success");
                        II0xO0.this.f34971Oo.notifyAdCache(II0xO0.this.f34970IXxxXO, 80002, "没有cache回调");
                        return;
                    }
                    return;
                }
                II0xO0.this.f34971Oo.notifyAdFailed(80001, "广告位空");
            }

            @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
            public void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
            }
        }
    }
}
