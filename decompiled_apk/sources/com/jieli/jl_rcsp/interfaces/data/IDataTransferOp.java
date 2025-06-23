package com.jieli.jl_rcsp.interfaces.data;

import com.jieli.jl_rcsp.interfaces.OnOperationCallback;
import com.jieli.jl_rcsp.model.data.DataParams;
import com.jieli.jl_rcsp.model.data.SendParams;

/* loaded from: classes8.dex */
public interface IDataTransferOp {
    void addListener(OnDataTransferListener onDataTransferListener);

    void cancelDataTransfer(OnOperationCallback<Boolean> onOperationCallback);

    boolean isDataTransfer();

    void readLargeData(DataParams dataParams, OnDataEventCallback onDataEventCallback);

    void removeListener(OnDataTransferListener onDataTransferListener);

    void sendLargeData(SendParams sendParams, OnDataEventCallback onDataEventCallback);
}
