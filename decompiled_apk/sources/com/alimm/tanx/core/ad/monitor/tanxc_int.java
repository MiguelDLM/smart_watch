package com.alimm.tanx.core.ad.monitor;

import com.alimm.tanx.core.ad.view.TanxAdView;

/* loaded from: classes.dex */
public class tanxc_int extends tanxc_do {
    public tanxc_int(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i, String str) {
        super(tanxAdView, iTanxExposureCallback, i, str);
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_do() {
        this.tanxc_char = 0L;
        this.tanxc_case = 0.5f;
    }
}
