package xoIox;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsInterstitialLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class xxIXOIIO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f35091II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final KsInterstitialLoader f35092oIX0oI;

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Context f35104Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35105XO;

        public oIX0oI(MediationAdSlotValueSet mediationAdSlotValueSet, Context context) {
            this.f35105XO = mediationAdSlotValueSet;
            this.f35104Oo = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            xxIXOIIO.this.II0xO0(this.f35105XO);
            ooOOo0oXI.oxoX(getClass().getName(), this.f35104Oo);
        }
    }

    public xxIXOIIO(KsInterstitialLoader ksInterstitialLoader) {
        this.f35092oIX0oI = ksInterstitialLoader;
    }

    public final void II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            new II0xO0(mediationAdSlotValueSet, this.f35092oIX0oI.getGMBridge()).X0o0xo(new KsScene.Builder(Long.valueOf(this.f35092oIX0oI.getAdnId()).longValue()).build());
        } catch (Exception unused) {
            this.f35092oIX0oI.notifyAdFailed(80001, "代码位不合法");
        }
    }

    public void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean Oxx0IOOO2 = x0XOIxOo.Oxx0IOOO(this.f35092oIX0oI, mediationAdSlotValueSet);
        this.f35091II0xO0 = Oxx0IOOO2;
        if (Oxx0IOOO2) {
            ooOOo0oXI.I0Io(new oIX0oI(mediationAdSlotValueSet, context));
        } else {
            II0xO0(mediationAdSlotValueSet);
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 extends MediationBaseAdBridge {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public KsLoadManager.InterstitialAdListener f35093IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f35094Oo;

        /* renamed from: XO, reason: collision with root package name */
        public KsInterstitialAd f35096XO;

        /* renamed from: xoIox.xxIXOIIO$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC1175II0xO0 implements Runnable {
            public RunnableC1175II0xO0() {
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.I0Io();
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Activity f35101XO;

            public oIX0oI(Activity activity) {
                this.f35101XO = activity;
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.oxoX(this.f35101XO);
            }
        }

        /* loaded from: classes.dex */
        public class oxoX implements Callable<String> {
            public oxoX() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return II0xO0.this.x0XOIxOo();
            }
        }

        public II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
            this.f35093IXxxXO = new I0Io();
        }

        private String oOoXoXO() {
            if (xxIXOIIO.this.f35091II0xO0) {
                return ooOOo0oXI();
            }
            return x0XOIxOo();
        }

        private String ooOOo0oXI() {
            try {
                return (String) ooOOo0oXI.oIX0oI(new oxoX()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String x0XOIxOo() {
            Object obj;
            try {
                KsInterstitialAd ksInterstitialAd = this.f35096XO;
                if (ksInterstitialAd != null && (obj = ksInterstitialAd.getMediaExtraInfo().get("llsid")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void xoIox() {
            if (!this.f35094Oo) {
                this.f35094Oo = true;
                Bridge bridge = this.mGMAd;
                if (bridge != null) {
                    bridge.call(1014, null, Void.class);
                }
            }
        }

        public void I0Io() {
            KsInterstitialAd ksInterstitialAd = this.f35096XO;
            if (ksInterstitialAd != null) {
                ksInterstitialAd.setAdInteractionListener(null);
                this.f35096XO = null;
            }
        }

        public void OOXIXo(Activity activity) {
            if (xxIXOIIO.this.f35091II0xO0) {
                Oxx0IOOO(activity);
            } else {
                oxoX(activity);
            }
        }

        public void Oxx0IOOO(Activity activity) {
            ooOOo0oXI.X0o0xo(new oIX0oI(activity));
        }

        @JProtect
        public void X0o0xo(KsScene ksScene) {
            MediationApiLog.i("TMe", "ks_KsInterstitialLoader loadAd");
            KsAdSDK.getLoadManager().loadInterstitialAd(ksScene, this.f35093IXxxXO);
        }

        public void XO() {
            ooOOo0oXI.X0o0xo(new RunnableC1175II0xO0());
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 8113) {
                Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                if (activity != null) {
                    OOXIXo(activity);
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
                    return (T) oOoXoXO();
                }
                if (i == 8142) {
                    if (x0XOIxOo.xxIXOIIO(this.f35096XO)) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long oxoX2 = x0XOIxOo.oxoX(map);
                            long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                            KsInterstitialAd ksInterstitialAd = this.f35096XO;
                            if (ksInterstitialAd != null) {
                                ksInterstitialAd.setBidEcpm(oxoX2, oOoXoXO2);
                            }
                        }
                    }
                } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f35096XO)) {
                    Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int oO2 = x0XOIxOo.oO(map2);
                        int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                        int Oo2 = x0XOIxOo.Oo(map2);
                        String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                        if (this.f35096XO != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(x0xO0oo2);
                            adExposureFailedReason.setAdnType(Oo2);
                            adExposureFailedReason.setAdnName(IXxxXO2);
                            this.f35096XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            if (this.f35096XO == null) {
                return true;
            }
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            if (xxIXOIIO.this.f35091II0xO0) {
                XO();
            } else {
                I0Io();
            }
        }

        @JProtect
        public void oxoX(Activity activity) {
            if (this.f35096XO != null) {
                this.f35096XO.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(!isMuted()).build());
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        /* loaded from: classes.dex */
        public class I0Io implements KsLoadManager.InterstitialAdListener {

            /* loaded from: classes.dex */
            public class oIX0oI implements KsInterstitialAd.AdInteractionListener {
                public oIX0oI() {
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdClicked() {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onAdClicked");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1009, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdClosed() {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onAdClosed");
                    II0xO0.this.xoIox();
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onAdShow() {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onAdShow");
                    Bridge bridge = II0xO0.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1008, null, Void.class);
                    }
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onPageDismiss() {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onPageDismiss");
                    II0xO0.this.xoIox();
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onSkippedAd() {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onSkippedAd");
                    II0xO0.this.xoIox();
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayEnd() {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onVideoPlayEnd");
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayError(int i, int i2) {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onVideoPlayError");
                }

                @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public void onVideoPlayStart() {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onVideoPlayStart");
                }
            }

            public I0Io() {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            @JProtect
            public void onError(int i, String str) {
                MediationApiLog.i("TMe", "ks_KsInterstitialLoader onError");
                xxIXOIIO.this.f35092oIX0oI.notifyAdFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            @JProtect
            public void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                if (list != null && list.size() != 0) {
                    MediationApiLog.i("TMe", "ks_KsInterstitialLoader onInterstitialAdLoad");
                    II0xO0.this.f35096XO = list.get(0);
                    II0xO0.this.setExpress();
                    if (xxIXOIIO.this.f35092oIX0oI.isClientBidding()) {
                        double ecpm = II0xO0.this.f35096XO.getECPM();
                        II0xO0 iI0xO0 = II0xO0.this;
                        if (ecpm <= XIXIX.OOXIXo.f3760XO) {
                            ecpm = 0.0d;
                        }
                        iI0xO0.setCpm(ecpm);
                    }
                    if (II0xO0.this.mGMAd != null) {
                        MediationValueSetBuilder create = MediationValueSetBuilder.create();
                        create.add(8059, x0XOIxOo.II0xO0(II0xO0.this.f35096XO.getInteractionType()));
                        II0xO0.this.mGMAd.call(8140, create.build(), Void.class);
                    }
                    KsInterstitialLoader ksInterstitialLoader = xxIXOIIO.this.f35092oIX0oI;
                    II0xO0 iI0xO02 = II0xO0.this;
                    ksInterstitialLoader.notifyAdSuccess(iI0xO02, iI0xO02.mGMAd);
                    II0xO0.this.f35096XO.setAdInteractionListener(new oIX0oI());
                    return;
                }
                xxIXOIIO.this.f35092oIX0oI.notifyAdFailed(80001, "暂无广告");
            }

            @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
            public void onRequestResult(int i) {
            }
        }
    }
}
