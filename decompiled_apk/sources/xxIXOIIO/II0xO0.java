package xxIXOIIO;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.R;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class II0xO0 extends MediationNativeAd {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public VideoOption f35349IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public volatile boolean f35350Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f35351Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public NativeUnifiedADData f35352XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public NativeADMediaListener f35353oI0IIXIo;

    /* loaded from: classes.dex */
    public class I0Io implements Runnable {
        public I0Io() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f35352XO != null) {
                II0xO0.this.f35352XO.pauseAppDownload();
            }
        }
    }

    /* loaded from: classes.dex */
    public class II0XooXoX implements Runnable {
        public II0XooXoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f35352XO != null) {
                II0xO0.this.f35352XO.negativeFeedback();
            }
        }
    }

    /* renamed from: xxIXOIIO.II0xO0$II0xO0, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC1179II0xO0 implements Runnable {
        public RunnableC1179II0xO0() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f35352XO != null) {
                II0xO0.this.f35352XO.destroy();
            }
        }
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f35359XO;

        public Oxx0IOOO(int i) {
            this.f35359XO = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0xO0.this.f35352XO.sendLossNotification(0, this.f35359XO, null);
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Callable<MediationConstant.AdIsReadyStatus> {
        public X0o0xo() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public MediationConstant.AdIsReadyStatus call() {
            return II0xO0.this.X0o0xo();
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Runnable {
        public XO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            II0xO0.this.f35352XO.sendWinNotification((int) II0xO0.this.getCpm());
        }
    }

    /* loaded from: classes.dex */
    public class oIX0oI implements Runnable {
        public oIX0oI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f35352XO != null) {
                II0xO0.this.f35352XO.pauseVideo();
            }
        }
    }

    /* loaded from: classes.dex */
    public class oOoXoXO implements Callable<String> {
        public oOoXoXO() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return II0xO0.this.OOXIXo();
        }
    }

    /* loaded from: classes.dex */
    public class ooOOo0oXI implements Runnable {
        public ooOOo0oXI() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f35352XO != null) {
                II0xO0.this.f35352XO.resume();
            }
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (II0xO0.this.f35352XO != null) {
                II0xO0.this.f35352XO.resumeAppDownload();
            }
        }
    }

    /* loaded from: classes.dex */
    public class xxIXOIIO implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ List f35368IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f35369Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ List f35370Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final /* synthetic */ Bridge f35371OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Activity f35372XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ List f35373oI0IIXIo;

        public xxIXOIIO(Activity activity, ViewGroup viewGroup, List list, List list2, List list3, Bridge bridge) {
            this.f35372XO = activity;
            this.f35369Oo = viewGroup;
            this.f35368IXxxXO = list;
            this.f35370Oxx0xo = list2;
            this.f35373oI0IIXIo = list3;
            this.f35371OxxIIOOXO = bridge;
        }

        @Override // java.lang.Runnable
        public void run() {
            II0xO0.this.I0Io(this.f35372XO, this.f35369Oo, this.f35368IXxxXO, this.f35370Oxx0xo, this.f35373oI0IIXIo, xxIXOIIO.oIX0oI.II0xO0(this.f35371OxxIIOOXO));
        }
    }

    public II0xO0(NativeUnifiedADData nativeUnifiedADData, MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge, VideoOption videoOption, boolean z) {
        super(mediationAdLoaderImpl, bridge);
        this.f35350Oo = false;
        this.f35353oI0IIXIo = new OOXIXo();
        this.f35352XO = nativeUnifiedADData;
        this.f35349IXxxXO = videoOption;
        this.f35351Oxx0xo = z;
        II0XooXoX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0Io(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        NativeAdContainer nativeAdContainer;
        Object tag;
        NativeUnifiedADData nativeUnifiedADData;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        List<View> list4 = list2;
        if (isServerBidding() && (nativeUnifiedADData = this.f35352XO) != null) {
            nativeUnifiedADData.setBidECPM(nativeUnifiedADData.getECPM());
        }
        if (this.f35352XO != null && (viewGroup instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) viewGroup;
            int i = 0;
            if (frameLayout.getChildAt(0) instanceof NativeAdContainer) {
                nativeAdContainer = (NativeAdContainer) frameLayout.getChildAt(0);
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
                while (frameLayout.getChildCount() > 0) {
                    View childAt2 = frameLayout.getChildAt(0);
                    childAt2.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                    frameLayout.removeViewInLayout(childAt2);
                    nativeAdContainer.addView(childAt2, childAt2.getLayoutParams());
                }
                frameLayout.removeAllViews();
                frameLayout.addView(nativeAdContainer, -1, -1);
            }
            NativeAdContainer nativeAdContainer2 = nativeAdContainer;
            FrameLayout frameLayout2 = (FrameLayout) frameLayout.findViewById(mediationViewBinder.mediaViewId);
            this.f35352XO.bindAdToView(context, nativeAdContainer2, null, list, list4);
            VideoOption videoOption = this.f35349IXxxXO;
            if (videoOption == null) {
                videoOption = new VideoOption.Builder().build();
            }
            if (frameLayout2 != null && getImageMode() == 5) {
                MediaView mediaView = new MediaView(context);
                frameLayout2.removeAllViews();
                frameLayout2.addView(mediaView, -1, -1);
                this.f35352XO.bindMediaView(mediaView, videoOption, this.f35353oI0IIXIo);
            }
            if (!TextUtils.isEmpty(this.f35352XO.getCTAText())) {
                View findViewById = frameLayout.findViewById(mediationViewBinder.callToActionId);
                ArrayList arrayList = new ArrayList();
                arrayList.add(findViewById);
                this.f35352XO.bindCTAViews(arrayList);
            }
            this.f35352XO.setNativeAdEventListener(new xoIox());
        }
    }

    private void II0XooXoX() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        NativeUnifiedADAppMiitInfo appMiitInfo = this.f35352XO.getAppMiitInfo();
        if (appMiitInfo != null) {
            create.add(8056, appMiitInfo.getAppName());
            create.add(8057, appMiitInfo.getAuthorName());
            create.add(8078, appMiitInfo.getPackageSizeBytes());
            create.add(8079, appMiitInfo.getPermissionsUrl());
            create.add(8080, appMiitInfo.getPrivacyAgreement());
            create.add(8081, appMiitInfo.getVersionName());
            try {
                create.add(8551, appMiitInfo.getDescriptionUrl());
            } catch (Throwable unused) {
            }
        }
        create.add(8045, this.f35352XO.getTitle());
        create.add(8046, this.f35352XO.getDesc());
        create.add(8061, this.f35352XO.getCTAText());
        create.add(8048, this.f35352XO.getIconUrl());
        create.add(8050, this.f35352XO.getImgUrl());
        create.add(8052, this.f35352XO.getPictureWidth());
        create.add(8051, this.f35352XO.getPictureHeight());
        create.add(8053, this.f35352XO.getImgList());
        create.add(8082, this.f35352XO.getAppScore());
        create.add(8049, this.f35352XO.getTitle());
        create.add(8055, this.f35352XO.isAppAd());
        if (isClientBidding()) {
            create.add(8016, Math.max(this.f35352XO.getECPM(), XIXIX.OOXIXo.f3760XO));
        } else if (isMultiBidding()) {
            create.add(8058, this.f35352XO.getECPMLevel());
        }
        if (this.f35352XO.getAdPatternType() == 2) {
            create.add(8060, 5);
        } else if (this.f35352XO.getAdPatternType() != 4 && this.f35352XO.getAdPatternType() != 1) {
            if (this.f35352XO.getAdPatternType() == 3) {
                create.add(8060, 4);
            }
        } else {
            create.add(8060, 3);
        }
        if (this.f35352XO.isAppAd()) {
            create.add(8059, 4);
        } else {
            create.add(8059, 3);
        }
        create.add(8033, false);
        notifyNativeValue(create.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String OOXIXo() {
        Object obj;
        try {
            NativeUnifiedADData nativeUnifiedADData = this.f35352XO;
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
            return (String) xxIXOIIO.oOoXoXO.oIX0oI(new oOoXoXO()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String xxIXOIIO() {
        if (this.f35351Oxx0xo) {
            return xoIox();
        }
        return OOXIXo();
    }

    public MediationConstant.AdIsReadyStatus Oxx0IOOO() {
        try {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) xxIXOIIO.oOoXoXO.oIX0oI(new X0o0xo()).get(500L, TimeUnit.MILLISECONDS);
            if (adIsReadyStatus != null) {
                return adIsReadyStatus;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        } catch (Exception e) {
            e.printStackTrace();
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }
    }

    public MediationConstant.AdIsReadyStatus X0o0xo() {
        NativeUnifiedADData nativeUnifiedADData = this.f35352XO;
        if (nativeUnifiedADData != null && nativeUnifiedADData.isValid()) {
            return MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }
        return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Runnable iI0XooXoX;
        if (i == 8148) {
            if (this.f35351Oxx0xo) {
                iI0XooXoX = new ooOOo0oXI();
            } else {
                NativeUnifiedADData nativeUnifiedADData = this.f35352XO;
                if (nativeUnifiedADData != null) {
                    nativeUnifiedADData.resume();
                }
                return (T) MediationValueUtil.checkClassType(cls);
            }
        } else if (i == 8149) {
            if (this.f35351Oxx0xo) {
                iI0XooXoX = new oIX0oI();
            } else {
                NativeUnifiedADData nativeUnifiedADData2 = this.f35352XO;
                if (nativeUnifiedADData2 != null) {
                    nativeUnifiedADData2.pauseVideo();
                }
                return (T) MediationValueUtil.checkClassType(cls);
            }
        } else {
            if (i == 8109) {
                this.f35350Oo = true;
                new Handler(Looper.getMainLooper()).post(new RunnableC1179II0xO0());
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.f35350Oo);
                }
                if (i == 8191) {
                    if (this.f35351Oxx0xo) {
                        iI0XooXoX = new I0Io();
                    } else {
                        NativeUnifiedADData nativeUnifiedADData3 = this.f35352XO;
                        if (nativeUnifiedADData3 != null) {
                            nativeUnifiedADData3.pauseAppDownload();
                        }
                    }
                } else if (i == 8192) {
                    if (this.f35351Oxx0xo) {
                        iI0XooXoX = new oxoX();
                    } else {
                        NativeUnifiedADData nativeUnifiedADData4 = this.f35352XO;
                        if (nativeUnifiedADData4 != null) {
                            nativeUnifiedADData4.resumeAppDownload();
                        }
                    }
                } else {
                    if (i == 8121) {
                        return (T) oIX0oI();
                    }
                    try {
                        if (i == 8142) {
                            NativeUnifiedADData nativeUnifiedADData5 = this.f35352XO;
                            if (nativeUnifiedADData5 != null) {
                                if (this.f35351Oxx0xo) {
                                    xxIXOIIO.oOoXoXO.I0Io(new XO());
                                } else {
                                    nativeUnifiedADData5.sendWinNotification((int) getCpm());
                                }
                            }
                        } else if (i == 8144) {
                            Map map = (Map) valueSet.objectValue(8006, Map.class);
                            if (map != null && this.f35352XO != null) {
                                Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
                                if (obj instanceof MediationConstant.BiddingLossReason) {
                                    int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                                    if (this.f35351Oxx0xo) {
                                        xxIXOIIO.oOoXoXO.I0Io(new Oxx0IOOO(oIX0oI2));
                                    } else {
                                        this.f35352XO.sendLossNotification(0, oIX0oI2, null);
                                    }
                                }
                            }
                        } else if (i == 8194) {
                            if (this.f35351Oxx0xo) {
                                iI0XooXoX = new II0XooXoX();
                            } else {
                                NativeUnifiedADData nativeUnifiedADData6 = this.f35352XO;
                                if (nativeUnifiedADData6 != null) {
                                    nativeUnifiedADData6.negativeFeedback();
                                }
                            }
                        } else if (i == 8159) {
                            Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                            ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(8067, ViewGroup.class);
                            List<View> list = (List) valueSet.objectValue(8068, List.class);
                            List<View> list2 = (List) valueSet.objectValue(8069, List.class);
                            List<View> list3 = (List) valueSet.objectValue(8070, List.class);
                            Bridge bridge = (Bridge) valueSet.objectValue(8071, Bridge.class);
                            if (this.f35351Oxx0xo) {
                                xxIXOIIO.oOoXoXO.X0o0xo(new xxIXOIIO(activity, viewGroup, list, list2, list3, bridge));
                            } else {
                                I0Io(activity, viewGroup, list, list2, list3, xxIXOIIO.oIX0oI.II0xO0(bridge));
                            }
                        } else if (i == 8147) {
                            return (T) xxIXOIIO();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }
        xxIXOIIO.oOoXoXO.X0o0xo(iI0XooXoX);
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public MediationConstant.AdIsReadyStatus oIX0oI() {
        if (this.f35351Oxx0xo) {
            return Oxx0IOOO();
        }
        return X0o0xo();
    }

    /* loaded from: classes.dex */
    public class OOXIXo implements NativeADMediaListener {
        public OOXIXo() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoClicked() {
            II0xO0.this.notifyOnClickAd();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoCompleted() {
            II0xO0.this.notifyOnVideoComplete();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoError(AdError adError) {
            if (adError != null) {
                II0xO0.this.notifyOnVideoError(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                II0xO0.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "error is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoPause() {
            II0xO0.this.notifyOnVideoPause();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoResume() {
            II0xO0.this.notifyOnVideoResume();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoStart() {
            II0xO0.this.notifyOnVideoStart();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoInit() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoading() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoReady() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoStop() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        public void onVideoLoaded(int i) {
        }
    }

    /* loaded from: classes.dex */
    public class xoIox implements NativeADEventListener {
        public xoIox() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            II0xO0.this.notifyOnClickAd();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            II0xO0.this.notifyOnShowAd();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
        }
    }
}
