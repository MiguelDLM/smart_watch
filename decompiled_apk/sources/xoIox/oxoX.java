package xoIox;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsNativeLoader;
import com.bytedance.msdk.adapter.ks.R;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class oxoX extends MediationNativeAd {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public KsApkDownloadListener f35057IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f35058IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public MediationAdSlotValueSet f35059Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public Context f35060Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public KsNativeAd.VideoPlayListener f35061OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public KsNativeAd f35062XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public KsNativeAd.AdInteractionListener f35063oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements KsApkDownloadListener {
        public I0Io() {
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFailed() {
            oxoX.this.notifyOnDownloadFailed(-1L, -1L, null, null);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadFinished() {
            oxoX.this.notifyOnDownloadFinished(-1L, null, null);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onDownloadStarted() {
            oxoX.this.notifyOnDownloadStarted();
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onIdle() {
            oxoX.this.notifyOnIdel();
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onInstalled() {
            oxoX.this.notifyOnInstalled(null, null);
        }

        @Override // com.kwad.sdk.api.KsApkDownloadListener
        public void onPaused(int i) {
            oxoX.this.notifyOnDownloadPause(-1L, -1L, null, null);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public void onProgressUpdate(int i) {
            oxoX.this.notifyOnProgressUpdate(-1L, -1L, i, 2);
        }
    }

    /* loaded from: classes.dex */
    public class II0XooXoX implements Callable<String> {
        public II0XooXoX() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return oxoX.this.oI0IIXIo();
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Callable<Integer> {
        public X0o0xo() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            return Integer.valueOf(oxoX.this.xoIox());
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

    /* renamed from: xoIox.oxoX$oxoX, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC1174oxoX implements Callable<Integer> {
        public CallableC1174oxoX() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            return Integer.valueOf(oxoX.this.oIX0oI());
        }
    }

    /* loaded from: classes.dex */
    public class xxIXOIIO implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ List f35072IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f35073Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ List f35074Oxx0xo;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Activity f35076XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ Bridge f35077oI0IIXIo;

        public xxIXOIIO(Activity activity, ViewGroup viewGroup, List list, List list2, Bridge bridge) {
            this.f35076XO = activity;
            this.f35073Oo = viewGroup;
            this.f35072IXxxXO = list;
            this.f35074Oxx0xo = list2;
            this.f35077oI0IIXIo = bridge;
        }

        @Override // java.lang.Runnable
        public void run() {
            oxoX.this.X0o0xo(this.f35076XO, this.f35073Oo, this.f35072IXxxXO, this.f35074Oxx0xo, x0XOIxOo.X0o0xo(this.f35077oI0IIXIo));
        }
    }

    public oxoX(Context context, KsNativeAd ksNativeAd, MediationAdSlotValueSet mediationAdSlotValueSet, Bridge bridge, KsNativeLoader ksNativeLoader, boolean z) {
        super(ksNativeLoader, bridge);
        this.f35063oI0IIXIo = new oIX0oI();
        this.f35061OxxIIOOXO = new II0xO0();
        this.f35057IIXOooo = new I0Io();
        this.f35060Oxx0xo = context;
        this.f35062XO = ksNativeAd;
        this.f35059Oo = mediationAdSlotValueSet;
        this.f35058IXxxXO = z;
        Oo();
    }

    private String IXxxXO() {
        if (this.f35058IXxxXO) {
            return Oxx0xo();
        }
        return oI0IIXIo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0o0xo(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
        if (list != null && list2 != null) {
            list.addAll(list2);
        }
        if (context == null) {
            context = viewGroup.getContext();
        }
        if (viewGroup instanceof FrameLayout) {
            KsNativeAd ksNativeAd = this.f35062XO;
            if (ksNativeAd != null) {
                ksNativeAd.registerViewForInteraction(viewGroup, list, this.f35063oI0IIXIo);
            }
            if (mediationViewBinder != null) {
                oxoX(context, viewGroup, mediationViewBinder);
            }
        }
    }

    private void oxoX(Context context, ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        View II0xO02;
        KsNativeAd ksNativeAd;
        KsNativeAd ksNativeAd2 = this.f35062XO;
        if (ksNativeAd2 != null && ksNativeAd2.getAdSourceLogoUrl(1) != null) {
            View findViewById = viewGroup.findViewById(mediationViewBinder.logoLayoutId);
            if (findViewById != null) {
                findViewById.setVisibility(0);
                if (findViewById instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) findViewById;
                    viewGroup2.removeAllViews();
                    ImageView imageView = new ImageView(context);
                    new xoIox.oIX0oI(imageView).execute(this.f35062XO.getAdSourceLogoUrl(1));
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    viewGroup2.addView(imageView, -1, -1);
                } else if (findViewById instanceof ImageView) {
                    ImageView imageView2 = (ImageView) findViewById;
                    new xoIox.oIX0oI(imageView2).execute(this.f35062XO.getAdSourceLogoUrl(1));
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
            }
            if (!isUseCustomVideo() || (ksNativeAd = this.f35062XO) == null || TextUtils.isEmpty(ksNativeAd.getVideoUrl())) {
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(mediationViewBinder.mediaViewId);
                if (this.f35062XO == null || frameLayout == null || (II0xO02 = II0xO0(context)) == null) {
                    return;
                }
                removeSelfFromParent(II0xO02);
                frameLayout.removeAllViews();
                frameLayout.addView(II0xO02, -1, -1);
            }
        }
    }

    public final View II0xO0(Context context) {
        if (context != null && this.f35062XO != null) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            kSAdVideoPlayConfigImpl.setVideoSoundEnable(!this.f35059Oo.isMuted());
            return this.f35062XO.getVideoView(context, kSAdVideoPlayConfigImpl);
        }
        return null;
    }

    public int OOXIXo() {
        try {
            Integer num = (Integer) ooOOo0oXI.oIX0oI(new X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x01e0, code lost:
    
        if (r1 != null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Oo() {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: xoIox.oxoX.Oo():void");
    }

    public int Oxx0IOOO() {
        try {
            Integer num = (Integer) ooOOo0oXI.oIX0oI(new CallableC1174oxoX()).get(500L, TimeUnit.MILLISECONDS);
            if (num == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final String Oxx0xo() {
        try {
            return (String) ooOOo0oXI.oIX0oI(new II0XooXoX()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r9v6, types: [T, java.util.Map, java.util.HashMap] */
    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Context context;
        KsImage videoCoverImage;
        boolean z;
        KsNativeAd ksNativeAd;
        if (i == 8159) {
            Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
            ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(8067, ViewGroup.class);
            List<View> list = (List) valueSet.objectValue(8068, List.class);
            List<View> list2 = (List) valueSet.objectValue(8069, List.class);
            Bridge bridge = (Bridge) valueSet.objectValue(8071, Bridge.class);
            if (this.f35058IXxxXO) {
                ooOOo0oXI.X0o0xo(new xxIXOIIO(activity, viewGroup, list, list2, bridge));
            } else {
                X0o0xo(activity, viewGroup, list, list2, x0XOIxOo.X0o0xo(bridge));
            }
        } else {
            if (i == 8161) {
                return (T) Integer.valueOf(xxIXOIIO());
            }
            if (i == 8162) {
                return (T) Integer.valueOf(oOoXoXO());
            }
            if (i == 8163) {
                return (T) String.valueOf(oO());
            }
            if (i == 8164) {
                return (T) x0xO0oo();
            }
            if (i == 8320) {
                if (isUseCustomVideo() && (ksNativeAd = this.f35062XO) != null) {
                    return (T) new xoIox.I0Io(ksNativeAd);
                }
            } else if (i == 8109) {
                KsNativeAd ksNativeAd2 = this.f35062XO;
                if (ksNativeAd2 != null) {
                    ksNativeAd2.setVideoPlayListener(null);
                    this.f35062XO = null;
                }
            } else {
                if (i == 8120) {
                    if (this.f35062XO == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    return (T) Boolean.valueOf(z);
                }
                if (i == 8147) {
                    return (T) IXxxXO();
                }
                if (i == 8142) {
                    if (x0XOIxOo.xxIXOIIO(this.f35062XO)) {
                        Map map = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long oxoX2 = x0XOIxOo.oxoX(map);
                            long oOoXoXO2 = x0XOIxOo.oOoXoXO(map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + oxoX2 + " loseBidEcpm = " + oOoXoXO2);
                            KsNativeAd ksNativeAd3 = this.f35062XO;
                            if (ksNativeAd3 != null) {
                                ksNativeAd3.setBidEcpm(oxoX2, oOoXoXO2);
                            }
                        }
                    }
                } else if (i == 8144) {
                    if (x0XOIxOo.x0XOIxOo(this.f35062XO)) {
                        Map map2 = (Map) valueSet.objectValue(8006, Map.class);
                        MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                        if (map2 != null) {
                            int oO2 = x0XOIxOo.oO(map2);
                            int x0xO0oo2 = x0XOIxOo.x0xO0oo(map2);
                            int Oo2 = x0XOIxOo.Oo(map2);
                            String IXxxXO2 = x0XOIxOo.IXxxXO(map2);
                            MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + x0xO0oo2 + " failureCode = " + oO2);
                            if (this.f35062XO != null) {
                                AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                                adExposureFailedReason.setWinEcpm(x0xO0oo2);
                                adExposureFailedReason.setAdnType(Oo2);
                                adExposureFailedReason.setAdnName(IXxxXO2);
                                this.f35062XO.reportAdExposureFailed(oO2, adExposureFailedReason);
                            }
                        }
                    }
                } else {
                    if (i == 6164) {
                        Context context2 = this.f35060Oxx0xo;
                        if (context2 == null) {
                            return null;
                        }
                        return (T) II0xO0(context2);
                    }
                    if (i == 8268) {
                        if (this.f35062XO != null) {
                            return (T) Double.valueOf(r8.getVideoDuration());
                        }
                    } else if (i == 8269) {
                        KsNativeAd ksNativeAd4 = this.f35062XO;
                        if (ksNativeAd4 != null && (videoCoverImage = ksNativeAd4.getVideoCoverImage()) != null) {
                            ?? r9 = (T) new HashMap();
                            r9.put(MediationConstant.VIDEO_COVER_IMG_URL, videoCoverImage.getImageUrl());
                            r9.put(MediationConstant.VIDEO_COVER_IMG_WIDTH, Integer.valueOf(videoCoverImage.getWidth()));
                            r9.put(MediationConstant.VIDEO_COVER_IMG_HEIGHT, Integer.valueOf(videoCoverImage.getHeight()));
                            r9.put(MediationConstant.VIDEO_COVER_IMG_VALID, Boolean.valueOf(videoCoverImage.isValid()));
                            return r9;
                        }
                    } else if (i == 8267 && (context = this.f35060Oxx0xo) != null) {
                        return (T) BitmapFactory.decodeResource(context.getResources(), R.drawable.tt_ks_logo);
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public final String oI0IIXIo() {
        Object obj;
        try {
            KsNativeAd ksNativeAd = this.f35062XO;
            if (ksNativeAd != null && (obj = ksNativeAd.getMediaExtraInfo().get("llsid")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public int oIX0oI() {
        KsNativeAd ksNativeAd = this.f35062XO;
        if (ksNativeAd != null) {
            return ksNativeAd.getVideoWidth();
        }
        return 0;
    }

    public String oO() {
        if (this.f35058IXxxXO) {
            return x0XOIxOo();
        }
        return ooOOo0oXI();
    }

    public int oOoXoXO() {
        if (this.f35058IXxxXO) {
            return OOXIXo();
        }
        return xoIox();
    }

    public String ooOOo0oXI() {
        KsNativeAd ksNativeAd;
        if (isUseCustomVideo() && (ksNativeAd = this.f35062XO) != null) {
            return ksNativeAd.getVideoUrl();
        }
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    public String x0XOIxOo() {
        try {
            return (String) ooOOo0oXI.oIX0oI(new XO()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public IMediationCustomizeVideo x0xO0oo() {
        if (isUseCustomVideo()) {
            return new Oxx0IOOO();
        }
        return null;
    }

    public int xoIox() {
        KsNativeAd ksNativeAd = this.f35062XO;
        if (ksNativeAd != null) {
            return ksNativeAd.getVideoHeight();
        }
        return 0;
    }

    public int xxIXOIIO() {
        if (this.f35058IXxxXO) {
            return Oxx0IOOO();
        }
        return oIX0oI();
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements KsNativeAd.VideoPlayListener {
        public II0xO0() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        @JProtect
        public void onVideoPlayComplete() {
            oxoX.this.notifyOnVideoComplete();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        @JProtect
        public void onVideoPlayError(int i, int i2) {
            oxoX.this.notifyOnVideoError(i, "Android MediaPlay Error Code :" + i2);
        }

        @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
        @JProtect
        public void onVideoPlayStart() {
            oxoX.this.notifyOnVideoStart();
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
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements IMediationCustomizeVideo {
        public Oxx0IOOO() {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public String getVideoUrl() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoFinish() {
            if (oxoX.this.f35062XO != null) {
                oxoX.this.f35062XO.reportAdVideoPlayEnd();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoStart() {
            if (oxoX.this.f35062XO != null) {
                oxoX.this.f35062XO.reportAdVideoPlayStart();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoAutoStart() {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoBreak(long j) {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoContinue(long j) {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoPause(long j) {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoStartError(int i, int i2) {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
        public void reportVideoError(long j, int i, int i2) {
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements KsNativeAd.AdInteractionListener {
        public oIX0oI() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        @JProtect
        public void onAdClicked(View view, KsNativeAd ksNativeAd) {
            oxoX.this.notifyOnClickAd();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        @JProtect
        public void onAdShow(KsNativeAd ksNativeAd) {
            oxoX.this.notifyOnShowAd();
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public void onDownloadTipsDialogShow() {
        }
    }
}
