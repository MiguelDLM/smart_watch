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

/* loaded from: classes.dex */
public class TanxAdView extends FrameLayout implements NotConfused {
    private long downTime;
    private ITanxAdMonitor mAdMonitor;
    private long upTime;

    public TanxAdView(Context context) {
        this(context, null);
    }

    private boolean checkClick() {
        if (OrangeManager.getInstance().getCommonSwitch("performClickCheckSwitch")) {
            if (this.downTime != 0 && System.currentTimeMillis() - this.upTime < 200) {
                return true;
            }
            return false;
        }
        LogUtils.d("TanxAdView", "不做校验");
        return true;
    }

    private void clearTime() {
        this.downTime = 0L;
        this.upTime = 0L;
    }

    public boolean allowSettingViewSize() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.downTime = System.currentTimeMillis();
        }
        if (motionEvent.getAction() == 1) {
            this.upTime = System.currentTimeMillis();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onVisibilityAggregated(z);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ITanxAdMonitor iTanxAdMonitor = this.mAdMonitor;
        if (iTanxAdMonitor != null) {
            iTanxAdMonitor.onWindowFocusChanged(z);
        }
    }

    @Override // android.view.View
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
        if (allowSettingViewSize()) {
            int dp2px = DimenUtil.dp2px(getContext(), iTanxAd.getAdSlot().getExpressViewWidth());
            if (dp2px > SysUtils.getScreenWidth(getContext())) {
                return SysUtils.getScreenWidth(getContext());
            }
            if (dp2px <= 0) {
                return View.MeasureSpec.getSize(i);
            }
            return dp2px;
        }
        return 0;
    }

    public TanxAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.downTime = 0L;
        this.upTime = 0L;
    }

    public TanxAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.downTime = 0L;
        this.upTime = 0L;
    }

    public TanxAdView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.downTime = 0L;
        this.upTime = 0L;
    }
}
