package com.alimm.tanx.core.ad.listener;

import android.view.View;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: classes.dex */
public abstract class ViewClickListener implements View.OnClickListener, NotConfused {
    private long lastClickTime = 0;
    private final long clickInterval = 500;
    private final String TAG = "ViewClickListener";

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (System.currentTimeMillis() - this.lastClickTime > 500) {
                this.lastClickTime = System.currentTimeMillis();
                viewClick(view);
            } else {
                LogUtils.d("ViewClickListener", "点击过快");
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("ViewClickListener", e.getMessage());
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "ViewClickListener", LogUtils.getStackTraceMessage(e), "");
        }
    }

    public abstract void viewClick(View view);
}
