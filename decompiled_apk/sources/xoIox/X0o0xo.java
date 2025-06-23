package xoIox;

import android.content.Context;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.KsNativeLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class X0o0xo extends MediationNativeAd {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f34997IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public MediationAdSlotValueSet f34998Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public KsNativeLoader f34999Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public KsFeedAd f35000XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public WeakReference<Context> f35001oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            X0o0xo.this.OOXIXo();
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements KsFeedAd.AdRenderListener {
        public II0xO0() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
        public void onAdRenderFailed(int i, String str) {
            X0o0xo.this.oIX0oI(i, str);
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
        public void onAdRenderSuccess(View view) {
            X0o0xo.this.xoIox();
        }
    }

    /* renamed from: xoIox.X0o0xo$X0o0xo, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC1170X0o0xo implements Callable<String> {
        public CallableC1170X0o0xo() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return X0o0xo.this.oO();
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Callable<View> {
        public oxoX() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public View call() {
            return X0o0xo.this.XO();
        }
    }

    public X0o0xo(Context context, KsFeedAd ksFeedAd, MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, KsNativeLoader ksNativeLoader, boolean z) {
        super(ksNativeLoader, bridge);
        this.f35001oI0IIXIo = new WeakReference<>(context);
        this.f35000XO = ksFeedAd;
        this.f34998Oo = mediationAdSlotValueSet;
        this.f34999Oxx0xo = ksNativeLoader;
        this.f34997IXxxXO = z;
        xxIXOIIO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String oO() {
        Object obj;
        try {
            KsFeedAd ksFeedAd = this.f35000XO;
            if (ksFeedAd != null && (obj = ksFeedAd.getMediaExtraInfo().get("llsid")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String ooOOo0oXI() {
        if (this.f34997IXxxXO) {
            return x0XOIxOo();
        }
        return oO();
    }

    private String x0XOIxOo() {
        try {
            return (String) ooOOo0oXI.oIX0oI(new CallableC1170X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xoIox() {
        notifyRenderSuccess(-1.0f, -2.0f);
    }

    private void xxIXOIIO() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        if (isClientBidding()) {
            create.add(8016, Math.max(this.f35000XO.getECPM(), XIXIX.OOXIXo.f3760XO));
        }
        create.add(8059, x0XOIxOo.II0xO0(this.f35000XO.getInteractionType()));
        create.add(8033, true);
        notifyNativeValue(create.build());
        this.f35000XO.setAdInteractionListener(new oIX0oI());
        if (this.f34998Oo != null) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            kSAdVideoPlayConfigImpl.setVideoSoundEnable(!this.f34998Oo.isMuted());
            this.f35000XO.setVideoPlayConfig(kSAdVideoPlayConfigImpl);
        }
    }

    public View II0XooXoX() {
        try {
            return (View) ooOOo0oXI.oIX0oI(new oxoX()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void OOXIXo() {
        View view;
        try {
            KsFeedAd ksFeedAd = this.f35000XO;
            if (ksFeedAd != null) {
                ksFeedAd.render(new II0xO0());
            } else {
                oIX0oI(80003, "渲染失败");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (this.f35000XO != null) {
                Context context = this.f35001oI0IIXIo.get();
                if (context != null) {
                    view = this.f35000XO.getFeedView(context);
                } else {
                    view = null;
                }
                if (view != null) {
                    xoIox();
                    return;
                }
            }
            oIX0oI(80003, "渲染失败");
        }
    }

    public View XO() {
        Context context;
        if (this.f35000XO != null && (context = this.f35001oI0IIXIo.get()) != null) {
            return this.f35000XO.getFeedView(context);
        }
        return null;
    }

    public void a() {
        if (this.f34997IXxxXO) {
            oOoXoXO();
        } else {
            OOXIXo();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 6083) {
            a();
        } else {
            if (i == 6081) {
                return (T) oxoX();
            }
            if (i == 8135) {
                return (T) Boolean.TRUE;
            }
            if (i == 8147) {
                return (T) ooOOo0oXI();
            }
            if (i == 8142) {
                if (x0XOIxOo.xxIXOIIO(this.f35000XO)) {
                    Map map = (Map) valueSet.objectValue(8006, Map.class);
                    MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                    if (map != null) {
                        long oxoX2 = x0XOIxOo.oxoX(map);
                        long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                        MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                        KsFeedAd ksFeedAd = this.f35000XO;
                        if (ksFeedAd != null) {
                            ksFeedAd.setBidEcpm(oxoX2, oOoXoXO2);
                        }
                    }
                }
            } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f35000XO)) {
                Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                if (map2 != null) {
                    int oO2 = x0XOIxOo.oO(map2);
                    int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                    int Oo2 = x0XOIxOo.Oo(map2);
                    String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                    MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                    if (this.f35000XO != null) {
                        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                        adExposureFailedReason.setWinEcpm(x0xO0oo2);
                        adExposureFailedReason.setAdnType(Oo2);
                        adExposureFailedReason.setAdnName(IXxxXO2);
                        this.f35000XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public final void oIX0oI(int i, String str) {
        notifyRenderFail(null, i, str);
    }

    public final void oOoXoXO() {
        ooOOo0oXI.X0o0xo(new I0Io());
    }

    public View oxoX() {
        if (this.f34997IXxxXO) {
            return II0XooXoX();
        }
        return XO();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements KsFeedAd.AdInteractionListener {
        public oIX0oI() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdClicked() {
            X0o0xo.this.notifyOnClickAd();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onAdShow() {
            X0o0xo.this.notifyOnShowAd();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDislikeClicked() {
            X0o0xo.this.notifyDislikeClick("ks信息流模板dislike接口无关闭原因", new HashMap());
            X0o0xo.this.notifyDislikeSelect(-1, "ks信息流模板dislike接口无关闭原因");
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }
}
