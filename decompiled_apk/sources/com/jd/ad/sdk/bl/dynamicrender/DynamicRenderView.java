package com.jd.ad.sdk.bl.dynamicrender;

import XIXIX.OOXIXo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_ep.jad_iv;
import com.jd.ad.sdk.jad_hu.jad_hu;
import com.jd.ad.sdk.jad_js.jad_jt;
import com.jd.ad.sdk.jad_js.jad_na;
import com.jd.ad.sdk.jad_js.jad_sf;
import com.jd.ad.sdk.jad_js.jad_uh;
import com.jd.ad.sdk.jad_kv.jad_ly;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.lottie.LottieAnimationView;
import com.jd.ad.sdk.multi.R;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes10.dex */
public class DynamicRenderView extends FrameLayout {
    public static final /* synthetic */ int jad_pa = 0;
    public double jad_an;
    public double jad_bo;
    public IDynamicRenderCallback jad_cn;
    public double jad_cp;
    public IDynamicCountdownListener jad_do;
    public double jad_dq;
    public int jad_ep;
    public double jad_er;
    public final CountDownLatch jad_fq;
    public boolean jad_fs;
    public boolean jad_gr;
    public Exception jad_hs;
    public ShakeListener jad_hu;
    public int jad_it;
    public String jad_iv;
    public int jad_jt;
    public float jad_ju;
    public double jad_jw;
    public float jad_kv;
    public double jad_kx;
    public float jad_lw;
    public String jad_ly;
    public float jad_mx;
    public double jad_mz;
    public double jad_na;
    public jad_dq jad_ny;
    public int jad_ob;
    public final Runnable jad_oz;
    public int jad_pc;
    public int jad_qd;
    public int jad_re;
    public LottieAnimationView jad_sf;
    public List<String> jad_tg;
    public List<String> jad_uh;
    public List<String> jad_vi;
    public final Map<String, com.jd.ad.sdk.jad_hu.jad_an> jad_wj;
    public String jad_xk;
    public final JSONObject jad_yl;
    public final Map<String, Bitmap> jad_zm;

    /* loaded from: classes10.dex */
    public interface IDynamicRenderCallback {
        void onAnimationEnd();

        void onDynamicRenderFailed(int i, String str);

        void onDynamicRenderSuccess(View view);

        void onFullLottieViewClick(Context context);
    }

