package com.realsil.sdk.dfu.batch;

import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;

/* loaded from: classes11.dex */
public abstract class BatchDfuCallback {
    public void onError(String str, int i) {
    }

    public void onProgressChanged(String str, DfuProgressInfo dfuProgressInfo) {
    }

    public void onStateChanged(String str, int i, Throughput throughput) {
    }
}
