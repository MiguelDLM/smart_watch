package com.alimm.tanx.core.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.monitor.ITanxAdMonitor;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.SysUtils;

public class TanxAdView extends FrameLayout implements NotConfused {
    private long downTime;
    private ITanxAdMonitor mAdMonitor;
    private long upTime;

    public TanxAdView(Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean checkClick() {
        if (!OrangeManager.getInstance().getCommonSwitch("performClickCheckSwitch")) {
            LogUtils.d("TanxAdView", "不做校验");
            return true;
        } else if (this.downTime == 0 || System.currentTimeMillis() - this.upTime >= 200) {
            return false;
        } else {
            return true;
        }
    }

    private void clearTime() {
        this.downTime = 0;
        this.upTime = 0;
    }

    public boolean allowSettingViewSize() {
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.downTime = System.currentTimeMillis();
        }
        if (motionEvent.getAction() == 1) {
            this.upTime = System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onAttachedToWindow();
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onDetachedFromWindow();
        }
    }

    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onVisibilityAggregated(z);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onWindowFocusChanged(z);
        }
    }

    public boolean performClick() {
        boolean z;
        if (checkClick()) {
            z = super.performClick();
        } else {
            z = false;
        }
        clearTime();
        return z;
    }

    public void setAdMonitor(ITanxAdMonitor iTanxAdMonitor) {
        this.mAdMonitor = iTanxAdMonitor;
    }

    public int setViewSize(ITanxAd iTanxAd, int i) {
        if (!allowSettingViewSize()) {
            return 0;
        }
        int dp2px = DimenUtil.dp2px(getContext(), (float) iTanxAd.getAdSlot().getExpressViewWidth());
        if (dp2px > SysUtils.getScreenWidth(getContext())) {
            return SysUtils.getScreenWidth(getContext());
        }
        if (dp2px <= 0) {
            return View.MeasureSpec.getSize(i);
        }
        return dp2px;
    }

    public TanxAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downTime = 0;
        this.upTime = 0;
    }

    public TanxAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.downTime = 0;
        this.upTime = 0;
    }

    public TanxAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.downTime = 0;
        this.upTime = 0;
    }
}
