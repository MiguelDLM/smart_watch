package com.jd.ad.sdk.interstitial;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADExposureService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.multi.R;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_i_an {
    public WeakReference<Context> jad_i_an;
    public final JADSlot jad_i_bo;
    public String jad_i_cp;
    public String jad_i_dq;
    public String jad_i_er;
    public int jad_i_fs;
    public jad_i_cp jad_i_hu;
    public Dialog jad_i_iv;
    public View jad_i_jt;
    public boolean jad_i_jw = false;
    public boolean jad_i_kx = false;
    public View jad_i_ly;
    public ImageView jad_i_mz;

    /* renamed from: com.jd.ad.sdk.interstitial.jad_i_an$jad_i_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class DialogInterfaceOnShowListenerC0678jad_i_an implements DialogInterface.OnShowListener {

        /* renamed from: com.jd.ad.sdk.interstitial.jad_i_an$jad_i_an$jad_i_an, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public class C0679jad_i_an implements JADExposureListener {
            public C0679jad_i_an() {
            }

            @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
            public void onDelayExposure(long j, String str, int i) {
                JADSlot jADSlot = jad_i_an.this.jad_i_bo;
                if (jADSlot != null) {
                    jADSlot.setImm(i);
                }
                jad_i_an jad_i_anVar = jad_i_an.this;
                jad_i_anVar.jad_i_an(jad_i_anVar.jad_i_jt, true, str, i);
            }

            @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
            public void onExposure(String str) {
                JADSlot jADSlot = jad_i_an.this.jad_i_bo;
                if (jADSlot != null) {
                    jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
                }
                jad_i_an jad_i_anVar = jad_i_an.this;
                jad_i_anVar.jad_i_an(jad_i_anVar.jad_i_jt, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
            }

            @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
            public void onFinishExposure() {
            }

            @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
            public void onPreExposure(String str) {
                JADSlot jADSlot = jad_i_an.this.jad_i_bo;
                if (jADSlot != null) {
                    jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
                }
                jad_i_an jad_i_anVar = jad_i_an.this;
                jad_i_anVar.jad_i_an(jad_i_anVar.jad_i_jt, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
            }
        }

        public DialogInterfaceOnShowListenerC0678jad_i_an() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            JADMediator.getInstance().getExposureService().registerExposureView(jad_i_an.this.jad_i_dq);
            JADExposureService exposureService = JADMediator.getInstance().getExposureService();
            jad_i_an jad_i_anVar = jad_i_an.this;
            exposureService.setViewExposureCallback(jad_i_anVar.jad_i_dq, 4, jad_i_anVar.jad_i_jt, new C0679jad_i_an());
        }
    }

    /* loaded from: classes10.dex */
    public class jad_i_bo implements DialogInterface.OnDismissListener {
        public jad_i_bo() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            jad_i_an jad_i_anVar = jad_i_an.this;
            View view = jad_i_anVar.jad_i_jt;
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_i_anVar.jad_i_dq);
            jad_i_cp jad_i_cpVar = jad_i_anVar.jad_i_hu;
            if (jad_i_cpVar != null) {
                jad_i_cpVar.onAdDismiss(view);
            }
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_i_cp {
        void onAdClicked(View view, int i);

        void onAdDismiss(View view);

        void onAdExposure(View view, boolean z, String str, int i);

        void onAdRenderFailed(int i, String str);

        void onAdRenderSuccess(View view);
    }

    public jad_i_an(Context context, JADSlot jADSlot, String str, String str2) {
        this.jad_i_cp = "";
        this.jad_i_dq = "";
        this.jad_i_er = "";
        this.jad_i_fs = 0;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.jad_i_an = new WeakReference<>(context);
        }
        this.jad_i_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_i_er = jADSlot.getRequestId();
            this.jad_i_fs = jADSlot.getSen();
        }
        this.jad_i_dq = str;
        this.jad_i_cp = str2;
    }

    @Nullable
    public final Context jad_i_an() {
        WeakReference<Context> weakReference = this.jad_i_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String jad_i_an(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.jad_i_bo;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
        } else {
            str2 = "";
        }
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "adt", 4);
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public void jad_i_an(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (this.jad_i_bo != null && this.jad_i_jt != null) {
                    Dialog dialog = new Dialog(activity, R.style.jad_native_insert_dialog);
                    this.jad_i_iv = dialog;
                    dialog.setCancelable(false);
                    this.jad_i_iv.setContentView(this.jad_i_jt);
                    this.jad_i_iv.setOnShowListener(new DialogInterfaceOnShowListenerC0678jad_i_an());
                    this.jad_i_iv.setOnDismissListener(new jad_i_bo());
                    this.jad_i_iv.setContentView(this.jad_i_jt);
                    this.jad_i_iv.show();
                    WindowManager.LayoutParams attributes = this.jad_i_iv.getWindow().getAttributes();
                    attributes.width = (int) ScreenUtils.dip2px(activity, this.jad_i_bo.getWidth());
                    attributes.height = (int) ScreenUtils.dip2px(activity, this.jad_i_bo.getHeight());
                    this.jad_i_iv.getWindow().setAttributes(attributes);
                    return;
                }
                Logger.w("广告被销毁", new Object[0]);
                throw new Exception("广告被销毁");
            }
            Logger.w("不能在子线程调用 showInteractionAd", new Object[0]);
            throw new Exception("不能在子线程调用 showInteractionAd");
        }
        Logger.w("activity is null or activity isFinishing", new Object[0]);
        throw new Exception("activity is null or activity isFinishing");
    }

    public void jad_i_an(int i, String str) {
        jad_i_cp jad_i_cpVar = this.jad_i_hu;
        if (jad_i_cpVar != null) {
            jad_i_cpVar.onAdRenderFailed(i, str);
        }
    }

    public void jad_i_an(View view, boolean z, String str, int i) {
        jad_i_cp jad_i_cpVar = this.jad_i_hu;
        if (jad_i_cpVar != null) {
            jad_i_cpVar.onAdExposure(view, z, str, i);
        }
    }
}
