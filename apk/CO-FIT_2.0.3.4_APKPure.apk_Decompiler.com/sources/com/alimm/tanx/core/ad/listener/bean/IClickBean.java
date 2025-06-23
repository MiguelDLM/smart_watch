package com.alimm.tanx.core.ad.listener.bean;

public interface IClickBean {
    String getClickThroughUrl();

    String getDeepLinkUrl();

    boolean getInteractType(int i);

    Integer[] getInteractType();

    int getInteractType2Int();

    int getOpenType();
}
