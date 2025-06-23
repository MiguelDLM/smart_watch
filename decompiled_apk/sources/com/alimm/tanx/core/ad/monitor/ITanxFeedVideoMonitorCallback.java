package com.alimm.tanx.core.ad.monitor;

/* loaded from: classes.dex */
public interface ITanxFeedVideoMonitorCallback extends ITanxExposureCallback {
    void attach();

    void detached();

    void remove();

    void show();
}
