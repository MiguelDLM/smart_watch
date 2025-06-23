package com.alimm.tanx.core.ad.monitor;

public interface ITanxAdMonitor {
    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onVisibilityAggregated(boolean z);

    void onWindowFocusChanged(boolean z);
}
