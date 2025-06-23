package com.alimm.tanx.core.ad.monitor;

public interface ITanxFeedVideoMonitorCallback extends ITanxExposureCallback {
    void attach();

    void detached();

    void remove();

    void show();
}
