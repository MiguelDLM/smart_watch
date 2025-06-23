package com.alimm.tanx.core.ad.monitor;

import android.os.SystemClock;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.FeedMonitorBean;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashMap;

public class tanxc_if extends tanxc_do {
    private boolean tanxc_break = true;
    private float tanxc_catch = 0.2f;
    private int tanxc_class;
    private int tanxc_const;
    private long tanxc_this;
    private long tanxc_void;

    public tanxc_if(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback) {
        super(tanxAdView, iTanxExposureCallback, 2);
        OrangeUtBean orangeUtBean;
        FeedMonitorBean feedMonitorBean;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean != null && (orangeUtBean = orangeBean.ut) != null && (feedMonitorBean = orangeUtBean.feedMonitor) != null) {
            this.tanxc_catch = feedMonitorBean.getMinRatio();
        }
    }

    private void tanxc_long() {
        if (TanxMonitorUt.isOpenFeedMonitor()) {
            if ((!this.tanxc_for || !this.tanxc_int || !this.tanxc_new || this.tanxc_goto.width() <= 0 || this.tanxc_goto.height() <= 0) && this.tanxc_this != 0 && this.tanxc_break) {
                this.tanxc_break = false;
                this.tanxc_void = SystemClock.elapsedRealtime() - this.tanxc_this;
                this.tanxc_this = 0;
                if (this.tanxc_if != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("exposure_time", String.valueOf(this.tanxc_void));
                    hashMap.put("min_ratio", String.valueOf(this.tanxc_catch));
                    hashMap.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, String.valueOf(this.tanxc_class));
                    hashMap.put("height", String.valueOf(this.tanxc_const));
                    this.tanxc_if.onMonitor(hashMap);
                }
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tanxc_long();
    }

    public boolean onPreDraw() {
        boolean onPreDraw = super.onPreDraw();
        if (((float) Math.abs(this.tanxc_goto.height())) > ((float) this.tanxc_do.getHeight()) * this.tanxc_catch && ((float) Math.abs(this.tanxc_goto.width())) > ((float) this.tanxc_do.getWidth()) * this.tanxc_catch && this.tanxc_this == 0) {
            this.tanxc_this = SystemClock.elapsedRealtime();
        }
        this.tanxc_class = this.tanxc_do.getWidth();
        this.tanxc_const = this.tanxc_do.getHeight();
        return onPreDraw;
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            this.tanxc_break = true;
        } else {
            tanxc_long();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.tanxc_break = true;
        } else {
            tanxc_long();
        }
    }

    public void tanxc_new() {
        super.tanxc_new();
    }

    public void tanxc_try() {
        super.tanxc_try();
    }
}
