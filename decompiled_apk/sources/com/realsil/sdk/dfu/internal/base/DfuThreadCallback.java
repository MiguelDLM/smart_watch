package com.realsil.sdk.dfu.internal.base;

import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;

/* loaded from: classes11.dex */
public abstract class DfuThreadCallback {
    public void onError(int i) {
    }

    public void onProgressChanged(DfuProgressInfo dfuProgressInfo) {
    }

    public void onStateChanged(int i, Throughput throughput) {
    }
}
