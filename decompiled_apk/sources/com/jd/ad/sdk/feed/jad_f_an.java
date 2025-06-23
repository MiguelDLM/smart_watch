package com.jd.ad.sdk.feed;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class jad_f_an {
    public WeakReference<Context> jad_f_an;
    public final JADSlot jad_f_bo;
    public List<String> jad_f_cp;
    public String jad_f_dq;
    public String jad_f_er;
    public int jad_f_fs;
    public String jad_f_hu;
    public View jad_f_iv;
    public String jad_f_jt;
    public View.OnAttachStateChangeListener jad_f_jw;
    public InterfaceC0677jad_f_an jad_f_kx;

    /* renamed from: com.jd.ad.sdk.feed.jad_f_an$jad_f_an, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0677jad_f_an {
    }

    public jad_f_an(Context context, JADSlot jADSlot, String str, List<String> list, String str2, String str3) {
        this.jad_f_cp = new ArrayList();
        this.jad_f_dq = "";
        this.jad_f_er = "";
        this.jad_f_fs = 0;
        this.jad_f_jt = "";
        this.jad_f_hu = "";
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.jad_f_an = new WeakReference<>(context);
        }
        this.jad_f_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_f_er = jADSlot.getRequestId();
            this.jad_f_fs = jADSlot.getSen();
        }
        this.jad_f_dq = str;
        this.jad_f_cp = list;
        this.jad_f_jt = str2;
        this.jad_f_hu = str3;
    }

    public final ImageView jad_f_an(String str) {
        View view = this.jad_f_iv;
        if (view == null) {
            return null;
        }
        try {
            return (ImageView) view.findViewById(ResourceUtils.getResourceId(view.getContext(), str, "id"));
        } catch (Exception e) {
            Logger.w("Exception while get image: " + e, new Object[0]);
            return null;
        }
    }

    @Nullable
    public final Context jad_f_bo() {
        WeakReference<Context> weakReference = this.jad_f_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final String jad_f_cp() {
        List<String> list = this.jad_f_cp;
        if (list != null && !list.isEmpty()) {
            return this.jad_f_cp.get(0);
        }
        return "";
    }

    public final boolean jad_f_dq() {
        if (this.jad_f_bo.getTemplateId() == CommonConstants.AdTmp.TEMPLATE_GROUP_IMAGE.getTemplateId()) {
            return true;
        }
        return false;
    }

    public String jad_f_bo(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.jad_f_bo;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
        } else {
            str2 = "";
        }
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "adt", 2);
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    public void jad_f_an() {
        View view = this.jad_f_iv;
        if (view != null) {
            View.OnAttachStateChangeListener onAttachStateChangeListener = this.jad_f_jw;
            if (onAttachStateChangeListener != null) {
                view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
                this.jad_f_jw = null;
            }
            JADMediator.getInstance().getExposureService().unregisterExposureView(this.jad_f_dq);
            JADMediator.getInstance().getTouchService().unregisterTouchView(this.jad_f_dq);
            this.jad_f_iv = null;
        }
        this.jad_f_kx = null;
    }

    public void jad_f_an(View view, boolean z, String str, int i) {
        JADFeed.jad_f_jw jad_f_jwVar;
        WeakReference<JADFeed> weakReference;
        InterfaceC0677jad_f_an interfaceC0677jad_f_an = this.jad_f_kx;
        if (interfaceC0677jad_f_an == null || (weakReference = (jad_f_jwVar = (JADFeed.jad_f_jw) interfaceC0677jad_f_an).jad_f_an) == null || weakReference.get() == null) {
            return;
        }
        JADFeed jADFeed = jad_f_jwVar.jad_f_an.get();
        if (z) {
            jADFeed.reportDelayExposureEvent(str, i);
            jADFeed.callbackAdShowedOnUiThread();
        } else {
            jADFeed.reportExposureEvent(str, i);
        }
    }

    public void jad_f_an(View view) {
        JADFeed.jad_f_jw jad_f_jwVar;
        WeakReference<JADFeed> weakReference;
        InterfaceC0677jad_f_an interfaceC0677jad_f_an = this.jad_f_kx;
        if (interfaceC0677jad_f_an == null || (weakReference = (jad_f_jwVar = (JADFeed.jad_f_jw) interfaceC0677jad_f_an).jad_f_an) == null || weakReference.get() == null) {
            return;
        }
        jad_f_jwVar.jad_f_an.get().callbackAdReadyOnUiThread(view);
    }

    public void jad_f_an(int i, String str) {
        JADFeed.jad_f_jw jad_f_jwVar;
        WeakReference<JADFeed> weakReference;
        InterfaceC0677jad_f_an interfaceC0677jad_f_an = this.jad_f_kx;
        if (interfaceC0677jad_f_an == null || (weakReference = (jad_f_jwVar = (JADFeed.jad_f_jw) interfaceC0677jad_f_an).jad_f_an) == null || weakReference.get() == null) {
            return;
        }
        jad_f_jwVar.jad_f_an.get().callbackAdRenderFailedOnUiThread(i, str);
    }

    public void jad_f_an(View view, int i) {
        JADFeed.jad_f_jw jad_f_jwVar;
        WeakReference<JADFeed> weakReference;
        JADMediator.getInstance().getExposureService().setViewForceExposure(this.jad_f_dq);
        InterfaceC0677jad_f_an interfaceC0677jad_f_an = this.jad_f_kx;
        if (interfaceC0677jad_f_an == null || (weakReference = (jad_f_jwVar = (JADFeed.jad_f_jw) interfaceC0677jad_f_an).jad_f_an) == null || weakReference.get() == null) {
            return;
        }
        JADFeed jADFeed = jad_f_jwVar.jad_f_an.get();
        jADFeed.reportCloseEvent(i);
        jADFeed.callbackAdCloseOnUiThread();
    }
}
