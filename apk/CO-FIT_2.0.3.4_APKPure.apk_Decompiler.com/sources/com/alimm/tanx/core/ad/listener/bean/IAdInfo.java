package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

public interface IAdInfo {
    int getAdCount();

    List<? extends IBidInfo> getBidInfoList();

    String getDecrypt();

    String getRequestId();

    List<? extends ISeatInfo> getSeatList();

    int getStatus();
}
