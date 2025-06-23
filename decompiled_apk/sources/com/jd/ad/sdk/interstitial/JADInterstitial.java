package com.jd.ad.sdk.interstitial;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.interstitial.jad_i_an;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JADInterstitial implements IJADBase, JADAdLoadListener, jad_i_an.jad_i_cp, PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private WeakReference<Context> mContextWf;
    private String mInstanceId;
    private com.jd.ad.sdk.interstitial.jad_i_an mInterstitialRender;
    private JADInterstitialListener mJADAdListener;
    private JADMaterialData mJADMaterialData;
    private ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private JADSlot mSlot;
    private int srtp;
    private final int mSplashStylePlanType = 0;
    private final int mSplashClickAreaValue = 100;

    /* loaded from: classes10.dex */
    public class jad_i_an implements ActLifecycle.OnLifecycleChangeListener {
        public jad_i_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (activity.hashCode() == JADInterstitial.this.mAttachActivityHashCode) {
                JADInterstitial.this.destroy();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_bo implements Runnable {
        public jad_i_bo() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.startRender();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_cp implements Runnable {
        public jad_i_cp() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.onAdLoadCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_dq implements Runnable {
        public final /* synthetic */ int jad_i_an;
        public final /* synthetic */ String jad_i_bo;

        public jad_i_dq(int i, String str) {
            this.jad_i_an = i;
            this.jad_i_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.onAdLoadFailedCallback(this.jad_i_an, this.jad_i_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_er implements Runnable {
        public final /* synthetic */ View jad_i_an;

        public jad_i_er(View view) {
            this.jad_i_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.onAdRenderSucCallback(this.jad_i_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_fs implements Runnable {
        public final /* synthetic */ int jad_i_an;
        public final /* synthetic */ String jad_i_bo;

        public jad_i_fs(int i, String str) {
            this.jad_i_an = i;
            this.jad_i_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.onAdRenderFailedCallback(this.jad_i_an, this.jad_i_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_hu implements Runnable {
        public jad_i_hu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.onAdShowedCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_iv implements Runnable {
        public jad_i_iv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.onAdCloseCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_jt implements Runnable {
        public jad_i_jt() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADInterstitial.this.onAdClickCallback();
        }
    }

    public JADInterstitial(@NonNull Context context, @NonNull JADSlot jADSlot) {
        this.dstp = 0;
        this.srtp = 0;
        this.mInstanceId = "";
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.mContextWf = new WeakReference<>(context);
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

    private int getAdType() {
        return 4;
    }

    @Nullable
    private Context getAppContext() {
        WeakReference<Context> weakReference = this.mContextWf;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    private int getDisplayScene() {
        return 2;
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
            jad_i_an jad_i_anVar = new jad_i_an();
            this.mLifeChangeListener = jad_i_anVar;
            ActLifecycle.addLifecycleListener(jad_i_anVar);
        }
    }

    private void notifyRender() {
        HandlerUtils.runOnUiThread(new jad_i_bo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdLoadCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADInterstitialListener jADInterstitialListener = this.mJADAdListener;
        if (jADInterstitialListener != null) {
            jADInterstitialListener.onLoadSuccess();
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
        JADInterstitialListener jADInterstitialListener = this.mJADAdListener;
        if (jADInterstitialListener != null) {
            jADInterstitialListener.onLoadFailure(i, str);
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
            JADInterstitialListener jADInterstitialListener = this.mJADAdListener;
            if (jADInterstitialListener != null) {
                JADError jADError2 = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
                jADInterstitialListener.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new String[0]));
                return;
            }
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        JADInterstitialListener jADInterstitialListener2 = this.mJADAdListener;
        if (jADInterstitialListener2 != null) {
            jADInterstitialListener2.onRenderSuccess(view);
        }
    }

    private void startPreloadAdDataTimeCounter() {
        PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    public void callbackAdClickOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_i_jt());
    }

    public void callbackAdCloseOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_i_iv());
    }

    public void callbackAdLoadFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_i_dq(i, str));
    }

    public void callbackAdLoadOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_i_cp());
    }

    public void callbackAdReadyOnUiThread(View view) {
        reportRenderSuccessEvent();
        HandlerUtils.runOnUiThread(new jad_i_er(view));
    }

    public void callbackAdRenderFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_i_fs(i, str));
    }

    public void callbackAdShowedOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_i_hu());
    }

    public void destroy() {
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.mInterstitialRender;
        if (jad_i_anVar != null) {
            Dialog dialog = jad_i_anVar.jad_i_iv;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (jad_i_anVar.jad_i_jt != null) {
                JADMediator.getInstance().getExposureService().unregisterExposureView(jad_i_anVar.jad_i_dq);
                jad_i_anVar.jad_i_jt = null;
            }
            jad_i_anVar.jad_i_hu = null;
            this.mInterstitialRender = null;
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

    public final void loadAd(@NonNull JADInterstitialListener jADInterstitialListener) {
        this.mJADAdListener = jADInterstitialListener;
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

    @UiThread
    public void onAdClickCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADInterstitialListener jADInterstitialListener = this.mJADAdListener;
        if (jADInterstitialListener != null) {
            jADInterstitialListener.onClick();
        }
    }

    @Override // com.jd.ad.sdk.interstitial.jad_i_an.jad_i_cp
    public void onAdClicked(View view, int i) {
        reportClickEvent(i);
        callbackAdClickOnUiThread();
    }

    @UiThread
    public void onAdCloseCallback() {
        StringBuilder a2 = a.a("seven_back=====onAdCloseCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADInterstitialListener jADInterstitialListener = this.mJADAdListener;
        if (jADInterstitialListener != null) {
            jADInterstitialListener.onClose();
        }
        destroy();
    }

    @Override // com.jd.ad.sdk.interstitial.jad_i_an.jad_i_cp
    public void onAdDismiss(View view) {
        int ordinal;
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.mInterstitialRender;
        if (jad_i_anVar != null && (jad_i_anVar.jad_i_jw || jad_i_anVar.jad_i_kx)) {
            if (jad_i_anVar.jad_i_kx) {
                ordinal = CommonConstants.ClickFrom.CUSTOM_CLOSE.ordinal();
            } else {
                ordinal = CommonConstants.ClickFrom.CLOSE.ordinal();
            }
            reportCloseEvent(ordinal);
        }
        callbackAdCloseOnUiThread();
    }

    @Override // com.jd.ad.sdk.interstitial.jad_i_an.jad_i_cp
    public void onAdExposure(View view, boolean z, String str, int i) {
        if (z) {
            reportDelayExposureEvent(str, i);
            callbackAdShowedOnUiThread();
        } else {
            reportExposureEvent(str, i);
        }
    }

    @Override // com.jd.ad.sdk.interstitial.jad_i_an.jad_i_cp
    public void onAdRenderFailed(int i, String str) {
        callbackAdRenderFailedOnUiThread(i, str);
    }

    @UiThread
    public void onAdRenderFailedCallback(int i, String str) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADInterstitialListener jADInterstitialListener = this.mJADAdListener;
        if (jADInterstitialListener != null) {
            jADInterstitialListener.onRenderFailure(i, str);
        }
    }

    @Override // com.jd.ad.sdk.interstitial.jad_i_an.jad_i_cp
    public void onAdRenderSuccess(View view) {
        callbackAdReadyOnUiThread(view);
    }

    @UiThread
    public void onAdShowedCallback() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADInterstitialListener jADInterstitialListener = this.mJADAdListener;
        if (jADInterstitialListener != null) {
            jADInterstitialListener.onExposure();
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
        this.mSlot.setAdDataRequestSourceType(1);
        JADMediator.getInstance().getAdService().loadAd(this.mInstanceId, this.mSlot, this);
    }

    public void removeInterstitialView() {
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.mInterstitialRender;
        if (jad_i_anVar != null) {
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.jad_i_an.jad_i_er(jad_i_anVar));
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

    public void showAd(Activity activity) {
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.mInterstitialRender;
        if (jad_i_anVar != null) {
            try {
                jad_i_anVar.jad_i_an(activity);
            } catch (Throwable th) {
                if (this.mSlot == null) {
                    return;
                }
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String requestId = this.mSlot.getRequestId();
                JADError jADError = JADError.EXPOSURE_EXCEPTION_ERROR;
                eventService.reportExceptionEvent(requestId, jADError.getCode(), jADError.getMessage(th.getMessage()));
                callbackAdCloseOnUiThread();
            }
        }
    }

    public void startRender() {
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = new com.jd.ad.sdk.interstitial.jad_i_an(getAppContext(), this.mSlot, this.mInstanceId, getImageUrl());
        this.mInterstitialRender = jad_i_anVar;
        jad_i_anVar.jad_i_hu = this;
        if (jad_i_anVar.jad_i_an() == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str = jad_i_anVar.jad_i_er;
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str, jADError.getCode(), jADError.getMessage(new String[0]), jad_i_anVar.jad_i_fs);
            jad_i_anVar.jad_i_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        Context jad_i_an2 = jad_i_anVar.jad_i_an();
        View view = null;
        if (jad_i_an2 != null) {
            try {
                view = LayoutInflater.from(jad_i_an2).inflate(ResourceUtils.getResourceId(jad_i_an2, "jad_interstitial_layout", "layout"), (ViewGroup) null);
            } catch (Exception e) {
                Logger.w("Exception while render: " + e, new Object[0]);
            }
        }
        jad_i_anVar.jad_i_jt = view;
        if (view == null) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            String str2 = jad_i_anVar.jad_i_er;
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jADError2.getMessage(new String[0]), jad_i_anVar.jad_i_fs);
            jad_i_anVar.jad_i_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        if (jad_i_anVar.jad_i_an() != null && jad_i_anVar.jad_i_bo != null) {
            try {
                jad_i_anVar.jad_i_ly = jad_i_anVar.jad_i_jt.findViewById(ResourceUtils.getResourceId(jad_i_anVar.jad_i_an(), "jad_interstitial_close", "id"));
            } catch (Exception e2) {
                Logger.w("Exception while render: " + e2, new Object[0]);
            }
            if (jad_i_anVar.jad_i_ly != null) {
                if (jad_i_anVar.jad_i_bo.isHideClose()) {
                    jad_i_anVar.jad_i_ly.setVisibility(8);
                } else {
                    jad_i_anVar.jad_i_ly.setVisibility(0);
                    jad_i_anVar.jad_i_ly.setOnClickListener(new com.jd.ad.sdk.jad_i_an.jad_i_an(jad_i_anVar));
                }
            }
        }
        if (jad_i_anVar.jad_i_jt != null && jad_i_anVar.jad_i_an() != null) {
            try {
                jad_i_anVar.jad_i_mz = (ImageView) jad_i_anVar.jad_i_jt.findViewById(ResourceUtils.getResourceId(jad_i_anVar.jad_i_an(), "jad_inserstitial_img", "id"));
            } catch (Exception e3) {
                Logger.w("Exception while render: " + e3, new Object[0]);
            }
            if (jad_i_anVar.jad_i_mz != null) {
                JADMediator.getInstance().getTouchService().registerTouchView(jad_i_anVar.jad_i_dq);
                jad_i_anVar.jad_i_mz.setClickable(true);
                jad_i_anVar.jad_i_mz.setOnTouchListener(new com.jd.ad.sdk.jad_i_an.jad_i_bo(jad_i_anVar));
                jad_i_anVar.jad_i_mz.setOnClickListener(new com.jd.ad.sdk.jad_i_an.jad_i_cp(jad_i_anVar));
            }
        }
        if (jad_i_anVar.jad_i_an() != null) {
            if (jad_i_anVar.jad_i_mz == null) {
                try {
                    jad_i_anVar.jad_i_mz = (ImageView) jad_i_anVar.jad_i_jt.findViewById(ResourceUtils.getResourceId(jad_i_anVar.jad_i_an(), "jad_inserstitial_img", "id"));
                } catch (Exception e4) {
                    Logger.w("Exception while render: " + e4, new Object[0]);
                }
            }
            if (TextUtils.isEmpty(jad_i_anVar.jad_i_cp)) {
                if (jad_i_anVar.jad_i_bo != null) {
                    JADEventService eventService3 = JADMediator.getInstance().getEventService();
                    String str3 = jad_i_anVar.jad_i_er;
                    JADError jADError3 = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
                    eventService3.reportRenderFailedEvent(str3, jADError3.getCode(), jad_i_anVar.jad_i_an(jADError3.getMessage(new String[0])), jad_i_anVar.jad_i_fs);
                }
                JADError jADError4 = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
                jad_i_anVar.jad_i_an(jADError4.getCode(), jADError4.getMessage(new String[0]));
                return;
            }
            JADMediator.getInstance().getFoundationService().loadImage(jad_i_anVar.jad_i_an(), jad_i_anVar.jad_i_cp, new com.jd.ad.sdk.jad_i_an.jad_i_dq(jad_i_anVar));
        }
    }
}
