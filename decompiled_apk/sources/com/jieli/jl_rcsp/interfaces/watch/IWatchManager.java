package com.jieli.jl_rcsp.interfaces.watch;

import com.jieli.jl_fatfs.model.FatFile;
import com.jieli.jl_rcsp.interfaces.rcsp.IRcspOp;

/* loaded from: classes8.dex */
public interface IWatchManager extends IWatchOp {
    void destroy();

    OnWatchCallback getCallback();

    IRcspOp getRcspOp();

    FatFile getWatchFileByPath(String str);

    void init();

    boolean isInit();

    boolean isSysException();

    void sendWriteProtectFlag(boolean z, OnWatchOpCallback<Boolean> onWatchOpCallback);
}
