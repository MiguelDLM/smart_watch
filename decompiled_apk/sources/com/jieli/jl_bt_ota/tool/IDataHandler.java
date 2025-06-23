package com.jieli.jl_bt_ota.tool;

import com.jieli.jl_bt_ota.model.DataInfo;

/* loaded from: classes10.dex */
public interface IDataHandler {
    void addRecvData(DataInfo dataInfo);

    void addSendData(DataInfo dataInfo);

    void release();
}
