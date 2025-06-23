package xxIXOIIO;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
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
public class I0Io extends MediationNativeAd {

    /* renamed from: IIXOooo, reason: collision with root package name */
    public NativeADMediaListener f35303IIXOooo;

    /* renamed from: IXxxXO, reason: collision with root package name */
    public FrameLayout.LayoutParams f35304IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public volatile boolean f35305Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public VideoOption f35306Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public Context f35307OxxIIOOXO;

    /* renamed from: XO, reason: collision with root package name */
    public NativeUnifiedADData f35308XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public boolean f35309oI0IIXIo;

    /* renamed from: xxIXOIIO.I0Io$I0Io, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class CallableC1177I0Io implements Callable<String> {
        public CallableC1177I0Io() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public String call() {
            return I0Io.this.IIXOooo();
        }
    }

    /* loaded from: classes.dex */
    public class II0XooXoX implements Runnable {
        public II0XooXoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (I0Io.this.f35308XO != null) {
                I0Io.this.f35308XO.pauseAppDownload();
            }
        }
    }

    /* loaded from: classes.dex */
    public class OOXIXo implements Runnable {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ int f35314XO;

        public OOXIXo(int i) {
            this.f35314XO = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            I0Io.this.f35308XO.sendLossNotification(0, this.f35314XO, null);
        }
    }

    /* loaded from: classes.dex */
    public class Oxx0IOOO implements Callable<Integer> {
        public Oxx0IOOO() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            return Integer.valueOf(I0Io.this.OOXIXo());
        }
    }

    /* loaded from: classes.dex */
    public class X0o0xo implements Runnable {
        public X0o0xo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (I0Io.this.f35308XO != null) {
                I0Io.this.f35308XO.pauseVideo();
            }
        }
    }

    /* loaded from: classes.dex */
    public class XO implements Runnable {
        public XO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (I0Io.this.f35308XO != null) {
                I0Io.this.f35308XO.destroy();
            }
        }
    }

    /* loaded from: classes.dex */
    public class oO implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ MediaView f35320XO;

        public oO(MediaView mediaView) {
            this.f35320XO = mediaView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f35320XO.getVisibility() == 0) {
                if (I0Io.this.f35308XO != null) {
                    I0Io.this.f35308XO.bindMediaView(this.f35320XO, I0Io.this.IXxxXO(), I0Io.this.f35303IIXOooo);
                }
                if (this.f35320XO.getViewTreeObserver() != null) {
                    this.f35320XO.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class oOoXoXO implements Runnable {
        public oOoXoXO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (I0Io.this.f35308XO != null) {
                I0Io.this.f35308XO.negativeFeedback();
            }
        }
    }

    /* loaded from: classes.dex */
    public class ooOOo0oXI implements Runnable {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public final /* synthetic */ List f35323IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f35324Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public final /* synthetic */ List f35325Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public final /* synthetic */ Bridge f35326OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public final /* synthetic */ Activity f35327XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public final /* synthetic */ List f35328oI0IIXIo;

        public ooOOo0oXI(Activity activity, ViewGroup viewGroup, List list, List list2, List list3, Bridge bridge) {
            this.f35327XO = activity;
            this.f35324Oo = viewGroup;
            this.f35323IXxxXO = list;
            this.f35325Oxx0xo = list2;
            this.f35328oI0IIXIo = list3;
            this.f35326OxxIIOOXO = bridge;
        }

        @Override // java.lang.Runnable
        public void run() {
            I0Io.this.oxoX(this.f35327XO, this.f35324Oo, this.f35323IXxxXO, this.f35325Oxx0xo, this.f35328oI0IIXIo, xxIXOIIO.oIX0oI.II0xO0(this.f35326OxxIIOOXO));
        }
    }

    /* loaded from: classes.dex */
    public class oxoX implements Runnable {
        public oxoX() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (I0Io.this.f35308XO != null) {
                I0Io.this.f35308XO.resume();
            }
        }
    }

    /* loaded from: classes.dex */
    public class x0XOIxOo implements Callable<MediationConstant.AdIsReadyStatus> {
        public x0XOIxOo() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: oIX0oI, reason: merged with bridge method [inline-methods] */
        public MediationConstant.AdIsReadyStatus call() {
            return I0Io.this.oO();
        }
    }

    /* loaded from: classes.dex */
    public class xoIox implements Runnable {
        public xoIox() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I0Io.this.f35308XO.sendWinNotification((int) I0Io.this.getCpm());
        }
    }

    /* loaded from: classes.dex */
    public class xxIXOIIO implements Runnable {
        public xxIXOIIO() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (I0Io.this.f35308XO != null) {
                I0Io.this.f35308XO.resumeAppDownload();
            }
        }
    }

    public I0Io(Context context, MediationAdLoaderImpl mediationAdLoaderImpl, Bridge bridge, NativeUnifiedADData nativeUnifiedADData, FrameLayout.LayoutParams layoutParams, VideoOption videoOption, boolean z) {
        super(mediationAdLoaderImpl, bridge);
        this.f35305Oo = false;
        this.f35303IIXOooo = new II0xO0();
        this.f35307OxxIIOOXO = context;
        this.f35308XO = nativeUnifiedADData;
        this.f35304IXxxXO = layoutParams;
        this.f35306Oxx0xo = videoOption;
        this.f35309oI0IIXIo = z;
        II0XooXoX();
    }

    private void II0XooXoX() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        NativeUnifiedADAppMiitInfo appMiitInfo = this.f35308XO.getAppMiitInfo();
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
        create.add(8045, this.f35308XO.getTitle());
        create.add(8046, this.f35308XO.getDesc());
        create.add(8061, this.f35308XO.getCTAText());
        create.add(8048, this.f35308XO.getIconUrl());
        create.add(8050, this.f35308XO.getImgUrl());
        create.add(8052, this.f35308XO.getPictureWidth());
        create.add(8051, this.f35308XO.getPictureHeight());
        create.add(8053, this.f35308XO.getImgList());
        create.add(8082, this.f35308XO.getAppScore());
        create.add(8049, this.f35308XO.getTitle());
        create.add(8055, this.f35308XO.isAppAd());
        if (isClientBidding()) {
            create.add(8016, Math.max(this.f35308XO.getECPM(), XIXIX.OOXIXo.f3760XO));
        } else if (isMultiBidding()) {
            create.add(8058, this.f35308XO.getECPMLevel());
        }
        if (this.f35308XO.getAdPatternType() == 2) {
            create.add(8060, 5);
        } else if (this.f35308XO.getAdPatternType() != 4 && this.f35308XO.getAdPatternType() != 1) {
            if (this.f35308XO.getAdPatternType() == 3) {
                create.add(8060, 4);
            }
        } else {
            create.add(8060, 3);
        }
        if (this.f35308XO.isAppAd()) {
            create.add(8059, 4);
        } else {
            create.add(8059, 3);
        }
        create.add(8033, false);
        notifyNativeValue(create.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int OOXIXo() {
        NativeUnifiedADData nativeUnifiedADData = this.f35308XO;
        if (nativeUnifiedADData != null) {
            int appStatus = nativeUnifiedADData.getAppStatus();
            if (appStatus == 0) {
                return 0;
            }
            if (appStatus == 1) {
                return 6;
            }
            if (appStatus == 2) {
                return 8;
            }
            if (appStatus == 4) {
                return 2;
            }
            if (appStatus == 8) {
                return 5;
            }
            if (appStatus == 16) {
                return 4;
            }
            if (appStatus == 32) {
                return 3;
            }
            if (appStatus == 64) {
                return 7;
            }
        }
        return 1;
    }

    private MediationConstant.AdIsReadyStatus Oo() {
        try {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) xxIXOIIO.oOoXoXO.oIX0oI(new x0XOIxOo()).get(500L, TimeUnit.MILLISECONDS);
            if (adIsReadyStatus != null) {
                return adIsReadyStatus;
            }
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        } catch (Exception e) {
            e.printStackTrace();
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }
    }

    private String OxxIIOOXO() {
        try {
            return (String) xxIXOIIO.oOoXoXO.oIX0oI(new CallableC1177I0Io()).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String oI0IIXIo() {
        if (this.f35309oI0IIXIo) {
            return OxxIIOOXO();
        }
        return IIXOooo();
    }

    private int ooOOo0oXI() {
        try {
            Integer num = (Integer) xxIXOIIO.oOoXoXO.oIX0oI(new Oxx0IOOO()).get(500L, TimeUnit.MILLISECONDS);
            if (num == null) {
                return 1;
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oxoX(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
        NativeAdContainer nativeAdContainer;
        Object tag;
        NativeUnifiedADData nativeUnifiedADData;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        if (isServerBidding() && (nativeUnifiedADData = this.f35308XO) != null) {
            nativeUnifiedADData.setBidECPM(nativeUnifiedADData.getECPM());
        }
        if (this.f35308XO != null && (viewGroup instanceof FrameLayout)) {
            if (context == null) {
                context = viewGroup.getContext();
            }
            ViewGroup viewGroup2 = (FrameLayout) viewGroup;
            int i = 0;
            if (viewGroup2.getChildAt(0) instanceof NativeAdContainer) {
                nativeAdContainer = (NativeAdContainer) viewGroup2.getChildAt(0);
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
                while (viewGroup2.getChildCount() > 0) {
                    View childAt2 = viewGroup2.getChildAt(0);
                    childAt2.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, MediationConstant.TT_GDT_NATIVE_VIEW_TAG);
                    viewGroup2.removeViewInLayout(childAt2);
                    nativeAdContainer.addView(childAt2, childAt2.getLayoutParams());
                }
                viewGroup2.removeAllViews();
                viewGroup2.addView(nativeAdContainer, -1, -1);
            }
            this.f35308XO.bindAdToView(context, nativeAdContainer, this.f35304IXxxXO, list, list2);
            if (mediationViewBinder != null) {
                I0Io(context, viewGroup2, mediationViewBinder);
            } else {
                X0o0xo(list2);
            }
            this.f35308XO.setNativeAdEventListener(new oIX0oI());
        }
    }

    private int xxIXOIIO() {
        if (this.f35309oI0IIXIo) {
            return ooOOo0oXI();
        }
        return OOXIXo();
    }

    public final void I0Io(Context context, ViewGroup viewGroup, MediationViewBinder mediationViewBinder) {
        if (viewGroup != null && mediationViewBinder != null) {
            FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(mediationViewBinder.mediaViewId);
            if (frameLayout != null && getImageMode() == 5) {
                MediaView mediaView = new MediaView(context);
                frameLayout.removeAllViews();
                frameLayout.addView(mediaView, -1, -1);
                this.f35308XO.bindMediaView(mediaView, IXxxXO(), this.f35303IIXOooo);
            }
            if (!TextUtils.isEmpty(this.f35308XO.getCTAText())) {
                View findViewById = viewGroup.findViewById(mediationViewBinder.callToActionId);
                ArrayList arrayList = new ArrayList();
                arrayList.add(findViewById);
                this.f35308XO.bindCTAViews(arrayList);
            }
        }
    }

    public MediationConstant.AdIsReadyStatus II0xO0() {
        if (this.f35309oI0IIXIo) {
            return Oo();
        }
        return oO();
    }

    public final String IIXOooo() {
        Object obj;
        try {
            NativeUnifiedADData nativeUnifiedADData = this.f35308XO;
            if (nativeUnifiedADData != null && (obj = nativeUnifiedADData.getExtraInfo().get("request_id")) != null) {
                return obj.toString();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final VideoOption IXxxXO() {
        VideoOption videoOption = this.f35306Oxx0xo;
        if (videoOption == null) {
            return new VideoOption.Builder().build();
        }
        return videoOption;
    }

    public final MediaView Oxx0xo() {
        if (this.f35307OxxIIOOXO != null) {
            MediaView mediaView = new MediaView(this.f35307OxxIIOOXO);
            mediaView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (mediaView.getViewTreeObserver() != null) {
                mediaView.getViewTreeObserver().addOnGlobalLayoutListener(new oO(mediaView));
            }
            return mediaView;
        }
        return null;
    }

    public final void X0o0xo(List<View> list) {
        NativeUnifiedADData nativeUnifiedADData;
        if (list != null && (nativeUnifiedADData = this.f35308XO) != null && !TextUtils.isEmpty(nativeUnifiedADData.getCTAText())) {
            this.f35308XO.bindCTAViews(list);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Context context;
        Runnable oooxoxo;
        if (i == 8148) {
            if (this.f35309oI0IIXIo) {
                oooxoxo = new oxoX();
            } else {
                NativeUnifiedADData nativeUnifiedADData = this.f35308XO;
                if (nativeUnifiedADData != null) {
                    nativeUnifiedADData.resume();
                }
                return (T) MediationValueUtil.checkClassType(cls);
            }
        } else if (i == 8149) {
            if (this.f35309oI0IIXIo) {
                oooxoxo = new X0o0xo();
            } else {
                NativeUnifiedADData nativeUnifiedADData2 = this.f35308XO;
                if (nativeUnifiedADData2 != null) {
                    nativeUnifiedADData2.pauseVideo();
                }
                return (T) MediationValueUtil.checkClassType(cls);
            }
        } else {
            if (i == 8109) {
                this.f35305Oo = true;
                new Handler(Looper.getMainLooper()).post(new XO());
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.f35305Oo);
                }
                if (i == 8191) {
                    if (this.f35309oI0IIXIo) {
                        oooxoxo = new II0XooXoX();
                    } else {
                        NativeUnifiedADData nativeUnifiedADData3 = this.f35308XO;
                        if (nativeUnifiedADData3 != null) {
                            nativeUnifiedADData3.pauseAppDownload();
                        }
                    }
                } else if (i == 8192) {
                    if (this.f35309oI0IIXIo) {
                        oooxoxo = new xxIXOIIO();
                    } else {
                        NativeUnifiedADData nativeUnifiedADData4 = this.f35308XO;
                        if (nativeUnifiedADData4 != null) {
                            nativeUnifiedADData4.resumeAppDownload();
                        }
                    }
                } else {
                    if (i == 8193) {
                        return (T) Integer.valueOf(xxIXOIIO());
                    }
                    if (i == 8121) {
                        return (T) II0xO0();
                    }
                    try {
                        if (i == 8142) {
                            NativeUnifiedADData nativeUnifiedADData5 = this.f35308XO;
                            if (nativeUnifiedADData5 != null) {
                                if (this.f35309oI0IIXIo) {
                                    xxIXOIIO.oOoXoXO.I0Io(new xoIox());
                                } else {
                                    nativeUnifiedADData5.sendWinNotification((int) getCpm());
                                }
                            }
                        } else if (i == 8144) {
                            Map map = (Map) valueSet.objectValue(8006, Map.class);
                            if (map != null && this.f35308XO != null) {
                                Object obj = map.get(MediationConstant.BIDDING_LOSE_REASON);
                                if (obj instanceof MediationConstant.BiddingLossReason) {
                                    int oIX0oI2 = xxIXOIIO.oIX0oI.oIX0oI((MediationConstant.BiddingLossReason) obj);
                                    if (this.f35309oI0IIXIo) {
                                        xxIXOIIO.oOoXoXO.I0Io(new OOXIXo(oIX0oI2));
                                    } else {
                                        this.f35308XO.sendLossNotification(0, oIX0oI2, null);
                                    }
                                }
                            }
                        } else if (i == 8194) {
                            if (this.f35309oI0IIXIo) {
                                oooxoxo = new oOoXoXO();
                            } else {
                                NativeUnifiedADData nativeUnifiedADData6 = this.f35308XO;
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
                            if (this.f35309oI0IIXIo) {
                                xxIXOIIO.oOoXoXO.X0o0xo(new ooOOo0oXI(activity, viewGroup, list, list2, list3, bridge));
                            } else {
                                oxoX(activity, viewGroup, list, list2, list3, xxIXOIIO.oIX0oI.II0xO0(bridge));
                            }
                        } else {
                            if (i == 8147) {
                                return (T) oI0IIXIo();
                            }
                            if (i == 6164) {
                                if (this.f35307OxxIIOOXO == null) {
                                    return null;
                                }
                                return (T) Oxx0xo();
                            }
                            if (i == 8268) {
                                if (this.f35308XO != null) {
                                    return (T) Double.valueOf(r9.getVideoDuration());
                                }
                            } else if (i != 8269 && i == 8267 && (context = this.f35307OxxIIOOXO) != null) {
                                return (T) BitmapFactory.decodeResource(context.getResources(), R.drawable.tt_gdt_logo);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }
        xxIXOIIO.oOoXoXO.X0o0xo(oooxoxo);
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public final MediationConstant.AdIsReadyStatus oO() {
        NativeUnifiedADData nativeUnifiedADData = this.f35308XO;
        if (nativeUnifiedADData != null && nativeUnifiedADData.isValid()) {
            return MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }
        return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    /* loaded from: classes.dex */
    public class II0xO0 implements NativeADMediaListener {
        public II0xO0() {
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoClicked() {
            I0Io.this.notifyOnClickAd();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoCompleted() {
            I0Io.this.notifyOnVideoComplete();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoError(AdError adError) {
            if (adError != null) {
                I0Io.this.notifyOnVideoError(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                I0Io.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "error is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoPause() {
            I0Io.this.notifyOnVideoPause();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoResume() {
            I0Io.this.notifyOnVideoResume();
        }

        @Override // com.qq.e.ads.nativ.NativeADMediaListener
        @JProtect
        public void onVideoStart() {
            I0Io.this.notifyOnVideoStart();
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
    public class oIX0oI implements NativeADEventListener {
        public oIX0oI() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADClicked() {
            I0Io.this.notifyOnClickAd();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADExposed() {
            I0Io.this.notifyOnShowAd();
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADStatusChanged() {
        }

        @Override // com.qq.e.ads.nativ.NativeADEventListener
        public void onADError(AdError adError) {
        }
    }
}
