package com.jd.ad.sdk.splash;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.fdt.utils.ResourceUtils;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.splash.JADSplash;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import xx0X0.oIX0oI;

/* loaded from: classes10.dex */
public class jad_s_bo implements DynamicRenderView.IDynamicRenderCallback {
    public WeakReference<Context> jad_s_an;
    public final JADSlot jad_s_bo;
    public String jad_s_cp;
    public String jad_s_dq;
    public String jad_s_er;
    public int jad_s_fs;
    public jad_s_cp jad_s_hu;
    public View jad_s_iv;
    public View jad_s_jt;
    public int jad_s_jw;
    public JADSplashSkipView jad_s_kx;
    public JADSplashCountDownListener jad_s_ly;

    /* loaded from: classes10.dex */
    public class jad_s_an implements View.OnTouchListener {
        public jad_s_an(jad_s_bo jad_s_boVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* renamed from: com.jd.ad.sdk.splash.jad_s_bo$jad_s_bo, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public class C0721jad_s_bo implements OnImageLoadListener {
        public final /* synthetic */ ImageView jad_s_an;
        public final /* synthetic */ View jad_s_bo;

        public C0721jad_s_bo(ImageView imageView, View view) {
            this.jad_s_an = imageView;
            this.jad_s_bo = view;
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadFailed(int i, String str, @Nullable Drawable drawable) {
            jad_s_bo jad_s_boVar = jad_s_bo.this;
            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(jad_s_bo.this.jad_s_er, jADError.getCode(), jad_s_boVar.jad_s_an(jADError.getMessage(new String[0])), jad_s_bo.this.jad_s_fs);
            jad_s_bo.this.jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
        }

        @Override // com.jd.ad.sdk.fdt.imageloader.OnImageLoadListener
        public void onLoadSuccess(@NonNull Drawable drawable) {
            ImageView imageView = this.jad_s_an;
            if (imageView != null) {
                imageView.setImageDrawable(drawable);
            }
            jad_s_bo.this.jad_s_an(this.jad_s_bo, 1);
        }
    }

    /* loaded from: classes10.dex */
    public interface jad_s_cp {
    }

    public jad_s_bo(Context context, JADSlot jADSlot, String str, String str2) {
        this.jad_s_cp = "";
        this.jad_s_dq = "";
        this.jad_s_er = "";
        this.jad_s_fs = 0;
        if (context == null) {
            Logger.w("Context can not be null !!!", new Object[0]);
        } else {
            this.jad_s_an = new WeakReference<>(context);
        }
        this.jad_s_bo = jADSlot;
        if (jADSlot != null) {
            this.jad_s_er = jADSlot.getRequestId();
            this.jad_s_fs = jADSlot.getSen();
        }
        this.jad_s_dq = str;
        this.jad_s_cp = str2;
    }

    public static void jad_s_an(jad_s_bo jad_s_boVar, View view) {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        jad_s_boVar.getClass();
        JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_boVar.jad_s_dq);
        jad_s_cp jad_s_cpVar = jad_s_boVar.jad_s_hu;
        if (jad_s_cpVar == null || (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) == null || weakReference.get() == null) {
            return;
        }
        JADSplash jADSplash = jad_s_kxVar.jad_s_an.get();
        jADSplash.reportCloseEvent(CommonConstants.ClickFrom.CLOSE.ordinal());
        if (view != null) {
            jADSplash.callbackAdCloseOnUiThread();
        }
    }

    @Nullable
    public final Context jad_s_bo() {
        WeakReference<Context> weakReference = this.jad_s_an;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final FrameLayout.LayoutParams jad_s_cp() {
        return new FrameLayout.LayoutParams(-1, -2);
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onAnimationEnd() {
        jad_s_an();
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderFailed(int i, String str) {
        if (jad_s_bo() != null) {
            Context jad_s_bo = jad_s_bo();
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            String message = jADError.getMessage(new String[0]);
            if (jad_s_bo == null || this.jad_s_bo == null) {
                JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
                jad_s_an(code, message);
            }
            this.jad_s_bo.setRem(1);
            int templateId = this.jad_s_bo.getTemplateId();
            View view = null;
            if (templateId != CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_4.getTemplateId() && templateId != CommonConstants.AdTmp.TEMPLATE_SPLASH_SINGLE_IMAGE_8.getTemplateId()) {
                JADError jADError2 = JADError.RENDER_SPLASH_RESPONSE_TEMPLATE_ID_ERROR;
                code = jADError2.getCode();
                message = jADError2.getMessage(new String[0]);
            } else {
                try {
                    view = LayoutInflater.from(jad_s_bo).inflate(ResourceUtils.getResourceId(jad_s_bo, "jad_splash_layout", "layout"), (ViewGroup) null);
                } catch (Exception e) {
                    Logger.w("Exception while render: " + e, new Object[0]);
                }
            }
            if (view == null) {
                JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
                jad_s_an(code, message);
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int dip2px = (int) ScreenUtils.dip2px(jad_s_bo, this.jad_s_bo.getWidth());
            int dip2px2 = (int) ScreenUtils.dip2px(jad_s_bo, this.jad_s_bo.getHeight());
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(dip2px, dip2px2);
            } else {
                layoutParams.height = dip2px2;
                layoutParams.width = dip2px;
            }
            view.setLayoutParams(layoutParams);
            try {
                this.jad_s_kx = (JADSplashSkipView) view.findViewById(ResourceUtils.getResourceId(jad_s_bo, "jad_splash_skip_btn", "id"));
            } catch (Exception e2) {
                Logger.d("Exception while render: " + e2);
            }
            if (this.jad_s_kx != null) {
                if (this.jad_s_bo.isHideSkip()) {
                    this.jad_s_kx.setVisibility(8);
                } else {
                    this.jad_s_kx.setVisibility(0);
                }
                JADSplashSkipView jADSplashSkipView = this.jad_s_kx;
                int skipTime = this.jad_s_bo.getSkipTime();
                com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = new com.jd.ad.sdk.splash.jad_s_an(this);
                jADSplashSkipView.jad_s_an = skipTime;
                jADSplashSkipView.jad_s_bo = jad_s_anVar;
                jADSplashSkipView.setOnClickListener(new jad_s_dq(jADSplashSkipView));
            }
            try {
                ImageView imageView = (ImageView) view.findViewById(ResourceUtils.getResourceId(jad_s_bo(), "jad_splash_image", "id"));
                jad_s_an(imageView, view);
                jad_s_an(jad_s_bo(), view, imageView);
                return;
            } catch (Exception e3) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String str2 = this.jad_s_er;
                JADError jADError3 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
                eventService.reportRenderFailedEvent(str2, jADError3.getCode(), jADError3.getMessage(e3.toString()), this.jad_s_fs);
                jad_s_an(jADError3.getCode(), jADError3.getMessage(e3.toString()));
                return;
            }
        }
        JADError jADError4 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
        JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, jADError4.getCode(), jad_s_an(jADError4.getMessage(new String[0])), this.jad_s_fs);
        jad_s_an(jADError4.getCode(), jADError4.getMessage(new String[0]));
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public void onDynamicRenderSuccess(View view) {
        try {
            JADError jADError = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            int code = jADError.getCode();
            String message = jADError.getMessage(new String[0]);
            if (view != null && this.jad_s_bo != null) {
                this.jad_s_iv = view;
                jad_s_an(view, 3);
                return;
            }
            JADMediator.getInstance().getEventService().reportRenderFailedEvent(this.jad_s_er, code, message, this.jad_s_fs);
            jad_s_an(code, message);
        } catch (Exception e) {
            JADError jADError2 = JADError.RENDER_CREATE_AD_VIEW_FAIL_ERROR;
            jad_s_an(jADError2.getCode(), jADError2.getMessage(e.toString()));
        }
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.DynamicRenderView.IDynamicRenderCallback
    public /* synthetic */ void onFullLottieViewClick(Context context) {
        oIX0oI.II0xO0(this, context);
    }

    public JSONObject jad_s_an(Exception exc) {
        JSONObject jSONObject = new JSONObject();
        String message = exc.getMessage();
        int code = JADError.RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR.getCode();
        try {
            try {
                for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
                    String message2 = cause.getMessage();
                    if (!TextUtils.isEmpty(message2) && message2.startsWith("40")) {
                        String[] split = message2.split(HelpFormatter.DEFAULT_OPT_PREFIX);
                        code = Integer.parseInt(split[0]);
                        message = message + "|" + split[1];
                    } else {
                        message = message + "|" + message2;
                    }
                }
                jSONObject.put("code", code);
                jSONObject.put("msg", message);
            } catch (Exception unused) {
                Logger.d("错误信息拼接异常");
                jSONObject.put("code", code);
                jSONObject.put("msg", message);
            }
            return jSONObject;
        } catch (Throwable th) {
            jSONObject.put("code", code);
            jSONObject.put("msg", message);
            throw th;
        }
    }

    public String jad_s_an(String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        JADSlot jADSlot = this.jad_s_bo;
        if (jADSlot != null) {
            str2 = jADSlot.getSlotID();
        } else {
            str2 = "";
        }
        JsonUtils.put(jSONObject, "pid", str2);
        JsonUtils.put(jSONObject, "adt", 1);
        JsonUtils.put(jSONObject, "error", str);
        return jSONObject.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009b  */
    @android.annotation.SuppressLint({"InflateParams"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void jad_s_an(android.content.Context r11, android.view.View r12, android.widget.ImageView r13) {
        /*
            r10 = this;
            if (r11 == 0) goto Lb3
            com.jd.ad.sdk.dl.model.JADSlot r0 = r10.jad_s_bo
            if (r0 != 0) goto L8
            goto Lb3
        L8:
            android.content.Context r0 = r10.jad_s_bo()
            java.lang.String r1 = "jad_splash_click_area_container"
            java.lang.String r2 = "id"
            int r0 = com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(r0, r1, r2)
            android.view.View r0 = r12.findViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            android.view.LayoutInflater r1 = android.view.LayoutInflater.from(r11)
            com.jd.ad.sdk.dl.model.JADSlot r2 = r10.jad_s_bo
            int r2 = r2.getClickAreaType()
            r3 = 2
            r4 = 4
            r5 = 3
            r6 = 1
            if (r2 != r6) goto L2b
            goto L3c
        L2b:
            if (r2 != r3) goto L2e
            goto L40
        L2e:
            if (r2 != r5) goto L31
            goto L44
        L31:
            if (r2 != r4) goto L34
            goto L48
        L34:
            com.jd.ad.sdk.dl.model.JADSlot r2 = r10.jad_s_bo
            int r2 = r2.getModelClickAreaType()
            if (r2 != r6) goto L3e
        L3c:
            r2 = 2
            goto L4b
        L3e:
            if (r2 != r3) goto L42
        L40:
            r2 = 3
            goto L4b
        L42:
            if (r2 != r5) goto L46
        L44:
            r2 = 4
            goto L4b
        L46:
            if (r2 != r4) goto L4a
        L48:
            r2 = 5
            goto L4b
        L4a:
            r2 = 1
        L4b:
            int r2 = com.jd.ad.sdk.jad_s_an.jad_s_fs.jad_s_an(r2)
            r7 = 0
            r8 = 0
            java.lang.String r9 = "layout"
            if (r2 == r6) goto L9b
            if (r2 == r5) goto L91
            java.lang.String r5 = "jad_splash_click_area_type2"
            if (r2 == r4) goto L7a
            int r11 = com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(r11, r5, r9)
            android.view.View r11 = r1.inflate(r11, r8)
            com.jd.ad.sdk.splash.jad_s_bo$jad_s_an r12 = new com.jd.ad.sdk.splash.jad_s_bo$jad_s_an
            r12.<init>(r10)
            r13.setOnTouchListener(r12)
            android.widget.FrameLayout$LayoutParams r12 = r10.jad_s_cp()
            r0.addView(r11, r12)
            r0.setVisibility(r7)
            r10.jad_s_iv = r11
            r10.jad_s_jw = r3
            goto Lb3
        L7a:
            int r11 = com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(r11, r5, r9)
            android.view.View r11 = r1.inflate(r11, r8)
            android.widget.FrameLayout$LayoutParams r13 = r10.jad_s_cp()
            r0.addView(r11, r13)
            r0.setVisibility(r7)
            r10.jad_s_iv = r12
            r10.jad_s_jw = r4
            goto Lb3
        L91:
            r11 = 8
            r0.setVisibility(r11)
            r10.jad_s_iv = r12
            r10.jad_s_jw = r5
            goto Lb3
        L9b:
            java.lang.String r13 = "jad_splash_click_area_type1"
            int r11 = com.jd.ad.sdk.fdt.utils.ResourceUtils.getResourceId(r11, r13, r9)
            android.view.View r11 = r1.inflate(r11, r8)
            android.widget.FrameLayout$LayoutParams r13 = r10.jad_s_cp()
            r0.addView(r11, r13)
            r0.setVisibility(r7)
            r10.jad_s_iv = r12
            r10.jad_s_jw = r6
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.splash.jad_s_bo.jad_s_an(android.content.Context, android.view.View, android.widget.ImageView):void");
    }

    public final void jad_s_an(ImageView imageView, View view) {
        if (jad_s_bo() != null) {
            if (TextUtils.isEmpty(this.jad_s_cp)) {
                JADEventService eventService = JADMediator.getInstance().getEventService();
                String str = this.jad_s_er;
                JADError jADError = JADError.RENDER_IMAGE_URL_IS_NULL_ERROR;
                eventService.reportRenderFailedEvent(str, jADError.getCode(), jad_s_an(jADError.getMessage(new String[0])), this.jad_s_fs);
                jad_s_an(jADError.getCode(), jADError.getMessage(new String[0]));
                return;
            }
            JADMediator.getInstance().getFoundationService().loadImage(jad_s_bo(), this.jad_s_cp, new C0721jad_s_bo(imageView, view));
            return;
        }
        JADEventService eventService2 = JADMediator.getInstance().getEventService();
        String str2 = this.jad_s_er;
        JADError jADError2 = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
        eventService2.reportRenderFailedEvent(str2, jADError2.getCode(), jad_s_an(jADError2.getMessage(new String[0])), this.jad_s_fs);
        jad_s_an(jADError2.getCode(), jADError2.getMessage(new String[0]));
    }

    public static void jad_s_an(jad_s_bo jad_s_boVar, Context context, View view, int i, int i2, int i3) {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        if (jad_s_boVar.jad_s_jt != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_s_boVar.jad_s_dq);
        }
        int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(context, view, jad_s_boVar.jad_s_dq);
        jad_s_cp jad_s_cpVar = jad_s_boVar.jad_s_hu;
        if (jad_s_cpVar == null || (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) == null || weakReference.get() == null) {
            return;
        }
        JADSplash jADSplash = jad_s_kxVar.jad_s_an.get();
        jADSplash.reportClickEvent(onViewClicked, i, i2, i3);
        jADSplash.callbackAdClickOnUiThread();
    }

    public static void jad_s_an(jad_s_bo jad_s_boVar, View view, boolean z, String str, int i, int i2) {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        jad_s_cp jad_s_cpVar = jad_s_boVar.jad_s_hu;
        if (jad_s_cpVar == null || (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) == null || weakReference.get() == null) {
            return;
        }
        JADSplash jADSplash = jad_s_kxVar.jad_s_an.get();
        jADSplash.calculateClickArea();
        if (z) {
            jADSplash.reportDelayExposureEvent(str, i, i2);
            jADSplash.callbackAdShowedOnUiThread();
        } else {
            jADSplash.reportExposureEvent(str, i, i2);
        }
    }

    public final void jad_s_an() {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        JADSplash jADSplash;
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar == null || (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) == null || weakReference.get() == null || (jADSplash = jad_s_kxVar.jad_s_an.get()) == null) {
            return;
        }
        jADSplash.callbackAdCloseOnUiThread();
        jADSplash.destroy();
    }

    public final void jad_s_an(int i, String str) {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar == null || (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) == null || weakReference.get() == null) {
            return;
        }
        jad_s_kxVar.jad_s_an.get().callbackAdRenderFailedOnUiThread(i, str);
    }

    public final void jad_s_an(@NonNull View view, int i) {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        this.jad_s_jt = view;
        if (view != null) {
            JADMediator.getInstance().getExposureService().registerExposureView(this.jad_s_dq);
            View view2 = this.jad_s_jt;
            JADMediator.getInstance().getExposureService().setViewExposureCallback(this.jad_s_dq, 1, view2, new com.jd.ad.sdk.jad_s_an.jad_s_an(this, i, view2));
        }
        if (this.jad_s_iv != null) {
            JADMediator.getInstance().getTouchService().registerTouchView(this.jad_s_dq);
            if (i == 3) {
                try {
                    if (jad_s_bo() != null) {
                        JADMediator.getInstance().getDynamicRenderService().registerAdViewClick(jad_s_bo(), (DynamicRenderView) this.jad_s_jt, new com.jd.ad.sdk.jad_s_an.jad_s_bo(this));
                    }
                } catch (Exception e) {
                    Logger.d(Log.getStackTraceString(e));
                }
            } else {
                View view3 = this.jad_s_iv;
                if (view3 != null) {
                    view3.setClickable(true);
                    this.jad_s_iv.setOnTouchListener(new com.jd.ad.sdk.jad_s_an.jad_s_cp(this));
                    this.jad_s_iv.setOnClickListener(new com.jd.ad.sdk.jad_s_an.jad_s_dq(this));
                }
            }
        }
        jad_s_cp jad_s_cpVar = this.jad_s_hu;
        if (jad_s_cpVar == null || (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) == null || weakReference.get() == null) {
            return;
        }
        jad_s_kxVar.jad_s_an.get().callbackAdReadyOnUiThread(view);
    }

    public static void jad_s_an(jad_s_bo jad_s_boVar, int i) {
        JADSplash.jad_s_kx jad_s_kxVar;
        WeakReference<JADSplash> weakReference;
        jad_s_cp jad_s_cpVar = jad_s_boVar.jad_s_hu;
        if (jad_s_cpVar == null || (weakReference = (jad_s_kxVar = (JADSplash.jad_s_kx) jad_s_cpVar).jad_s_an) == null || weakReference.get() == null) {
            return;
        }
        jad_s_kxVar.jad_s_an.get().callbackAdCountDownOnUiThread(i);
    }
}
