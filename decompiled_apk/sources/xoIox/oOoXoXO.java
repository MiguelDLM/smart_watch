package xoIox;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import com.baidu.mapapi.UIMsg;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsSplashLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class oOoXoXO {

    /* renamed from: II0xO0, reason: collision with root package name */
    public boolean f35040II0xO0;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final KsSplashLoader f35041oIX0oI;

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Context f35052Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35053XO;

        public oIX0oI(MediationAdSlotValueSet mediationAdSlotValueSet, Context context) {
            this.f35053XO = mediationAdSlotValueSet;
            this.f35052Oo = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            oOoXoXO.this.II0xO0(this.f35053XO);
            ooOOo0oXI.oxoX(getClass().getName(), this.f35052Oo.getApplicationContext());
        }
    }

    public oOoXoXO(KsSplashLoader ksSplashLoader) {
        this.f35041oIX0oI = ksSplashLoader;
    }

    public void II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet) {
        MediationApiLog.i("TMe", "KsSplashLoader realLoader adnId:" + this.f35041oIX0oI.getAdnId());
        try {
            new II0xO0(mediationAdSlotValueSet, this.f35041oIX0oI.getGMBridge()).XO(new KsScene.Builder(Long.valueOf(this.f35041oIX0oI.getAdnId()).longValue()).build());
        } catch (Exception unused) {
            this.f35041oIX0oI.notifyAdFailed(80001, "代码位不合法");
        }
    }

    public void oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean Oxx0IOOO2 = x0XOIxOo.Oxx0IOOO(this.f35041oIX0oI, mediationAdSlotValueSet);
        this.f35040II0xO0 = Oxx0IOOO2;
        if (Oxx0IOOO2) {
            ooOOo0oXI.I0Io(new oIX0oI(mediationAdSlotValueSet, context));
        } else {
            II0xO0(mediationAdSlotValueSet);
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 extends MediationBaseAdBridge {

        /* renamed from: Oo, reason: collision with root package name */
        public KsLoadManager.SplashScreenAdListener f35043Oo;

        /* renamed from: XO, reason: collision with root package name */
        public KsSplashScreenAd f35044XO;

        /* loaded from: classes.dex */
        public class I0Io implements Callable<MediationConstant.AdIsReadyStatus> {
            public I0Io() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public MediationConstant.AdIsReadyStatus call() {
                return II0xO0.this.oIX0oI();
            }
        }

        /* loaded from: classes.dex */
        public class X0o0xo implements Callable<String> {
            public X0o0xo() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return II0xO0.this.x0XOIxOo();
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f35049XO;

            public oIX0oI(ViewGroup viewGroup) {
                this.f35049XO = viewGroup;
            }

            @Override // java.lang.Runnable
            public void run() {
                II0xO0.this.oOoXoXO(this.f35049XO);
            }
        }

        public II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
            this.f35043Oo = new oxoX();
        }

        private String OOXIXo() {
            if (oOoXoXO.this.f35040II0xO0) {
                return ooOOo0oXI();
            }
            return x0XOIxOo();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oOoXoXO(ViewGroup viewGroup) {
            View view;
            KsSplashScreenAd ksSplashScreenAd = this.f35044XO;
            if (ksSplashScreenAd != null && viewGroup != null && (view = ksSplashScreenAd.getView(viewGroup.getContext(), new C1173II0xO0())) != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(view);
                }
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                viewGroup.removeAllViews();
                viewGroup.addView(view);
            }
        }

        private String ooOOo0oXI() {
            try {
                return (String) ooOOo0oXI.oIX0oI(new X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String x0XOIxOo() {
            Object obj;
            try {
                KsSplashScreenAd ksSplashScreenAd = this.f35044XO;
                if (ksSplashScreenAd != null && (obj = ksSplashScreenAd.getMediaExtraInfo().get("llsid")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private void xoIox(ViewGroup viewGroup) {
            ooOOo0oXI.X0o0xo(new oIX0oI(viewGroup));
        }

        public MediationConstant.AdIsReadyStatus II0XooXoX() {
            try {
                MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) ooOOo0oXI.oIX0oI(new I0Io()).get(500L, TimeUnit.MILLISECONDS);
                if (adIsReadyStatus != null) {
                    return adIsReadyStatus;
                }
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            } catch (Exception e) {
                e.printStackTrace();
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            }
        }

        public void X0o0xo(ViewGroup viewGroup) {
            if (oOoXoXO.this.f35040II0xO0) {
                xoIox(viewGroup);
            } else {
                oOoXoXO(viewGroup);
            }
        }

        @JProtect
        public void XO(KsScene ksScene) {
            MediationApiLog.i("TMe", "KsSplashLoader loadAd");
            KsAdSDK.getLoadManager().loadSplashScreenAd(ksScene, this.f35043Oo);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 6152) {
                MediationApiLog.i("TMe", "KsSplashLoader showSplashAd");
                ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(20060, ViewGroup.class);
                if (viewGroup != null) {
                    X0o0xo(viewGroup);
                }
            } else if (i != 6154 && i != 6153) {
                if (i == 6161) {
                    MediationApiLog.i("TMe", "KsSplashLoader showMinWindow");
                    Rect rect = (Rect) valueSet.objectValue(20067, Rect.class);
                    if (rect != null) {
                        oxoX(rect);
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
                        return (T) OOXIXo();
                    }
                    if (i == 8142) {
                        if (x0XOIxOo.xxIXOIIO(this.f35044XO)) {
                            Map map = (Map) valueSet.objectValue(8006, Map.class);
                            MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                            if (map != null) {
                                long oxoX2 = x0XOIxOo.oxoX(map);
                                long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                                MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                                KsSplashScreenAd ksSplashScreenAd = this.f35044XO;
                                if (ksSplashScreenAd != null) {
                                    ksSplashScreenAd.setBidEcpm(oxoX2, oOoXoXO2);
                                }
                            }
                        }
                    } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f35044XO)) {
                        Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                        if (map2 != null) {
                            int oO2 = x0XOIxOo.oO(map2);
                            int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                            int Oo2 = x0XOIxOo.Oo(map2);
                            String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                            MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                            if (this.f35044XO != null) {
                                AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                                adExposureFailedReason.setWinEcpm(x0xO0oo2);
                                adExposureFailedReason.setAdnType(Oo2);
                                adExposureFailedReason.setAdnName(IXxxXO2);
                                this.f35044XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                            }
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            if (this.f35044XO == null) {
                return true;
            }
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            if (oOoXoXO.this.f35040II0xO0) {
                return II0XooXoX();
            }
            return oIX0oI();
        }

        public MediationConstant.AdIsReadyStatus oIX0oI() {
            KsSplashScreenAd ksSplashScreenAd = this.f35044XO;
            if (ksSplashScreenAd != null && ksSplashScreenAd.isAdEnable()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            if (this.f35044XO != null) {
                this.f35044XO = null;
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        /* renamed from: xoIox.oOoXoXO$II0xO0$II0xO0, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C1173II0xO0 implements KsSplashScreenAd.SplashScreenAdInteractionListener {
            public C1173II0xO0() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdClicked() {
                MediationApiLog.i("TMe", "KsSplashLoader onAdClicked");
                Bridge bridge = II0xO0.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1009, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowEnd() {
                MediationApiLog.i("TMe", "KsSplashLoader onAdShowEnd");
                Bridge bridge = II0xO0.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1011, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowError(int i, String str) {
                MediationApiLog.i("TMe", "KsSplashLoader onAdShowError");
                if (II0xO0.this.mGMAd != null) {
                    MediationValueSetBuilder create = MediationValueSetBuilder.create();
                    create.add(UIMsg.m_AppUI.MSG_MAP_HOTKEYS, i);
                    create.add(8015, str);
                    II0xO0.this.mGMAd.call(1017, create.build(), Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onAdShowStart() {
                MediationApiLog.i("TMe", "KsSplashLoader onAdShowStart");
                Bridge bridge = II0xO0.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1008, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onSkippedAd() {
                MediationApiLog.i("TMe", "KsSplashLoader onSkippedAd");
                Bridge bridge = II0xO0.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1019, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogCancel() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        }

        /* loaded from: classes.dex */
        public class oxoX implements KsLoadManager.SplashScreenAdListener {
            public oxoX() {
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onError(int i, String str) {
                MediationApiLog.i("TMe", "KsSplashLoader load  onError");
                oOoXoXO.this.f35041oIX0oI.notifyAdFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
                MediationApiLog.i("TMe", "KsSplashLoader load  onSplashScreenAdLoad ksSplashScreenAd:" + ksSplashScreenAd);
                if (ksSplashScreenAd != null) {
                    II0xO0.this.f35044XO = ksSplashScreenAd;
                    if (oOoXoXO.this.f35041oIX0oI.isClientBidding()) {
                        double ecpm = ksSplashScreenAd.getECPM();
                        II0xO0 iI0xO0 = II0xO0.this;
                        if (ecpm <= XIXIX.OOXIXo.f3760XO) {
                            ecpm = 0.0d;
                        }
                        iI0xO0.setCpm(ecpm);
                    }
                    if (II0xO0.this.mGMAd != null) {
                        MediationValueSetBuilder create = MediationValueSetBuilder.create();
                        create.add(8059, x0XOIxOo.II0xO0(II0xO0.this.f35044XO.getInteractionType()));
                        II0xO0.this.mGMAd.call(8140, create.build(), Void.class);
                    }
                    II0xO0.this.setExpress();
                    MediationApiLog.i("KsRewardLoader", "load success");
                    KsSplashLoader ksSplashLoader = oOoXoXO.this.f35041oIX0oI;
                    II0xO0 iI0xO02 = II0xO0.this;
                    ksSplashLoader.notifyAdSuccess(iI0xO02, iI0xO02.mGMAd);
                    return;
                }
                oOoXoXO.this.f35041oIX0oI.notifyAdFailed(80001, "ksSplashScreenAd is null");
            }

            @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
            public void onRequestResult(int i) {
            }
        }

        public void oxoX(Rect rect) {
        }
    }
}
