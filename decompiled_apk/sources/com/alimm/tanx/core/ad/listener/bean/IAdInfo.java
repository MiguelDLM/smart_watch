package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

/* loaded from: classes.dex */
public interface IAdInfo {
    int getAdCount();

    List<? extends IBidInfo> getBidInfoList();

    String getDecrypt();

    String getRequestId();

    List<? extends ISeatInfo> getSeatList();

    int getStatus();
}
