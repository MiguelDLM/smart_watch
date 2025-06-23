package com.alimm.tanx.core.orange.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: classes.dex */
public class FeedMonitorBean extends BaseBean {
    public String minRatio;

    public float getMinRatio() {
        try {
            return Float.parseFloat(this.minRatio);
        } catch (Exception unused) {
            return 0.0f;
        }
    }
}
