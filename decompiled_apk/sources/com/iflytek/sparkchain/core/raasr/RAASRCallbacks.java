package com.iflytek.sparkchain.core.raasr;

import com.iflytek.sparkchain.core.raasr.RAASR;

/* loaded from: classes10.dex */
public interface RAASRCallbacks {
    void onError(RAASR.RaAsrError raAsrError, Object obj);

    void onResult(RAASR.RaAsrResult raAsrResult, Object obj);
}
