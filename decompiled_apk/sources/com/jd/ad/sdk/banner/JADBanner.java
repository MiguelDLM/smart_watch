package com.jd.ad.sdk.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.jd.ad.sdk.banner.jad_b_an;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JADBanner implements IJADBase, JADAdLoadListener, PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private com.jd.ad.sdk.banner.jad_b_an mBannerRender;
    private WeakReference<Context> mContextWf;
    private String mInstanceId;
    private JADBannerListener mJADListener;
    private JADMaterialData mJADMaterialData;
    private ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private JADSlot mSlot;
    private int srtp;
    private final int mSplashStylePlanType = 0;
    private final int mSplashClickAreaValue = 100;

    /* loaded from: classes10.dex */
    public class jad_b_an implements ActLifecycle.OnLifecycleChangeListener {
        public jad_b_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (activity.hashCode() == JADBanner.this.mAttachActivityHashCode) {
                JADBanner.this.destroy();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_bo implements Runnable {
        public jad_b_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.startRender();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_cp implements Runnable {
        public jad_b_cp() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.onAdLoadCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_dq implements Runnable {
        public final /* synthetic */ int jad_b_an;
        public final /* synthetic */ String jad_b_bo;

        public jad_b_dq(int i, String str) {
            this.jad_b_an = i;
            this.jad_b_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.onAdLoadFailedCallback(this.jad_b_an, this.jad_b_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_er implements Runnable {
        public final /* synthetic */ View jad_b_an;

        public jad_b_er(View view) {
            this.jad_b_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.onAdRenderSucCallback(this.jad_b_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_fs implements Runnable {
        public final /* synthetic */ int jad_b_an;
        public final /* synthetic */ String jad_b_bo;

        public jad_b_fs(int i, String str) {
            this.jad_b_an = i;
            this.jad_b_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.onAdRenderFailedCallback(this.jad_b_an, this.jad_b_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_hu implements Runnable {
        public jad_b_hu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.onAdShowedCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_iv implements Runnable {
        public jad_b_iv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.onAdCloseCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_b_jt implements Runnable {
        public jad_b_jt() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADBanner.this.onAdClickCallback();
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_b_jw implements jad_b_an.jad_b_bo {
        public WeakReference<JADBanner> jad_b_an;

        public jad_b_jw(JADBanner jADBanner) {
            this.jad_b_an = new WeakReference<>(jADBanner);
        }
    }

    public JADBanner(@NonNull Context context, @NonNull JADSlot jADSlot) {
        this.dstp = 0;
        this.srtp = 0;
        this.mInstanceId = "";
        this.mAttachActivityHashCode = -1;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.mContextWf = new WeakReference<>(context);
            if (context instanceof Activity) {
                this.mAttachActivityHashCode = context.hashCode();
            }
        }
        this.mInstanceId = UUIDUtils.uuid();
        if (jADSlot == null) {
            Logger.w("JADSlot can not be null !!!", new Object[0]);
        } else {
            this.mSlot = jADSlot;
            JADMediator.getInstance().getInitService().createDefaultAdInstance(jADSlot);
            this.dstp = JADMediator.getInstance().getInitService().getDs(this.mSlot.getSlotID());
            this.srtp = JADMediator.getInstance().getInitService().getR(this.mSlot.getSlotID());
        }
        JADMediator.getInstance().getAdService().registerAd(this.mInstanceId);
        initActLifeListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdClickOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_b_jt());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdCloseOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_b_iv());
    }

    private void callbackAdLoadFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_b_dq(i, str));
    }

    private void callbackAdLoadOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_b_cp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdReadyOnUiThread(View view) {
        reportRenderSuccessEvent();
        HandlerUtils.runOnUiThread(new jad_b_er(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdRenderFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_b_fs(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdShowedOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_b_hu());
    }

    private void doAfterPreloadFinished() {
        JADMediator.getInstance().getAdService().unregisterAdPreloader(this.mInstanceId, this.mSlot);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    private int getAdType() {
        return 5;
    }

    private Context getAppContext() {
        WeakReference<Context> weakReference = this.mContextWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private int getDisplayScene() {
        return 1;
    }

    private String getImageUrl() {
        if (getJADMaterialData() != null && getJADMaterialData().getImageUrls() != null && !getJADMaterialData().getImageUrls().isEmpty()) {
            return getJADMaterialData().getImageUrls().get(0);
        }
        return "";
    }

    private int getRenderMode() {
        return 1;
    }

    private void initActLifeListener() {
        if (this.mAttachActivityHashCode != -1) {
            jad_b_an jad_b_anVar = new jad_b_an();
            this.mLifeChangeListener = jad_b_anVar;
            ActLifecycle.addLifecycleListener(jad_b_anVar);
        }
    }

    private void notifyRender() {
        HandlerUtils.runOnUiThread(new jad_b_bo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdClickCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        JADBannerListener jADBannerListener = this.mJADListener;
        if (jADBannerListener != null) {
            jADBannerListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdCloseCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        JADBannerListener jADBannerListener = this.mJADListener;
        if (jADBannerListener != null) {
            jADBannerListener.onClose();
        }
        this.mJADListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadCallback() {
        JADBannerListener jADBannerListener = this.mJADListener;
        if (jADBannerListener != null) {
            jADBannerListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAdLoadFailedCallback(int i, String str) {
        if (this.mSlot != null) {
            JADMediator.getInstance().getAdService().printRequestData(this.mSlot);
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADBannerListener jADBannerListener = this.mJADListener;
        if (jADBannerListener != null) {
            jADBannerListener.onLoadFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdRenderFailedCallback(int i, String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADBannerListener jADBannerListener = this.mJADListener;
        if (jADBannerListener != null) {
            jADBannerListener.onRenderFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdRenderSucCallback(View view) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        if (view == null) {
            if (this.mSlot != null) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String requestId = this.mSlot.getRequestId();
                JADError jADError = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
                eventService.reportRenderFailedEvent(requestId, jADError.getCode(), jADError.getMessage(new String[0]), this.mSlot.getSen());
            }
            JADBannerListener jADBannerListener = this.mJADListener;
            if (jADBannerListener != null) {
                JADError jADError2 = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
                jADBannerListener.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new String[0]));
                return;
            }
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        JADBannerListener jADBannerListener2 = this.mJADListener;
        if (jADBannerListener2 != null) {
            jADBannerListener2.onRenderSuccess(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdShowedCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        JADBannerListener jADBannerListener = this.mJADListener;
        if (jADBannerListener != null) {
            jADBannerListener.onExposure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickEvent(int i) {
        JADSlot jADSlot;
        if (i == -2 || (jADSlot = this.mSlot) == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, clickTime, clickTime2, clickTime3, 0, 100, this.mSlot.getEventInteractionType(), 0, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, clickTime, clickTime2, clickTime3, 0, 100, this.mSlot.getEventInteractionType(), 0, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportCloseEvent(int i) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), -1, clickTime, clickTime2, clickTime3, 0, 100, i, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), -1, clickTime, clickTime2, clickTime3, 0, 100, i, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDelayExposureEvent(String str, int i) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setDelayShowTime(System.currentTimeMillis());
        long delayShowTime = this.mSlot.getDelayShowTime() - this.mSlot.getLoadTime();
        long delayShowTime2 = this.mSlot.getDelayShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(delayShowTime);
        this.mSlot.setDedu(delayShowTime2);
        this.mSlot.setSspt(0);
        this.mSlot.setScav(100);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, delayShowTime, delayShowTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, delayShowTime, delayShowTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportExposureEvent(String str, int i) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setShowTime(System.currentTimeMillis());
        long showTime = this.mSlot.getShowTime() - this.mSlot.getLoadTime();
        long showTime2 = this.mSlot.getShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(showTime);
        this.mSlot.setDedu(showTime2);
        this.mSlot.setSspt(0);
        this.mSlot.setScav(100);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, showTime, showTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), i, showTime, showTime2, 0, 100, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), str, this.dstp, this.srtp);
        }
    }

    private void reportRenderSuccessEvent() {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setRenderSucTime(System.currentTimeMillis());
        long renderSucTime = this.mSlot.getRenderSucTime() - this.mSlot.getLoadTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), renderSucTime, 0L, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), getRenderMode(), renderSucTime, 0L, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        }
    }

    private void startPreloadAdDataTimeCounter() {
        PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0167 -> B:28:0x01a4). Please report as a decompilation issue!!! */
    public void startRender() {
        String str = "Exception while banner render: ";
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = new com.jd.ad.sdk.banner.jad_b_an(getAppContext(), this.mSlot, this.mInstanceId, getImageUrl());
        this.mBannerRender = jad_b_anVar;
        jad_b_anVar.jad_b_iv = new jad_b_jw(this);
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar2 = this.mBannerRender;
        if (jad_b_anVar2.jad_b_bo() != null && jad_b_anVar2.jad_b_bo != null) {
            try {
                jad_b_anVar2.jad_b_jt = LayoutInflater.from(jad_b_anVar2.jad_b_bo()).inflate(ResourceUtils.getResourceId(jad_b_anVar2.jad_b_bo(), "jad_banner_layout", "layout"), (ViewGroup) null);
            } catch (Exception e) {
                Logger.w("Exception while banner render: " + e, new Object[0]);
            }
            if (jad_b_anVar2.jad_b_jt == null) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String str2 = jad_b_anVar2.jad_b_er;
                JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
                eventService.reportRenderFailedEvent(str2, jADError.getCode(), jADError.getMessage(new String[0]), jad_b_anVar2.jad_b_fs);
                jad_b_anVar2.jad_b_an(jADError.getCode(), jADError.getMessage(new String[0]));
                return;
            }
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
            int dip2px = (int) ScreenUtils.dip2px(jad_b_anVar2.jad_b_bo(), jad_b_anVar2.jad_b_bo.getWidth());
            int dip2px2 = (int) ScreenUtils.dip2px(jad_b_anVar2.jad_b_bo(), jad_b_anVar2.jad_b_bo.getHeight());
            layoutParams.width = dip2px;
            layoutParams.height = dip2px2;
            jad_b_anVar2.jad_b_jt.setLayoutParams(layoutParams);
            JADMediator.getInstance().getExposureService().registerExposureView(jad_b_anVar2.jad_b_dq);
            JADMediator.getInstance().getExposureService().setViewExposureCallback(jad_b_anVar2.jad_b_dq, 5, jad_b_anVar2.jad_b_jt, new com.jd.ad.sdk.banner.jad_b_an.jad_b_an(jad_b_anVar2));
            try {
                ImageView imageView = (ImageView) jad_b_anVar2.jad_b_jt.findViewById(ResourceUtils.getResourceId(jad_b_anVar2.jad_b_bo(), "jad_banner_image", "id"));
                if (imageView != null) {
                    Drawable drawable = jad_b_anVar2.jad_b_hu;
                    if (drawable != null) {
                        imageView.setImageDrawable(drawable);
                    } else {
                        jad_b_anVar2.jad_b_an(new com.jd.ad.sdk.banner.jad_b_an.jad_b_bo(jad_b_anVar2, imageView));
                    }
                }
            } catch (Exception e2) {
                Logger.w("Exception while banner render: " + e2, new Object[0]);
            }
            View view = jad_b_anVar2.jad_b_jt;
            if (view != null) {
                JADMediator.getInstance().getTouchService().registerTouchView(jad_b_anVar2.jad_b_dq);
                view.setClickable(true);
                view.setOnTouchListener(new com.jd.ad.sdk.banner.jad_b_an.jad_b_dq(jad_b_anVar2, view));
                view.setOnClickListener(new com.jd.ad.sdk.banner.jad_b_an.jad_b_er(jad_b_anVar2, view));
            }
            try {
                View findViewById = jad_b_anVar2.jad_b_jt.findViewById(ResourceUtils.getResourceId(jad_b_anVar2.jad_b_bo(), "jad_banner_close", "id"));
                if (jad_b_anVar2.jad_b_bo.isHideClose()) {
                    findViewById.setVisibility(8);
                    str = str;
                } else {
                    findViewById.setVisibility(0);
                    findViewById.setOnClickListener(new com.jd.ad.sdk.banner.jad_b_an.jad_b_cp(jad_b_anVar2));
                    str = str;
                }
            } catch (Exception e3) {
                Object[] objArr = new Object[0];
                Logger.w(str + e3, objArr);
                str = objArr;
            }
            return;
        }
        JADEventService eventService2 = JADMediator.getInstance().getEventService();
        String str3 = jad_b_anVar2.jad_b_er;
        JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        eventService2.reportRenderFailedEvent(str3, jADError2.getCode(), jADError2.getMessage(new String[0]), jad_b_anVar2.jad_b_fs);
        jad_b_anVar2.jad_b_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
    }

    public void destroy() {
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = this.mBannerRender;
        if (jad_b_anVar != null) {
            jad_b_anVar.jad_b_an();
            this.mBannerRender = null;
        }
        this.mJADListener = null;
        JADMediator.getInstance().getAdService().removeData(this.mInstanceId);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
        ActLifecycle.OnLifecycleChangeListener onLifecycleChangeListener = this.mLifeChangeListener;
        if (onLifecycleChangeListener != null) {
            ActLifecycle.removeLifecycleListener(onLifecycleChangeListener);
            this.mLifeChangeListener = null;
        }
    }

    public String getErin(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
        } else {
            str2 = "";
        }
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(getAdType()));
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    @NonNull
    public final IJADExtra getExtra() {
        return JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
    }

    public JADMaterialData getJADMaterialData() {
        List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        if (jADMaterialDataList != null && !jADMaterialDataList.isEmpty() && jADMaterialDataList.get(0) != null) {
            this.mJADMaterialData = jADMaterialDataList.get(0);
        }
        return this.mJADMaterialData;
    }

    public final void loadAd(JADBannerListener jADBannerListener) {
        this.mJADListener = jADBannerListener;
        String uuid = UUIDUtils.uuid();
        if (this.mSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        startPreloadAdDataTimeCounter();
        this.mSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(0);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadFailure(int i, String str) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null && jADSlot.getAdDataRequestSourceType() == 1) {
            doAfterPreloadFinished();
        } else {
            callbackAdLoadFailedOnUiThread(i, str);
        }
    }

    @Override // com.jd.ad.sdk.bl.adload.JADAdLoadListener
    public void onLoadSuccess() {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null && jADSlot.getAdDataRequestSourceType() == 1) {
            doAfterPreloadFinished();
        } else {
            callbackAdLoadOnUiThread();
            notifyRender();
        }
    }

    @Override // com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback
    public void onUseCacheCounterFinish() {
        this.mSlot.setAdDataRequestSourceType(2);
        JADMediator.getInstance().getAdService().loadAdFromCache(this.mInstanceId, this.mSlot, this);
    }

    public void preloadAd() {
        String uuid = UUIDUtils.uuid();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        jADSlot.setRequestId(uuid);
        this.mSlot.setLoadTime(System.currentTimeMillis());
        this.mSlot.setAdType(getAdType());
        this.mSlot.setDisplayScene(getDisplayScene());
        this.mSlot.setFromNativeAd(false);
        this.mSlot.setAdDataRequestSourceType(1);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    public void removeBannerView() {
        com.jd.ad.sdk.banner.jad_b_an jad_b_anVar = this.mBannerRender;
        if (jad_b_anVar != null) {
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.banner.jad_b_an.jad_b_fs(jad_b_anVar));
        }
    }
}
