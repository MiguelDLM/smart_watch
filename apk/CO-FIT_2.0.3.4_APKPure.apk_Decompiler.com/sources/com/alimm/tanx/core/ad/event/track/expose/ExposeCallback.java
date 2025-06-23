package com.alimm.tanx.core.ad.event.track.expose;

public interface ExposeCallback {
    void onFail(int i, String str, String str2);

    void onSucceed(int i, String str);

    void send(String str);
}
