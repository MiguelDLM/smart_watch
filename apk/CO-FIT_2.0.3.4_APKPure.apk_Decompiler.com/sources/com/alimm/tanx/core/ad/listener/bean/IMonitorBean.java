package com.alimm.tanx.core.ad.listener.bean;

import java.util.List;

public interface IMonitorBean {
    List<String> getClickTrackUrl();

    List<? extends ITrackItem> getEventTrack();

    List<String> getImpTrackUrl();

    String getWinNoticeUrl();
}
