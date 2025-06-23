package com.sma.smartv3.biz;

import android.os.Handler;
import com.sma.smartv3.model.JobDetail;
import kotlin.jvm.internal.IIX0o;

/* loaded from: classes12.dex */
public final class AIWatchFaceManager$findJob$1 implements xxxI.II0xO0<JobDetail> {
    public static final void I0Io() {
        String str;
        AIWatchFaceManager aIWatchFaceManager = AIWatchFaceManager.f19897oIX0oI;
        if (aIWatchFaceManager.oO()) {
            str = AIWatchFaceManager.f19895X0o0xo;
            IIX0o.oO(str, "access$getMJobId$p(...)");
            aIWatchFaceManager.oOoXoXO(str);
        }
    }

    @Override // xxxI.II0xO0
    /* renamed from: II0xO0, reason: merged with bridge method [inline-methods] */
    public void handleResponse(@OXOo.oOoXoXO JobDetail jobDetail) {
        OI0.oIX0oI oix0oi = OI0.oIX0oI.f1507oIX0oI;
        StringBuilder sb = new StringBuilder();
        sb.append(AIWatchFaceManager.f19893II0xO0);
        sb.append(" findJob -> ");
        AIWatchFaceManager aIWatchFaceManager = AIWatchFaceManager.f19897oIX0oI;
        sb.append(aIWatchFaceManager.oO());
        sb.append(", ");
        sb.append(jobDetail);
        oix0oi.oIX0oI(sb.toString());
        if (jobDetail != null && aIWatchFaceManager.oO()) {
            int jobStatus = jobDetail.getJobStatus();
            if (jobStatus != 2) {
                if (jobStatus != 3) {
                    new Handler().postDelayed(new Runnable() { // from class: com.sma.smartv3.biz.XO
                        @Override // java.lang.Runnable
                        public final void run() {
                            AIWatchFaceManager$findJob$1.I0Io();
                        }
                    }, 3000L);
                    return;
                } else {
                    aIWatchFaceManager.OOXIXo(jobDetail.getImages(), jobDetail.getImageSign());
                    return;
                }
            }
            AIWatchFaceManager.Oo(aIWatchFaceManager, null, 1, null);
        }
    }

    @Override // xxxI.II0xO0
    public void handleError(@OXOo.OOXIXo String error) {
        IIX0o.x0xO0oo(error, "error");
        OI0.oIX0oI.f1507oIX0oI.oIX0oI(AIWatchFaceManager.f19893II0xO0 + " findJob -> error = " + error);
        AIWatchFaceManager.Oo(AIWatchFaceManager.f19897oIX0oI, null, 1, null);
    }
}
