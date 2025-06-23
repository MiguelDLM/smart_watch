package com.jd.ad.sdk.feed;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.jd.ad.sdk.a.a;
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
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.feed.jad_f_an;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JADFeed implements IJADBase, JADAdLoadListener, PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private WeakReference<Context> mContextWf;
    private com.jd.ad.sdk.feed.jad_f_an mFeedAdRender;
    private String mInstanceId;
    private JADFeedListener mJADAdListener;
    private JADMaterialData mJADMaterialData;
    private ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private JADSlot mSlot;
    private int srtp;
    private final int mSplashStylePlanType = 0;
    private final int mSplashClickAreaValue = 100;

    /* loaded from: classes10.dex */
    public class jad_f_an implements ActLifecycle.OnLifecycleChangeListener {
        public jad_f_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (activity.hashCode() == JADFeed.this.mAttachActivityHashCode) {
                JADFeed.this.destroy();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_bo implements Runnable {
        public jad_f_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.startRender();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_cp implements Runnable {
        public jad_f_cp() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdLoadCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_dq implements Runnable {
        public final /* synthetic */ int jad_f_an;
        public final /* synthetic */ String jad_f_bo;

        public jad_f_dq(int i, String str) {
            this.jad_f_an = i;
            this.jad_f_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdLoadFailedCallback(this.jad_f_an, this.jad_f_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_er implements Runnable {
        public final /* synthetic */ View jad_f_an;

        public jad_f_er(View view) {
            this.jad_f_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdRenderSucCallback(this.jad_f_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_fs implements Runnable {
        public final /* synthetic */ int jad_f_an;
        public final /* synthetic */ String jad_f_bo;

        public jad_f_fs(int i, String str) {
            this.jad_f_an = i;
            this.jad_f_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdRenderFailedCallback(this.jad_f_an, this.jad_f_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_hu implements Runnable {
        public jad_f_hu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdShowedCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_iv implements Runnable {
        public jad_f_iv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdCloseCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_f_jt implements Runnable {
        public jad_f_jt() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADFeed.this.onAdClickCallback();
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_f_jw implements jad_f_an.InterfaceC0677jad_f_an {
        public WeakReference<JADFeed> jad_f_an;

        public jad_f_jw(JADFeed jADFeed) {
            this.jad_f_an = new WeakReference<>(jADFeed);
        }
    }

    public JADFeed(@NonNull Context context, @NonNull JADSlot jADSlot) {
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

    private void doAfterPreloadFinished() {
        JADMediator.getInstance().getAdService().unregisterAdPreloader(this.mInstanceId, this.mSlot);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    private String getAdTitle() {
        JADMaterialData jADMaterialData = getJADMaterialData();
        this.mJADMaterialData = jADMaterialData;
        if (jADMaterialData == null) {
            return "";
        }
        return jADMaterialData.getTitle();
    }

    private int getAdType() {
        return 2;
    }

    private Context getAppContext() {
        WeakReference<Context> weakReference = this.mContextWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private int getDisplayScene() {
        return 64;
    }

    private List<String> getImageUrls() {
        JADMaterialData jADMaterialData = getJADMaterialData();
        if (jADMaterialData == null) {
            return null;
        }
        return jADMaterialData.getImageUrls();
    }

    private String getMediaStyle() {
        JADMaterialData jADMaterialData = getJADMaterialData();
        this.mJADMaterialData = jADMaterialData;
        if (jADMaterialData == null) {
            return "";
        }
        return jADMaterialData.getMediaStyle();
    }

    private int getRenderMode() {
        return 1;
    }

    private void initActLifeListener() {
        if (this.mAttachActivityHashCode != -1) {
            jad_f_an jad_f_anVar = new jad_f_an();
            this.mLifeChangeListener = jad_f_anVar;
            ActLifecycle.addLifecycleListener(jad_f_anVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdLoadCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdLoadFailedCallback(int i, String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        if (this.mSlot != null) {
            JADMediator.getInstance().getAdService().printRequestData(this.mSlot);
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onLoadFailure(i, str);
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
            JADFeedListener jADFeedListener = this.mJADAdListener;
            if (jADFeedListener != null) {
                JADError jADError2 = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
                jADFeedListener.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new String[0]));
                return;
            }
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        JADFeedListener jADFeedListener2 = this.mJADAdListener;
        if (jADFeedListener2 != null) {
            jADFeedListener2.onRenderSuccess(view);
        }
    }

    private void startPreloadAdDataTimeCounter() {
        PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    public void callbackAdClickOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_jt());
    }

    public void callbackAdCloseOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_iv());
    }

    public void callbackAdLoadFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_f_dq(i, str));
    }

    public void callbackAdLoadOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_cp());
    }

    public void callbackAdReadyOnUiThread(View view) {
        reportRenderSuccessEvent();
        HandlerUtils.runOnUiThread(new jad_f_er(view));
    }

    public void callbackAdRenderFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_f_fs(i, str));
    }

    public void callbackAdShowedOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_f_hu());
    }

    public void destroy() {
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.mFeedAdRender;
        if (jad_f_anVar != null) {
            jad_f_anVar.jad_f_an();
            this.mFeedAdRender = null;
        }
        this.mJADAdListener = null;
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

    public void loadAd(JADFeedListener jADFeedListener) {
        this.mJADAdListener = jADFeedListener;
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

    public void notifyRender() {
        HandlerUtils.runOnUiThread(new jad_f_bo());
    }

    @UiThread
    public void onAdClickCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onClick();
        }
    }

    @UiThread
    public void onAdCloseCallback() {
        StringBuilder a2 = a.a("seven_back=====onAdCloseCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onClose();
        }
        this.mJADAdListener = null;
    }

    @UiThread
    public void onAdRenderFailedCallback(int i, String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onRenderFailure(i, str);
        }
    }

    @UiThread
    public void onAdShowedCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADFeedListener jADFeedListener = this.mJADAdListener;
        if (jADFeedListener != null) {
            jADFeedListener.onExposure();
        }
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
        float width = this.mSlot.getWidth();
        if (this.mSlot.getHeight() <= 0.0f) {
            this.mSlot.setHeight((width * 720.0f) / 1280.0f);
        }
        this.mSlot.setAdDataRequestSourceType(1);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    public void removeFeedView() {
        com.jd.ad.sdk.feed.jad_f_an jad_f_anVar = this.mFeedAdRender;
        if (jad_f_anVar != null) {
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_f_an.jad_f_an(jad_f_anVar));
        }
    }

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

    public void reportRenderSuccessEvent() {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x030b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v46, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r3v57, types: [android.widget.FrameLayout, android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20, types: [int] */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v47, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v53 */
    /* JADX WARN: Type inference failed for: r4v54 */
    /* JADX WARN: Type inference failed for: r4v55 */
    /* JADX WARN: Type inference failed for: r4v56 */
    /* JADX WARN: Type inference failed for: r4v57 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void startRender() {
        /*
            Method dump skipped, instructions count: 1260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.feed.JADFeed.startRender():void");
    }
}
