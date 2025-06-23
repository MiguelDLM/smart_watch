package xoIox;

import android.content.Context;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class II0xO0 extends MediationNativeAd {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public MediationAdSlotValueSet f34960IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public View f34961Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f34962Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public KsDrawAd f34963XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public WeakReference<Context> f34964oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context;
            if (II0xO0.this.f34963XO != null && (context = (Context) II0xO0.this.f34964oI0IIXIo.get()) != null) {
                II0xO0 iI0xO0 = II0xO0.this;
                iI0xO0.f34961Oo = iI0xO0.f34963XO.getDrawView(context);
                II0xO0.this.notifyRenderSuccess(r0.f34960IXxxXO.getWidth(), II0xO0.this.f34960IXxxXO.getHeight());
            }
        }
    }

    /* renamed from: xoIox.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC1168II0xO0 implements Callable<String> {
        public CallableC1168II0xO0() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return II0xO0.this.II0XooXoX();
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements KsDrawAd.AdInteractionListener {
        public oIX0oI() {
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdClicked() {
            II0xO0.this.notifyOnClickAd();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onAdShow() {
            II0xO0.this.notifyOnShowAd();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayEnd() {
            II0xO0.this.notifyOnVideoComplete();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayError() {
            II0xO0.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "no msg");
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayPause() {
            II0xO0.this.notifyOnVideoPause();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayResume() {
            II0xO0.this.notifyOnVideoResume();
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public void onVideoPlayStart() {
            II0xO0.this.notifyOnVideoStart();
        }
    }

    public II0xO0(Context context, MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge, KsDrawAd ksDrawAd, MediationAdSlotValueSet mediationAdSlotValueSet, boolean z) {
        super(mediationAdLoaderImpl, bridge);
        this.f34964oI0IIXIo = new WeakReference<>(context);
        this.f34963XO = ksDrawAd;
        this.f34960IXxxXO = mediationAdSlotValueSet;
        this.f34962Oxx0xo = z;
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String II0XooXoX() {
        Object obj;
        try {
            KsDrawAd ksDrawAd = this.f34963XO;
            if (ksDrawAd != null && (obj = ksDrawAd.getMediaExtraInfo().get("llsid")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String X0o0xo() {
        try {
            return (String) ooOOo0oXI.oIX0oI(new CallableC1168II0xO0()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void a() {
        boolean z;
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        if (this.f34963XO.getInteractionType() == 1) {
            z = true;
        } else {
            z = false;
        }
        create.add(8055, z);
        create.add(8059, x0XOIxOo.II0xO0(this.f34963XO.getInteractionType()));
        if (isClientBidding()) {
            create.add(8016, Math.max(this.f34963XO.getECPM(), XIXIX.OOXIXo.f3760XO));
        }
        create.add(8033, true);
        notifyNativeValue(create.build());
        this.f34963XO.setAdInteractionListener(new oIX0oI());
    }

    private String oxoX() {
        if (this.f34962Oxx0xo) {
            return X0o0xo();
        }
        return II0XooXoX();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        boolean z;
        Context context;
        if (i == 6083) {
            if (this.f34962Oxx0xo) {
                ooOOo0oXI.X0o0xo(new I0Io());
            } else if (this.f34963XO != null && (context = this.f34964oI0IIXIo.get()) != null) {
                this.f34961Oo = this.f34963XO.getDrawView(context);
                notifyRenderSuccess(this.f34960IXxxXO.getWidth(), this.f34960IXxxXO.getHeight());
            }
        } else {
            if (i == 6081) {
                return (T) this.f34961Oo;
            }
            if (i == 8120) {
                if (this.f34963XO == null) {
                    z = true;
                } else {
                    z = false;
                }
                return (T) Boolean.valueOf(z);
            }
            if (i == 8109) {
                this.f34963XO = null;
            } else {
                if (i == 8147) {
                    return (T) oxoX();
                }
                if (i == 8142) {
                    if (x0XOIxOo.xxIXOIIO(this.f34963XO)) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long oxoX2 = x0XOIxOo.oxoX(map);
                            long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                            KsDrawAd ksDrawAd = this.f34963XO;
                            if (ksDrawAd != null) {
                                ksDrawAd.setBidEcpm(oxoX2, oOoXoXO2);
                            }
                        }
                    }
                } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f34963XO)) {
                    Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int oO2 = x0XOIxOo.oO(map2);
                        int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                        int Oo2 = x0XOIxOo.Oo(map2);
                        String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                        if (this.f34963XO != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(x0xO0oo2);
                            adExposureFailedReason.setAdnType(Oo2);
                            adExposureFailedReason.setAdnName(IXxxXO2);
                            this.f34963XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }
}
