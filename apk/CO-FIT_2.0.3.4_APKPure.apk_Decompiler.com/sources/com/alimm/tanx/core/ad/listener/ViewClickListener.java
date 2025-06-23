package com.alimm.tanx.core.ad.listener;

import android.view.View;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

public abstract class ViewClickListener implements View.OnClickListener, NotConfused {
    private final String TAG = "ViewClickListener";
    private final long clickInterval = 500;
    private long lastClickTime = 0;

    public void onClick(View view) {
        try {
            if (System.currentTimeMillis() - this.lastClickTime > 500) {
                this.lastClickTime = System.currentTimeMillis();
                viewClick(view);
                return;
            }
            LogUtils.d("ViewClickListener", "点击过快");
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("ViewClickListener", e.getMessage());
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "ViewClickListener", LogUtils.getStackTraceMessage(e), "");
        }
    }

    public abstract void viewClick(View view);
}
