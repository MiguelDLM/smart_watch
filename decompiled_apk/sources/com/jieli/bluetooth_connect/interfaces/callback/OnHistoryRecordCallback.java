package com.jieli.bluetooth_connect.interfaces.callback;

import com.jieli.bluetooth_connect.bean.history.HistoryRecord;

/* loaded from: classes10.dex */
public interface OnHistoryRecordCallback {
    void onFailed(int code, String message);

    void onSuccess(HistoryRecord record);
}
