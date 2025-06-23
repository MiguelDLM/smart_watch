package com.alimm.tanx.core.common;

import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: classes.dex */
public class AdTask implements Runnable {
    private Runnable tanxc_do;
    private onErrorListener tanxc_for;
    private String tanxc_if;

    /* loaded from: classes.dex */
    public interface onErrorListener {
        void onError(String str);
    }

    public AdTask(Runnable runnable, String str) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.tanxc_do.run();
        } catch (Exception e) {
            e.printStackTrace();
            onErrorListener onerrorlistener = this.tanxc_for;
            if (onerrorlistener != null) {
                onerrorlistener.onError(e.getMessage());
            }
            LogUtils.e("AdTask", e, "AdTask");
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "AdTask", LogUtils.getStackTraceMessage(e), "AdTask");
        }
    }

    public AdTask(Runnable runnable, String str, onErrorListener onerrorlistener) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
        this.tanxc_for = onerrorlistener;
    }
}
