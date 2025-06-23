package com.alimm.tanx.core.ad.monitor;

import android.os.SystemClock;
import android.util.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.orange.bean.SplashMonitorBean;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tanxc_new extends tanxc_do {
    private long tanxc_break;
    private long tanxc_catch;
    private long tanxc_class;
    private float tanxc_const;
    private long tanxc_final;
    private float tanxc_this = 0.2f;
    private final List<Map<String, Object>> tanxc_void = new ArrayList();

    public tanxc_new(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback) {
        super(tanxAdView, iTanxExposureCallback, 1);
        OrangeUtBean orangeUtBean;
        SplashMonitorBean splashMonitorBean;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean != null && (orangeUtBean = orangeBean.ut) != null && (splashMonitorBean = orangeUtBean.splashMonitor) != null) {
            this.tanxc_this = splashMonitorBean.getCoverRatio();
        }
    }

    private Map<String, Object> tanxc_if(float f) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        arrayMap.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, Integer.valueOf(this.tanxc_do.getWidth()));
        arrayMap.put("height", Integer.valueOf(this.tanxc_do.getHeight()));
        arrayMap.put("cover_percent", Float.valueOf(f));
        return arrayMap;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tanxc_if != null && TanxMonitorUt.isOpenSplashMonitor()) {
            HashMap hashMap = new HashMap();
            hashMap.put("monitors", JSON.toJSONString(this.tanxc_void));
            hashMap.put("total_time", String.valueOf(this.tanxc_class));
            hashMap.put("exposure_time", String.valueOf(this.tanxc_catch));
            this.tanxc_if.onMonitor(hashMap);
        }
    }

    public boolean onPreDraw() {
        return super.onPreDraw();
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z) {
            tanxc_do(1.0f);
        }
    }

    public void tanxc_do() {
        this.tanxc_char = 0;
        this.tanxc_case = 0.5f;
    }

    public void tanxc_for() {
        super.tanxc_for();
        float tanxc_else = tanxc_else();
        if (this.tanxc_int) {
            tanxc_do(tanxc_else);
        }
    }

    public void tanxc_new() {
        super.tanxc_new();
    }

    private void tanxc_do(float f) {
        if (TanxMonitorUt.isOpenSplashMonitor()) {
            if (this.tanxc_void.size() <= 0) {
                this.tanxc_const = f;
                this.tanxc_break = SystemClock.elapsedRealtime();
                this.tanxc_void.add(tanxc_if(f));
            } else {
                List<Map<String, Object>> list = this.tanxc_void;
                Map map = list.get(list.size() - 1);
                if (!(map == null || map.get("cover_percent") == null)) {
                    this.tanxc_const = ((Float) map.get("cover_percent")).floatValue();
                }
                if (((double) Math.abs(f - this.tanxc_const)) > 0.05d) {
                    this.tanxc_void.add(tanxc_if(f));
                }
            }
            if (this.tanxc_final == 0) {
                this.tanxc_final = SystemClock.elapsedRealtime();
            }
            float f2 = this.tanxc_const;
            float f3 = this.tanxc_this;
            if (f2 < f3 && f < f3) {
                this.tanxc_catch += SystemClock.elapsedRealtime() - this.tanxc_final;
            }
            this.tanxc_final = SystemClock.elapsedRealtime();
            this.tanxc_const = f;
            this.tanxc_class = SystemClock.elapsedRealtime() - this.tanxc_break;
        }
    }
}
