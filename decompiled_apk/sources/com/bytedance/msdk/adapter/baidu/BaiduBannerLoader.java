package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.mobads.sdk.api.AdView;
import com.baidu.mobads.sdk.api.AdViewListener;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.DislikeEvent;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.StyleParams;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class BaiduBannerLoader extends BaiduBaseLoader {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f10376IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public Bridge f10377Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public boolean f10378Oxx0xo;

    /* renamed from: OxxIIOOXO, reason: collision with root package name */
    public final BaiduNativeManager.ExpressAdListener f10379OxxIIOOXO = new BaiduNativeManager.ExpressAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.1
        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        @JProtect
        public void onNativeFail(int i, String str) {
            BaiduBannerLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        @JProtect
        public void onNativeLoad(List<ExpressResponse> list) {
            if (list == null || list.size() <= 0) {
                BaiduBannerLoader.this.notifyAdFailed(80001, "load成功，但list为空");
                return;
            }
            for (ExpressResponse expressResponse : list) {
                if (expressResponse != null) {
                    new BaiduNativeExpressAd(expressResponse).render();
                    return;
                }
            }
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        @JProtect
        public void onNoAd(int i, String str) {
            BaiduBannerLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadSuccess() {
        }
    };

    /* renamed from: XO, reason: collision with root package name */
    public MediationAdSlotValueSet f10380XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public WeakReference<Context> f10381oI0IIXIo;

    /* loaded from: classes8.dex */
    public class BaiduBannerAd extends MediationBaseAdBridge implements AdViewListener {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public boolean f10386IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f10387Oo;

        /* renamed from: Oxx0xo, reason: collision with root package name */
        public boolean f10388Oxx0xo;

        /* renamed from: OxxIIOOXO, reason: collision with root package name */
        public volatile boolean f10389OxxIIOOXO;

        /* renamed from: XO, reason: collision with root package name */
        public AdView f10390XO;

        /* renamed from: oI0IIXIo, reason: collision with root package name */
        public VisibleStateFrameLayout f10391oI0IIXIo;

        public BaiduBannerAd() {
            super(BaiduBannerLoader.this.f10380XO, BaiduBannerLoader.this.f10377Oo);
            this.f10389OxxIIOOXO = false;
        }

        @JProtect
        public void II0xO0(Context context) {
            BaiduBannerLoader baiduBannerLoader;
            String str;
            if (context instanceof Activity) {
                this.f10390XO = new AdView(context.getApplicationContext(), null, false, AdSize.Banner, BaiduBannerLoader.this.getAdnId());
                if (!TextUtils.isEmpty(BaiduBannerLoader.this.f10380XO.getBaiduAppSid())) {
                    this.f10390XO.setAppSid(BaiduBannerLoader.this.f10380XO.getBaiduAppSid());
                }
                this.f10390XO.setListener(this);
                Activity activity = (Activity) context;
                if (activity != null && activity.getWindow() != null && (activity.getWindow().getDecorView() instanceof ViewGroup)) {
                    this.f10391oI0IIXIo = new VisibleStateFrameLayout(context);
                    this.f10391oI0IIXIo.addView(this.f10390XO, new FrameLayout.LayoutParams(-1, -1));
                    this.f10391oI0IIXIo.setVisibility(4);
                    final ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    viewGroup.addView(this.f10391oI0IIXIo);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduBannerAd.1
                        @Override // java.lang.Runnable
                        public void run() {
                            viewGroup.removeView(BaiduBannerAd.this.f10391oI0IIXIo);
                        }
                    }, 100L);
                    return;
                }
                baiduBannerLoader = BaiduBannerLoader.this;
                str = "上下文为null，无法加载百度Banner";
            } else {
                baiduBannerLoader = BaiduBannerLoader.this;
                str = "Context必须为Activity，其他类型不支持百度Banner广告";
            }
            baiduBannerLoader.notifyAdFailed(80001, str);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 6081) {
                return (T) getAdView();
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @JProtect
        public View getAdView() {
            if (this.f10388Oxx0xo || !this.f10387Oo) {
                return null;
            }
            this.f10391oI0IIXIo.setVisibility(0);
            BaiduBannerLoader.this.removeSelfFromParent(this.f10391oI0IIXIo);
            this.f10391oI0IIXIo.setVisibilityChanged(new VisibleStateFrameLayout.VisibilityChanged() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduBannerAd.3
                @Override // com.bytedance.msdk.adapter.baidu.VisibleStateFrameLayout.VisibilityChanged
                public void callback(boolean z) {
                    Bridge bridge;
                    if (!z || (bridge = BaiduBannerAd.this.mGMAd) == null) {
                        return;
                    }
                    bridge.call(1008, null, Void.class);
                }
            });
            return this.f10391oI0IIXIo;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f10389OxxIIOOXO;
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdClick(JSONObject jSONObject) {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1009, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdClose(JSONObject jSONObject) {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1014, null, Void.class);
            }
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdFailed(String str) {
            this.f10388Oxx0xo = true;
            if (this.f10386IXxxXO) {
                return;
            }
            this.f10386IXxxXO = true;
            BaiduBannerLoader.this.notifyAdFailed(80001, str);
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdReady(AdView adView) {
            this.f10387Oo = true;
            if (this.f10386IXxxXO) {
                return;
            }
            this.f10386IXxxXO = true;
            BaiduBannerLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        @JProtect
        public void onAdShow(JSONObject jSONObject) {
        }

        @Override // com.baidu.mobads.sdk.api.AdViewListener
        public void onAdSwitch() {
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            this.f10389OxxIIOOXO = true;
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduBannerAd.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BaiduBannerAd.this.f10390XO != null) {
                        BaiduBannerAd.this.f10390XO.destroy();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class BaiduNativeAd extends MediationBaseAdBridge {

        /* renamed from: IXxxXO, reason: collision with root package name */
        public boolean f10396IXxxXO;

        /* renamed from: Oo, reason: collision with root package name */
        public FeedNativeView f10397Oo;

        /* renamed from: XO, reason: collision with root package name */
        public XAdNativeResponse f10399XO;

        public BaiduNativeAd(XAdNativeResponse xAdNativeResponse, Context context) {
            super(BaiduBannerLoader.this.f10380XO, BaiduBannerLoader.this.f10377Oo);
            double d;
            this.f10396IXxxXO = false;
            this.f10399XO = xAdNativeResponse;
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8045, xAdNativeResponse.getTitle());
            create.add(8046, xAdNativeResponse.getDesc());
            create.add(8047, (int) xAdNativeResponse.getAppSize());
            create.add(8048, xAdNativeResponse.getIconUrl());
            create.add(8049, xAdNativeResponse.getBrandName());
            create.add(8050, xAdNativeResponse.getImageUrl());
            create.add(8051, xAdNativeResponse.getMainPicHeight());
            create.add(8052, xAdNativeResponse.getMainPicWidth());
            create.add(8053, xAdNativeResponse.getMultiPicUrls());
            create.add(8054, xAdNativeResponse.getAppPackage());
            create.add(8055, BaiduAdapterUtil.isDownloadAd(xAdNativeResponse));
            create.add(8056, xAdNativeResponse.getBrandName());
            create.add(8057, xAdNativeResponse.getPublisher());
            create.add(8079, xAdNativeResponse.getAppPermissionLink());
            create.add(8080, xAdNativeResponse.getAppPrivacyLink());
            try {
                create.add(8551, xAdNativeResponse.getAppFunctionLink());
            } catch (Throwable unused) {
            }
            create.add(8078, xAdNativeResponse.getAppSize());
            List<DislikeEvent> dislikeList = xAdNativeResponse.getDislikeList();
            if (dislikeList != null && dislikeList.size() > 0) {
                create.add(8036, dislikeList);
            }
            if (BaiduBannerLoader.this.isClientBidding()) {
                try {
                    d = Double.valueOf(xAdNativeResponse.getECPMLevel()).doubleValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    d = OOXIXo.f3760XO;
                }
                create.add(8016, d);
            } else if (BaiduBannerLoader.this.isMultiBidding()) {
                create.add(8058, xAdNativeResponse.getECPMLevel());
            }
            create.add(8059, BaiduAdapterUtil.getinteractionType(xAdNativeResponse.getAdActionType()));
            if (BaiduAdapterUtil.isNativeSmartOpt(xAdNativeResponse.getStyleType())) {
                create.add(8033, true);
                if (xAdNativeResponse.getStyleType() == 28 || xAdNativeResponse.getStyleType() == 29 || xAdNativeResponse.getStyleType() == 30 || xAdNativeResponse.getStyleType() == 33 || xAdNativeResponse.getStyleType() == 34) {
                    create.add(8060, 3);
                } else if (xAdNativeResponse.getStyleType() == 35 || xAdNativeResponse.getStyleType() == 36) {
                    create.add(8060, 4);
                } else if (xAdNativeResponse.getStyleType() == 37 || xAdNativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO) {
                    create.add(8060, 5);
                }
                FeedNativeView feedNativeView = new FeedNativeView(context);
                this.f10397Oo = feedNativeView;
                if (feedNativeView.getParent() != null) {
                    ((ViewGroup) this.f10397Oo.getParent()).removeView(this.f10397Oo);
                }
                this.f10397Oo.setAdData(this.f10399XO);
                if (BaiduBannerLoader.this.f10380XO.getBaiduNativeSmartOptStyleParams() instanceof StyleParams) {
                    this.f10397Oo.changeViewLayoutParams((StyleParams) BaiduBannerLoader.this.f10380XO.getBaiduNativeSmartOptStyleParams());
                }
            } else {
                create.add(8033, false);
                if (xAdNativeResponse.getMultiPicUrls() != null && xAdNativeResponse.getMultiPicUrls().size() == 3) {
                    create.add(8060, 4);
                } else if (!TextUtils.isEmpty(xAdNativeResponse.getVideoUrl()) || xAdNativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO) {
                    create.add(8060, 5);
                } else {
                    create.add(8060, 3);
                }
            }
            this.mGMAd.call(8140, create.build(), Void.class);
            this.f10399XO.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.1
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public void onDislikeClick() {
                    Bridge bridge = BaiduNativeAd.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1014, null, Void.class);
                    }
                }
            });
        }

        private String I0Io() {
            try {
                XAdNativeResponse xAdNativeResponse = this.f10399XO;
                if (xAdNativeResponse != null) {
                    return (String) xAdNativeResponse.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void oIX0oI() {
            Bridge bridge = this.mGMAd;
            if (bridge != null) {
                bridge.call(1008, null, Void.class);
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 6081) {
                return (T) getAdView();
            }
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
                registerView(activity, viewGroup, list, list2, BaiduAdapterUtil.buildViewBinder((Bridge) valueSet.objectValue(8071, Bridge.class)));
            } else if (i == 8109) {
                onDestroy();
            } else if (i == 8147) {
                return (T) I0Io();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @JProtect
        public View getAdView() {
            return this.f10397Oo;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f10396IXxxXO;
        }

        public boolean hasDislike() {
            return BaiduBannerLoader.this.f10378Oxx0xo;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            Context context = BaiduBannerLoader.this.f10381oI0IIXIo != null ? (Context) BaiduBannerLoader.this.f10381oI0IIXIo.get() : null;
            XAdNativeResponse xAdNativeResponse = this.f10399XO;
            return (xAdNativeResponse == null || !xAdNativeResponse.isAdAvailable(context)) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            this.f10396IXxxXO = true;
        }

        @JProtect
        public void registerView(Context context, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
            if (this.f10399XO != null) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.logoLayoutId);
                if (viewGroup2 != null && !BaiduAdapterUtil.isNativeSmartOpt(this.f10399XO.getStyleType())) {
                    viewGroup2.setVisibility(0);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setGravity(17);
                    linearLayout.setOrientation(0);
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(BaiduAdapterUtil.dp2px(context, 15.0f), BaiduAdapterUtil.dp2px(context, 15.0f)));
                    linearLayout.addView(imageView);
                    ImageView imageView2 = new ImageView(context);
                    imageView2.setLayoutParams(new LinearLayout.LayoutParams(BaiduAdapterUtil.dp2px(context, 25.0f), BaiduAdapterUtil.dp2px(context, 13.0f)));
                    linearLayout.addView(imageView2);
                    new DownloadImageTask(imageView).execute(this.f10399XO.getBaiduLogoUrl());
                    new DownloadImageTask(imageView2).execute(this.f10399XO.getAdLogoUrl());
                    viewGroup2.removeAllViews();
                    ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                    layoutParams.width = BaiduAdapterUtil.dp2px(context, 38.0f);
                    layoutParams.height = BaiduAdapterUtil.dp2px(context, 13.0f);
                    viewGroup2.setLayoutParams(layoutParams);
                    viewGroup2.addView(linearLayout, -1, -1);
                }
                ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.mediaViewId);
                if (viewGroup3 != null && (this.f10399XO.getStyleType() == 37 || this.f10399XO.getMaterialType() == NativeResponse.MaterialType.VIDEO)) {
                    XNativeView xNativeView = new XNativeView(context);
                    xNativeView.setNativeItem(this.f10399XO);
                    xNativeView.setVideoMute(BaiduBannerLoader.this.f10376IXxxXO);
                    xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.2
                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onCompletion() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onError() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onPause() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onRenderingStart() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onResume() {
                        }
                    });
                    viewGroup3.removeAllViews();
                    viewGroup3.addView(xNativeView, -1, -1);
                    xNativeView.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.3
                        @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
                        public void onNativeViewClick(XNativeView xNativeView2) {
                        }
                    });
                    xNativeView.render();
                }
                this.f10399XO.registerViewForInteraction(viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.4
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADExposed() {
                        BaiduNativeAd.this.oIX0oI();
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADExposureFailed(int i) {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADStatusChanged() {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onAdClick() {
                        Bridge bridge = BaiduNativeAd.this.mGMAd;
                        if (bridge != null) {
                            bridge.call(1009, null, Void.class);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onAdUnionClick() {
                    }
                });
            }
        }

        @JProtect
        public void render() {
            XAdNativeResponse xAdNativeResponse = this.f10399XO;
            if (xAdNativeResponse == null || !BaiduAdapterUtil.isNativeSmartOpt(xAdNativeResponse.getStyleType())) {
                BaiduBannerLoader.this.notifyAdFailed(80001, "渲染类型错误");
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            FeedNativeView feedNativeView = this.f10397Oo;
            if (feedNativeView != null) {
                arrayList.add(feedNativeView);
            }
            this.f10399XO.registerViewForInteraction(this.f10397Oo, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.5
                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposed() {
                    BaiduNativeAd.this.oIX0oI();
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADExposureFailed(int i) {
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onADStatusChanged() {
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdClick() {
                    Bridge bridge = BaiduNativeAd.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1009, null, Void.class);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                public void onAdUnionClick() {
                }
            });
            BaiduBannerLoader baiduBannerLoader = BaiduBannerLoader.this;
            baiduBannerLoader.notifyAdSuccess(this, baiduBannerLoader.f10377Oo);
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    /* loaded from: classes8.dex */
    public class BaiduNativeExpressAd extends MediationBaseAdBridge {

        /* renamed from: Oo, reason: collision with root package name */
        public boolean f10407Oo;

        /* renamed from: XO, reason: collision with root package name */
        public final ExpressResponse f10408XO;

        public BaiduNativeExpressAd(ExpressResponse expressResponse) {
            super(BaiduBannerLoader.this.f10380XO, BaiduBannerLoader.this.f10377Oo);
            double d;
            this.f10407Oo = false;
            this.f10408XO = expressResponse;
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            if (BaiduBannerLoader.this.isClientBidding()) {
                try {
                    d = Double.valueOf(expressResponse.getECPMLevel()).doubleValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    d = OOXIXo.f3760XO;
                }
                create.add(8016, d);
            } else if (BaiduBannerLoader.this.isMultiBidding()) {
                create.add(8058, expressResponse.getECPMLevel());
            }
            create.add(8033, true);
            create.add(8055, BaiduAdapterUtil.isDownloadAd(expressResponse));
            create.add(8059, BaiduAdapterUtil.getinteractionType(expressResponse.getAdActionType()));
            this.mGMAd.call(8140, create.build(), Void.class);
            this.f10408XO.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeExpressAd.1
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdClick() {
                    Bridge bridge = BaiduNativeExpressAd.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1009, null, Void.class);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdExposed() {
                    Bridge bridge = BaiduNativeExpressAd.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1008, null, Void.class);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderFail(View view, String str, int i) {
                    BaiduBannerLoader.this.notifyAdFailed(i, str);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderSuccess(View view, float f, float f2) {
                    BaiduNativeExpressAd baiduNativeExpressAd = BaiduNativeExpressAd.this;
                    BaiduBannerLoader.this.notifyAdSuccess(baiduNativeExpressAd, baiduNativeExpressAd.mGMAd);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdUnionClick() {
                }
            });
            this.f10408XO.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeExpressAd.2
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeItemClick(String str) {
                    Bridge bridge = BaiduNativeExpressAd.this.mGMAd;
                    if (bridge != null) {
                        bridge.call(1014, null, Void.class);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowClose() {
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowShow() {
                }
            });
        }

        private String oIX0oI() {
            try {
                ExpressResponse expressResponse = this.f10408XO;
                if (expressResponse != null) {
                    return (String) expressResponse.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (i == 6081) {
                return (T) getAdView();
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else if (i == 8147) {
                return (T) oIX0oI();
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @JProtect
        public View getAdView() {
            ExpressResponse expressResponse = this.f10408XO;
            if (expressResponse != null) {
                return expressResponse.getExpressAdView();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.f10407Oo;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public MediationConstant.AdIsReadyStatus isReadyStatus() {
            ExpressResponse expressResponse = this.f10408XO;
            return (expressResponse == null || !expressResponse.isAdAvailable()) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationBaseAdBridge
        public void onDestroy() {
            this.f10407Oo = true;
        }

        @JProtect
        public void render() {
            ExpressResponse expressResponse = this.f10408XO;
            if (expressResponse != null) {
                expressResponse.render();
            } else {
                BaiduBannerLoader.this.notifyAdFailed(80001, "render fail, mExpressResponse is null");
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    private void II0xO0(Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, getAdnId());
        String baiduAppSid = this.f10380XO.getBaiduAppSid();
        if (!TextUtils.isEmpty(baiduAppSid)) {
            baiduNativeManager.setAppSid(baiduAppSid);
        }
        this.f10376IXxxXO = this.f10380XO.isMuted();
        RequestParameters build = new RequestParameters.Builder().build();
        if (this.f10380XO.getBaiduRequestParameters() instanceof RequestParameters) {
            build = (RequestParameters) this.f10380XO.getBaiduRequestParameters();
        }
        setBiddingResult(getAdnId(), isClientBidding(), build);
        baiduNativeManager.setCacheVideoOnlyWifi(this.f10380XO.getBaiduCacheVideoOnlyWifi());
        baiduNativeManager.loadExpressAd(build, this.f10379OxxIIOOXO);
    }

    public final void oxoX(final Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, getAdnId());
        String baiduAppSid = this.f10380XO.getBaiduAppSid();
        if (!TextUtils.isEmpty(baiduAppSid)) {
            baiduNativeManager.setAppSid(baiduAppSid);
        }
        this.f10376IXxxXO = this.f10380XO.isMuted();
        RequestParameters build = new RequestParameters.Builder().build();
        if (this.f10380XO.getBaiduRequestParameters() instanceof RequestParameters) {
            build = (RequestParameters) this.f10380XO.getBaiduRequestParameters();
        }
        setBiddingResult(getAdnId(), isClientBidding(), build);
        baiduNativeManager.setCacheVideoOnlyWifi(this.f10380XO.getBaiduCacheVideoOnlyWifi());
        baiduNativeManager.loadFeedAd(build, new BaiduNativeManager.FeedAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNativeFail(int i, String str) {
                BaiduBannerLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.size() <= 0) {
                    BaiduBannerLoader.this.notifyAdFailed(80001, "load成功，但list为空");
                    return;
                }
                BaiduNativeAd baiduNativeAd = new BaiduNativeAd((XAdNativeResponse) list.get(0), context);
                if (BaiduBannerLoader.this.f10378Oxx0xo) {
                    baiduNativeAd.render();
                } else {
                    BaiduBannerLoader baiduBannerLoader = BaiduBannerLoader.this;
                    baiduBannerLoader.notifyAdSuccess(baiduNativeAd, baiduBannerLoader.f10377Oo);
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNoAd(int i, String str) {
                BaiduBannerLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        String str;
        if (context != null && mediationAdSlotValueSet != null) {
            this.f10381oI0IIXIo = new WeakReference<>(context);
            this.f10380XO = mediationAdSlotValueSet;
            this.f10377Oo = getGMBridge();
            if (mediationAdSlotValueSet.getAdSubType() != 4) {
                new BaiduBannerAd().II0xO0(context);
                return;
            }
            int originType = mediationAdSlotValueSet.getOriginType();
            if (originType == 1) {
                this.f10378Oxx0xo = true;
            } else if (originType == 2) {
                this.f10378Oxx0xo = false;
            } else {
                if (originType == 3) {
                    this.f10378Oxx0xo = true;
                    II0xO0(context.getApplicationContext());
                    return;
                }
                str = "originType类型错误";
            }
            oxoX(context.getApplicationContext());
            return;
        }
        str = "context is null or adSlotValueSet is null";
        notifyAdFailed(80001, str);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdLoaderImpl, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
