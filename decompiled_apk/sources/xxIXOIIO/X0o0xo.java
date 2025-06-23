package xxIXOIIO;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtBannerLoader;
import com.bytedance.msdk.adapter.gdt.R;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.apache.commons.text.ooOOo0oXI;

/* loaded from: classes.dex */
public class X0o0xo {

    /* renamed from: I0Io, reason: collision with root package name */
    public FrameLayout.LayoutParams f35415I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Bridge f35416II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public boolean f35418X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public MediationAdSlotValueSet f35420oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public final GdtBannerLoader f35421oxoX;

    /* renamed from: XO, reason: collision with root package name */
    public final NativeExpressAD.NativeExpressADListener f35419XO = new II0xO0();

    /* renamed from: Oxx0IOOO, reason: collision with root package name */
    public final NativeADUnifiedListener f35417Oxx0IOOO = new I0Io();

    /* loaded from: classes.dex */
    public class I0Io implements NativeADUnifiedListener {
        public I0Io() {
        }

        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list != null && list.size() > 0) {
                for (NativeUnifiedADData nativeUnifiedADData : list) {
                    if (nativeUnifiedADData != null) {
                        GdtBannerLoader gdtBannerLoader = X0o0xo.this.f35421oxoX;
                        X0o0xo x0o0xo = X0o0xo.this;
                        gdtBannerLoader.notifyAdSuccess(new C1181X0o0xo(nativeUnifiedADData, x0o0xo.f35420oIX0oI, X0o0xo.this.f35416II0xO0), X0o0xo.this.f35416II0xO0);
                        return;
                    }
                }
                return;
            }
            X0o0xo.this.f35421oxoX.notifyAdFailed(80001, "load list is empty");
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                X0o0xo.this.f35421oxoX.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                X0o0xo.this.f35421oxoX.notifyAdFailed(80001, "error is null");
            }
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements NativeExpressAD.NativeExpressADListener {

        /* renamed from: oIX0oI, reason: collision with root package name */
        public XO f35424oIX0oI;

        public II0xO0() {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            XO xo2 = this.f35424oIX0oI;
            if (xo2 != null) {
                xo2.xoIox();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            XO xo2 = this.f35424oIX0oI;
            if (xo2 != null) {
                xo2.Oxx0IOOO();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            XO xo2 = this.f35424oIX0oI;
            if (xo2 != null) {
                xo2.OOXIXo();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            XO xo2 = this.f35424oIX0oI;
            if (xo2 != null) {
                xo2.oxoX();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list != null && list.size() != 0) {
                for (NativeExpressADView nativeExpressADView : list) {
                    if (nativeExpressADView != null) {
                        X0o0xo x0o0xo = X0o0xo.this;
                        XO xo2 = new XO(nativeExpressADView, x0o0xo.f35420oIX0oI, X0o0xo.this.f35416II0xO0);
                        this.f35424oIX0oI = xo2;
                        xo2.oOoXoXO();
                        return;
                    }
                }
                return;
            }
            X0o0xo.this.f35421oxoX.notifyAdFailed(80001, "load list is null or empty");
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                X0o0xo.this.f35421oxoX.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                X0o0xo.this.f35421oxoX.notifyAdFailed(80001, "error is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            X0o0xo.this.f35421oxoX.notifyAdFailed(80001, "render fail");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            X0o0xo.this.f35421oxoX.notifyAdSuccess(this.f35424oIX0oI, X0o0xo.this.f35416II0xO0);
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ Context f35459Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35460XO;

        public oIX0oI(MediationAdSlotValueSet mediationAdSlotValueSet, Context context) {
            this.f35460XO = mediationAdSlotValueSet;
            this.f35459Oo = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            X0o0xo.this.X0o0xo(this.f35460XO, this.f35459Oo);
            oOoXoXO.oxoX(getClass().getName(), this.f35459Oo);
        }
    }

    /* loaded from: classes.dex */
    public class oxoX extends MediationBaseAdBridge {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public boolean f35461IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f35462Oo;

        /* renamed from: XO, reason: collision with root package name */
        public UnifiedBannerView f35464XO;

        /* loaded from: classes.dex */
        public class I0Io implements Runnable {
            public I0Io() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (oxoX.this.f35464XO != null) {
                    oxoX.this.f35464XO.destroy();
                }
            }
        }

        /* loaded from: classes.dex */
        public class II0xO0 implements Callable<MediationConstant.AdIsReadyStatus> {
            public II0xO0() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public MediationConstant.AdIsReadyStatus call() {
                return oxoX.this.oIX0oI();
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$oxoX$X0o0xo, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC1185X0o0xo implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f35468XO;

            public RunnableC1185X0o0xo(int i) {
                this.f35468XO = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                oxoX.this.f35464XO.sendLossNotification(0, this.f35468XO, null);
            }
        }

        /* loaded from: classes.dex */
        public class XO implements Callable<String> {
            public XO() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return oxoX.this.ooOOo0oXI();
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements UnifiedBannerADListener {
            public oIX0oI() {
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClicked() {
                Bridge bridge = oxoX.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1009, null, Void.class);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADClosed() {
                Bridge bridge = oxoX.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1014, null, Void.class);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADExposure() {
                Bridge bridge = oxoX.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1008, null, Void.class);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADLeftApplication() {
                Bridge bridge = oxoX.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1016, null, Void.class);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onADReceive() {
                double d;
                if (!oxoX.this.f35462Oo) {
                    oxoX.this.f35462Oo = true;
                    if (oxoX.this.f35464XO != null) {
                        if (X0o0xo.this.f35421oxoX.isClientBidding()) {
                            int ecpm = oxoX.this.f35464XO.getECPM();
                            oxoX oxox = oxoX.this;
                            if (ecpm > 0) {
                                d = ecpm;
                            } else {
                                d = XIXIX.OOXIXo.f3760XO;
                            }
                            oxox.setCpm(d);
                        } else if (X0o0xo.this.f35421oxoX.isMultiBidding()) {
                            oxoX oxox2 = oxoX.this;
                            oxox2.setCpmLevel(oxox2.f35464XO.getECPMLevel());
                        }
                    }
                    GdtBannerLoader gdtBannerLoader = X0o0xo.this.f35421oxoX;
                    oxoX oxox3 = oxoX.this;
                    gdtBannerLoader.notifyAdSuccess(oxox3, oxox3.mGMAd);
                }
            }

            @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
            public void onNoAD(AdError adError) {
                int i;
                String str;
                if (!oxoX.this.f35462Oo) {
                    oxoX.this.f35462Oo = true;
                    GdtBannerLoader gdtBannerLoader = X0o0xo.this.f35421oxoX;
                    if (adError != null) {
                        i = adError.getErrorCode();
                    } else {
                        i = -1;
                    }
                    if (adError != null) {
                        str = adError.getErrorMsg();
                    } else {
                        str = "位置错误";
                    }
                    gdtBannerLoader.notifyAdFailed(i, str);
                }
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$oxoX$oxoX, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC1186oxoX implements Runnable {
            public RunnableC1186oxoX() {
            }

            @Override // java.lang.Runnable
            public void run() {
                oxoX.this.f35464XO.sendWinNotification((int) oxoX.this.getCpm());
            }
        }

        public oxoX(MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
            this.f35462Oo = false;
            this.f35461IXxxXO = false;
        }

        private String OOXIXo() {
            if (X0o0xo.this.f35418X0o0xo) {
                return oOoXoXO();
            }
            return ooOOo0oXI();
        }

        private String oOoXoXO() {
            try {
                return (String) oOoXoXO.oIX0oI(new XO()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String ooOOo0oXI() {
            Object obj;
            try {
                UnifiedBannerView unifiedBannerView = this.f35464XO;
                if (unifiedBannerView != null && (obj = unifiedBannerView.getExtraInfo().get("request_id")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private View xxIXOIIO() {
            return this.f35464XO;
        }

        public void I0Io(Map<String, Object> map) {
            if (!X0o0xo.this.f35421oxoX.isClientBidding() || this.f35464XO == null) {
                return;
            }
            try {
                if (X0o0xo.this.f35418X0o0xo) {
                    oOoXoXO.I0Io(new RunnableC1186oxoX());
                } else {
                    this.f35464XO.sendWinNotification((int) getCpm());
                }
            } catch (Exception unused) {
            }
        }

        public void II0XooXoX(Map<String, Object> map) {
            if (!X0o0xo.this.f35421oxoX.isClientBidding() || this.f35464XO == null || map == null) {
                return;
            }
            try {
                Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
                if (obj instanceof MediationConstant.BiddingLossReason) {
                    int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                    if (X0o0xo.this.f35418X0o0xo) {
                        oOoXoXO.I0Io(new RunnableC1185X0o0xo(oIX0oI2));
                    } else {
                        this.f35464XO.sendLossNotification(0, oIX0oI2, null);
                    }
                }
            } catch (Exception unused) {
            }
        }

        public void II0xO0(Context context) {
            if (context instanceof Activity) {
                UnifiedBannerView unifiedBannerView = new UnifiedBannerView((Activity) context, X0o0xo.this.f35421oxoX.getAdnId(), new oIX0oI());
                this.f35464XO = unifiedBannerView;
                unifiedBannerView.setRefresh(0);
                this.f35464XO.loadAD();
            }
        }

        public MediationConstant.AdIsReadyStatus XO() {
            try {
                MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) oOoXoXO.oIX0oI(new II0xO0()).get(500L, TimeUnit.MILLISECONDS);
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
            if (i == 6081) {
                return (T) xxIXOIIO();
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else if (i == 8142) {
                MediationApiLog.i("TMe", "GdtBannerLoader bidWinNotify");
                Map<String, Object> map = (Map) valueSet.objectValue(8006, Map.class);
                if (map != null) {
                    I0Io(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i("TMe", "GdtBannerLoader bidLoseNotify");
                Map<String, Object> map2 = (Map) valueSet.objectValue(8006, Map.class);
                if (map2 != null) {
                    II0XooXoX(map2);
                }
            } else if (i == 8147) {
                return (T) OOXIXo();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f35461IXxxXO;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            if (X0o0xo.this.f35418X0o0xo) {
                return XO();
            }
            return oIX0oI();
        }

        public MediationConstant.AdIsReadyStatus oIX0oI() {
            UnifiedBannerView unifiedBannerView = this.f35464XO;
            if (unifiedBannerView != null && unifiedBannerView.isValid()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            this.f35461IXxxXO = true;
            new Handler(Looper.getMainLooper()).post(new I0Io());
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public X0o0xo(GdtBannerLoader gdtBannerLoader) {
        this.f35421oxoX = gdtBannerLoader;
    }

    public final void I0Io(Context context) {
        NativeExpressAD nativeExpressAD;
        VideoOption build;
        if (this.f35421oxoX.isServerBidding()) {
            nativeExpressAD = new NativeExpressAD(context, II0xO0(this.f35420oIX0oI), this.f35421oxoX.getAdnId(), this.f35419XO, this.f35421oxoX.getAdm());
        } else {
            nativeExpressAD = new NativeExpressAD(context, II0xO0(this.f35420oIX0oI), this.f35421oxoX.getAdnId(), this.f35419XO);
        }
        int gdtMaxVideoDuration = this.f35420oIX0oI.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = this.f35420oIX0oI.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeExpressAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeExpressAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        if (this.f35420oIX0oI.getGdtVideoOption() instanceof VideoOption) {
            build = (VideoOption) this.f35420oIX0oI.getGdtVideoOption();
        } else {
            build = new VideoOption.Builder().build();
        }
        nativeExpressAD.setVideoOption(build);
        nativeExpressAD.loadAD(1);
    }

    public final void II0XooXoX(Context context) {
        NativeUnifiedAD nativeUnifiedAD;
        if (this.f35421oxoX.isServerBidding()) {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.f35421oxoX.getAdnId(), this.f35417Oxx0IOOO, this.f35421oxoX.getAdm());
        } else {
            nativeUnifiedAD = new NativeUnifiedAD(context, this.f35421oxoX.getAdnId(), this.f35417Oxx0IOOO);
        }
        int gdtMaxVideoDuration = this.f35420oIX0oI.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = this.f35420oIX0oI.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeUnifiedAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeUnifiedAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        Object gdtNativeLogoParams = this.f35420oIX0oI.getGdtNativeLogoParams();
        if (gdtNativeLogoParams instanceof FrameLayout.LayoutParams) {
            this.f35415I0Io = (FrameLayout.LayoutParams) gdtNativeLogoParams;
        }
        nativeUnifiedAD.loadData(1);
    }

    public final ADSize II0xO0(MediationAdSlotValueSet mediationAdSlotValueSet) {
        ADSize aDSize = new ADSize(-1, -2);
        float expressWidth = mediationAdSlotValueSet.getExpressWidth();
        float expressHeight = mediationAdSlotValueSet.getExpressHeight();
        if (expressWidth > 0.0f) {
            if (!xxIXOIIO.oIX0oI.X0o0xo(mediationAdSlotValueSet) && expressHeight != 0.0f) {
                return new ADSize((int) expressWidth, (int) expressHeight);
            }
            return new ADSize((int) expressWidth, -2);
        }
        return aDSize;
    }

    public final void X0o0xo(MediationAdSlotValueSet mediationAdSlotValueSet, Context context) {
        if (mediationAdSlotValueSet.getAdSubType() == 4) {
            int originType = mediationAdSlotValueSet.getOriginType();
            if (originType == 1) {
                I0Io(context.getApplicationContext());
                return;
            } else if (originType == 2) {
                II0XooXoX(context.getApplicationContext());
                return;
            } else {
                this.f35421oxoX.notifyAdFailed(80001, "originType is mismatch");
                return;
            }
        }
        new oxoX(mediationAdSlotValueSet, this.f35416II0xO0).II0xO0(context);
    }

    public void oxoX(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null && mediationAdSlotValueSet != null) {
            this.f35420oIX0oI = mediationAdSlotValueSet;
            this.f35416II0xO0 = this.f35421oxoX.getGMBridge();
            boolean oxoX2 = xxIXOIIO.oIX0oI.oxoX(this.f35421oxoX, mediationAdSlotValueSet);
            this.f35418X0o0xo = oxoX2;
            if (oxoX2) {
                oOoXoXO.I0Io(new oIX0oI(mediationAdSlotValueSet, context));
                return;
            } else {
                X0o0xo(mediationAdSlotValueSet, context);
                return;
            }
        }
        this.f35421oxoX.notifyAdFailed(80001, "context is null or adSlotValueSet is null");
    }

    /* renamed from: xxIXOIIO.X0o0xo$X0o0xo, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1181X0o0xo extends MediationBaseAdBridge {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public volatile boolean f35425IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public NativeUnifiedADData f35426Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public NativeADMediaListener f35427Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public String f35428XO;

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$I0Io */
        /* loaded from: classes.dex */
        public class I0Io implements Callable<MediationConstant.AdIsReadyStatus> {
            public I0Io() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public MediationConstant.AdIsReadyStatus call() {
                return C1181X0o0xo.this.oIX0oI();
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$II0XooXoX */
        /* loaded from: classes.dex */
        public class II0XooXoX implements Runnable {

            /* renamed from: IXxxXO, reason: collision with root package name */
            public final /* synthetic */ List f35432IXxxXO;

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f35433Oo;

            /* renamed from: Oxx0xo, reason: collision with root package name */
            public final /* synthetic */ List f35434Oxx0xo;

            /* renamed from: OxxIIOOXO, reason: collision with root package name */
            public final /* synthetic */ Bridge f35435OxxIIOOXO;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Activity f35436XO;

            /* renamed from: oI0IIXIo, reason: collision with root package name */
            public final /* synthetic */ List f35437oI0IIXIo;

            public II0XooXoX(Activity activity, ViewGroup viewGroup, List list, List list2, List list3, Bridge bridge) {
                this.f35436XO = activity;
                this.f35433Oo = viewGroup;
                this.f35432IXxxXO = list;
                this.f35434Oxx0xo = list2;
                this.f35437oI0IIXIo = list3;
                this.f35435OxxIIOOXO = bridge;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1181X0o0xo.this.I0Io(this.f35436XO, this.f35433Oo, this.f35432IXxxXO, this.f35434Oxx0xo, this.f35437oI0IIXIo, xxIXOIIO.oIX0oI.II0xO0(this.f35435OxxIIOOXO));
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$II0xO0 */
        /* loaded from: classes.dex */
        public class II0xO0 implements Runnable {
            public II0xO0() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NativeUnifiedADData nativeUnifiedADData = C1181X0o0xo.this.f35426Oo;
                if (nativeUnifiedADData != null) {
                    nativeUnifiedADData.destroy();
                }
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$Oxx0IOOO */
        /* loaded from: classes.dex */
        public class Oxx0IOOO implements Callable<String> {
            public Oxx0IOOO() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return C1181X0o0xo.this.OOXIXo();
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$X0o0xo, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC1182X0o0xo implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f35441XO;

            public RunnableC1182X0o0xo(int i) {
                this.f35441XO = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1181X0o0xo.this.f35426Oo.sendLossNotification(0, this.f35441XO, null);
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$oxoX */
        /* loaded from: classes.dex */
        public class oxoX implements Runnable {
            public oxoX() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1181X0o0xo c1181X0o0xo = C1181X0o0xo.this;
                c1181X0o0xo.f35426Oo.sendWinNotification((int) c1181X0o0xo.getCpm());
            }
        }

        public C1181X0o0xo(NativeUnifiedADData nativeUnifiedADData, MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
            this.f35428XO = "GdtBanner-gdtNativeAd";
            this.f35425IXxxXO = false;
            this.f35427Oxx0xo = new XO();
            this.f35426Oo = nativeUnifiedADData;
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            NativeUnifiedADAppMiitInfo appMiitInfo = this.f35426Oo.getAppMiitInfo();
            if (appMiitInfo != null) {
                create.add(8056, appMiitInfo.getAppName());
                create.add(8057, appMiitInfo.getAuthorName());
                create.add(8078, appMiitInfo.getPackageSizeBytes());
                create.add(8047, (int) appMiitInfo.getPackageSizeBytes());
                create.add(8079, appMiitInfo.getPermissionsUrl());
                create.add(8080, appMiitInfo.getPrivacyAgreement());
                create.add(8081, appMiitInfo.getVersionName());
                try {
                    create.add(8551, appMiitInfo.getDescriptionUrl());
                } catch (Throwable unused) {
                }
            }
            create.add(8045, this.f35426Oo.getTitle());
            create.add(8046, this.f35426Oo.getDesc());
            create.add(8061, this.f35426Oo.getCTAText());
            create.add(8048, this.f35426Oo.getIconUrl());
            create.add(8050, this.f35426Oo.getImgUrl());
            create.add(8052, this.f35426Oo.getPictureWidth());
            create.add(8051, this.f35426Oo.getPictureHeight());
            create.add(8053, this.f35426Oo.getImgList());
            create.add(8082, this.f35426Oo.getAppScore());
            create.add(8049, this.f35426Oo.getTitle());
            create.add(8055, this.f35426Oo.isAppAd());
            if (X0o0xo.this.f35421oxoX.isClientBidding()) {
                create.add(8016, Math.max(this.f35426Oo.getECPM(), XIXIX.OOXIXo.f3760XO));
            } else if (X0o0xo.this.f35421oxoX.isMultiBidding()) {
                create.add(8058, this.f35426Oo.getECPMLevel());
            }
            if (this.f35426Oo.getAdPatternType() == 2) {
                create.add(8060, 5);
            } else if (this.f35426Oo.getAdPatternType() != 4 && this.f35426Oo.getAdPatternType() != 1) {
                if (this.f35426Oo.getAdPatternType() == 3) {
                    create.add(8060, 4);
                }
            } else {
                create.add(8060, 3);
            }
            if (this.f35426Oo.isAppAd()) {
                create.add(8059, 4);
            } else {
                create.add(8059, 3);
            }
            create.add(8033, false);
            bridge.call(8140, create.build(), Void.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String OOXIXo() {
            Object obj;
            try {
                NativeUnifiedADData nativeUnifiedADData = this.f35426Oo;
                if (nativeUnifiedADData != null && (obj = nativeUnifiedADData.getExtraInfo().get("request_id")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private String xoIox() {
            try {
                return (String) oOoXoXO.oIX0oI(new Oxx0IOOO()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        private String xxIXOIIO() {
            if (X0o0xo.this.f35418X0o0xo) {
                return xoIox();
            }
            return OOXIXo();
        }

        @JProtect
        public final void I0Io(Context context, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
            NativeAdContainer nativeAdContainer;
            Object tag;
            if (this.f35426Oo != null) {
                if (list3 != null) {
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                    }
                    list2.addAll(list3);
                }
                List<View> list4 = list2;
                int i = 0;
                if (viewGroup.getChildAt(0) instanceof NativeAdContainer) {
                    nativeAdContainer = (NativeAdContainer) viewGroup.getChildAt(0);
                    while (i < nativeAdContainer.getChildCount()) {
                        View childAt = nativeAdContainer.getChildAt(i);
                        if (childAt == null || ((tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG))) {
                            i++;
                        } else {
                            nativeAdContainer.removeView(childAt);
                        }
                    }
                } else {
                    nativeAdContainer = new NativeAdContainer(context);
                    nativeAdContainer.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG);
                    while (viewGroup.getChildCount() > 0) {
                        View childAt2 = viewGroup.getChildAt(0);
                        childAt2.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                        int indexOfChild = viewGroup.indexOfChild(childAt2);
                        viewGroup.removeViewInLayout(childAt2);
                        nativeAdContainer.addView(childAt2, indexOfChild, childAt2.getLayoutParams());
                    }
                    viewGroup.removeAllViews();
                    viewGroup.addView(nativeAdContainer, -1, -1);
                }
                NativeAdContainer nativeAdContainer2 = nativeAdContainer;
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.mediaViewId);
                this.f35426Oo.bindAdToView(context, nativeAdContainer2, X0o0xo.this.f35415I0Io, list, list4);
                if (viewGroup2 != null && this.f35426Oo.getAdPatternType() == 2) {
                    MediaView mediaView = new MediaView(context);
                    viewGroup2.removeAllViews();
                    viewGroup2.addView(mediaView, -1, -1);
                    VideoOption build = new VideoOption.Builder().build();
                    if (X0o0xo.this.f35420oIX0oI != null && (X0o0xo.this.f35420oIX0oI.getGdtVideoOption() instanceof VideoOption)) {
                        build = (VideoOption) X0o0xo.this.f35420oIX0oI.getGdtVideoOption();
                    }
                    this.f35426Oo.bindMediaView(mediaView, build, this.f35427Oxx0xo);
                }
                if (!TextUtils.isEmpty(this.f35426Oo.getCTAText())) {
                    View findViewById = viewGroup.findViewById(mediationViewBinder.callToActionId);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(findViewById);
                    this.f35426Oo.bindCTAViews(arrayList);
                }
                this.f35426Oo.setNativeAdEventListener(new oIX0oI());
            }
        }

        public void II0XooXoX(Map<String, Object> map) {
            if (!X0o0xo.this.f35421oxoX.isClientBidding() || this.f35426Oo == null || map == null) {
                return;
            }
            try {
                Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
                if (obj instanceof MediationConstant.BiddingLossReason) {
                    int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                    if (X0o0xo.this.f35418X0o0xo) {
                        oOoXoXO.I0Io(new RunnableC1182X0o0xo(oIX0oI2));
                    } else {
                        this.f35426Oo.sendLossNotification(0, oIX0oI2, null);
                    }
                }
            } catch (Exception unused) {
            }
        }

        public MediationConstant.AdIsReadyStatus XO() {
            try {
                MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) oOoXoXO.oIX0oI(new I0Io()).get(500L, TimeUnit.MILLISECONDS);
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
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8159) {
                Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(8067, ViewGroup.class);
                List<View> list = (List) valueSet.objectValue(8068, List.class);
                List<View> list2 = (List) valueSet.objectValue(8069, List.class);
                List<View> list3 = (List) valueSet.objectValue(8070, List.class);
                Bridge bridge = (Bridge) valueSet.objectValue(8071, Bridge.class);
                if (X0o0xo.this.f35418X0o0xo) {
                    oOoXoXO.X0o0xo(new II0XooXoX(activity, viewGroup, list, list2, list3, bridge));
                } else {
                    I0Io(activity, viewGroup, list, list2, list3, xxIXOIIO.oIX0oI.II0xO0(bridge));
                }
            } else if (i == 8109) {
                onDestroy();
            } else if (i == 8142) {
                MediationApiLog.i(this.f35428XO, "GdtBannerLoader Native bidWinNotify");
                Map<String, Object> map = (Map) valueSet.objectValue(8006, Map.class);
                if (map != null) {
                    oxoX(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i(this.f35428XO, "GdtBannerLoader Native bidLoseNotify");
                Map<String, Object> map2 = (Map) valueSet.objectValue(8006, Map.class);
                if (map2 != null) {
                    II0XooXoX(map2);
                }
            } else if (i == 8147) {
                return (T) xxIXOIIO();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f35425IXxxXO;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            if (X0o0xo.this.f35418X0o0xo) {
                return XO();
            }
            return oIX0oI();
        }

        public MediationConstant.AdIsReadyStatus oIX0oI() {
            NativeUnifiedADData nativeUnifiedADData = this.f35426Oo;
            if (nativeUnifiedADData != null && nativeUnifiedADData.isValid()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            this.f35425IXxxXO = true;
            new Handler(Looper.getMainLooper()).post(new II0xO0());
        }

        public void oxoX(Map<String, Object> map) {
            if (!X0o0xo.this.f35421oxoX.isClientBidding() || this.f35426Oo == null) {
                return;
            }
            try {
                if (X0o0xo.this.f35418X0o0xo) {
                    oOoXoXO.I0Io(new oxoX());
                } else {
                    this.f35426Oo.sendWinNotification((int) getCpm());
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$XO */
        /* loaded from: classes.dex */
        public class XO implements NativeADMediaListener {
            public XO() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoClicked() {
                MediationApiLog.i(C1181X0o0xo.this.f35428XO, "onVideoClicked");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
                MediationApiLog.i(C1181X0o0xo.this.f35428XO, "onVideoInit: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i) {
                MediationApiLog.i(C1181X0o0xo.this.f35428XO, "onVideoLoaded: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
                MediationApiLog.i(C1181X0o0xo.this.f35428XO, "onVideoLoading: ");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
                MediationApiLog.i(C1181X0o0xo.this.f35428XO, "onVideoReady");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoStart() {
                MediationApiLog.i(C1181X0o0xo.this.f35428XO, "onVideoStart");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
                MediationApiLog.i(C1181X0o0xo.this.f35428XO, "onVideoStop");
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoCompleted() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoResume() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$X0o0xo$oIX0oI */
        /* loaded from: classes.dex */
        public class oIX0oI implements NativeADEventListener {
            public oIX0oI() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                Bridge bridge = C1181X0o0xo.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1009, null, Void.class);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                Bridge bridge = C1181X0o0xo.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1008, null, Void.class);
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class XO extends MediationBaseAdBridge {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public volatile boolean f35445IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public NativeExpressADView f35446Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final NativeExpressMediaListener f35447Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public String f35448XO;

        /* loaded from: classes.dex */
        public class I0Io implements Callable<MediationConstant.AdIsReadyStatus> {
            public I0Io() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public MediationConstant.AdIsReadyStatus call() {
                return XO.this.x0XOIxOo();
            }
        }

        /* loaded from: classes.dex */
        public class II0xO0 implements Runnable {
            public II0xO0() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NativeExpressADView nativeExpressADView = XO.this.f35446Oo;
                if (nativeExpressADView != null) {
                    nativeExpressADView.destroy();
                }
            }
        }

        /* loaded from: classes.dex */
        public class Oxx0IOOO implements Callable<String> {
            public Oxx0IOOO() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return XO.this.IXxxXO();
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$XO$X0o0xo, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC1183X0o0xo implements Runnable {

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ int f35454XO;

            public RunnableC1183X0o0xo(int i) {
                this.f35454XO = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                XO.this.f35446Oo.sendLossNotification(0, this.f35454XO, null);
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                NativeExpressADView nativeExpressADView = XO.this.f35446Oo;
                if (nativeExpressADView != null) {
                    nativeExpressADView.render();
                }
            }
        }

        /* loaded from: classes.dex */
        public class oxoX implements Runnable {
            public oxoX() {
            }

            @Override // java.lang.Runnable
            public void run() {
                XO xo2 = XO.this;
                xo2.f35446Oo.sendWinNotification((int) xo2.getCpm());
            }
        }

        public XO(NativeExpressADView nativeExpressADView, MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
            double d;
            this.f35448XO = "GdtBanenrLoader-TTExpressAd";
            this.f35445IXxxXO = false;
            C1184XO c1184xo = new C1184XO();
            this.f35447Oxx0xo = c1184xo;
            this.f35446Oo = nativeExpressADView;
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            AdData boundData = nativeExpressADView.getBoundData();
            if (boundData.getAdPatternType() == 2) {
                nativeExpressADView.setMediaListener(c1184xo);
                create.add(8060, 5);
            } else if (boundData.getAdPatternType() != 4 && boundData.getAdPatternType() != 1 && boundData.getAdPatternType() == 3) {
                create.add(8060, 4);
            } else {
                create.add(8060, 3);
            }
            create.add(8033, true);
            create.add(8045, boundData.getTitle());
            create.add(8046, boundData.getDesc());
            create.add(8059, 3);
            bridge.call(8140, create.build(), Void.class);
            if (X0o0xo.this.f35421oxoX.isClientBidding()) {
                if (boundData.getECPM() != -1) {
                    d = boundData.getECPM();
                } else {
                    d = XIXIX.OOXIXo.f3760XO;
                }
                setCpm(d);
                return;
            }
            if (X0o0xo.this.f35421oxoX.isMultiBidding()) {
                setCpmLevel(boundData.getECPMLevel());
            }
        }

        private String x0xO0oo() {
            if (X0o0xo.this.f35418X0o0xo) {
                return Oo();
            }
            return IXxxXO();
        }

        public void II0XooXoX(Map<String, Object> map) {
            if (!X0o0xo.this.f35421oxoX.isClientBidding() || this.f35446Oo == null || map == null) {
                return;
            }
            try {
                Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
                if (obj instanceof MediationConstant.BiddingLossReason) {
                    int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                    if (X0o0xo.this.f35418X0o0xo) {
                        oOoXoXO.I0Io(new RunnableC1183X0o0xo(oIX0oI2));
                    } else {
                        this.f35446Oo.sendLossNotification(0, oIX0oI2, null);
                    }
                }
            } catch (Exception unused) {
            }
        }

        public final String II0xO0(AdData.VideoPlayer videoPlayer) {
            if (videoPlayer != null) {
                return "{state:" + videoPlayer.getVideoState() + ",duration:" + videoPlayer.getDuration() + ",position:" + videoPlayer.getCurrentPosition() + ooOOo0oXI.f33074oOoXoXO;
            }
            return null;
        }

        public final String IXxxXO() {
            Object obj;
            try {
                NativeExpressADView nativeExpressADView = this.f35446Oo;
                if (nativeExpressADView != null && (obj = nativeExpressADView.getExtraInfo().get("request_id")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public void OOXIXo() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        public final String Oo() {
            try {
                return (String) oOoXoXO.oIX0oI(new Oxx0IOOO()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public void Oxx0IOOO() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1014, null, Void.class);
            }
        }

        public void X0o0xo(Map<String, Object> map) {
            if (!X0o0xo.this.f35421oxoX.isClientBidding() || this.f35446Oo == null) {
                return;
            }
            try {
                if (X0o0xo.this.f35418X0o0xo) {
                    oOoXoXO.I0Io(new oxoX());
                } else {
                    this.f35446Oo.sendWinNotification((int) getCpm());
                }
            } catch (Exception unused) {
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 6081) {
                return (T) ooOOo0oXI();
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else if (i == 8142) {
                MediationApiLog.i(this.f35448XO, "GdtBannerLoader ExpressNative bidWinNotify");
                Map<String, Object> map = (Map) valueSet.objectValue(8006, Map.class);
                if (map != null) {
                    X0o0xo(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i(this.f35448XO, "GdtBannerLoader ExpressNative bidLoseNotify");
                Map<String, Object> map2 = (Map) valueSet.objectValue(8006, Map.class);
                if (map2 != null) {
                    II0XooXoX(map2);
                }
            } else if (i == 8147) {
                return (T) x0xO0oo();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f35445IXxxXO;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            if (X0o0xo.this.f35418X0o0xo) {
                return oO();
            }
            return x0XOIxOo();
        }

        public final MediationConstant.AdIsReadyStatus oO() {
            try {
                MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) oOoXoXO.oIX0oI(new I0Io()).get(500L, TimeUnit.MILLISECONDS);
                if (adIsReadyStatus != null) {
                    return adIsReadyStatus;
                }
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            } catch (Exception e) {
                e.printStackTrace();
                return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
            }
        }

        @JProtect
        public void oOoXoXO() {
            if (X0o0xo.this.f35418X0o0xo) {
                oOoXoXO.X0o0xo(new oIX0oI());
                return;
            }
            NativeExpressADView nativeExpressADView = this.f35446Oo;
            if (nativeExpressADView != null) {
                nativeExpressADView.render();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            new Handler(Looper.getMainLooper()).post(new II0xO0());
            this.f35445IXxxXO = true;
        }

        @JProtect
        public View ooOOo0oXI() {
            return this.f35446Oo;
        }

        public void oxoX() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1016, null, Void.class);
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        public final MediationConstant.AdIsReadyStatus x0XOIxOo() {
            NativeExpressADView nativeExpressADView = this.f35446Oo;
            if (nativeExpressADView != null && nativeExpressADView.isValid()) {
                return MediationConstant.AdIsReadyStatus.AD_IS_READY;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }

        public void xoIox() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        /* renamed from: xxIXOIIO.X0o0xo$XO$XO, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C1184XO implements NativeExpressMediaListener {
            public C1184XO() {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoCached(NativeExpressADView nativeExpressADView) {
                MediationApiLog.i(XO.this.f35448XO, "onVideoCached");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoInit(NativeExpressADView nativeExpressADView) {
                MediationApiLog.i(XO.this.f35448XO, "onVideoInit: " + XO.this.II0xO0((AdData.VideoPlayer) nativeExpressADView.getBoundData().getProperty(AdData.VideoPlayer.class)));
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoLoading(NativeExpressADView nativeExpressADView) {
                MediationApiLog.i(XO.this.f35448XO, "onVideoLoading");
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            @JProtect
            public void onVideoComplete(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageClose(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageOpen(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            @JProtect
            public void onVideoPause(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            @JProtect
            public void onVideoStart(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            @JProtect
            public void onVideoError(NativeExpressADView nativeExpressADView, AdError adError) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoReady(NativeExpressADView nativeExpressADView, long j) {
            }
        }
    }
}
