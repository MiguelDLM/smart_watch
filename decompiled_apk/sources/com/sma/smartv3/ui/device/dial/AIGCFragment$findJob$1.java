package com.sma.smartv3.ui.device.dial;

import android.os.Handler;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.sma.smartv3.co_fit.R;
import com.sma.smartv3.model.JobDetail;

/* loaded from: classes12.dex */
public final class AIGCFragment$findJob$1 implements xxxI.II0xO0<JobDetail> {

    /* renamed from: oIX0oI, reason: collision with root package name */
    public final /* synthetic */ AIGCFragment f22135oIX0oI;

    public AIGCFragment$findJob$1(AIGCFragment aIGCFragment) {
        this.f22135oIX0oI = aIGCFragment;
    }

    public static final void I0Io(AIGCFragment this$0) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(this$0, "this$0");
        this$0.setFindJobNumber(this$0.getFindJobNumber() + 1);
        if (this$0.getFindJobNumber() >= 20) {
            this$0.dismissLoadPopup();
            ToastUtils.showLong(R.string.request_error);
        } else {
            String mJobId = this$0.getMJobId();
            kotlin.jvm.internal.IIX0o.oO(mJobId, "<get-mJobId>(...)");
            this$0.findJob(mJobId);
        }
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO JobDetail jobDetail) {
        LogUtils.d("findJobNumber = " + this.f22135oIX0oI.getFindJobNumber() + " findJob -> " + jobDetail);
        if (jobDetail != null) {
            int jobStatus = jobDetail.getJobStatus();
            if (jobStatus == 2) {
                this.f22135oIX0oI.dismissLoadPopup();
                ToastUtils.showLong(jobDetail.getJobErrCode() + " = " + jobDetail.getJobErrMsg(), new Object[0]);
                return;
            }
            if (jobStatus != 3) {
                Handler handler = new Handler();
                final AIGCFragment aIGCFragment = this.f22135oIX0oI;
                handler.postDelayed(new Runnable() { // from class: com.sma.smartv3.ui.device.dial.II0XooXoX
                    @Override // java.lang.Runnable
                    public final void run() {
                        AIGCFragment$findJob$1.I0Io(AIGCFragment.this);
                    }
                }, 3000L);
                return;
            }
            this.f22135oIX0oI.showPics(jobDetail.getImages(), jobDetail.getImageSign());
        }
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        kotlin.jvm.internal.IIX0o.x0xO0oo(error, "error");
        LogUtils.d("findJob -> error = " + error);
        this.f22135oIX0oI.dismissLoadPopup();
        ToastUtils.showLong(error, new Object[0]);
    }
}
