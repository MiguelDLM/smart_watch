package com.alimm.tanx.core.ad.base;

import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;

public class BaseWebViewUtil$4 extends TanxCountDownTimer {
    final /* synthetic */ tanxc_if this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseWebViewUtil$4(tanxc_if tanxc_if, long j, long j2) {
        super(j, j2);
        this.this$0 = tanxc_if;
    }

    public void onFinish() {
        LogUtils.d("BaseWebViewUtil", "startTimer - onFinish");
        boolean unused = this.this$0.tanxc_goto = false;
        tanxc_if.tanxc_new(this.this$0);
        this.this$0.tanxc_new();
    }

    public void onTick(long j) {
        int round = Math.round(((float) j) / 1000.0f);
        LogUtils.d("BaseWebViewUtil", "startTimer" + round + "");
    }
}
