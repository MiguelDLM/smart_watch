package com.alimm.tanx.core.ad.listener.bean;

public interface IBidInfo {
    String getAdSource();

    String getAdvLogo();

    long getBidPrice();

    IClickBean getClickBean();

    String getCreativeId();

    String getCreativeMd5();

    String getCreativeName();

    String getCreativePath();

    String getCreativeType();

    int getId();

    Integer[] getInteractType();

    int getInteractType2Int();

    boolean getInteractType2Shake();

    IMaterialBean getMaterialBean();

    IMonitorBean getMonitorBean();

    int getOpenType();

    long getReleaseEndTime();

    long getReleaseStartTime();

    String getSessionId();

    String getTemplateId();
}
