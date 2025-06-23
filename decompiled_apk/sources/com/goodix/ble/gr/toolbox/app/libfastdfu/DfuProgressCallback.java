package com.goodix.ble.gr.toolbox.app.libfastdfu;

/* loaded from: classes9.dex */
public interface DfuProgressCallback {
    void onDfuComplete();

    void onDfuError(String str, Error error);

    void onDfuProgress(int i);

    void onDfuStart();
}
