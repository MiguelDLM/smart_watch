package com.jd.ad.sdk.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.jd.ad.sdk.a.a;
import com.jd.ad.sdk.bl.adload.IJADBase;
import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.bl.preload.PreloadAdDataCacheUsageManager;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.jad_s_bo;
import com.jd.ad.sdk.splash.jad_s_er;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class JADSplash implements IJADBase, JADAdLoadListener, jad_s_er.jad_s_an, PreloadAdDataCacheUsageManager.UseCacheCounterFinishCallback {
    private int dstp;
    private int mAttachActivityHashCode;
    private WeakReference<Context> mContextWf;
    private String mInstanceId;
    private JADSplashCountDownListener mJADCountDownListener;
    private JADSplashListener mJADListener;
    private final com.jd.ad.sdk.splash.jad_s_er mJADSplashTolerateManager;
    private ActLifecycle.OnLifecycleChangeListener mLifeChangeListener;
    private JADSlot mSlot;
    private com.jd.ad.sdk.splash.jad_s_bo mSplashAdRender;
    private int srtp;
    private int mSplashStylePlanType = 0;
    private int mSplashClickAreaValue = 100;

    /* loaded from: classes10.dex */
    public class jad_s_an implements Runnable {
        public final /* synthetic */ int jad_s_an;

        public jad_s_an(int i) {
            this.jad_s_an = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdCountDownCallback(this.jad_s_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_bo implements ActLifecycle.OnLifecycleChangeListener {
        public jad_s_bo() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.OnLifecycleChangeListener
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (activity.hashCode() == JADSplash.this.mAttachActivityHashCode) {
                JADSplash.this.destroy();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_cp implements Runnable {
        public jad_s_cp() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.startRender();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_dq implements Runnable {
        public jad_s_dq() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdLoadCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_er implements Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ String jad_s_bo;

        public jad_s_er(int i, String str) {
            this.jad_s_an = i;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdLoadFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_fs implements Runnable {
        public final /* synthetic */ View jad_s_an;

        public jad_s_fs(View view) {
            this.jad_s_an = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdRenderSucCallback(this.jad_s_an);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_hu implements Runnable {
        public jad_s_hu() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdClickCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_iv implements Runnable {
        public jad_s_iv() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdShowedCallback();
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_jt implements Runnable {
        public final /* synthetic */ int jad_s_an;
        public final /* synthetic */ String jad_s_bo;

        public jad_s_jt(int i, String str) {
            this.jad_s_an = i;
            this.jad_s_bo = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdRenderFailedCallback(this.jad_s_an, this.jad_s_bo);
        }
    }

    /* loaded from: classes10.dex */
    public class jad_s_jw implements Runnable {
        public jad_s_jw() {
        }

        @Override // java.lang.Runnable
        public void run() {
            JADSplash.this.onAdCloseCallback();
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_s_kx implements jad_s_bo.jad_s_cp {
        public WeakReference<JADSplash> jad_s_an;

        public jad_s_kx(JADSplash jADSplash) {
            this.jad_s_an = new WeakReference<>(jADSplash);
        }
    }

    public JADSplash(@NonNull Context context, @NonNull JADSlot jADSlot) {
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
        this.mJADSplashTolerateManager = getTolerateWidget(jADSlot.getTolerateTime());
        initActLifeListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateClickArea() {
        View view;
        DynamicRenderView dynamicRenderView;
        try {
            JADSlot jADSlot = this.mSlot;
            if (jADSlot == null) {
                return;
            }
            if (jADSlot.getRem() == 3) {
                this.mSplashStylePlanType = 6;
                com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar = this.mSplashAdRender;
                if (jad_s_boVar != null) {
                    View view2 = jad_s_boVar.jad_s_jt;
                    DynamicRenderView dynamicRenderView2 = null;
                    if (view2 != null && (view2 instanceof DynamicRenderView)) {
                        dynamicRenderView = (DynamicRenderView) view2;
                    } else {
                        dynamicRenderView = null;
                    }
                    if (dynamicRenderView != null) {
                        if (view2 != null && (view2 instanceof DynamicRenderView)) {
                            dynamicRenderView2 = (DynamicRenderView) view2;
                        }
                        this.mSplashClickAreaValue = dynamicRenderView2.getAdClickAreaValue();
                    }
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
                return;
            }
            com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar2 = this.mSplashAdRender;
            if (jad_s_boVar2 != null && jad_s_boVar2.jad_s_iv != null && (view = jad_s_boVar2.jad_s_jt) != null) {
                this.mSplashStylePlanType = jad_s_boVar2.jad_s_jw;
                int measuredWidth = (int) (view.getMeasuredWidth() * this.mSplashAdRender.jad_s_jt.getMeasuredHeight());
                int measuredWidth2 = this.mSplashAdRender.jad_s_iv.getMeasuredWidth() * this.mSplashAdRender.jad_s_iv.getMeasuredHeight();
                if (measuredWidth > 0) {
                    this.mSplashClickAreaValue = (measuredWidth2 * 100) / measuredWidth;
                }
                this.mSlot.setSspt(this.mSplashStylePlanType);
                this.mSlot.setScav(this.mSplashClickAreaValue);
            }
        } catch (Exception e) {
            StringBuilder a2 = a.a("Exception while calculate area: ");
            a2.append(e.getMessage());
            Logger.w(a2.toString(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdClickOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_hu());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdCloseOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_jw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdCountDownOnUiThread(int i) {
        HandlerUtils.runOnUiThread(new jad_s_an(i));
    }

    private void callbackAdLoadFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_s_er(i, str));
    }

    private void callbackAdLoadOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_dq());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdReadyOnUiThread(View view) {
        reportRenderSuccessEvent();
        HandlerUtils.runOnUiThread(new jad_s_fs(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdRenderFailedOnUiThread(int i, String str) {
        HandlerUtils.runOnUiThread(new jad_s_jt(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackAdShowedOnUiThread() {
        HandlerUtils.runOnUiThread(new jad_s_iv());
    }

    private void doAfterPreloadFinished() {
        JADMediator.getInstance().getAdService().unregisterAdPreloader(this.mInstanceId, this.mSlot);
        JADMediator.getInstance().getAdService().unregisterAd(this.mInstanceId);
    }

    private int getAdType() {
        return 1;
    }

    @Nullable
    private Context getAppContext() {
        WeakReference<Context> weakReference = this.mContextWf;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private int getDisplayScene() {
        return 4;
    }

    private String getImageUrl() {
        if (getJADMaterialData() != null && getJADMaterialData().getImageUrls() != null && !getJADMaterialData().getImageUrls().isEmpty()) {
            return getJADMaterialData().getImageUrls().get(0);
        }
        return "";
    }

    private String getTolerateTimeFinishErin(String str) {
        String str2;
        float f;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.mSlot;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
            f = this.mSlot.getTolerateTime();
        } else {
            str2 = "";
            f = 0.0f;
        }
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "adt", Integer.valueOf(getAdType()));
        JsonUtils.put(jSONObject, "toti", Float.valueOf(f));
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    private com.jd.ad.sdk.splash.jad_s_er getTolerateWidget(float f) {
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = new com.jd.ad.sdk.splash.jad_s_er(f);
        jad_s_erVar.jad_s_dq = this;
        return jad_s_erVar;
    }

    private void initActLifeListener() {
        if (this.mAttachActivityHashCode != -1) {
            jad_s_bo jad_s_boVar = new jad_s_bo();
            this.mLifeChangeListener = jad_s_boVar;
            ActLifecycle.addLifecycleListener(jad_s_boVar);
        }
    }

    private void notifyRender() {
        HandlerUtils.runOnUiThread(new jad_s_cp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdClickCallback() {
        StringBuilder a2 = a.a("seven_back=====onAdClickCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdCloseCallback() {
        StringBuilder a2 = a.a("seven_back=====onAdCloseCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an();
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onClose();
        }
        this.mJADListener = null;
        destroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdCountDownCallback(int i) {
        StringBuilder a2 = a.a("seven_back=====onAdCountDownCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            jADSplashCountDownListener.onCountdown(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdLoadCallback() {
        StringBuilder a2 = a.a("seven_back=====onAdLoadCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("The current thread is not the main thread!!", new Object[0]);
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an = true;
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdLoadFailedCallback(int i, String str) {
        StringBuilder a2 = a.a("seven_back=====onAdLoadFailedCallback====TYPE=");
        a2.append(getAdType());
        a2.append(",code=");
        a2.append(i);
        a2.append(",error=");
        a2.append(str);
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an();
        }
        if (this.mSlot != null) {
            JADMediator.getInstance().getAdService().printRequestData(this.mSlot);
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onLoadFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdRenderFailedCallback(int i, String str) {
        StringBuilder a2 = a.a("seven_back=====onAdRenderFailedCallback====TYPE=");
        a2.append(getAdType());
        a2.append(",code=");
        a2.append(i);
        a2.append(",error=");
        a2.append(str);
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null) {
            jad_s_erVar.jad_s_an();
        }
        if (TextUtils.isEmpty(str)) {
            str = JADError.DEFAULT_ERROR.getMessage(new String[0]);
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onRenderFailure(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdRenderSucCallback(View view) {
        StringBuilder a2 = a.a("seven_back=====onAdRenderCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.w("seven_back===thread error!!", new Object[0]);
        }
        if (view == null) {
            if (this.mSlot != null) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String requestId = this.mSlot.getRequestId();
                JADError jADError = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
                eventService.reportRenderFailedEvent(requestId, jADError.getCode(), jADError.getMessage(new String[0]), this.mSlot.getSen());
            }
            com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
            if (jad_s_erVar != null) {
                jad_s_erVar.jad_s_an();
            }
            JADSplashListener jADSplashListener = this.mJADListener;
            if (jADSplashListener != null) {
                JADError jADError2 = JADError.RENDER_AD_VIEW_IS_NULL_ERROR;
                jADSplashListener.onRenderFailure(jADError2.getCode(), jADError2.getMessage(new String[0]));
                return;
            }
            return;
        }
        if (view.getParent() instanceof ViewGroup) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar2 = this.mJADSplashTolerateManager;
        if (jad_s_erVar2 != null) {
            jad_s_erVar2.jad_s_an();
        }
        JADSplashListener jADSplashListener2 = this.mJADListener;
        if (jADSplashListener2 != null) {
            jADSplashListener2.onRenderSuccess(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public void onAdShowedCallback() {
        StringBuilder a2 = a.a("seven_back=====onAdShowedCallback====TYPE=");
        a2.append(getAdType());
        Logger.d(a2.toString());
        if (Looper.getMainLooper() != Looper.myLooper()) {
            Logger.d("seven_back===thread error!!");
        }
        JADSplashListener jADSplashListener = this.mJADListener;
        if (jADSplashListener != null) {
            jADSplashListener.onExposure();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportClickEvent(int i, int i2, int i3, int i4) {
        JADSlot jADSlot;
        if (i == -2 || (jADSlot = this.mSlot) == null) {
            return;
        }
        jADSlot.setClickTime(System.currentTimeMillis());
        long clickTime = this.mSlot.getClickTime() - this.mSlot.getLoadTime();
        long clickTime2 = this.mSlot.getClickTime() - this.mSlot.getLoadSucTime();
        long clickTime3 = this.mSlot.getClickTime() - this.mSlot.getShowTime();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i4, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadClickEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, this.mSlot.getEventInteractionType(), i4, this.mSlot.getModelClickAreaType(), this.dstp, this.srtp);
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
            JADMediator.getInstance().getEventService().reportCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadCloseEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), -1, clickTime, clickTime2, clickTime3, this.mSplashStylePlanType, this.mSplashClickAreaValue, i, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDelayExposureEvent(String str, int i, int i2) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setDelayShowTime(System.currentTimeMillis());
        long delayShowTime = this.mSlot.getDelayShowTime() - this.mSlot.getLoadTime();
        long delayShowTime2 = this.mSlot.getDelayShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(delayShowTime);
        this.mSlot.setDedu(delayShowTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, delayShowTime, delayShowTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportExposureEvent(String str, int i, int i2) {
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setShowTime(System.currentTimeMillis());
        long showTime = this.mSlot.getShowTime() - this.mSlot.getLoadTime();
        long showTime2 = this.mSlot.getShowTime() - this.mSlot.getLoadSucTime();
        this.mSlot.setSedu(showTime);
        this.mSlot.setDedu(showTime2);
        this.mSlot.setSspt(this.mSplashStylePlanType);
        this.mSlot.setScav(this.mSplashClickAreaValue);
        this.mSlot.setExposureExtend(str);
        this.mSlot.setDstp(this.dstp);
        this.mSlot.setSrtp(this.srtp);
        int eventInteractionType = this.mSlot.getEventInteractionType();
        int modelClickAreaType = this.mSlot.getModelClickAreaType();
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadExposureEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), i2, i, showTime, showTime2, this.mSplashStylePlanType, this.mSplashClickAreaValue, eventInteractionType, modelClickAreaType, str, this.dstp, this.srtp);
        }
    }

    private void reportRenderSuccessEvent() {
        long j;
        JADSlot jADSlot = this.mSlot;
        if (jADSlot == null) {
            return;
        }
        jADSlot.setRenderSucTime(System.currentTimeMillis());
        long renderSucTime = this.mSlot.getRenderSucTime() - this.mSlot.getLoadTime();
        long dynamicRenderViewInitSuccessTime = this.mSlot.getDynamicRenderViewInitSuccessTime();
        if (dynamicRenderViewInitSuccessTime > 0) {
            long loadTime = dynamicRenderViewInitSuccessTime - this.mSlot.getLoadTime();
            Logger.d("dynamic render view init time:" + loadTime);
            j = loadTime;
        } else {
            j = 0;
        }
        if (this.mSlot.getAdDataRequestSourceType() != 1 && this.mSlot.getAdDataRequestSourceType() != 2) {
            JADMediator.getInstance().getEventService().reportRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        } else {
            JADMediator.getInstance().getEventService().reportPreloadRenderSuccessEvent(this.mSlot.getRequestId(), this.mSlot.getSlotID(), getAdType(), this.mSlot.getTemplateId(), this.mSlot.getSen(), this.mSlot.getRem(), renderSucTime, j, this.mSlot.getEventInteractionType(), this.mSlot.getModelClickAreaType(), this.mSlot.getMediaSpecSetType(), this.dstp, this.srtp);
        }
    }

    private void startPreloadAdDataTimeCounter() {
        PreloadAdDataCacheUsageManager preloadAdDataCacheUsageManager = new PreloadAdDataCacheUsageManager();
        preloadAdDataCacheUsageManager.setCounterFinishCallback(this);
        preloadAdDataCacheUsageManager.startPreloadAdDataCacheUsageTimeCounter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRender() {
        JADSlot jADSlot;
        com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar = new com.jd.ad.sdk.splash.jad_s_bo(getAppContext(), this.mSlot, this.mInstanceId, getImageUrl());
        this.mSplashAdRender = jad_s_boVar;
        jad_s_boVar.jad_s_hu = new jad_s_kx(this);
        JADSplashCountDownListener jADSplashCountDownListener = this.mJADCountDownListener;
        if (jADSplashCountDownListener != null) {
            this.mSplashAdRender.jad_s_ly = jADSplashCountDownListener;
        }
        com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar2 = this.mSplashAdRender;
        if (jad_s_boVar2.jad_s_bo == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            String str = jad_s_boVar2.jad_s_er;
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService.reportRenderFailedEvent(str, jADError.getCode(), jADError.getMessage(new String[0]), jad_s_boVar2.jad_s_fs);
            jad_s_boVar2.jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        if (jad_s_boVar2.jad_s_bo() == null) {
            JADEventService eventService2 = JADMediator.getInstance().getEventService();
            String str2 = jad_s_boVar2.jad_s_er;
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jADError2.getMessage(new String[0]), jad_s_boVar2.jad_s_fs);
            jad_s_boVar2.jad_s_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
            return;
        }
        Context jad_s_bo2 = jad_s_boVar2.jad_s_bo();
        JADError jADError3 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
        int code = jADError3.getCode();
        String message = jADError3.getMessage(new String[0]);
        if (jad_s_bo2 != null && (jADSlot = jad_s_boVar2.jad_s_bo) != null) {
            if (jADSlot.getDynamicRenderTemplateHelper() != null) {
                try {
                    if (JADMediator.getInstance().getDynamicRenderService().createDynamicView(jad_s_bo2, jad_s_boVar2.jad_s_dq, jad_s_boVar2.jad_s_bo, jad_s_boVar2) == null) {
                        JADError jADError4 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                        jad_s_boVar2.onDynamicRenderFailed(jADError4.getCode(), jADError4.getMessage(new String[0]));
                    } else {
                        jad_s_boVar2.jad_s_bo.setDynamicRenderViewInitSuccessTime(System.currentTimeMillis());
                        jad_s_boVar2.jad_s_bo.setRem(3);
                    }
                    return;
                } catch (Throwable th) {
                    try {
                        Exception exc = new Exception("dynamic render view init error", th);
                        JSONObject jad_s_an2 = jad_s_boVar2.jad_s_an(exc);
                        int optInt = jad_s_an2.optInt("code");
                        JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_boVar2.jad_s_er, optInt, jad_s_an2.optString("msg"), jad_s_boVar2.jad_s_fs);
                        Logger.d(optInt + ": " + Log.getStackTraceString(exc));
                    } catch (Exception e) {
                        Logger.d(Log.getStackTraceString(e));
                    }
                    jad_s_boVar2.onDynamicRenderFailed(code, message);
                    return;
                }
            }
            jad_s_boVar2.onDynamicRenderFailed(code, message);
            return;
        }
        JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_boVar2.jad_s_er, code, message, jad_s_boVar2.jad_s_fs);
        jad_s_boVar2.jad_s_an(code, message);
    }

    public void destroy() {
        com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar = this.mSplashAdRender;
        if (jad_s_boVar != null) {
            JADMediator.getInstance().getTouchService().unregisterTouchView(jad_s_boVar.jad_s_dq);
            JADMediator.getInstance().getExposureService().unregisterExposureView(jad_s_boVar.jad_s_dq);
            jad_s_boVar.jad_s_jt = null;
            jad_s_boVar.jad_s_iv = null;
            jad_s_boVar.jad_s_hu = null;
            this.mSplashAdRender = null;
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

    public final IJADExtra getJADExtra() {
        return JADMediator.getInstance().getAdService().getJADExtra(this.mInstanceId);
    }

    @Nullable
    public JADMaterialData getJADMaterialData() {
        List<JADMaterialData> jADMaterialDataList = JADMediator.getInstance().getAdService().getJADMaterialDataList(this.mInstanceId);
        if (jADMaterialDataList != null && !jADMaterialDataList.isEmpty() && jADMaterialDataList.get(0) != null) {
            return jADMaterialDataList.get(0);
        }
        return null;
    }

    public final void loadAd(JADSplashListener jADSplashListener) {
        Handler handler;
        this.mJADListener = jADSplashListener;
        String uuid = UUIDUtils.uuid();
        if (this.mSlot == null) {
            JADEventService eventService = JADMediator.getInstance().getEventService();
            JADError jADError = JADError.GW_REQUEST_SLOT_IS_NULL_ERROR;
            eventService.reportRequestErrorEvent(uuid, jADError.getCode(), getErin(jADError.getMessage(new String[0])));
            callbackAdLoadFailedOnUiThread(jADError.getCode(), jADError.getMessage(new String[0]));
            return;
        }
        com.jd.ad.sdk.splash.jad_s_er jad_s_erVar = this.mJADSplashTolerateManager;
        if (jad_s_erVar != null && (handler = jad_s_erVar.jad_s_cp) != null) {
            handler.sendEmptyMessageDelayed(1, jad_s_erVar.jad_s_bo * 1000.0f);
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

    @Override // com.jd.ad.sdk.splash.jad_s_er.jad_s_an
    public void onCounterFinish() {
        String str;
        int i;
        if (this.mJADSplashTolerateManager != null) {
            JADSlot jADSlot = this.mSlot;
            if (jADSlot != null) {
                str = jADSlot.getRequestId();
                i = this.mSlot.getSen();
            } else {
                str = "";
                i = 0;
            }
            if (!this.mJADSplashTolerateManager.jad_s_an) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                JADError jADError = JADError.GW_RESPONSE_TOLERATE_TIME_ERROR;
                eventService.reportRequestErrorEvent(str, jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new String[0])));
                onAdLoadFailedCallback(jADError.getCode(), getTolerateTimeFinishErin(jADError.getMessage(new String[0])));
            } else {
                JADEventService eventService2 = JADMediator.getInstance().getEventService();
                JADError jADError2 = JADError.RENDER_TOLERATE_TIME_ERROR;
                eventService2.reportRenderFailedEvent(str, jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new String[0])), i);
                onAdRenderFailedCallback(jADError2.getCode(), getTolerateTimeFinishErin(jADError2.getMessage(new String[0])));
            }
            this.mJADListener = null;
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

    public final void removeSplashView() {
        com.jd.ad.sdk.splash.jad_s_bo jad_s_boVar = this.mSplashAdRender;
        if (jad_s_boVar != null) {
            HandlerUtils.runOnUiThread(new com.jd.ad.sdk.splash.jad_s_cp(jad_s_boVar));
        }
    }

    public void setCountDownListener(JADSplashCountDownListener jADSplashCountDownListener) {
        this.mJADCountDownListener = jADSplashCountDownListener;
    }
}
