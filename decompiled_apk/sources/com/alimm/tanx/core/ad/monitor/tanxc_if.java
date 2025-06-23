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

/* loaded from: classes.dex */
public class tanxc_if extends tanxc_do {
    private boolean tanxc_break;
    private float tanxc_catch;
    private int tanxc_class;
    private int tanxc_const;
    private long tanxc_this;
    private long tanxc_void;

    public tanxc_if(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback) {
        super(tanxAdView, iTanxExposureCallback, 2);
        OrangeUtBean orangeUtBean;
        FeedMonitorBean feedMonitorBean;
        this.tanxc_break = true;
        this.tanxc_catch = 0.2f;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean != null && (orangeUtBean = orangeBean.ut) != null && (feedMonitorBean = orangeUtBean.feedMonitor) != null) {
            this.tanxc_catch = feedMonitorBean.getMinRatio();
        }
    }

    private void tanxc_long() {
        if (!TanxMonitorUt.isOpenFeedMonitor()) {
            return;
        }
        if ((!this.tanxc_for || !this.tanxc_int || !this.tanxc_new || this.tanxc_goto.width() <= 0 || this.tanxc_goto.height() <= 0) && this.tanxc_this != 0 && this.tanxc_break) {
            this.tanxc_break = false;
            this.tanxc_void = SystemClock.elapsedRealtime() - this.tanxc_this;
            this.tanxc_this = 0L;
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

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tanxc_long();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean onPreDraw = super.onPreDraw();
        if (Math.abs(this.tanxc_goto.height()) > this.tanxc_do.getHeight() * this.tanxc_catch && Math.abs(this.tanxc_goto.width()) > this.tanxc_do.getWidth() * this.tanxc_catch && this.tanxc_this == 0) {
            this.tanxc_this = SystemClock.elapsedRealtime();
        }
        this.tanxc_class = this.tanxc_do.getWidth();
        this.tanxc_const = this.tanxc_do.getHeight();
        return onPreDraw;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            this.tanxc_break = true;
        } else {
            tanxc_long();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.tanxc_break = true;
        } else {
            tanxc_long();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_try() {
        super.tanxc_try();
    }
}
