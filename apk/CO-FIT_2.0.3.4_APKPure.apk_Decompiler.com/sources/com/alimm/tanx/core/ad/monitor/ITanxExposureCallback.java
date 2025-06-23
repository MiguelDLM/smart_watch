package com.alimm.tanx.core.ad.monitor;

import java.util.Map;

public interface ITanxExposureCallback {
    void exposure();

    void exposureTime(long j);

    void onMonitor(Map<String, Object> map);
}
