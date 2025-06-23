package com.jieli.jl_rcsp.interfaces.nfc;

import com.jieli.jl_rcsp.model.base.BaseError;
import com.jieli.jl_rcsp.model.device.NfcMsg;
import java.util.List;

/* loaded from: classes8.dex */
public interface OnSyncNfcMsgListener {
    void onError(BaseError baseError);

    void onFinish(List<NfcMsg> list);

    void onStart();
}
