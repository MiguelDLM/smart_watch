package com.alimm.tanx.core.ad.monitor;

import android.os.SystemClock;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.FeedMonitorBean;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;

/* loaded from: classes.dex */
public class tanxc_for extends tanxc_do {
    private long tanxc_break;
    private long tanxc_catch;
    private boolean tanxc_class;
    private float tanxc_const;
    private int tanxc_final;
    private int tanxc_float;
    protected boolean tanxc_this;
    ITanxFeedVideoMonitorCallback tanxc_void;

    public tanxc_for(TanxAdView tanxAdView, ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback) {
        super(tanxAdView, iTanxFeedVideoMonitorCallback, 2);
        OrangeUtBean orangeUtBean;
        FeedMonitorBean feedMonitorBean;
        this.tanxc_class = true;
        this.tanxc_const = 0.2f;
        this.tanxc_this = false;
        this.tanxc_void = iTanxFeedVideoMonitorCallback;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean != null && (orangeUtBean = orangeBean.ut) != null && (feedMonitorBean = orangeUtBean.feedMonitor) != null) {
            this.tanxc_const = feedMonitorBean.getMinRatio();
        }
    }

    private void tanxc_long() {
        if (!TanxMonitorUt.isOpenFeedMonitor()) {
            return;
        }
        if ((!this.tanxc_for || !this.tanxc_int || !this.tanxc_new || this.tanxc_goto.width() <= 0 || this.tanxc_goto.height() <= 0) && this.tanxc_break != 0 && this.tanxc_class) {
            this.tanxc_class = false;
            this.tanxc_catch = SystemClock.elapsedRealtime() - this.tanxc_break;
            this.tanxc_break = 0L;
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.tanxc_void.attach();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tanxc_long();
        this.tanxc_this = false;
        this.tanxc_void.detached();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean onPreDraw = super.onPreDraw();
        if (Math.abs(this.tanxc_goto.height()) > this.tanxc_do.getHeight() * this.tanxc_const && Math.abs(this.tanxc_goto.width()) > this.tanxc_do.getWidth() * this.tanxc_const && this.tanxc_break == 0) {
            this.tanxc_break = SystemClock.elapsedRealtime();
        }
        this.tanxc_final = this.tanxc_do.getWidth();
        this.tanxc_float = this.tanxc_do.getHeight();
        return onPreDraw;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        if (z) {
            this.tanxc_class = true;
        } else {
            tanxc_long();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.tanxc_class = true;
        } else {
            tanxc_long();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_for() {
        super.tanxc_for();
        if (this.tanxc_for && this.tanxc_int && this.tanxc_new && !this.tanxc_this) {
            this.tanxc_void.show();
            this.tanxc_this = true;
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
        if (this.tanxc_for && this.tanxc_this) {
            this.tanxc_void.remove();
            this.tanxc_this = false;
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_try() {
        super.tanxc_try();
    }
}
