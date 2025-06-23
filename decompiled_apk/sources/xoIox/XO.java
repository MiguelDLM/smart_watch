package xoIox;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsBannerLoader;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class XO {

    /* renamed from: I0Io, reason: collision with root package name */
    public final KsBannerLoader f35007I0Io;

    /* renamed from: II0xO0, reason: collision with root package name */
    public Bridge f35008II0xO0;

    /* renamed from: X0o0xo, reason: collision with root package name */
    public WeakReference<Context> f35009X0o0xo;

    /* renamed from: oIX0oI, reason: collision with root package name */
    public MediationAdSlotValueSet f35010oIX0oI;

    /* renamed from: oxoX, reason: collision with root package name */
    public boolean f35011oxoX;

    /* loaded from: classes.dex */
    public class I0Io implements KsLoadManager.NativeAdListener {
        public I0Io() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onError(int i, String str) {
            XO.this.f35007I0Io.notifyAdFailed(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
            if (list != null && !list.isEmpty()) {
                for (KsNativeAd ksNativeAd : list) {
                    if (ksNativeAd != null) {
                        KsBannerLoader ksBannerLoader = XO.this.f35007I0Io;
                        XO xo2 = XO.this;
                        ksBannerLoader.notifyAdSuccess(new X0o0xo(ksNativeAd, xo2.f35010oIX0oI, XO.this.f35008II0xO0), XO.this.f35008II0xO0);
                        return;
                    }
                }
                return;
            }
            XO.this.f35007I0Io.notifyAdFailed(80001, "load成功，list为空");
        }
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements KsLoadManager.FeedAdListener {
        public II0xO0() {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onError(int i, String str) {
            XO.this.f35007I0Io.notifyAdFailed(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
        public void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
            if (list != null && !list.isEmpty()) {
                for (KsFeedAd ksFeedAd : list) {
                    if (ksFeedAd != null) {
                        XO xo2 = XO.this;
                        new oxoX(ksFeedAd, xo2.f35010oIX0oI, XO.this.f35008II0xO0).oIX0oI();
                        return;
                    }
                }
                return;
            }
            XO.this.f35007I0Io.notifyAdFailed(80001, "load成功，list为空");
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ MediationAdSlotValueSet f35029Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Context f35030XO;

        public oIX0oI(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
            this.f35030XO = context;
            this.f35029Oo = mediationAdSlotValueSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            XO.this.XO(this.f35030XO.getApplicationContext(), this.f35029Oo);
            ooOOo0oXI.oxoX(getClass().getName(), this.f35030XO.getApplicationContext());
        }
    }

    public XO(KsBannerLoader ksBannerLoader) {
        this.f35007I0Io = ksBannerLoader;
    }

    @JProtect
    public final void I0Io(KsScene ksScene) {
        KsAdSDK.getLoadManager().loadConfigFeedAd(ksScene, new II0xO0());
    }

    public void II0xO0(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.f35009X0o0xo = new WeakReference<>(context);
        boolean Oxx0IOOO2 = x0XOIxOo.Oxx0IOOO(this.f35007I0Io, mediationAdSlotValueSet);
        this.f35011oxoX = Oxx0IOOO2;
        if (Oxx0IOOO2) {
            ooOOo0oXI.I0Io(new oIX0oI(context, mediationAdSlotValueSet));
        } else {
            XO(context.getApplicationContext(), mediationAdSlotValueSet);
        }
    }

    @JProtect
    public final void Oxx0IOOO(KsScene ksScene) {
        KsAdSDK.getLoadManager().loadNativeAd(ksScene, new I0Io());
    }

    public final void XO(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        KsBannerLoader ksBannerLoader;
        String str;
        if (context != null && mediationAdSlotValueSet != null) {
            this.f35010oIX0oI = mediationAdSlotValueSet;
            this.f35008II0xO0 = this.f35007I0Io.getGMBridge();
            try {
                KsScene build = new KsScene.Builder(Long.valueOf(this.f35007I0Io.getAdnId()).longValue()).adNum(1).build();
                if (mediationAdSlotValueSet.getAdSubType() == 4) {
                    int originType = mediationAdSlotValueSet.getOriginType();
                    if (originType == 1) {
                        float expressWidth = mediationAdSlotValueSet.getExpressWidth();
                        if (expressWidth > 0.0f) {
                            build.setWidth((int) x0XOIxOo.oIX0oI(context, expressWidth));
                        }
                        I0Io(build);
                        return;
                    }
                    if (originType == 2) {
                        Oxx0IOOO(build);
                        return;
                    } else {
                        ksBannerLoader = this.f35007I0Io;
                        str = "广告类型错误";
                    }
                } else {
                    ksBannerLoader = this.f35007I0Io;
                    str = "ks不支持banner";
                }
            } catch (Exception unused) {
                this.f35007I0Io.notifyAdFailed(80001, "广告位id错误");
                return;
            }
        } else {
            ksBannerLoader = this.f35007I0Io;
            str = "context is null or adSlotValueSet is null";
        }
        ksBannerLoader.notifyAdFailed(80001, str);
    }

    /* loaded from: classes.dex */
    public class X0o0xo extends MediationBaseAdBridge {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public KsNativeAd.VideoPlayListener f35014IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public KsNativeAd.AdInteractionListener f35015Oo;

        /* renamed from: XO, reason: collision with root package name */
        public KsNativeAd f35017XO;

        /* renamed from: xoIox.XO$X0o0xo$X0o0xo, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC1171X0o0xo implements Runnable {

            /* renamed from: IXxxXO, reason: collision with root package name */
            public final /* synthetic */ List f35020IXxxXO;

            /* renamed from: Oo, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f35021Oo;

            /* renamed from: Oxx0xo, reason: collision with root package name */
            public final /* synthetic */ List f35022Oxx0xo;

            /* renamed from: XO, reason: collision with root package name */
            public final /* synthetic */ Activity f35024XO;

            /* renamed from: oI0IIXIo, reason: collision with root package name */
            public final /* synthetic */ Bridge f35025oI0IIXIo;

            public RunnableC1171X0o0xo(Activity activity, ViewGroup viewGroup, List list, List list2, Bridge bridge) {
                this.f35024XO = activity;
                this.f35021Oo = viewGroup;
                this.f35020IXxxXO = list;
                this.f35022Oxx0xo = list2;
                this.f35025oI0IIXIo = bridge;
            }

            @Override // java.lang.Runnable
            public void run() {
                X0o0xo.this.II0xO0(this.f35024XO, this.f35021Oo, this.f35020IXxxXO, this.f35022Oxx0xo, x0XOIxOo.X0o0xo(this.f35025oI0IIXIo));
            }
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements Runnable {
            public oIX0oI() {
            }

            @Override // java.lang.Runnable
            public void run() {
                X0o0xo.this.oIX0oI();
            }
        }

        /* loaded from: classes.dex */
        public class oxoX implements Callable<String> {
            public oxoX() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return X0o0xo.this.II0XooXoX();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:49:0x01f9, code lost:
        
            if (r8 != null) goto L30;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public X0o0xo(com.kwad.sdk.api.KsNativeAd r9, com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet r10, com.bykv.vk.openvk.api.proto.Bridge r11) {
            /*
                Method dump skipped, instructions count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: xoIox.XO.X0o0xo.<init>(xoIox.XO, com.kwad.sdk.api.KsNativeAd, com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet, com.bykv.vk.openvk.api.proto.Bridge):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String II0XooXoX() {
            Object obj;
            try {
                KsNativeAd ksNativeAd = this.f35017XO;
                if (ksNativeAd != null && (obj = ksNativeAd.getMediaExtraInfo().get("llsid")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private String Oxx0IOOO() {
            try {
                return (String) ooOOo0oXI.oIX0oI(new oxoX()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        private void X0o0xo() {
            ooOOo0oXI.X0o0xo(new oIX0oI());
        }

        private String XO() {
            if (XO.this.f35011oxoX) {
                return Oxx0IOOO();
            }
            return II0XooXoX();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oIX0oI() {
            KsNativeAd ksNativeAd = this.f35017XO;
            if (ksNativeAd != null) {
                ksNativeAd.setVideoPlayListener(null);
                this.f35017XO = null;
            }
        }

        @JProtect
        public void II0xO0(Context context, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
            View findViewById;
            if (list != null && list2 != null) {
                list.addAll(list2);
            }
            KsNativeAd ksNativeAd = this.f35017XO;
            if (ksNativeAd != null) {
                ksNativeAd.registerViewForInteraction(viewGroup, list, this.f35015Oo);
            }
            KsNativeAd ksNativeAd2 = this.f35017XO;
            boolean z = false;
            if (ksNativeAd2 != null && ksNativeAd2.getAdSourceLogoUrl(1) != null && (findViewById = viewGroup.findViewById(mediationViewBinder.logoLayoutId)) != null) {
                findViewById.setVisibility(0);
                if (findViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(context);
                    new xoIox.oIX0oI(imageView).execute(this.f35017XO.getAdSourceLogoUrl(1));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (findViewById instanceof ImageView) {
                    ImageView imageView2 = (ImageView) findViewById;
                    new xoIox.oIX0oI(imageView2).execute(this.f35017XO.getAdSourceLogoUrl(1));
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.mediaViewId);
            if (this.f35017XO != null && viewGroup3 != null) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
                if (XO.this.f35010oIX0oI != null && !XO.this.f35010oIX0oI.isMuted()) {
                    z = true;
                }
                kSAdVideoPlayConfigImpl.setVideoSoundEnable(z);
                View videoView = this.f35017XO.getVideoView(context, kSAdVideoPlayConfigImpl);
                if (videoView == null) {
                    return;
                }
                XO.this.f35007I0Io.removeSelfFromParent(videoView);
                viewGroup3.removeAllViews();
                viewGroup3.addView(videoView, -1, -1);
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
                Bridge bridge = (Bridge) valueSet.objectValue(8071, Bridge.class);
                if (XO.this.f35011oxoX) {
                    ooOOo0oXI.X0o0xo(new RunnableC1171X0o0xo(activity, viewGroup, list, list2, bridge));
                } else {
                    II0xO0(activity, viewGroup, list, list2, x0XOIxOo.X0o0xo(bridge));
                }
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8147) {
                    return (T) XO();
                }
                if (i == 8142) {
                    if (x0XOIxOo.xxIXOIIO(this.f35017XO)) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long oxoX2 = x0XOIxOo.oxoX(map);
                            long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                            KsNativeAd ksNativeAd = this.f35017XO;
                            if (ksNativeAd != null) {
                                ksNativeAd.setBidEcpm(oxoX2, oOoXoXO2);
                            }
                        }
                    }
                } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f35017XO)) {
                    Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int oO2 = x0XOIxOo.oO(map2);
                        int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                        int Oo2 = x0XOIxOo.Oo(map2);
                        String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                        if (this.f35017XO != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(x0xO0oo2);
                            adExposureFailedReason.setAdnType(Oo2);
                            adExposureFailedReason.setAdnName(IXxxXO2);
                            this.f35017XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            if (this.f35017XO == null) {
                return true;
            }
            return false;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            if (XO.this.f35011oxoX) {
                X0o0xo();
            } else {
                oIX0oI();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        /* loaded from: classes.dex */
        public class I0Io implements KsNativeAd.VideoPlayListener {
            public I0Io() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            @JProtect
            public void onVideoPlayComplete() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayPause() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayReady() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            public void onVideoPlayResume() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            @JProtect
            public void onVideoPlayStart() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
            @JProtect
            public void onVideoPlayError(int i, int i2) {
            }
        }

        /* loaded from: classes.dex */
        public class II0xO0 implements KsNativeAd.AdInteractionListener {
            public II0xO0() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            @JProtect
            public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                Bridge bridge = X0o0xo.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1009, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            @JProtect
            public void onAdShow(KsNativeAd ksNativeAd) {
                Bridge bridge = X0o0xo.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1008, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        }
    }

    /* loaded from: classes.dex */
    public class oxoX extends MediationBaseAdBridge {

        /* renamed from: XO, reason: collision with root package name */
        public KsFeedAd f35032XO;

        /* loaded from: classes.dex */
        public class I0Io implements KsFeedAd.AdRenderListener {
            public I0Io() {
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
            public void onAdRenderFailed(int i, String str) {
                XO.this.f35007I0Io.notifyAdFailed(i, str);
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
            public void onAdRenderSuccess(View view) {
                KsBannerLoader ksBannerLoader = XO.this.f35007I0Io;
                oxoX oxox = oxoX.this;
                ksBannerLoader.notifyAdSuccess(oxox, oxox.mGMAd);
            }
        }

        /* loaded from: classes.dex */
        public class II0xO0 implements Runnable {
            public II0xO0() {
            }

            @Override // java.lang.Runnable
            public void run() {
                oxoX.this.II0XooXoX();
            }
        }

        /* loaded from: classes.dex */
        public class X0o0xo implements Callable<String> {
            public X0o0xo() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public String call() {
                return oxoX.this.OOXIXo();
            }
        }

        /* renamed from: xoIox.XO$oxoX$oxoX, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class CallableC1172oxoX implements Callable<View> {
            public CallableC1172oxoX() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
            public View call() {
                return oxoX.this.X0o0xo();
            }
        }

        public oxoX(KsFeedAd ksFeedAd, MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge) {
            super(mediationAdSlotValueSet, bridge);
            double d;
            this.f35032XO = ksFeedAd;
            if (XO.this.f35007I0Io.isClientBidding()) {
                int ecpm = ksFeedAd.getECPM();
                if (ecpm > 0) {
                    d = ecpm;
                } else {
                    d = XIXIX.OOXIXo.f3760XO;
                }
                setCpm(d);
            }
            this.f35032XO.setAdInteractionListener(new oIX0oI(XO.this));
            if (XO.this.f35010oIX0oI != null) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
                kSAdVideoPlayConfigImpl.setVideoSoundEnable(!XO.this.f35010oIX0oI.isMuted());
                ksFeedAd.setVideoPlayConfig(kSAdVideoPlayConfigImpl);
            }
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8033, true);
            create.add(8059, x0XOIxOo.II0xO0(this.f35032XO.getInteractionType()));
            bridge.call(8140, create.build(), Void.class);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String OOXIXo() {
            Object obj;
            try {
                KsFeedAd ksFeedAd = this.f35032XO;
                if (ksFeedAd != null && (obj = ksFeedAd.getMediaExtraInfo().get("llsid")) != null) {
                    return obj.toString();
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        private void Oxx0IOOO() {
            ooOOo0oXI.X0o0xo(new II0xO0());
        }

        private String xoIox() {
            try {
                return (String) ooOOo0oXI.oIX0oI(new X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        private String xxIXOIIO() {
            if (XO.this.f35011oxoX) {
                return xoIox();
            }
            return OOXIXo();
        }

        @JProtect
        public View I0Io() {
            if (XO.this.f35011oxoX) {
                return XO();
            }
            return X0o0xo();
        }

        public final void II0XooXoX() {
            View view;
            try {
                KsFeedAd ksFeedAd = this.f35032XO;
                if (ksFeedAd != null) {
                    ksFeedAd.render(new I0Io());
                } else {
                    XO.this.f35007I0Io.notifyAdFailed(80001, "render fail, ksFeedAd is null");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.f35032XO != null) {
                    Context context = (Context) XO.this.f35009X0o0xo.get();
                    if (context != null) {
                        view = this.f35032XO.getFeedView(context);
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        XO.this.f35007I0Io.notifyAdSuccess(this, this.mGMAd);
                        return;
                    } else {
                        XO.this.f35007I0Io.notifyAdFailed(80001, "render fail, expressView is null");
                        return;
                    }
                }
                XO.this.f35007I0Io.notifyAdFailed(80001, "render fail, ksFeedAd is null");
            }
        }

        public View X0o0xo() {
            Context context;
            if (this.f35032XO != null && (context = (Context) XO.this.f35009X0o0xo.get()) != null) {
                return this.f35032XO.getFeedView(context);
            }
            return null;
        }

        public View XO() {
            try {
                return (View) ooOOo0oXI.oIX0oI(new CallableC1172oxoX()).get(500L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 6081) {
                return (T) I0Io();
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8147) {
                    return (T) xxIXOIIO();
                }
                if (i == 8142) {
                    if (x0XOIxOo.xxIXOIIO(this.f35032XO)) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long oxoX2 = x0XOIxOo.oxoX(map);
                            long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                            KsFeedAd ksFeedAd = this.f35032XO;
                            if (ksFeedAd != null) {
                                ksFeedAd.setBidEcpm(oxoX2, oOoXoXO2);
                            }
                        }
                    }
                } else if (i == 8144 && x0XOIxOo.x0XOIxOo(this.f35032XO)) {
                    Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int oO2 = x0XOIxOo.oO(map2);
                        int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                        int Oo2 = x0XOIxOo.Oo(map2);
                        String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                        if (this.f35032XO != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(x0xO0oo2);
                            adExposureFailedReason.setAdnType(Oo2);
                            adExposureFailedReason.setAdnName(IXxxXO2);
                            this.f35032XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return false;
        }

        public void oIX0oI() {
            if (XO.this.f35011oxoX) {
                Oxx0IOOO();
            } else {
                II0XooXoX();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }

        /* loaded from: classes.dex */
        public class oIX0oI implements KsFeedAd.AdInteractionListener {

            /* renamed from: oIX0oI, reason: collision with root package name */
            public final /* synthetic */ XO f35037oIX0oI;

            public oIX0oI(XO xo2) {
                this.f35037oIX0oI = xo2;
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                Bridge bridge = oxoX.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1009, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                Bridge bridge = oxoX.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1008, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                Bridge bridge = oxoX.this.mGMAd;
                if (bridge != null) {
                    bridge.call(1014, null, Void.class);
                }
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
        }
    }
}
