package com.alimm.tanx.core.ad;

import com.alimm.tanx.core.ad.bean.TanxBiddingInfo;

public interface ITanxAdBidding {
    TanxBiddingInfo getBiddingInfo();

    void setBiddingResult(TanxBiddingInfo tanxBiddingInfo);
}
