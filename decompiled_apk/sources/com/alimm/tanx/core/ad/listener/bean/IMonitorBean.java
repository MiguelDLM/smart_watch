package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

/* loaded from: classes.dex */
public interface IMonitorBean {
    List<String> getClickTrackUrl();

    List<? extends ITrackItem> getEventTrack();

    List<String> getImpTrackUrl();

    String getWinNoticeUrl();
}
