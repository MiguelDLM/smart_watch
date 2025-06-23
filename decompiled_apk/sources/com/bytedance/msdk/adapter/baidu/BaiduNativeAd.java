package com.bytedance.msdk.adapter.baidu;

import XIXIX.OOXIXo;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobads.sdk.api.DislikeEvent;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.StyleParams;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes8.dex */
public class BaiduNativeAd extends MediationNativeAd {

    /* renamed from: IXxxXO, reason: collision with root package name */
    public boolean f10431IXxxXO;

    /* renamed from: Oo, reason: collision with root package name */
    public FeedNativeView f10432Oo;

    /* renamed from: Oxx0xo, reason: collision with root package name */
    public MediationAdSlotValueSet f10433Oxx0xo;

    /* renamed from: XO, reason: collision with root package name */
    public XAdNativeResponse f10434XO;

    /* renamed from: oI0IIXIo, reason: collision with root package name */
    public WeakReference<Context> f10435oI0IIXIo;

    public BaiduNativeAd(Context context, XAdNativeResponse xAdNativeResponse, BaiduNativeLoader baiduNativeLoader, Bridge bridge, MediationAdSlotValueSet mediationAdSlotValueSet) {
        super(baiduNativeLoader, bridge);
        double d;
        this.f10431IXxxXO = false;
        this.f10435oI0IIXIo = new WeakReference<>(context);
        this.f10434XO = xAdNativeResponse;
        this.f10433Oxx0xo = mediationAdSlotValueSet;
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
            MediationApiLog.i("app_function_link : " + xAdNativeResponse.getAppFunctionLink());
            create.add(8551, xAdNativeResponse.getAppFunctionLink());
        } catch (Throwable unused) {
        }
        create.add(8078, xAdNativeResponse.getAppSize());
        create.add(8061, oIX0oI());
        List<DislikeEvent> dislikeList = xAdNativeResponse.getDislikeList();
        if (dislikeList != null && dislikeList.size() > 0) {
            create.add(8036, dislikeList);
        }
        if (baiduNativeLoader.isClientBidding()) {
            try {
                d = Double.valueOf(xAdNativeResponse.getECPMLevel()).doubleValue();
            } catch (Exception unused2) {
                d = OOXIXo.f3760XO;
            }
            create.add(8016, d);
        } else if (baiduNativeLoader.isMultiBidding()) {
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
            this.f10432Oo = feedNativeView;
            if (feedNativeView.getParent() != null) {
                ((ViewGroup) this.f10432Oo.getParent()).removeView(this.f10432Oo);
            }
            this.f10432Oo.setAdData(this.f10434XO);
            if (this.f10433Oxx0xo.getBaiduNativeSmartOptStyleParams() instanceof StyleParams) {
                this.f10432Oo.changeViewLayoutParams((StyleParams) this.f10433Oxx0xo.getBaiduNativeSmartOptStyleParams());
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
        notifyNativeValue(create.build());
    }

    private void II0xO0(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
        FrameLayout frameLayout;
        MediationAdSlotValueSet mediationAdSlotValueSet;
        int i;
        int i2;
        View renderShakeView;
        ViewGroup viewGroup2;
        if (this.f10434XO == null || !(viewGroup instanceof FrameLayout)) {
            return;
        }
        FrameLayout frameLayout2 = (FrameLayout) viewGroup;
        View findViewById = frameLayout2.findViewById(mediationViewBinder.logoLayoutId);
        if ((findViewById instanceof ViewGroup) && !BaiduAdapterUtil.isNativeSmartOpt(this.f10434XO.getStyleType())) {
            findViewById.setVisibility(0);
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
            new DownloadImageTask(imageView).execute(this.f10434XO.getBaiduLogoUrl());
            new DownloadImageTask(imageView2).execute(this.f10434XO.getAdLogoUrl());
            ViewGroup viewGroup3 = (ViewGroup) findViewById;
            viewGroup3.removeAllViews();
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.width = BaiduAdapterUtil.dp2px(context, 38.0f);
            layoutParams.height = BaiduAdapterUtil.dp2px(context, 13.0f);
            findViewById.setLayoutParams(layoutParams);
            viewGroup3.addView(linearLayout, -1, -1);
        }
        try {
            mediationAdSlotValueSet = this.f10433Oxx0xo;
            i = 80;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (mediationAdSlotValueSet != null) {
            int shakeViewWidth = mediationAdSlotValueSet.getShakeViewWidth() > 0.0f ? (int) this.f10433Oxx0xo.getShakeViewWidth() : 80;
            if (this.f10433Oxx0xo.getShakeViewHeight() > 0.0f) {
                i = shakeViewWidth;
                i2 = (int) this.f10433Oxx0xo.getShakeViewHeight();
                renderShakeView = this.f10434XO.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.2
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
                    public void onDismiss() {
                        try {
                            BaiduNativeAd.this.shakeViewDismissed();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                });
                if (renderShakeView != null && (viewGroup2 = (ViewGroup) frameLayout2.findViewById(mediationViewBinder.shakeViewContainerId)) != null) {
                    viewGroup2.removeView(renderShakeView);
                    removeSelfFromParent(renderShakeView);
                    viewGroup2.addView(renderShakeView);
                }
                if ((isUseCustomVideo() || TextUtils.isEmpty(this.f10434XO.getVideoUrl())) && (frameLayout = (FrameLayout) frameLayout2.findViewById(mediationViewBinder.mediaViewId)) != null && getImageMode() == 5) {
                    XNativeView xNativeView = new XNativeView(context);
                    xNativeView.setNativeItem(this.f10434XO);
                    xNativeView.setVideoMute(this.f10433Oxx0xo.isMuted());
                    xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.3
                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onCompletion() {
                            BaiduNativeAd.this.notifyOnVideoComplete();
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onError() {
                            BaiduNativeAd.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "baidu setNativeVideoListener onError");
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onPause() {
                            BaiduNativeAd.this.notifyOnVideoPause();
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onRenderingStart() {
                            BaiduNativeAd.this.notifyOnVideoStart();
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onResume() {
                            BaiduNativeAd.this.notifyOnVideoResume();
                        }
                    });
                    frameLayout.removeAllViews();
                    frameLayout.addView(xNativeView, -1, -1);
                    xNativeView.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.4
                        @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
                        public void onNativeViewClick(XNativeView xNativeView2) {
                        }
                    });
                    xNativeView.render();
                }
                this.f10434XO.registerViewForInteraction(frameLayout2, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.5
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADExposed() {
                        BaiduNativeAd.this.notifyOnShowAd();
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADExposureFailed(int i3) {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADStatusChanged() {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onAdClick() {
                        BaiduNativeAd.this.notifyOnClickAd();
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onAdUnionClick() {
                    }
                });
            }
            i = shakeViewWidth;
        }
        i2 = 80;
        renderShakeView = this.f10434XO.renderShakeView(i, i2, new NativeResponse.AdShakeViewListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.2
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdShakeViewListener
            public void onDismiss() {
                try {
                    BaiduNativeAd.this.shakeViewDismissed();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        });
        if (renderShakeView != null) {
            viewGroup2.removeView(renderShakeView);
            removeSelfFromParent(renderShakeView);
            viewGroup2.addView(renderShakeView);
        }
        if (isUseCustomVideo()) {
        }
        XNativeView xNativeView2 = new XNativeView(context);
        xNativeView2.setNativeItem(this.f10434XO);
        xNativeView2.setVideoMute(this.f10433Oxx0xo.isMuted());
        xNativeView2.setNativeVideoListener(new INativeVideoListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.3
            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onCompletion() {
                BaiduNativeAd.this.notifyOnVideoComplete();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onError() {
                BaiduNativeAd.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "baidu setNativeVideoListener onError");
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onPause() {
                BaiduNativeAd.this.notifyOnVideoPause();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onRenderingStart() {
                BaiduNativeAd.this.notifyOnVideoStart();
            }

            @Override // com.baidu.mobads.sdk.api.INativeVideoListener
            public void onResume() {
                BaiduNativeAd.this.notifyOnVideoResume();
            }
        });
        frameLayout.removeAllViews();
        frameLayout.addView(xNativeView2, -1, -1);
        xNativeView2.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.4
            @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
            public void onNativeViewClick(XNativeView xNativeView22) {
            }
        });
        xNativeView2.render();
        this.f10434XO.registerViewForInteraction(frameLayout2, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.5
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BaiduNativeAd.this.notifyOnShowAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i3) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BaiduNativeAd.this.notifyOnClickAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private void X0o0xo() {
        XAdNativeResponse xAdNativeResponse = this.f10434XO;
        if (xAdNativeResponse == null || !BaiduAdapterUtil.isNativeSmartOpt(xAdNativeResponse.getStyleType())) {
            I0Io(this.f10432Oo, 80003, "物料错误");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FeedNativeView feedNativeView = this.f10432Oo;
        if (feedNativeView != null) {
            arrayList.add(feedNativeView);
        }
        this.f10434XO.registerViewForInteraction(this.f10432Oo, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.1
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BaiduNativeAd.this.notifyOnShowAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BaiduNativeAd.this.notifyOnClickAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
        oxoX();
    }

    private String XO() {
        try {
            XAdNativeResponse xAdNativeResponse = this.f10434XO;
            if (xAdNativeResponse != null) {
                return (String) xAdNativeResponse.getAdDataForKey("request_id");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
    
        if (r6.f10434XO.getAdActionType() == 2) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String oIX0oI() {
        /*
            r6 = this;
            com.baidu.mobads.sdk.api.XAdNativeResponse r0 = r6.f10434XO
            java.lang.String r1 = ""
            if (r0 == 0) goto L4a
            int r0 = r0.getDownloadStatus()
            java.lang.String r2 = "去看看"
            java.lang.String r3 = "立即下载"
            r4 = 2
            if (r0 >= 0) goto L1f
            com.baidu.mobads.sdk.api.XAdNativeResponse r0 = r6.f10434XO
            int r0 = r0.getAdActionType()
            if (r0 != r4) goto L1d
        L1b:
            r1 = r3
            goto L3d
        L1d:
            r1 = r2
            goto L3d
        L1f:
            r5 = 101(0x65, float:1.42E-43)
            if (r0 >= r5) goto L30
            com.baidu.mobads.sdk.api.XAdNativeResponse r0 = r6.f10434XO
            int r0 = r0.getAdActionType()
            if (r0 != r4) goto L2c
            goto L1b
        L2c:
            java.lang.String r1 = "查看详情"
            goto L3d
        L30:
            if (r0 != r5) goto L3d
            com.baidu.mobads.sdk.api.XAdNativeResponse r0 = r6.f10434XO
            int r0 = r0.getAdActionType()
            if (r0 != r4) goto L1d
            java.lang.String r1 = "点击安装"
        L3d:
            com.baidu.mobads.sdk.api.XAdNativeResponse r0 = r6.f10434XO
            java.lang.String r0 = r0.getActButtonString()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L4a
            r1 = r0
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.oIX0oI():java.lang.String");
    }

    private void oxoX() {
        notifyRenderSuccess(-1.0f, -2.0f);
    }

    public final void I0Io(View view, int i, String str) {
        notifyRenderFail(view, i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 6083) {
            X0o0xo();
        } else {
            if (i == 6081) {
                return (T) this.f10432Oo;
            }
            if (i == 8121) {
                return (T) isReadyStatus();
            }
            if (i == 8163) {
                return (T) String.valueOf(getVideoUrl());
            }
            if (i == 8135) {
                return (T) Boolean.valueOf(hasDislike());
            }
            if (i == 6085) {
                XAdNativeResponse xAdNativeResponse = this.f10434XO;
                if (xAdNativeResponse != null) {
                    xAdNativeResponse.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeAd.6
                        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                        public void onDislikeClick() {
                            BaiduNativeAd.this.notifyDislikeClick("百度智能优选dislike接口无关闭原因", null);
                            BaiduNativeAd.this.notifyDislikeSelect(0, "百度智能优选dislike接口无关闭原因");
                        }
                    });
                }
            } else if (i == 8109) {
                this.f10431IXxxXO = true;
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.f10431IXxxXO);
                }
                if (i == 8194) {
                    Map map = (Map) valueSet.objectValue(8075, Map.class);
                    if (map != null && (map.get(MediationConstant.BAIDU_DISLIKE_CLICK_ITEM) instanceof DislikeEvent)) {
                        DislikeEvent dislikeEvent = (DislikeEvent) map.get(MediationConstant.BAIDU_DISLIKE_CLICK_ITEM);
                        XAdNativeResponse xAdNativeResponse2 = this.f10434XO;
                        if (xAdNativeResponse2 != null) {
                            xAdNativeResponse2.dislikeClick(dislikeEvent);
                        }
                    }
                } else if (i == 8191) {
                    XAdNativeResponse xAdNativeResponse3 = this.f10434XO;
                    if (xAdNativeResponse3 != null) {
                        xAdNativeResponse3.pauseAppDownload();
                    }
                } else if (i == 8192) {
                    XAdNativeResponse xAdNativeResponse4 = this.f10434XO;
                    if (xAdNativeResponse4 != null) {
                        xAdNativeResponse4.resumeAppDownload();
                    }
                } else if (i == 8193) {
                    return (T) Integer.valueOf(getDownloadStatus());
                }
            }
        }
        if (i == 8159) {
            II0xO0((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), BaiduAdapterUtil.buildViewBinder((Bridge) valueSet.objectValue(8071, Bridge.class)));
        } else if (i == 8147) {
            return (T) XO();
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public int getDownloadStatus() {
        XAdNativeResponse xAdNativeResponse = this.f10434XO;
        if (xAdNativeResponse == null) {
            return -1;
        }
        int downloadStatus = xAdNativeResponse.getDownloadStatus();
        if (downloadStatus >= 0 && downloadStatus <= 100) {
            return 2;
        }
        if (downloadStatus == 101) {
            return 9;
        }
        if (downloadStatus == 102) {
            return 12;
        }
        if (downloadStatus == 103) {
            return 10;
        }
        return downloadStatus == 104 ? 11 : 1;
    }

    public String getVideoUrl() {
        XAdNativeResponse xAdNativeResponse;
        return (!isUseCustomVideo() || (xAdNativeResponse = this.f10434XO) == null) ? "" : xAdNativeResponse.getVideoUrl();
    }

    public boolean hasDislike() {
        return isExpress();
    }

    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        WeakReference<Context> weakReference = this.f10435oI0IIXIo;
        Context context = weakReference != null ? weakReference.get() : null;
        XAdNativeResponse xAdNativeResponse = this.f10434XO;
        return (xAdNativeResponse == null || !xAdNativeResponse.isAdAvailable(context)) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.native_ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8035, this);
        return create.build();
    }
}
