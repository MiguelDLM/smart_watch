package com.alimm.tanx.core.ad.monitor;

import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;

public class TanxAdMonitor$1 extends TanxCountDownTimer {
    final /* synthetic */ tanxc_do this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TanxAdMonitor$1(tanxc_do tanxc_do, long j, long j2) {
        super(j, j2);
        this.this$0 = tanxc_do;
    }

    public void onFinish() {
        LogUtils.d("TanxAdMonitor", "initTimer - onFinish");
    }

    public void onTick(long j) {
        LogUtils.d("TanxAdMonitor", "initTimer  onTick exposureCompleted: " + this.this$0.tanxc_byte + " isOnExposure: " + this.this$0.tanxc_try);
        if (this.this$0.tanxc_byte) {
            this.this$0.tanxc_break();
        } else if (this.this$0.tanxc_try) {
            this.this$0.onPreDraw();
        }
    }
}
