package com.jieli.jl_bt_ota.interfaces.rcsp;

import com.jieli.jl_bt_ota.interfaces.IActionCallback;
import com.jieli.jl_bt_ota.model.FileOffset;
import com.jieli.jl_bt_ota.model.response.TargetInfoResponse;

/* loaded from: classes10.dex */
public interface IRcspOTA {
    void changeCommunicationWay(int i, int i2, IActionCallback<Integer> iActionCallback);

    void enterUpdateMode(IActionCallback<Integer> iActionCallback);

    void exitUpdateMode(IActionCallback<Integer> iActionCallback);

    void getDeviceInfo(IActionCallback<TargetInfoResponse> iActionCallback);

    void getMD5(IActionCallback<String> iActionCallback);

    void inquiryDeviceCanOTA(byte[] bArr, IActionCallback<Integer> iActionCallback);

    void queryUpdateResult(IActionCallback<Integer> iActionCallback);

    void readUpgradeFileFlag(IActionCallback<FileOffset> iActionCallback);

    void rebootDevice(IActionCallback<Boolean> iActionCallback);

    void stopADVInfo(IActionCallback<Boolean> iActionCallback);
}
