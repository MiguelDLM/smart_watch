package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

public interface ISeatInfo {
    List<? extends IBidInfo> getIBidList();

    int getId();

    List<String> getRawBidList();
}
