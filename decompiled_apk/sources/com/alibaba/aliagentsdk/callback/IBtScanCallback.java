package com.alibaba.aliagentsdk.callback;

import android.bluetooth.le.ScanResult;
import java.util.List;

/* loaded from: classes.dex */
public interface IBtScanCallback {
    void onError(String str, int i);

    void onScanResultUpdate(List<ScanResult> list);
}
