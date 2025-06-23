package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

/* loaded from: classes.dex */
public interface ISeatInfo {
    List<? extends IBidInfo> getIBidList();

    int getId();

    List<String> getRawBidList();
}