    /* loaded from: classes10.dex */
    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicRenderView dynamicRenderView = DynamicRenderView.this;
            IDynamicCountdownListener iDynamicCountdownListener = dynamicRenderView.jad_do;
            if (iDynamicCountdownListener != null) {
                iDynamicCountdownListener.onAdCountdown(dynamicRenderView.jad_ep);
            }
            DynamicRenderView dynamicRenderView2 = DynamicRenderView.this;
            if (dynamicRenderView2.jad_fs) {
                dynamicRenderView2.jad_ep--;
            }
            if (dynamicRenderView2.jad_ep > 0) {
                dynamicRenderView2.postDelayed(dynamicRenderView2.jad_oz, 1000L);
            } else {
                dynamicRenderView2.removeCallbacks(dynamicRenderView2.jad_oz);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_bo extends com.jd.ad.sdk.jad_bm.jad_an<Bitmap> {
        public final /* synthetic */ jad_na jad_dq;
        public final /* synthetic */ Map jad_er;

        public jad_bo(jad_na jad_naVar, Map map) {
            this.jad_dq = jad_naVar;
            this.jad_er = map;
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@Nullable Drawable drawable) {
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_an, com.jd.ad.sdk.jad_bm.jad_er
        public void jad_cp(@Nullable Drawable drawable) {
            IDynamicRenderCallback iDynamicRenderCallback = DynamicRenderView.this.jad_cn;
            if (iDynamicRenderCallback != null) {
                JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
            }
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@NonNull Object obj, @Nullable com.jd.ad.sdk.jad_en.jad_bo jad_boVar) {
            jad_na jad_naVar = this.jad_dq;
            DynamicRenderView.this.jad_zm.put(this.jad_dq.jad_cp, jad_hu.jad_an((Bitmap) obj, jad_naVar.jad_an, jad_naVar.jad_bo));
            Map map = this.jad_er;
            if (map == null || map.size() != DynamicRenderView.this.jad_zm.size()) {
                return;
            }
            try {
                DynamicRenderView.this.jad_fq.await();
                DynamicRenderView dynamicRenderView = DynamicRenderView.this;
                IDynamicRenderCallback iDynamicRenderCallback = dynamicRenderView.jad_cn;
                if (iDynamicRenderCallback == null || !dynamicRenderView.jad_gr) {
                    return;
                }
                iDynamicRenderCallback.onDynamicRenderSuccess(dynamicRenderView);
            } catch (Exception e) {
                StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("loadImages error:");
                jad_an.append(Log.getStackTraceString(e));
                Logger.d(jad_an.toString());
                IDynamicRenderCallback iDynamicRenderCallback2 = DynamicRenderView.this.jad_cn;
                if (iDynamicRenderCallback2 != null) {
                    JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    iDynamicRenderCallback2.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_cp implements Runnable {
        public final /* synthetic */ DynamicRenderView jad_an;
        public final /* synthetic */ Context jad_bo;
        public final /* synthetic */ JSONObject jad_cp;
        public final /* synthetic */ String jad_dq;

        public jad_cp(DynamicRenderView dynamicRenderView, DynamicRenderView dynamicRenderView2, Context context, JSONObject jSONObject, String str) {
            this.jad_an = dynamicRenderView2;
            this.jad_bo = context;
            this.jad_cp = jSONObject;
            this.jad_dq = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DynamicRenderView dynamicRenderView = this.jad_an;
                if (dynamicRenderView != null) {
                    dynamicRenderView.jad_an(this.jad_bo, this.jad_cp, this.jad_dq);
                }
            } catch (Exception unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class jad_dq implements ActLifecycle.jad_an {
        public jad_dq() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            DynamicRenderView dynamicRenderView = DynamicRenderView.this;
            int i = DynamicRenderView.jad_pa;
            dynamicRenderView.jad_dq();
        }
    }

    /* loaded from: classes10.dex */
    public static class jad_er {
        public String jad_an;
        public float jad_bo;
        public float jad_cp;
        public List<String> jad_dq = new ArrayList();
        public List<String> jad_er = new ArrayList();
        public List<String> jad_fs = new ArrayList();
        public int jad_hu;
        public int jad_iv;
        public IDynamicRenderCallback jad_jt;
        public String jad_jw;
        public float jad_kx;
        public float jad_ly;
        public int jad_mz;
    }

    public DynamicRenderView(Context context, jad_er jad_erVar) {
        super(context);
        this.jad_an = 1.0d;
        this.jad_bo = 1.0d;
        this.jad_cp = 1.0d;
        this.jad_fs = true;
        this.jad_jt = 0;
        this.jad_tg = new ArrayList();
        this.jad_uh = new ArrayList();
        this.jad_vi = new ArrayList();
        this.jad_wj = new HashMap();
        this.jad_yl = new JSONObject();
        this.jad_zm = new HashMap();
        this.jad_gr = true;
        this.jad_hs = null;
        this.jad_it = 100;
        this.jad_ju = 0.0f;
        this.jad_kv = 1.0f;
        this.jad_lw = 0.0f;
        this.jad_mx = 0.0f;
        this.jad_oz = new jad_an();
        jad_bo();
        jad_an();
        this.jad_fq = new CountDownLatch(1);
        jad_an(jad_erVar, context);
        jad_an(context);
    }

    private void setCanvasWH(JSONObject jSONObject) {
        this.jad_dq = jSONObject.getInt(IAdInterListener.AdReqParam.WIDTH);
        this.jad_er = jSONObject.getInt(IAdInterListener.AdReqParam.HEIGHT);
    }

    private void setFixedLayerPosition(JSONArray jSONArray) {
        Double valueOf;
        Double valueOf2;
        double d = jSONArray.getDouble(0);
        double d2 = jSONArray.getDouble(1);
        double d3 = this.jad_dq;
        if (d > d3 / 2.0d) {
            double d4 = this.jad_an;
            valueOf = Double.valueOf((d * d4) - ((d4 - 1.0d) * d3));
        } else {
            valueOf = Double.valueOf(d * this.jad_an);
        }
        double d5 = this.jad_er;
        if (d2 > d5 / 2.0d) {
            double d6 = this.jad_bo;
            valueOf2 = Double.valueOf((d2 * d6) - ((d6 - 1.0d) * d5));
        } else {
            valueOf2 = Double.valueOf(d2 * this.jad_bo);
        }
        jSONArray.put(0, valueOf);
        jSONArray.put(1, valueOf2);
    }

    private void setTransformParams(JSONObject jSONObject) {
        setCanvasWH(jSONObject);
        int i = this.jad_pc;
        double d = this.jad_dq;
        if (d > OOXIXo.f3760XO && i > 0) {
            double d2 = this.jad_jw;
            if (d2 > OOXIXo.f3760XO) {
                double d3 = d / i;
                this.jad_an = (d / d3) / d2;
                this.jad_bo = (this.jad_er / d3) / this.jad_kx;
            }
        }
        double d4 = this.jad_kx;
        if (d4 > OOXIXo.f3760XO && d > OOXIXo.f3760XO) {
            double d5 = this.jad_er;
            if (d5 > OOXIXo.f3760XO) {
                this.jad_cp = (this.jad_jw / d4) / (d / d5);
            }
        }
    }

    public int getAdAnimationType() {
        return this.jad_jt;
    }

    public int getAdClickAreaValue() {
        return this.jad_it;
    }

    public Exception getLoadImagesException() {
        return this.jad_hs;
    }

    public LottieAnimationView getLottieView() {
        return this.jad_sf;
    }

    public final void jad_an() {
        com.jd.ad.sdk.jad_na.jad_an jad_an2 = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        if (jad_an2 == null) {
            return;
        }
        this.jad_ju = jad_an2.jad_cp;
        float f = jad_an2.jad_dq;
        this.jad_kv = f;
        this.jad_lw = jad_an2.jad_er;
        this.jad_mx = jad_an2.jad_fs;
        if (f <= 0.0f) {
            this.jad_kv = 1.0f;
        }
    }

    public final void jad_bo() {
        jad_dq jad_dqVar = new jad_dq();
        this.jad_ny = jad_dqVar;
        ActLifecycle.jad_bo.add(jad_dqVar);
    }

    public final void jad_cp() {
        if (this.jad_qd == CommonConstants.AdTriggerSourceType.CLICK.ordinal()) {
            if (this.jad_re == CommonConstants.ClickAreaType.FULL_SCREEN_CLICK.getTemplateId()) {
                this.jad_jt = 1;
                return;
            } else {
                this.jad_jt = 0;
                return;
            }
        }
        if (this.jad_qd == CommonConstants.AdTriggerSourceType.SHAKE.ordinal()) {
            this.jad_jt = 2;
        } else if (this.jad_qd == CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal()) {
            this.jad_jt = 3;
        }
    }

    public final void jad_dq() {
        ShakeListener shakeListener = this.jad_hu;
        if (shakeListener != null) {
            shakeListener.unregister();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.destroyDrawingCache();
            this.jad_sf = null;
        }
        jad_dq();
        jad_dq jad_dqVar = this.jad_ny;
        CopyOnWriteArrayList<ActLifecycle.jad_an> copyOnWriteArrayList = ActLifecycle.jad_bo;
        if (jad_dqVar != null) {
            copyOnWriteArrayList.remove(jad_dqVar);
        }
        this.jad_ny = null;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.jad_fs = z;
        if (!z) {
            removeCallbacks(this.jad_oz);
        } else if (this.jad_do != null && this.jad_ep > 0) {
            post(this.jad_oz);
        }
        if (this.jad_fs) {
            ShakeListener shakeListener = this.jad_hu;
            if (shakeListener != null) {
                shakeListener.register();
                return;
            }
            return;
        }
        jad_dq();
    }

    public void play() {
        LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.jad_dq();
        } else {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_PLAY_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
        }
    }

    public void startCount(@NonNull IDynamicCountdownListener iDynamicCountdownListener) {
        if (iDynamicCountdownListener == null) {
            return;
        }
        this.jad_do = iDynamicCountdownListener;
        int i = this.jad_ep;
        if (i < 1 || i > 30) {
            this.jad_ep = 5;
        }
        Runnable runnable = this.jad_oz;
        if (runnable != null) {
            post(runnable);
        }
    }

    public static boolean jad_an(DynamicRenderView dynamicRenderView, Context context, int i, int i2, int i3, int i4, int i5) {
        dynamicRenderView.getClass();
        int i6 = i4 - i2;
        float abs = Math.abs(i3 - i);
        float f = i5;
        return abs > ScreenUtils.dip2px(context, f) || ((float) Math.abs(i6)) > ScreenUtils.dip2px(context, f);
    }

    public void jad_an(String str, com.jd.ad.sdk.jad_hu.jad_an jad_anVar) {
        try {
            JSONObject optJSONObject = this.jad_yl.optJSONObject(str);
            if (optJSONObject == null) {
                Logger.d("动态化渲染不阻断问题：" + str + "不存在");
                return;
            }
            int i = optJSONObject.getInt(MapBundleKey.MapObjKey.OBJ_SL_INDEX);
            Rect rect = (Rect) optJSONObject.get("rect");
            jad_anVar.jad_cp = i;
            jad_anVar.jad_bo = rect;
            this.jad_wj.put(str, jad_anVar);
            if (str.equals(this.jad_xk)) {
                int width = rect.width();
                int height = rect.height();
                int i2 = (int) (this.jad_jw * this.jad_kx);
                if (i2 > 0) {
                    this.jad_it = ((width * height) * 100) / i2;
                }
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_ADD_EVENT_ERROR;
            sb.append(jad_anVar2.jad_an);
            sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb.append(jad_anVar2.jad_an(new String[0]));
            throw new Exception(sb.toString(), e);
        }
    }

    public void jad_an(Context context, JSONObject jSONObject, String str) {
        try {
            Map<String, jad_na> jad_an2 = jad_an(jSONObject, str);
            if (jad_an2 != null && !jad_an2.isEmpty()) {
                Iterator<String> it = jad_an2.keySet().iterator();
                while (it.hasNext()) {
                    jad_na jad_naVar = jad_an2.get(it.next());
                    if (jad_naVar == null) {
                        IDynamicRenderCallback iDynamicRenderCallback = this.jad_cn;
                        if (iDynamicRenderCallback != null) {
                            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                            iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
                            return;
                        }
                        return;
                    }
                    com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(context).jad_er().jad_an(jad_ly.jad_bo).jad_an(jad_naVar.jad_dq).jad_an((jad_iv) new jad_bo(jad_naVar, jad_an2));
                }
                return;
            }
            this.jad_fq.await();
            IDynamicRenderCallback iDynamicRenderCallback2 = this.jad_cn;
            if (iDynamicRenderCallback2 == null || !this.jad_gr) {
                return;
            }
            iDynamicRenderCallback2.onDynamicRenderSuccess(this);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOAD_IMAGES_ERROR;
            sb.append(jad_anVar.jad_an);
            sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb.append(jad_anVar.jad_an(new String[0]));
            this.jad_hs = new Exception(sb.toString(), e);
        }
    }

    public final void jad_an(Context context) {
        LottieAnimationView lottieAnimationView;
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.jad_dynamic_render_layout, (ViewGroup) null);
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) inflate.findViewById(R.id.animation_view);
            this.jad_sf = lottieAnimationView2;
            lottieAnimationView2.setCacheComposition(false);
            addView(inflate);
            try {
                String jad_an2 = jad_an(jad_an(context, this.jad_iv, this.jad_ly, this.jad_ob, this));
                Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
                com.jd.ad.sdk.jad_zi.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_zi.jad_iv(com.jd.ad.sdk.jad_zi.jad_er.jad_an(new ByteArrayInputStream(jad_an2.getBytes())));
                String[] strArr = com.jd.ad.sdk.jad_ud.jad_cp.jad_er;
                jad_sf<jad_jt> jad_an3 = com.jd.ad.sdk.jad_js.jad_hu.jad_an((com.jd.ad.sdk.jad_ud.jad_cp) new com.jd.ad.sdk.jad_ud.jad_fs(jad_ivVar), (String) null, true);
                Throwable th = jad_an3.jad_bo;
                if (th == null) {
                    jad_jt jad_jtVar = jad_an3.jad_an;
                    if (jad_jtVar != null) {
                        this.jad_sf.setComposition(jad_jtVar);
                        LottieAnimationView lottieAnimationView3 = this.jad_sf;
                        if (lottieAnimationView3 != null) {
                            lottieAnimationView3.setOnTouchListener(new com.jd.ad.sdk.jad_hu.jad_iv(this, context));
                            this.jad_sf.setOnClickListener(new com.jd.ad.sdk.bl.dynamicrender.jad_bo(this, context));
                        }
                        LottieAnimationView lottieAnimationView4 = this.jad_sf;
                        if (lottieAnimationView4 != null) {
                            try {
                                lottieAnimationView4.setFontAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_er());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        LottieAnimationView lottieAnimationView5 = this.jad_sf;
                        Map<String, Bitmap> map2 = this.jad_zm;
                        if (lottieAnimationView5 != null && context != null) {
                            lottieAnimationView5.setImageAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_jt(map2, context));
                        }
                        LottieAnimationView lottieAnimationView6 = this.jad_sf;
                        if (lottieAnimationView6 != null && context != null) {
                            lottieAnimationView6.jad_er.jad_cp.jad_bo.add(new com.jd.ad.sdk.bl.dynamicrender.jad_an(this, context));
                        }
                        double d = this.jad_kx;
                        if (d > OOXIXo.f3760XO) {
                            double d2 = this.jad_er;
                            if (d2 > OOXIXo.f3760XO && this.jad_jw / d != this.jad_dq / d2 && (lottieAnimationView = this.jad_sf) != null) {
                                lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        int i = (int) this.jad_jw;
                        int i2 = (int) this.jad_kx;
                        if (layoutParams == null) {
                            layoutParams = new FrameLayout.LayoutParams(i, i2);
                        } else {
                            layoutParams.height = i2;
                            layoutParams.width = i;
                        }
                        setLayoutParams(layoutParams);
                        return;
                    }
                    StringBuilder sb = new StringBuilder();
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                    sb.append(jad_anVar.jad_an);
                    sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                    sb.append(jad_anVar.jad_an(new String[0]));
                    throw new Exception(sb.toString());
                }
                StringBuilder sb2 = new StringBuilder();
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                sb2.append(jad_anVar2.jad_an);
                sb2.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                sb2.append(jad_anVar2.jad_an(new String[0]));
                throw new Exception(sb2.toString(), th);
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_VAR_REPLACE_ERROR;
                sb3.append(jad_anVar3.jad_an);
                sb3.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                sb3.append(jad_anVar3.jad_an(new String[0]));
                throw new Exception(sb3.toString(), e2);
            }
        } catch (Throwable th2) {
            try {
                this.jad_gr = false;
                StringBuilder sb4 = new StringBuilder();
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar4 = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_INIT_VIEW_OTHER_ERROR;
                sb4.append(jad_anVar4.jad_an);
                sb4.append(HelpFormatter.DEFAULT_OPT_PREFIX);
                sb4.append(jad_anVar4.jad_an(new String[0]));
                throw new Throwable(sb4.toString(), th2);
            } finally {
                this.jad_fq.countDown();
            }
        }
    }

    public String jad_an(Context context, String str, String str2, int i, DynamicRenderView dynamicRenderView) {
        JSONObject jSONObject = new JSONObject(str);
        WorkExecutor.execute(new jad_cp(this, dynamicRenderView, context, jSONObject, str2));
        int optInt = jSONObject.optInt("fr");
        if (i > 5) {
            JSONArray jSONArray = jSONObject.getJSONArray("layers");
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                String string = jSONObject2.getString("nm");
                int i3 = (i - 5) * optInt;
                if (string.equals("sdkStaticSkipButton")) {
                    jSONObject2.put("op", i3);
                }
                if (string.equals("sdkSkipButton")) {
                    jSONObject2.put("ip", i3);
                }
            }
            str = jSONObject.toString();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("countDownTemplate");
        if (optJSONObject != null) {
            String jSONObject3 = optJSONObject.toString();
            StringBuilder sb = new StringBuilder();
            int i4 = i <= 5 ? i : 5;
            for (int i5 = i4; i5 > 0; i5--) {
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
                int i6 = (i - i5) * optInt;
                jad_an2.append(i6);
                String replace = jSONObject3.replace("${startTime}", jad_an2.toString());
                StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
                jad_an3.append(i6 + optInt);
                String replaceAll = replace.replace("${endTime}", jad_an3.toString()).replaceAll("\\$\\{count\\}", "" + i5);
                if (i5 != i4) {
                    sb.append(",");
                }
                sb.append(replaceAll);
            }
            str = str.replace("\"${countDown}\"", sb.toString());
        }
        int i7 = i * optInt;
        return str.replace("${materialImage}", str2).replace("${totalTime}", "" + i7);
    }

    public final Map<String, jad_na> jad_an(JSONObject jSONObject, String str) {
        int length;
        JSONArray jSONArray = jSONObject.getJSONArray("assets");
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            String optString = optJSONObject.optString("p");
            String optString2 = optJSONObject.optString(t.i);
            String optString3 = optJSONObject.optString("id");
            int optInt = optJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
            int optInt2 = optJSONObject.optInt(IAdInterListener.AdReqParam.HEIGHT);
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(optString3, new jad_na(optInt, optInt2, optString3, optString.equals("${materialImage}") ? str : optString, optString2));
            }
        }
        return hashMap;
    }

    public static String jad_an(DynamicRenderView dynamicRenderView, int i, int i2) {
        Iterator<String> it = dynamicRenderView.jad_wj.keySet().iterator();
        com.jd.ad.sdk.jad_hu.jad_an jad_anVar = null;
        while (it.hasNext()) {
            com.jd.ad.sdk.jad_hu.jad_an jad_anVar2 = dynamicRenderView.jad_wj.get(it.next());
            if (jad_anVar2 != null && jad_anVar2.jad_bo.contains(i, i2) && (jad_anVar == null || jad_anVar.jad_cp > jad_anVar2.jad_cp)) {
                jad_anVar = jad_anVar2;
            }
        }
        if (jad_anVar == null) {
            return "";
        }
        return jad_anVar.jad_an;
    }

    public final String jad_an(String str) {
        String str2;
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        String str3;
        String str4 = t.f18411a;
        int i = 0;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jad_cp();
            setTransformParams(jSONObject2);
            JSONArray jSONArray3 = jSONObject2.getJSONArray("layers");
            JSONArray jSONArray4 = new JSONArray();
            int i2 = 0;
            while (i2 < jSONArray3.length()) {
                JSONObject jSONObject3 = jSONArray3.getJSONObject(i2);
                String str5 = (String) jSONObject3.get("nm");
                if (this.jad_vi.contains(str5)) {
                    str2 = str4;
                    jSONObject = jSONObject2;
                    jSONArray = jSONArray3;
                    jSONArray2 = jSONArray4;
                } else {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(MediationConstant.ADN_KS);
                    JSONArray jSONArray5 = jSONObject4.getJSONObject("p").getJSONArray(str4);
                    JSONArray jSONArray6 = jSONObject4.getJSONObject("s").getJSONArray(str4);
                    JSONArray jSONArray7 = jSONObject4.getJSONObject("a").getJSONArray(str4);
                    double d = jSONArray6.getDouble(i);
                    double d2 = jSONArray6.getDouble(1);
                    if (this.jad_tg.contains(str5)) {
                        jSONObject = jSONObject2;
                        jSONArray = jSONArray3;
                        jSONArray6.put(0, this.jad_an * d);
                        jSONArray6.put(1, this.jad_bo * d2);
                        setFixedLayerPosition(jSONArray5);
                    } else {
                        jSONObject = jSONObject2;
                        jSONArray = jSONArray3;
                    }
                    if (this.jad_uh.contains(str5)) {
                        jSONArray6.put(1, this.jad_cp * d2);
                        jSONArray2 = jSONArray4;
                        jSONArray5.put(1, Double.valueOf(jSONArray5.getDouble(1) - (jSONObject4.getJSONObject("a").getJSONArray(str4).getDouble(1) * (this.jad_cp - 1.0d))));
                    } else {
                        jSONArray2 = jSONArray4;
                    }
                    if ("sdkMaterialImage".equals(str5)) {
                        double d3 = this.jad_mz;
                        if (d3 != OOXIXo.f3760XO) {
                            String str6 = str4;
                            double d4 = this.jad_jw;
                            if (d4 != OOXIXo.f3760XO) {
                                str3 = str5;
                                str2 = str6;
                                double d5 = ((this.jad_kx / d4) / (this.jad_na / d3)) * d;
                                double d6 = 100.0d;
                                if (d5 < 100.0d) {
                                    double d7 = (100.0d / d5) * 100.0d;
                                    d5 = 100.0d;
                                    d6 = d7;
                                }
                                jSONArray6.put(0, d5);
                                jSONArray6.put(1, d6);
                            } else {
                                str3 = str5;
                                str2 = str6;
                            }
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put(MapBundleKey.MapObjKey.OBJ_SL_INDEX, i2);
                            jSONObject5.put("rect", jad_an(jSONArray5, jSONArray7, jSONObject3, jSONArray6));
                            this.jad_yl.put(str3, jSONObject5);
                            jSONArray2.put(jSONObject3);
                        }
                    }
                    str2 = str4;
                    str3 = str5;
                    JSONObject jSONObject52 = new JSONObject();
                    jSONObject52.put(MapBundleKey.MapObjKey.OBJ_SL_INDEX, i2);
                    jSONObject52.put("rect", jad_an(jSONArray5, jSONArray7, jSONObject3, jSONArray6));
                    this.jad_yl.put(str3, jSONObject52);
                    jSONArray2.put(jSONObject3);
                }
                i2++;
                jSONArray4 = jSONArray2;
                str4 = str2;
                jSONObject2 = jSONObject;
                jSONArray3 = jSONArray;
                i = 0;
            }
            JSONObject jSONObject6 = jSONObject2;
            jSONObject6.put("layers", jSONArray4);
            return jSONObject6.toString();
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_JSON_PARSE_ERROR;
            sb.append(jad_anVar.jad_an);
            sb.append(HelpFormatter.DEFAULT_OPT_PREFIX);
            sb.append(jad_anVar.jad_an(new String[0]));
            throw new Exception(sb.toString(), e);
        }
    }

    public final Rect jad_an(JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject, JSONArray jSONArray3) {
        Double valueOf;
        Double valueOf2;
        double d = this.jad_dq;
        double d2 = d > OOXIXo.f3760XO ? this.jad_jw / d : 1.0d;
        double d3 = this.jad_er;
        double d4 = d3 > OOXIXo.f3760XO ? this.jad_kx / d3 : 1.0d;
        if (jSONObject.getInt("ty") != 1) {
            valueOf = Double.valueOf(jSONObject.getDouble(IAdInterListener.AdReqParam.WIDTH));
            valueOf2 = Double.valueOf(jSONObject.getDouble(IAdInterListener.AdReqParam.HEIGHT));
        } else {
            valueOf = Double.valueOf(jSONObject.getDouble("sw"));
            valueOf2 = Double.valueOf(jSONObject.getDouble("sh"));
        }
        double d5 = jSONArray3.getDouble(0) / 100.0d;
        double d6 = jSONArray3.getDouble(1) / 100.0d;
        int i = (int) (((jSONArray.getDouble(0) - jSONArray2.getDouble(0)) - ((d5 - 1.0d) * (valueOf.doubleValue() / 2.0d))) * d2);
        int i2 = (int) (((jSONArray.getDouble(1) - jSONArray2.getDouble(1)) - ((d6 - 1.0d) * (valueOf2.doubleValue() / 2.0d))) * d4);
        return new Rect(i, i2, ((int) (valueOf.doubleValue() * d5 * d2)) + i, ((int) (valueOf2.doubleValue() * d6 * d4)) + i2);
    }

    public final void jad_an(jad_er jad_erVar, Context context) {
        this.jad_iv = jad_erVar.jad_an;
        this.jad_jw = jad_erVar.jad_bo;
        this.jad_kx = jad_erVar.jad_cp;
        this.jad_ly = jad_erVar.jad_jw;
        this.jad_mz = jad_erVar.jad_kx;
        this.jad_na = jad_erVar.jad_ly;
        int i = jad_erVar.jad_mz;
        this.jad_ob = i;
        this.jad_ep = i;
        this.jad_tg = jad_erVar.jad_dq;
        this.jad_uh = jad_erVar.jad_er;
        this.jad_vi = jad_erVar.jad_fs;
        this.jad_cn = jad_erVar.jad_jt;
        this.jad_pc = ScreenUtils.getPhoneWidth(context);
        this.jad_qd = jad_erVar.jad_hu;
        this.jad_re = jad_erVar.jad_iv;
    }
}
