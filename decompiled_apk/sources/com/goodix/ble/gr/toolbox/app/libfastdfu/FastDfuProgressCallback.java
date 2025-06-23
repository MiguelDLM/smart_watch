package com.goodix.ble.gr.toolbox.app.libfastdfu;

/* loaded from: classes9.dex */
public interface FastDfuProgressCallback {
    void onDfuComplete();

    void onDfuErase(int i);

    void onDfuError(int i, String str, Error error);

    void onDfuProgress(int i);

    void onDfuStart();
}
