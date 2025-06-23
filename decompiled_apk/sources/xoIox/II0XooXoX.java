package xoIox;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsFullVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class II0XooXoX {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f34945II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final KsFullVideoLoader f34946oIX0oI;

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Context f34958Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f34959XO;

        public oIX0oI(MediationAdSlotValueSet mediationAdSlotValueSet, Context context) {
            this.f34959XO = mediationAdSlotValueSet;
            this.f34958Oo = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0XooXoX.this.II0xO0(this.f34959XO);
            ooOOo0oXI.oxoX(getClass().getName(), this.f34958Oo);
        }
    }

    public II0XooXoX(KsFullVideoLoader ksFullVideoLoader) {
        this.f34946oIX0oI = ksFullVideoLoader;
    }

    public void II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            new II0xO0(mediationAdSlotValueSet, this.f34946oIX0oI.getGMBridge()).X0o0xo(new KsScene.Builder(Long.valueOf(this.f34946oIX0oI.getAdnId()).longValue()).build());
        } catch (Exception unused) {
            this.f34946oIX0oI.notifyAdFailed(80001, "代码位不合法");
        }
    }

    public void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean Oxx0IOOO2 = x0XOIxOo.Oxx0IOOO(this.f34946oIX0oI, mediationAdSlotValueSet);
        this.f34945II0xO0 = Oxx0IOOO2;
        if (Oxx0IOOO2) {
            ooOOo0oXI.I0Io(new oIX0oI(mediationAdSlotValueSet, context));
        } else {
            II0xO0(mediationAdSlotValueSet);
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 extends MediationBaseAdBridge {

        /* renamed from: Oo, reason: collision with root package name */
        public KsLoadManager.FullScreenVideoAdListener f34948Oo;

        /* renamed from: XO, reason: collision with root package name */
        public KsFullScreenVideoAd f34949XO;

        /* loaded from: classes.dex */
        public class I0Io implements Runnable {
            public I0Io() {
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.I0Io();
            }
        }

        /* renamed from: xoIox.II0XooXoX$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class CallableC1167II0xO0 implements Callable<MediationConstant.AdIsReadyStatus> {
            public CallableC1167II0xO0() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public MediationConstant.AdIsReadyStatus call() {
                return II0xO0.this.xoIox();
            }
        }

        /* loaded from: classes.dex */
        public class X0o0xo implements Callable<String> {
            public X0o0xo() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return II0xO0.this.x0xO0oo();
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Activity f34954XO;

            public oIX0oI(Activity activity) {
                this.f34954XO = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.xxIXOIIO(this.f34954XO);
            }
        }

        public II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
            this.f34948Oo = new oxoX();
        }

        private String oO() {
            try {
                return (String) ooOOo0oXI.oIX0oI(new X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        private void oOoXoXO(Activity activity) {
            ooOOo0oXI.X0o0xo(new oIX0oI(activity));
        }

        private MediationConstant.AdIsReadyStatus ooOOo0oXI() {
            try {
                MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) ooOOo0oXI.oIX0oI(new CallableC1167II0xO0()).get(500L, TimeUnit.MILLISECONDS);
                if (adIsReadyStatus != null) {
                    return adIsReadyStatus;
                }
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            } catch (Exception e) {
                e.printStackTrace();
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            }
        }

        private String x0XOIxOo() {
            if (II0XooXoX.this.f34945II0xO0) {
                return oO();
            }
            return x0xO0oo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String x0xO0oo() {
            Object obj;
            try {
                KsFullScreenVideoAd ksFullScreenVideoAd = this.f34949XO;
                if (ksFullScreenVideoAd != null && (obj = ksFullScreenVideoAd.getMediaExtraInfo().get("llsid")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MediationConstant.AdIsReadyStatus xoIox() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader isReadyStatus");
            KsFullScreenVideoAd ksFullScreenVideoAd = this.f34949XO;
            if (ksFullScreenVideoAd != null && ksFullScreenVideoAd.isAdEnable()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public void xxIXOIIO(Activity activity) {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader showAd");
            if (activity != null && this.f34949XO != null) {
                KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
                boolean isMuted = isMuted();
                if (getOrientation() == 2) {
                    builder.showLandscape(true);
                }
                builder.videoSoundEnable(!isMuted);
                this.f34949XO.showFullScreenVideoAd(activity, builder.build());
            }
        }

        public void I0Io() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onDestroy");
            KsFullScreenVideoAd ksFullScreenVideoAd = this.f34949XO;
            if (ksFullScreenVideoAd != null) {
                ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.f34949XO = null;
            }
        }

        public void II0XooXoX() {
            ooOOo0oXI.X0o0xo(new I0Io());
        }

        @JProtect
        public void X0o0xo(KsScene ksScene) {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader loadAd");
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksScene, this.f34948Oo);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8113) {
                MediationApiLog.i("TMe", "ks_KsFullVideoLoader showAd");
                Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                if (activity != null) {
                    oxoX(activity);
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
                    return (T) x0XOIxOo();
                }
                if (i == 8142) {
                    if (x0XOIxOo.xxIXOIIO(this.f34949XO)) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long oxoX2 = x0XOIxOo.oxoX(map);
                            long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                            KsFullScreenVideoAd ksFullScreenVideoAd = this.f34949XO;
                            if (ksFullScreenVideoAd != null) {
                                ksFullScreenVideoAd.setBidEcpm(oxoX2, oOoXoXO2);
                            }
                        }
                    }
                } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f34949XO)) {
                    Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int oO2 = x0XOIxOo.oO(map2);
                        int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                        int Oo2 = x0XOIxOo.Oo(map2);
                        String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                        if (this.f34949XO != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(x0xO0oo2);
                            adExposureFailedReason.setAdnType(Oo2);
                            adExposureFailedReason.setAdnName(IXxxXO2);
                            this.f34949XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader hasDestroyed");
            if (this.f34949XO == null) {
                return true;
            }
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            if (II0XooXoX.this.f34945II0xO0) {
                return ooOOo0oXI();
            }
            return xoIox();
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            if (II0XooXoX.this.f34945II0xO0) {
                II0XooXoX();
            } else {
                I0Io();
            }
        }

        public void oxoX(Activity activity) {
            if (II0XooXoX.this.f34945II0xO0) {
                oOoXoXO(activity);
            } else {
                xxIXOIIO(activity);
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        /* loaded from: classes.dex */
        public class oxoX implements KsLoadManager.FullScreenVideoAdListener {

            /* loaded from: classes.dex */
            public class oIX0oI implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
                public oIX0oI() {
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onAdClicked() {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onAdClicked");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1009, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onPageDismiss() {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onPageDismiss");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1014, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onSkippedVideo() {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onSkippedVideo");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1037, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onVideoPlayEnd() {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayEnd");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1026, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onVideoPlayError(int i, int i2) {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayError");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1021, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public void onVideoPlayStart() {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayStart");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1008, null, Void.class);
                    }
                }
            }

            public oxoX() {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            @JProtect
            public void onError(int i, String str) {
                MediationApiLog.i("TMe", "ks_KsFullVideoLoader onError");
                II0XooXoX.this.f34946oIX0oI.notifyAdFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            @JProtect
            public void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                MediationApiLog.i("TMe", "ks_KsFullVideoLoader onFullScreenVideoAdLoad");
                if (list != null && list.size() != 0 && list.get(0) != null) {
                    II0xO0.this.f34949XO = list.get(0);
                    if (II0XooXoX.this.f34946oIX0oI.isClientBidding()) {
                        double ecpm = II0xO0.this.f34949XO.getECPM();
                        II0xO0 iI0xO0 = II0xO0.this;
                        if (ecpm <= XIXIX.OOXIXo.f3760XO) {
                            ecpm = 0.0d;
                        }
                        iI0xO0.setCpm(ecpm);
                    }
                    if (II0xO0.this.mGMAd != null) {
                        MediationValueSetBuilder create = MediationValueSetBuilder.create();
                        create.add(8059, x0XOIxOo.II0xO0(II0xO0.this.f34949XO.getInteractionType()));
                        II0xO0.this.mGMAd.call(8140, create.build(), Void.class);
                    }
                    II0xO0.this.setExpress();
                    II0xO0.this.f34949XO.setFullScreenVideoAdInteractionListener(new oIX0oI());
                    KsFullVideoLoader ksFullVideoLoader = II0XooXoX.this.f34946oIX0oI;
                    II0xO0 iI0xO02 = II0xO0.this;
                    ksFullVideoLoader.notifyAdSuccess(iI0xO02, iI0xO02.mGMAd);
                    II0XooXoX.this.f34946oIX0oI.notifyAdCache(II0xO0.this.mGMAd, 80002, "没有cache回调");
                    return;
                }
                II0XooXoX.this.f34946oIX0oI.notifyAdFailed(80001, "暂无广告");
            }

            @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
            public void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
            }
        }
    }
}
