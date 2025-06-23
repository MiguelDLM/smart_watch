package com.alimm.tanx.core.ad.monitor;

import com.alimm.tanx.core.ad.view.TanxAdView;

public class tanxc_try extends tanxc_do {
    public tanxc_try(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i) {
        super(tanxAdView, iTanxExposureCallback, i);
    }

    public void tanxc_do() {
        this.tanxc_char = 0;
        this.tanxc_case = 0.5f;
    }
}
